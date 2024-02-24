<template>
  <form  name="signupForm" class="sign-up" @submit="onSubmit" @reset="onReset">
    <img src="../assets/logo.png">
    <h3>Sign Up</h3>

    <input
      v-model="signup.id"
      type="text"
      maxlength="20"
      @blur="idValid"
      placeholder="*id">
    <br>
    <div id="valid" v-if="!idValidFlag">
      5~20자 영문+숫자를 입력하세요.
    </div>

    <input
      v-model="signup.password"
      type="password"
      maxlength="16"
      @blur="passwordValid"
      placeholder="*password">
    <br>
    <div id="valid" v-if="!passwordValidFlag">
      8~16자 영문+숫자를 입력하세요.
    </div>

    <input
      v-model="signup.passwordCheck"
      type="password"
      @blur="passwordCheckValid"
      maxlength="16"
      placeholder="*password check">
    <div id ="valid" v-if="!passwordCheckFlag">
      비밀번호가 동일하지 않습니다.
    </div>
    <br>

    <input
      v-model="signup.name"
      type="text"
      maxlength="20"
      placeholder="*name">
    <br>

    <input width="10%"
      type="text">@
    <input width="10%"
    type="text">
    <br>

    <input
      v-model="signup.birth"
      type="date"
      data-placeholder="*birth"
      required
      aria-required="true">
    <br>

    <input
      v-model="signup.tel"
      type="text"
      maxlength="13"
      @keyup="getPhoneMask(signup.tel)"
      placeholder="*tel">
    <br>

    <button type="reset">재작성</button>
    <button
      :disabled="nextPageDisabledFlag">
<!--
      v-on:click="signUpSubmit"
-->
      가입하기
    </button>

    <span>또는 <router-link to="/login">로그인</router-link>으로 돌아가기</span>
    <button v-on:click="goBack">뒤로 가기</button>
  </form>
</template>

<script>
export default {
  name: 'signUp',
  data() {
    return {
      signup: {
        id: null,
        password: null,
        passwordCheck: null,
        name: null,
        birth: null,
        tel: null
      },
      idValidFlag: true,
      passwordValidFlag: true,
      passwordCheckFlag: true
    }
  },
  computed: {
    /*idValid () {
      return /^[A-Za-z0-9]*$/.test(this.signup.id)
    },*/
    /*idValid() {
      return /^[A-Za-z0-9]{5,20}$/.test(this.signup.id)
    },*/
    /*passwordValid() {
      return /^[A-Za-z0-9]{8,20}$/.test(this.signup.password)
    },*/
    nextPageDisabledFlag() {
      if (
        this.signup.id == null ||
        this.signup.password == null ||
        this.signup.passwordCheck == null ||
        this.signup.name == null ||
        this.signup.birth == null
      ) {
        return true;
      }
      if (!this.idValid || !this.passwordValidFlag || !this.passwordCheckFlag) {
        return true;
      }
      return false;
    }
  },
  methods: {
    idValid() {
      if (/^(?=.*[a-z]).{4,12}$/.test(this.signup.id)) {
        this.idValidFlag = true;
      } else {
        this.idValidFlag = false;
      }
    },
    passwordValid() {
      if (/^(?=.*[a-z])(?=.*[0-9]).{4,12}$/.test(this.signup.password)) {
        this.passwordValidFlag = true;
      } else {
        this.passwordValidFlag = false;
      }
    },
    passwordCheckValid () {
      if (this.signup.password == this.signup.passwordCheck) {
        this.passwordCheckFlag = true
      } else {
        this.passwordCheckFlag = false
      }
    },
    getPhoneMask(val) {
      let res = this.getMask(val)
      this.signup.tel = res
      //서버 전송 값에는 '-' 를 제외하고 숫자만 저장
      this.model.signup.tel = this.signup.tel.replace(/[^0-9]/g, '')
    },

    getMask( phoneNumber ) {
      if(!phoneNumber) return phoneNumber
      phoneNumber = phoneNumber.replace(/[^0-9]/g, '')

      let res = ''
      if(phoneNumber.length < 3) {
        res = phoneNumber
      }
      else {
        if(phoneNumber.substr(0, 2) =='02') {

          if(phoneNumber.length <= 5) {//02-123-5678
            res = phoneNumber.substr(0, 2) + '-' + phoneNumber.substr(2, 3)
          }
          else if(phoneNumber.length > 5 && phoneNumber.length <= 9) {//02-123-5678
            res = phoneNumber.substr(0, 2) + '-' + phoneNumber.substr(2, 3) + '-' + phoneNumber.substr(5)
          }
          else if(phoneNumber.length > 9) {//02-1234-5678
            res = phoneNumber.substr(0, 2) + '-' + phoneNumber.substr(2, 4) + '-' + phoneNumber.substr(6)
          }

        } else {
          if(phoneNumber.length < 8) {
            res = phoneNumber
          }
          else if(phoneNumber.length == 8)
          {
            res = phoneNumber.substr(0, 4) + '-' + phoneNumber.substr(4)
          }
          else if(phoneNumber.length == 9)
          {
            res = phoneNumber.substr(0, 3) + '-' + phoneNumber.substr(3, 3) + '-' + phoneNumber.substr(6)
          }
          else if(phoneNumber.length == 10)
          {
            res = phoneNumber.substr(0, 3) + '-' + phoneNumber.substr(3, 3) + '-' + phoneNumber.substr(6)
          }
          else if(phoneNumber.length > 10) { //010-1234-5678
            res = phoneNumber.substr(0, 3) + '-' + phoneNumber.substr(3, 4) + '-' + phoneNumber.substr(7)
          }
        }
      }

      return res
    },
    signUpSubmit() {
      if (this.signup.id !== null && this.signup.password != null)
        this.$router.push({ name: 'HelloWorld', params: {signup: this.signup}})
        //this.$router.push({path:'hello', params: {signup: this.signup}})
      //console.log(this.signup.id, this.signup.password)
      //localStorage.setItem(this.id, this.password)
      //this.$router.push({ name: 'signup', params: { id: this.id } })
      //this.$router.push('hello')
    },
    onSubmit() {
      this.$router.push({ name: 'HelloWorld', params: {signup: this.signup}})
    },
    onReset() {

    },
    goBack() {
      this.$router.go(-1)
    }
  }
}
</script>

<script setup>
</script>

<style scoped>
.signUp {
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
  font-size: 20px;
}
span {
  display: block;
  margin-top: 20px;
  font-size: 15px;
}
#valid {
  color: #ff1d1d
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
</style>
