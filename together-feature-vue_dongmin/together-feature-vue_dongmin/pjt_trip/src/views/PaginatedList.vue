<template>
  <div class="font_Yeon">
    <template>
    <v-container fluid :grid-list-md="!$vuetify.breakpoint.xs">
      <v-layout wrap row>
        <v-flex xs12 sm6 md3 class="pb-2" v-for="p in paginatedData" :key="p.contentid">
          <v-card height="290px">
              <i v-if="p.image">
              <img :src="p.image" class="{ full: fullWidthImage }" /></i>
              <i v-else>
              <!-- <img :src="https://static.thenounproject.com/png/1174579-200.png" class="{ full: fullWidthImage }" /> -->
              <!-- <img :class="{ full: fullWidthImage }" src="https://static.thenounproject.com/png/1174579-200.png" alt="" /> -->
              </i>
               <p style="padding-top:3px; color:grey; font-size:20px; text-align: center; letter-spacing: 2px;" class="mb-0">{{p.title}}</p>
               <div>
               <p style="color:grey; font-size:15px; text-align: center; ">{{p.address}}</p></div>


            <!-- <img :src="p.firstimage2" style="width:150px; height:150px;"> -->
          </v-card>
        </v-flex>
      </v-layout>
    </v-container>
  </template>
    <div class="btn-cover">
      <button :disabled="PaginatedList.props.pageNum.type === 0" @click="prevPage" class="page-btn">
        -10
      </button>
      <span class="page-count">{{ PaginatedList.props.pageNum.type + 1 }} / {{ pageCount }} 페이지</span>
      <button :disabled="PaginatedList.props.pageNum.type >= pageCount - 1" @click="nextPage" class="page-btn">
        +10
      </button>
    </div>
  </div>
</template>

<script>
import PaginatedList from './PaginatedList'
import { posix } from 'path';

export default {
  name: 'paginated-list',
  data () {
    return {
      PaginatedList,

    }
  },
  props: {
    listArray: {
      type: Array,
      required: true
    },
    pageSize: {
      type: Number,
      required: false,
      default: 10
    },
    pageNum: 0,
  },
  methods: {
    nextPage () {
       PaginatedList.props.pageNum.type += 1;
    },
    prevPage () {
       PaginatedList.props.pageNum.type -= 1;
    }
  },
  computed: {
    pageCount () {
      let listLeng = this.listArray.length,
          listSize = this.pageSize,
          page = Math.floor(listLeng / listSize);
      if (listLeng % listSize > 0) page += 1;

      /*
      아니면 page = Math.floor((listLeng - 1) / listSize) + 1;
      이런식으로 if 문 없이 고칠 수도 있다!
      */
      return page;
    },
    paginatedData () {
      const start = PaginatedList.props.pageNum.type * this.pageSize,
            end = start + this.pageSize;
      console.log(this.listArray.slice(start, end))
      return this.listArray.slice(0, end);
      // 0-9, 10,19, 20,29
    }
  }
}
</script>

<style>
.btn-cover {
  margin-top: 1.5rem;
  text-align: center;
}
.btn-cover .page-btn {
  width: 5rem;
  height: 2rem;
  letter-spacing: 0.5px;
}
.btn-cover .page-count {
  padding: 0 1rem;
}
.full {
  width: 100%;
  height: 40%;
}
img {
  width: 290px;
  height: 200px;
  border-radius: 2px;
  box-shadow: 1px 1px 3px 1px rgba(0, 0, 0, 0.5);
  transition: width 1s;
  display: block; margin: 0px auto;
}
</style>
