<template>
  <div id="app">
    <MainMap/>
    <SideBar class="side-bar"/>
    <router-view/>
  </div>
</template>

<script>
import SideBar from "@/components/SideBar"
import MainMap from '@/components/MainMap'

export default {
  name: 'App',
  components: {
    SideBar,
    MainMap
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
  position: absolute;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;

  > .side-bar{
    position: absolute;
    left: 0;
    top: 0;
    bottom: 0;
  }
}
</style>
