<template>
  <v-container fluid fill-height>
    <v-layout align-center justify-center>
      <v-flex xs12 sm8 md4>
        <v-card class="elevation-12">
          <v-toolbar dark color="primary">
            <v-toolbar-title>회원 가입</v-toolbar-title>
            <v-spacer></v-spacer>
          </v-toolbar>
          <v-card-text>
            <form>
                        <v-text-field

                          label="email"
                          type='text'
                          v-model="form.email"
                          data-vv-name="email"
                          required
                        ></v-text-field>
                        <v-text-field

                          label="닉네임"
                          v-model="form.nickname"
                          data-vv-name="nickname"
                          required
                        ></v-text-field>
                        <v-text-field

                          label="휴대폰 번호"
                          v-model="form.phone_number"
                          data-vv-name="phone_number"
                          required
                        ></v-text-field>
                        <v-text-field

                          label="grade"
                          v-model="form.grade"
                          data-vv-name="grade"
                          required
                        ></v-text-field>
                         <v-btn @click="submit">가입</v-btn>
                      </form>
          </v-card-text>
        </v-card>
      </v-flex>
    </v-layout>
  </v-container>
</template>
<script>
import Header from '@/components/Header'


export default {
  name: 'register',
  components : {
    Header
  },
  data () {

    return {
      title : 'HelloWorld',
      form:{
        email:' ',
        nickname:' ',
        phone_number:' ',
        grade:' '
      },
    }
  },
  methods: {
    submit(){
        var key='rbssLvuPaumnRlgRCPsgU5IeLlHAf5nHHGU8P3JVSYqJvgSFL8l%2FJbCYNE9zVd5Je%2BFoFlSBFo%2Fochd7h97a%2Fg%3D%3D'
        var spring_url = 'http://192.168.31.84:8080/api/user/signup/'
        alert(this.form.email)

        axios.post(spring_url,{
          email:this.form.email,
          nickname:this.form.nickname,
          phone_number:this.form.phone_number,
          grade:this.form.grade
        })
        .then( response =>{

          console.log('response : ', JSON.stringify(response, null, 2)) }).catch( error => { console.log('failed', error)

        })



    }


  },
  computed: {

  }
}
</script>
