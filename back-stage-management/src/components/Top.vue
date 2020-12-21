<template>
	<el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
		<el-menu-item index="1">处理中心</el-menu-item>
		<el-submenu index="2">
			<template slot="title">我的工作台</template>
			<el-menu-item index="2-1">选项1</el-menu-item>
			<el-menu-item index="2-2">选项2</el-menu-item>
			<el-menu-item index="2-3">选项3</el-menu-item>
			<el-submenu index="2-4">
				<template slot="title">选项4</template>
				<el-menu-item index="2-4-1">选项1</el-menu-item>
				<el-menu-item index="2-4-2">选项2</el-menu-item>
				<el-menu-item index="2-4-3">选项3</el-menu-item>
			</el-submenu>
		</el-submenu>
		<el-menu-item index="3">消息中心</el-menu-item>
		<el-menu-item index="4"><a href="https://www.ele.me" target="_blank">订单管理</a></el-menu-item>
		<div style="float: right;width: auto;margin-top: 5px;">
			<el-dropdown @command="handleCommand">
				<!-- <span class="el-dropdown-link">
					下拉菜单<i class="el-icon-arrow-down el-icon--right"></i>
				</span> -->
				<p>{{adminInfo.adminNick}}</p>
				<el-col :span="10">
					<div class="demo-basic--circle">
						<div class="block">
							<el-avatar :size="50" :src="headUrl"></el-avatar>
						</div>
						<div class="block" v-for="size in sizeList" :key="size">
							<el-avatar :size="size" :src="circleUrl"></el-avatar>
						</div>
					</div>
				</el-col>
				<el-dropdown-menu slot="dropdown">
					<el-dropdown-item command="个人信息">个人信息</el-dropdown-item>
					<el-dropdown-item command="修改密码">修改密码</el-dropdown-item>
					<el-dropdown-item command="注销">注销</el-dropdown-item>
				</el-dropdown-menu>
			</el-dropdown>
		</div>
	</el-menu>
</template>

<script>
	export default {
		props: ['adminInfo'],
		data() {
			return {
				info: this.adminInfo,
				activeIndex2: '1',
				headUrl: 'https://s3.ax1x.com/2020/12/11/rAAung.jpg'
			};
		},
		methods: {
			handleSelect(key, keyPath) {
				this.$message(key + " " + keyPath);
				// console.log(key, keyPath);
			},
			handleCommand(command) {

				this.$message('click on item ' + command + " " + this.info.adminId);
			}
		}
	}
</script>

<style>
</style>
