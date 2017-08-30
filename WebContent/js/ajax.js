//	$('#btnSubmit').click(function() {

//		var fname = $('#fname').val();
//		var mname = $('#mname').val();
//		var lname = $('#lname').val();
//		var address=$('#address').val();
//		var email = $('#email').val();
//		var mobno1 = $('#mobile1').val();
//		var mobno2 = $('#mobile2').val();
//		var enumber = $('#enumber').val();
//		var username = $('#username').val();
//		var password = $('#password').val();		
//		var designation = $('#designation').val();
//		var approver1 = $('#approver1').val();
//		var approver2 = $('#approver2').val();
//		var approver3 = $('#approver3').val();
//		var department = $('#department').val();
//		var location = $('#location').val();
//		$.ajax({
//			url : 'Logic',
//			type : 'POST',
//			data : {
//				fname : fname,
//				 mname : mname,
//				lname : lname,
//				address: address,
//				 email : email,
//				mobno1 : mobile1,
//				mobno2 : mobile2,
//				 enumber : enumber,
//				username : username,
//				password : password,
//				designation:designation,
//				approver1:approver1,
//				approver2:approver2,
//				approver3:approver3,
//				department:department,
//				location:location
//			},
//			success : function(data) {
//				
//					alert("location sucessfully added");
//				
//			},
//			error : function(data) {
//				error(data);
//			}
//		});
//
//	});

$(document)
		.ready(
				function() {
					function getParameterByName(name, url) {
						if (!url)
							url = window.location.href;
						name = name.replace(/[\[\]]/g, "\\$&");
						var regex = new RegExp("[?&]" + name
								+ "(=([^&#]*)|&|#|$)"), results = regex
								.exec(url);
						if (!results)
							return null;
						if (!results[2])
							return '';
						return decodeURIComponent(results[2]
								.replace(/\+/g, " "));

					}
					var empsearch = getParameterByName('search');
					
					
					
					
//					var action = getParameterByName('locationid');
					
//					$.ajax({
//						url : 'Logic',
//						data : {
//						},
//						success : function(data) {
//						},
//						error : function(data) {
//							error(data);
//						}
//					});

					$('#btnSubmitlocation').click(function() {

						var locationname = $('#locationname').val();
						var locationaddress = $('#locationaddress').val();
						// if(action!=null){
						// $.ajax({
						// url : 'LocationLogic&locationid='+action,
						// type : 'POST',
						// data : {
						// locationname:locationname,
						// locationaddress:locationaddress,
						// action:action
						// },
						// success : function(data) {
						// },
						// error : function(data) {
						// error(data);
						// }
						// });
						// }
						// else{
						$.ajax({
							url : 'LocationLogic',
							type : 'POST',
							data : {
								locationname : locationname,
								locationaddress : locationaddress

							},
							success : function(data) {
							},
							error : function(data) {
								error(data);
							}
						});

					});
					
					$('#btnSubmitleave').click(function() {
						var leavetype = $('#leavetype').val();
						var allocateddays = $('#allocateddays').val();

						$.ajax({
							url : 'LeaveLogic',
							type : 'POST',
							data : {
								leavetype : leavetype,
								allocateddays : allocateddays

							},
							success : function(data) {
								if (data == "success") {
									
								}
							},
							error : function(data) {
								error(data);
							}
						});

					});
					$('#btnLogin').click(function() {
						
						var leavetype = $('#leavetype').val();
						var allocateddays = $('#allocateddays').val();

						$.ajax({
							url : 'LeaveLogic',
							type : 'POST',
							data : {
								leavetype : leavetype,
								allocateddays : allocateddays

							},
							success : function(data) {
								if (data == "success") {
									
								}
							},
							error : function(data) {
								error(data);
							}
						});

					});
//					$('#btnSearch').click(function() {
//						var empsearch = $('#empsearch').val();
////						$('#listemp td td:not(:contains('+ empsearch +'))').each(function(){ 
//						$("#listemp tr td:not(:contains('" + empsearch  + "'))")
//						.each(function() {
//						    if ($(this).text() == empsearch) {
//						        $(this).parent().hide();
//						    }  
//						});
//						
////						$.ajax({
////							url : 'FilterEmp?action=search&column='+empsearch,
////							type : 'GET',
////							data : {
////								empsearch:empsearch
////							},
////							success : function(data) {
////								
////							},
////							error : function(data) {
////								error(data);
////							}
////						});
//
//					});
					$('#btnLeavesMasterSubmit').click(function() {
						var annualalloted = $('#annualalloted').val();
						var annualconsumed = $('#annualconsumed').val();
						var sickalloted = $('#sickalloted').val();
						var sickconsumed = $('#sickconsumed').val();
						var wfhalloted = $('#wfhalloted').val();
						var wfhconsumed = $('#wfhconsumed').val();

						$.ajax({
							url : 'LeavesMasterLogic',
							type : 'POST',
							data : {
								annualalloted : annualalloted,
								annualconsumed : annualconsumed,
								sickalloted : sickalloted,
								sickconsumed : sickconsumed,
								wfhalloted : wfhalloted,
								wfhconsumed : wfhconsumed
							},
							success : function(data) {
								if (data == "success") {
									location.href = "index.jsp"
								}
							},
							error : function(data) {

							}
						});

					});
					$('#RolesSubmit').click(function() {
						var empid = $('#empid').val();
						var isadmin = $('#isadmin').val();
						var isapprover = $('#isapprover').val();
						$.ajax({
							url : 'RolesLogic',
							type : 'POST',
							data : {
								empid : empid,
								isadmin : isadmin,
								isapprover : isapprover

							},
							success : function(data) {
								
							},
							error : function(data) {

							}
						});

					});
				

				});
