<template>
  <!--<div class="login-container">-->
    <!--<h1>{{pageName}}</h1>-->
  <!--</div>-->
  <div class="app-container">
      <el-row>
        <el-col :span="6">
          <el-input style="width:200px;" v-model="tableQuery.rname" placeholder="请输入"></el-input>
          <span style="margin-right: 15px;"></span>
          <el-tooltip class="item" content="搜索" placement="top">
            <el-button icon="el-icon-search" circle @click="fetchData()"></el-button>
          </el-tooltip>
        </el-col>
        <el-col :span="4" class="text-center">
          <router-link class="pan-btn pink-btn" to="">Excel导出</router-link>
        </el-col>
      </el-row>
    <div style="margin-top: 30px"></div>
    <el-table
      :data="tableData"
      border
      style="width: 100%;"
      v-loading="loading"
      element-loading-text="拼命加载中"
      element-loading-spinner="el-icon-loading"
      element-loading-background="rgba(0, 0, 0, 0.8)"
    >
      <el-table-column
      v-for="(item, index) in tableHead"
      :key="index"
      align="center"
      :prop="item.prop"
      :label="item.label"
      >
      </el-table-column>
    </el-table>

    <!--分页-->
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="tablePage.current"
      :page-sizes="[10, 20, 30, 40, 50]"
      :page-size="tablePage.size"
      layout="total, sizes, prev, pager, next, jumper"
      :total="tablePage.total">
    </el-pagination>
  </div>

</template>

<script>
  import contentApi from "@/api/content";
  export default {
    name: 'Menu1',
    data() {
      return {
        tableLoading:false,
        pageName: '菜单1',
        tableQuery: {
          rname: ''
      },
        tableData: [],
        tabelHead: [],
        tablePage: {
          current: null,
          pages: null,
          size:null,
          total: null
        }
      }
    },
    mothods: {
      //分页
      handleSizeChange(val) {
        this.tablePage.size = val;
        this.fetchData();
      },
      handleCurrentChange(val) {
        this.tablePage.current = val;
        this.fetchData();
      },
      //查询
      fetchData() {
        this.tableLoading = true
        contentApi.queryData(this.tableQuery,this.tablePage).then(res => {
          this.tableData = res.data.page.records
          this.tableLoading = false
          //设置后台返回的分页参数
          pageParamNames.forEach(name=>this.$set(this.tablePage,name,res.data.page[name]))
        })
      },
    }
  }
</script>

