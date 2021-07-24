(function($) {
  Drupal.behaviors.corp_i18n = {
    attach: function(context, settings) {
      var base_url = window.location.protocol + '//' + window.location.host;
      var html = '';
      var url_info;
      var i;
      // show current url
      for(i = 0; i < Drupal.settings.corp_i18n.lang_urls.length; i++) {
        url_info = Drupal.settings.corp_i18n.lang_urls[i];
        if (base_url == url_info.url) {
          Drupal.settings.corp_i18n.lang_urls[i].selected = true;
          html += '<div class="selected" id="selected-lang"><span>' + url_info.desc + '</span></div>';
        }
        else {
          Drupal.settings.corp_i18n.lang_urls[i].selected = false;
        }
      }

      // show other options
      html += '<div class="lang-dropdown">';
      html += '<ul id="lang-list">';
      for(i = 0; i < Drupal.settings.corp_i18n.lang_urls.length; i++) {
        url_info = Drupal.settings.corp_i18n.lang_urls[i];
        if (url_info.selected == false) {
          html += '<li><a href="' + url_info.url + window.location.pathname + '" class="lang-option">' + url_info.desc + '</a></li>';
        }
      }
      html += '</ul></div>';
      $('div.lang-select').html(html);

      // hide dropdown
      $('.lang-dropdown').toggle();

      // bind hover
      $('#selected-lang').click(function() {
        $('.lang-dropdown').toggle();
        $('.lang-select').toggleClass('expanded');
      });

      // click on body hides selector
      $('#main').click(function() {
        if ($('.lang-select.expanded').length > 0) {
          $('.lang-dropdown').toggle();
          $('.lang-select').toggleClass('expanded');
        }
      });
    }
  }
})(jQuery);

