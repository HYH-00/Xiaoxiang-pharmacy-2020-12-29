<template>
	<el-container>
		<button @click="ju"></button>
		<el-header>
			<Top v-bind:adminInfo="adminInfo"></Top>
		</el-header>
		<el-container>
			<el-aside style="width: auto;">
				<Side></Side>
			</el-aside>
			<el-main>
				<Main></Main>
			</el-main>
		</el-container>
	</el-container>
</template>

<script>
	import Top from '../components/Top.vue'
	import Main from '../components/Main.vue'
	import Side from '../components/Side.vue'
	export default {
		data() {
			return {
				adminInfo: {
					adminId: this.$route.params.userId,
					adminPassword: this.$route.params.userPassword,
					adminNick: this.$route.params.userNickName
				},
				comName: 'TreeHole'
			};
		},
		mounted(){
			// this.ju();
		},
		methods: {
			// ju() {
			// 	alert(this.adminInfo.adminId)
			// },
			handleOpen(key, keyPath) {
				console.log(key, keyPath);
			},
			handleClose(key, keyPath) {
				console.log(key, keyPath);
			}
		},
		components: {
			Top,
			Main,
			Side
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
