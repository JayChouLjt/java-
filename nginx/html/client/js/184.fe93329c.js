"use strict";(self["webpackChunkmusic_client"]=self["webpackChunkmusic_client"]||[]).push([[184],{1063:function(e,n,t){t.d(n,{Z:function(){return k}});var a=t(3396),i=t(7139);const o={class:"play-list"},s={key:0,class:"play-title"},l={class:"play-body"},r=["onClick"],c=["onClick"],u={class:"card-name"};function d(e,n,t,d,g,m){const p=(0,a.up)("el-image"),w=(0,a.up)("yin-icon");return(0,a.wg)(),(0,a.iD)("div",o,[e.title?((0,a.wg)(),(0,a.iD)("div",s,(0,i.zw)(e.title),1)):(0,a.kq)("",!0),(0,a._)("ul",l,[((0,a.wg)(!0),(0,a.iD)(a.HY,null,(0,a.Ko)(e.playList,((n,t)=>((0,a.wg)(),(0,a.iD)("li",{class:"card-frame",key:t},[(0,a._)("div",{class:"card",onClick:t=>e.goAblum(n)},[(0,a.Wm)(p,{class:"card-img",fit:"contain",src:e.attachImageUrl(n.pic)},null,8,["src"]),(0,a._)("div",{class:"mask",onClick:t=>e.goAblum(n)},[(0,a.Wm)(w,{class:"mask-icon",icon:e.BOFANG},null,8,["icon"])],8,c)],8,r),(0,a._)("p",u,(0,i.zw)(n.name||n.title),1)])))),128))])])}var g=t(4870),m=t(3089),p=t(8045),w=t(754),v=t(2167),h=(0,a.aZ)({components:{YinIcon:m.Z},props:{title:String,playList:Array,path:String},setup(e){const{proxy:n}=(0,a.FN)(),{routerManager:t}=(0,p.Z)(),{path:i}=(0,g.BK)(e);function o(e){n.$store.commit("setSongDetails",e),t(i.value,{path:`/${i.value}/${e.id}`})}return{BOFANG:w.JO.BOFANG,goAblum:o,attachImageUrl:v.x.attachImageUrl}}}),f=t(89);const y=(0,f.Z)(h,[["render",d],["__scopeId","data-v-1f9d386d"]]);var k=y},6319:function(e,n,t){t.d(n,{Z:function(){return S}});var a=t(3396);const i={class:"content"},o=(0,a.Uk)("下载"),s=(0,a.Uk)("删除");function l(e,n,t,l,r,c){const u=(0,a.up)("el-table-column"),d=(0,a.up)("MoreFilled"),g=(0,a.up)("el-icon"),m=(0,a.up)("el-dropdown-item"),p=(0,a.up)("el-dropdown-menu"),w=(0,a.up)("el-dropdown"),v=(0,a.up)("el-table");return(0,a.wg)(),(0,a.iD)("div",i,[(0,a.Wm)(v,{"highlight-current-row":"",data:e.dataList,onRowClick:e.handleClick},{default:(0,a.w5)((()=>[(0,a.Wm)(u,{prop:"songName",label:"歌曲"}),(0,a.Wm)(u,{prop:"singerName",label:"歌手"}),(0,a.Wm)(u,{prop:"introduction",label:"专辑"}),(0,a.Wm)(u,{label:"编辑",width:"80",align:"center"},{default:(0,a.w5)((n=>[(0,a.Wm)(w,null,{dropdown:(0,a.w5)((()=>[(0,a.Wm)(p,null,{default:(0,a.w5)((()=>[(0,a.Wm)(m,{icon:e.Download,onClick:t=>e.downloadMusic({songUrl:n.row.url,songName:n.row.name})},{default:(0,a.w5)((()=>[o])),_:2},1032,["icon","onClick"]),e.show?((0,a.wg)(),(0,a.j4)(m,{key:0,icon:e.Delete,onClick:t=>e.deleteCollection({id:n.row.id})},{default:(0,a.w5)((()=>[s])),_:2},1032,["icon","onClick"])):(0,a.kq)("",!0)])),_:2},1024)])),default:(0,a.w5)((()=>[(0,a.Wm)(g,{onClick:t=>e.handleEdit(n.row)},{default:(0,a.w5)((()=>[(0,a.Wm)(d)])),_:2},1032,["onClick"])])),_:2},1024)])),_:1})])),_:1},8,["data","onRowClick"])])}var r=t(4870),c=t(9749),u=t(8045),d=t(9092),g=t(547),m=t(6854);const p=(0,a.aZ)({name:"Download"}),w={class:"icon",width:"200",height:"200",viewBox:"0 0 1024 1024",xmlns:"http://www.w3.org/2000/svg"},v=(0,a._)("path",{fill:"currentColor",d:"M160 832h704a32 32 0 110 64H160a32 32 0 110-64zm384-253.696l236.288-236.352 45.248 45.248L508.8 704 192 387.2l45.248-45.248L480 584.704V128h64v450.304z"},null,-1),h=[v];function f(e,n,t,i,o,s){return(0,a.wg)(),(0,a.iD)("svg",w,h)}var y=(0,m.Z)(p,[["render",f]]),k=t(2167),L=t(754),C=(0,a.aZ)({components:{MoreFilled:d.Z},props:{songList:Array,show:{default:!1}},emits:["changeData"],setup(e){const{getSongTitle:n,getSingerName:t,playMusic:i,checkStatus:o,downloadMusic:s}=(0,u.Z)(),{proxy:l}=(0,a.FN)(),d=(0,c.oR)(),{songList:m}=(0,r.BK)(e),p=(0,r.qj)({dislike:L.JO.Dislike,like:L.JO.Like}),w=(0,a.Fl)((()=>d.getters.songUrl)),v=(0,a.Fl)((()=>d.getters.singerName)),h=(0,a.Fl)((()=>d.getters.songTitle)),f=(0,a.Fl)((()=>{const e=[];return m.value.forEach(((a,i)=>{a["songName"]=n(a.name),a["singerName"]=t(a.name),a["index"]=i,e.push(a)})),e}));function C(e){i({id:e.id,url:e.url,pic:e.pic,index:e.index,name:e.name,lyric:e.lyric,currentSongList:m.value})}function Z(e){console.log("row",e)}const N=(0,a.Fl)((()=>d.getters.userId));async function S({id:e}){if(!o())return;const n=await k.x.deleteCollection(N.value,e);l.$message({message:n.message,type:n.type}),!1===n.data&&l.$emit("changeData",n.data)}return{dataList:f,iconList:p,Delete:g.Z,Download:y,songUrl:w,singerName:v,songTitle:h,handleClick:C,handleEdit:Z,downloadMusic:s,deleteCollection:S}}}),Z=t(89);const N=(0,Z.Z)(C,[["render",l],["__scopeId","data-v-05112f65"]]);var S=N},3089:function(e,n,t){t.d(n,{Z:function(){return u}});var a=t(3396);const i={class:"icon","aria-hidden":"true"},o=["xlink:href"];function s(e,n,t,s,l,r){return(0,a.wg)(),(0,a.iD)("svg",i,[(0,a._)("use",{"xlink:href":e.icon},null,8,o)])}var l=(0,a.aZ)({props:{icon:String}}),r=t(89);const c=(0,r.Z)(l,[["render",s]]);var u=c},1447:function(e,n,t){t.d(n,{Z:function(){return d}});var a=t(3396),i=t(7139);const o={class:"yin-nav"},s=["onClick"];function l(e,n,t,l,r,c){return(0,a.wg)(),(0,a.iD)("ul",o,[((0,a.wg)(!0),(0,a.iD)(a.HY,null,(0,a.Ko)(e.styleList,((n,t)=>((0,a.wg)(),(0,a.iD)("li",{key:t,class:(0,i.C_)({active:n.name==e.activeName}),onClick:t=>e.handleChangeView(n)},(0,i.zw)(n.name),11,s)))),128))])}var r=(0,a.aZ)({props:{styleList:Array,activeName:String},emits:["click"],setup(){const{proxy:e}=(0,a.FN)();function n(n){e.$emit("click",n)}return{handleChangeView:n}}}),c=t(89);const u=(0,c.Z)(r,[["render",l],["__scopeId","data-v-604c60a7"]]);var d=u},9184:function(e,n,t){t.r(n),t.d(n,{default:function(){return S}});var a=t(3396);const i={class:"search"};function o(e,n,t,o,s,l){const r=(0,a.up)("yin-nav");return(0,a.wg)(),(0,a.iD)("div",i,[(0,a.Wm)(r,{styleList:e.searchNavList,activeName:e.activeName,onClick:e.handleChangeView},null,8,["styleList","activeName","onClick"]),((0,a.wg)(),(0,a.j4)((0,a.LL)(e.currentView),{class:"search-list"}))])}var s=t(1447);const l={class:"search-song"};function r(e,n,t,i,o,s){const r=(0,a.up)("song-list");return(0,a.wg)(),(0,a.iD)("div",l,[(0,a.Wm)(r,{songList:e.currentSongList},null,8,["songList"])])}var c=t(4870),u=t(9749),d=t(6319),g=t(2167),m=(0,a.aZ)({components:{SongList:d.Z},setup(){const{proxy:e}=(0,a.FN)(),n=(0,u.oR)(),t=(0,c.iH)([]),i=(0,a.Fl)((()=>n.getters.searchWord));async function o(n){if(!n)return void(t.value=[]);const a=await g.x.getSongOfSingerName(n);a.data.length?t.value=a.data:(t.value=[],e.$message({message:"暂时没有相关歌曲",type:"warning"}))}return(0,a.YP)(i,(e=>{o(e)})),(0,a.bv)((()=>{o(e.$route.query.keywords)})),{currentSongList:t}}}),p=t(89);const w=(0,p.Z)(m,[["render",r]]);var v=w;const h={class:"search-song-list"};function f(e,n,t,i,o,s){const l=(0,a.up)("play-list");return(0,a.wg)(),(0,a.iD)("div",h,[(0,a.Wm)(l,{playList:e.playList,path:"song-sheet-detail"},null,8,["playList"])])}var y=t(1063),k=(0,a.aZ)({components:{PlayList:y.Z},setup(){const{proxy:e}=(0,a.FN)(),n=(0,u.oR)(),t=(0,c.iH)([]),i=(0,a.Fl)((()=>n.getters.searchWord));async function o(n){if(!n)return;const a=await g.x.getSongListOfLikeTitle(n);a.data.length?t.value=a.data:e.$message({message:"暂无该歌曲内容",type:"warning"})}return(0,a.YP)(i,(e=>{o(e)})),(0,a.bv)((()=>{o(e.$route.query.keywords)})),{playList:t}}});const L=(0,p.Z)(k,[["render",f]]);var C=L,Z=(0,a.aZ)({components:{YinNav:s.Z,SearchSong:v,SearchSongList:C},data(){return{searchNavList:[{name:"歌曲",value:"SearchSong"},{name:"歌单",value:"SearchSongList"}],activeName:"歌曲",currentView:"SearchSong"}},methods:{handleChangeView(e){this.activeName=e.name,this.currentView=e.value}}});const N=(0,p.Z)(Z,[["render",o],["__scopeId","data-v-d345783c"]]);var S=N}}]);
//# sourceMappingURL=184.fe93329c.js.map