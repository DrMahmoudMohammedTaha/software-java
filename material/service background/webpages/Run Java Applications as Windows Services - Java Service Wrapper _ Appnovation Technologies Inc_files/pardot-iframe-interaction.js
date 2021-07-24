/*
 * Changes the size of the Pardot iframe.
 * This script resizes the iframe that contains a Pardot Form when it receives
 * a message from the iframe. The message must be, e.g. "h=275" for a height
 * of 275px.
 * It will resize only the FIRST iframe that has the "pardot-form-iframe" class, and
 * needs to know the domain where the iframe is located.
*/
var iframe_location = "www2.appnovation.com";

function receiveMessage(event) {
  if (event.origin !== "http://" + iframe_location
      && event.origin !== "https://" + iframe_location)
    return;
  var forms_selector = [
    'iframe.pardot-form-iframe',
    'iframe.cboxIframe',
    '.contact-wrapper iframe'
  ];
  if (typeof(event.data) == "string" && event.data.indexOf("h=") == 0) {
    forms_selector.forEach(function(id) {
      var pardot_iframe = jQuery(id)[0];
      if (pardot_iframe != undefined) {
        pardot_iframe.height = parseInt(event.data.substring(2)) + "px";
      }
    });
  } else {
    forms_selector.forEach(function(id) {
      var pardot_iframe = jQuery(id)[0];
      if (pardot_iframe != undefined) {
        pardot_iframe.height = event.data + "px";
        jQuery.colorbox.resize({innerHeight:event.data });
      }
    });
  }
}
if (window.addEventListener) {
  window.addEventListener("message", receiveMessage, false);
} else if (window.attachEvent)  {
  window.attachEvent("message", receiveMessage);
}
