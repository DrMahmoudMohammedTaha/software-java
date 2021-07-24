  var secondColumnImages;
var dynamicBanners;
var thirdLevelMenu;
(function($) {
  Drupal.behaviors.corp_mmenu = {
    initializeMenu: function() {
      var menu_items = $('.nav').children();
			var isInRegion = false;
      var main_menu_active_item = null;
			menu_items.each(function() {
				$(this).mouseleave(function() {
	        isInRegion = false;
					$(this).removeClass('clicked');
	        setTimeout(function() {
	          if (!isInRegion) {
	            Drupal.behaviors.corp_mmenu.hideActiveSubMenu();
	          }
	        }, 100);
	      });
				if ('ontouchstart' in document) {
					$(this).click(function() {
					  if ($(this).hasClass('clicked')) {
							window.location = $(this).attr('href');
						} else {
							event.preventDefault();
							$(this).addClass('clicked');
						}
						Drupal.behaviors.corp_mmenu.showSubMenu(jQuery(this).attr('data-mlid'));
						isInRegion = true;
					});
				} else {
					$(this).mouseenter(function() {
						Drupal.behaviors.corp_mmenu.showSubMenu(jQuery(this).attr('data-mlid'));
						isInRegion = true;
					});
				}
			});
      $('#corp_mmenu_submenu').mouseenter(function() {
        isInRegion = true;
        //Drupal.behaviors.corp_mmenu.showSubMenu(jQuery(this).attr('data-mlid'));
      });
      $('#corp_mmenu_submenu').mouseleave(function() {
        isInRegion = false;
        setTimeout(function() {
          if (!isInRegion) {
            Drupal.behaviors.corp_mmenu.hideActiveSubMenu();
          }
        }, 100);
      })
    },

    hideActiveSubMenu: function() {
      // remove active class
      jQuery('.nav li[data-mlid=' + Drupal.behaviors.corp_mmenu.main_menu_active_item + ']').removeClass('active')
      // hide
      jQuery('#corp_mmenu_submenu').hide();
    },

    showSubMenu: function(mlid) {
      // remove old active class
      if (Drupal.behaviors.corp_mmenu.main_menu_active_item) {
        jQuery('.nav li[data-mlid=' + Drupal.behaviors.corp_mmenu.main_menu_active_item + ']').removeClass('active')
      }

      // Save active mlid
      Drupal.behaviors.corp_mmenu.main_menu_active_item = mlid;

      var json = Drupal.settings.corp_mmenu.menu_content;
      var currentItem = json[mlid];
			if (currentItem && currentItem.hasContent) {
        var submenu = {};
        submenu.firstColumn = currentItem.first_column;
        submenu.secondColumn = Drupal.behaviors.corp_mmenu.getSecondColumn(currentItem.second_column);
        submenu.thirdColumn = {};
        submenu.thirdColumn = Drupal.behaviors.corp_mmenu.getThirdColumn(currentItem.third_column);
        if (currentItem.hasFourthColumn) {
          submenu.fourthColumn = currentItem.fourth_column;
          submenu.hasFourthColumn = true;
        }
        if (submenu.thirdColumn.type != 'simpleBanner') {
          submenu.useSimpleSecondCol = true;
        } else {
          submenu.useSimpleSecondCol = false;
        }
        if (submenu.thirdColumn.type == 'dynamicBanner' || submenu.thirdColumn.type == 'view') {
          submenu.useSecondColThin = true;
        } else {
          submenu.useSecondColThin = false;
        }
        var source = jQuery("#submenu-template").html();
        var template = Handlebars.compile(source);
        var html    = template(submenu);
        $('#corp_mmenu_submenu').html(html);

        Drupal.behaviors.corp_mmenu.setUpSubMenu(submenu);

        // show
        $('#corp_mmenu_submenu').show();
			}
      else {
        this.hideActiveSubMenu();
      }
      //highlight text menu on HOVER
       ( !($('#mobile-menu').is(":visible")) ) ? jQuery('.nav li[data-mlid=' + mlid + ']').addClass('active') : null;
    },

    getSecondColumn: function(secondColumn) {
      switch (secondColumn.type) {
        case "simpleList":
          var childrens = new Array();
          var count = 0;
          $(secondColumn.content).each(function() {
            childrens[count] = this;
            count ++;
          });
					var secondCol = {};
					secondCol.content = childrens;
					secondCol.type = 'simpleList';
          secondCol.simpleList = true;
          secondCol.complexList = false;
          return secondCol;
          break;
        case "complexList":
        //todo: Si funciona hacer una sola funcion que haga todo.
          var childrens = new Array();
          var count = 0;
          secondColumnImages = new Array();
          $(secondColumn.content).each(function(){
            childrens[count] = this;
            secondColumnImages[this.mlid] = this.image;
            count += 1;
          });
					var secondCol = {};
          secondCol.content = childrens;
          secondCol.type = 'complexList';
          secondCol.simpleList = false;
          secondCol.complexList = true;
          return secondCol;
          break;
      }
    },

    getThirdColumn: function(thirdColumn) {
      thirdCol = {};
      thirdCol.type = thirdColumn.type;
      switch (thirdColumn.type) {
        case "fullBanner":
          thirdCol.content = thirdColumn.content;
					thirdCol.fullBanner = true;
          break;
        case "simpleBanner":
          var images = new Array();
          var count = 0;
          $(thirdColumn.content).each(function() {
            images[count] = new Array();
            images[count]['image'] = this.image;
            images[count]['url'] = this.url;
            count ++;
          });
					/*for (child in thirdColumn.content) {
						images[count] = child.image;
						count ++;
					}*/
          thirdCol.content = {};
          thirdCol.content.images = images;
          thirdCol.content.title = thirdColumn.title;
          break;
        case "dynamicBanner":
          dynamicBanners = new Array();
          $(thirdColumn.content).each(function() {
            dynamicBanners[this.mlid] = this.content;
          });
          thirdCol.defaultContent = thirdColumn.defaultContent;
          break;
        case "menuItems":
          thirdLevelMenu = new Array();
          $(thirdColumn.content).each(function() {
            thirdLevelMenu[this.mlid] = this.content;
          });
          this.menuItems = true;
          break;
        case "view":
          var thirdCol = {};
          thirdCol.content = thirdColumn.content;
          thirdCol.view = true;
          break;
      }
      return thirdCol;
    },

    setUpSubMenu: function(submenu) {
      if (submenu.secondColumn.type == "complexList") {
        var children = $('.dynamic-list').children();
        var firstItem = secondColumnImages[jQuery(children[0]).attr('data-mlid')];
        $('#secondColumnImage').attr('src', firstItem);
        children.each(function() {
          var mlid = $(this).attr('data-mlid');
          var href = $($(this).children()[0]).attr('href');
          var image = secondColumnImages[mlid];
          $(this).mouseenter(function() {
						if (image != null) {
            	$('#secondColumnImage').attr('src', image);
              $('#secondColURL').attr('src', href);
						} else {
							$('#secondColumnImage').attr('src', '');
              $('#secondColURL').attr('src', '');
						}
          });
          $(this).mouseleave(function() {
            $('#seconColumnImage').attr('src', '');
            $('#secondColURL').attr('src', '');
          });
        })
      }
      if (submenu.thirdColumn.type == "menuItems") {
        var children = $('.dynamic-list').children();
        children.each(function() {
          var mlid = $(this).attr('data-mlid');
          var children = thirdLevelMenu[mlid];
          var menu = {};
          menu.content = children;
          $(this).mouseenter(function() {
            var source = jQuery("#thirdLevelMenu-template").html();
            var template = Handlebars.compile(source);
            var html    = template(menu);
            $('#thirdCol').html(html);
          });
        });
      } else if (submenu.thirdColumn.type == 'dynamicBanner') {
        var children = $('.dynamic-list').children();
        var firstItem = dynamicBanners[jQuery(children[0]).attr('data-mlid')];
        var source = jQuery("#dynamicBanner-template").html();
        var template = Handlebars.compile(source);
        var html    = template(firstItem);
        $('#thirdCol').html(html);
        children.each(function() {
          var mlid = $(this).attr('data-mlid');
          var banner = dynamicBanners[mlid];
          var defaultContent = submenu.thirdColumn.defaultContent
          if (defaultContent) {
            var source = jQuery("#dynamicBanner-template").html();
            var template = Handlebars.compile(source);
            var html    = template(defaultContent);
            $('#thirdCol').html(html);
          }
          if (banner) {
            $(this).mouseenter(function() {
              var source = jQuery("#dynamicBanner-template").html();
              var template = Handlebars.compile(source);
              var html    = template(banner);
              $('#thirdCol').html(html);
            });
          }
        })
      }
    },

    attach: function(context, settings) {
      this.initializeMenu();
    },
  }
})(jQuery);
