<script setup>

</script>

<template>
  <div class="home">
    <div id="nav">
      <router-link to="/hello">소개</router-link> |
      <router-link to="/signup">회원가입</router-link> |
      <router-link to="/login">로그인</router-link>
    </div>
    <img alt="Vue logo" src="../assets/logo.png">
  </div>
</template>

<style scoped>
a {
  color: #fa9729;
  text-decoration: none;
  cursor: pointer;
}
</style>
