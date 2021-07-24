if( typeof Jadeite == "undefined" )
{
	Jadeite = {};
}

Jadeite.Main = function()
{
	return {

		cleanUrl : function( url )
		{
			return url.replace( "&amp;", "&" );
		},
		
		showPackage : function( api, package, configQuery )
		{
			parent.classFrame.location.href = this.cleanUrl( "main.php?api=" + api + "&state=package" + "&package=" + package + configQuery );
		},

		showClass : function( api, package, clazz, configQuery )
		{
			parent.classFrame.location.href = this.cleanUrl( "main.php?api=" + api + "&state=class" + "&package=" + package + "&class=" + clazz + configQuery );
		},

		setAddClassPlaceholdFrameLocation : function( url )
		{
			if( parent.classAddFrame )
			{
				parent.classAddFrame.location.replace( this.cleanUrl( url ) );
			}
		},

		setAddMethodPlaceholdFrameLocation : function( url )
		{
			if( parent.methodAddFrame )
			{
				parent.methodAddFrame.location.replace( this.cleanUrl( url ) );
			}
		},

		refresh : function( frameName, suppressPlaceholderRefresh, anchor )
		{
			frame = parent.frames[ frameName ];
			if( !frame )
			{
				return;
			}

			oldHref = frame.location.href.toString();
			newHref = new String( oldHref );

			newHref = newHref.replace( /&suppressPlaceholderRefresh=[^&#]*/, "" );
			newHref = newHref.replace( /&salt=[^&#]*/, "" );
			newHref = newHref.replace( /#.*$/, "" );

			if( suppressPlaceholderRefresh )
			{
				newHref += "&suppressPlaceholderRefresh=true";
			}

			newHref += "&salt=" + new Date().getTime();

			if( anchor )
			{
				newHref += "#" + anchor;
			}

			frame.location.replace( newHref );
		}
	}
}();