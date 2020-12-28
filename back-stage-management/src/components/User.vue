<template>
	<div>
		<el-table :data="UserData" style="width: 100%;padding: 0px;" height="630">
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
		props: ['UserData'],
		data() {
			return {
			};
		},
		mounted() {
			this.getallUser();
		},
		methods: {
			getallUser() {
				// alert("--")
				var queryuserkey = sessionStorage.getItem("queryuserkey")
				var queryordervalue = sessionStorage.getItem("queryuservalue")
				sessionStorage.removeItem("queryuserkey")
				sessionStorage.removeItem("queryordervalue")
				// alert("2")
				var posturl = "http://localhost:8080/shop/findAllOrder";
				if (queryuserkey == "按用户编号查询") {
					posturl = "http://localhost:8080/shop/findLikeOrderByUserId/" + queryordervalue;
				} else if (queryuserkey == "按订单编号查询") {
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
						that.UserData = res.data;
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
</style>
