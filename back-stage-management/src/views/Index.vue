<template>
	<el-container>
		<el-header>
			<Top @menuSelect="menuSelect_" v-bind:adminInfo="adminInfo"></Top>
		</el-header>
		<el-container>
			<el-aside style="width: auto;">
				<Side @SideSelect="SideSelect_"></Side>
			</el-aside>
			<el-main>
				<component :is="comName" v-bind:userinfo="userinfo"></component>
			</el-main>
		</el-container>
	</el-container>
</template>

<script>
	import Top from '../components/Top.vue'
	import Main from '../components/Main.vue'
	import Side from '../components/Side.vue'
	import Product from '../components/Product.vue'
	import Order from '../components/Order.vue'
	import Message from '../components/Message.vue'
	import User from '../components/User.vue'
	import OrderData from '../components/OrderData.vue'
	export default {
		data() {
			return {
				adminInfo: {
					// adminId: this.$route.params.userId,
					// adminPwd: this.$route.params.userPassword,
					// adminNick: this.$route.params.userNickName
					adminId: '',
					adminPwd: '',
					adminNick: ''
				},
				comName: 'Main'
			};
		},
		mounted() {
			this.get();
		},
		methods: {
			get() {
				this.adminInfo.adminId = sessionStorage.getItem("adminId");
				this.adminInfo.adminPwd = sessionStorage.getItem("adminPwd");
				this.adminInfo.adminNick = sessionStorage.getItem("adminNick");
			},
			menuSelect_(data) {
				if (data == "处理中心") this.comName = "Main";
				else if (data == "商品总览") this.comName = "Product";
				else if (data == "消息中心") this.comName = "Message";
				else if (data == "订单管理") this.comName = "Order";
				else if (data == "用户管理") this.comName = "User";
			},
			SideSelect_(data){
				if(data=="数据分析")this.comName="OrderData";
			}
		},
		components: {
			Top,
			Main,
			Side,
			Product,
			Order,
			Message,
			User,
			OrderData
		}
	}
</script>

<style>
	* {
		margin: 0;
		padding: 0;
	}

	html,
	body {
		height: 100%;
	}

	.box {
		height: 100%;
		background-color: blue;
	}


	/* .el-menu-vertical-demo:not(.el-menu--collapse) {
		width: 200px;
		min-height: 200px;
	} */

	.el-header {
		/* background-color: #B3C0D1; */
		color: #333;
		text-align: center;
		/* line-height: 60px; */
	}

	.el-aside {
		/* background-color: #D3DCE6; */
		color: #333;
		text-align: center;
		/* line-height: 200px; */
	}

	.el-main {
		/* background-color: #E9EEF3; */
		color: #333;
		text-align: center;
		line-height: 160px;
	}

	body>.el-container {
		margin-bottom: 40px;
	}

	.el-container:nth-child(5) .el-aside,
	.el-container:nth-child(6) .el-aside {
		line-height: 260px;
	}

	.el-container:nth-child(7) .el-aside {
		line-height: 320px;
	}
</style>
