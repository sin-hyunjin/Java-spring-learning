<template>
  <div class="home">
    <a href="/user">사용자 목록</a>
    <br />
    <button @click="getData">데이터 호출</button>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "HomeView",
  /** methods axios 호출
   *  get방식으로 호출
   *  .then((response )=>{}) -> 요쳥에 성공하였을시
   *  .catch((error)=>{}) -> 에러 발생시 처리
   */
  methods: {
    getData() {
      // 메서드 이름을 getDate에서 getData로 수정
      axios
        .get("/api")
        .then((res) => {
          console.log(res);
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
};
</script>

<!-- scoped = 이 파일에서의 스타일만 적용한다는 의미  -->
<style scoped>
a {
  color: black;
  text-decoration: none;
  font-weight: bold;
  font-size: 1.5rem;
}

a:hover {
  color: rgba(0, 0, 0, 0.6);
}
</style>
