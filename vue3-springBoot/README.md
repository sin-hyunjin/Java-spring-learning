# 프로젝트 구성 설명

- vue3_springboot

### 프로젝트 목표

- 이 프로젝트의 목표는 Spring과 Vue.js를 사용하여 간단한 회원 관리 시스템을 개발하는 것입니다.

- 이를 통해 전체적인 웹 애플리케이션의 흐름과 각 기술의 연동 방법을 이해하고자 했습니다.

![화면-기록-2024-01-06-오전-5 54 23](https://github.com/sin-hyunjin/spring-learning/assets/116487398/bde98acb-d7fc-49ec-9b62-7b5e9d68e073)

좋았던 점:

양방향 바인딩의 편리함: Vue.js의 양방향 바인딩은 화면 갱신이 편리하게 이루어져 개발을 효율적으로 할수 있었음
Spring Boot의 간결함: Spring Boot의 자동 어노테이션 설정과 객체지향적 구조는 백엔드 개발을 효과적으로 수행할 수 있도록 도왔음

어려웠던 점:

CORS 이슈 처리: 프론트엔드와 백엔드 간의 도메인이 다를 경우 CORS 이슈가 있었음

- 이를 해결하기 위해 서버 사이드에서 CORS 헤더를 설정하는 방법을 익힘

상태 관리의 필요성: 대규모 애플리케이션에서 상태의 효율적인 관리는 중요함

- 상태 관리에 대한 이해 부족으로 어려움을 겪었고 JAVA에 대해 좀더 공부할 필요성을 느낌

# 목차

- [ERROR해결](ERROR.md)
- [프로젝트 환경설정 파일](INSTALL.md)
- [Vue3 실행](#vue3-실행)
  - [Router SET](#router-set)

# Vue3 실행

**pakage.json**

```bash
"serve": "vue-cli-service serve --port 8800",
```

- backend 8080 서버와 다른 portfmf 사용하기위해 변경

## Router Set

![img_1.png](IMG%2Fimg_1.png)

1. 사용자 목록 페이지
   - ListView.vue "/user"
2. 사용자 등록 페이지
   - CreateView.vue "/user/save"
3. 사용자 정보 페이지
   - SelectView.vue "/user/findById"
4. 사용자 정보 수정 페이지
   - UpdateView.vue "/user/editById"

- HomeView.vue "/"

**router/index.js 에서 설정**

```html
{ path: "/user/editById", name: "UpdateView", component: () => import(/*
webpackChunkName: "user" */ "../views/UpdateView.vue"), }, { path: "/user/save",
name: "CreateView", component: () => import(/* webpackChunkName: "user" */
"../views/CreateView.vue"), },
```

- path : Url
- name : 파일이름
- component()=>{ 파일경로 }

# axios 사용

    $ npm install axios

**package.jon** <br>
![img.png](img.png)

### frontend 데이터 요청

```vue
/** methods axios 호출 * get방식으로 호출 * .then((response )=>{}) -> 요쳥에
성공하였을시 * .catch((error)=>{}) -> 에러 발생시 처리 */ methods: { getDate() {
axios .get("http://localhost:8080/") .then((res) => { console.log(res); })
.catch((error) => { console.log(error); }); }, },
```

# Back-end 데이터 처리하기

- controller method 기본정리

```java
  @CrossOrigin(origins = "http://localhost:8800")
    @GetMapping("/")
    public String home() {
        return "Data 준비 중";
    }

    @GetMapping("/api")
    public String api() {
        return "API Data 준비 중";
    }
    // 사용자 정보페이지  SelectView.vue "/user/findById"
    @PostMapping("/findAll")
    public void findAll() {

    }

    // 업데이트  UpdateView.vue "/user/editById"
    @PostMapping("/editById")
    public void editById() {

    }
    // 사용자 정보 삭제
    @DeleteMapping("/delete")
    public void delete() {

    }

    // 사용자 정보 등록 CreateView.vue "/user/save"
    @PutMapping("/save")
    public void save() {

    }
```
