const shortcut ={
    template :"\
    <div class='py-container'> \
        <div class='shortcut'> \
            <ul class='fl'> \
               <li class='f-item'>亲</li> \
               <li class='f-item' v-if='user && user.username'>\
               尊敬的会员，<span style='...'>{{user.username}}</span>\
               </li>\
               <li v-else class='f-item'> \
                   请<a href='javascript:void(0)' @click='gotoLogin'>登录</a>　 \
                   <span><a href='/register.html' target='_blank'>免费注册</a></span> \
               </li> \
           </ul> \
           <ul class='fr'> \
               <li class='f-item'>商城首页</li> \
               <li class='f-item space'></li> \
               <li class='f-item'><a href='home.html' target='_blank'>个人中心</a></li> \
               <li class='f-item space'></li> \
               <li class='f-item'>购物车</li> \
               <li class='f-item space'></li> \
               <li class='f-item'>收藏夹</li> \
           </ul> \
       </div> \
    </div>\
    ",
    name:"shortcut",
    data() {
        return {
            user: null
        }
    },
    created() {
        yjll.http("/auth/verify")
            .then(resp => {
                this.user = resp.data;
            })
    },
    methods: {
        gotoLogin() {
            window.location = "/login.html?returnUrl=" + window.location;
        }
    }
}
export default shortcut;