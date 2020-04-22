import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../view/Login.vue'
import Home from '../view/Home'
Vue.use(VueRouter)

  const routes = [
      { path: '/', name: 'Login', component: Login, hidden: true },
      { path: '/home', name: 'Home', component: Home, hidden: true }

]

const router = new VueRouter({
  routes
})

export default router
