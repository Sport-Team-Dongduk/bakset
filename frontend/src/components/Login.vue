<template>
  <div class="login">
    <img src="../assets/logo.png">
    <h3>Login</h3>
    <form name="login" @submit.prevent="onSubmit" method="post">
      <div>
        <input
          v-model="login.id"
          name="id"
          type="text"
          placeholder="id"
          required>
        <br>
        <span v-show="errorId" class="input-error">
          아이디는 영문을 포함한 4~12자이어야 합니다.
        </span>
      </div>

      <div>
        <input
          v-model="login.pwd"
          name="pwd"
          type="password"
          placeholder="password"
          required>
        <br>
        <span v-show="errorPwd" class="input-error">
          비밀번호는 영문과 숫자를 포함한 8~20자이어야 합니다.
        </span>
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
  //name: 'login',
  data() {
    return {
      login: {
        id: null,
        pwd: null
      },
      errorId: null,
      errorPwd: null
    }
  },

  watch: {
    'login.id': function () {
      this.checkId()
    },
    'login.pwd': function () {
      this.checkPwd()
    }
  },

  methods: {
    checkId() {
      // 아이디 형식 검사
      const validateId = /^[A-Za-z0-9]{4,12}$/

      if (!validateId.test(this.login.id) || !this.login.id) {
        this.errorId = true
        return
      }
      this.errorId = false
    },

    checkPwd() {
      // 비밀번호 형식 검사
      const validateId = /^(?=.*[A-Za-z])(?=.*[0-9]).{8,20}$/

      if (!validateId.test(this.login.pwd) || !this.login.pwd) {
        this.errorPwd = true
        return
      }
      this.errorPwd = false
    },

    onSubmit() {
      if (this.login.id !== null && this.login.pwd != null) {
        this.$router.push({name: 'LoginSuccess2', params: {login: this.login}})
      }
    },

    goBack() {
      this.$router.go(-1)
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
