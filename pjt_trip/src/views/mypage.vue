<template>
  <div class="mypage">
    <h1 class="subheading grey--text ma-3 text-center">My Page</h1>

    <v-container class="my-5">
      <v-layout row wrap justify-center>
        <v-card flat class="text-xs-center ma-3">
          <v-responsive class="pt-4">image goes here</v-responsive>
          <v-card-text>
            <div class="subheading">{{this.user.name}}</div>
            <div class="grey--text">{{this.user.nickname}}</div>
          </v-card-text>
          <v-card-actions>
            <v-btn flat color="grey" @click="getUserInfo()">
              <v-icon small left>message</v-icon>
              <span>Message</span>
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-layout>
    </v-container>
  </div>
</template>

<script>

export default {
  data: function () {
    return {
      user_pk: 1,
      user: {
        created_at: '',
        description: '',
        email: '',
        grade: 0,
        nickname: '',
        name: '',
        phone_number: '',
        profile_image: '',
        user_pk: 0
      }
    }
  },
  methods: {
    getUserInfo () {
      var swg_addr = 'http://192.168.31.84:8080/api/user/'
      var user_key = this.user_pk
      var url = swg_addr + user_key

      axios.post(url)
        .then(res => {
          console.log(res.data)
          this.user.name = res.data.name
          this.user.nickname = res.data.nickname
          this.user.email = res.data.email
        })
    }
  }
}
</script>
