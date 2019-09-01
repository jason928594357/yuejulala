var indexApp = new Vue({
    el:"#indexApp",
    components:{
        yjllTop:() => import('../common/js/top.js')
    }
});