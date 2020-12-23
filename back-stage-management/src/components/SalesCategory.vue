<template>
	<div>
		<ve-pie :events="chartEvents" :loading="loading" :data="chartData" :settings="chartSettings"></ve-pie>
	</div>
</template>

<script>
	export default {
		data() {
			this.chartSettings = {
				dimension: '类别',
				metrics: '销售额',
				selectedMode: 'single',
				radius: 80,
				limitShowNum: 10
				// label: ['a','b','c','d']
			}
			var self = this
			this.chartEvents = {
				click: function(e) {
					self.name = e.name
					self.$message(self.name);
				}
			}
			return {
				select_chart: '',
				chartData: {
					columns: ['类别', '销售额'],
					rows: [{
							'类别': '1/1',
							'销售额': 1393
						},
						{
							'类别': '1/2',
							'销售额': 3530
						},
						{
							'类别': '1/3',
							'销售额': 2923
						},
						{
							'类别': '1/4',
							'销售额': 1723
						},
						{
							'类别': '1/5',
							'销售额': 3792
						},
						{
							'类别': '1/6',
							'销售额': 4593
						}
					]
				}
			};
		},
		mounted() {},
		methods: {

		},
		components: {}
	}
</script>

<style>
</style>
