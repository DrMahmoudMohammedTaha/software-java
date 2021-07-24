function sendEmail(s1, s2)
{
	document.location = 'mailto:' + showEmail(s1, s2);
}

function handleBbCode(evt)
{
	var e = evt || window.event;
	var thisKey = e.which || e.keyCode;

	var ch = String.fromCharCode(thisKey).toLowerCase();
	
	if (e.altKey && ch == "b") {
		bbstyle(0);
		return false;
	}
	else if (e.altKey && ch == "i") {
		bbstyle(2);
		return false;
	}
	else if (e.altKey && ch == "u") {
		bbstyle(4);
		return false;
	}
	else if (e.altKey && ch == "q") {
		bbstyle(6);
		return false;
	}
	else if (e.altKey && ch == "c") {
		bbstyle(8);
		return false;
	}
	else if (e.altKey && ch == "l") {
		bbstyle(10);
		return false;
	}
	else if (e.altKey && ch == "p") {
		bbstyle(12);
		return false;
	}
	else if (e.altKey && ch == "w") {
		bbstyle(14);
		return false;
	}
	else if (e.altKey && ch == "y") {
		bbstyle(18);
		return false;
	}
}

function enterText(field)
{
	storeCaret(field);
	document.onkeydown = handleBbCode;
}

function leaveText()
{
	document.onkeydown = null;
}

function selectCode(a)
{
	var e = a.parentNode.parentNode.getElementsByTagName('code')[0];

	if (document.selection) {
		var r = document.body.createTextRange();
		r.moveToElementText(e);
		r.select();
	}
	else {
		var s = window.getSelection();
		var r = document.createRange();
		r.setStartBefore(e);
		r.setEndAfter(e);
		s.addRange(r);
	}
}

function toggleLike (postId, token) {
    var likeImage = imagesServedFrom + "/templates/default/images/jr.button.plus.1.thumb.gif";
    var unlikeImage = imagesServedFrom + "/templates/default/images/jr.button.minus.1.thumb.gif";
	var likeURL = forumUrlPrefix + "/posts/like/" + postId + "?OWASP_CSRFTOKEN=" + token;
	var unlikeURL = forumUrlPrefix + "/posts/unlike/" + postId + "?OWASP_CSRFTOKEN=" + token;

    var unlikeHandler = function() { turnOn=false; toggleLike(postId, token); return false; };
    var likeHandler = function() { turnOn=true; toggleLike(postId, token); return false; };
    $.ajax({
        url: turnOn ? likeURL : unlikeURL,
        type: 'POST',
        dataType: 'json',
        headers: {'OWASP_CSRFTOKEN': token},
        success: function (data) {
            $("#like_message_" + postId).html("<img src='" + imagesServedFrom + "/templates/default/images/thumbs-up.gif'"
                                                +" title='"+data.message+"'/> "+data.count);
            if (turnOn) {
                $(".toggleLikeImage_"+postId)[0].src = unlikeImage;
                $(".toggleLikeLink_"+postId)[0].href = unlikeURL;
                $(".toggleLikeLink_"+postId)[0].onclick = unlikeHandler;
                $("#like_message_" + postId).css("visibility", "visible");
            } else {
                $(".toggleLikeImage_"+postId)[0].src = likeImage;
                $(".toggleLikeLink_"+postId)[0].href = likeURL;
                $(".toggleLikeLink_"+postId)[0].onclick = likeHandler;
                if (data.count == 0)
                    $("#like_message_" + postId).css("visibility", "hidden");
            }
        }
    });
}
