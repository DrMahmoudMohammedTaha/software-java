/*(c)2014 sovrn Holdings;All Rights Reserved*/
if(typeof LJT_AdsiFrame_Opts==="undefined"){var LJT_AdsiFrame_Opts=null;}
if(typeof LJT_placement_id==="undefined"){var LJT_placement_id=null;}
var LJT_AdsiFrame=(function(){
  function isInIframe(){return self!==top;}
  function getScriptTag(){
    if('currentScript' in document) return document.currentScript;
    var scripts=document.getElementsByTagName('script');
    var last_script=scripts[scripts.length-1];
    if(last_script.src.search(/\/delivery\/fpi.js/)>=0){return last_script;}
    else {try{for(var n=scripts.length-1;n>=0;n--){if(scripts[n].src.search(/\/delivery\/fpi.js/)>=0){return scripts[n];}}}catch(e){}}
    return last_script;
  }
  function getQueryString(){
    var myScript=getScriptTag();
    if(myScript.src.search(/\/delivery\/fpi.js/)>=0){return myScript.src.replace(/^[^\?]+\??/,'');}else{return false;}
  }
  function getQueryStringArg(qs,key,default_){
    default_=default_||'';
    var query_obj={};
    qs.replace(new RegExp("([^?=&]+)(=([^&]*))?","g"),function($0,$1,$2,$3){query_obj[$1]=$3;});
    if(typeof(query_obj[key])==='undefined'||query_obj[key]===null){return default_;}else{return query_obj[key];}
  }
  function getSiteURL(){
    var site_loc='';
    try{if(isInIframe()&&document.referrer){site_loc=document.referrer.replace(/^\s+|\s+$/g,'');}
    else {site_loc=document.location.href;}
    }catch(e){}
    return site_loc.replace(/["']/g,'');
  }
  function getRefSiteURL(){
    var ref='';
    if(!isInIframe()){ref=document.referrer.replace(/^\s+|\s+$|["']/g,'');}
    return ref;
  }
  function getOD(){return parseUri(document.location.href.replace(/["']/g,'')).host;}

  function getFMZoneId(zoneid){
    var id='fm_'+zoneid;
    var obj=document.getElementById(id);
    if(!obj){return id;}
    var i=1;
    while(obj){
      id='fm_'+zoneid+'_'+i;
      obj=document.getElementById(id);
      i++;
    }
    return id;
  }
  function getFMAbf(id,viewport){
    var ret="";
    if(!viewport||viewport.status!="ok"){ret="error";}
    try {
      var rect=getFMPosition(id);
      ret=((rect.x+rect.width<=viewport.x+viewport.width)&&(rect.y+rect.height<=viewport.y+viewport.height));
      if((typeof LJT_bCTids!=='undefined')&&(typeof LJT_bCTids[id]!=='undefined')){ret=ret+'&amp;tid='+LJT_bCTids[id];}
      var zoneid=id.replace(/^lwp_abf_/i,'');
      zoneid=zoneid.replace(/_[0-9]{1,3}$/i,'');
      if((typeof ljt_beacon_vals!=='undefined')&&(typeof ljt_beacon_vals[zoneid]!=='undefined')){
        var cidsbids=ljt_beacon_vals[zoneid].replace(/^bannerid=\d+&amp;campaignid=\d+/i,'');
        if(cidsbids.length>0){ret=ret+cidsbids;}
      }
    }catch(e){ret="error";}
    return ret;
  }
  function getFMPosition(id,width,height){
    var w=(width)?width:0,h=(height)?height:0,y=0,x=0,rect={x:x,y:y,width:w,height:h},de=document.documentElement;
    try{
      var obj=document.getElementById(id);
      while(obj){rect.x+=obj.offsetLeft;rect.y+=obj.offsetTop;obj=obj.offsetParent;}
      if(self.pageYOffset){
        rect.x-=self.pageXOffset;rect.y-=self.pageYOffset;
      }else if(de&&de.scrollTop){
        rect.x-=de.scrollLeft;rect.y-=de.scrollTop;
      }else if(document.body){
        rect.x-=document.body.scrollLeft;rect.y-=document.body.scrollTop;
      }
    } catch(e){}
    return rect;
  }
  function getFMViewport(){
    var viewport={x:0,y:0,width:0,height:0,status:''},bw=0,bh=0,de=de,w=window,db=document.body;
    try {
      if(typeof w.innerWidth==='number'){bw=w.innerWidth;bh=w.innerHeight;}
      else if(de&&(de.clientWidth||de.clientHeight)){bw=de.clientWidth;bh=de.clientHeight;}
      else if(db&&(db.clientWidth||db.clientHeight)){bw=db.clientWidth;bh=db.clientHeight;}
      else if(de&&(de.offsetWidth||de.offsetHeight)){bw=de.offsetWidth;bh=de.offsetHeight;}
      viewport.status="ok";viewport.width=bw;viewport.height=bh;
    }catch(e){viewport.status="error";}
    return viewport;
  }
  function parseUri(u){
    try{
      var o={key:["source","protocol","authority","userInfo","user","password","host","port","relative","path","directory","file","query","anchor"],
        q:{name:"queryKey",parser:/(?:^|&)([^&=]*)=?([^&]*)/g},
        parser:{loose:/^(?:(?![^:@]+:[^:@\/]*@)([^:\/?#.]+):)?(?:\/\/)?((?:(([^:@]*)(?::([^:@]*))?)?@)?([^:\/?#]*)(?::(\d*))?)(((\/(?:[^?#](?![^?#\/]*\.[^?#\/.]+(?:[?#]|$)))*\/?)?([^?#\/]*))(?:\?([^#]*))?(?:#(.*))?)/}
      },m=o.parser.loose.exec(u),uri={},i=14;while(i--)uri[o.key[i]]=m[i]||'';
      uri[o.q.name]={};uri[o.key[12]].replace(o.q.parser,function($0,$1,$2){if($1) uri[o.q.name][$1]=$2;});
      return uri;
    }catch(e){this.reportError('Failed to get OD',e);}
    return u;
  }
  function getFPQueryString(qs,abf,add_all_tokens){
    var qstring='?abf='+abf,e=encodeURIComponent;
    if(add_all_tokens){qstring+='&loc='+e(getSiteURL())+'&od='+e(getOD())+'&ref='+e(getRefSiteURL());}
    var args=qs.split('&');
    for(var i=0;i<args.length;i++){
      var arg=args[i].split('='),key=arg[0],value=arg[1];
      if(key==='debug'||key==='u'||key==='z'||key==='n'||key==='lijit_domain'||key.match(/^ljt_/)){qstring+='&'+e(key)+"="+e(value);}
    }
    return qstring;
  }
  function createiFrame(id,width,height){
    var ifrm=document.createElement('iframe');
    ifrm.setAttribute('id',id);
    ifrm.setAttribute('margin','0');ifrm.setAttribute('padding','0');ifrm.setAttribute('frameBorder','0');ifrm.setAttribute('width',width+'');ifrm.setAttribute('height',height+'');ifrm.setAttribute('scrolling','no');
    try{ifrm.style.margin="0px";ifrm.style.padding="0px";ifrm.style.border='0px none';ifrm.style.width=width+"px";ifrm.style.height=height+"px";ifrm.style.overflow='hidden';}catch(e){}
    return ifrm;
  }
  var qs=null,scriptTag,fpTag;
  if(LJT_AdsiFrame_Opts!==null){qs=LJT_AdsiFrame_Opts;}else{qs=getQueryString();}
  var ljtLocTag="<script type='text/javascript'>var LJT_Loc={};"+"LJT_Loc.loc='"+getSiteURL()+"';LJT_Loc.ref='"+getRefSiteURL()+"';LJT_Loc.ifr='"+(isInIframe()?'1':'0')+"';LJT_Loc.od='"+getOD()+"';</script>";
  var domain=getQueryStringArg(qs,'lijit_domain','www.lijit.com'),abf=null,
    fpTag='<scr'+'ipt type="text/javascript" src="http://'+domain+'/delivery/fp'+getFPQueryString(qs,abf,false)+'"></scr'+'ipt>',
    htmlPrefix="<html><head><title></title></head><body style='padding:0px;margin:0px;'>",
    htmlSuffix="<![if !IE]><script type='text/javascript'>document.close();</script><![endif]></body></html>";

  if(isInIframe()){document.write(ljtLocTag+fpTag);}
  else{
    if(LJT_AdsiFrame_Opts!==null){
      var placement=LJT_placement_id||"LJT_FPI_"+getQueryStringArg(qs,'z',0);
      scriptTag=document.getElementById(placement)||getScriptTag();
    }else{scriptTag=getScriptTag();}
    var width=getQueryStringArg(qs,'width',160),
      height=getQueryStringArg(qs,'height',600),
      id=getQueryStringArg(qs,'z'),
      ifrm=createiFrame(id,width,height);
    scriptTag.parentNode.insertBefore(ifrm,scriptTag);
    abf=getFMAbf(id,getFMViewport());
    fpTag='<scr'+'ipt type="text/javascript" src="http://'+domain+'/delivery/fp'+getFPQueryString(qs,abf,false)+'"></scr'+'ipt>';

    if(getQueryStringArg(qs,'lijit_src','0')==='1'){
      var ap_domain=getQueryStringArg(qs,'lijit_ad_domain','ap.lijit.com');
      ifrm.src='http://'+ap_domain+"/adif.php"+getFPQueryString(qs,abf,true);
    }else{
      var ifr_content=ifrm.contentWindow.document||ifrm.contentDocument;
      ifr_content.write(htmlPrefix+ljtLocTag+fpTag+htmlSuffix);
    }
  }
  return {};
})();
LJT_placement_id=null;
LJT_AdsiFrame_Opts=null;
