
/* Zooming, by fancybox. */
$(document).ready(function() {
	$("a.zoomPopup").fancybox({
		'transitionIn':'elastic', 'transitionOut':'elastic', 'speedIn':400, 'speedOut':200, 'overlayOpacity':0.65,
		'overlayColor':'#000', 'overlayShow':true, 'autoScale':true, 'autoDimensions':false
	});
});

