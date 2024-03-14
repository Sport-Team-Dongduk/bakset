import Vue from 'vue'
import Router from 'vue-router'

import Home from "../components/Home.vue";
import HelloWorld from '@/components/HelloWorld'
import Login from '@/components/Login'
import SignUp from '@/components/SignUp'
import LoginSuccess from "../components/LoginSuccess.vue";
import SignUpSuccess from "../components/SignUpSuccess.vue";

Vue.use(Router)

export default new Router({
    mode: 'history',
    routes: [
        {
            path: '/',
            name: 'Home',
            component:() => import("@/components/Home")
        },
        {
            path: '/hello',
            name: 'HelloWorld',
            component:() => import("@/components/HelloWorld")
        },
        /*{
            path: '/login',
            name: 'Login',
            component:() => import("@/components/Login")
        },*/
        {
            path: '/login',
            name: 'Login',
            component:() => import("@/components/LoginForm.vue")
        },
        {
            path: '/login2',
            name: 'Login2',
            component:() => import("@/components/Login2")
        },
        {
            path: '/signup',
            name: 'SignUp',
            component:() => import("@/components/SignUp")
        },
        {
            path: '/signupform',
            name: 'SignUpForm',
            component:() => import("@/components/SignUpForm.vue")
        },
        {
            path: '/loginsuceess',
            name: 'LoginSuccess',
            component:() => import("@/components/LoginSuccess")
        },
        {
            path: '/loginsuceess2',
            name: 'LoginSuccess2',
            component:() => import("@/components/LoginSuccess2")
        },
        {
            path: '/signupsuccess',
            name: 'SignUpSuccess',
            component:() => import("@/components/SignUpSuccess")
        },
        {
            path: '/signup2',
            name: 'SingUp2',
            component:() => import("@/components/SignUp2")
        },
        {
            path: '/fronttest',
            name: 'FrontTest',
            component:() => import("@/components/FrontTest")
        }
    ]
})
