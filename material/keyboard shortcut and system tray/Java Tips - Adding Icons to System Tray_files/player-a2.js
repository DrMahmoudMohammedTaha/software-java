// JavaScript Document


var player;

var video, content, exp, menu, ads, social;



function onTemplateLoaded(pPlayer) {



	player = bcPlayer.getPlayer(pPlayer);



	video 	= player.getModule(APIModules.VIDEO_PLAYER);

	content = player.getModule(APIModules.CONTENT);

	exp 	= player.getModule(APIModules.EXPERIENCE);

	menu 	= player.getModule(APIModules.MENU);

	ads 	= player.getModule(APIModules.ADVERTISING);

	social 	= player.getModule(APIModules.SOCIAL);





	exp.addEventListener(BCExperienceEvent.CONTENT_LOAD, onContentLoad);

}





function onContentLoad(e) {



	video.setVolume(.2);

}



// <script type="text/javascript">

function displayCompanionBanners(banners) {

tmDisplayBanner(banners, "adCompanionBanner", 300, 250);

}


// </script>