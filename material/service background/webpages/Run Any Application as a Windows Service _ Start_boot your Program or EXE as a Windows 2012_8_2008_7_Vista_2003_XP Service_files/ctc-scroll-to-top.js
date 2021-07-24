
/* For scrolling to the top of the page. */
$(document).ready(function() {
	$('a[href=#top]').click(function(){
		$('html, body').animate({scrollTop:0}, 800);
		if (window.location.hash) {
			// Remove the hash.
			var $new_url = window.location.href.substr(0, window.location.href.indexOf('#'));
			var $cmd = 'window.location.href = "' + $new_url + '"';
			setTimeout($cmd, 800);
		}
		return false;
	});
});
