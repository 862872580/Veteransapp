<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" label-width="68px">
      <el-form-item label="工作职位" prop="workPosition">
        <el-input
          v-model="queryParams.workPosition"
          placeholder="请输入工作职位"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="全职/兼职/专职" prop="workType">
        <el-select v-model="queryParams.workType" placeholder="请选择全职/兼职/专职" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="最低薪资" prop="workMinsalary">
        <el-input
          v-model="queryParams.workMinsalary"
          placeholder="请输入最低薪资"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="最高薪资" prop="workMaxsalary">
        <el-input
          v-model="queryParams.workMaxsalary"
          placeholder="请输入最高薪资"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="市" prop="workCity">
        <el-input
          v-model="queryParams.workCity"
          placeholder="请输入市"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="区" prop="workDistrict">
        <el-input
          v-model="queryParams.workDistrict"
          placeholder="请输入区"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="电话" prop="workPhone">
        <el-input
          v-model="queryParams.workPhone"
          placeholder="请输入电话"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="邮箱" prop="workEmail">
        <el-input
          v-model="queryParams.workEmail"
          placeholder="请输入邮箱"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="职位优势" prop="workAdv">
        <el-input
          v-model="queryParams.workAdv"
          placeholder="请输入职位优势"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="公司id" prop="comId">
        <el-input
          v-model="queryParams.comId"
          placeholder="请输入公司id"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="工作地点" prop="workAddress">
        <el-input
          v-model="queryParams.workAddress"
          placeholder="请输入工作地点"
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
          v-hasPermi="['army:work:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['army:work:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['army:work:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['army:work:export']"
        >导出</el-button>
      </el-col>
    </el-row>

    <el-table v-loading="loading" :data="workList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="工作id" align="center" prop="workId" />
      <el-table-column label="工作职位" align="center" prop="workPosition" />
      <el-table-column label="全职/兼职/专职" align="center" prop="workType" />
      <el-table-column label="最低薪资" align="center" prop="workMinsalary" />
      <el-table-column label="最高薪资" align="center" prop="workMaxsalary" />
      <el-table-column label="市" align="center" prop="workCity" />
      <el-table-column label="区" align="center" prop="workDistrict" />
      <el-table-column label="电话" align="center" prop="workPhone" />
      <el-table-column label="邮箱" align="center" prop="workEmail" />
      <el-table-column label="职位优势" align="center" prop="workAdv" />
      <el-table-column label="薪资福利简述" align="center" prop="workSketch" />
      <el-table-column label="公司id" align="center" prop="comId" />
      <el-table-column label="工作地点" align="center" prop="workAddress" />
      <el-table-column label="是否启用" align="center" prop="status" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="修改之前的id" align="center" prop="previous" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['army:work:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['army:work:remove']"
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

    <!-- 添加或修改工作对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="工作职位" prop="workPosition">
          <el-input v-model="form.workPosition" placeholder="请输入工作职位" />
        </el-form-item>
        <el-form-item label="全职/兼职/专职">
          <el-select v-model="form.workType" placeholder="请选择全职/兼职/专职">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="最低薪资" prop="workMinsalary">
          <el-input v-model="form.workMinsalary" placeholder="请输入最低薪资" />
        </el-form-item>
        <el-form-item label="最高薪资" prop="workMaxsalary">
          <el-input v-model="form.workMaxsalary" placeholder="请输入最高薪资" />
        </el-form-item>
        <el-form-item label="市" prop="workCity">
          <el-input v-model="form.workCity" placeholder="请输入市" />
        </el-form-item>
        <el-form-item label="区" prop="workDistrict">
          <el-input v-model="form.workDistrict" placeholder="请输入区" />
        </el-form-item>
        <el-form-item label="电话" prop="workPhone">
          <el-input v-model="form.workPhone" placeholder="请输入电话" />
        </el-form-item>
        <el-form-item label="邮箱" prop="workEmail">
          <el-input v-model="form.workEmail" placeholder="请输入邮箱" />
        </el-form-item>
        <el-form-item label="职位优势" prop="workAdv">
          <el-input v-model="form.workAdv" placeholder="请输入职位优势" />
        </el-form-item>
        <el-form-item label="薪资福利简述" prop="workSketch">
          <el-input v-model="form.workSketch" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="公司id" prop="comId">
          <el-input v-model="form.comId" placeholder="请输入公司id" />
        </el-form-item>
        <el-form-item label="工作地点" prop="workAddress">
          <el-input v-model="form.workAddress" placeholder="请输入工作地点" />
        </el-form-item>
        <el-form-item label="是否启用">
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
import { listWork, getWork, delWork, addWork, updateWork, exportWork } from "@/api/army/work";

export default {
  name: "Work",
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
      // 工作表格数据
      workList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        workPosition: undefined,
        workType: undefined,
        workMinsalary: undefined,
        workMaxsalary: undefined,
        workCity: undefined,
        workDistrict: undefined,
        workPhone: undefined,
        workEmail: undefined,
        workAdv: undefined,
        comId: undefined,
        workAddress: undefined,
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
    /** 查询工作列表 */
    getList() {
      this.loading = true;
      listWork(this.queryParams).then(response => {
        this.workList = response.rows;
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
        workId: undefined,
        workPosition: undefined,
        workType: undefined,
        workMinsalary: undefined,
        workMaxsalary: undefined,
        workCity: undefined,
        workDistrict: undefined,
        workPhone: undefined,
        workEmail: undefined,
        workAdv: undefined,
        workSketch: undefined,
        comId: undefined,
        workAddress: undefined,
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
      this.ids = selection.map(item => item.workId)
      this.single = selection.length!=1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加工作";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const workId = row.workId || this.ids
      getWork(workId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改工作";
      });
    },
    /** 提交按钮 */
    submitForm: function() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.workId != undefined) {
            updateWork(this.form).then(response => {
              if (response.code === 200) {
                this.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              }
            });
          } else {
            addWork(this.form).then(response => {
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
      const workIds = row.workId || this.ids;
      this.$confirm('是否确认删除工作编号为"' + workIds + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delWork(workIds);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(function() {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有工作数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportWork(queryParams);
        }).then(response => {
          this.download(response.msg);
        }).catch(function() {});
    }
  }
};
</script>