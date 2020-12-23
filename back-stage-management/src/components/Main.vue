<template>
	<div class="wraper">
		<el-row>
			<el-col :span="12">
				<SalesCategory></SalesCategory>
			</el-col>
			<el-col :span="12">
				<SalesCategory></SalesCategory>
			</el-col>
		</el-row>
		<el-row>
			<el-col :span="23">
				<UserAccess></UserAccess>
			</el-col>
		</el-row>
	</div>
</template>

<script>
	import SalesCategory from './SalesCategory.vue'
	import UserAccess from './UserAccess.vue'
	export default {
		data() {
			return {

			};
		},
		mounted() {},
		methods: {

		},
		components: {
			SalesCategory,
			UserAccess
		}
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
