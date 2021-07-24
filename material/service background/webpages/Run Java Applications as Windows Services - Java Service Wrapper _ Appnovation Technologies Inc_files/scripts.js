


jQuery(document).ready(function($) {

  //MOBILE NAV customized
  var mobileButton = $('#mobile-menu'),
      headerBG = $('#header-inner .main-menu'),
      headerElem = $('#header-inner .main-menu ul li'),
      navItems = $('#header-inner .main-menu li a'),
      listOne = $('.nav-pills li').clone().removeClass().addClass('dynamic-item-menu expanded dropdown'),
      delay = 0;
      //Fix the double tap bug on Safari
      //http://stackoverflow.com/questions/3038898/ipad-iphone-hover-problem-causes-the-user-to-double-click-a-link
      navItems.on('click touchend', function(e) {
          var el = $(this);
          var link = el.attr('href');
          window.location = link;
      });


  $( window ).resize(function() {
    if ( $( window ).width() > 1179){
      headerBG.removeAttr('style');
      headerBG.fadeIn( "fast");
    }
  });

  mobileButton.toggle(
    function(){
      headerBG.fadeIn('fast');
      //append nav-pill items to regular nav
      $('#header-inner .main-menu ul').append(listOne);
    },
    function() {
      headerBG.fadeOut('fast');
      $('#header-inner .main-menu ul li:last-child').prev('li').andSelf().remove();
  });


  //SUPERSLIDES customized
  numberOfSlides = $('#slideshow .slides-container > li').length;

  if(numberOfSlides > 1){
    playThis = 8000;
  }else{
    playThis = 0;
  }

  // For homepage slider
  if ($('body.front').length) {
   $('#slideshow').superslides({
      hashchange: false,
      play: playThis,
      animation: 'fade',
      pagination: true,
      inherit_height_from : '#content-top'
    });
  }

  // For contact slider
  if ($('body.contact-us').length) {
   $('#slideshow').superslides({
      hashchange: false,
      play: playThis,
      animation: 'fade',
      pagination: true,
      inherit_height_from : '#banner'
    });
  }


  initInlineLabels();
  initWebformBlocks();
  initScrollspy();
  display_next_webinar();

  // Parallax effect for footer.
  jQuery(window).bind('scroll', function(e) {
    var y = jQuery(window).scrollTop();
    var hb = jQuery('body').height();
    var hw = jQuery(window).height();
    var pcnt = (hb - y - hw) / 600;

    if (pcnt < 0 || pcnt > 1.5 ) {
      return;
    };

    // paralax paramers: initial offset and
    var layer2offset = -100;
    var layer2speed  = 50;
    var layer3offset = -160;
    var layer3speed  = 100;

    var layer2Top = ((1 - pcnt) * layer2speed + layer2offset);
    var layer3Top = ((1 - pcnt) * layer3speed + layer3offset);

    if (layer3Top < -150.0) {
      layer3Top = 100;
    }

    if (layer2Top < -100.0) {
      layer2Top = 0;
    }

    jQuery('.parallax-bg-2').css('top', layer2Top + 'px');
    jQuery('.parallax-bg-3').css('top', layer3Top + 'px');

  });

  // Homepage audience slider
  $(".audience-slideshow .audience-item").hover(function() {
    var itemClass = this.className;
    itemClass = itemClass.replace('audience-item ','');
    $(".image-item").not("." + itemClass).addClass('inactive');

    if ($('.image-item.' + itemClass).hasClass('inactive')) {
      $(".image-item." + itemClass).removeClass('inactive');
      $(".image-item").removeClass('item-1');
    };

  });
  // End Homepage

    $(".op_close_btn .btn_inner").click(function() {
        var id = $(this).attr('id');
        if ($('#' + id + '_snippet').hasClass('hidden')) {
            $('#' + id + '_snippet').removeClass('hidden');
            $(this).html('CLOSE');
        }
        else
            {
                $('#' + id + '_snippet').addClass('hidden');
                $(this).html('VIEW SNIPPET');
            };
    });

    $(".piece_title").click(function() {
        var id = $(this).attr('id');
        var this_text = $(this).html();
        if ($('#' + id + '_content').hasClass('hidden')) {
            $('#' + id + '_content').removeClass('hidden');
            $(this).removeClass('closed');
            $(this).addClass('opened');
            $(this).html(this_text.replace('closed', 'opened'));
        }
        else
            {
                $('#' + id + '_content').addClass('hidden');
                $(this).removeClass('opened');
                $(this).addClass('closed');
                $(this).html(this_text.replace('opened', 'closed'));
            };
    });

    // Webinar
    $("span.more-information").click(function() {
      if ($(this).hasClass('open')) {
        $(this).removeClass('open');
        $(".full-description").removeClass('visible');
      }
      else {
        $(this).addClass('open');
        $(".full-description").addClass('visible');
      }
    });

    // Webinar Viewer
    $(".more-webinars-title").click(function() {
      if ($(".view-display-id-block_11").hasClass('visible')) {
        $(".view-display-id-block_11").removeClass('visible');
        $(".more-webinars-title").removeClass('webinars-close');
        $("body.webinar-on-demand-viewer #main").removeClass('webinars-close');
      }
      else {
        $(".view-display-id-block_11").addClass('visible');
        $(".more-webinars-title").addClass('webinars-close');
        $("body.webinar-on-demand-viewer #main").addClass('webinars-close');
      }
    });

    // End Webinar

    $('.featurred_work_image').hover(function(){
        var id = $(this).attr('id');
        $('#' + id + '_a').removeClass('hidden');
    });

		$(".view_case_study").hover(
			function () {
		    var id = $(this).attr('id');
		    var t = $('#' + id + 'h').html();
		    if(t) {
		      $('#' + id + 'h').html(t.replace('normal', 'hover'));
		    }
			},
			function () {
		    var id = $(this).attr('id');
		    var t = $('#' + id + 'h').html();
		    if(t) {
		      $('#' + id + 'h').html(t.replace('hover', 'normal'));
		    }
			}
		);

    // Contact us address accordion
    if ($('#address-accordion').length) {
      $('#address-accordion .addr').hide();
      $('#address-accordion h3.state-inactive').click(function() {
        if ($(this).hasClass('state-active')) {
          return;
        }
        // hide all
        $('#address-accordion h3:gt(0)').removeClass('state-active').addClass('state-inactive');
        $('#address-accordion .addr').slideUp();
        // show clicked
        var e = $(this).next();
        $(this).removeClass('state-inactive').addClass('state-active');
        $(e).slideDown();
      });
    }

    // Old portoflio
    $('#main').hover(function(){
        $('.featured_overlay').addClass('hidden');
    });

    $('.featured_overlay').mouseleave(function(){
        $(this).addClass('hidden');
    });

    $('.ps_image').hover(function(){
        $('.featured_overlay').addClass('hidden');
        var id = $(this).attr('id');
        $('#' + id + '_a').removeClass('hidden');
    });

    $('.ps_theoverlay').mouseleave(function(){
        $(this).addClass('hidden');
        var casestudy = $(this).find(".view_case_study");
		    var id = casestudy.attr('id');
		    var t = $('#' + id + 'h').html();
		    if(t) {
		      $('#' + id + 'h').html(t.replace('hover', 'normal'));
		    }
    });

     $('.ps_image_d').hover(function(){
        var id = $(this).attr('id');
        $('#' + id + '_b').removeClass('hidden');
    });

    $('.ps_the_overlay').mouseleave(function(){
        $(this).addClass('hidden');
    });


    $(".fancybox").fancybox({
      openEffect: 'none',
      closeEffect: 'none',
      autoHeight: true,
      autoWidth:  true,
      scrolling:  'no',
      scrollOutside: false,
      helpers: {
        overlay: {
          locked: true,
        }
      }
    });

    //Fancybox for contact form
    $(".iframe-fancybox").click(function() {
        $( ".pardot-form-iframe" ).css({ 'height': '680'}).attr( "scrolling", "no" );;
        $(".iframe-fancybox").fancybox({
        content   : '<iframe id="myFrame" class="fancybox-iframe" frameborder="0" vspace="0" hspace="0" src="about:blank"></iframe>',
        openEffect  : 'none',
        closeEffect  : 'none',
        scrolling: 'no',
        autoSize  : false,
        width     : '800',
        height    : '710',
        afterShow : function() {
          var oIframe = document.getElementById('myFrame');
          var iframeDoc = (oIframe.contentWindow.document || oIframe.contentDocument );
          iframeDoc.open();
          iframeDoc.write(myContent);
          iframeDoc.close();
        }
        });
          var myContent = $('#getaquote').html();
    });

  // Setup & Initialize footer tabs
  if ($('section#footer-tabbed').length > 0)
    initFooterTabs();

  if ($('.carousel').length > 0)
    initCarousels();

  if ($('body.front').length > 0) {
    $('.logo-bg')
    .css({
      opacity: 0
    })
    .delay(500)
    .animate({
      opacity: 1
    }, 1000);
  }

  $('#logo')
    .hover(function() {
      $('.logo-bg').stop().animate({
        opacity: 0.7
      }, 200);
    }, function() {
      $('.logo-bg').stop().animate({
        opacity: 1
      }, 100)
    })


  $('header form.search input.not-active')
    .focus(function() {
      $(this)
      .removeClass('not-active')
      .stop()
      .animate({
        width: "73px"
      }, 500, 'easeOutQuint');
      $(this).parent()
      .removeClass('not-active')
      .stop()
      .animate({
        width: "100px"
      }, 500, 'easeOutQuint');
      if ($('.lang-select').length > 0) {
        $('.lang-select').hide();
      }
    })
    .blur(function() {
      if ($(this).val() == '')
      {
        $(this).addClass('not-active')
        .stop()
        .animate({
          width: "0px"
        }, 300);
        $(this).parent().addClass('not-active')
        .stop()
        .animate({
          width: "32px"
        }, 300);
        if ($('.lang-select').length > 0) {
          $('.lang-select').show();
        }
      }
    });

  $('header .social-links img').hover(function() {
    var src = $(this).attr('src');
    $(this).attr('src', src.replace('/social-large-bw/', '/social-large/'));
  }, function() {
    var src = $(this).attr('src');
    $(this).attr('src', src.replace('/social-large/', '/social-large-bw/'));
  })

  // Make active menu items in company page
  $('#block-menu_block-1 ul.menu a.active').parent().addClass('active')
  $('#block-menu_block-1 ul.menu a.active-trail').parent().addClass('active')

  /**
   * Attached carousel behavior to all carousels on the page
   */
  function initCarousels()
  {
    var maincarousel = $('.carousel').carousel({
      interval: 8000
    });
    $('a.carousel-nav').bind('click', function(e) {
      var carousel = $('.carousel');

      // @TODO: PROBLEM!!!!!
      maincarousel.carousel($(this).index()).carousel('pause');

      // Set the active class
      $('a.carousel-nav.active').removeClass('active');
      $(this).addClass('active');

      // Prevent the default behavior..
      e.preventDefault();
    });

    $('.carousel').on('slide', function(e) {
      $('.carousel .item.active').hide();
    });


    $('.carousel .item:not(.active)').css({
      display: 'none'
    });

    $('.carousel').on('slid', function(e, v) {

     	var activeIndex = $(this).find('.item.active').index();
      $(this).find('a.carousel-nav.active').removeClass('active');
      $(this).find('a.carousel-nav:eq('+activeIndex+')').addClass('active');

      $('.carousel .item.active').fadeIn();

      if($('.carousel .item.active #technologies').length > 0){
        $('#banner').removeClass();
        $('#banner').addClass('banner-tech');
      $('.carousel-navbar').find('a.carousel-nav.active').removeClass('active');
      $('.carousel-navbar').find('a.carousel-nav:eq(0)').addClass('active');
      }
      if($('.carousel .item.active #solutions').length > 0){
        $('#banner').removeClass();
        $('#banner').addClass('banner-sol');
      $('.carousel-navbar').find('a.carousel-nav.active').removeClass('active');
      $('.carousel-navbar').find('a.carousel-nav:eq(1)').addClass('active');
      }
      if($('.carousel .item.active #partners').length > 0){
        $('#banner').removeClass();
        $('#banner').addClass('banner-part');
      $('.carousel-navbar').find('a.carousel-nav.active').removeClass('active');
      $('.carousel-navbar').find('a.carousel-nav:eq(2)').addClass('active');
      }
      if($('.carousel .item.active #clients').length > 0){
        $('#banner').removeClass();
        $('#banner').addClass('banner-clients');
      $('.carousel-navbar').find('a.carousel-nav.active').removeClass('active');
      $('.carousel-navbar').find('a.carousel-nav:eq(3)').addClass('active');
      }
    });
  }

  function initInlineLabels() {
      $('#sidebar-second form .form-text, #sidebar-second form textarea').each(function() {
        var label = $(this).parents('.form-item').find('label');
        label.hide();
        $(this).attr('placeholder', label.text());
      });
  }

  function initWebformBlocks() {
    $('#sidebar-second form.webform-client-form .form-submit').hide();
    $('#sidebar-second form.webform-client-form .form-text:not(.required)').parents('.form-item').hide().addClass('hidden-field');
    $('#sidebar-second form.webform-client-form').click('bind', function() {
      $(this).find('.form-submit, .hidden-field').fadeIn();
      $(this).unbind('click');
    });
  }

  function initScrollspy() {
    $('body').scrollspy();
  }

  function display_next_webinar() {
      if (($("#block-views-webinars-block_6").length > 0) && ($("#next_webinar_placeholder").length > 0)){
          $("#next_webinar_placeholder").html($("#block-views-webinars-block_6").html());
          $("#block-views-webinars-block_6").html('');
      };
  }

  // Tabs
  $(function() {
    $( "#tabs" ).tabs();
  });

});

function getURLParameter(name) {
  return decodeURI(
    (RegExp(name + '=' + '(.+?)(&|$)').exec(location.search)||[,null])[1]
  );
}

