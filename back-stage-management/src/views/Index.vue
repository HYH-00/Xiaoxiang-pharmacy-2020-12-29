<template>
	<el-container>
		<el-header>
			<Top ref="topchild" @menuSelect="menuSelect_" v-bind:adminInfo="adminInfo"></Top>
		</el-header>
		<el-container>
			<el-aside style="width: auto;">
				<Side @SideSelect="SideSelect_"></Side>
			</el-aside>
			<el-main>
				<component ref="mainchild" :is="comName" :discountGoods="discountGoods" :OrderData="OrderData"></component>
			</el-main>

			<el-drawer size="60%" title="商品添加" :before-close="handleClose" :visible.sync="addproduct" direction="ltr"
			 custom-class="demo-drawer" ref="drawer">
				<div class="demo-drawer__content">
					<el-form ref="form" :model="addform" label-width="80px">
						<el-row :gutter="0" style="text-align: center;">
							<el-upload class="upload-demo" drag limit="1" :on-success="handlesuccess" action="http://localhost:8080/shop/fileupload"
							 multiple ref='upload' :file-list="addproductimgList">
								<i class="el-icon-upload"></i>
								<div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
								<div class="el-upload__tip" slot="tip">只能上传jpg/png文件，且不超过500kb</div>
							</el-upload>
						</el-row>
						<el-row :gutter="5">
							<el-col :span="8">
								<el-form-item label="批准文号">
									<el-input v-model="addform.shopId" style="width: 200px;"></el-input>
								</el-form-item>
							</el-col>
							<el-col :span="8">
								<el-form-item label="价格">
									<el-input v-model="addform.price" style="width: 200px;"></el-input>
								</el-form-item>
							</el-col>
							<el-col :span="8">
								<el-form-item label="商品名称">
									<el-input v-model="addform.name" style="width: 200px;"></el-input>
								</el-form-item>
							</el-col>
						</el-row>
						<el-row :gutter="5">
							<el-col :span="23">
								<el-form-item label="描述">
									<el-input type="textarea" v-model="addform.description"></el-input>
								</el-form-item>
							</el-col>
						</el-row>
						<el-row :gutter="5">
							<el-col :span="8">
								<el-form-item label="库存量">
									<el-input v-model="addform.number" style="width: 200px;"></el-input>
								</el-form-item>
							</el-col>
							<el-col :span="8">
								<el-form-item label="商标">
									<el-input v-model="addform.trademark" style="width: 200px;"></el-input>
								</el-form-item>
							</el-col>
							<el-col :span="8">
								<el-form-item label="有效期">
									<el-input v-model="addform.validPeriod" style="width: 200px;"></el-input>
								</el-form-item>
							</el-col>

						</el-row>
						<el-row :gutter="5">
							<!-- 							<el-col :span="8">
								<el-form-item label="折扣">
									<el-input v-model="addform.discount" style="width: 200px;"></el-input>
								</el-form-item>
							</el-col>
							<el-col :span="8">
								<el-form-item label="折扣期限">
									<el-input v-model="addform.time" style="width: 200px;"></el-input>
								</el-form-item>
							</el-col> -->
							<el-col :span="8">
								<el-form-item label="包装规格">
									<el-input v-model="addform.packingSpecification" style="width: 200px;"></el-input>
								</el-form-item>
							</el-col>
							<el-col :span="8">
								<el-form-item label="制造商">
									<el-input v-model="addform.manufacturer" style="width: 200px;"></el-input>
								</el-form-item>
							</el-col>
							<el-col :span="8">
								<el-form-item label="医药类别">
									<el-input v-model="addform.type" style="width: 200px;"></el-input>
								</el-form-item>
							</el-col>
						</el-row>
					</el-form>
					<div class="demo-drawer__footer" style="float: right;margin-right: 40px;">
						<el-button @click="initaddproductfrom">重 置</el-button>
						<el-button @click="cancelForm">取 消</el-button>
						<el-button type="primary" @click="$refs.drawer.closeDrawer()" :loading="loading">{{ loading ? '提交中 ...' : '确 定' }}</el-button>
					</div>
				</div>
			</el-drawer>
			<el-dialog title="商品查询" :visible.sync="queryproduct" width="30%" :before-close="queryproducthandleClose">
				<el-form style="text-align: center;" ref="form" :model="queryproductform" label-width="80px">
					<el-form-item style="width: 300px;margin-left: 50px;" label="查询规则">
						<el-select v-model="queryproductform.select" placeholder="请选择">
							<el-option v-for="item in queryproductoptions" :key="item.value" :label="item.label" :value="item.value"></el-option>
						</el-select>
					</el-form-item>
					<el-form-item style="width: 300px;margin-left: 50px;" label="查询键值">
						<el-input v-model="queryproductform.value"></el-input>
					</el-form-item>
				</el-form>
				</el-form>
				<span slot="footer" class="dialog-footer">
					<el-button @click="initqueryproductfrom">重 置</el-button>
					<el-button @click="queryproductNo">取 消</el-button>
					<el-button type="primary" @click="queryproductYes">确 定</el-button>
				</span>
			</el-dialog>
			<el-dialog title="订单查询" :visible.sync="queryorder" width="30%" :before-close="queryorderhandleClose">
				<el-form style="text-align: center;" ref="form" :model="queryorderform" label-width="80px">
					<el-form-item style="width: 300px;margin-left: 50px;" label="查询规则">
						<el-select v-model="queryorderform.select" placeholder="请选择">
							<el-option v-for="item in queryorderoptions" :key="item.value" :label="item.label" :value="item.value"></el-option>
						</el-select>
					</el-form-item>
					<el-form-item style="width: 300px;margin-left: 50px;" label="查询键值">
						<el-input v-model="queryorderform.value"></el-input>
					</el-form-item>
				</el-form>
				</el-form>
				<span slot="footer" class="dialog-footer">
					<el-button @click="initqueryorderfrom">重 置</el-button>
					<el-button @click="queryorderNo">取 消</el-button>
					<el-button type="primary" @click="queryorderYes">确 定</el-button>
				</span>
			</el-dialog>
			<el-dialog title="密码重置" :visible.sync="queryorder" width="30%" :before-close="queryorderhandleClose">
				<el-form style="text-align: center;" ref="form" :model="rasswordresetfrom" label-width="80px">
					<el-form-item style="width: 300px;margin-left: 50px;" label="重置的用户ID">
						<el-input v-model="rasswordresetfrom.value"></el-input>
					</el-form-item>
				</el-form>
				</el-form>
				<span slot="footer" class="dialog-footer">
					<el-button @click="initqueryorderfrom">重 置</el-button>
					<el-button @click="queryorderNo">取 消</el-button>
					<el-button type="primary" @click="queryorderYes">确 定</el-button>
				</span>
			</el-dialog>
		</el-container>
	</el-container>
</template>

<script>
	import Top from '../components/Top.vue'
	import Main from '../components/Main.vue'
	import Side from '../components/Side.vue'
	import Product from '../components/Product.vue'
	import Order from '../components/Order.vue'
	import Message from '../components/Message.vue'
	import User from '../components/User.vue'
	import OrderData from '../components/OrderData.vue'
	export default {
		data() {
			return {
				adminInfo: {
					// adminId: this.$route.params.userId,
					// adminPwd: this.$route.params.userPassword,
					// adminNick: this.$route.params.userNickName
					adminId: '',
					adminPwd: '',
					adminNick: '',
					select: '处理中心'
				},
				// info: '11',
				// info:{
				// 	key:'',
				// 	value:''
				// },
				discountGoods: [],
				OrderData:[],
				comName: 'Main',
				addproduct: false,
				queryproduct: false,
				queryorder: false,
				loading: false,
				addproductimgList: [],
				addform: {
					imgurl: '',
					shopId: '',
					price: '',
					name: '',
					description: '',
					number: '',
					trademark: '',
					validPeriod: '',
					packingSpecification: '',
					manufacturer: '',
					discount: '',
					time: '',
					type: ''
				},
				queryproductoptions: [{
					value: '按名称查询',
					label: '按名称查询'
				}, {
					value: '按批准文号查询',
					label: '按批准文号查询'
				}, {
					value: '按类别查询',
					label: '按类别查询'
				}, {
					value: '按商标查询',
					label: '按商标查询'
				}],
				queryproductform: {
					select: '按名称查询',
					value: ''
				},
				queryorderoptions: [{
					value: '按用户编号查询',
					label: '按用户编号查询'
				}, {
					value: '按订单编号查询',
					label: '按订单编号查询'
				}, {
					value: '按状态查询',
					label: '按状态查询'
				}],
				queryorderform: {
					select: '按用户编号查询',
					value: ''
				},
				rasswordresetfrom:{
					value:''
				}
			};
		},
		mounted() {
			this.get();
			this.getallDiscountGoods();
			this.getallOrder();
		},
		methods: {
			get() {
				this.adminInfo.adminId = sessionStorage.getItem("adminId");
				this.adminInfo.adminPwd = sessionStorage.getItem("adminPwd");
				this.adminInfo.adminNick = sessionStorage.getItem("adminNick");
			},
			menuSelect_(data) {
				if (data == "处理中心") this.comName = "Main";
				else if (data == "商品总览") this.comName = "Product";
				else if (data == "消息中心") this.comName = "Message";
				else if (data == "订单管理") this.comName = "Order";
				else if (data == "用户管理") this.comName = "User";
			},
			SideSelect_(data) {
				if (data == "订单数据") this.comName = "OrderData";
				else if (data == "商品添加") this.addproduct = true;
				else if (data == "商品查询") this.queryproduct = true;
				else if (data == "订单查询") this.queryorder = true;
				
				else if (data == "密码重置") this.queryorder = true;
				else if (data == "用户查询") this.queryorder = true;
				
			},
			handleClose(done) {
				if (this.loading) {
					return;
				}
				var that = this;
				if (this.judgeaddproductfrom()) {
					return;
				}
				this.$confirm('确定要提交表单吗？')
					.then(function() {
						that.loading = true;
						that.timer = setTimeout(() => {
							done();
							// that.$alert(that.shopId)

							that.$axios.post("http://localhost:8080/shop/insertGoods", {
								shopId: that.addform.shopId,
								price: that.addform.price,
								name: that.addform.name,
								description: that.addform.description,
								picture: that.addform.imgurl,
								number: that.addform.number,
								trademark: that.addform.trademark,
								validPeriod: that.addform.validPeriod,
								packingSpecification: that.addform.packingSpecification,
								manufacturer: that.addform.manufacturer,
								type: that.addform.type

							}).then(function(res) {
								console.log(res);
								that.initaddproductfrom();
							}).catch(function(err) {
								console.log(err)
							})

							// 动画关闭需要一定的时间
							setTimeout(() => {
								that.loading = false;
							}, 300);
						}, 800);
					})
					.catch(function() {});
			},
			initaddproductfrom() {
				this.addform.imgurl = '',
					this.addform.shopId = '',
					this.addform.price = '',
					this.addform.name = '',
					this.addform.description = '',
					this.addform.number = '',
					this.addform.trademark = '',
					this.addform.validPeriod = '',
					this.addform.packingSpecification = '',
					this.addform.manufacturer = '',
					this.addform.type = '',
					this.$refs.upload.clearFiles();
			},
			cancelForm() {
				// this.loading = false;
				this.addproduct = false;
				clearTimeout(this.timer);
			},
			handlesuccess(response, file, fileList) {
				// console.log("success")
				console.log(response)
				console.log(file)
				console.log(fileList)
				this.addform.imgurl = response.data
			},
			judgeaddproductfrom() {
				if (this.addform.imgurl == '') {
					this.$message('图片未上传');
					return true;
				}
				if (this.addform.shopId == '') {
					this.$message('请填写批准文号');
					return true;
				}
				if (this.addform.price == '') {
					this.$message('请填写价格');
					return true;
				}
				if (this.addform.name == '') {
					this.$message('请填写商品名');
					return true;
				}
				if (this.addform.description == '') {
					this.$message('请填写描述');
					return true;
				}
				if (this.addform.number == '') {
					this.$message('请填写商品数量');
					return true;
				}
				if (this.addform.trademark == '') {
					this.$message('请填写商标');
					return true;
				}
				if (this.addform.validPeriod == '') {
					this.$message('请填写有效期');
					return true;
				}
				if (this.addform.packingSpecification == '') {
					this.$message('请填写包装规格');
					return true;
				}
				if (this.addform.manufacturer == '') {
					this.$message('请填写制造商');
					return true;
				}
				if (this.addform.type == '') {
					this.$message('请填写商品类型');
					return true;
				}
			},
			initqueryproductfrom() {
				this.queryproductform.select = "按名称查询"
				this.queryproductform.value = ""
			},
			queryproductNo() {
				this.queryproduct = false
			},
			queryproductYes() {
				sessionStorage.setItem("queryproductkey", this.queryproductform.select)
				sessionStorage.setItem("queryproductvalue", this.queryproductform.value)
				this.adminInfo.select = "商品总览"

				this.getallDiscountGoods();
				this.comName = "Product"
				this.queryproduct = false
				this.initqueryproductfrom();
			},
			initqueryorderfrom() {
				this.queryorderform.select = "按用户编号查询"
				this.queryorderform.value = ""
			},
			queryorderNo() {
				this.queryorder = false
			},
			queryorderYes() {
				// alert("1");
				sessionStorage.setItem("queryorderkey", this.queryorderform.select)
				sessionStorage.setItem("queryordervalue", this.queryorderform.value)
				this.adminInfo.select="订单管理";
				// alert("2");
				this.comName = "Order"
				this.queryorder = false
				this.getallOrder();
				// alert(this.queryorder);
				this.initqueryorderfrom();
			},
			getallDiscountGoods() {
				var queryproductkey = sessionStorage.getItem("queryproductkey")
				var queryproductvalue = sessionStorage.getItem("queryproductvalue")
				// sessionStorage.removeItem("queryproductkey")
				// sessionStorage.removeItem("queryproductvalue")
				var queryurl = "http://localhost:8080/shop/findAllGoods"
				if (queryproductkey == "按名称查询") {
					queryurl = "http://localhost:8080/shop/findLikeGoodsByName/" + queryproductvalue;
				} else if (queryproductkey == "按批准文号查询") {
					queryurl = "http://localhost:8080/shop/findLikeGoodsByShopId/" + queryproductvalue;
				} else if (queryproductkey == "按类别查询") {
					queryurl = "http://localhost:8080/shop/findLikeGoodsByType/" + queryproductvalue;
				} else if (queryproductkey == "按商标查询") {
					queryurl = "http://localhost:8080/shop/findLikeGoodsByTrademark/" + queryproductvalue;
				}
				if(queryproductvalue=="")queryurl = "http://localhost:8080/shop/findAllGoods"
				var that = this;
				// alert(queryurl)
				this.$axios.post(queryurl)
					.then(function(res) {
						console.log(res);
						that.discountGoods = res.data;
					}).catch(function(err) {
						console.log(err);
					})
			},
			getallOrder() {
				var queryorderkey = sessionStorage.getItem("queryorderkey")
				var queryordervalue = sessionStorage.getItem("queryordervalue")
				// sessionStorage.removeItem("queryproductkey")
				// sessionStorage.removeItem("queryproductvalue")
				var posturl = "http://localhost:8080/shop/findAllOrder";
				// alert(posturl)
				if (queryorderkey == "按用户编号查询") {
					posturl = "http://localhost:8080/shop/findLikeOrderByUserId/" + queryordervalue;
				} else if (queryorderkey == "按订单编号查询") {
					posturl = "http://localhost:8080/shop/findLikeOrderByShopId/" + queryordervalue;
				} else if (queryorderkey == "按状态查询") {
					posturl = "http://localhost:8080/shop/findLikeOrderByCancel/" + queryordervalue;
				}
				// alert(posturl+"2")
				if (queryordervalue == "") posturl = "http://localhost:8080/shop/findAllOrder";
				// alert(posturl)
				var that = this;
				this.$axios.post(posturl)
					.then(function(res) {
						console.log(res);
						that.OrderData = res.data;
					}).catch(function(err) {
						console.log(err);
					})
			}

		},
		components: {
			Top,
			Main,
			Side,
			Product,
			Order,
			Message,
			User,
			OrderData
		}
	}
</script>

<style>
	* {
		margin: 0;
		padding: 0;
	}

	html,
	body {
		height: 100%;
	}

	.box {
		height: 100%;
		background-color: blue;
	}


	/* .el-menu-vertical-demo:not(.el-menu--collapse) {
		width: 200px;
		min-height: 200px;
	} */

	.el-header {
		/* background-color: #B3C0D1; */
		color: #333;
		text-align: center;
		/* line-height: 60px; */
	}

	.el-aside {
		/* background-color: #D3DCE6; */
		color: #333;
		text-align: center;
		/* line-height: 200px; */
	}

	.el-main {
		/* background-color: #E9EEF3; */
		color: #333;
		text-align: center;
		line-height: 40px;
	}

	body>.el-container {
		margin-bottom: 40px;
	}

	.el-container:nth-child(5) .el-aside,
	.el-container:nth-child(6) .el-aside {
		line-height: 260px;
	}

	.el-container:nth-child(7) .el-aside {
		line-height: 320px;
	}
</style>
