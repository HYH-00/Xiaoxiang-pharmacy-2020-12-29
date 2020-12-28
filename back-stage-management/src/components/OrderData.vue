<template>
	<div class="wraper">
		<el-row>
			<el-col :span="12">
				<SalesMount></SalesMount>
			</el-col>
			<el-col :span="12">
				<SalesNum></SalesNum>
			</el-col>
		</el-row>
		<el-row>
			<el-col :span="24">
				<OrderTime></OrderTime>
			</el-col>
		</el-row>
	</div>
</template>

<script>
	import SalesMount from './Chart/SalesMount.vue'
	import SalesNum from './Chart/SalesNum.vue'
	import OrderTime from './Chart/OrderTime.vue'
	export default {
		props:['info'],
		data() {
			return {

			};
		},
		mounted() {},
		methods: {

		},
		components: {
			SalesMount,
			SalesNum,
			OrderTime
		}
	}
</script>

<style>
	.wraper {
		width: 100%;
		height: 82vh;
		overflow-x: hidden;
	}

	/* ::-webkit-scrollbar {
		width: 0 !important;
	}

	::-webkit-scrollbar {
		width: 0 !important;
		height: 0;
	} */

	.image {
		width: 100%;
		display: block;
	}
</style>
