<template>
  <div class="login">
    <img src="../assets/logo.png">
    <h3>Login</h3>
    <form name="login" @submit.prevent="onSubmit" method="post">
      <div>
        <input
            v-model="username"
            name="username"
            type="text"
            placeholder="username"
            required>
      </div>

      <div>
        <input
            v-model="password"
            name="password"
            type="password"
            placeholder="password"
            required>
      </div>

      <!--      <button @click="loginSubmit">로그인</button>-->
      <button type="submit">로그인</button>
      <p>계정이 없다면 <router-link to="/signup">회원가입</router-link>을 먼저 진행해주세요!</p>
    </form>
    <!--    <button @click="goBack">뒤로가기</button>-->
  </div>
</template>

<script>
export default {
  data() {
    return {
      username: null,
      password: null
    }
  },

  methods: {
    onSubmit() {
      if (this.username !== null && this.password != null) {
        this.$router.push({path: './api/user/login'})
      }
    }
  }
}
</script>

<style scoped>
.login {
  margin-top: 40px;
}
input {
  margin: 10px 0;
  width: 20%;
  padding: 15px;
}
button {
  margin-top: 20px;
  width: 9%;
  cursor: pointer;
  background-color: #fddc96;
  border-style: solid;
  border-color: lightgray;
  border-radius: 5px;
  padding: 5px;
}
p {
  margin-top: 40px;
  font-size: 15px;
}
span {
  color: #ff1d1d;
}
p a {
  color: #fa9729;
  text-decoration: none;
  cursor: pointer;
}
</style>
