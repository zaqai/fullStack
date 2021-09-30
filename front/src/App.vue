<template>
  <div id="app">
    <el-table class="table" :data="getData" border stripe>
      <el-table-column
        type="index"
        fixed="left"
        width="50px"
        label="序号"
        align="center"
      >
      </el-table-column>
      <el-table-column
        width="110px"
        align="center"
        fixed
        sortable
        prop="id"
        label="学号"
      >
        <template slot-scope="scope">
          <span v-if="!showEdit[scope.$index]">{{ scope.row.id }}</span>
        </template>
      </el-table-column>
      <el-table-column sortable align="center" prop="username" label="姓名">
        <template slot-scope="scope">
          <span v-if="!showEdit[scope.$index]">{{ scope.row.username }}</span>
        </template>
      </el-table-column>
      <el-table-column prop="password" align="center" label="密码">
        <template slot-scope="scope">
          <span v-if="!showEdit[scope.$index]">{{ scope.row.password }}</span>
        </template>
      </el-table-column>
      <el-table-column prop="email" align="center" label="邮箱">
        <template slot-scope="scope">
          <span v-if="!showEdit[scope.$index]">{{ scope.row.email }}</span>
        </template>
      </el-table-column>
      <el-table-column fixed="right" align="center" label="操作" width="100">
        <template slot-scope="scope">
          <el-button
            @click="showUpdate(scope.$index, scope.row)"
            type="text"
            size="small"
            >修改</el-button
          >
          <el-button @click="deleteUser(scope.row)" type="text" size="small"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  data () {
    return {
      showEdit: [],
      getData: null,
    }
  },
  created () {
    this.fetchDate()
  },
  watch: {
    currentBranch: 'fetchDate'
  },

  methods: {
    fetchDate () {
      var xhr = new XMLHttpRequest()

      let self = this

      xhr.onload = function () {
        if (xhr.readyState == 4) {
          if (xhr.status >= 200 && xhr.status < 300 || xhr.status == 304) {
            self.getData = JSON.parse(xhr.responseText)
          } else {
            console.error(xhr.status, xhr.statusText)
          }
        }
      }
      xhr.open('GET', "http://127.0.0.1:8090/do/user/userAll")
      xhr.send(null)
    },
    showUpdate (index, row) {
      this.showEdit[index] = true
      this.$set(this.showEdit, index, true) //这里要用$set方法，否则页面状态不更新
      console.log(row)
    },

    deleteUser (row) {

      var xhr = new XMLHttpRequest()
      this.$confirm('删除不可以恢复,确认要删除?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {

        xhr.open('GET', "http://127.0.0.1:8090/do/user/delete?id=" + row.id)
        xhr.send(null)
        console.log(xhr.responseText)

      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })




    }

  },
}




</script>
<style  scoped>
.table {
  margin-top: 20px;
  text-align: center;
  border: 1px solid black;
  max-width: 1200px;
}

.top {
  margin: 0 auto;
  text-align: center;
}

.page {
  margin-top: 15px;
  text-align: center;
}
</style>