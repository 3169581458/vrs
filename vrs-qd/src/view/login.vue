<template>
	
	
	  <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
		<el-form-item label="账号" prop="user">
			<el-input v-model="input" placeholder="请输入账号"></el-input>
		</el-form-item>
		<el-form-item label="密码" prop="psd">
			<el-input placeholder="请输入密码" v-model="input" show-password></el-input>
		</el-form-item>
		<el-form-item >
			<el-checkbox v-model="checked">记住密码</el-checkbox><br>
		</el-form-item>
		<el-form-item>
			<el-button type="primary" @click="submitForm('ruleForm')">登录</el-button>
			<el-button @click="resetForm('ruleForm')">重置</el-button>
		</el-form-item>
	  </el-form>
	
</template>

<script>
</script>

<style>	

	.demo-ruleForm{
		width: 500px;
		height: 300px;
		margin: 0 auto;
		margin-top: 300px;
		
/* 		border:1px solid gray;
		border-radius: 30px; */
		
	}

</style>
