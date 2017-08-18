$(document).ready(function() {
	$("#DateFrom").datepicker({
		changeYear : true,
		minDate : '-3M',
		maxDate : '+28D',
		dateFormat : 'dd-mm-yy',
		onSelect : function() {
			// - get date from another datepicker without language dependencies

			var minDate = $('#DateFrom').datepicker('getDate');
			$("#DateTo").datepicker("change", {
				minDate : minDate
			});
		}
	});

	$("#DateTo").datepicker({
		changeYear : true,
		minDate : '-3M',
		maxDate : '+28D',
		dateFormat : 'dd-mm-yy',
		onSelect : function() {
			// - get date from another datepicker without language dependencies
			var maxDate = $('#DateTo').datepicker('getDate');
			$("#DateFrom").datepicker("change", {
				maxDate : maxDate
			});
		}
	});

//	$(function() {
//		$('#DateFrom').datepicker({
//			showOnFocus : false,
//			showTrigger : '#calImg',
//			beforeShowDay : $.datepicker.noWeekends,
//			pickerClass : 'noPrevNext',
//			numberOfMonths : 1,
//			dateFormat : 'mm-dd-yy',
//			minDate : '0',
//			maxDate : '+1Y',
//			onSelect : function(dateStr) {
//				var min = $(this).datepicker('getDate');
//				$('#DateTo').datepicker('option', 'minDate', min || '0');
//				datepicked();
//			}
//		});
//		$('#DateTo').datepicker({
//			showOnFocus : false,
//			showTrigger : '#calImg',
//			beforeShowDay : $.datepicker.noWeekends,
//			pickerClass : 'noPrevNext',
//			numberOfMonths : 1,
//			dateFormat : 'mm-dd-yy',
//			minDate : '0',
//			maxDate : '+1Y',
//			onSelect : function(dateStr) {
//				var max = $(this).datepicker('getDate');
//				$('#DateFrom').datepicker('option', 'maxDate', max || '+1Y');
//				datepicked();
//			}
//		});
//		});
//	
$('#DateTo').blur(function() {
//	var datepicked = function() {
		var from = $('#DateFrom');
		var to = $('#DateTo');
		var nights = $('#nights');

		var startDate = from.datepicker('getDate')

		var endDate = to.datepicker('getDate')

		// Validate input
		if (endDate && startDate) {

			// Calculate days between dates
			var millisecondsPerDay = 86400 * 1000; // Day in milliseconds
			startDate.setHours(0, 0, 0, 1); // Start just after midnight
			endDate.setHours(23, 59, 59, 999); // End just before midnight
			var diff = endDate - startDate; // Milliseconds between datetime
											// objects
			var days = Math.ceil(diff / millisecondsPerDay);

			// Subtract two weekend days for every week in between
			var weeks = Math.floor(days / 7);
			var days = days - (weeks * 2);

			// Handle special cases
			var startDay = startDate.getDay();
			var endDay = endDate.getDay();

			// Remove weekend not previously removed.
			if (startDay - endDay > 1)
				var days = days - 2;

			// Remove start day if span starts on Sunday but ends before
			// Saturday
			if (startDay == 0 && endDay != 6)
				var days = days - 1

				// Remove end day if span ends on Saturday but starts after
				// Sunday
			if (endDay == 6 && startDay != 0)
				var days = days - 1

			nights.val(days);
		}
	});
 $('#applicationform').validate({
 rules: {
 startdate: {
 required: true
	 
 },
 enddate: {
 required: true

 },
 applicationdate: {
 required: true

 },
 reason: {
 required: true

 },
	
 approver: {
 required: true

 },
 type: {
 required: "type required"
 }
 } ,
	 
 messages: {
type: {
required:"type of leave required"},
 startdate: {
 required: "startdate required"
 },
 enddate: {
 required: "enddate required"
 },
 comment: {
 required: "Reason required"
 },
 approver1:{
 required: "Please select your Approver1"
 },
 approver2:{
	 required: "Please select your Approver1"
	 }
 }
 
});
});
