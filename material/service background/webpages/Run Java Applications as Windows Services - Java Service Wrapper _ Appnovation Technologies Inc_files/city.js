Drupal.behaviors.city = {
  attach: function (context, settings) {
    jQuery('.city-header-menu').once(function(){
      var numItems = jQuery('.city-header-menu ul li').length;
      var elementClass = '';
      if (numItems > 0) {
        elementClass = 'items-' + numItems;
        jQuery('.city-header-menu ul').addClass(elementClass);
      }
    });
  }
};
