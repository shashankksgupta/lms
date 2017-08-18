$(document).ready(function() {
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
		$('#btnSearch').click(function(){
			var empsearch=$('#empsearch').val();
			
			$.ajax({
				url : 'FilterEmp?search=true',
				type : 'GET',
				data : {
					
			empsearch:empsearch,
			
				},
				success : function(data) {
					
				},
				error : function(data) {
					error(data);
				}
			});
			
		});
		
		
});