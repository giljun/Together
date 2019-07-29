import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import 'vuetify/dist/vuetify.min.css' // Ensure you are using css-loade
import index from '@/views/index'
import tour from '@/views/tour'
import register from '@/views/register'
import tour_views from '@/views/tour_views'
import Vuetify from 'vuetify'

Vue.use(Vuetify)
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'index',
      component: index
    },
    {
      path: '/register',
      name: 'register',
      component: register
    },
    {
      path: '/tour',
      name: 'tour',
      component: tour
    },
    {
      path: '/tour_views',
      name: 'tour_views',
      component: tour_views
    },
  ]
})
