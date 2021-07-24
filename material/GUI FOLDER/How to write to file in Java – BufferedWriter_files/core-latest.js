function dd_load_js(){

	jQuery(document).ready(function($) {
		$.getScript('https://apis.google.com/js/plusone.js', function(){
			$('#dd-google').remove();
		}); 
	  }
	);

	jQuery(document).ready(function($) {
		$.getScript('http://platform.twitter.com/widgets.js', function(){
			$('#dd-twitter').remove();
		}); 
	  }
	);
	  
	
	jQuery(document).ready(function($) {

			var url = (window.location.href).split('#');
			
			var fbUrl = "http://www.facebook.com/plugins/like.php?href=" + url[0] + "&send=false&layout=box_count&show_faces=false&action=like&colorscheme=light&font=verdana&height=62&width=50";
			$('#dd-fblike-iframe').attr('src',fbUrl);
			
			$('#dd-fblike-iframe').load(function(){
				$('#dd-fblike-iframe').attr('width','50').attr('height','62');
				$('#dd-fblike').remove();
			});
					
			var fbPageUrl = "http://www.facebook.com/plugins/likebox.php?href=http://www.facebook.com/java.tutorial&width=300&colorscheme=light&show_faces=true&border_color&stream=false&header=false&height=260";
			$('#dd-fbpage-iframe').attr('src',fbPageUrl);
			
			$('#dd-fbpage-iframe').load(function(){
				$('#dd-fbpage-iframe').attr('width','300').attr('height','260');
				$('#dd-fbpage').remove();
			});
		
		}
	);

	jQuery(document).ready(function($) {

		var watermark = 'Puts your email address';

		$('#awf_field-32846329').val(watermark).addClass('watermark');

	 	$('#awf_field-32846329').blur(function(){
	  		if ($(this).val().length == 0){
	    		   $(this).val(watermark).addClass('watermark');
			}
	 	});

		$('#awf_field-32846329').focus(function(){
	  		if ($(this).val() == watermark){
	    		   $(this).val('').removeClass('watermark');
			}
	 	});
	});
	
	jQuery(document).ready(function($){

		var $postShare = $('#dd_light_ajax_float');
		
		if($('#dd_content_wrap').length > 0){
		
			var descripY = parseInt($('#dd_content_wrap').offset().top) - 20;
			var pullX = $postShare.css('margin-left');
		
			$(window).scroll(function () { 
			  
				var scrollY = $(window).scrollTop();
				var fixedShare = $postShare.css('position') == 'fixed';
				
				if($('#dd_light_ajax_float').length > 0){
				
					if ( scrollY > descripY && !fixedShare ) {
						$postShare.stop().css({
							position: 'fixed',
							top: 18
						});
					} else if ( scrollY < descripY && fixedShare ) {
	  
						$postShare.css({
							position: 'absolute',
							top: 290,
							marginLeft: pullX
						});

					}
					
				}
		
			});
		}
	});
	
}

if (typeof jQuery == 'undefined') {
	var ddscript = document.createElement('script');
	ddscript.src = 'http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js';
	ddscript.onloadDone = false;
	ddscript.onload = function(){
		ddscript.onloadDone = true;
		dd_load_js();
	};
	ddscript.onreadystatechange = function(){
		if ('loaded' == ddscript.readyState && !ddscript.onloadDone){
			ddscript.onloadDone = true;
			dd_load_js();
		}
	};
	document.getElementsByTagName('head')[0].appendChild(ddscript);
}else{

	dd_load_js();

}
