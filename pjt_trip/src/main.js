// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import Vuetify from 'vuetify'
import 'vuetify/dist/vuetify.min.css' // Ensure you are using css-loader
import VeeValidate from 'vee-validate'
Vue.use(VeeValidate) // add
Vue.use(Vuetify)
Vue.config.productionTip = false

// axios.defaults.headers.common['Access-Control-Allow-Origin'] = '*';
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
