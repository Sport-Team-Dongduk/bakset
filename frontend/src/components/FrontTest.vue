<template>
    <div>
      <input type="text" v-model="b1" name="b1" placeholder="1 or 2">
      <button @click="button">Click</button>
      <p>{{a}}</p>
      <button @click="postBtn">PostClick</button>
      <p>{{c}}</p>
    </div>
</template>

<script>
import axios from "axios";

export default {
  name: 'FrontTest',
  data: () => ({
    b1: '',
    a: '',
    c: ''
  }),
  methods: {
    button () {
      this.axios.get('/api/example', {params: {tEst:this.b1} }).then(result => {
        console.log(result.data)
        this.a = result.data
      })
    },
    postBtn () {
      const fd = new FormData()
      fd.append('demo', this.b1)
      this.axios.post('/api/example2', fd).then(result => {
        this.c = result.data
      })
    }
  }
}
</script>