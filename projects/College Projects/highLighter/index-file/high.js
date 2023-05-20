document.onkeypress = function(evt) {
    evt = evt || window.event;
    var charCode = evt.keyCode || evt.which;
    var charStr = String.fromCharCode(charCode);

if ( charStr == 'h' || charStr == 'H')
  {

  	  selected = getSelectionText();
  	  stylizeHighlightedString();
  }
};


function getSelectionText() {
    var text = "";
    if (window.getSelection) {
        text = window.getSelection().toString();
    } else if (document.selection && document.selection.type != "Control") {
        text = document.selection.createRange().text;
    }
    return text;
}



function stylizeHighlightedString() 
{
  //alert(text.focusOffset - text.anchorOffset);

  var text = window.getSelection();
  var start = text.anchorOffset;
  
  var end = text.focusOffset - text.anchorOffset;
  
  range = window.getSelection().getRangeAt(0);
  range1 = window.getSelection().toString();
  var selectionContents = range.extractContents();
  var span = document.createElement("span");

  span.appendChild(selectionContents);

  span.setAttribute("class", "uiWebviewHighlight");
  span.style.backgroundColor = "yellow";
  span.style.color = "black";

  range.insertNode(span);
}

