<template>
  <div class="common-table">
    <div>
      <label>请选择表格需要展示的列：</label>
      <el-checkbox-group v-model="checkedTableLabels">
        <el-checkbox
          v-for="item in tableLabel"
          :key="item.prop"
          :label="item.prop"
          >{{ item.label }}</el-checkbox
        >
      </el-checkbox-group>
    </div>
    <el-table :data="tableData" stripe :border="true" style="width: 100%">
      <el-table-column
        :resizable="true"
        show-overflow-tooltip
        v-for="item in bindTableLabels"
        :key="item.prop"
        :label="item.label"
        :prop="item.prop"
        align="center"
      >
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  name: "CommonTable",
  props: {
    tableData: Array,
    tableLabel: Array,
  },
  data() {
    return {};
  },
  methods: {},
  computed: {
    bindTableLabels() {
      return this.tableLabel.filter((item) => item.show);
    },
    checkedTableLabels: {
      get() {
        return this.bindTableLabels.map((item) => item.prop);
      },
      set(checked) {
        this.tableLabel.forEach((item, index) => {
          if (checked.includes(item.prop)) {
            item.show = true;
          } else {
            item.show = false;
          }
        });
      },
    },
  },
};
</script>

<style scoped>
</style>