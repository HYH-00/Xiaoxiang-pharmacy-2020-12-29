import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../views/Login.vue'
// import Main from '../views/Main.vue'

Vue.use(VueRouter)

const routes = [{
		path: '/',
		name: 'Login',
		component: Login
	},
	{
		path: '/Index',
		name: 'Index',
		// component: Main
		component: () => import('../views/Index.vue')
	}
	//,
	// {
	// path: '/Main',
	// name: 'Main',
	// route level code-splitting
	// this generates a separate chunk (about.[hash].js) for this route
	// which is lazy-loaded when the route is visited.
	// component: () => import(/* webpackChunkName: "about" */ '../views/Main.vue')
	// }
]

const router = new VueRouter({
	routes
})

export default router
