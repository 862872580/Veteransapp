<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" label-width="68px">
      <el-form-item label="用户id" prop="memId">
        <el-input
          v-model="queryParams.memId"
          placeholder="请输入用户id"
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
      <el-form-item label="开始时间" prop="beginTime">
        <el-date-picker clearable size="small" style="width: 200px"
          v-model="queryParams.beginTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择开始时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="结束时间" prop="endTime">
        <el-date-picker clearable size="small" style="width: 200px"
          v-model="queryParams.endTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择结束时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="职位" prop="workexpPosition">
        <el-input
          v-model="queryParams.workexpPosition"
          placeholder="请输入职位"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="薪资" prop="workexpSalary">
        <el-input
          v-model="queryParams.workexpSalary"
          placeholder="请输入薪资"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否启用" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择是否启用" clearable size="small">
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
          v-hasPermi="['army:workexp:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['army:workexp:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['army:workexp:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['army:workexp:export']"
        >导出</el-button>
      </el-col>
    </el-row>

    <el-table v-loading="loading" :data="workexpList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="是否启用" align="center" prop="workexpId" />
      <el-table-column label="用户id" align="center" prop="memId" />
      <el-table-column label="公司名称" align="center" prop="comName" />
      <el-table-column label="开始时间" align="center" prop="beginTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.beginTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="结束时间" align="center" prop="endTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.endTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="职位" align="center" prop="workexpPosition" />
      <el-table-column label="工作内容" align="center" prop="workexpContent" />
      <el-table-column label="薪资" align="center" prop="workexpSalary" />
      <el-table-column label="是否启用" align="center" prop="status" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['army:workexp:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['army:workexp:remove']"
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

    <!-- 添加或修改工作经历对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="用户id" prop="memId">
          <el-input v-model="form.memId" placeholder="请输入用户id" />
        </el-form-item>
        <el-form-item label="公司名称" prop="comName">
          <el-input v-model="form.comName" placeholder="请输入公司名称" />
        </el-form-item>
        <el-form-item label="开始时间" prop="beginTime">
          <el-date-picker clearable size="small" style="width: 200px"
            v-model="form.beginTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择开始时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="结束时间" prop="endTime">
          <el-date-picker clearable size="small" style="width: 200px"
            v-model="form.endTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择结束时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="职位" prop="workexpPosition">
          <el-input v-model="form.workexpPosition" placeholder="请输入职位" />
        </el-form-item>
        <el-form-item label="工作内容" prop="workexpContent">
          <el-input v-model="form.workexpContent" placeholder="请输入工作内容" />
        </el-form-item>
        <el-form-item label="薪资" prop="workexpSalary">
          <el-input v-model="form.workexpSalary" placeholder="请输入薪资" />
        </el-form-item>
        <el-form-item label="是否启用">
          <el-radio-group v-model="form.status">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
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
import { listWorkexp, getWorkexp, delWorkexp, addWorkexp, updateWorkexp, exportWorkexp } from "@/api/army/workexp";

export default {
  name: "Workexp",
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
      // 工作经历表格数据
      workexpList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        memId: undefined,
        comName: undefined,
        beginTime: undefined,
        endTime: undefined,
        workexpPosition: undefined,
        workexpSalary: undefined,
        status: undefined
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        memId: [
          { required: true, message: "用户id不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询工作经历列表 */
    getList() {
      this.loading = true;
      listWorkexp(this.queryParams).then(response => {
        this.workexpList = response.rows;
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
        workexpId: undefined,
        memId: undefined,
        comName: undefined,
        beginTime: undefined,
        endTime: undefined,
        workexpPosition: undefined,
        workexpContent: undefined,
        workexpSalary: undefined,
        updateTime: undefined,
        createTime: undefined,
        status: "0"
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
      this.ids = selection.map(item => item.workexpId)
      this.single = selection.length!=1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加工作经历";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const workexpId = row.workexpId || this.ids
      getWorkexp(workexpId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改工作经历";
      });
    },
    /** 提交按钮 */
    submitForm: function() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.workexpId != undefined) {
            updateWorkexp(this.form).then(response => {
              if (response.code === 200) {
                this.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              }
            });
          } else {
            addWorkexp(this.form).then(response => {
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
      const workexpIds = row.workexpId || this.ids;
      this.$confirm('是否确认删除工作经历编号为"' + workexpIds + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delWorkexp(workexpIds);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(function() {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有工作经历数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportWorkexp(queryParams);
        }).then(response => {
          this.download(response.msg);
        }).catch(function() {});
    }
  }
};
</script>