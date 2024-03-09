<template>
  <div class="signUp">
    <img src="../assets/logo.png">
    <h3>Sign Up</h3>
    <form name="signUp" @submit.prevent="onSubmit" method="post">
      <div>
        <input
            v-model="username"
            name="username"
            type="text"
            maxlength="12"
            clearable="true"
            placeholder="*username"
            required>
      </div>

      <div>
        <input
            v-model="password1"
            name="password1"
            type="password"
            maxlength="20"
            clearable="true"
            placeholder="*password"
            required>
      </div>

      <div>
        <input
            v-model="password2"
            name="password2"
            type="password"
            maxlength="20"
            placeholder="*password check">
      </div>

      <div>
        <input
            v-model="email"
            name="email"
            type="email"
            clearable="true"
            placeholder="*email"
            required>
      </div>

      <button type="reset">재작성</button>
      <!--    <button type="submit"
            :disabled="signUp.id && signUp.pwd && signUp.username && signUp.email && signUp.phone === ''">
            가입하기
          </button>-->
      <button type="submit">가입하기</button>
      <span>또는 <router-link to="/login">로그인</router-link>으로 돌아가기</span>
    </form>
  </div>
</template>

<script>
import axios from "axios";

export default {
  //name: 'signUp'
  data() {
    return {
      username: '',
      password1: '',
      password2: '',
      email: '',
    }
  },
  methods: {
    onSubmit: function () {
      console.log("아이디 : " + this.username);
      const url = '/api/user/signup'
      const data = {
        username: this.username,
        password1: this.password1,
        password2: this.password2,
        email: this.email
      }

      axios.post(url, data)
          .then(function (response) {
            console.log(response);
          })
          .catch(function (error) {
            console.log(error);
          });

      /*try {
        axios.post("/api/hello", JSON.stringify(data), {
          headers: {
            "Content-Type": `application/json`,
          },
        })
            .then((response) => {
              console.log(response)
              if (response.data.errorCode === 400) {
                alert(response.data.errorMessage)

              }
              else{
                alert("회원가입이 완료되었습니다. 로그인 화면으로 돌아갑니다")
                this.$router.push({path: './login'});
              }
            })
            .catch(error =>{
              console.log(error.response);

            });
      } catch (error) {
        console.error(error);
      }
    }*/

      /*onReset() {}*/
    }
  }
}
</script>

<style scoped>
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
  color: #ff1d1d;
  margin: -1px;
}
span {
  display: block;
  margin-top: 20px;
  font-size: 15px;
}
input[type='date'] {
  font-weight: 600;
}
input[type='date']::before {
  content: attr(data-placeholder);
  width: 100%;
  color: #848484;
  letter-spacing: -2px;
}
input[type='date']:focus::before,
input[type='date']:valid::before {
  display: none;
  color: #848484;
}
label {
  position: relative;
}
span a {
  color: #fa9729;
  text-decoration: none;
  cursor: pointer;
}
</style>
