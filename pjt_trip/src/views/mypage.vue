<template>
  <div class="mypage">
    <h1 class="subheading grey--text ma-3 text-center">My Page</h1>

    <v-container class="my-3">
      <v-layout row wrap justify-center>
        <v-card flat class="text-xs-center ma-3" min-width="500">
          <v-responsive class="pt-4">
            <v-img
              src="http://mnews.imaeil.com/inc/photos/2018/10/04/2018100410494025802_l.jpg"
              class="grey lighten-2"
              ma-3
            ></v-img>
            <v-btn color="success" class="right">프로필 이미지 변경</v-btn>
          </v-responsive>

          <v-card-text>
            <v-text-field
              name="email"
              label="Email"
              id="email"
              prepend-icon="mail"
              clearable
              hint="메일 표기 형식을 지켜주세요. ex) xxxx@gmail.com"
              :rules="[rules.counter, rules.email]"
              counter="25"
              v-model="user.email"
            ></v-text-field>
            <v-text-field
              name="name"
              label="Name"
              id="name"
              prepend-icon="account_box"
              clearable
              hint="이름을 입력해주세요."
              :rules="[rules.counter]"
              counter="25"
              v-model="user.name"
            ></v-text-field>
            <v-text-field
              name="nickname"
              label="Nickname"
              id="nickname"
              prepend-icon="face"
              clearable
              hint="별명을 입력해주세요."
              :rules="[rules.counter]"
              counter="25"
              v-model="user.nickname"
            ></v-text-field>
            <v-text-field
              name="desc"
              label="Desc"
              id="desc"
              prepend-icon="description"
              clearable
              hint="자신을 한마디로 표현해주세요."
              :rules="[rules.counter]"
              counter="25"
              v-model="user.description"
            ></v-text-field>
            <v-text-field
              name="phone"
              label="Phone"
              id="phone"
              prepend-icon="smartphone"
              clearable
              hint="전화번호를 입력해주세요."
              :rules="[rules.counter]"
              counter="25"
              v-model="user.phone_number"
            ></v-text-field>
            <v-text-field
              name="password"
              label="Password"
              id="password"
              prepend-icon="security"
              clearable
              hint="비밀번호를 입력해주세요."
              :rules="[rules.counter]"
              counter="25"
            ></v-text-field>
            <v-checkbox
              label="Would you like to travel with someone else?"
              v-model="user.together"
              value="value"
              color="green"
            ></v-checkbox>
          </v-card-text>

          <v-card-actions class="justify-center">
            <v-btn flat color="grey" @click="getUserInfo()">
              <v-icon small left>message</v-icon>
              <span>Message</span>
            </v-btn>
            <v-btn flat color="grey" @click="submit()">
              <v-icon small left>edit</v-icon>
              <span>edit</span>
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
      rules: {
        counter: value => value.length <= 25 || 'Max 25 characters',
        email: value => {
          const pattern = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
          return pattern.test(value) || 'Invalid e-mail.'
        }
      },
      user: {
        created_at: '',
        description: '',
        email: '',
        grade: 0,
        nickname: '',
        name: '',
        phone_number: '',
        profile_image: '',
        user_pk: 0,
        together: 0
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
          this.user.email = res.data.email
          this.user.name = res.data.name
          this.user.nickname = res.data.nickname
          this.user.email = res.data.email
          this.user.description = res.data.description
          this.user.phone_number = res.data.phone_number
          this.user.together = 1
        })
    },
    submit () {

    }
  },
  mounted () {
    this.getUserInfo()
  }
}
</script>
