"use strict";(self["webpackChunkmusic_client"]=self["webpackChunkmusic_client"]||[]).push([[691],{3089:function(e,n,o){o.d(n,{Z:function(){return c}});var r=o(3396);const s={class:"icon","aria-hidden":"true"},t=["xlink:href"];function a(e,n,o,a,i,l){return(0,r.wg)(),(0,r.iD)("svg",s,[(0,r._)("use",{"xlink:href":e.icon},null,8,t)])}var i=(0,r.aZ)({props:{icon:String}}),l=o(89);const u=(0,l.Z)(i,[["render",a]]);var c=u},2155:function(e,n,o){o.d(n,{Z:function(){return d}});var r=o(3396);const s={class:"login-logo"};function t(e,n,o,t,a,i){const l=(0,r.up)("yin-icon");return(0,r.wg)(),(0,r.iD)("div",s,[(0,r.Wm)(l,{icon:e.icon},null,8,["icon"])])}var a=o(3089),i=o(754),l=(0,r.aZ)({components:{YinIcon:a.Z},data(){return{icon:i.JO.ERJI}}}),u=o(89);const c=(0,u.Z)(l,[["render",t],["__scopeId","data-v-6d3e9656"]]);var d=c},9691:function(e,n,o){o.r(n),o.d(n,{default:function(){return _}});var r=o(3396),s=o(9242);const t=e=>((0,r.dD)("data-v-205ef79b"),e=e(),(0,r.Cn)(),e),a={class:"sign"},i=t((()=>(0,r._)("div",{class:"sign-head"},[(0,r._)("span",null,"帐号登录")],-1))),l=(0,r.Uk)("注册"),u=(0,r.Uk)("登录");function c(e,n,o,t,c,d){const m=(0,r.up)("yin-login-logo"),p=(0,r.up)("el-input"),g=(0,r.up)("el-form-item"),f=(0,r.up)("el-button"),w=(0,r.up)("el-form");return(0,r.wg)(),(0,r.iD)(r.HY,null,[(0,r.Wm)(m),(0,r._)("div",a,[i,(0,r.Wm)(w,{ref:"signInForm","status-icon":"",model:e.registerForm,rules:e.SignInRules},{default:(0,r.w5)((()=>[(0,r.Wm)(g,{prop:"username"},{default:(0,r.w5)((()=>[(0,r.Wm)(p,{placeholder:"用户名",modelValue:e.registerForm.username,"onUpdate:modelValue":n[0]||(n[0]=n=>e.registerForm.username=n)},null,8,["modelValue"])])),_:1}),(0,r.Wm)(g,{prop:"password"},{default:(0,r.w5)((()=>[(0,r.Wm)(p,{type:"password",placeholder:"密码",modelValue:e.registerForm.password,"onUpdate:modelValue":n[1]||(n[1]=n=>e.registerForm.password=n),onKeyup:(0,s.D2)(e.handleLoginIn,["enter"])},null,8,["modelValue","onKeyup"])])),_:1}),(0,r.Wm)(g,{class:"sign-btn"},{default:(0,r.w5)((()=>[(0,r.Wm)(f,{onClick:e.handleSignUp},{default:(0,r.w5)((()=>[l])),_:1},8,["onClick"]),(0,r.Wm)(f,{type:"primary",onClick:e.handleLoginIn},{default:(0,r.w5)((()=>[u])),_:1},8,["onClick"])])),_:1})])),_:1},8,["model","rules"])])],64)}var d=o(4870),m=o(8045),p=o(2155),g=o(2167),f=o(754),w=(0,r.aZ)({components:{YinLoginLogo:p.Z},setup(){const{proxy:e}=(0,r.FN)(),{routerManager:n,changeIndex:o}=(0,m.Z)(),s=(0,d.qj)({username:"",password:""});async function t(){let r=!0;if(e.$refs["signInForm"].validate((e=>{if(!e)return r=!1})),r)try{const r=s.username,t=s.password,a=await g.x.SignIn({username:r,password:t});e.$message({message:a.message,type:a.type}),a.success&&(e.$store.commit("setUserId",a.data[0].id),e.$store.commit("setUsername",a.data[0].username),e.$store.commit("setUserPic",a.data[0].avator),e.$store.commit("setToken",!0),o(f.ZF.Home),n(f.wC.Home,{path:f.wC.Home}))}catch(t){console.error(t)}}function a(){n(f.wC.SignUp,{path:f.wC.SignUp})}return{registerForm:s,SignInRules:f.Jj,handleLoginIn:t,handleSignUp:a}}}),h=o(89);const v=(0,h.Z)(w,[["render",c],["__scopeId","data-v-205ef79b"]]);var _=v}}]);
//# sourceMappingURL=691.c62b6569.js.map