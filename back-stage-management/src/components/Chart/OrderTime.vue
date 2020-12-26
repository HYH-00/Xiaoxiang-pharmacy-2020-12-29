<template>
	<div>
		<ve-line :data="chartData" :data-zoom="dataZoom" :settings="chartSettings">
		</ve-line>
	</div>
</template>

<script>
	export default {
		data() {
			// this.dataZoom = [{
			// 	type: 'slider',
   //              show: true,
   //              startValue: 0,
   //              endValue: 5,
   //              height: '15',
   //              bottom: '3%',
   //              // zoomLock: true
			// }]
			return {
				chartData: {
					columns: [],
					rows: []
				},dataZoom:{
					type: 'slider',
					show: true,
					startValue: 0,
					endValue: 5,
					height: '15',
					bottom: '3%',
				},
				chartSettings: {
					legendName:{
						'date':"日期",
						'mount':"金额",
						'num':"数量"
					}
				}
			}
		},
		mounted() {
			this.getdata();
		},
		methods: {
			getdata() {
				var that = this
				this.$axios.post("http://localhost:8080/shop/queryOrderTime")
					.then(function(res) {
						// alert(res.data.data)
						that.chartData = res.data.data;
						var len=that.chartData.rows.length;
						that.dataZoom.endValue=len;
						that.dataZoom.startValue=len-11;
					}).catch(function(err) {
						console.log(err);
					})
			}
		}
	}
</script>

<style>
</style>
