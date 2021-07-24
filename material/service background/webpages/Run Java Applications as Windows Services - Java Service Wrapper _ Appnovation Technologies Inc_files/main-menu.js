(function ($) {

  Drupal.behaviors.main_menu = {
    attach: function (context, settings) {
      initRolloverLinks();
    }
  };

  function initRolloverLinks() {
  	$('.navbar .dropdown-menu .rollover-menu').each(function() {
  		var wrapper = $(this);
  		var menu = $(this).find('ul.links');

  		menu.find('li')
  		.hover(function() {
  			var index = menu.find('li').index($(this));
  			index += 1; // the first index is the "default" view
  			displayRollover(wrapper, index);
  		}, function() {
  			displayRollover(wrapper, 0);
  		});
  	})
  }

  function displayRollover(elem, index) {
  	elem.find('.rollovers div.rollover.active').removeClass('active');
  	var div = elem.find('.rollovers div.rollover:eq('+index+')');

  	//console.log(div.length);

  	if (div.length > 0 && div.hasClass('exclude') == false)
  		div.addClass('active');
  	else
  		elem.find('.rollovers div.rollover:eq(0)').addClass('active');
  }

})(jQuery);
