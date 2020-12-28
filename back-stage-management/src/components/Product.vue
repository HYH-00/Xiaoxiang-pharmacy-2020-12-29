<template>
	<div id="app">
		<el-table :data="discountGoods" :row-class-name="tableRowClassName" style="width: 100%;padding: 0px;" height="630">
			<el-table-column fixed prop="shopId" label="批准文号" width="95"></el-table-column>
			<el-table-column prop="picture" label="物品图片" width="170">
				<template slot-scope="scope">
					<el-popover placement="top-start" trigger="hover">
						<img slot="reference" :src="scope.row.picture" style="width: 150px;height: 110px">
						<img :src="scope.row.picture" alt="" style="width:300px;height: 300px">
					</el-popover>
				</template>
				<!-- <template slot-scope="scope">
					<img style="border-radius: 20px;height: 200px;width: 200px;" :src="scope.row.picture"></img>
				</template> -->
			</el-table-column>
			<el-table-column prop="price" label="价格" width="60"></el-table-column>
			<el-table-column prop="name" label="商品名称" width="160"></el-table-column>
			<!-- <el-table-column prop="description" label="描述" width="60"></el-table-column> -->
			<el-table-column prop="number" label="库存量" width="70"></el-table-column>
			<el-table-column prop="trademark" label="商标" width="80"></el-table-column>
			<el-table-column prop="validPeriod" label="有效期" width="80"></el-table-column>
			<el-table-column prop="packingSpecification" label="包装规格" width="100"></el-table-column>
			<el-table-column prop="manufacturer" label="制造商" width="100"></el-table-column>
			<!-- <el-table-column prop="discount" label="折扣" width="100"></el-table-column> -->
			<!-- <el-table-column prop="time" label="折扣过期时间" width="100"></el-table-column> -->
			<el-table-column prop="type" label="医药用品类别" width="110"></el-table-column>
			<el-table-column fixed="right" label="操作" width="160">
				<template slot-scope="scope">
					<el-button size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
					<el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
				</template>
			</el-table-column>
		</el-table>
		<el-drawer size="60%" title="商品编辑" :before-close="handleClose" :visible.sync="editproduct" direction="rtl"
		 custom-class="demo-drawer" ref="drawer">
			<div class="demo-drawer__content">
				<el-form ref="form" :model="editform" label-width="80px">
					<el-row :gutter="0" style="text-align: center;">
						<img :src="editform.picture" style="height: 200px;width: 200px;" />
						<!-- <el-upload class="upload-demo" drag limit="1" :on-success="handlesuccess" action="http://localhost:8080/shop/fileupload"
						 multiple ref='upload' :file-list="editproductimgList">
							<i class="el-icon-upload" style="height: 300px;"></i>
							<div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
							<div class="el-upload__tip" slot="tip">只能上传jpg/png文件，且不超过500kb</div>
						</el-upload> -->
					</el-row>
					<el-row :gutter="5">
						<el-col :span="8">
							<el-form-item label="批准文号">
								<el-input disabled="" v-model="editform.shopId" style="width: 200px;"></el-input>
							</el-form-item>
						</el-col>
						<el-col :span="8">
							<el-form-item label="价格">
								<el-input v-model="editform.price" style="width: 200px;"></el-input>
							</el-form-item>
						</el-col>
						<el-col :span="8">
							<el-form-item label="商品名称">
								<el-input v-model="editform.name" style="width: 200px;"></el-input>
							</el-form-item>
						</el-col>
					</el-row>
					<el-row :gutter="5">
						<el-col :span="23">
							<el-form-item label="描述">
								<el-input type="textarea" v-model="editform.description"></el-input>
							</el-form-item>
						</el-col>
					</el-row>
					<el-row :gutter="5">
						<el-col :span="8">
							<el-form-item label="库存量">
								<el-input v-model="editform.number" style="width: 200px;"></el-input>
							</el-form-item>
						</el-col>
						<el-col :span="8">
							<el-form-item label="商标">
								<el-input v-model="editform.trademark" style="width: 200px;"></el-input>
							</el-form-item>
						</el-col>
						<el-col :span="8">
							<el-form-item label="有效期">
								<el-input v-model="editform.validPeriod" style="width: 200px;"></el-input>
							</el-form-item>
						</el-col>

					</el-row>
					<el-row :gutter="5">
						<el-col :span="8">
							<el-form-item label="包装规格">
								<el-input v-model="editform.packingSpecification" style="width: 200px;"></el-input>
							</el-form-item>
						</el-col>
						<el-col :span="8">
							<el-form-item label="制造商">
								<el-input v-model="editform.manufacturer" style="width: 200px;"></el-input>
							</el-form-item>
						</el-col>
						<el-col :span="8">
							<el-form-item label="医药类别">
								<el-input v-model="editform.type" style="width: 200px;"></el-input>
							</el-form-item>
						</el-col>
					</el-row>
				</el-form>
				<div class="demo-drawer__footer" style="float: right;margin-right: 40px;">
					<!-- <el-button @click="initeditproductfrom">重 置</el-button> -->
					<el-button @click="cancelForm">取 消</el-button>
					<el-button type="primary" @click="$refs.drawer.closeDrawer()" :loading="loading">{{ loading ? '提交中 ...' : '确 定' }}</el-button>
				</div>
			</div>
		</el-drawer>
	</div>
</template>

<script>
	export default {
		props: ['discountGoods'],
		data() {
			return {
				// discountGoods: []
				editform: {
					picture: '',
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
				editproduct: false,
				loading: false,
				editproductimgList: ['']
			};
		},
		mounted() {
			this.getallDiscountGoods();
		},
		methods: {
			getallDiscountGoods() {
				var queryproductkey = sessionStorage.getItem("queryproductkey")
				var queryproductvalue = sessionStorage.getItem("queryproductvalue")
				sessionStorage.removeItem("queryproductkey")
				sessionStorage.removeItem("queryproductvalue")
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
				var that = this;
				// alert("pp  "+queryurl)
				this.$axios.post(queryurl)
					.then(function(res) {
						console.log(res);
						that.discountGoods = res.data;
					}).catch(function(err) {
						console.log(err);
					})
			},
			tableRowClassName({
				row,
				rowIndex
			}) {
				// if (row.cancel === "未到货") {
				// 	return 'warning-row';
				// } else {
				// 	return 'success-row';
				// }
				return '';
			},
			handleEdit(index, row) {
				console.log(index, row);
				this.editproduct = true;
				// alert(this.discountGoods[index].picture)
				this.editform = this.discountGoods[index]
			},
			handleDelete(index, row) {
				console.log(index, row);
				// alert(row.shopId)
				// this.discountGoods.splice(index,1);
				var that = this;
				this.$axios.post("http://localhost:8080/shop/deleteGoodPictureByShopId/" + row.shopId)
					.then(function(res) {
						console.log(res.data);
						if (res.data == 1) {
							that.$message("删除成功")
							// for(var i=0;i<this.discountGoods.length;++i){
							// 	if(index==i){

							// 	}
							// }
							that.discountGoods.splice(index, 1);
						} else that.$message("删除失败")
					}).catch(function(err) {
						console.log(err);
					})
			},
			initeditproductfrom() {
				// this.editform.picture = '',
				this.editform.shopId = ''
				this.editform.price = ''
				this.editform.name = ''
				this.editform.description = ''
				this.editform.number = ''
				this.editform.trademark = ''
				this.editform.validPeriod = ''
				this.editform.packingSpecification = ''
				this.editform.manufacturer = ''
				this.editform.type = ''
			},
			cancelForm(){
				this.editproduct=false;
			},
			handleClose(done) {
				if (this.loading) {
					return;
				}
				var that = this;
				// if (this.judgeaddproductfrom()) {
				// 	return;
				// }
				this.$confirm('确定要提交表单吗？')
					.then(function() {
						that.loading = true;
						that.timer = setTimeout(() => {
							done();			
							that.$axios.post("http://localhost:8080/shop/updateGoodsByShopId", {								
								shopId: that.editform.shopId,
								price: that.editform.price,
								name: that.editform.name,
								description: that.editform.description,
								picture: that.editform.picture,
								number: that.editform.number,
								trademark: that.editform.trademark,
								validPeriod: that.editform.validPeriod,
								packingSpecification: that.editform.packingSpecification,
								manufacturer: that.editform.manufacturer,
								type: that.editform.type,
							}).then(function(res) {
								console.log(res);
								that.initeditproductfrom();
								that.getallDiscountGoods();
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
		},
		components: {

		},
		watch: {
			info(newVal) {
				alert(newVal)
				// this.expandDetail = newVal;
				console.log(this.expandDetail);
			}
		},
	}
</script>

<style>
	.wraper {
		width: 100%;
		height: 82vh;
		overflow-x: hidden;
	}

	.back-top-container {
		position: absolute;
		top: 0;
		bottom: 0;
		left: 0;
		right: 0;
		overflow: auto;
	}

	/* ::-webkit-scrollbar {
		width: 0 !important;
	}

	::-webkit-scrollbar {
		width: 0 !important;
		height: 0;
	} */

	.el-row {
		margin-bottom: 20px;

		&:last-child {
			margin-bottom: 0;
		}
	}

	.el-col {
		border-radius: 4px;
	}

	.bg-purple-dark {
		background: #99a9bf;
	}

	.bg-purple {
		background: #d3dce6;
	}

	.bg-purple-light {
		background: #e5e9f2;
	}

	.grid-content {
		border-radius: 4px;
		min-height: 36px;
	}

	.row-bg {
		padding: 10px 0;
		background-color: #f9fafc;
	}

	.image {
		width: 100%;
		display: block;
	}

	.time {
		font-size: 13px;
		color: #999;
	}

	.bottom {
		margin-top: 13px;
		line-height: 12px;
	}

	.button {
		padding: 0;
		float: right;
	}

	.clearfix:before,
	.clearfix:after {
		display: table;
		content: "";
	}

	.clearfix:after {
		clear: both
	}
</style>
