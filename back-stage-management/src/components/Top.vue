<template>
	<div>
		<el-menu :default-active="adminInfo.select" class="el-menu-demo" mode="horizontal" @select="handleSelect">
			<el-menu-item index="处理中心">处理中心</el-menu-item>
			<el-menu-item index="商品总览">商品总览</el-menu-item>
			<el-menu-item index="订单管理">订单管理</el-menu-item>
			<!-- <el-menu-item index="用户管理">用户管理</el-menu-item> -->
			<div style="float: right;width: auto;margin-top: 5px;">
				<el-dropdown @command="handleCommand">
					<el-col :span="12">
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
						<el-dropdown-item command="退出登录">退出登录</el-dropdown-item>
					</el-dropdown-menu>
				</el-dropdown>
			</div>
			<el-dialog title="提示" :visible.sync="infoVisible" width="30%" center>
				<span slot="title" class="dialog-title">
					<div style="font-size: 18px;">
						管理员ID：{{info.adminId}}
						<br />
						<br />
						管理员昵称：{{info.adminNick}}
					</div>
					<!-- <el-button @click="centerDialogVisible = false">取 消</el-button> -->
					<!-- <el-button type="primary" @click="centerDialogVisible = false">确 定</el-button> -->
				</span>
			</el-dialog>
		</el-menu>
	</div>
</template>

<script>
	export default {
		props: ['adminInfo'],
		data() {
			return {
				info: this.adminInfo,
				activeIndex: '处理中心',
				headUrl: 'https://s3.ax1x.com/2020/12/11/rAAung.jpg',
				infoVisible: false
			};
		},
		methods: {
			handleSelect(key, keyPath) {
				this.$emit("menuSelect", key);
				this.$message(key + " " + keyPath);
			},
			handleCommand(command) {
				var that = this;
				if (command == "个人信息") {
					this.infoVisible = true;
				} else if (command == "退出登录") {
					sessionStorage.removeItem('adminId');
					sessionStorage.removeItem('adminPwd');
					sessionStorage.removeItem('adminNick');
					that.$router.push({
						name: 'Login',
						params: {
							// userId: dat.id,
							// userPassword: dat.pwd,
							// userNickName: dat.nick
						}
					});
				}
				this.$message('click on item ' + command + " " + this.info.adminId);
			}
		}
	}
</script>

<style>
	* {
		margin: 0;
		padding: 0;
	}
</style>
