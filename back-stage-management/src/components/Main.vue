<template>
	<div class="wraper">
		<template>
			<el-backtop target=".wraper">
				<div style="{height: 100%;width: 100%;background-color: #f2f5f6;box-shadow: 0 0 6px rgba(0,0,0, .12);text-align: center;line-height: 40px;color: #1989fa;}">
					UP
				</div>
			</el-backtop>
		</template>
		<p v-for="(item,id) in items" :key="id">这是第{{item}}次循环</p>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				items:[1,2,3,4,5,6,7,8,2,3,4,5,6,7,8,9,67,45,4,343]
			};
		},
		methods: {
	
		},
		components: {
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
</style>
