<template>
	<div>
		基础信息设置
		<br>
		<el-tabs v-model="activeName" type="card" @tab-click="handleClick">
			<el-tab-pane label="部门管理" name="first">

			</el-tab-pane>


			<el-tab-pane label="职位管理" name="second">
				<div class="search-box">
					<el-input v-model="add_work" placeholder="+ 添加职位"></el-input>
					<el-button class="add" type="primary">+添加</el-button>
				</div>
				<div class="table">
					<el-table ref="multipleTable" :data="tableData" border stripe tooltip-effect="dark" style="width: 60%"
					 @selection-change="handleSelectionChange">
						<el-table-column type="selection" width="60">
						</el-table-column>

						<el-table-column prop="number" label="编号" width="120">
						</el-table-column>

						<el-table-column prop="jobname" label="职位名称" width="120">
						</el-table-column>

						<el-table-column prop="time" label="创建时间" width="150px" show-overflow-tooltip>
						</el-table-column>

						<el-table-column prop="caozuo" label="操作">
							<template slot-scope="scope">
								<el-button icon="el-icon-edit" @click="edit(scope.row)"></el-button>
								<el-button icon="el-icon-delete" @click="del(scope.row)"></el-button>
							</template>
						</el-table-column>
					</el-table>
				</div>
			</el-tab-pane>
			<el-tab-pane label="职称管理" name="third">角色管理</el-tab-pane>
			<el-tab-pane label="奖惩规则" name="fourth">定时任务补偿</el-tab-pane>
			<el-tab-pane label="权限组" name="fifth">定时任务补偿</el-tab-pane>
		</el-tabs>
	</div>
</template>

<script>
	export default {
		name: 'SysBasic',
		data() {
			return {
				activeName: 'first',
				tableData: [
					{
						number: '01',
						jobname: '总监',
						time: '2016-05-03'
					},
					{
						date: '2016-05-03',
						name: '王小虎',
						address: '上海市普陀区金沙江路 1518 弄'
					},
				]
			}
		},
		methods: {
			handleClick(tab, event) {
				console.log(tab, event);
			}
		}
	}
</script>

<style scoped>
	.search-box {}

	.el-input {
		width: 300px;
	}

	.add {
		margin-left: 20px;
	}

	.table {
		margin-top: 20px;
	}
</style>
