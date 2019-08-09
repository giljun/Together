<template>
  <v-layout justify-center>
    <v-dialog v-model="dialog" fullscreen hide-overlay transition="dialog-bottom-transition">
      <template v-slot:activator="{ on }">
        <v-btn dark v-on="on">함께 여행하기</v-btn>
      </template>
      <v-card>
        <v-toolbar dark color="primary">
          <v-btn icon dark @click="dialog = false">
            <v-icon>close</v-icon>
          </v-btn>
          <v-toolbar-title>Together with you !</v-toolbar-title>
          <v-spacer></v-spacer>
          <!-- <v-toolbar-items>
            <v-btn dark text @click="dialog = false">Save</v-btn>
          </v-toolbar-items> -->
        </v-toolbar>
        <v-list three-line subheader>
          <v-subheader>{{this.$session.get('lo').nickname}} 여행자님!</v-subheader>
            <v-list-item>
                <v-list-item-content>
                  <!-- <v-list-item-title>Content filtering {{Traveling.props.city}}</v-list-item-title> -->
                  <v-list-item-subtitle> 현재 {{Traveling.props.city}}에서는 {{}}명의 여행자가 여행중이네요! </v-list-item-subtitle>
                </v-list-item-content>
            </v-list-item>
            <!-- <v-list-item>
              <v-list-item-content>
                <v-list-item-title>Password</v-list-item-title>
                <v-list-item-subtitle>Require password for purchase or use password to restrict purchase</v-list-item-subtitle>
              </v-list-item-content>
            </v-list-item> -->
        </v-list>
        <v-divider></v-divider>
        <v-list three-line subheader>
          <v-subheader>General</v-subheader>
          <v-list-item>
            <v-list-item-action>
              <v-checkbox v-model="notifications"></v-checkbox>
            </v-list-item-action>
            <v-list-item-content>
              <v-list-item-title>Notifications</v-list-item-title>
              <v-list-item-subtitle>Notify me about updates to apps or games that I downloaded</v-list-item-subtitle>
            </v-list-item-content>
          </v-list-item>
          <!-- <v-list-item>
            <v-list-item-action>
              <v-checkbox v-model="sound"></v-checkbox>
            </v-list-item-action>
            <v-list-item-content>
              <v-list-item-title>Sound</v-list-item-title>
              <v-list-item-subtitle>Auto-update apps at any time. Data charges may apply</v-list-item-subtitle>
            </v-list-item-content>
          </v-list-item>
          <v-list-item>
            <v-list-item-action>
              <v-checkbox v-model="widgets"></v-checkbox>
            </v-list-item-action>
            <v-list-item-content>
              <v-list-item-title>Auto-add widgets</v-list-item-title>
              <v-list-item-subtitle>Automatically add home screen widgets</v-list-item-subtitle>
            </v-list-item-content>
          </v-list-item> -->
        </v-list>
      </v-card>
    </v-dialog>
  </v-layout>
</template>
<script>
import Traveling from '@/components/Traveling'
  export default {
    name: 'withmodal',
    components: {
      Traveling,
    },
    data () {
      return {
        dialog: false,
        notifications: false,
        sound: true,
        widgets: false,
        Traveling,
      }
    },
    methods:{
      setuser() {
        if(this.$session.get('lo')){
          this.login_users = []
          console.log('12132414234')
          var spring_url='http://192.168.31.84:8080/api/user/locate'
          axios.post(spring_url,{location:Traveling.props.city}).then((res)=>{
            console.log(res.data)
            for (var [key, login_user] of Object.entries(res.data)){
              this.login_users.push(login_user)}
          })
        }
      }
    },
    mounted(){
      this.setuser();
    }
  }
</script>
