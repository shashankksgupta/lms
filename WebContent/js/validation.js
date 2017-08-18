$(document).ready(function() {

	$('#regform').validate({
		rules : {
			fname : {
				required : true,
				lettersonly : true
			},
			mname : {
				required : true,
				lettersonly : true
			},
			lname : {
				required : true,
				lettersonly : true
			},
			address : {
				required : true,
			},
			email : {
				required : true,
				email : true
			},
			mobile1 : {
				required : true,
				numbers : true,
			},
			enumber : {
				required : true,
			},
			mobile2 : {
				required : true,
				numbers : true,
			},
			username : {
				required : true
			},
			password : {
				required : true
			},
			designation : {
				required : true
			},
			designation : {
				required : true
			},
			department : {
				required : true
			},
			location : {
				required : true
			},
			locationname : {
				required : true
			},
			locationaddress : {
				required : true
			},
			leavetype : {
				required : true
			},
			allocateddays : {
				required : true,
				numbers : true
			},
			locationaddress : {
				required : true
			},
			annualalloted : {
				required : true
			},
			annualconsumed : {
				required : true
			},
			annualbalance : {
				required : true
			},
			sickalloted : {
				required : true
			},
			sickconsumed : {
				required : true
			},
			sickbalance : {
				required : true
			},
			wfhalloted : {
				required : true
			},
			wfhconsumed : {
				required : true
			},
			wfhbalance : {
				required : true
			}
		}
	});

});