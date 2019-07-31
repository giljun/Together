import Vue from 'vue'
import Router from 'vue-router'
import Traveling from '@/components/Traveling'
import 'vuetify/dist/vuetify.min.css' // Ensure you are using css-loade
import index from '@/views/index'
import Vuetify from 'vuetify'


Vue.use(Vuetify)
Vue.use(Router)

export default new Router({
    routes: [{
        path: '/',
        name: 'index',
        component: index
    }]
})