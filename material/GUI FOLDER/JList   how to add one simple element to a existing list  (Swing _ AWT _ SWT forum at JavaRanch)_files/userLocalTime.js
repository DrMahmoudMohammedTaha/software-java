String.prototype.toLocaleDateTime = function() {

	var date = new Date(this.toString());

	var userOffsetFromGmt = getUserOffsetInHoursFromGmt();
	// date.setHours(date.getHours() - userOffsetFromGmt);
	date.setMilliseconds(date.getMilliseconds() - userOffsetFromGmt*3600000);

	printWithTodayYesterdayFormatting(date);
}

function printWithTodayYesterdayFormatting (date) {
	var localDate = date.toLocaleDateString();
	var date2 = new Date();
	var localToday = date2.toLocaleDateString();
	date2.setTime(date2.getTime() - 24*3600000);
	var localYesterday = date2.toLocaleDateString();

	if (localDate == localToday) {
		localDate = "Today";
	} else if (localDate == localYesterday) {
		localDate = "Yesterday";
	}
	var localTime = date.toLocaleTimeString().replace(/(\d\d?\:\d\d)\:00/,"$1");

	document.write(localDate + " " + localTime);
}

function getUserOffsetInHoursFromGmt() {
	var date = new Date();
	return date.getTimezoneOffset() / 60;
}

