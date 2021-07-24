//	utils.js: JCE Utilities script
//	by Ryan Demmer (http://www.cellardoor.za.net)
	
//  CREDITS:
//	Based on...
//	Lightbox v2.02 - Lokesh Dhakar - http://www.huddletogether.com
//  Thickbox 2.0 - Cody Lindley - http://www.codeylindley.com
//  Litebox v1.0 - http://doknowevil.net/litebox
//  Everything else by me.

//	Uses the awesome mootools library - http://mootools.net

//	Licensed under the Creative Commons Attribution 2.5 License - http://creativecommons.org/licenses/by/2.5/
//  only because Lightbox is and is a condition of the above licence, otherwise it would be under an MIT-style license.

//  Should work with all modern browsers - FF 1.5, IE 6 & 7, Opera 9, Safari

var isMSIE = (navigator.appName == "Microsoft Internet Explorer");
var ua = navigator.userAgent;
var isMSIE_7 = isMSIE && (ua.indexOf('MSIE 7') != -1);
var isGecko = ua.indexOf('Gecko') != -1;
var isSafari = ua.indexOf('Safari') != -1;
var isOpera = ua.indexOf('Opera') != -1;

//Additional Element functions
Element.extend({ 
	hide: function(){ 
		this.style.display = 'none'; 
		return this; 
	}, 
	show: function(){ 
		this.style.display = ''; 
		return this; 
	},
	setProperty: function(property, value){
		if (property == 'class') this.className = value;
		else if (property == 'style') this.setStyles(value);
		else this.setAttribute(property, value);
		return this;
	},
	removeProperty: function(property){
		this.removeAttribute(property);
		return this;
	},	
	removeProperties: function(source){
		for (property in source) this.removeProperty(property);
		return this;
	}
});
//Quirksmode, IE 5.5 workaround, add document.body
Window.extend({
	getWidth: function(){
		return window.innerWidth || document.documentElement.clientWidth || document.body.clientWidth || 0;
	},
	
	getHeight: function(){
		return window.innerHeight || document.documentElement.clientHeight || document.body.clientHeight || 0;
	},
	getScrollHeight: function(){
		return document.documentElement.scrollHeight || document.body.scrollHeight;
	},
	
	getScrollWidth: function(){
		return document.documentElement.scrollWidth || document.body.scrollWidth;
	},
	getScrollTop: function(){
		return document.documentElement.scrollTop || window.pageYOffset || document.body.scrollTop || 0;
	},
	getScrollLeft: function(){
		return document.documentElement.scrollLeft || window.pageXOffset || document.body.scrollLeft || 0;
	}
});
function jceUtilities(){
	this.config = {
		convert		: 1,
		
		png_fix		: 0,
		
		pngfix_id	: '_trans',
	
		fadespeed	: 500,

		scalespeed	: 500,

		tipclass	: 'tooltip'
	}
};
//  Borrowed from TinyMCE - http://tinymce.moxiecode.com
jceUtilities.prototype.cleanupEventStr = function(s) {
	s = "" + s;
	s = s.replace('function anonymous()\n{\n', '');
	s = s.replace('\n}', '');
	s = s.replace(/^return true;/gi, ''); // Remove event blocker

	return s;
};
jceUtilities.prototype.parseQuery = function ( query ) {
   var params = new Object ();
   if ( ! query ) return params; // return empty object
   var pairs = query.split(/[;&]/);
   for ( var i = 0; i < pairs.length; i++ ) {
      var kv = pairs[i].split('=');
      if ( ! kv || kv.length != 2 ) continue;
      var k = unescape( kv[0] );
      var v = unescape( kv[1] );
      v = v.replace(/\+/g, ' ');
      params[k] = v;
   }
   return params;
};
jceUtilities.prototype.init = function(){
	jceutils.convert();
	new Tips($S('.jce_tooltip'), {className: jceutils.config.tipclass});
};
jceUtilities.prototype.initBox = function(el){
	JCEBox.showBox(el);
	el.blur();
	return false;
};
jceUtilities.prototype.convert = function(){
	//Fix IE control activation
	if(isMSIE || isOpera){
		$S('object').action ({
			initialize: function(){ 
				this.outerHTML = this.outerHTML;
			}
		});
	}
	//IE PNG Fix
	if(isMSIE && !isMSIE_7){
		if(jceutils.config.pngfix == 1){
			$S('img').action ({
				initialize: function(){
					if(this.src.toLowerCase().match(/\.png/g) && (jceutils.config.pngfix_id == 'all' || (this.src.toLowerCase().match(jceutils.config.pngfix_id, 'g') || this.className.toLowerCase().match(jceutils.config.pngfix_id, 'g')))){					
						this.setStyle('filter', 'progid:DXImageTransform.Microsoft.AlphaImageLoader(src=\'' + this.src + '\', sizingMethod=\'\')');
						this.setProperty('src', 'mambots/system/jceutils/images/blank.gif');
					}
				}
			});
		}
	}
	$S('a').action({
		initialize: function(){
			if(jceutils.config.convert == 1){
				var matched = false;
				var temp = 'index2.php?option=com_jce&task=popup';
				if(this.href.indexOf(temp) != -1 || jceutils.cleanupEventStr(this.getAttribute('onclick')).indexOf(temp) != -1){
					var src = jceutils.cleanupEventStr(this.getAttribute('onclick'));
					src = src.replace(/&amp;/g, '&').replace(/&#39;/g, "'");
					matched = true;
				}
				if(this.href.indexOf("mosce/jscripts/tiny_mce/popupImage.php") != -1){
					var src = this.href.replace(/&amp;/g, '&').replace(/&#39;/g, "'").replace(/&quot;/g, '"');
					src = src.replace(/[\(\'\)\;]/g, '');
					src = src.replace(/\?/g, '&');
					matched = true;
				}
				if(matched){
					var params = jceutils.parseQuery( src );
					this.setProperties({'href': params['img'], 'title': params['title'].replace(/_/g, ' ')}).addClassName('jcebox').removeProperties('target', 'onclick');
					this.onclick = function(){
						jceutils.initBox(this);	
						return false;
					}	
				}
			}
			if(this.className == 'jcebox'){
				this.onclick = function(){
					jceutils.initBox(this);	
					return false;
				}
			}
		}
	});
};
//
//	Global Variables
//
var imgArr = new Array;
var activeImg;
// -----------------------------------------------------------------------------------

var JCEBox = {
	el : null,
	href : null,
	caption : null,
	group : null,
	type : null,
	showBox : function(el){		
		this.el = el;
		this.href = el.href;
		this.caption = el.title || el.name || null;
		this.group = el.rel || false;
		
		if(this.caption == null) this.caption = '';

		if(!$('selectblocker')){
			if(isMSIE && !isMSIE_7){
				new Element('iframe').setProperty('id','selectblocker').injectInside($E('body')).setStyle('height', Window.getScrollHeight());
			}
		}
		new Element('div').setProperty('id','lightbox').injectInside($E('body')).hide();
		
		if(this.href.toLowerCase().match(/\.jpg|\.jpeg|\.png|\.gif|\.bmp/g)){
			this.type = 'image';				
			var html = '<div id="outerImageContainer">';
				html += '<div id="imageContainer">';
				html += '<a href="#" onclick="JCEBox.end(); return false;" title="Close">';
				html += '<img id="closeButton" src="mambots/system/jceutils/images/close.gif">';		
				html += '<img id="lightboxImage" />';
				html += '</a>';
				html += '<div id="loading"><a href="#" id="loadingLink" onclick="JCEBox.end(); return false;"><img src="mambots/system/jceutils/images/loading.gif"></a></div>';
				html += '</div>';
				html += '</div>';
				html += '<div id="imageDataContainer">';
				html += '<div id="imageData">';
				html += '<div id="imageDetails"><span id="caption"></span></div>';
				html += '<div id="imageNav"><span id="navDisplayPrev"></span><span id="numberDisplay"></span><span id="navDisplayNext"></span></div>';
				html += '</div>';
				html += '</div>';
		}else{
			this.type = 'iframe';
			var query = this.href.replace(/^[^\?]+\??/,'');
			var params = jceutils.parseQuery( query );
			
			var url = this.href.replace('&bw=' + params['bw'] + '&bh=' + params['bh'], '', 'g');
			
			var html = '<div id="outerIframeContainer">';
				html += '<div id="iframeContainer">';
				html += '<div id="iframeTop">';
				html += '<a href="#" onclick="JCEBox.end(); return false;" title="Close">';
				html += '<img id="closeButton" src="mambots/system/jceutils/images/close.gif">';		
				html += '</a>';
				html += '</div>';
				html += '<iframe src="' + url + '" frameborder="0" id="iframecontent" style="width:' + params['bw'] + 'px; height:' + params['bh'] + 'px;"></iframe>';
				html += '<div id="loading"><a href="#" id="loadingLink" onclick="JCEBox.end(); return false;"><img src="mambots/system/jceutils/images/loading.gif"></a></div>';
				html += '</div>';
				html += '</div>';
		}
		$('lightbox').setHTML(html);
		
		if($('lightboxImage')){
			$('imageDataContainer').hide();
			imageFx = new fx.Opacity('lightboxImage', { duration: jceutils.config.fadespeed, onComplete: function() { imageDetailsFx.toggle();}});
			imageFx.hide();
			imageDetailsFx = new fx.Opacity('imageDataContainer', { duration: jceutils.config.fadespeed }); 
			imageDetailsFx.hide();
		}
		if($('iframecontent')){
			imageFx = new fx.Opacity('iframecontent', { duration: jceutils.config.fadespeed });
			imageFx.hide();
		}				
		this.startBox();
	},
	startBox : function(){
		if(this.type == 'image'){	
			var el = this.el;
			var grp = this.group;
			imgArr = [];
			imageNum = 0;
	
			// if image is NOT part of a set..
			if(!grp){
				// add single image to imageArray
				imgArr.push(new Array(this.href, this.caption));
			} else {
			// if image is part of a set..
				$S('a').action({
					initialize: function(){ 
						if(this.href && (this.className == el.className) && (this.rel == grp)){   
							imgArr.push(new Array(this.href, this.title));
						}
					}
				});
				for(i = 1; i < imgArr.length; i++){
					if(imgArr[i][0] == imgArr[i-1][0]){
						imgArr.splice(i,1);
					}
				}
				while(imgArr[imageNum][0] != this.href) { 
					imageNum++;
				}
			}
			this.changeImage(imageNum);
		}else if(this.type == 'iframe'){
			$('loading').hide();
			var w = parseInt($('iframecontent').getStyle('width'));
			var h = parseInt($('iframecontent').getStyle('height'));
			
			//fallback
			w = (w == 0) ? parseInt($('iframecontent').style.width) : w;
			h = (h == 0) ? parseInt($('iframecontent').style.height) + 20 : h + 20;
			  			
			this.resizeContainer(w, h);
			$('lightbox').makeDraggable();
		}
		// calculate top offset for the lightbox and display 
		$('lightbox').setStyle('top', Window.getScrollTop() + (Window.getWidth() / 15) + 'px');
		$('lightbox').show();
	},
	//
	//	resizeImageContainer()
	//
	resizeContainer : function(w, h) {		
		var container = ( this.type == 'image' ) ? 'outerImageContainer' : 'outerIframeContainer';
		
		var cw = ($(container).style.width == 0) ? 250 : $(container).offsetWidth;
		var ch = ($(container).style.width == 0) ? 250 : $(container).offsetHeight;

		widthFx = new fx.Width($(container), { duration: jceutils.config.scalespeed, onComplete: function() { heightFx.custom(ch, h+20); }});
		widthFx.custom(cw, w+20);
		heightFx = new fx.Height($(container), { duration: jceutils.config.scalespeed, onComplete: function() { imageFx.custom(0,1); }});

		if(this.type == 'image'){
			$('imageDataContainer').setStyle('width', w + 20 + 'px').show();
			this.showImage();
		}
	},
	//	changeImage()
	//	Hide most elements and preload image in preparation for resizing image container.
	//
	changeImage: function(imageNum) {
		activeImg = imageNum;	// update global var
		// hide elements during transition
		$('loading').show();
		
		imageDetailsFx.hide();
		imageFx.hide();
		
		imgPreloader = new Image();
		// once image is preloaded, resize image container
		imgPreloader.onload = function(){
			$('lightboxImage').src = imgArr[activeImg][0];
			
			//Resize image if necessary
			var x = Window.getWidth() - 150;
			var y = Window.getHeight() - 150;
			var iw = imgPreloader.width;
			var ih = imgPreloader.height;
			
			if (iw > x) {
				ih = ih * (x / iw); 
				iw = x; 
				if (ih > y) { 
					iw = iw * (y / ih); 
					ih = y; 
				}
			} else if (ih > y) { 
				iw = iw * (y / ih); 
				ih = y; 
				if (iw > x) { 
					ih = ih * (x / iw); 
					iw = x;
				}
			}
			$('lightboxImage').width = iw;
			$('lightboxImage').height = ih;
			
			JCEBox.resizeContainer(iw, ih);
		}
		imgPreloader.src = imgArr[activeImg][0];
	},
	//
	//	showImage()
	//	Display image and begin preloading neighbors.
	//
	showImage: function(){
		$('loading').hide();
		this.updateDetails(); 
		this.preloadNeighborImages();
	},
	//
	//	updateDetails()
	//	Display caption, image number, and bottom nav.
	//
	updateDetails: function() {
		$('caption').setHTML(imgArr[activeImg][1]).show();
		
		$('numberDisplay').hide();
		$('navDisplayPrev').hide();
		$('navDisplayNext').hide();
		
		if(imgArr.length > 1){
			if(activeImg != 0){
				$('navDisplayPrev').setHTML('<a href="#" onclick="JCEBox.changeImage(' + (activeImg - 1) + '); return false;"><</a>&nbsp;&nbsp;').show();
			}
			if(activeImg != imgArr.length -1){
				$('navDisplayNext').setHTML('&nbsp;&nbsp;<a href="#" onclick="JCEBox.changeImage(' + (activeImg + 1) + '); return false;">></a>').show();
			}
			
			$('numberDisplay').setHTML('').show();
			for(var i=0; i<imgArr.length; i++){
				var num = i + 1;
				var seperator = (num == imgArr.length) ? '' : ' | ';
				var html = '';
				if(activeImg != i){
					html += '<a id="numberLink" href="#" onclick="JCEBox.changeImage(' + i + '); return false;">';
				}
				html += num;
				if(activeImg != i){
					html += '</a>';
				}
				html += seperator;
				$('numberDisplay').innerHTML += html;
			}
		}
		$('lightbox').makeDraggable();
		$('outerImageContainer').setStyle('borderBottom', '0px');
	},
	//
	//	preloadNeighborImages()
	//	Preload previous and next images.
	//
	preloadNeighborImages: function(){
		if((imgArr.length - 1) > activeImg){
			preloadNextImage = new Image();
			preloadNextImage.src = imgArr[activeImg + 1][0];
		}
		if(activeImg > 0){
			preloadPrevImage = new Image();
			preloadPrevImage.src = imgArr[activeImg - 1][0];
		}
	
	},
	end : function(){
		if(typeof(imageFx) != 'undefined'){
			imageFx.hide();
		}
		if($('lightbox')){
			$('lightbox').remove();
		}
		if($('selectblocker')){
			$('selectblocker').remove();
		}
	}
};
var jceutils = new jceUtilities();
Window.onDomReady(function(){jceutils.init();});