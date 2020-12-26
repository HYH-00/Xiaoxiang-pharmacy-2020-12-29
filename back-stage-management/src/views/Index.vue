<template>
	<el-container>
		<el-header>
			<Top @menuSelect="menuSelect_" v-bind:adminInfo="adminInfo"></Top>
		</el-header>
		<el-container>
			<el-aside style="width: auto;">
				<Side @SideSelect="SideSelect_"></Side>
			</el-aside>
			<el-main>
				<component :is="comName" v-bind:userinfo="userinfo"></component>
			</el-main>
			<el-drawer size="60%" title="商品添加" :before-close="handleClose" :visible.sync="addproduct" direction="ltr"
			custom-class="demo-drawer" ref="drawer">
				<div class="demo-drawer__content">
					<el-form ref="form" :model="addform" label-width="80px">
						<el-row :gutter="0" style="text-align: center;">
							<el-upload class="upload-demo" drag limit="2" :on-success="handlesuccess" action="http://localhost:8081/springboot/fileupload"
							multiple>
								<i class="el-icon-upload"></i>
								<div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
								<div class="el-upload__tip" slot="tip">只能上传jpg/png文件，且不超过500kb</div>
							</el-upload>
							<img :src="addform.imgurl" />
							<p>{{addform.imgurl}}</p>
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
							<el-col :span="8">
								<el-form-item label="描述">
									<el-input v-model="addform.description" style="width: 200px;"></el-input>
								</el-form-item>
							</el-col>
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
						</el-row>
						<el-row :gutter="5">
							<el-col :span="8">
								<el-form-item label="有效期">
									<el-input v-model="addform.validPeriod" style="width: 200px;"></el-input>
								</el-form-item>
							</el-col>
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
						</el-row>
						<el-row :gutter="5">
							<el-col :span="8">
								<el-form-item label="折扣">
									<el-input v-model="addform.discount" style="width: 200px;"></el-input>
								</el-form-item>
							</el-col>
							<el-col :span="8">
								<el-form-item label="折扣期限">
									<el-input v-model="addform.time" style="width: 200px;"></el-input>
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
						<el-button @click="cancelForm">取 消</el-button>
						<el-button type="primary" @click="$refs.drawer.closeDrawer()" :loading="loading">{{ loading ? '提交中 ...' : '确 定' }}</el-button>
					</div>
				</div>
			</el-drawer>
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
					adminNick: ''
				},
				comName: 'Main',
				addproduct: false,
				addform: {
					imgurl:'',
					shopId:'',
					price:'',
					name:'',
					description:'',
					number:'',
					trademark:'',
					validPeriod:'',
					packingSpecification:'',
					manufacturer:'',
					discount:'',
					time:'',
					type:''
				}
			};
		},
		mounted() {
			this.get();
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
				else if (data == "商品添加") {
					this.addproduct = true;
				} else if (data == "商品查询") {
					this.addproduct = true;
				}
			},
			handleClose(done) {
				if (this.loading) {
					return;
				}
				done();
				// this.$confirm('确定要提交表单吗？')
				// 	.then(function() {
				// 		this.loading = true;
				// 		this.timer = setTimeout(() => {
				// 			done();
				// 			// 动画关闭需要一定的时间
				// 			setTimeout(() => {
				// 				this.loading = false;
				// 			}, 400);
				// 		}, 2000);
				// 	})
				// 	.catch(function() {});
			},
			cancelForm() {
				// this.loading = false;
				this.addproduct = false;
				clearTimeout(this.timer);
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
		line-height: 160px;
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
