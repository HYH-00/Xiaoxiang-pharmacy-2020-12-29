<template>
	<div>
		<el-table :data="OrderData" :row-class-name="tableRowClassName" style="width: 100%;padding: 0px;" height="630">
			<!-- <el-table-column fixed prop="key" label="订单编号" width="180"></el-table-column> -->
			<el-table-column prop="userid" label="用户编号" width="180"></el-table-column>
			<el-table-column prop="shopId" label="商品编号" width="160"></el-table-column>
			<el-table-column prop="shopnumber" label="数量" width="60"></el-table-column>
			<el-table-column prop="discount" label="折扣" width="60"></el-table-column>
			<el-table-column prop="address" label="地址" width="260"></el-table-column>
			<el-table-column prop="allprice" label="全价" width="60"></el-table-column>
			<el-table-column prop="time" label="时间" width="100"></el-table-column>
			<el-table-column prop="cancel" label="状态" width="100"></el-table-column>
			<el-table-column fixed="right" label="操作" width="180">
				<template slot-scope="scope">
					<el-button size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
					<el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
				</template>
			</el-table-column>
		</el-table>
		<el-drawer size="40%" title="订单编辑" :before-close="handleClose" :visible.sync="editorder" direction="rtl" custom-class="demo-drawer"
		 ref="drawer">
			<div class="demo-drawer__content">
				<el-form ref="form" :model="editform" label-width="80px">
					<el-row :gutter="5">
						<el-col :span="8">
							<el-form-item label="用户编号">
								<el-input disabled v-model="editform.userid" style="width: 200px;"></el-input>
							</el-form-item>
						</el-col>
						<el-col :span="8">
							<el-form-item label="商品编号">
								<el-input v-model="editform.shopId" style="width: 200px;"></el-input>
							</el-form-item>
						</el-col>
						<el-col :span="8">
							<el-form-item label="数量">
								<el-input v-model="editform.shopnumber" style="width: 200px;"></el-input>
							</el-form-item>
						</el-col>
					</el-row>
					<el-row :gutter="5">
						<el-col :span="23">
							<el-form-item label="折扣">
								<el-input type="textarea" v-model="editform.discount"></el-input>
							</el-form-item>
						</el-col>
					</el-row>
					<el-row :gutter="5">
						<el-col :span="8">
							<el-form-item label="地址">
								<el-input v-model="editform.address" style="width: 200px;"></el-input>
							</el-form-item>
						</el-col>
						<el-col :span="8">
							<el-form-item label="全价">
								<el-input v-model="editform.allprice" style="width: 200px;"></el-input>
							</el-form-item>
						</el-col>
						<el-col :span="8">
							<el-form-item label="时间">
								<el-input v-model="editform.time" style="width: 200px;"></el-input>
							</el-form-item>
						</el-col>
					</el-row>
					<el-row :gutter="5">
						<el-col :span="8">
							<el-form-item label="状态">
								<el-input v-model="editform.cancel" style="width: 200px;"></el-input>
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
	</div>
</template>
<script>
	export default {
		props: ['OrderData'],
		data() {
			return {
				// OrderData: [],
				// tableData: []
				editorder: false,
				editform: {
					userid: '',
					shopId: '',
					shopnumber: '',
					discount: '',
					address: '',
					time: '',
					allprice: '',
					cancel: ''
				},
				loading:false
			};
		},
		mounted() {
			this.getallOrder();
		},
		methods: {
			getallOrder() {
				// alert("--")
				var queryorderkey = sessionStorage.getItem("queryorderkey")
				var queryordervalue = sessionStorage.getItem("queryordervalue")
				sessionStorage.removeItem("queryorderkey")
				sessionStorage.removeItem("queryordervalue")
				// alert("2")
				var posturl = "http://localhost:8080/shop/findAllOrder";
				if (queryorderkey == "按用户编号查询") {
					posturl = "http://localhost:8080/shop/findLikeOrderByUserId/" + queryordervalue;
				} else if (queryorderkey == "按订单编号查询") {
					posturl = "http://localhost:8080/shop/findLikeOrderByShopId/" + queryordervalue;
				} else if (querykey == "按状态查询") {
					posturl = "http://localhost:8080/shop/findLikeOrderByCancel/" + queryordervalue;
				}
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
			},
			handleClick(row) {
				console.log(row);
			},
			tableRowClassName({
				row,
				rowIndex
			}) {
				if (row.cancel === "未到货") {
					return 'warning-row';
				} else {
					return 'success-row';
				}
				return '';
			},
			handleEdit(index, row) {
				console.log(index, row);
				this.editorder = true;
				this.editform = this.OrderData[index]
			},
			handleDelete(index, row) {
				console.log(index, row);
				var that = this;
				this.$axios.post("http://localhost:8080/shop/deleteOrderByShopId/" + row.shopId)
					.then(function(res) {
						console.log(res.data);
						if (res.data == 1) {
							that.$message("删除成功")
							that.OrderData.splice(index, 1);
						} else that.$message("删除失败")
					}).catch(function(err) {
						console.log(err);
					})
			},
			cancelForm() {
				this.editorder = false
			},
			handleClose(done) {
				if (this.loading) {
					return;
				}
				var that = this;
				this.$confirm('确定要提交表单吗？')
					.then(function() {
						that.loading = true;
						that.timer = setTimeout(() => {
							done();			
							that.$axios.post("http://localhost:8080/shop/updateOrderByShopId", {
								shopId: that.editform.shopId,
								userid: that.editform.userid,
								shopnumber: that.editform.shopnumber,
								discount: that.editform.discount,
								address: that.editform.address,
								time: that.editform.time,
								allprice: that.editform.allprice,
								cancel: that.editform.cancel,
							}).then(function(res) {
								console.log(res);
								// that.initeditorderfrom();
								that.getallOrder();
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
			initeditorderfrom(){
				this.editform.userid= '',
				this.editform.shopId= '',
				this.editform.shopnumber= '',
				this.editform.discount= '',
				this.editform.address= '',
				this.editform.time= '',
				this.editform.allprice= '',
				this.editform.cancel= ''
			}
		},
		components: {}
	}
</script>

<style>
	.el-table .warning-row {
		background: oldlace;
	}

	.el-table .success-row {
		background: #f0f9eb;
	}

	.wraper {
		width: 100%;
		height: 78vh;
		overflow-x: hidden;
	}

	.el-table__header tr,
	.el-table__header th {
		padding: 0;
		height: 20px;
	}

	.el-table__body tr,
	.el-table__body td {
		padding: 0;
		height: 40px;
	}


	/* .back-top-container {
		position: absolute;
		top: 0;
		bottom: 0;
		left: 0;
		right: 0;
		overflow: auto;
	} */

	/* ::-webkit-scrollbar {
		width: 0 !important;
	}

	::-webkit-scrollbar {
		width: 0 !important;
		height: 0;
	} */

	/* .el-row {
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
	} */
</style>
