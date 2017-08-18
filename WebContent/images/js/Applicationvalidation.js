 $(document).ready(function() {
	 $(function() {
		    $(".datepicker" ).datepicker();
		  } ),
 
 $("#apply").validate({
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
        startdate: {
            required: "startdate required"
         },
         enddate: {
             required: "enddate required"
          },
         applicationdate: {
             required: "application Date required"
          },
         reason: {
             required: "Reason required"
          },
          approver:{
               required: "Username required"
            },
          type: {
              required: "type pf leave required"
           }
	 }
  });
  });
