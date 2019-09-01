import Vue from 'vue'
import axios from 'axios'
import config from './config'

axios.defaults.baseURL = config.api;
axios.defaults.timeout=2000;

axios.loadData= async function (url){
    const resp = await axios.get(url);
    return resp.data;
}

Vue.prototype.$http = axios;