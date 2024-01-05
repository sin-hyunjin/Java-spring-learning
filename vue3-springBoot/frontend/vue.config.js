//JAVA 에서 CrossOrigin을 했기때문에 기존 코드 사용
const { defineConfig } = require("@vue/cli-service");
module.exports = defineConfig({
  transpileDependencies: true,
});
// http://localhost:8080/api 로 정의하고 url에 api가 합쳐져서 호출됨
/*
const target = "http://localhost:8080";
module.exports = {
  devServer: {
    port: 8080,
    proxy: {
      // ^ 화살표를 적어줘야 axios가 연결이 됨
      // 웹팩 개발 서버가 "/api"로 시작하는 경로에 대한 프록시를 활성화하도록 하는 정규 표현식 패턴
      "^/api": {
        target,
        changOrigin: true,
      },
    },
  },
};
*/
