
		jQuery(document).ready(function(){ 
				jQuery(".button").hover(function () {
					jQuery(this).animate({
						opacity: 0.7
					}, 200);
					},function(){
					jQuery(this).animate({
						opacity: 1	      			
					}, 200);
				});
				jQuery(".button_big").hover(function () {
					jQuery(this).animate({
						opacity: 0.7
					}, 200);
					},function(){
					jQuery(this).animate({
						opacity: 1	      			
					}, 200);
				});				
				jQuery(".button_small").hover(function () {
					jQuery(this).animate({
						opacity: 0.7
					}, 200);
					},function(){
					jQuery(this).animate({
						opacity: 1	      			
					}, 200);
				});				
				jQuery(".button_medium").hover(function () {
					jQuery(this).animate({
						opacity: 0.7
					}, 200);
					},function(){
					jQuery(this).animate({
						opacity: 1	      			
					}, 200);
				});				
				jQuery(".button_large").hover(function () {
					jQuery(this).animate({
						opacity: 0.7
					}, 200);
					},function(){
					jQuery(this).animate({
						opacity: 1	      			
					}, 200);
				});
				jQuery("#cancel-comment-reply-link").hover(function () {
					jQuery(this).animate({
						opacity: 0.6
					}, 200);
					},function(){
					jQuery(this).animate({
						opacity: 1	      			
					}, 200);
				});
				jQuery(".comment-reply-link").hover(function () {
					jQuery(this).animate({
						opacity: 0.6
					}, 200);
					},function(){
					jQuery(this).animate({
						opacity: 1	      			
					}, 200);
				});	
				jQuery(".hover").hover(function () {
					jQuery(this).animate({
						opacity: 0.8
					}, 200);
					},function(){
					jQuery(this).animate({
						opacity: 1	      			
					}, 200);
				});
				
				
				jQuery(".hover-port").hover(function () {
					jQuery(this).children(".portfolio-hover").next().animate({
						opacity: 0.9
					}, 200);
					jQuery(this).children(".portfolio-hover").animate({
						opacity: 0.95
					}, 200);
					jQuery(this).children(".portfolio-hover").slideDown(200);
				},function () {
					jQuery(this).children(".portfolio-hover").next().animate({
						opacity: 1
					}, 150);
					jQuery(this).children(".portfolio-hover").slideUp(150);
				});
				
				
				
			if( BrowserDetect.browser != 'Explorer'){
			
				
				jQuery(".portfolio-link h4 a").hover(function () {
					jQuery(this).parent('h4').animate({
						  marginLeft: "0.1in",opacity: 0.5
					}, 150);
					},function(){
					jQuery(this).parent('h4').animate({
						marginLeft: "0in",opacity: 1	      			
					}, 150);
				}); 					
				jQuery(".blog-title h4 a").hover(function () {
					jQuery(this).parent('h4').animate({
						  marginLeft: "0.1in",opacity: 0.5
					}, 150);
					},function(){
					jQuery(this).parent('h4').animate({
						marginLeft: "0in",opacity: 1	      			
					}, 150);
				}); 
					
				}
				
			});
			