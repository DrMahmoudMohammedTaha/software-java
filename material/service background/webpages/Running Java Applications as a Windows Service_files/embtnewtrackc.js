// JQuery Plugin to Track Marketing Campaign Codes
 (function (jQuery, document, undefined) {
        var pluses = /\+/g;
        function raw(s) {
            return s;
        }
        function decoded(s) {
            return decodeURIComponent(s.replace(pluses, ' '));
        }
        var config = jQuery.cookie = function (key, value, options) {
            // write
            if (value !== undefined) {
                options = jQuery.extend({}, config.defaults, options);
                if (value === null) {
                    options.expires = -1;
                }
                if (typeof options.expires === 'number') {
                    var days = options.expires, t = options.expires = new Date();
                    t.setDate(t.getDate() + days);
                }
                value = config.json ? JSON.stringify(value) : String(value);
                return (document.cookie = [
                    encodeURIComponent(key), '=', config.raw ? value : encodeURIComponent(value),
                    options.expires ? '; expires=' + options.expires.toUTCString() : '', 
                    options.path ? '; path=' + options.path : '',
                    options.domain ? '; domain=' + options.domain : '',
                    options.secure ? '; secure' : ''
                ].join(''));
            }
            // read
            var decode = config.raw ? raw : decoded;
            var cookies = document.cookie.split('; ');
            for (var i = 0, parts; (parts = cookies[i] && cookies[i].split('=')); i++) {
                if (decode(parts.shift()) === key) {
                    var cookie = decode(parts.join('='));
                    return config.json ? JSON.parse(cookie) : cookie;
                }
            }
            return null;
        };
        config.defaults = {};
        jQuery.removeCookie = function (key, options) {
            if (jQuery.cookie(key) !== null) {
                jQuery.cookie(key, null, options);
                return true;
            }
            return false;
        };
    })
	
	(jQuery, document);
	
        jQuery(function() {
			
            var requestid = gup('cid');
            if (requestid)  {
                    jQuery.cookie("sfcid_embt", requestid, { expires: 90, path: '/', domain: '.embarcadero.com' }); 	  
                    }
        })
					
          function gup(name) {
               name = name.replace(/[\[]/, "\\\[").replace(/[\]]/, "\\\]");
               var regexS = "[\\?&]" + name + "=([^&#]*)";
               var regex = new RegExp(regexS);
               var results = regex.exec(window.location.href);
                if (results == null)
                   return "";
                else
                   return results[1];
            }
    
