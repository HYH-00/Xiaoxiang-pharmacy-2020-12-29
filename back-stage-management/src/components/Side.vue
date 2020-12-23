<template>
	<el-row>
		<el-col :span="32">
			<el-menu default-active="2" class="el-menu-vertical-demo" @select="selectSidebar" @open="handleOpen" @close="handleClose">
				<el-submenu index="商品操作">
					<template slot="title">
						<i class="el-icon-s-goods"></i>
						<span>商品操作</span>
					</template>
					<el-menu-item index="商品添加">商品添加</el-menu-item>
					<el-menu-item index="商品修改">商品修改</el-menu-item>
					<el-menu-item index="商品删除">商品删除</el-menu-item>
					<el-menu-item index="商品查询">商品查询</el-menu-item>
				</el-submenu>
				<el-submenu index="订单操作">
					<template slot="title">
						<i class="el-icon-s-order"></i>
						<span slot="title">订单操作</span>
					</template>
					<el-menu-item index="订单添加">订单添加</el-menu-item>
					<el-menu-item index="订单修改">订单修改</el-menu-item>
					<el-menu-item index="订单删除">订单删除</el-menu-item>
					<el-menu-item index="订单查询">订单查询</el-menu-item>
				</el-submenu>
				<el-submenu index="用户操作">
					<template slot="title">
						<i class="el-icon-s-custom"></i>
						<span slot="title">用户操作</span>
					</template>
					<el-menu-item index="用户添加">用户添加</el-menu-item>
					<el-menu-item index="用户修改">用户修改</el-menu-item>
					<el-menu-item index="用户删除">用户删除</el-menu-item>
					<el-menu-item index="用户查询">用户查询</el-menu-item>
				</el-submenu>
				<el-submenu index="数据分析">
					<template slot="title">
						<i class="el-icon-s-marketing"></i>
						<span slot="title">数据分析</span>
					</template>
					<el-menu-item index="用户">用户</el-menu-item>
					<el-menu-item index="订单">订单</el-menu-item>
					<el-menu-item index="商品">商品</el-menu-item>
				</el-submenu>
			</el-menu>
		</el-col>
	</el-row>
</template>

<script>
	export default {
		data() {
			return {
				isCollapse: true
			};
		},
		methods: {
			handleOpen(key, keyPath) {
				console.log(key,keyPath);
				// this.$message(key);
			},
			handleClose(key, keyPath) {
				// this.$message(key);
				console.log(key,keyPath);
			},
			selectSidebar(index, indexPath) {
				console.log(index,indexPath);
				this.$message(index);
			}
		},
		components: {}
	}
</script>

<style>
	.el-menu-vertical-demo:not(.el-menu--collapse) {
		width: 200px;
		min-height: 400px;
	}
</style>
