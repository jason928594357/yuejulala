<template>
  <v-card>
      <v-btn color="primary" @click="addCategory">新增分类</v-btn>
      <v-flex xs12 sm10>
        <v-tree url="/item/category/list"
                :isEdit="isEdit"
                @handleAdd="handleAdd"
                @handleEdit="handleEdit"
                @handleDelete="handleDelete"
                @handleClick="handleClick"
        />    
      </v-flex>
      <v-dialog max-width="500" v-model="show" persistent scrollable>
        <v-card>
          <!-- 对话框的标题 -->
          <v-toolbar dense dark color="primary">
            <v-toolbar-title>新增分类</v-toolbar-title>
            <v-spacer/>
            <v-btn icon @click="closeWindow"><v-icon>close</v-icon></v-btn>
          </v-toolbar>
          <v-card-text class="px-5" style="height:290px">
            <category-form @close="closeWindow" :isEdit="isEdit"/>
          </v-card-text>
        </v-card>
      </v-dialog>
  </v-card>
</template>

<script>
  import CategoryForm from './CategoryForm'
  export default {
    name: "category",
    data() {
      return {
        isEdit:true,
        show:false
      }
    },
    components:{
      CategoryForm
    },
    methods: {
      handleAdd(node) {
        console.log("add .... ");
        console.log(node);
      },
      handleEdit(id, name) {
        console.log("edit... id: " + id + ", name: " + name);
        this.$http({
          method: 'post',
          url: '/item/category/save',
          data: node
        }).then(() => {
          // 关闭窗口
          this.$emit("close");
          this.$message.success("保存成功！");
        }).catch(() => {
          this.$message.error("保存失败！");
        });
      },
      handleDelete(id) {
        console.log("delete ... " + id)
      },
      handleClick(node) {
        
      },
      addCategory(){
        this.isEdit = false;
        this.show = true;
      },
      closeWindow(){
        this.show = false;
      }
    }
  };
</script>

<style scoped>

</style>
