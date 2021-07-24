jQuery(document).ready(function($) {
  // social share counts
  var social_count_el = $('.social-share-count');
  var url_query;
  var api_url;

  if (social_count_el.length > 0) {
    social_count_el.each(function() {
      var this_el = $(this);
      var node_url = this_el.find('input[name=node_url]').val();
      var callback = function(count) {
        this_el.find('a').text(abbrNum(count, 1) || 0);
      }

      if (this_el.hasClass('facebook-count') && ! this_el.hasClass('no-count')) {
        getSocialShareCount(node_url, 'facebook', callback);
      }
      else if (this_el.hasClass('twitter-count') && ! this_el.hasClass('no-count')) {
        getSocialShareCount(node_url, 'twitter', callback);
      }
      else if (this_el.hasClass('linkedin-count') && ! this_el.hasClass('no-count')) {
        getSocialShareCount(node_url, 'linkedin', callback);
      }
      else if (this_el.hasClass('gplus-count') && ! this_el.hasClass('no-count')) {
        getSocialShareCount(node_url, 'gplus', callback);
      }
    });
  }

  function getSocialShareCount(url, service, callback) {
    var url_query;
    var api_url;
    var count = 0;
    if (url == undefined) {
      return count;
    }
    switch (service) {
      case 'facebook':
        url_query = 'SELECT url, normalized_url, share_count, like_count, comment_count, total_count,commentsbox_count, comments_fbid, click_count FROM link_stat WHERE  url="' + url + '"';
        api_url = 'http://graph.facebook.com/fql?q=' + url_query;
        break;
      case 'twitter':
        api_url = 'http://urls.api.twitter.com/1/urls/count.json?url=' + url + '&callback=?';
        break;
      case 'linkedin':
        api_url = 'http://www.linkedin.com/countserv/count/share?url=' + url + '&callback=?';
        break;
      case 'gplus':
        api_url = '/gplus/count?url=' + url + '&callback=?';
        break;
    }

    if (api_url) {
      $.getJSON(api_url, function(data) {
        count = data.count != undefined ? data.count : data.data[0].total_count;
        if (typeof callback == 'function') {
          callback(count)
        }
      });
    }

    return count;
  }

  // On hover show/hide social button
  $('.social-links-boxes li.count').hover(function(context) {
    $(this).addClass('visible');
  });

  $('.social-links-boxes li.count').mouseleave(function(context) {
    $(this).removeClass('visible');
  });

  /*
   *  Round the count numbers "http://stackoverflow.com/questions/2685911/is-there-a-way-round-numbers-into-a-friendly-format-e-g-1-1k"
   */
  function abbrNum(number, decPlaces) {
    // 2 decimal places => 100, 3 => 1000, etc
    decPlaces = Math.pow(10, decPlaces);

    // Enumerate number abbreviations
    var abbrev = ["k", "m", "b", "t"];

    // Go through the array backwards, so we do the largest first
    for (var i = abbrev.length - 1; i >= 0; i--) {

      // Convert array index to "1000", "1000000", etc
      var size = Math.pow(10, (i + 1) * 3);

      // If the number is bigger or equal do the abbreviation
      if (size <= number) {
        // Here, we multiply by decPlaces, round, and then divide by decPlaces.
        // This gives us nice rounding to a particular decimal place.
        number = Math.round(number * decPlaces / size) / decPlaces;

        // Handle special case where we round up to the next abbreviation
        if ((number == 1000) && (i < abbrev.length - 1)) {
          number = 1;
          i++;
        }

        // Add the letter for the abbreviation
        number += abbrev[i];

        // We are done... stop
        break;
      }
    }

    return number;
  }

});
