<template>
	<div class="wraper">
		<el-row :gutter="20">
			<el-col :span="6">
				<el-button style="border-radius: 30px;width: 9.5rem;height: 9.5rem;" type="success" plain>
					<div>
						<p style="font-size: 16px;">新增用户</p>
						<p style="font-size: 30px;">1000</p>
					</div>
				</el-button>
			</el-col>
			<el-col :span="6">
				<el-button style="border-radius: 30px;width: 9.5rem;height: 9.5rem;" type="success" plain>
					<div>
						<p style="font-size: 16px;">新增订单数</p>
						<p style="font-size: 30px;">987</p>
					</div>
				</el-button>
			</el-col>
			<el-col :span="6">
				<el-button style="border-radius: 30px;width: 9.5rem;height: 9.5rem;" type="success" plain>
					<div>
						<p style="font-size: 16px;">新增交易额</p>
						<p style="font-size: 30px;">43585</p>
					</div>
				</el-button>
			</el-col>
			<el-col :span="6">
				<el-button style="border-radius: 30px;width: 9.5rem;height: 9.5rem;" type="success" plain>
					<div>
						<p style="font-size: 16px;">活跃用户</p>
						<p style="font-size: 30px;">10000</p>
					</div>
				</el-button>
			</el-col>
		</el-row>
	</div>
</template>

<script>
	export default {
		props:['info'],
		data() {
			return {

			};
		},
		mounted() {},
		methods: {

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
