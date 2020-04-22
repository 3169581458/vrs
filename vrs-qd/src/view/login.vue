<template>
	<div class="app">
		<el-form :model="loginForm" :rules="loginFormRule" ref="loginFormRef" label-width="0px" class="demo-ruleForm">
			<p style="text-align: center;"><b>系统登陆</b></p>
			<!-- 用户名 -->
			<el-form-item prop="username">
				<el-input v-model="loginForm.username" prefix-icon="iconfont icon-account-fill"></el-input>
			</el-form-item>
			<!-- 密码 -->
			<el-form-item prop="password">
				<el-input v-model="loginForm.password" prefix-icon="iconfont icon-password" @keydown.enter.native="Login"
				 show-password></el-input>
			</el-form-item>
			<!-- 记住我 -->
			<el-form-item>
				<el-checkbox v-model="checked" class="login_remember">记住我</el-checkbox>
			</el-form-item>
			<!-- 登录/重置按钮 -->
			<el-form-item class="btn">
				<el-button type="primary" @click="login">登录</el-button>
				<el-button type="info" @click="resetLoginForm">重置</el-button>
			</el-form-item>
		</el-form>
	</div>
</template>

<script>
	import {
		postKeyValueRequest
	} from '../untils/api.js'
	export default {
		name: 'Login',
		data() {
			return {
				loginForm: {
					username: 'admin',
					password: '123456'
				},

				checked: true,
				loginFormRule: {
					username: [{
							required: true,
							message: '请输入账号',
							trigger: 'blur'
						},
						{
							min: 3,
							max: 6,
							message: '长度在3到6个字',
							trigger: 'blur'
						}
					],
					password: [{
							required: true,
							message: '请输入账号',
							trigger: 'blur'
						},
						{
							min: 3,
							max: 7,
							message: '长度在3到6个字符',
							trigger: 'blur'
						}
					]
				}
			}

		},
		methods: {
			//登录事件
			login: function() {
				this.$refs.loginFormRef.validate(valid => {
					if (!valid) {
						return this.$message.error('用户名或密码格式不正确，请重新输入')
					}
					postKeyValueRequest('/doLogin', this.loginForm).then(resp => {
						console.log(resp)
						if (resp) {
							console.log(resp.obj)
							this.$message.success('登录成功')
							window.sessionStorage.setItem('user', JSON.stringify(resp.obj));
							let path = this.$route.query.redirect
							this.$router.replace('/home')
						}
					})
				})
			},
            //重置
			resetLoginForm() {
				console.log(this.$refs)
				this.$refs.loginFormRef.resetFields()
			}
		}

	}
</script>

<style>
	body {}

	.app {
		width: 500px;
		height: 350px;
		position: absolute;
		left: 50%;
		top: 50%;
		margin-left: -250px;
		margin-top: -175px;
		border: 1px solid gray;
		border-radius: 30px;

		box-shadow: 10px 10px 10px 10px #888888;
	}

	.demo-ruleForm {
		width: 400px;
		margin: 0 auto;
		margin-top: 40px;
	}

	.btn {
		margin-left: 135px;
	}
</style>
