<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" label-width="68px">
      <el-form-item label="姓名" prop="memName">
        <el-input
          v-model="queryParams.memName"
          placeholder="请输入姓名"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="性别" prop="memSex">
        <el-select v-model="queryParams.memSex" placeholder="请选择性别" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="年龄" prop="memBirthday">
        <el-date-picker clearable size="small" style="width: 200px"
          v-model="queryParams.memBirthday"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择年龄">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="学历" prop="memEducation">
        <el-input
          v-model="queryParams.memEducation"
          placeholder="请输入学历"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="手机号" prop="memPhone">
        <el-input
          v-model="queryParams.memPhone"
          placeholder="请输入手机号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="邮箱" prop="memEmail">
        <el-input
          v-model="queryParams.memEmail"
          placeholder="请输入邮箱"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="求职状态" prop="memJobstate">
        <el-input
          v-model="queryParams.memJobstate"
          placeholder="请输入求职状态"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="头像位置" prop="memPhoto">
        <el-input
          v-model="queryParams.memPhoto"
          placeholder="请输入头像位置"
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
          v-hasPermi="['army:mem:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['army:mem:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['army:mem:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['army:mem:export']"
        >导出</el-button>
      </el-col>
    </el-row>

    <el-table v-loading="loading" :data="memList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="用户id" align="center" prop="memId" />
      <el-table-column label="姓名" align="center" prop="memName" />
      <el-table-column label="性别" align="center" prop="memSex" />
      <el-table-column label="年龄" align="center" prop="memBirthday" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.memBirthday, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="学历" align="center" prop="memEducation" />
      <el-table-column label="手机号" align="center" prop="memPhone" />
      <el-table-column label="邮箱" align="center" prop="memEmail" />
      <el-table-column label="求职状态" align="center" prop="memJobstate" />
      <el-table-column label="头像位置" align="center" prop="memPhoto" />
      <el-table-column label="状态" align="center" prop="status" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="修改之前的id" align="center" prop="previous" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['army:mem:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['army:mem:remove']"
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

    <!-- 添加或修改用户对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="姓名" prop="memName">
          <el-input v-model="form.memName" placeholder="请输入姓名" />
        </el-form-item>
        <el-form-item label="性别">
          <el-select v-model="form.memSex" placeholder="请选择性别">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="年龄" prop="memBirthday">
          <el-date-picker clearable size="small" style="width: 200px"
            v-model="form.memBirthday"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择年龄">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="学历" prop="memEducation">
          <el-input v-model="form.memEducation" placeholder="请输入学历" />
        </el-form-item>
        <el-form-item label="手机号" prop="memPhone">
          <el-input v-model="form.memPhone" placeholder="请输入手机号" />
        </el-form-item>
        <el-form-item label="邮箱" prop="memEmail">
          <el-input v-model="form.memEmail" placeholder="请输入邮箱" />
        </el-form-item>
        <el-form-item label="求职状态" prop="memJobstate">
          <el-input v-model="form.memJobstate" placeholder="请输入求职状态" />
        </el-form-item>
        <el-form-item label="头像位置" prop="memPhoto">
          <el-input v-model="form.memPhoto" placeholder="请输入头像位置" />
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
import { listMem, getMem, delMem, addMem, updateMem, exportMem } from "@/api/army/mem";

export default {
  name: "Mem",
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
      // 用户表格数据
      memList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        memName: undefined,
        memSex: undefined,
        memBirthday: undefined,
        memEducation: undefined,
        memPhone: undefined,
        memEmail: undefined,
        memJobstate: undefined,
        memPhoto: undefined,
        status: undefined,
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
    /** 查询用户列表 */
    getList() {
      this.loading = true;
      listMem(this.queryParams).then(response => {
        this.memList = response.rows;
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
        memId: undefined,
        memName: undefined,
        memSex: undefined,
        memBirthday: undefined,
        memEducation: undefined,
        memPhone: undefined,
        memEmail: undefined,
        memJobstate: undefined,
        memPhoto: undefined,
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
      this.ids = selection.map(item => item.memId)
      this.single = selection.length!=1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加用户";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const memId = row.memId || this.ids
      getMem(memId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改用户";
      });
    },
    /** 提交按钮 */
    submitForm: function() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.memId != undefined) {
            updateMem(this.form).then(response => {
              if (response.code === 200) {
                this.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              }
            });
          } else {
            addMem(this.form).then(response => {
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
      const memIds = row.memId || this.ids;
      this.$confirm('是否确认删除用户编号为"' + memIds + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delMem(memIds);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(function() {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有用户数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportMem(queryParams);
        }).then(response => {
          this.download(response.msg);
        }).catch(function() {});
    }
  }
};
</script>