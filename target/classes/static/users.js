var users = [];

function findUser (userId) {
  return users[findUserKey(userId)];
}

function findUserKey (userId) {
  for (var key = 0; key < users.length; key++) {
    if (users[key].id == userId) {
      return key;
    }
  }
}

var userService = {
  findAll(fn) {
    axios
      .get('/api/v1/users')
      .then(response => fn(response))
      .catch(error => console.log(error))
  },

  findById(id, fn) {
    axios
      .get('/api/v1/users/' + id)
      .then(response => fn(response))
      .catch(error => console.log(error))
  },

  create(user, fn) {
    axios
      .post('/api/v1/users', user)
      .then(response => fn(response))
      .catch(error => console.log(error))
  },

  update(id, user, fn) {
    axios
      .put('/api/v1/users/' + id, user)
      .then(response => fn(response))
      .catch(error => console.log(error))
  },

  deleteUser(id, fn) {
    axios
      .delete('/api/v1/users/' + id)
      .then(response => fn(response))
      .catch(error => console.log(error))
  }
}

var List = Vue.extend({
  template: '#user-list',
  data: function () {
    return {users: [], searchKey: ''};
  },
  computed: {
    filteredUsers() {
      return this.users.filter((user) => {
      	return user.name.indexOf(this.searchKey) > -1
      	  || user.description.indexOf(this.searchKey) > -1
      	  || user.price.toString().indexOf(this.searchKey) > -1
      })
    }
  },
  mounted() {
    userService.findAll(r => {this.users = r.data; users = r.data})
  }
});

var User = Vue.extend({
  template: '#user',
  data: function () {
    return {user: findUser(this.$route.params.user_id)};
  }
});

var UserEdit = Vue.extend({
  template: '#user-edit',
  data: function () {
    return {user: findUser(this.$route.params.user_id)};
  },
  methods: {
    updateUser: function () {
      userService.update(this.user.id, this.user, r => router.push('/'))
    }
  }
});

var UserDelete = Vue.extend({
  template: '#user-delete',
  data: function () {
    return {user: findUser(this.$route.params.user_id)};
  },
  methods: {
    deleteUser: function () {
      userService.deleteUser(this.user.id, r => router.push('/'))
    }
  }
});

var AddUser = Vue.extend({
  template: '#add-user',
  data() {
    return {
      user: {name: '', description: '', price: 0}
    }
  },
  methods: {
    createUser() {
      userService.create(this.user, r => router.push('/'))
    }
  }
});

var router = new VueRouter({
	routes: [
		{path: '/', component: List},
		{path: '/user/:user_id', component: User, name: 'user'},
		{path: '/add-user', component: AddUser},
		{path: '/user/:user_id/edit', component: UserEdit, name: 'user-edit'},
		{path: '/user/:user_id/delete', component: UserDelete, name: 'user-delete'}
	]
});

new Vue({
  router
}).$mount('#app')