$(document)
		.ready(
				function() {
					console.log(window.location.href);
					var annualalloted, annualconsumed, annualbalance, sickalloted, sickconsumed, sickbalance;
					annualalloted = $('#annualalloted').val();
					annualconsumed = $('#annualconsumed').val();
					annualbalance = annualalloted - annualconsumed;
					$('#annualbalance').val(annualbalance);

					sickalloted = $('#sickalloted').val();
					sickconsumed = $('#sickconsumed').val();
					sickbalance = sickalloted - sickconsumed;
					$('#sickbalance').val(sickbalance);

					wfhalloted = $('#wfhalloted').val();
					wfhconsumed = $('#wfhconsumed').val();
					wfhbalance = wfhalloted - annualconsumed;
					$('#wfhbalance').val(wfhbalance);
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
					var isadmin = getParameterByName('isadmin');
					if (isadmin == "true") {
						$('#annualalloted').prop('disabled', false);
						$('#annualconsumed').prop('disabled', false);
						$('#sickalloted').prop('disabled', false);
						$('#sickconsumed').prop('disabled', false);
						$('#wfhalloted').prop('disabled', false);
						$('#wfhconsumed').prop('disabled', false);
						$('#btnLeavesMasterSubmit').prop('disabled',false);
						// $('#annualbalance').disabled=false;
					}
//					$('#annualalloted')
//				.oninput(
//									function() {
//										var annualalloted, annualconsumed, annualbalance, sickalloted, sickconsumed, sickbalance;
//										annualalloted = $('#annualalloted')
//												.val();
//										annualconsumed = $('#annualconsumed')
//												.val();
//										annualbalance = annualalloted
//												- annualconsumed;
//										$('#annualbalance').val(annualbalance);
//
//										sickalloted = $('#sickalloted').val();
//										sickconsumed = $('#sickconsumed').val();
//										sickbalance = sickalloted
//												- sickconsumed;
//										$('#sickbalance').val(sickbalance);
//
//										wfhalloted = $('#wfhalloted').val();
//										wfhconsumed = $('#wfhconsumed').val();
//										wfhbalance = wfhalloted
//												- annualconsumed;
//										$('#wfhbalance').val(wfhbalance);
//
//									});

				});