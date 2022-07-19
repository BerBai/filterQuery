<template>
  <div class="home">
    <vue-query-builder :rules="rules" v-model="query"></vue-query-builder>
    <br>
    <el-button type="primary" @click="getData(query)">获取数据</el-button>

    <common-table
      :tableData="tableData"
      :tableLabel="tableLabel"
    ></common-table>
  </div>
</template>

<script>
import VueQueryBuilder from "vue-query-builder";
import CommonTable from "../components/CommonTable";

export default {
  name: "Home",
  components: { VueQueryBuilder, CommonTable },
  data() {
    return {
      query: {},
      rules: [
        {
          type: "text",
          id: "id",
          label: "Id",
        },
        {
          type: "text",
          id: "name",
          label: "Name",
        },
        {
          type: "text",
          id: "age",
          label: "Age",
        },
        {
          type: "text",
          id: "sex",
          label: "Sex",
        },
        {
          type: "text",
          id: "address",
          label: "Address",
        },
      ],
      tableData: [],
      tableLabel: [
        {
          label: "id",
          prop: "id",
          show: true
        },
        {
          label: "姓名",
          prop: "name",
          show: true
        },
        {
          label: "年龄",
          prop: "age",
          show: true
        },
        {
          label: "性别",
          prop: "sex",
          show: true
        },
        {
          label: "地址",
          prop: "address",
          show: true
        },
      ],
    };
  },
  methods: {
    getData(query) {
      this.$axios
        .post("/filter/query", query
        // {          query: query,}
        )
        .then((response) => {
          this.tableData = response.data;
        });
    },
  },
};
</script>

<style>
</style>