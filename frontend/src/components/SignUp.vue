<template>
  <div class="signUp">
    <img src="../assets/logo.png">
    <h3>Sign Up</h3>
    <form name="signUp" @submit.prevent="onSubmit" method="post">
      <div>
        <input
          v-model="signUp.id"
          name="id"
          type="text"
          maxlength="12"
          clearable="true"
          placeholder="*id"
          required>
        <p v-show="errorId" class="input-error">
          아이디는 영문을 포함한 4~12자이어야 합니다.
        </p>
      </div>

      <div>
        <input
          v-model="signUp.pwd"
          name="pwd"
          type="password"
          maxlength="20"
          clearable="true"
          placeholder="*password"
          required>
        <p v-show="errorPwd" class="input-error">
          비밀번호는 영문과 숫자를 포함한 8~20자이어야 합니다.
        </p>
      </div>

      <div>
        <input
          v-model="signUp.pwdCheck"
          name="pwdCheck"
          type="password"
          maxlength="16"
          placeholder="*password check">
        <p v-show="errorPwdCheck">
          비밀번호가 동일하지 않습니다.
        </p>
      </div>

      <div>
        <input
          v-model="signUp.username"
          name="username"
          type="text"
          maxlength="20"
          clearable="true"
          placeholder="*name"
          required>
        <p v-show="errorUsername" class="input-error">
          이름이 올바르지 않습니다.
        </p>
      </div>

      <div>
        <input
          v-model="signUp.email"
          name="email"
          type="email"
          clearable="true"
          placeholder="*email"
          required>
        <p v-show="errorEmail" class="input-error">
          이메일 형식이 올바르지 않습니다.
        </p>
      </div>

      <div>
      <input
        v-model="signUp.birth"
        name="birth"
        type="date"
        data-placeholder="*birth"
        aria-required="true"
        required>
      </div>

      <div>
        <input
          v-model="signUp.phone"
          maxlength="13"
          @keyup="getPhoneMask(signUp.phone)"
          clearable="true"
          placeholder="*phone (  -  생략하고 입력)"
          required>
        <p v-show="errorPhone" class="input-error">
          전화번호 형식이 올바르지 않습니다.
        </p>
      </div>
<!--      <div>
        <input
          v-model="signUp.phone"
          name="phone"
          maxlength="13"
          clearable="true"
          placeholder="*phone (  -  생략하고 입력)"
          required>
        <p v-show="errorPhone" class="input-error">
          전화번호 형식이 올바르지 않습니다.
        </p>
      </div>-->

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
export default {
  //name: 'signUp'
  data() {
    return {
      signUp: {
        id: null,
        pwd: null,
        pwdCheck: null,
        username: null,
        email: null,
        birth: null,
        phone: null
      },
      errorId: null,
      errorPwd: null,
      errorPwdCheck: null,
      errorUsername: null,
      errorEmail: null,
      errorPhone: null
    }
  },
  watch: {
    'signUp.id': function () {
      this.checkId()
    },

    'signUp.pwd': function () {
      this.checkPwd()
    },

    'signUp.pwdCheck': function () {
      this.checkPwdCheck()
    },

    'signUp.username': function () {
      this.checkUsername()
    },

    'signUp.email': function () {
      this.checkemail()
    },

    'signUp.phone': function () {
      this.checkPhone()
    }
  },
  methods: {
    checkId() {
      // 아이디 형식 검사
      const validateId = /^[A-Za-z0-9]{4,12}$/

      if (!validateId.test(this.signUp.id) || !this.signUp.id) {
        this.errorId = true
        return
      }
      this.errorId = false
    },

    checkPwd() {
      // 비밀번호 형식 검사
      const validateId = /^(?=.*[A-Za-z])(?=.*[0-9]).{8,20}$/

      if (!validateId.test(this.signUp.pwd) || !this.signUp.pwd) {
        this.errorPwd = true
        return
      }
      this.errorPwd = false
    },

    checkPwdCheck() {
      // 비밀번호 확인 검사
      if (this.signUp.pwd != this.signUp.pwdCheck) {
        this.errorPwdCheck = true
        return
      }
      this.errorPwdCheck = false
    },

    checkUsername() {
      // 이름 형식 검사
      const validateId = /^[A-Za-z가-힣]{1,6}$/

      if (
        !validateId.test(this.signUp.username) ||
        !this.signUp.username
      ) {
        this.errorUsername = true
        return
      }
      this.errorUsername = false
    },

    checkemail() {
      // 이메일 형식 검사
      const validateId =
        /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i

      if (!validateId.test(this.signUp.email) || !this.signUp.email) {
        this.errorEmail = true
        return
      }
      this.errorEmail = false
    },

    checkPhone() {
      // 휴대전화번호 형식 검사
      const validateId = /^01([0|1|6|7|8|9]?)*-([0-9]{3,4})*-([0-9]{4})$/

      if (!validateId.test(this.signUp.phone) || !this.signUp.phone) {
        this.errorPhone = true
        return
      }
      this.errorPhone = false
    },

    getPhoneMask(val) {
      let res = this.getMask(val)
      this.signUp.phone = res
      //서버 전송 값에는 '-' 를 제외하고 숫자만 저장
      this.model.signUp.phone = this.signUp.phone.replace(/[^0-9]/g, '')
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

    onSubmit() {
      this.$router.push({ name: 'SignUpSuccess', params: {signUp: this.signUp}})
    },

    /*onReset() {

    }*/

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
