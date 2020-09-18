<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" label-width="68px">
      <el-form-item label="公司账号" prop="comname">
        <el-input
          v-model="queryParams.comname"
          placeholder="请输入公司账号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="公司密码" prop="compassword">
        <el-input
          v-model="queryParams.compassword"
          placeholder="请输入公司密码"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="公司名称" prop="comName">
        <el-input
          v-model="queryParams.comName"
          placeholder="请输入公司名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="公司规模" prop="comScale">
        <el-input
          v-model="queryParams.comScale"
          placeholder="请输入公司规模"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="行业" prop="comIndustry">
        <el-input
          v-model="queryParams.comIndustry"
          placeholder="请输入行业"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择状态" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="修改之前的id" prop="previous">
        <el-input
          v-model="queryParams.previous"
          placeholder="请输入修改之前的id"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['army:com:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['army:com:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['army:com:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['army:com:export']"
        >导出</el-button>
      </el-col>
    </el-row>

    <el-table v-loading="loading" :data="comList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="公司id" align="center" prop="comId" />
      <el-table-column label="公司名称" align="center" prop="comName" />
      <el-table-column label="公司规模" align="center" prop="comScale" />
      <el-table-column label="行业" align="center" prop="comIndustry" />
      <el-table-column label="地址" align="center" prop="comAddress" />
      <el-table-column label="公司介绍" align="center" prop="comSketch" />
      <el-table-column label="法人" align="center" prop="comBoss" />
      <el-table-column label="产品介绍" align="center" prop="comProduct" />
      <el-table-column label="公司照片" align="center" prop="comPhoto" />
      <el-table-column label="状态" align="center" prop="status" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['army:com:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['army:com:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改公司对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="公司账号" prop="comname">
          <el-input v-model="form.comname" placeholder="请输入公司账号" />
        </el-form-item>
        <el-form-item label="公司密码" prop="compassword">
          <el-input v-model="form.compassword" placeholder="请输入公司密码" />
        </el-form-item>
        <el-form-item label="公司名称" prop="comName">
          <el-input v-model="form.comName" placeholder="请输入公司名称" />
        </el-form-item>
        <el-form-item label="公司规模" prop="comScale">
          <el-input v-model="form.comScale" placeholder="请输入公司规模" />
        </el-form-item>
        <el-form-item label="行业" prop="comIndustry">
          <el-input v-model="form.comIndustry" placeholder="请输入行业" />
        </el-form-item>
        <el-form-item label="地址" prop="comAddress">
          <el-input v-model="form.comAddress" placeholder="请输入地址" />
        </el-form-item>
        <el-form-item label="公司介绍" prop="comSketch">
          <el-input v-model="form.comSketch" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="法人" prop="comBoss">
          <el-input v-model="form.comBoss" placeholder="请输入法人" />
        </el-form-item>
        <el-form-item label="产品介绍" prop="comProduct">
          <el-input v-model="form.comProduct" placeholder="请输入产品介绍" />
        </el-form-item>
        <el-form-item label="公司照片" prop="comPhoto">
          <el-input v-model="form.comPhoto" placeholder="请输入公司照片" />
        </el-form-item>
        <el-form-item label="状态">
          <el-radio-group v-model="form.status">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="修改之前的id" prop="previous">
          <el-input v-model="form.previous" placeholder="请输入修改之前的id" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listCom, getCom, delCom, addCom, updateCom, exportCom } from "@/api/army/com";

export default {
  name: "Com",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 总条数
      total: 0,
      // 公司表格数据
      comList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        comname: undefined,
        compassword: undefined,
        comName: undefined,
        comScale: undefined,
        comIndustry: undefined,
        status: undefined,
        previous: undefined
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询公司列表 */
    getList() {
      this.loading = true;
      listCom(this.queryParams).then(response => {
        this.comList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        comId: undefined,
        comname: undefined,
        compassword: undefined,
        comName: undefined,
        comScale: undefined,
        comIndustry: undefined,
        comAddress: undefined,
        comSketch: undefined,
        comBoss: undefined,
        comProduct: undefined,
        comPhoto: undefined,
        createTime: undefined,
        updateTime: undefined,
        status: "0",
        remark: undefined,
        previous: undefined
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.comId)
      this.single = selection.length!=1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加公司";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const comId = row.comId || this.ids
      getCom(comId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改公司";
      });
    },
    /** 提交按钮 */
    submitForm: function() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.comId != undefined) {
            updateCom(this.form).then(response => {
              if (response.code === 200) {
                this.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              }
            });
          } else {
            addCom(this.form).then(response => {
              if (response.code === 200) {
                this.msgSuccess("新增成功");
                this.open = false;
                this.getList();
              }
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const comIds = row.comId || this.ids;
      this.$confirm('是否确认删除公司编号为"' + comIds + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delCom(comIds);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(function() {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有公司数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportCom(queryParams);
        }).then(response => {
          this.download(response.msg);
        }).catch(function() {});
    }
  }
};
</script>