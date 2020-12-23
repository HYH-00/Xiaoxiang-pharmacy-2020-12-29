<template>
	<div class="wraper">
		<el-row>
			<template>
				<el-backtop target=".wraper">
					<div style="{height: 100%;width: 100%;background-color: #f2f5f6;box-shadow: 0 0 6px rgba(0,0,0, .12);text-align: center;line-height: 40px;color: #1989fa;}">
						UP
					</div>
				</el-backtop>
			</template>
			<el-col style="margin: 20px 20px 20px 0px;" :span="23" v-for="(it, index) in discountGoods" :key="it">
				<el-card :body-style="{ padding: '0px'}">
					<div style="width: 100%;height: 200px;">
						<div style="text-align: left;">
							<!-- <div class="block"> -->
							<el-image style="border-radius: 20px;width: 200px;height: 200px;" src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"></el-image>
							<!-- </div> -->
						</div>
					</div>
					<div style="height: 60px;">
						<!-- <div class="bottom clearfix"> -->
						<el-button type="text" class="button">操作按钮</el-button>
						<!-- </div> -->
					</div>
				</el-card>
			</el-col>
		</el-row>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				discountGoods: []
			};
		},
		mounted() {
			this.getallDiscountGoods();
		},
		methods: {
			getallDiscountGoods() {
				var that = this;
				this.$axios.post("http://localhost:8080/shop/allDiscountGoods")
					.then(function(res) {
						console.log(res);
						that.discountGoods = res.data;
					}).catch(function(err) {
						console.log(err);
					})
			}
		},
		components: {}
	}
</script>

<style>
	.wraper {
		width: 100%;
		height: 82vh;
		overflow-x: hidden;
	}

	::-webkit-scrollbar {
		width: 0 !important;
	}

	::-webkit-scrollbar {
		width: 0 !important;
		height: 0;
	}

	.image {
		width: 100%;
		display: block;
	}
</style>
