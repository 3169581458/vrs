<template>
	<div>
		基础信息设置
		<el-tabs v-model="activeName" type="card">
			<el-tab-pane label="部门管理" name="first"><Bumen></Bumen></el-tab-pane>
			<el-tab-pane label="职位管理" name="second"><Position></Position></el-tab-pane>
			<el-tab-pane label="职称管理" name="third"><Joblevel</el-tab-pane>
			<el-tab-pane label="奖惩规则" name="fourth">bb</el-tab-pane>
			<el-tab-pane label="权限组" name="fifth">cc</el-tab-pane>
		</el-tabs>
	</div>
</template>

<script>
	import Position from '../../component/syetem/basic/Position'
	import Bumen from '../../component/syetem/basic/Bumen.vue'
	import Joblevel from '../../component/syetem/basic/Joblevel.vue'
	export default {
		name: 'SysBasic',
		data() {
			return {
				activeName: 'second',
			}
		},
		components:{
			Position,
			Bumen,
			Joblevel,
		}
	}
</script>

<style scoped>
	
</style>
