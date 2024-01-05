import { createRouter, createWebHistory } from "vue-router";
import HomeView from "../views/HomeView.vue";

const routes = [
  /**
   * views에 있는 경로를 지정하기 위한 설정
   */

  {
    path: "/",
    name: "HomeView",
    component: HomeView,
  },

  {
    path: "/user",
    name: "ListView",
    component: () =>
      import(/* webpackChunkName: "user" */ "../views/ListView.vue"),
  },
  {
    path: "/user/findById/:name",
    name: "SelectView",
    component: () =>
      import(/* webpackChunkName: "user" */ "../views/SelectView.vue"),
  },
  {
    path: "/user/editById",
    name: "UpdateView",
    component: () =>
      import(/* webpackChunkName: "user" */ "../views/UpdateView.vue"),
  },
  {
    path: "/user/save",
    name: "CreateView",
    component: () =>
      import(/* webpackChunkName: "user" */ "../views/CreateView.vue"),
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
