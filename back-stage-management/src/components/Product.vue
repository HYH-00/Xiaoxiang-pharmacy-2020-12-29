<template>
	<div id="app">
		<el-row>
			<el-col style="margin: 20px 20px 20px 0px;" :span="23" v-for="(it, index) in discountGoods" :key="it">
				<el-card :body-style="{ padding: '0px'}">
					<el-row :gutter="0" style="height: 175px;" type="flex" justify="start">
						<el-col :span="4">
							<!-- <div class="grid-content bg-purple"> -->
							<img style="border-radius: 20px;height: 200px;width: 200px;" :src="discountGoods[index].picture"></img>
							<!-- </div> -->
						</el-col>
						<el-col :span="18" style="text-align: left;margin-left: 40px;margin-top:20px;overflow: hidden;white-space: nowrap;text-overflow: ellipsis;">
							<!-- <div class="grid-content bg-purple" style="text-align: left;"> -->
							<h3 style="height: 20px;">商品名称: {{discountGoods[index].name}}</h3>
							<p style="height: 20px;">批准文号: {{discountGoods[index].shopId}}</p>
							<p style="height: 20px;">描述: {{discountGoods[index].description}}</p>
							<p style="height: 20px;">库存量: {{discountGoods[index].number}}</p>
							<p style="height: 20px;">商标: {{discountGoods[index].trademark}}</p>
							<p style="height: 20px;">制造商: {{discountGoods[index].manufacturer}}</p>
							<p style="height: 20px;">医药用品类别: {{discountGoods[index].type}}</p>
							<!-- </div> -->
						</el-col>
					</el-row>
					<el-row style="height: 3px;">
						<el-divider style="height: 3px;margin-top: -60px;" />
					</el-row>
					<el-row style="height: 40px;" type="flex" justify="end">
						<el-col :span="7" :offset="19">
							<el-button-group style="height: 80px;margin-top: 10px;margin-right: 10px;">
								<el-button type="primary" icon="el-icon-edit" plain></el-button>
								<el-button type="success" icon="el-icon-collection-tag" plain></el-button>
								<el-button type="danger" icon="el-icon-delete" plain></el-button>
							</el-button-group>
						</el-col>
					</el-row>
				</el-card>
			</el-col>
		</el-row>
	</div>
</template>

<script>
	export default {
		props: ['discountGoods'],
		data() {
			return {
				// discountGoods: []
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
			}
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

	::-webkit-scrollbar {
		width: 0 !important;
	}

	::-webkit-scrollbar {
		width: 0 !important;
		height: 0;
	}

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
