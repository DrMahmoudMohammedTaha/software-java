﻿var _qevents;if(typeof DMAds=="undefined"){var SendSearchTermsToServer=window.location.protocol==="http:",OnlySendForCodeProject=!1,CodeProjectPublisherId="lqm.codeproject.site",QuantScriptRequired=!1,EnableMutableAds=!0,adServer=adServer||window.location.protocol+"//ads.DeveloperMedia.com/",SearchTermUrl=window.location.protocol+"//apps.developermedia.com/Ads/PageTerms/GetTerms",AdClickUrl=window.location.protocol+"//apps.developermedia.com/Ads/PageTerms/LogClick",DownvoteUrl=window.location.protocol+"//apps.developermedia.com/Ads/AdVote/DownvoteByFingerprint",UndoDownvoteUrl=window.location.protocol+"//apps.developermedia.com/Ads/AdVote/UndoDownvote",ReportAdUrl=window.location.protocol+"//apps.developermedia.com/Ads/AdVote/ReportAd",CloseAdImageUrl=window.location.protocol+"//apps.developermedia.com/Content/images/undo.png",UndoCloseAdImageUrl=window.location.protocol+"//apps.developermedia.com/Content/images/redo.png",DmLogoImageUrl=window.location.protocol+"//apps.developermedia.com/Content/images/dm-logo-150x23.png",GlobalIdUrl=window.location.protocol+"//apps.developermedia.com/Ads/GlobalUserIdentification/",DMAds={GetQueryTerms:function(){function u(n){for(var u="",i,t=0;t<r.length;t++)if(i=r[t],n.indexOf(i.d)>=0){u=i.q;break}return u}function f(n,t){var r=t.toLowerCase().indexOf(n),u,i;return r<0||r+n.length>=t.length?"":(u=t.indexOf("&",r),u<0&&(u=t.length),i=t.substring(r+n.length,u),i=i.replace(/\+/gi," "),i=decodeURIComponent(i),i.replace(/\"/gi,""))}function e(n){if(n===undefined)return"";var t=n.replace(/^\s+|\s+$/gi,"");return t?(t=t.replace(/\bAND\b|\bNOT\b|^NOT\b|\bOR\b|[^A-Z0-9\+\-\#\._\s]+|\b[A-Z0-9]+:/gi," "),t.replace(/\s+/g," ")):""}var r=[{d:"www.google.",q:"q="},{d:"www.bing.com",q:"q="},{d:"search.live.com",q:"q="},{d:"search.yahoo.com",q:"p="},{d:"codeproject.com",q:"q="},{d:"msdn.microsoft.com",q:"query="},{d:"www.ask.com",q:"q="},{d:"yandex.com",q:"text="},{d:"yandex.ru",q:"text="},{d:"www.baidu.com",q:"wd="},{d:"localhost",q:"q="}],n=document.URL,i="",t=u(n);if(t!==""&&(i=e(f(t,n))),i==""){if(n=document.referrer.toLocaleLowerCase(),!n)return"";t=u(n);t!=""&&(i=e(f(t,n)))}return i},GetRandom:function(n,t){for(var u,i="",r=0;r<n;r++)u=Math.floor(Math.random()*t).toString(t).toUpperCase(),i=i+u;return i},PageRandomNumber:null,PageSearchTerms:null,Tile:1,CurrentDocument:null,BuildIFrameTag:function(n){var t='<iframe id="dmad{tile}" allowtransparency="false" style="z-index:10" ';return t=n&&n.width&&n.width>1?t+'width="{width}" ':t+'width="100%" ',t=n&&n.height&&n.height>0?t+'height="{height}" ':t+'height="0" ',t=t+'marginwidth="0" marginheight="0" frameborder="0" scrolling="no"><\/iframe>',this.ReplacePlaceholders(t,n)},BuildJavaScriptTag:function(n){var t='<script language="JavaScript" src="'+window.location.protocol+'//ad.doubleclick.net/N6839/adj/{sitename}/{zonename};{searchterm}sz={format};{dc_ref}{type}tile={tile};ord={timestamp}?" type="text/javascript"><\/script>';return this.ReplacePlaceholders(t,n)},ReplacePlaceholders:function(n,t){n=n.replace(/\{sitename\}/g,t.sitename);n=n.replace(/\{zonename\}/g,t.zonename);n=t.tags?n.replace(/\{searchterm\}/g,"kw="+encodeURIComponent(this.EscapeSpecialCharacters(t))+";"):n.replace(/\{searchterm\}/g,"");n=n.replace(/\{tile\}/g,t.tile.toString());n=n.replace(/\{format\}/g,t.format);n=n.replace(/\{width\}/g,t.width);n=n.replace(/\{height\}/g,t.height);n=n.replace(/\{target\}/g,t.target);n=n.replace(/\{timestamp\}/g,this.PageRandomNumber);n=t.type?n.replace(/\{type\}/g,"type="+encodeURIComponent(t.type)+";"):n.replace(/\{type\}/g,"");var i=encodeURIComponent(location.href);return n.length+i.length<2048?n.replace(/\{dc_ref\}/g,"dc_ref="+i+";"):n.replace(/\{dc_ref\}/g,"")},EscapeSpecialCharacters:function(n){var t=n.tags,i;t=t.replace(/\+/gi,"{plus}");t=t.replace(/\#/gi,"{sharp}");t=t.replace(/\./gi,"{dot}");t=t.replace(/[\#\*\.\(\)\+\<\>\[\]]/gi,"");for(var r=t.split(","),u=[];r.length>0;)i=r.shift(),/[^\u0020-\u007f]/.test(i)||u.push(i);return u.join(",")},tagInfo:[{id:1,n:"Standard Banner",h:60,w:468},{id:2,n:"Product Spotlight",h:2,w:1},{id:3,n:"Hosting Spotlight",h:2,w:1},{id:4,n:"Skyscraper",h:600,w:120},{id:5,n:"Square",h:125,w:125},{id:6,n:"Medium Rectangle",h:250,w:300},{id:7,n:"Large Rectangle",h:280,w:336},{id:8,n:"Leaderboard",h:90,w:728},{id:9,n:"HTML Ad",h:0,w:0},{id:10,n:"Fixed Square",h:125,w:125},{id:11,n:"Fixed Banner",h:60,w:468},{id:12,n:"Half Skyscraper",h:300,w:120},{id:13,n:"IAB Button",h:90,w:120},{id:14,n:"Rectangle",h:120,w:150},{id:15,n:"Thin Horizontal",h:27,w:408},{id:16,n:"Button",h:30,w:100},{id:17,n:"DogEar",h:0,w:0},{id:18,n:"Wide Skyscraper",h:600,w:160},{id:19,n:"Tracking Only",h:1,w:1},{id:20,n:"Mixed 120x90-Text",h:5,w:1},{id:21,n:"Home page top left (150 X 80)",h:80,w:150},{id:22,n:"SponsorEmail",h:0,w:0},{id:23,n:"Email",h:60,w:60},{id:24,n:"TextLinks",h:0,w:0},{id:25,n:"Zone",h:0,w:0},{id:26,n:"Goal group",h:0,w:0},{id:27,n:"Article",h:0,w:0},{id:28,n:"Search Sponsor Box",h:30,w:120},{id:29,n:"Microbar",h:31,w:88},{id:30,n:"Sponsor Link",h:1,w:0}],DetermineTagSize:function(n){var i,u,r,t;if(n.format)if(isNaN(n.format))i=n.format.split("x"),i.length==2&&(isFinite(i[0])&&(n.width=i[0]),isFinite(i[1])&&(n.height=i[1]));else for(u=!1,r=0;r<this.tagInfo.length&&!u;)t=this.tagInfo[r],t.id==n.format&&(t.w!=0&&(n.width=t.w),t.h!=0&&(n.height=t.h),n.type=t.name,u=!0,n.format=""+t.w+"x"+t.h),r++},MapDmIdsToDart:function(n){var t="lqm.",i=".site";n.publisher?(n.sitename=isNaN(n.publisher)?n.publisher:t+"pub"+n.publisher+i,this.MapDmZoneToDartZone(n)):n.site&&(n.sitename=t+"codeplex"+i,n.zonename=n.charity?"donated2charity":n.site.toLowerCase())},GetRequestData:function(n){var e=[],u,r,f;for(adIndex=0;adIndex<n.length;adIndex++){var s=n[adIndex],t={height:0,width:0,publisher:undefined,zone:undefined,site:undefined,tags:undefined,sitename:undefined,zonename:undefined,target:undefined,format:undefined,tile:undefined,type:undefined},o=s.attributes,h=o.length,i={};for(u=0;u<h;u++)r=o.item(u),r.nodeName.indexOf("lqm_")==0&&(f=r.nodeName.slice(4),i[f]=r.nodeValue),r.nodeName.indexOf("data-")==0&&(f=r.nodeName.slice(5),i[f]=r.nodeValue);t.publisher=i.publisher;t.zone=i.zone;t.site=i.site;t.tags=i.tags;t.format=i.format;t.charity=i.charity;t.tile=adIndex+1;t.target="_blank";t.tags&&(t.tags=decodeURIComponent(t.tags));DMAds.DetermineTagSize(t);DMAds.MapDmIdsToDart(t);e[adIndex]=t}return e},zoneInfo:[{id:1,n:"ron"},{id:51,n:"it"},{id:52,n:"designer"},{id:2,n:"above_the_fold"},{id:9,n:"wpf"},{id:14,n:"silverlight"},{id:3,n:"reportingservices"},{id:4,n:"sql"},{id:5,n:"whitepaper"},{id:6,n:"featuredwhitepaper"},{id:7,n:"crystalreports"},{id:10,n:"vs2005video"},{id:11,n:"ros_dogear"},{id:12,n:"homepage_dogear"},{id:13,n:"excludehomepage_dogear"},{id:15,n:"lqm_dogear"},{id:17,n:"mvc"},{id:18,n:"ajax"},{id:38,n:"devexpress_video"},{id:39,n:"devmavens_sidebar"},{id:40,n:"devmavens_offer"},{id:44,n:"silverlight"},{id:45,n:"wpf"},{id:54,n:"csharp_articles"}],MapDmZoneToDartZone:function(n){if(n.zone){for(var i=!1,t=0;t<this.zoneInfo.length&&!i;)this.zoneInfo[t].id==n.zone&&(n.zonename=this.zoneInfo[t].n,i=!0),t++;i||(n.zonename=isNaN(n.zone)?n.zone.toLowerCase():"ron")}else n.zonename="ron"},GetDocHeight:function(n){return n.height||n.body&&n.body.scrollHeight},HideRefs:function(n,t,i){var e=this,u,f,o,r;for(i.format.indexOf("1x")===0?(t.innerHTML=n.body.innerHTML,u=t):u=n,f=u.getElementsByTagName("a"),o=function(n){var t=n.href,i,f=t.indexOf("&adurl="),r,u;if(i=f>0?decodeURIComponent(t.substring(f+7)):adServer+e.GetRandom(4,16)+"-"+e.GetRandom(7,16),n.href=i,r=function(){n.href=t},u=function(){n.href=i},n.addEventListener)n.addEventListener("mousedown",r,!1),n.addEventListener("mouseover",u,!1);else try{n.attachEvent("onmousedown",r);n.attachEvent("onmouseover",u)}catch(o){}},r=0;r<f.length;r++)o(f[r])},GetDomain:function(){var t=document.location.hostname,n=/([^.]+\.[^.]{3,})$/i.exec(t);return n!=null?n[1]:(n=/([^.]+\.[^.]+\.[^.]{2})$/i.exec(t),n!=null?n[1]:t)},SetCookie:function(n,t,i,r,u,f){var e="",o;e=n+"="+t;i>0&&(o=new Date,o.setTime(o.getTime()+i*864e5))&&(e+="; expires="+o.toGMTString());r&&(e+="; path="+r);u&&u.indexOf(".")!=-1&&(e+="; domain="+u);f&&(e+="; secure");document.cookie=e},GetCookieValue:function(n){var r=document.cookie,u=null,t,i;if(r!="")for(t=r.split(";"),index=0;index<t.length;index++)if(i=t[index].replace(/^\s+/,""),i.substring(0,n.length+1)==n+"="){u=i.substring(n.length+1);break}return u},CookiesEnabled:function(){return navigator.cookieEnabled!=void 0?navigator.cookieEnabled:(document.cookie="testcookie=test; max-age=10000",document.cookie.indexOf("testcookie=test")>=0)},CreateDMIFrame:function(n){var t=document.createElement("IFRAME");return t.width=1,t.height=1,t.src=GlobalIdUrl,t.id="DMGlobalUserIdetifierIFRAME",t.name="DMGlobalUserIdetifierIFRAME",t.style.display="none",document.body.appendChild(t),t.onload=n,t},DmGlobalUserId:0,DmGlobalUserIdKey:"dmaduid",DmGlobalUserIdCookieConfirmedKey:"dmaduid_confirm",PublisherPageViewID:0};if(typeof DMAds.CreateAds!="function"&&(DMAds.CreateAds=function(){var f=this,v=1e3,r,n,a;this.PageRandomNumber=this.GetRandom(32,16);var it=function(n,t,i,r){var o=[],u,e;i==null&&(i=document);r==null&&(r="*");var f=i.getElementsByTagName(r),s=f.length,h=new RegExp("(^|\\s)"+t+"(\\s|$)");for(u=0,e=0;u<s;u++)h.test(f[u].getAttribute(n))&&(o[e]=f[u],e++);return o},y=function(n,t,i){var e=[],r,f;t==null&&(t=document);i==null&&(i="*");var u=t.getElementsByTagName(i),o=u.length,s=new RegExp("(^|\\s)"+n+"(\\s|$)");for(r=0,f=0;r<o;r++)s.test(u[r].className)&&(e[f]=u[r],f++);return e},rt=function(n,t,i,r){var e=50,u=0,o=window.setInterval(function(){var i=f.GetDocHeight(n);i>0&&((--e==0||i===u)&&(window.clearInterval(o),f.HideRefs(n,r,t),p(n,t,r)&&w(t,n,r)),u=i)},100)},p=function(n,t,r){var f=n.getElementsByTagName("body")[0],u=[],e=muteButton=!1,s=r.getAttribute("data-sticky")&&r.getAttribute("data-sticky").toLowerCase()==="top";for(f&&o(f.childNodes,u),i=0;i<u.length;i++)String(u[i]).indexOf("www.google.com/adsense/support/")>=0||String(u[i]).indexOf("ad_choices")>=0||String(u[i]).indexOf("adchoices")>=0||String(u[i]).indexOf("betrad.com")>=0||f&&y("GoogleActiveViewClass",f,"div").length>0?e=!0:String(u[i]).indexOf("x_button")>=0&&(muteButton=!0);return EnableMutableAds&&e&&!muteButton&&!s},w=function(n,t,i,r){var u=document.createElement("input"),f;u.type="image";u.src=CloseAdImageUrl;u.title="Close Ad";u.style.cssText="z-index:1000; position:fixed; left:0px; top:0px";f=ut(n);n.closeAdButton=u;n.adIFrame=i;n.closeAdDisplay=f;r.getElementsByTagName("body")[0].appendChild(u);t.appendChild(f);u.onclick=function(){return ft(n),!1}},ut=function(n){var i=parseInt(n.width),r=parseInt(n.height),u=document.createElement("div"),e,o,f;return u.style.cssText="display:none; width:"+i+"px; height:"+r+"px; z-index=100; text-align:left;border-style:solid; border-width:1px; position:relative; font:14px/18px 'Segoe UI', Arial; background-color:white",e="<select class='reportReason' max-width='100px'><option>Offensive<\/option><option>Abusive<\/option><option>Off topic<\/option><option>Don't like the Ad<\/option><\/select>",o="<a class='reportButton' padding='0px' href='javascript:void(0);'>Report<\/a>",i==728&&r==90?u.innerHTML="<div class='sendReportContainer' style='padding: 15px 20px;'><div style='padding-bottom:13px;'><b>Don't like this Ad?<\/b><\/div><div style='padding-bottom:10px;'>\tPlease tell us why: "+e+"&nbsp;"+o+"<\/div><\/div><div class='reportSentContainer' style='display:none; padding: 15px 20px;'><span style='color:#999'>Thank you for the report!<\/span><\/div><a href='http://www.developermedia.com/' target='_blank'><img src='"+DmLogoImageUrl+"' style='max-width:100%;position:absolute; right:20px; bottom:20px;'><\/a>":i==300&&r==250?u.innerHTML="<div class='sendReportContainer' style='padding: 30px 20px;'><div style='padding-bottom:20px;'><b>Don't like this Ad?<\/b><\/div><div style='padding-bottom:40px;'>Please tell us why:"+e+"<\/div><div>"+o+"<\/div><\/div><div class='reportSentContainer' style='display:none; padding: 15px 20px;'><span style='color:#999;'>Thank you for the report!<\/span><\/div><a href='http://www.developermedia.com/' target='_blank'><img src='"+DmLogoImageUrl+"' style='max-width:100%;position:absolute; right:20px; bottom:20px;'><\/a>":i==160&&r==600&&(u.innerHTML="<div class='sendReportContainer' style='padding: 30px 20px;'><div style='padding-bottom:20px;'><b>Don't like this Ad?<\/b><\/div><div style='padding-bottom:60px;'>Please tell us why: "+e+"<\/div><div>"+o+"<\/div><\/div><div class='reportSentContainer' style='display:none; padding: 15px 20px;'><span style='color:#999;'>Thank you for the report!<\/span><\/div><a href='http://www.developermedia.com/' target='_blank'><img src='"+DmLogoImageUrl+"' style='max-width:120px;position:absolute; right:20px; bottom:20px;'><\/a>"),(i==728&&r==90||i==300&&r==250||i==160&&r==600)&&(u.getElementsByClassName("reportButton")[0].onclick=function(){return et(n),!1}),f=document.createElement("input"),f.type="image",f.src=UndoCloseAdImageUrl,f.title="Show Ad",f.style.cssText="z-index:1000; position:absolute; left:0px; top:0px; width:14px; height:14px",u.appendChild(f),f.onclick=function(){var i={};return i.AdvertisementDownvoteID=n.AdvertisementDownvoteID?n.AdvertisementDownvoteID:0,t(UndoDownvoteUrl,i,function(){k(n)}),!1},u},o=function(n,t){for(var i=n[0],r;i;){if(i.tagName==="IMG")t[t.length]=i.src;else if(i.tagName==="A")t[t.length]=i.href;else if(i.tagName==="IFRAME")try{r=i.contentDocument||i.contentWindow.document||i.contentWindow.window.document;o(r.getElementsByTagName("body")[0].childNodes,t)}catch(u){}else i.tagName==="PARAM"&&i.name==="movie"?t[t.length]=i.value:i.tagName==="EMBED"?t[t.length]=i.src:i.tagName==="OBJECT"&&i.type==="application/x-shockwave-flash"&&(t[t.length]=i.data);i.childNodes.length>0&&o(i.childNodes,t);i=i.nextSibling}},ft=function(n){var r,u,i;n.adIdentifiers||(r=[],doc=n.adIFrame.contentDocument||elem.contentWindow.document||elem.contentWindow.window.document,o(doc.childNodes,r),n.adIdentifiers=r);u=function(responseText){var returnedObject=JSON&&JSON.parse(responseText)||eval("("+responseText+")");returnedObject&&(n.AdvertisementDownvoteID=returnedObject.AdvertisementDownvoteID,n.DownvoteCount=returnedObject.DownvoteCount);k(n)};i={};i.adIdentifiers=n.adIdentifiers;i.DmGlobalUserId=DMAds.DmGlobalUserId;t(DownvoteUrl,i,function(n){u(n)})},et=function(n){var i={},r;i.AdvertisementDownvoteID=n.AdvertisementDownvoteID?n.AdvertisementDownvoteID:0;r=n.closeAdDisplay.getElementsByClassName("reportReason")[0];i.reason=r.options[r.selectedIndex].value;t(ReportAdUrl,i,function(){var t=n.closeAdDisplay.getElementsByClassName("sendReportContainer")[0],i=n.closeAdDisplay.getElementsByClassName("reportSentContainer")[0];t.style.display="none";i.style.display="block"})},ot=function(n,t){var i=t.getElementsByTagName("body")[0],u,r;if(i.childNodes&&i.childNodes.length==1&&i.childNodes[0].nodeName=="A"&&i.childNodes[0].firstChild&&i.childNodes[0].firstChild.nodeName=="IMG")if(u=i.childNodes[0],r=i.childNodes[0].firstChild,r.addEventListener)r.addEventListener("click",function(){b(n,u.href)},!1);else try{r.attachEvent("onclick",function(){b(n,u.href)})}catch(f){}},b=function(n,i){var r={};r.PublisherPageViewID=DMAds.PublisherPageViewID;r.ClickedAdIndex=n;r.AnchorUrl=i;t(AdClickUrl,r,function(){})},t=function(n,t,i){var r=window.XMLHttpRequest?new XMLHttpRequest:new ActiveXObject("MSXML2.XMLHTTP"),u=JSON.stringify(t);server_write_timeout=setTimeout(function(){r.abort()},v);r.onreadystatechange=function(){try{r.readyState==4&&(clearTimeout(server_write_timeout),r.status==200?i(r.responseText):i(null))}catch(n){clearTimeout(server_write_timeout);i(null)}};try{r.open("POST",n,!0);r.setRequestHeader("Content-Type","application/json");r.send(u)}catch(f){i(null)}},k=function(n){n.adIFrame.style.display=n.adIFrame.style.display==="none"?"":"none";n.closeAdDisplay.style.display=n.closeAdDisplay.style.display==="none"?"inline-block":"none"},st=function(n){setTimeout(function(){n&&n.body&&top.postMessage&&top.postMessage(n.body.innerHTML?"DM-enabled":"DM-disabled","*")},1e3)},d=function(t){var o=n[t],u=l[t],e,i,s,h,c;if(r&&r!=""&&(u.tags=u.tags?u.tags+","+r:r),o.innerHTML=f.BuildIFrameTag(u),e=o.getElementsByTagName("iframe")[0],e.onerror=function(){return!0},i=e.contentDocument||e.contentWindow.document||e.contentWindow.window.document,s=function(){u.height<=1&&(this.height=f.GetDocHeight(i));f.HideRefs(i,o,u);setTimeout(function(){p(i,u,o)&&w(u,o,e,i);ot(t,i)},2e3)},e.addEventListener)e.addEventListener("load",s,!1);else try{e.attachEvent("onload",s)}catch(a){}h=navigator.userAgent&&navigator.userAgent.indexOf("MSIE")>=0;c=navigator.userAgent&&navigator.userAgent.indexOf("Opera")>=0;i.write(f.BuildJavaScriptTag(u));h||c||!i.close||i.close();(h||c)&&rt(i,u,e,o);st(i)},ht=function(n){var r=n.getBoundingClientRect(),i=0,t=0;return typeof window.innerWidth=="number"?(i=window.innerWidth,t=window.innerHeight):document.documentElement&&(document.documentElement.clientWidth||document.documentElement.clientHeight)?(i=document.documentElement.clientWidth,t=document.documentElement.clientHeight):document.body&&(document.body.clientWidth||document.body.clientHeight)&&(i=document.body.clientWidth,t=document.body.clientHeight),r.top<=t&&r.bottom>=0},s=function(){for(var t=0;t<n.length;t++)e[t]===!1&&ht(n[t])&&(e[t]=!0,d(t)),e[t]===!0&&(u[t]||(u[t]=g(t)),tt(t))},ct=function(i,u,f){var k=window.XMLHttpRequest?new XMLHttpRequest:new ActiveXObject("MSXML2.XMLHTTP"),o,c,e,s,l,p,a,h,w,y,b;if(!k||!JSON)return f();o=document.URL;o.indexOf("?")>0&&(o=o.substring(0,o.indexOf("?")));try{c=top.document.title}catch(d){c="FAILED TO GET DOCUMENT TITLE"}if(e={},e.terms=i,e.title=c,e.url=o,e.publisher=u,e.DmGlobalUserId=DMAds.DmGlobalUserId,e.numberOfAdsOnPage=n!=null?n.length:0,s=function(n){if(clearTimeout(server_write_timeout),n){var t=JSON.parse(n);t?(t.terms&&(r=i+","+t.terms),t.PublisherPageViewID&&(DMAds.PublisherPageViewID=t.PublisherPageViewID)):r=i}f()},DMAds.CookiesEnabled())if(l=DMAds.GetCookieValue(DMAds.DmGlobalUserIdKey),p=DMAds.GetCookieValue(DMAds.DmGlobalUserIdCookieConfirmedKey),!p&&JSON){if(a=!1,h={},h.sender=location.href,h.Id=DMAds.PageRandomNumber,receiveMessageTimeout=setTimeout(function(){a=!0;t(SearchTermUrl,e,s)},v),w=function(){b.contentWindow.postMessage(JSON.stringify(h),GlobalIdUrl)},y=function(n){var i=null,r;try{i=JSON.parse(n.data)}catch(u){}i&&i.Id&&i.Id===h.Id&&(clearTimeout(receiveMessageTimeout),r=DMAds.GetDomain(),DMAds.SetCookie(DMAds.DmGlobalUserIdKey,i.DmGlobalUserId,18250,"/",r,!1),DMAds.SetCookie(DMAds.DmGlobalUserIdCookieConfirmedKey,i.DmGlobalUserConfirmResponse,18250,"/",r,!1),e.DmGlobalUserId=i.DmGlobalUserId,DMAds.DmGlobalUserId=i.DmGlobalUserId,a||t(SearchTermUrl,e,s))},window.addEventListener)window.addEventListener("message",y,!1);else try{window.attachEvent("message",y)}catch(g){}b=DMAds.CreateDMIFrame(w)}else e.DmGlobalUserId=l,DMAds.DmGlobalUserId=l,t(SearchTermUrl,e,s);else t(SearchTermUrl,e,s)},h=function(){for(var u=n[0].getAttribute("lqm_publisher")||n[0].getAttribute("data-publisher"),r=u===CodeProjectPublisherId,i,t=0;t<n.length;t++)e[t]=!1,i=n[t].getAttribute("data-display")||n[t].getAttribute("lqm_loadOnView"),i==="onscroll"||i==="true"?r=!0:(i==="always"||i==="false")&&(r=!1),r||(d(t),e[t]=!0);if(s(),window.addEventListener)window.addEventListener("resize",nt,!1),window.addEventListener("scroll",s,!1);else try{window.attachEvent("onresize",nt);window.attachEvent("onscroll",s)}catch(f){}lt(QuantScriptRequired)},lt=function(n){var t,i;n&&(t=document.createElement("script"),t.src=(document.location.protocol=="https:"?"https://secure":"http://edge")+".quantserve.com/quant.js",t.async=!0,t.type="text/javascript",i=document.getElementsByTagName("script")[0],i.parentNode.insertBefore(t,i))},g=function(t){if(n[t].children[0]){var r=c(n[t].children[0]),i={};return(i.isStickyRequired=n[t].getAttribute("data-sticky")&&n[t].getAttribute("data-sticky").toLowerCase()==="top",i.absoluteTop=r.y,i.absoluteLeft=r.x,i.absoluteTop===-1)?null:(i.originalPosition=n[t].style.position,i)}},nt=function(){for(i=0;i<u.length;i++)u[i]&&(n[i].children[0].style.position=u[i].originalPosition,u[i]=g(i),tt(i))},tt=function(t){var i=u[t],r,s,o,h,f,e;i&&i.isStickyRequired&&n[t].children[0].getBoundingClientRect&&document.getElementsByClassName&&(r=document.getElementsByClassName("sticky-stop")[0],r&&(s=c(r),o=r.getBoundingClientRect()),h=c(n[t].children[0]),f=n[t].children[0].getBoundingClientRect(),r&&h.y+f.height+Math.abs(f.top)>s.y&&o.top<f.height?e=o.top-f.height+"px":window.pageYOffset+10>=i.absoluteTop&&(e="10px"),e?(n[t].children[0].style.position="fixed",n[t].children[0].style.top=e,n[t].children[0].style.left=i.absoluteLeft-window.pageXOffset+"px",n[t].clientHeight===0&&(n[t].style.height=n[t].children[0].clientHeight+"px"),n[t].clientWidth===0&&(n[t].style.width=n[t].children[0].clientWidth+"px")):n[t].children[0].style.position=i.originalPosition)},c=function(n){var t={};if(t.x=-1,t.y=-1,n.getBoundingClientRect){var r=n.getBoundingClientRect(),i=document.documentElement,u=window.pageYOffset||i.scrollTop||document.body.scrollTop||0,f=window.pageXOffset||i.scrollLeft||document.body.scrollLeft||0,e=i.clientTop||document.body.clientTop||0,o=i.clientLeft||document.body.clientLeft||0;t.y=r.top+u-e;t.x=r.left+f-o}return t},e=[],u=[],l=[];if(this.PageSearchTerms==null&&(this.PageSearchTerms=this.GetQueryTerms()),r=this.PageSearchTerms,n=y("lqm_ad",document,"div"),(n==null||n.length<=0)&&(n=it("data-type","ad",document,"div")),n!=null&&n.length>0)if(l=DMAds.GetRequestData(n),a=l[0].sitename,SendSearchTermsToServer&&(!OnlySendForCodeProject||a===CodeProjectPublisherId))try{ct(r,a,h)}catch(at){h()}else h()}),document.readyState==="complete")DMAds.CreateAds();else if(window.addEventListener)window.addEventListener("load",function(){DMAds.CreateAds()},!1);else try{window.attachEvent("onload",function(){DMAds.CreateAds()})}catch(e){}_qevents=_qevents||[];_qevents.push({qacct:"p-g6uZkrDA2nB2y"})}