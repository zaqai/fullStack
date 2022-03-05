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
          <span>{{ scope.row.id }}</span>
        </template>
      </el-table-column>
      <el-table-column sortable align="center" prop="username" label="姓名">
        <template slot-scope="scope">
          <span v-if="!showEdit[scope.$index]">{{ scope.row.username }}</span>
          <el-input
            type="text"
            v-model="scope.row.username"
            v-else
            placeholder="请输入姓名"
          ></el-input>
        </template>
      </el-table-column>
      <el-table-column prop="password" align="center" label="密码">
        <template slot-scope="scope">
          <span v-if="!showEdit[scope.$index]">{{ scope.row.password }}</span>
          <el-input
            type="text"
            v-model="scope.row.password"
            v-else
            placeholder="请输入密码"
          ></el-input>
        </template>
      </el-table-column>
      <el-table-column prop="email" align="center" label="邮箱">
        <template slot-scope="scope">
          <span v-if="!showEdit[scope.$index]">{{ scope.row.email }}</span>
          <el-input
            type="text"
            v-model="scope.row.email"
            v-else
            placeholder="请输入邮箱"
          ></el-input>
        </template>
      </el-table-column>
      <el-table-column fixed="right" align="center" label="操作" width="100">
        <template slot-scope="scope">
          <span v-if="scope.row.id">
            <el-button
              @click="showUpdate(scope.$index, scope.row)"
              type="text"
              size="small"
              >修改</el-button
            >
            <el-button @click="deleteUser(scope.row)" type="text" size="small"
              >删除</el-button
            >
          </span>
          <span v-else>
            <el-button @click="addUser(scope.row)" type="text" size="small"
              >添加</el-button
            >
          </span>
          <el-button
            v-if="showEdit[scope.$index]"
            @click="submitUpdate(scope.$index, scope.row)"
            type="primary"
            round
            size="small"
          >
            确认
          </el-button>
          <el-button
            v-if="showEdit[scope.$index]"
            @click="cancelUpdate(scope.$index)"
            type="primary"
            round
            size="small"
          >
            取消
          </el-button>
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
      getData: null
    }
  },
  created () {
    this.fetchData()
  },
  watch: {
    currentBranch: 'fetchData'
  },

  methods: {
    fetchData () {
      var xhr = new XMLHttpRequest()

      let self = this
      xhr.open('GET', 'http://127.0.0.1:8090/user/findAll')
      xhr.send(null)
      xhr.onload = function () {
        if (xhr.readyState === 4) {
          if ((xhr.status >= 200 && xhr.status < 300) || xhr.status === 304) {
            self.getData = JSON.parse(xhr.responseText)
          } else {
            console.error(xhr.status, xhr.statusText)
          }
        }
        // console.log(self.getData)
      }
    },
    showUpdate (index, row) {
      this.showEdit[index] = true
      this.$set(this.showEdit, index, true) // 这里要用$set方法，否则页面状态不更新
    },

    // 取消修改
    cancelUpdate (index) {
      this.$confirm('取消修改？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(() => {
          this.$set(this.showEdit, index, false)
          this.fetchData()
        })
        .catch(() => {
        })
    },

    submitUpdate (index, row) {
      this.$confirm('确认修改？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(() => {
          var xhr = new XMLHttpRequest()
          xhr.open('POST', 'http://127.0.0.1:8090/user/update', true)
          xhr.setRequestHeader('Content-Type', 'application/json')
          xhr.send(JSON.stringify(row))

          this.showEdit[index] = false
          this.$set(this.showEdit, index, false)
        })
        .catch(() => {
        })
    },
    addUser (row) {
      this.$confirm('确认修改？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(() => {
          var xhr = new XMLHttpRequest()
          xhr.open('POST', 'http://127.0.0.1:8090/user/update', true)
          xhr.setRequestHeader('Content-Type', 'application/json')
          xhr.send(JSON.stringify(row))
        })
        .catch(() => {
        })
    },

    deleteUser (row) {
      var xhr = new XMLHttpRequest()
      this.$confirm('删除不可以恢复,确认要删除?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        xhr.open('GET', 'http://127.0.0.1:8090/user/delete?id=' + row.id)
        xhr.send(null)
        location.reload()
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
    }

  }
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
