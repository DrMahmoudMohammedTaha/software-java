
// Refresh the current page -- http://grizzlyweb.com/webmaster/javascripts/refresh.asp
// Javascript 1.2 only
function refresh() { window.location.reload(false); }

// http://www.imint.com/support/sp042.htm
function checkFrames()
{
	my_frames_page = "frame.html";
	top_page = top.location.toString().toLowerCase();
	if (top_page.indexOf(my_frames_page)==-1) 
		top.location = my_frames_page;
}

// http://www.somacon.com/p117.php
function setAllCheckBoxes(formName, fieldName, checkValue)
{
	if (!document.forms[formName])
		return;
	var objCheckBoxes = document.forms[formName].elements[fieldName];
	if(!objCheckBoxes)
		return;
	var countCheckBoxes = objCheckBoxes.length;
	if (countCheckBoxes == 0)
		objCheckBoxes.checked = CheckValue;
	else
		// set the check value for all check boxes
		for(var i = 0; i < countCheckBoxes; i++)
			objCheckBoxes[i].checked = checkValue;
}

function isABoxChecked(formName, fieldName)
{
	if (!document.forms[formName])
		return false;
	var objCheckBoxes = document.forms[formName].elements[fieldName];
	if(!objCheckBoxes)
		return false;
	var countCheckBoxes = objCheckBoxes.length;
	if (countCheckBoxes == 0)
		return false;
	for(var i = 0; i < countCheckBoxes; i++)
		if (objCheckBoxes[i].checked)
			return true;
	return false;
}

function isAllChecked(formName, fieldName)
{
	if (!document.forms[formName])
		return false;
	var objCheckBoxes = document.forms[formName].elements[fieldName];
	if(!objCheckBoxes)
		return false;
	var countCheckBoxes = objCheckBoxes.length;
	if (countCheckBoxes == 0)
		return false;
	for(var i = 0; i < countCheckBoxes; i++)
		if (!objCheckBoxes[i].checked)
			return false;
	return true;
}

function enableButtonIfABoxIsChecked(formName, fieldName, buttonName)
{
	var isChecked = isABoxChecked(formName, fieldName);
	document.forms[formName].elements[buttonName].disabled = !isChecked;
}

function disableButtonIfAllChecked(formName, fieldName, buttonName)
{
	var allChecked = isAllChecked(formName, fieldName);
	document.forms[formName].elements[buttonName].disabled = allChecked;
}

function checkMasterCheckbox(checkboxName, formName, fieldName)
{
	if (!document.forms[formName] || !document.forms[formName].elements[checkboxName])
		return;
	var checkValue = document.forms[formName].elements[checkboxName].checked;
	setAllCheckBoxes(formName, fieldName, checkValue)
}

function validateRegistrationCode(form)
{
	var regCode = form.code.value;
	
	if (regCode == "") {
    	alert("Please specify your 13-character code in the format XXXX-XXX-XXXX.");
    	form.code.focus();
    	return false;
	}
	
 	if (regCode.length != 13) {
	    alert("The registration code must be 13 characters long." );
    	form.code.focus();
    	return false;
	}
	
  	var matchArr = regCode.match(/^([a-zA-Z\d]{4})-?[a-zA-ZZ\d]{3}-?[a-zA-Z\d]{4}$/);
	if (matchArr == null) {
    	alert("The registration code must in the format XXXX-XXX-XXXX, with only A-Z letters or numbers." );
    	form.code.focus();
    	return false;
	}
	
	// Looks valid
  	return true;
}

function hideContent(d)
{
	document.getElementById(d).style.display = "none";
}

function showContent(d)
{
	document.getElementById(d).style.display = "";
}

function toggleContentDisplay(d)
{
	if (document.getElementById(d).style.display == "none") {
		document.getElementById(d).style.display = "";
	} else {
		document.getElementById(d).style.display = "none";
	}
}

function validatePath(value)
{
	if (value.indexOf("+") != -1 || value.indexOf("#") != -1 || value.indexOf("/") != -1 || value.indexOf("*") != -1 
		|| value.indexOf(">") != -1 || value.indexOf("<") != -1 || value.indexOf("|") != -1) {
 		alert("The path should not contain any of these characters: + # / \" * | < >"); 
		return false;
	} else {
		return true;
	}
}

function validateSubFolder(value)
{
	if (value.indexOf("+") != -1 || value.indexOf("#") != -1 || value.indexOf("/") != -1 || value.indexOf("*") != -1 
		|| value.indexOf(">") != -1 || value.indexOf("<") != -1 || value.indexOf("|") != -1 || value.indexOf(":") != -1 || value.indexOf("\\") != -1) {
 		alert("The sub-folder name should not contain any of these characters: + # / \\ \" * | < > :"); 
		return false;
	} else {
		return true;
	}
}

function displayBox(box,show)
{
	window.scrollTo(0,0);
	document.getElementById(box).style.visibility=show?"visible":"hidden";
	if (box == 'CreateFolder') document.NF.FolderName.focus();
}

function clearForm(oForm)
{
	var elements = oForm.elements;
	oForm.reset();
	for (i=0; i<elements.length; i++) {
		if (elements[i].type == undefined)
			continue; // skip elements w/ no type
		field_type = elements[i].type.toLowerCase();
		switch(field_type) {
			case "text":
			case "password":
			case "textarea":
			case "hidden":  
				elements[i].value = "";
				break;
   
			case "radio":
			case "checkbox":
				if (elements[i].checked)
					elements[i].checked = false;
				break;

			case "select-one":
			case "select-multi":
				elements[i].selectedIndex = 0;
				break;
				
			default:
				break;
		}
	}
}

function customerLogoSlideshowAdvance()
{
	// Keep a counter of the number of times that this operation has been done.
	{
		if( typeof customerLogoSlideshowAdvance.counter == 'undefined' ) {
			customerLogoSlideshowAdvance.counter = 0;
		}
		customerLogoSlideshowAdvance.counter++;
	}
	
	// Done if too many times.
	var isDone = (customerLogoSlideshowAdvance.counter > 100);

    var $active = $('#customer-logo-slideshow IMG.active');

    if ( $active.length == 0 ) $active = $('#customer-logo-slideshow IMG:last');

    // use this to pull the images in the order they appear in the markup
    //var $next =  $active.next().length ? $active.next()
    //    : $('#slideshow IMG:first');
   
    var $url;
    if (isDone) {
    	$url = '/customer-logos/logo144.jpg'; // always end with this one (Shell)
    } else {
        // Pull images in random order.
        // Have 237 images...
        var rndNum = Math.floor(Math.random()*237)+1;
    	$url = '/customer-logos/logo' + rndNum + '.jpg';
    }
    
    var $next = $active;
	$next.attr('src', $url);
	
    $active.addClass('last-active');

    $next.css({opacity: 0.0})
        .addClass('active')
        .animate({opacity: 1.0}, 1000, function() {
            $active.removeClass('active last-active');
        });
	
    // Set the next timeout if not done.
    // Increase the timeout if we have already presented 30 images.
    if (!isDone) {
    	var $timeoutTime = (customerLogoSlideshowAdvance.counter < 30 ? 2000 : 10000);
    	setTimeout( "customerLogoSlideshowAdvance()", $timeoutTime );
    }
}

function scrollObject(main, width, height, direct, pause, speed, isRandom)
{
  var self = this;
  this.main = main;
  this.width = width;
  this.height = height;
  this.direct = direct;
  this.pause = pause;
  this.isRandom = isRandom;
  this.speed = Math.max(1.001, Math.min((direct == "up" || direct == "down") ? height : width, speed));
  this.block = new Array();
  this.blockprev = this.offset = 0;
  this.blockcurr = 1;
  this.mouse = false;
  this.scroll = function() {
    if (!document.getElementById) return false;
    this.main = document.getElementById(this.main);
    while (this.main.firstChild) this.main.removeChild(this.main.firstChild);
    this.main.style.overflow = "hidden";
    this.main.style.position = "relative";
    this.main.style.width = this.width + "px";
    this.main.style.height = this.height + "px";
   	for (var x = 0; x < this.block.length; x++)
      this.addEntry(x);
    if (this.block.length > 1) {
      this.main.onmouseover = function() { self.mouse = true; }
      this.main.onmouseout = function() { self.mouse = false; }
      setInterval(function() {
        if (!self.offset && self.scrollLoop()) self.block[self.blockcurr].style.visibility = "visible";
      }, this.pause);
    }
    this.blockprev = (this.isRandom ? Math.floor(Math.random()*this.block.length) : 0);
    this.block[this.blockprev].style.visibility = "visible";
  }
  this.scrollLoop = function() {
    if (!this.offset) {
      if (this.mouse)
        return false;
      this.offset = (this.direct == "up" || this.direct == "down") ? this.height : this.width;
    } else {
      this.offset = Math.floor(this.offset / this.speed);
    }
    if (this.direct == "up" || this.direct == "down") {
      this.block[this.blockcurr].style.top = ((this.direct == "up") ? this.offset : -this.offset) + "px";
      this.block[this.blockprev].style.top = ((this.direct == "up") ? this.offset - this.height : this.height - this.offset) + "px";
    } else {
      this.block[this.blockcurr].style.left = ((this.direct == "left") ? this.offset : -this.offset) + "px";
      this.block[this.blockprev].style.left = ((this.direct == "left") ? this.offset - this.width : this.width - this.offset) + "px";
    }
    if (!this.offset) {
       this.block[this.blockprev].style.visibility = "hidden";
      this.blockprev = this.blockcurr;
      if (this.isRandom) {
    	this.blockcurr = Math.floor(Math.random()*this.block.length);
    	if (this.blockcurr == this.blockprev) this.blockcurr = Math.floor(Math.random()*this.block.length);
    	//alert('this.blockcurr = ' + this.blockcurr);
      } else {
        if (++this.blockcurr >= this.block.length) this.blockcurr = 0;
      }
    } else {
      setTimeout(function() { self.scrollLoop(); }, 30);
    }
    return true;
  }
  this.addEntry = function(index) {
      var table = document.createElement('table');
      table.cellPadding = table.cellSpacing = table.border = "0";
      table.style.position = "absolute";
      table.style.left = table.style.top = "0px";
      table.style.width = this.width + "px";
      table.style.height = this.height + "px";
      table.style.overflow = table.style.visibility = "hidden";
    var tbody = document.createElement('tbody');
      var tr = document.createElement('tr');
        var td = document.createElement('td');
             td.innerHTML = this.block[index];
             td.style.verticalAlign = "top";
          tr.appendChild(td);
        tbody.appendChild(tr);
      table.appendChild(tbody);
    this.main.appendChild(this.block[index] = table);
  }
}

