<template>
	<div>
		<el-table :data="OrderData" style="width: 100%;padding: 0px;" height="630">
			<el-table-column fixed prop="userid" label="用户编号" width="180"></el-table-column>
			<el-table-column prop="shopId" label="商品编号" width="160"></el-table-column>
			<el-table-column prop="shopnumber" label="数量" width="60"></el-table-column>
			<el-table-column prop="discount" label="折扣" width="60"></el-table-column>
			<el-table-column prop="address" label="地址" width="360"></el-table-column>
			<el-table-column prop="allprice" label="全价" width="60"></el-table-column>
			<el-table-column prop="time" label="时间" width="100"></el-table-column>
			<el-table-column prop="cancel" label="状态" width="100"></el-table-column>
			<el-table-column fixed="right" label="操作" width="100">
				<template slot-scope="scope">
					<el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
					<el-button type="text" size="small">编辑</el-button>
				</template>
			</el-table-column>
		</el-table>
	</div>
</template>
<script>
	export default {
		props:['OrderData'],
		data() {
			return {
				// OrderData: [],
				// tableData: []
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
				alert(posturl)
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
				if (rowIndex === 1) {
					return 'warning-row';
				} else if (rowIndex === 3) {
					return 'success-row';
				}
				return '';
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

	/* .el-table__header-wrapper{
		padding: 0;
		height: 20px;
		width: 20px;
	} */

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
