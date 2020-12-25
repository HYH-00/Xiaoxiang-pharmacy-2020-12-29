<template>
	<div>
		<div class="block">
			<el-button round style="margin-right: 10px;" @click="changeType">切换图表类型</el-button>
			<el-date-picker @change="getdata" v-model="year" type="year" placeholder="选择日期" format="yyyy 年" value-format="yyyy" :clearable="false">
			</el-date-picker>
		</div>
		<ve-chart :events="chartEvents" :loading="loading" :data="chartData" :settings="chartSettings"></ve-chart>
	</div>
</template>

<script>
	export default {
		data() {
			this.index = 0
			var self = this
			this.chartEvents = {
				click: function(e) {
					self.name = e.name
					self.$message(self.name);
				}
			}
			return {
				year: '',
				select_chart: '',
				chartData: {
					columns: [],
					rows: []
				},
				chartSettings: {
					type: 'pie',
					selectedMode: 'single',
					limitShowNum: 10,
				},
				chartset: [{
					type: 'pie',
					selectedMode: 'single',
					limitShowNum: 10
				}, {
					type: 'histogram',
					limitShowNum: 10,
					legendName:{
						'num':"数量"
					}
				}, {
					type: 'line',
					limitShowNum: 10,
					legendName:{
						'num':"数量"
					}
				}, {
					type: 'ring',
					limitShowNum: 10,
					legendName:{
						'num':"数量"
					}
				}]
			};
		},
		mounted() {
			this.inityear();
			this.getdata();
		},
		methods: {
			inityear() {
				this.year = sessionStorage.getItem("year");
			},
			changeType: function() {
				this.index++
				if (this.index >= 4) {
					this.index = 0
				}
				this.chartSettings = this.chartset[this.index];
			},
			getdata() {
				var that = this
				this.$axios.post("http://localhost:8080/shop/querySalesNumByYear/"+this.year)
					.then(function(res) {
						// alert(res.data.data.rows[0])
						that.chartData=res.data.data;
					}).catch(function(err) {
						console.log(err);
					})
			}
		},
		components: {

		}
	}
</script>

<style>
</style>
