/** IMPORTANT: This file should only be loaded once in a given context. */

/** @constructor This class is based on the popular deferred/promise pattern. */
window.GrvMiniDeferred = function() {
  /** @private */
  var Promise = function() {
    this.thenCallbacks = [];
    this.errorCallbacks = [];
    this.resolved = 0;
    this.resolvedWith = null;

    this.RESOLVED_SUCCESS = 1;
    this.RESOLVED_ERROR = 2;

    this.then = function(callback) {
      if(this.resolved) {
        if(this.resolved == this.RESOLVED_SUCCESS)
          callback(this.resolvedWith);
      }
      else
        this.thenCallbacks.push(callback);

      return this;
    };

    this.error = function(callback) {
      if(this.resolved) {
        if(this.resolved == this.RESOLVED_ERROR)
          callback(this.resolvedWith);
      }
      else
        this.errorCallbacks.push(callback);

      return this;
    };

    this.always = function(callback) {
      if(this.resolved)
        callback(this.resolvedWith);
      else {
        this.thenCallbacks.push(callback);
        this.errorCallbacks.push(callback);
      }
    }
  };

  this.promise = new Promise;

  this.resolve = function(successValue) {
    this.promise.resolved = this.promise.RESOLVED_SUCCESS;
    this.promise.resolvedWith = successValue;
    for(var i=0; i<this.promise.thenCallbacks.length; ++i)
      this.promise.thenCallbacks[i](successValue);
  };

  this.reject = function(errorValue) {
    this.promise.resolved = this.promise.RESOLVED_ERROR;
    this.promise.resolvedWith = errorValue;
    for(var i=0; i<this.promise.errorCallbacks.length; ++i)
      this.promise.errorCallbacks[i](errorValue);
  };
};

/**
 * @constructor
 *
 * @param {String}  siteGuid
 * @param {Number}  placementId
 * @param {String}  userGuid
 * @param {Boolean} truncateArticleTitles
 * @param {Boolean} truncateArticleContent
 * @param {Boolean} isSidebar
 * @param {String}  frameUrl
 * @param {Number}  widgetLoaderVersion
 * @param {Boolean} useDynamicHeight
 * @param {String}  staticHeight
 * @param {Boolean} useThumby
 * @param {Boolean} enableImageTooltip
 * @param {String}  brokenImgUrl
 * @param {Boolean} doVerticalSpace
 * @param {Boolean} doHorizontalSpace
 * @param {Boolean} isIframe
 * @param {Boolean} doAolOmniture
 * @param {Boolean} clickThroughOnRightClick
 * @param {Boolean} showMouseoverSlide
 * @param {String}  rateRecoBaseUrl
 * @param {Boolean} useInnerScroll
 * @param {String}  impressionHash
 * @param {String}  beaconUrl
 * @param {String}  aolOmniModuleName
 * @param {String}  aolOmniBrand
 * @param {String}  aolCmsSrc
 * @param {String}  aolCobrand
 * @param {String}  aolOmniAccount
 * @param {String}  [containerId=] Only required for JSONP widgets.
 * @param {Number}  sitePlacementId
 * @param {String}  [googleAnalyticsWebPropertyId=]
 * @param {Boolean} [googleAnalyticsOrganicClicks=false]
 * @param {Boolean} [doImageMagicBgBlur=true]
 * @param {Boolean} [skipRedirectServlet=false]
 */
window.GrvWidgetVars = function(siteGuid, placementId, userGuid, truncateArticleTitles, truncateArticleContent, isSidebar,
    frameUrl, widgetLoaderVersion, useDynamicHeight, staticHeight, useThumby, enableImageTooltip, brokenImgUrl, doVerticalSpace,
    doHorizontalSpace, isIframe, doAolOmniture, clickThroughOnRightClick, showMouseoverSlide, rateRecoBaseUrl, useInnerScroll,
    impressionHash, beaconUrl, aolOmniModuleName, aolOmniBrand, aolCmsSrc, aolCobrand, aolOmniAccount, containerId,
    sitePlacementId, googleAnalyticsWebPropertyId, googleAnalyticsOrganicClicks, doImageMagicBgBlur, skipRedirectServlet) {
  this.siteGuid = siteGuid;
  this.placementId = placementId;
  this.userGuid = userGuid;
  this.truncateArticleTitles = truncateArticleTitles;
  this.truncateArticleContent = truncateArticleContent;
  this.isSidebar = isSidebar;
  this.frameUrl = frameUrl;
  this.widgetLoaderVersion = widgetLoaderVersion;
  this.useDynamicHeight = useDynamicHeight;
  this.staticHeight = staticHeight;
  this.useThumby = useThumby;
  this.enableImageTooltip = enableImageTooltip;
  this.brokenImgUrl = brokenImgUrl;
  this.doVerticalSpace = doVerticalSpace;
  this.doHorizontalSpace = doHorizontalSpace;
  this.isIframe = isIframe;
  this.doAolOmniture = doAolOmniture;
  this.clickThroughOnRightClick = clickThroughOnRightClick;
  this.showMouseoverSlide = showMouseoverSlide;
  this.rateRecoBaseUrl = rateRecoBaseUrl;
  this.useInnerScroll = useInnerScroll;
  this.impressionHash = impressionHash;
  this.beaconUrl = beaconUrl;
  this.aolOmniModuleName = aolOmniModuleName;
  this.aolOmniBrand = aolOmniBrand;
  this.aolCmsSrc = aolCmsSrc;
  this.aolCobrand = aolCobrand;
  this.aolOmniAccount = aolOmniAccount;
  this.containerId = containerId || null;
  this.container = containerId ? document.getElementById(containerId) : null;
  this.sitePlacementId = sitePlacementId;
  this.googleAnalyticsOrganicClicks = googleAnalyticsOrganicClicks;
  this.doImageMagicBgBlur = doImageMagicBgBlur == null || doImageMagicBgBlur;
  this.skipRedirectServlet = skipRedirectServlet || false;

  if(googleAnalyticsOrganicClicks)
    this.loadGoogleAnalytics(googleAnalyticsWebPropertyId);
};

/**
 * @param {jQuery} $
 *
 * @return {jQuery} Selected element of class .grv-personalization-**. JSONP widgets sometimes move this container
 *                  around in the DOM.
 */
GrvWidgetVars.prototype.innerContainer = function($) {
  return $('.' + this.containerId);
};

GrvWidgetVars.prototype.loadGoogleAnalytics = function(gaWebPropertyId) {
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
  ga('create', gaWebPropertyId, 'auto');
};

GrvWidgetVars.prototype.stylesLoadedPromise = function($) {
  if(!this._stylesLoadedDeferred) {
    this._stylesLoadedDeferred = new GrvMiniDeferred;

    var isNotSitePlacementSpecificCssOverrideReg = /\/base(\.[a-fA-F0-9]{32})?\.css(\?[^?]*)?$/,
        cleanCssHrefForSelectorReg = /[^A-Za-z0-9_]/g,
        cleanCssHrefReplace = '_',
        selectorPrefix = 'grvWidgetStylesLoaded_';

    /** @this jQuery The <link /> element. */
    function isSitePlacementSpecificCssOverride() {
      var $stylesheet = $(this);
      return !isNotSitePlacementSpecificCssOverrideReg.test($stylesheet.attr('href'));
    }

    // After dependent CSS loaded
    var $stylesheet = $('link.grvWidgetStylesheet.sg' + this.siteGuid + '-pl' + this.placementId)
                          .filter(isSitePlacementSpecificCssOverride);
    // Sanity check to only allow 1, no more
    if($stylesheet.length === 1) {
      try {
        var href = $stylesheet.attr('href'),
            elementIdToMatch = selectorPrefix + href.substr(1 + href.lastIndexOf('/')).replace(cleanCssHrefForSelectorReg, cleanCssHrefReplace),
            $dummyElem = $('<div />').attr('id', elementIdToMatch).appendTo('body'),
            self = this;

        function watchForCssOverrideLoaded() {
          // 0x0 must also be checked; in Safari when changing page zoom level, the 1x1 hardcoded width will be
          // adjusted when we retrieve it
          var intWidth = parseInt($dummyElem.width()),
              intHeight = parseInt($dummyElem.height());
          if(intWidth <= 1 && intHeight <= 1) {
            $dummyElem.remove();
            self._stylesLoadedDeferred.resolve();
          }
          else
            setTimeout(function() { watchForCssOverrideLoaded(); }, 25);
        }
        watchForCssOverrideLoaded();
      }
      catch(e) {
        this._stylesLoadedDeferred.reject(e);
      }
    }
    else
      this._stylesLoadedDeferred.reject("Couldn't determine CSS override.");
  }

  return this._stylesLoadedDeferred.promise;
};

/**
 * @param {jQuery} $
 * @param {window.GrvWidgetVars|Window.GrvWidgetVars|GrvWidgetVars} widgetVars
 */
window.grvInitWidget = function($, widgetVars) {
  // De-dupe execution of this just in case...
  this.inittedWidgets = this.inittedWidgets || {};
  if(this.inittedWidgets[widgetVars.siteGuid] && this.inittedWidgets[widgetVars.siteGuid][widgetVars.placementId])
    return;
  this.inittedWidgets[widgetVars.siteGuid] = this.inittedWidgets[widgetVars.siteGuid] || {};
  this.inittedWidgets[widgetVars.siteGuid][widgetVars.placementId] = true;

  var forwardHrefDataAttrName = widgetVars.skipRedirectServlet ? 'data-non-forward-href' : 'data-forward-href';

  /** Provides jQuery selection scoped to the widget container as needed. Helps manage multiple JSONP widgets. */
  function scoped$(selector) {
    var scope = scopeFor$();
    return scope == null ? $(selector) : scope.find(selector);
  }

  /** @return {jQuery|null} Null if the widget scope is indeterminate; if that happens, query against the whole DOM. */
  function scopeFor$() {
    // Iframe or sidebar
    if(widgetVars.isIframe || widgetVars.isSidebar)
      return null;
    // JSONP widget (only type of widget for which scoping of selectors matters since all elems are in same context)
    else {
      // Inner container might be moved by JSONP widgets so we need to select against it also
      var $innerContainer = widgetVars.innerContainer($);

      if(widgetVars.container || $innerContainer.length) {
        var scope = $innerContainer;
        if(widgetVars.container)
          scope = scope.add(widgetVars.container);
        return scope;
      }
      // No containers available for some strange reason; fall back so we don't astonishingly do nothing at least
      else
        return null;
    }
  }

  var $window = $(window),
      $articleContainer,
      $articleTitles,
      $articleContents,
      $grvImgLinks,
      postMessageSupported = !!parent.postMessage,
      usingDotdotdot = Boolean($.fn.dotdotdot),
      truncateArticleTitles = usingDotdotdot && widgetVars.truncateArticleTitles,
      truncateArticleContent = usingDotdotdot && widgetVars.truncateArticleContent,
      isSidebar = widgetVars.isSidebar,
      $widget,
      $grvScrollableHandle,
      dotdotdotInitted = false,
      $doc = $(document);

  function ensure$widget() {
    if($widget != null && $widget.length === 1)
      return true;

    $widget = scoped$('#grv_widget');
    if(!postMessageSupported)
      $widget.addClass('grv_widget_no_postmessage');

    return $widget.length === 1;
  }

  // Non-sidebar JSONP widget
  if(!widgetVars.isSidebar && !widgetVars.isIframe) {
    // Some success hooks registered
    if(window.grvWidgetSuccessCallbacks && window.grvWidgetSuccessCallbacks.length) {
      var containerId = widgetVars.containerId;
      for(var i=0, n=window.grvWidgetSuccessCallbacks.length; i < n; ++i)
        window.grvWidgetSuccessCallbacks[i](containerId);
    }

    var $container = $(widgetVars.container);

    // Ensure widget is visible; JSONP widget footers may have the container invisible to prevent FOUC
    widgetVars.stylesLoadedPromise($).always(function() {
      checkRespWidth();
      $container.add(widgetVars.innerContainer($)).css('opacity', 1);
    });
  }

  function postParentMessage(msg) {
    postRawParentMessage(widgetVars.siteGuid + '|' + widgetVars.placementId + '|' + widgetVars.userGuid + '|' + msg);
  }

  function postRawParentMessage(msg) {
    if(postMessageSupported && widgetVars.frameUrl && parent !== window)
      parent.postMessage(msg, widgetVars.frameUrl);
  }

  function $elForWidgetHeight() {
    var $el;

    // Sometimes $widget height is non-deterministic in Chrome for unknown reasons, so use <body /> (which is shown to
    // be deterministic in aforementioned cases) if possible
    if(widgetVars.isIframe) {
      $el = $('body');
      if($elForWidgetHeight.length == 0)
        $el = $widget;
    }
    else
      $el = $widget;

    return $el;
  }

  var grvWatchingForHeightUpdated = false;
  function grvUpdateHeight() {
    // Set up watch for "heightUpdated" response message only once, and only if we have what we need
    if(!grvWatchingForHeightUpdated && postMessageSupported && widgetVars.frameUrl && parent !== window && widgetVars.widgetLoaderVersion >= 2) {
      grvWatchingForHeightUpdated = true;

      $window.bind('message', function(event) {
        var data = event.originalEvent.data,
            origin = event.originalEvent.origin,
            $el = $elForWidgetHeight(),
            lastWidth = $el.data('lastWidth.grv'),
            lastHeight = $el.data('lastHeight.grv'),
            curWidth = $el.outerWidth(true),
            curHeight = $el.outerHeight(true);

        // Height updated
        if(data == 'heightUpdated' && widgetVars.frameUrl.indexOf(origin) == 0
        && (!lastWidth || lastWidth != curWidth || !lastHeight || lastHeight != curHeight)) {
          $el.data('lastWidth.grv', curWidth).data('lastHeight.grv', curHeight);
          grvWidgetDimUpdated();
        }
      });
    }

    if(widgetVars.useDynamicHeight) {
      var $el = $elForWidgetHeight(),
          lastHeight = $el.data('lastHeight.grv'),
          curHeight = $el.outerHeight(true);

      if(lastHeight != curHeight) {
        postParentMessage('setHeight:' + curHeight);
        $el.data('lastHeight.grv', curHeight);
      }
    }
    else
      postParentMessage('setHeight:' + widgetVars.staticHeight);
  }

  function initAttribution() {
    var attribHidden = true,
        $attribToggle = scoped$('#grv_personalization'),
        $attrib = scoped$('#grv_tooltip').css('opacity', 0).hide(),
        serverCodeVersionOk = widgetVars.widgetLoaderVersion >= 3;

    $attribToggle.click(function(e) {
      e.preventDefault();

      // Iframe widget
      if(parent !== window) {
        if(postMessageSupported && serverCodeVersionOk) {
          postParentMessage('showAttrib');
        }
        // No postMessage support
        else {
          fallbackAttributionTooltip();
        }
      }
      // JSONP widget
      else {
        // If show modal function available; might not be during deployment of this feature, but also if the client
        // cached widget loader unreasonably which is possible with widgets in the wild since eager widget loader cache
        // busting wasn't added until sidebar widget
        if(window.grvShowAttributionModal && serverCodeVersionOk)
          window.grvShowAttributionModal($);
        else
          fallbackAttributionTooltip();
      }
    });

    function fallbackAttributionTooltip() {
      if(attribHidden) {
        attribHidden = false;
        $attrib.stop().show().animate({ opacity: 1 }, 'fast');
      }
      // Shown
      else {
        attribHidden = true;
        $attrib.stop().animate({ opacity: 0 }, 50, function() {
          // Hide if still OK to hide (i.e. didn't quickly re-click)
          attribHidden && $attrib.hide();
        });
      }
    }
  }

  var grvNoFinalSlashUrl = /^[^#?]*/.exec(window.location.href)[0];

  function grvQueryString() {
    return (/\?([^#]*)/.exec(window.location.href)||[])[0] || '';
  }

  function docHasWidth() {
    return $doc.width() > 1 || (navigator && navigator.userAgent && navigator.userAgent.indexOf('MSIE') != -1);
  }

  var scaleImages;
  (function() {
    var sidebarCssLoaded = false,
        sidebarWaitingForCssLoaded = false;

    scaleImages = function() {
      // Hide images if the document doesn't have width
      if($doc.width() <= 1)
        $grvImgLinks.css('opacity', 0);

      // Is sidebar widget
      if(isSidebar) {
        // CSS loaded; OK to scale images
        if(sidebarCssLoaded)
          doScaleImages();
        // Need to wait for CSS (only if not already waiting)
        else if(!sidebarWaitingForCssLoaded) {
          sidebarWaitingForCssLoaded = true;
          doScaleImagesAfterSidebarCssLoaded();
        }
      }
      // JSONP widget
      else if(!widgetVars.isIframe) {
        widgetVars.stylesLoadedPromise($).always(function() {
          doScaleImages();
          $grvImgLinks.css('opacity', 1);
        });
      }
      // Not sidebar or JSONP; OK to scale images immediately as CSS is guaranteed to be loaded
      else
        doScaleImages();

      // Show images when the document has width
      if(docHasWidth())
        $grvImgLinks.css('opacity', 1);
    };

    function doScaleImages() {
      $grvImgLinks.each(scaleThisImgLinkOrDefer);
    }

    function doScaleImagesAfterSidebarCssLoaded() {
      var $testStylesElem = $('<div id="grvSidebarStylesLoaded" />').appendTo('body'),
          stylesReadyInterval = setInterval(function() {
            if(parseInt($testStylesElem.width()) === 1 && parseInt($testStylesElem.height()) === 1) {
              clearInterval(stylesReadyInterval);
              $testStylesElem.remove();
              doScaleImages();
            }
          }, 50);
    }

    function scaleThisImgLinkOrDefer() {
      var $imgLink = $(this),
          deferredImageScalePromise = $imgLink.data('deferredImageScalePromise.grv');

      // Somebody wants to defer image scaling until later
      if(deferredImageScalePromise && deferredImageScalePromise.then) {
        var _this = this;
        deferredImageScalePromise.then(function() { scaleThisImgLink.call(_this); });
      }
      else
        scaleThisImgLink.call(this);
    }

    /**
     * @constructor
     *
     * @param {Number} width
     * @param {Number} height
     */
    function ThumbyDimensions(width, height) {
      this.toString = function() { return width + 'x' + height; };
    }
    ThumbyDimensions.DEFAULT_DIMENSION_STR = 'original';

    /**
     * @param {ThumbyDimensions|null} thumbyDim     Null if not resizing image.
     * @param {String}                thumbyGravity Thumby "gravity" (North, East, Center, etc.).
     * @param {String}                imageUrl      Absolute image URL pre-Thumby.
     */
    function thumbyUrl(thumbyDim, thumbyGravity, imageUrl) {
      var widthHeightStr = thumbyDim == null ? ThumbyDimensions.DEFAULT_DIMENSION_STR : thumbyDim.toString();
      return (location.protocol == 'https:' ? 'https://grvaol-a.akamaihd.net' : 'http://a.rtb.grvcdn.com') + '/t/' + widthHeightStr + '/' + thumbyGravity + '/?url=' + encodeURIComponent(imageUrl);
    }

    var isCustomGravityCroppedImageRegExp = /^[^:]+:\/\/dlug-assets\.grvcdn\.com\//i;
    function scaleThisImgLink() {
      var $link = $(this),
          articleTitle = $link.attr('title'),
          width = Math.max(0, parseInt($link.width()) || 0),
          height = Math.max(0, parseInt($link.height()) || 0),
          imageUrl = $link.data('imageUrl') || '',
          $img = $link.find('.grv_article_img:first'),
          isCustomGravityCroppedImage = isCustomGravityCroppedImageRegExp.test(imageUrl);

      // If the link doesn't have dimensions, don't even do anything. Some widgets hide images on articles; we will
      // avoid unnecessarily loading images in that case with this check.
      // TODO: Further research on getting this to work with multiple JSONP widgets, which typically have 0 dimensions for a brief arbitrary amount of time on page load
//      if(!(width && height))
//        return;

      // Using Thumby and this image link is not already one of our custom cropped images
      if((widgetVars.useThumby || $link.data('campaignUsesThumby')) && !isCustomGravityCroppedImage) {
        // New <img /> required if no <img /> yet or image link dim changed
        var lastWidth = $link.data('lastImgLinkWidth.grv') || null,
            lastHeight = $link.data('lastImgLinkHeight.grv') || null,
            newImgRequired = !$img.length
                             || width !== lastWidth
                             || height !== lastHeight;

        // <img /> needed and dependent data available
        if(newImgRequired && width && height && imageUrl) {
          $img.length && $img.remove();

          // Store last width/height
          $link.data('lastImgLinkWidth.grv', width).data('lastImgLinkHeight.grv', height);

          // The new image thumb
          $img = $('<img class="grv_article_img grv_positionable" />')
              .one('error', function() {
                onImageError.call(this, width, height);
              })
              .one('load', function() {
                // Bad image; could be Thumby or partner error; note that image "load" event is not cross-browser friendly
                // so this fail safe won't even work all the time. Note also that dummy new Image() is used to determine
                // size because this <img />'s size is subject to partner-specific CSS, etc.
                var image = new Image();
                image.src = this.src;
                if(parseInt(image.width) === 1 || parseInt(image.height) === 1)
                  onImageError.call(this, width, height);
                else
                  onImageLoad.call(this, $link, $img);
                image = null;
              })
              .attr('src', thumbyUrl(new ThumbyDimensions(width, height), 'North', imageUrl))
              .appendTo($link);

          if(widgetVars.enableImageTooltip)
            $img.attr('title', articleTitle);
        }
      }
      // Not using Thumby
      else {
        // Create image if needed
        if(!$img.length) {
          if(location.protocol == 'https:') {
            imageUrl = thumbyUrl(null, 'Center', imageUrl);
          }

          $img = $('<img class="grv_article_img grv_positionable" />')
              .load(function() { onImageLoad.call(this, $link, $img); })
              .one('error', function() {
                onImageError.call($img[0], width, height);
              })
              .attr('src', imageUrl)
              .appendTo($link);

          if(widgetVars.enableImageTooltip)
            $img.attr('title', articleTitle);
        }
        // Image already existed and dims already known (if dims are not known at this point, it is because the image
        // is still loading; when it is loaded, the load handle above will call and the image alignment/overlay will
        // be adjusted at that time)
        else if($img.data('imageWidth') && $img.data('imageHeight'))
          alignImageAndOverlay($link, $img, $img.data('imageWidth'), $img.data('imageHeight'));
      }
    }

    /**
     * @param {jQuery} $link Image link containing the image.
     * @param {jQuery} $img  The <img />.
     *
     * @this {Image} The image object that is accessible as "this" in the load event.
     */
    function onImageLoad($link, $img) {
      // On image load store the dimensions
      var imageWidth = this.width,
          imageHeight = this.height;
      $img.data('imageWidth', imageWidth).data('imageHeight', imageHeight);
      alignImageAndOverlay($link, $img, imageWidth, imageHeight);
    }

    var onImageError = function(width, height) {
      // Width and height available
      if(width && height) {
        var $img = $(this),
            brokenImgThumb = (location.protocol == 'https:' ? 'https://grvaol-a.akamaihd.net' : 'http://a.rtb.grvcdn.com') + '/t/' + width + 'x' + height + '/Center/?url=' + encodeURIComponent(widgetVars.brokenImgUrl);

        // Attempt to load thumbnail of error image
        $img.one('error', onImageErrorFallback).addClass('grv_full_width grv_full_height').removeClass('grv_positionable').attr('src', brokenImgThumb);
      }
      // Dimensions not available
      else {
        // Skip to the non-Thumby version of fallback image; browser will resize. Arguably with no dimensions we could
        // skip even loading the fallback image but who knows what JS/CSS might be introduced to show the image late in
        // the widget lifecycle
        onImageErrorFallback.call(this);
      }
    };

    /**
     * This would be reached if the image failed to load and the dynamic thumb version of our fallback image also failed
     * to load. This would be very rare and if it happened, we would have much more serious problems to address.
     */
    var onImageErrorFallback = function() {
      var $img = $(this);

      // Set static broken image
      $img.addClass('grv_positionable').load(function() {
        alignImageAndOverlay($img.closest('.grv_img_link'), $img, this.width, this.height);
      }).attr('src', widgetVars.brokenImgUrl);
    };

    /**
     * Used when not using Thumby.
     *
     * @param {Object} $link       JQuery link containing the image.
     * @param {Object} $img        JQuery image.
     * @param {Number} imageWidth  Real image width.
     * @param {Number} imageHeight Real image height.
     */
    function alignImageAndOverlay($link, $img, imageWidth, imageHeight) {
      alignImage($link, $img, imageWidth, imageHeight);
      alignOverlay($link, $img);
    }

    /**
     * Used to align image using position relative when not using Thumby (in that case, the image thumb is larger than
     * the parent link.
     *
     * @param {Object} $link       JQuery link containing the image.
     * @param {Object} $img        JQuery image.
     * @param {Number} imageWidth  Real image width.
     * @param {Number} imageHeight Real image height.
     */
    var alignImage = function($link, $img, imageWidth, imageHeight) {
      var linkWidth = parseInt($link.width()),
          linkHeight = parseInt($link.height()),
          linkAspectRatio = linkWidth / linkHeight,
          imgAspectRatio = imageWidth / imageHeight;

      // Image is more landscapey than parent link
      if (linkAspectRatio < imgAspectRatio) {
        $img.addClass('grv_full_height').css('left', - (((imageWidth / imageHeight) * linkHeight) - linkWidth) / 2);
        $img.removeClass('grv_full_width');
      }
      // Image is more portraity
      else {
        $img.addClass('grv_full_width').css('left', 0);
        $img.removeClass('grv_full_height');
        imageMagicBgBlur($img);
      }
    };

    /**
     * Aligns the image overlay to the image in the case image height is less than container height. Only applicable
     * when not using Thumby (when using Thumby, the image will always be the correct size).
     *
     * @param {Object} $link JQuery link that contains the image.
     * @param {Object} $img  JQuery image.
     */
    var alignOverlay = function($link, $img) {
      if ($img.height() < $link.height()) {
        $img.siblings('.grv_post_type').css('bottom', ($link.height() - $img.height()) + 'px');
      }
    };
  })();

  // HD TV effect - Create BG image and blur it to show a portrait image in a landscape container
  function imageMagicBgBlur($img) {
    if(!widgetVars.doImageMagicBgBlur)
      return;

    var imgHeight = $img.height(),
        $parent = $img.parent(),
        cntrHeight = $parent.height(),
        heightRatio = imgHeight/cntrHeight;

    if(heightRatio > 1.5) {
      if(!$parent.hasClass('img_magic')) {
        $parent.addClass('img_magic');
        $('<div class="frosted_glass" />').prependTo($parent);

        var $baseClone = $img.clone().removeClass("grv_article_img grv_full_height grv_full_width grv_positionable").css({ position: 'absolute', left: '-1%' }).addClass('bg_fade').prependTo($parent);
        for(var i=2; i<=8; ++i)
          $baseClone.clone().css('left', '-' + i + '%').addClass('fade_' + i).prependTo($parent);
        $baseClone.addClass('fade_1');
      }

      $img.removeClass('grv_full_width');
      $img.addClass('grv_full_height shadow');
      $img.css({
        "margin": "0 auto",
        "display": "block",
        "position": "relative",
        "width": "auto",
        "height": "100%"
      });
    }
  }

  function verticalSpace() {
    var vert_margin;
    var totalElementsHeight;
    var totalSpaces = 2; // Accounts for the top and bottom

    if (!widgetVars.doVerticalSpace) {
      return;
    }

    totalElementsHeight = $widget.find('h3.grv_stories_header').outerHeight();

    totalSpaces += scoped$('.grv_article').length;
    scoped$('.grv_article').each(function(index) {
        totalElementsHeight += $(this).outerHeight();
    });

    if (scoped$('#grv_badge').is(":visible")) {
      totalElementsHeight += scoped$('#grv_badge').outerHeight();
      totalSpaces++;
    }

    vert_margin = ($widget.innerHeight()-totalElementsHeight)/totalSpaces;

    scoped$('.grv_article').css("margin-top",vert_margin);
    $widget.find('h3.grv_stories_header').css("margin-top",vert_margin);
    scoped$('#grv_badge').css("margin-top",vert_margin);
  }

  /**
   * Replaces instances of delim in fieldValue with "-".
   *
   * @param {String} fieldValue
   * @param {String} delim
   *
   * @returns {String}
   */
  function sanitizeFieldForClickCapturePostMessage(fieldValue, delim) {
    return fieldValue.replace(new RegExp('\\' + delim, 'g'), '-');
  }

  function bindArticleHandlers($grvparent) {
    var $forwardingLinks = $grvparent.find('[' + forwardHrefDataAttrName + ']');

    // Partner is capturing clicks; iframe widgets only at this time and only if post message is supported
    if(/[&?]cc(&|$)/.test(location.search || '') && widgetVars.isIframe && postMessageSupported) {
      // Article link click
      $forwardingLinks.click(function(e) {
        // Suppress click
        e.preventDefault();

        var $link = $(this),
            $article = $link.closest('.grv_article'),
            $title = $article.find('.grv_article_title'),
            title = $.trim($title.attr('title') || $title.text()),
            url = $title.attr('href'),
            gravRedirectUrl = $title.data('forwardHref');

        // Trigger a background click beacon
        $.ajax(gravRedirectUrl, {
          dataType: 'jsonp',
          jsonp: 'jscb',
          complete: function() {
            // Notify the parent. Be careful that exposedArticle doesn't get too large as it is transmitted via postMessage
            var delim = '|',
                exposedArticleFieldsStr = [
                  sanitizeFieldForClickCapturePostMessage(title, delim),
                  sanitizeFieldForClickCapturePostMessage(url, delim)
                ].join(delim);
            postRawParentMessage('grvClk' + exposedArticleFieldsStr);
          }
        });
      });
    }
    // Partner not capturing clicks; normal click behavior
    else {
      if(widgetVars.doAolOmniture) {
        $forwardingLinks.click(omniTrackLinkClick)
          .bind('contextmenu', widgetVars.clickThroughOnRightClick ? omniTrackLinkClick : rewriteHref);
      }
      // Non-Omniture
      else
        $forwardingLinks.click(function(e) {
          var $article;

          // Google Analytics for organics and this is a left-click
          if(widgetVars.googleAnalyticsOrganicClicks && window.ga && e.which == 1 && !(($article = $(this).closest('.grv_article')).hasClass('grv_is_sponsored')))
            gaTrackOrganicClick.apply(this, arguments);
          // Non-Google Analytics
          else
            rewriteHref.apply(this, arguments);
        }).bind('contextmenu', rewriteHref);
    }

    if (widgetVars.showMouseoverSlide) {
      var articles = $grvparent.is('.grv_article') ? $grvparent : $grvparent.find('.grv_article');
      articles
        .mouseover(function() { $(this).children('.grv_img_link').stop().animate({"top": "80px"}, "fast"); })
        .mouseout(function() { $(this).children('.grv_img_link').stop().animate({"top": "34px"}, "fast"); })
        ;
    }

    grvToggleRatingBtnEvents($grvparent.find('.grv_thumb_rating'), true);

    $grvparent.find('.grv_subscriber_only')
      .bind('mouseenter', function() { $(this).siblings('.grv_subscriber_info').show(); })
      .bind('mouseleave', function() { $(this).siblings('.grv_subscriber_info').hide(); })
      ;
  }

  /** @this HTMLElement A link with data-forward-href. */
  function omniTrackLinkClick(e) {
    // Do not interrupt right clicks
    if(e.which == 3)
      return;

    var $link = $(this),
        redirectUrl = $link.attr(forwardHrefDataAttrName),
        destUrl = $link.attr('href'),
        newTab = $link.attr('target') == '_blank';

    // Send exit beacon if external URL
    if(omniIsExternalUrl(destUrl))
      omniGravExit(destUrl);

    // If opening in same window, we need to cancel the click and set a timeout so Omniture can track click
    if(!newTab) {
      e.preventDefault();
      setTimeout(function() {
        window.top.location.href = redirectUrl;
      }, 500);
    }
    // Opening in new window (i.e. following browser behavior); need to rewrite HREF
    else
      rewriteHref.apply(this, arguments);
  }

  /**
   * @param {jQuery} $article The .grv_article.
   *
   * @return {Number}
   */
  function getArticleIndex($article) {
    var $container = $article.closest('.grv_articles'),
        $prevContainers = $container.prevAll('.grv_articles');

    return $prevContainers.find('.grv_article').length + $article.index();
  }

  /** @this HTMLElement A link with data-forward-href. */
  function gaTrackOrganicClick(e) {
    var $link = $(this),
        $article = $link.closest('.grv_article'),
        articleIndex = getArticleIndex($article),
        redirectUrl = $link.data('forwardHref'),
        newTab = $link.attr('target') == '_blank',
        gaDo = 'send',
        gaType = 'event',
        gaCategory = 'Gravity',
        gaAction = 'click',
        gaLabel = widgetVars.sitePlacementId,
        gaValue = articleIndex,
        gaOptions = { location: widgetVars.frameUrl };

    try {
      // New tab; need to rewrite HREF but can otherwise let browser resume normal link click behavior
      if(newTab) {
        ga(gaDo, gaType, gaCategory, gaAction, gaLabel, gaValue, gaOptions);
        rewriteHref.apply(this, arguments);
      }
      // Same tab; must wait for GA to complete before redirecting user via JS
      else {
        e.preventDefault();
        var gaTimeoutMs = 500,
            onGaCompleteCalled = false,
            onGaComplete = function() {
              if(onGaCompleteCalled) return;
              onGaCompleteCalled = true;
              window.top.location.href = redirectUrl;
            };

        ga(gaDo, gaType, gaCategory, gaAction, gaLabel, gaValue, $.extend({ hitCallback: onGaComplete }, gaOptions));
        setTimeout(onGaComplete, gaTimeoutMs);
      }
    }
    catch(e) {
      window.top.location.href = redirectUrl;
    }
  }

  /**
   * @this HTMLElement A link with data-forward-href.
   */
  function rewriteHref() {
    var $link = $(this),
        targetHref = $link.attr(forwardHrefDataAttrName);
    if(targetHref)
      $link.attr('href', targetHref);
  }

  function grvToggleRatingBtnEvents($btns, eventsOn) {
    var bindFunc = eventsOn ? 'bind' : 'unbind';
    $btns[bindFunc]('click', grvRateClick);
  }

  function grvRatingStr(liked, unliked, disliked) {
    if(liked) return 'like';
    else if(unliked) return 'unlike';
    else if(disliked) return 'dislike';
    else return null;
  }

  function grvRateClick(e) {
    e.preventDefault();
    var $btn = $(this),
        $btns = $btn.siblings('.grv_thumb_rating'),
        $article = $btn.closest('.grv_article'),
        clickedLike = $btn.hasClass('grv_thumbs_up'),
        unliked = clickedLike && $article.hasClass('grv_liked'),
        liked = clickedLike && !unliked,
        disliked = !liked && !unliked,
        ratingUrl = (widgetVars.rateRecoBaseUrl || '') + '/' + grvRatingStr(liked, unliked, disliked);

    // Disable buttons
    grvToggleRatingBtnEvents($btns, false);

    // Liked
    if(liked) {
      $article.addClass('grv_liked');
    }
    // Unliked or disliked
    else {
      $article.removeClass('grv_liked');

      // Specifically disliked
      if(disliked) {
        // Destroy article
        $article.children().animate({opacity: 0}, 500, function() {
          $article.height($article.height()).css('min-height', 0).slideUp('slow', function() {
            // Redraw scrollbar
            grvInitInnerScroll();
          });
        });
      }
    }

    var rateComplete = function() {
      // Enable buttons
      grvToggleRatingBtnEvents($btns, true);
    };

    // Has user GUID; if doesn't have user GUID, we just faked success but won't hit server
    if($.trim(widgetVars.userGuid) !== '') {
      $.ajax({
        dataType: 'jsonp',
        url: ratingUrl,
        data: {
          ai: $article.attr('data-id'), // .data() would cause article ID 64-bit Long to be cast to 32-bit JS Number;
                                        // we need it kept as string to preserve precision
          sg: widgetVars.siteGuid,
          ug: widgetVars.userGuid
        },
        complete: rateComplete
      });
    }
  }

  function grvLoadTab() {
    var queryStr = grvQueryString();
    var tab = $(this);
    var tabId = tab.attr('data-panel-id');
    var deferredArticlesUrl = grvNoFinalSlashUrl + '/tab/' + tabId + queryStr;
    var targetPanel = scoped$('#grv_mostPopularTab_panel_' + tabId);
    targetPanel.find('.grv_spinner').show().siblings('.grv_panel_content').hide();
    $.ajax({
      url: deferredArticlesUrl,
      timeout: 1000 * 10,
      success: function(html) {
        targetPanel.find('.grv_spinner').hide().siblings('.grv_panel_content').html(html).show();
        bindArticleHandlers(targetPanel);
      },
      error: function(xhr, textStatus, errorThrown) {
        targetPanel.find('.grv_spinner').hide().siblings('.grv_panel_content').html("<p>Sorry, there are no posts available right now.</p><p>Please try again later.</p>").show();
        tab.one('click', function() { grvLoadTab.call(tab); });
        $.post(grvNoFinalSlashUrl + '/log', { desc: textStatus + ': ' + errorThrown });
      }
    });
  }

  function checkRespWidth() {
    if(ensure$widget()) {
      var curWidth = $widget.outerWidth(),
          lastWidth = $widget.data('lastWidthForCheckRespWidth.grv');

      // Only if there is actually a width and it changed
      if(curWidth > 1 && (!lastWidth || lastWidth != curWidth)) {
        $widget.data('lastWidthForCheckRespWidth.grv', curWidth)
          .toggleClass('grv_less_940', curWidth < 940)
          .toggleClass('grv_less_820', curWidth < 820)
          .toggleClass('grv_less_650', curWidth < 650)
          .toggleClass('grv_less_520', curWidth < 520)
          .toggleClass('grv_less_481', curWidth < 481)
          .toggleClass('grv_less_322', curWidth < 322);
      }
    }

    $doc.trigger('responsiveSettled.grv', [$widget, $articleContainer]);
  }

  var numRetruncateAttemptsKey = 'numRetruncateAttempts.grv',
      maxRetruncateAttempts = 20;
  function dotdotdotTitlesCallback(isTruncated, $originalTitle) {
    var $articleTitle = $(this),
        trimmedTitle = $.trim($articleTitle.text());

    // Never let article titles be truncated to empty
    if(trimmedTitle === '' || trimmedTitle == '...') {
      $articleTitle.attr('title', null).text($originalTitle.text(), /* skipDotdotdot */ true);

      // Haven't reached max re-truncate attempts
      var numRetruncateAttempts = parseInt($articleTitle.data(numRetruncateAttemptsKey) || 0);
      if(numRetruncateAttempts < maxRetruncateAttempts) {
        setTimeout(function() {
          ++numRetruncateAttempts;
          $articleTitle.data(numRetruncateAttemptsKey, numRetruncateAttempts);
          updateDotdotdot($articleTitle);
        }, 100);
      }
    }
    // Article title not truncated to empty
    else
      $articleTitle.attr('title', isTruncated ? $.trim($originalTitle.text()) : null);
  }

  function dotdotdotContentCallback(isTruncated, $originalContent) {
    var $articleContent = $(this),
        trimmedContent = $.trim($articleContent.text());

    // Never let content be truncated to empty
    if(trimmedContent === '' || trimmedContent == '...') {
      $articleContent.text($originalContent.text(), /* skipDotdotdot */ true);

      // Haven't reached max re-truncate attempts
      var numRetruncateAttempts = parseInt($articleContent.data(numRetruncateAttemptsKey) || 0);
      if(numRetruncateAttempts < maxRetruncateAttempts) {
        setTimeout(function() {
          ++numRetruncateAttempts;
          $articleContent.data(numRetruncateAttemptsKey, numRetruncateAttempts);
          updateDotdotdot($articleContent);
        }, 100);
      }
    }
  }

  /**
   * @this {Object} DOM element.
   *
   * @return {Boolean} TRUE if element has both width and height.
   */
  function elemHasDim() {
    var $el = $(this);
    return $el.width() && $el.height() && $el.width() > 10 && $el.height() > 5;
  }

  function initDotdotdot() {
    var $filtered;

    if(truncateArticleTitles) {
      // Only attempt dotdotdot if article title has dimensions
      $filtered = $articleTitles.filter(elemHasDim);
      $filtered.length && $filtered.dotdotdot({ callback: dotdotdotTitlesCallback });
    }

    if(truncateArticleContent) {
      // Only attempt dotdotdot if article content has dimensions
      $filtered = $articleContents.filter(elemHasDim);
      $filtered.length && $filtered.dotdotdot({ callback: dotdotdotContentCallback });
    }
  }

  /** @param {jQuery} [$givenElems=] If not provided, re-truncates everything. */
  function updateDotdotdot($givenElems) {
    if($givenElems == null)
      $givenElems = $articleTitles.add($articleContents);

    // Only update dotdotdot if elements have dimensions
    var $filtered = $givenElems.filter(elemHasDim);
    if($filtered.length) {
      $filtered.trigger('destroy.dot');
      initDotdotdot();
    }
  }

  function grvInitInnerScroll() {
    if(widgetVars.useInnerScroll && $grvScrollableHandle) {
      // Wait for nanoScroller load as needed
      if(!$.fn.nanoScroller) {
        window.grvNanoScrollerLoadedCallbacks = window.grvNanoScrollerLoadedCallbacks || [];
        window.grvNanoScrollerLoadedCallbacks.push(grvInitInnerScroll);
      }
      // NanoScroller ready
      else {
        // OK, now wait for widget to be visible; JSONP widgets only
        if(!widgetVars.isIframe && !$widget.is(':visible')) {
          var widgetVisibleInterval = setInterval(function() {
          if($widget.is(':visible')) {
            clearInterval(widgetVisibleInterval);
            grvInitInnerScroll();
          }
        }, 50);
        }
        // Widget visible, good to go for nanoScroller
        else {
          // Arbitrary timeout to further let browser actually render something; fuck
          setTimeout(function() {
            $grvScrollableHandle.nanoScroller({
              contentClass: 'grv_panel_content'
            });
          }, 200);
        }
      }
    }
  }

  /**
   * For iframe widgets only, waits for a message from widget loader indicating that the iframe is now visible.
   *
   * It is very important this method is called before the "grv_show" message is posted to widget loader in order to
   * ensure our own handler for "widgetShown" is bound.
   */
  function grvBeginIframeWidgetShownWatch() {
    // Have everything we need and serving widget loader is at sufficient version
    if(postMessageSupported && widgetVars.frameUrl && parent !== window && widgetVars.widgetLoaderVersion >= 2) {
      var onMessage;
      $window.bind('message', onMessage = function(event) {
        var data = event.originalEvent.data,
            origin = event.originalEvent.origin;

        // Widget shown
        if(data == 'widgetShown' && widgetVars.frameUrl.indexOf(origin) == 0) {
          $window.unbind('message', onMessage);
          grvWidgetDimUpdated();
          grvUpdateHeight();
          grvInitInnerScroll();
        }
      });
    }
    // Missing something; assume widget shown. For the problem this routine is solving, it won't matter anyway that we're
    // making the assumption that widget is shown. This routine has to do with dotdotdot happening too early before widget
    // is visible in iOS browsers -- those browsers do support postMessage and therefore support the above fix.
    else {
      grvWidgetDimUpdated();
      grvInitInnerScroll();
    }
  }

  function grvInitIframeWidgetInViewWatch() {
    var ordinalToArticleUrl = null;

    // Pass all displayed ordinals + articles for AOL widgets
    if(window.grvIsAolPartner) {
      ordinalToArticleUrl = {};
      $articleTitles.each(function() {
        var $articleTitle = $(this);
        ordinalToArticleUrl[$articleTitle.closest('.grv_article').index().toString()] = $articleTitle.attr('href');
      });
    }

    var ivData = new window.GrvImpressionViewedData(widgetVars.siteGuid, widgetVars.placementId, widgetVars.userGuid,
        widgetVars.impressionHash, ordinalToArticleUrl);

    // No post message support
    if(!postMessageSupported) {
      window.grvSendImpressionViewed($, ivData, GrvImpressionViewedEventError.NO_POSTMESSAGE_SUPPORT);
    // Widget loader not top window
    } else if(window.parent !== window.parent.parent) {
      window.grvSendImpressionViewed($, ivData, GrvImpressionViewedEventError.WIDGET_LOADER_NOT_IN_TOP_WINDOW);
    } else {
      var $testP = $('<p />').width(1).height(1).appendTo('body'),
          boundingClientRectSupported = !!$testP[0].getBoundingClientRect();
      $testP.remove();

      // BlackBerry 5 and iOS 3 do not provide getBoundingClientRect(); it is impossible to tell if the widget enters
      // viewport on those devices
      if(!boundingClientRectSupported) {
        window.grvSendImpressionViewed($, ivData, GrvImpressionViewedEventError.NO_BOUNDING_CLIENT_RECT_SUPPORT);
      // All OK for impression viewed
      } else {
        var onMessage;
        $window.bind('message', onMessage = function(event) {
          var data = event.originalEvent.data,
              origin = event.originalEvent.origin;

          // Widget in view
          if(data == 'widgetInView' && widgetVars.frameUrl.indexOf(origin) == 0) {
            $window.unbind('message', onMessage);
            window.grvSendImpressionViewed($, ivData);
          }
        });
      }
    }
  }

  /**
   * To be called when widget is positively or most likely visible (parent container and iframe are visible).
   */
  function grvWidgetDimUpdated() {
    if(usingDotdotdot) {
      if(!dotdotdotInitted) {
        dotdotdotInitted = true;
        initDotdotdot();
      }
      else {
        updateDotdotdot();
      }
    }
  }

  $(function() {
    ensure$widget();

    $articleContainer = scoped$('.grv_articles');

    if(widgetVars.useInnerScroll) {
      $grvScrollableHandle = $widget.find('.grv_panel');
    }

    $grvImgLinks = scoped$('.grv_img_link');
    $(document).bind('newArticleImgLink.grv', function(e, $elem) { $grvImgLinks = $grvImgLinks.add($elem); });

    checkRespWidth();

    bindArticleHandlers(scopeFor$() || $('body'));

    scaleImages();
    verticalSpace();

    scoped$('.grv_tab').click(function() {
      var tab = $(this);
      tab.addClass('grv_selectedTab').siblings().removeClass('grv_selectedTab');
      scoped$('#grv_mostPopularTab_panel_' + tab.attr('data-panel-id')).show().siblings('.grv_panel').hide();
      return false;
    });

    scoped$('.grv_deferred').one('click', grvLoadTab);

    if (widgetVars.beaconUrl)
      $.getScript(widgetVars.beaconUrl);

    $articleTitles = scoped$('.grv_article_title');
    $(document).bind('newArticleTitle.grv', function(e, $elem) { $articleTitles = $articleTitles.add($elem); });

    $articleContents = scoped$('.grv_article_content');
    $(document).bind('newArticleContent.grv', function(e, $elem) { $articleContents = $articleContents.add($elem); });

    grvUpdateHeight();

    (function() {
      var resizeEndTimeout,
          allowInitialResizesToProcessImmediately = 3;

      $window.resize(function(e, arg1) {
        if(resizeEndTimeout) {
          clearTimeout(resizeEndTimeout);
          resizeEndTimeout = null;
        }

        if(allowInitialResizesToProcessImmediately > 0) {
          --allowInitialResizesToProcessImmediately;
          resizeEnd();
        }
        else if(arg1 && arg1 === 'noDebounce')
          resizeEnd();
        else {
          resizeEndTimeout = setTimeout(function() {
            resizeEnd();
          }, 500);
        }
      });

      function resizeEnd() {
        //do something, window hasn't changed size in 500ms
        checkRespWidth();
        scaleImages();
        grvUpdateHeight();
      }
    })();

    // Iframe widget only (JSONP events handled in separate context at a later time)
    if (widgetVars.isIframe) {
      window.grvLogDomReadyEvent($, widgetVars);
      grvInitIframeWidgetInViewWatch();

      // This is a safeguard for iframe widgets. In case the widget fails to load (and hence widget.js fails to load), the
      // widget will remain hidden so the user doesn't see some error page in the iframe. In the instance widget.js loads
      // and gets to the call to this function here, we notify the widget loader via postMessage to show the widget and wait
      // for impression viewed.
      //
      // NOTE: It is important for this to come after the call to grvInitIframeWidgetInViewWatch(), which sets up "message"
      // event binding; once widget loader is instructed to show widget, it will expect widget.js to be able to receive the
      // "widgetInView" message.
      grvBeginIframeWidgetShownWatch();
      postParentMessage('grv_show');

      widgetVars.doAolOmniture && aolOmnitureAndDataLayerPingIframeWidget();
    }
    // Non-iframe widget
    else {
      grvWidgetDimUpdated();

      // Inner scroll will get initted for iframe widgets after iframe "shown" message received
      grvInitInnerScroll();

      widgetVars.doAolOmniture && aolDataLayerPingJsonpWidget();
    }

    initAttribution();
  });

  $window.load(function() {
    // Solves issues with IE not being ready with height until window load; but we still want to fire it in DOM ready
    // block above because then our widget potentially displays sooner. Also, there is another "fail safe" especially to
    // fix IE9 where height is updated when iframe widget is positively shown (after having been notified of that by
    // widget loader via postMessage).
    grvUpdateHeight();
  });

  var omniLinkInternalFilters = '.aol.com,.mapquest.com,#dl,.atwola.com,.doubleclick.net,.ru4.com,.adsonar.com,.aol.it,about:,aol://,.aol.co.uk,.aol.ca,.aim.com,.huffingtonpost.co.uk,.huffingtonpost.ca,huff.to,.games.com,.dailyfinance.com,.stylelist.com,.patch.com,.aoltv.com,aol.sportingnews.com,.engadget.com,.autoblog.com,.noisecreep.com,.theboot.com,.spinner.com,.mydaily.com,.mydaily.co.uk,.cambio.com,.moviefone.com,.mandatory.com,.pawnation.com,.theboombox.com,webmail.cs.com,.techcrunch.com,.gadling.com,aolradio.slacker.com,.adtech.de,.makers.com,.247wallst.com,.aolcdn.com,aol.careerbuilder.com,.aolradio.com,.aolartists.com,.parentdish.co.uk,.walletpop.ca,.aolradioblog.com,.aolheroes.com,.shortcuts.com,.joystiq.com,.tuaw.com,.homesessive.com,.kitchendaily.com,.purpleclover.com,.huffingtonpost.com,.huffpost.com,.wow.com,.stylemepretty.com,.tested.com,.crunchbase.com,aol.king.com,.netscape.com,.compuserve.com,.aolsearch.com,.moviefone.ca,.altomail.com,.luxist.com,.mapquest.co.uk,.mapquest.ca,.stylelist.ca,.parentdish.ca,.gathr.com,.tourtracker.com,.gdgt.com';

  function aolDataLayerPingJsonpWidget() {
    if(!window.bN) {
      setTimeout(aolDataLayerPingJsonpWidget, 50);
      return;
    }

    bN.set('grv-plugin-id', widgetVars.sitePlacementId);
    bN.ping('mlt');
  }

  /** This is only to be used for iframe widgets, in which an isolated JS scope can be guaranteed. */
  function aolOmnitureAndDataLayerPingIframeWidget() {
    window.bN_cfg = {
      // The "h" parameter whitelists this hostname for beacon initialization.
      // Note: Can be a string or an array of hostnames. Use "location.hostname" to match URL of current page
      h: location.hostname,

      // Serve from b.aol.com instead of b.gravity.com
      b: 'b.aol.com',

      p: {
        module: widgetVars.aolOmniModuleName,
        brand: widgetVars.aolOmniBrand,

        cms_src: widgetVars.aolCmsSrc,
        cobrand: widgetVars.aolCobrand
      },

      view: 0
    };

    // Special mappings
    if(window.grvAolOmniPassThru) {
      if(window.grvAolOmniPassThru.prop23) window.bN_cfg.p.dL_ch = window.grvAolOmniPassThru.prop23;
      if(window.grvAolOmniPassThru.prop1) window.bN_cfg.p.dL_dpt = window.grvAolOmniPassThru.prop1;
      if(window.grvAolOmniPassThru.prop2) window.bN_cfg.p.dL_sDpt = window.grvAolOmniPassThru.prop2;
    }

    // Wait for bN to become available
    function aolDataLayerPingWhenBnReady() {
      if(window.bN) {
        if(window.bN.set && window.bN.ping) {
          window.bN.set('cids', (function() {
            var cids = [];
            scoped$('.beacon-ping-cids').each(function() {
              cids.push($(this).data('cid'));
            });

            return cids.join(',');
          })(), 1);

          window.bN.set('plids', (function() {
            var plidMnidStrs = [];
            scoped$('.beacon-ping-plids').each(function() {
              var $el = $(this);
              plidMnidStrs.push($el.data('plid') + '|' + $el.data('mnid'));
            });

            return plidMnidStrs.join(',');
          })(), 1);

          window.bN.ping('mlt');
        }
      }
      else
        setTimeout(aolDataLayerPingWhenBnReady, 50);
    }
    aolDataLayerPingWhenBnReady();

    window.runOmni = function() {
      window.s_265.pfxID="gra";
      window.s_265.pageName=widgetVars.aolOmniModuleName;

      // Special mappings
      if(window.grvAolOmniPassThru && window.grvAolOmniPassThru.prop23)
        window.s_265.channel = window.grvAolOmniPassThru.prop23;
      else
        window.s_265.channel = 'us.gravity';

      window.s_265.linkInternalFilters="javascript:," + omniLinkInternalFilters;
      window.s_265.trackExternalLinks=false;
      if(window.grvAolOmniPassThru) {
        for(var key in window.grvAolOmniPassThru) {
          if(window.grvAolOmniPassThru.hasOwnProperty(key)) {
            window.s_265[key] = window.grvAolOmniPassThru[key];
          }
        }
      }
    };

    window.s_265_account=widgetVars.aolOmniAccount;
    (function(){
      var d = document, s = d.createElement('script');
      s.type = 'text/javascript';
      s.src = (location.protocol == 'https:' ? 'https://s' : 'http://o') + '.aolcdn.com/os_merge/?file=/aol/beacon.min.js&file=/aol/omniture.min.js';
      d.getElementsByTagName('head')[0].appendChild(s);
    })();
  }

  function omniIsExternalUrl(url) {
    var internalHosts = omniLinkInternalFilters.split(','),
        numInternalHosts = internalHosts.length,
        subjectHost = hostFromUrl(url).toLowerCase(),
        isExternal = true;

    for(var i=0; i<numInternalHosts; ++i) {
      var internalHost = internalHosts[i].toLowerCase(),
          posOfInternalInSubject;

      // Exact match
      if(internalHost === subjectHost) {
        isExternal = false;
        break;
      }
      // Internal host, any subdomain
      else if(internalHost.charAt(0) === '.') {
        // No subdomain
        if(internalHost.substr(1) === subjectHost) {
          isExternal = false;
          break;
        }
        // Subject host is subdomain + internal host
        else if((posOfInternalInSubject = subjectHost.indexOf(internalHost)) != -1
              && posOfInternalInSubject === subjectHost.length - internalHost.length) {
          isExternal = false;
          break;
        }
      }
    }

    return isExternal;
  }

  function omniGravExit(destUrl) {
    var ce = {};

    //Exit Link tracking should go to the aolsvc report suite
    ce.un='aolsvc';
    ce.linkTrackVars = 'prop50,prop51';

    var aolDoPlugins = window.s_265.doPlugins;
    window.s_265.doPlugins = function(s_265) {
      aolDoPlugins.apply(this, arguments);
      ce.prop50=s_265.prop50=hostFromUrl(destUrl);
      ce.prop51=s_265.prop51=window.s_265.prop23;
    };

    //send the exit link request
    window.s_265.tl(true,'e',urlSansQuery(destUrl),ce);
  }

  function hostFromUrl(url) {
    var matches = /^[^:]+:\/\/([^\/]+)/.exec(url);
    return matches && matches[1] || '';
  }

  function urlSansQuery(url) {
    return url.replace(/\?.*/, '');
  }
};