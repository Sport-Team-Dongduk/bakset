<template>
  <div>
    <h1>회원가입이 완료되었습니다!</h1>
    <h2>id: {{ $route.params.signUp.id }}</h2>
    <h2>pwd: {{ $route.params.signUp.pwd }}</h2>
    <h2>pwdCheck: {{ $route.params.signUp.pwdCheck }}</h2>
    <h2>username: {{ $route.params.signUp.username }}</h2>
    <h2>email: {{ $route.params.signUp.email }}</h2>
    <h2>birth: {{ $route.params.signUp.birth }}</h2>
    <h2>phone: {{ $route.params.signUp.phone }}</h2>
  </div>
</template>

<script>
/*export default {
  name: "Params",
  props: {
    name: {
      type: String,
      default: "",
    },
  }
}*/
</script>
