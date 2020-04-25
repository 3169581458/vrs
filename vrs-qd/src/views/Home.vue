<template>
   <el-container >
     <el-header class="el-header" style="height: 80px;">
		 <div class="title">微人事</div>
		 <el-avatar class="pic" :src="user.userface" alt=""></el-avatar>
		 <el-dropdown class="user_name" @command="commandHandler">
		   <span class="el-dropdown-link">
		     {{user.name}}
       <!--      系统管理员 -->
		   </span>
		   <el-dropdown-menu slot="dropdown">
		     <el-dropdown-item command="userinfo">个人中心</el-dropdown-item>
		     <el-dropdown-item command="setting">设置</el-dropdown-item>
		     <el-dropdown-item command="logout" divided>注销</el-dropdown-item>
		   </el-dropdown-menu>      
		 </el-dropdown>
	 </el-header>
     <el-container>
       <el-aside width="15%">
	   
	   <el-menu router unique-opened>
	     <el-submenu :index="index.toString()" v-for="(item, index) in routes"
	                 v-if="!item.hidden" :key="index">
	       <template slot="title">
	         <i :class="item.iconCls" style="color: #0392ff; margin-right: 8px"></i>
	         <span>{{item.name}}</span>
	       </template>
	       <el-menu-item :index="child.path" v-for="(child, subIndex) in item.children"
	                     :key="subIndex">
	         {{child.name}}
	       </el-menu-item>
	     </el-submenu>
	   </el-menu>
	   
	   </el-aside>
       <el-main>
		   
		   <el-breadcrumb separator-class="el-icon-arrow-right"
		                  v-if="this.$router.currentRoute.path !== '/home'">
		     <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
		     <el-breadcrumb-item>{{this.$router.currentRoute.name}}</el-breadcrumb-item>
		   </el-breadcrumb>
		   <div class="home_welcome" v-else>欢迎来到微人事</div>
		   <router-view/>
		   
	   </el-main>
     </el-container>
   </el-container>
   
</template>

<script>
    export default {
        name: "Home",
		data () {
		  return {
		    user: JSON.parse(window.sessionStorage.getItem('user'))
		  }
		},
		computed: {
		  routes () {
		    return this.$store.state.routes;
		  }
		},
		methods: {
			commandHandler (cmd) {
				if (cmd === 'logout') {
					this.$confirm('此操作将注销登录, 是否继续?', '提示', {
						confirmButtonText: '确定',
						cancelButtonText: '取消',
						type: 'warning'
					}).then(() => {
						this.getRequest('/logout')
						// 1. 移除storage存储的数据
						window.sessionStorage.removeItem('user')
						// 2. 路由跳转到首页
						this.$router.replace('/')
						// 3. 清空store存储的菜单信息
						this.$store.commit('initRoutes', [])
					}).catch(() => {
						this.$message({
							type: 'info',
							message: '已取消操作'
						});
					});
				}
			}
		}
    }
</script>

<style >
	body {
		margin: 0px;
		background-color: #FFFFFF;
		height: 100%;
	}
	.el-container{
		height: 100%;
	}
	.title{
		margin-top: 20px;
		width: 100px;
		float: left;
	}
	.user_name{
		float: right;
		margin: 0px;
		margin-right: 30px;
	}
	.pic{
		float: right;
		margin-top: 20px;
	}
	.el-dropdown-link{
		line-height: 80px;
		color: #FFFFFF;
		
	}
    .el-header {
		background-color: #409EFF;
		color: #FFFFFF;
		font-size: 30px;
	}
	.el-aside{
		background-color: #e6e6e6;
		height: 100%;
	}
	.el-submenu{
		background-color: #e6e6e6;
	}

</style>