<template>
	<div>
		<ve-line @change="getData" :data="chartData" :loading="loading" :data-zoom="dataZoom" :toolbox="toolbox" :extend="extend"></ve-line>
	</div>
</template>

<script>
	export default {
		data() {
			this.dataZoom = [{
				type: 'slider',
				start: 0,
				end: 20
			}]
			this.toolbox = {
				feature: {
					magicType: {
						type: ['line', 'bar']
					},
					saveAsImage: {}
				}
			}
			this.chartSettings = {
				xAxisType: 'time'
			}
			return {
				chartData: {
					columns: ['日期', '访问用户', '下单用户', '下单率'],
					rows: [{
							'日期': '2018-01-01',
							'访问用户': 1393,
							'下单用户': 1093,
							'下单率': 0.32
						},
						{
							'日期': '2018-01-02',
							'访问用户': 3530,
							'下单用户': 3230,
							'下单率': 0.26
						},
						{
							'日期': '2018-01-03',
							'访问用户': 2923,
							'下单用户': 2623,
							'下单率': 0.76
						},
						{
							'日期': '2018-01-05',
							'访问用户': 1723,
							'下单用户': 1423,
							'下单率': 0.49
						},
						{
							'日期': '2018-01-10',
							'访问用户': 3792,
							'下单用户': 3492,
							'下单率': 0.323
						},
						{
							'日期': '2018-01-20',
							'访问用户': 4593,
							'下单用户': 4293,
							'下单率': 0.78
						}
					]
				}
			}
		}
	}
</script>

<style>
</style>
