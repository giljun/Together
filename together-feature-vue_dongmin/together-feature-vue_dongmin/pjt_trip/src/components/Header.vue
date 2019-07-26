<template>
  <v-toolbar :color="elevation-0" style="background-color: #ffffff; background-color: rgba( 255, 255, 255, 0 );" flat=flase class="font_pacifico">
    <v-toolbar-side-icon></v-toolbar-side-icon>
    <v-toolbar-title>Everything to trip</v-toolbar-title>
    <v-spacer></v-spacer>
    <v-toolbar-items class="hidden-sm-and-down">
      <v-btn flat>Login</v-btn>
      <v-btn flat>Tour</v-btn>
      <v-btn flat>Transportation</v-btn>
    </v-toolbar-items>
  </v-toolbar>
</template>
<style>
.font_pacifico {
  font-family: 'Pacifico', cursive;
}
</style>
