/*
 * Copyright (C) 2012-2013 TopCoder Inc., All Rights Reserved.
 */

/**
 * @author isv, TCSASSEMBLER
 * Version 1.2
 * 
 * Version 1.1 (Member Payments Automation assembly) change notes: added code for payment processing by user.
 *
 * Version 1.2 (TopCoder Reg2 Password Recovery Revamp and Misc Bug Fixes) change notes:
 * Fixed bug :https://apps.topcoder.com/bugs/browse/BUGR-8819.
 */
var MINIMUM_PAYMENT_ACCRUAL_AMOUNT;
var PAY_ME_CONFIRMATION_TEMPLATE;
var USER_PAYMENT_METHOD;


document.write('<link type="image/x-icon" rel="shortcut icon" href="/i/favicon.ico"/>');
  function getGraph(url,wd,ht) {
    var last=0;
    var daHt = parseInt(ht) + parseInt('49');
    var size = "top=2,left=2,width="+wd+",height="+daHt+"status=0,resizable=yes";
    popup = window.open('/statistics/graphPopup.jsp?'+url+'&width='+wd+'&height='+ht,null,size);
    return;
  }

  function getGraph(url,wd,ht,name) {
    var last=0;
    var daHt = parseInt(ht) + parseInt('49');
    var size = "top=2,left=2,width="+wd+",height="+daHt+",status=0,resizable=yes";
    popup = window.open('/statistics/graphPopup.jsp?'+url+'&width='+wd+'&height='+ht,name,size);
    return;
  }

function tcTime() {
  w=window.open("http://www.topcoder.com/tc?module=Static&d1=calendar&d2=time","Time","top=2,left=2,width=250,height=50,resizable=yes,status=1");
  return;
}

function sponsorLink(spons) {
  w=window.open(spons,"Sponsor");
  return;
}

function sponsorLinkWindow(spons,nam,top,lef,wid,hei) {
  w=window.open(spons,nam,"top="+top+",left="+lef+",width="+wid+",height="+hei+",resizable=yes,toolbar=no,location=no,scrollbars=no,menubar=no,status=no");
  return;
}

function openWin(url, name, w, h) {
    var left = Math.round((screen.availWidth - w)/2);
    var top = Math.round((screen.availHeight-h)/2);
    win = window.open(url, name, "scrollbars=yes,toolbar=no,resizable=yes,menubar=no"
            + ",width=" + w + ",height=" + h
            + ",left=" + left + ",top=" + top);
    win.location.href = url;
    win.focus();
}

function infoWindow(url) {
  var width = 300
  var height = 250
  var left = (screen.availWidth - width) / 2;
  var top = (screen.availHeight-height)/2;
  OpenWin=this.open(url,"Info",
            "toolbar=no,menubar=no,location=no,scrollbars=yes,resizable=yes"
            + ",width=" + width + ",height=" + height
            + ",left=" + left + ",top=" + top);
}

function openProblemRating(id) {
    var width = Math.round(560);
    var height = Math.round(660);
    var left = Math.round((screen.availWidth - width) / 2);
    var top = 0;
    var cmd = "toolbar=no,menubar=no,location=no,scrollbars=yes,resizable=yes,top="+top+",left="+left+",width=" + width + ",height=" + height + ",status=0";
    var name="problemRating";
    window.open('/tc?module=ProblemRatingQuestions&pid='+id,name,cmd);
    return;
  }


function goTo(selection) {
  sel = selection.options[selection.selectedIndex].value;
  if (sel == "alltimewin")
  {
    window.location = "/stat?c=all_time_wins";
  }
  else if (sel == "winningdebuts")
  {
    window.location = "/stat?c=winning_debuts";
  }
  else if (sel == "impressivedebuts")
  {
    window.location = "/stat?c=impressive_debuts";
  }
  else if (sel == "hightesttotal")
  {
    window.location = "/stat?c=highest_totals";
  }
  else if (sel == "ratingpointgain")
  {
    window.location = "/stat?c=biggest_rating_gains";
  }
  else if (sel == "consecwins")
  {
    window.location = "/stat?c=most_consecutive_wins";
  }
  else if (sel == "submissionaccuracy")
  {
    window.location = "/stat?c=highest_accuracy";
  }
  else if (sel == "challengesuccess")
  {
    window.location = "/stat?c=best_challengers";
  }


  else {}
}


function doWrite(s) {
    document.write(s);
}

/**
 * Validates the pagination parameters. 
 * 
 * @return {Boolean} true if pagination parameters are valid; false otherwise.
 */
function checkPaymentHistoryForm() {
    var myForm = document.f;
    var nr = myForm.nr.value;
    var sr = myForm.sr.value;
    
    var error = '';
    if (!isPositiveNumber(nr)) {
        error += 'Number of records is not positive numeric value';
        error += '\n';
    }
    if (!isPositiveNumber(sr)) {
        error += 'Starting record number is not positive numeric value';
        error += '\n';
    }

    if (error != '') {
        alert(error);
        return false;
    } else {
        $('input[name=paymentId]').attr('disabled', 'disabled');
        return true;
    }
    
}

/**
 * Checks if specified text provides positive integer number.
 * 
 * @param v a number to validate.
 * @return {Boolean} true if specified string provided positive integer number: false otherwise.
 */
function isPositiveNumber(v) {
    var regExp = new RegExp('^[0-9]+$');
    var matches = regExp.test(v);
    if (matches) {
        var n = parseInt(v);
        if (n <= 0) {
            return false;
        } else {
            return true;
        }
    } else {
        return false;
    }
}

$(document).ready(function() {
    $('.uncheckAll').click(function() {
        $('.uncheckable').attr('checked', false);
        updatePayMe();
    });
    
    $('.checkAll').click(function () {
        $('.checkable').attr('checked', true);
        updatePayMe();
    });
    
    $('.payable').click(function() {
        if (!$(this).hasClass('negative')) {
            updatePayMe();
        }
    });
    
    $('#payMe').click(function() {
        if (isUserPaymentMethodValid()) {
            var total = calcTotalPayment();
            var confirmationMessage = PAY_ME_CONFIRMATION_TEMPLATE.replace('{0}', '$' + total.toFixed(2));

            if (confirm(confirmationMessage)) {
                var myForm = document.f;
                myForm.method = 'POST';
                myForm.module.value = 'PayMe';
                myForm.submit();
            }
        }
    });
    
    $('.getable').click(function () {
        var myForm = document.f;
        myForm.method = 'GET';
        myForm.module.value = 'PaymentHistory';
        
        $('input[name=paymentId]').attr('disabled', 'disabled');
    });

    updatePayMe();

    //TopCoder Project Permission Error Page changes
    //https://apps.topcoder.com/bugs/browse/BUGR-8819
    $('.buttonArea .register').click(function(){
        // the 'isAnonymous' is defined in the projectDetails.jsp file
        if(!isAnonymous) {
            var thisObj = this;
            adjustAndShow("#preloaderModal");
            //Check Project Permission using ajax call
            $.ajax({
                type: "get",
                url: '?module=CheckPermission',
                success: function(data){
                    var result = $.parseJSON(data);
                    closeModal();
                    if('OK' !== result.msg && !result.isAnonymous) {
                        adjustAndShow("#errorModal");
                    } else {
                        location.href = $(thisObj).attr('href');
                    }
                }
            });
            return false;
        } else {
            // for the Anonymous user, go to the viewRegistration page directly.
            return true;
        }
    });

    $("#new-modal-window .closeModal, #new-modal-window .defaultBtn").click(function(){
        closeModal();
    });

    $("#m_cs_competitions").parent().find("a:eq(0)").css("color", "#f8941e");
});

/**
 * Close modal windows
 */
function closeModal() {
    $("#modal-background, #new-modal-window .outLay").hide();
}

/**
 * Adjust the overlay background and model window and display them
 */
function adjustAndShow(modal) {
    $("#modal-background").css("height", document.body.scrollHeight > document.body.offsetHeight ? (document.body.scrollHeight>$(window).height()? document.body.scrollHeight :$(window).height()) : (document.body.offsetHeight>$(window).height()? document.body.offsetHeight:$(window).height()));
    $("#modal-background, " + modal).show();
    $("#new-modal-window").css("margin-left", - $("#new-modal-window").width() / 2 + "px").css("margin-top", - $("#new-modal-window").height() / 2 + "px");
    var height = 0;
    $(modal + ".outLay .modalBody .modalContent li").each(function(){
        height += $(this).height();
    });
    if(!$(modal+ ".outLay .modalBody .modalContent").hasClass("multiple")){
        $(modal+ ".outLay .modalBody .modalContent li:first").css("padding-top", ($(".outLay .modalBody .modalContent").height() - height) / 2 + "px");
    }
    if (jQuery.browser.msie && jQuery.browser.version == '9.0') {
        $(modal + " .modalBody").css("margin-top", "-2px");
    }
}

/**
 * Updates the text of Pay Me button with total amount of selected payments.
 */
function updatePayMe() {
    var total = calcTotalPayment();
    if (total >= 0) {
        $('#payMe').val('Pay Me: $' + total.toFixed(2));
    } else {
        $('#payMe').val('Pay Me: -$' + Math.abs(total.toFixed(2)));
    }
    if (total < MINIMUM_PAYMENT_ACCRUAL_AMOUNT || !isUserPaymentMethodValid()) {
        $('#payMe').attr('disabled', 'disabled');
    } else {
        $('#payMe').removeAttr('disabled');
    }
}

/**
 * Calculates the total amount of payments selected by user.
 * 
 * @return {Number} a total amount of selected payments.
 */
function calcTotalPayment() {
    var total = 0.00;
    $('.payable:checked').each(function () {
        var amount = parseFloat($(this).parent().find('.paymentNetAmount').val());
        total += amount;
    });
    return total;
}

/**
 * Checks if current user has a payment method set to any value other than NULL or 1,3,4 (Not Set,Wire,ACH)
 */
function isUserPaymentMethodValid() {
    return (USER_PAYMENT_METHOD != null) && (USER_PAYMENT_METHOD != 1) && (USER_PAYMENT_METHOD != 3) && (USER_PAYMENT_METHOD != 4);
}
