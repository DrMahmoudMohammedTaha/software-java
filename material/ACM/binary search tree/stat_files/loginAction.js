// JavaScript Document
$(document).ready(function(e) {
	
	$(".btnLoginNew").live("click", function(){
		var username = $.trim($("input[name='username']").val());
		var password = $.trim($("input[name='password']").val());
		if(username.length ==0 || password.length ==0){
			$(".loginAreaBox .loginCheck").fadeIn();
		}else{
			 $("form[name='frmLogin']").submit();
		}
		return false;
	});
	
	$("form[name='frmLogin'] input").live("focus", function(){
		$(".loginAreaBox .loginCheck").fadeOut();
	});
	
	$("input[name='username'], input[name='password']").live("keypress", function(){
		var keycode;
		if (window.event) keycode = window.event.keyCode;
		else if (e) keycode = e.which;
		if (keycode == 13) {
			var username = $.trim($("input[name='username']").val());
			var password = $.trim($("input[name='password']").val());
			if(username.length ==0 || password.length ==0){
				$(".loginAreaBox .loginCheck").fadeIn();
				return false;
			}else{
				 $("form[name='frmLogin']").submit();
			}
		}
	});
	
});