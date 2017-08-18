$(document).ready(function() {
	debugger;
	$('#ApplicationTableContainer').jtable({
		title : 'Application List',
		actions : {
			listAction : 'AppController?action=list',
			createAction : 'AppController?action=create',
			updateAction : 'AppController?action=update',
			deleteAction : 'AppController?action=delete'
		},
		fields : {
			empid : {
				title : 'Type id',
			//	width : '30%',

			},
			appid : {
				title : 'App id',
				//width : '30%',

			},

			startdate : {
				title : 'Start Date',
//				width : '30%',
//				edit : true
		},
			enddate : {
				title : 'End Date',
//				width : '30%',
//				edit : true
			},
			typeid : {
				title : 'Type id',
//				width : '30%',
//				key : true,
//				list : true,
//				edit : false,
//				create : true
			},
			applicabledays : {
				title : 'Number of Days',
//				width : '30%',
//				key : true,
//				list : true,
//				edit : false,
//				create : true
			},
			leaveid : {
				title : 'Leave id',
//				width : '30%',
//				key : true,
//				list : true,
//				edit : false,
//				create : true
			},
			approver1 : {
				title : 'Apprrover 1id',
//				width : '20%',
//				edit : true

			},
			approver2 : {
				title : 'Apprrover 2id',
//				width : '20%',
//				edit : true
			},
			status : {
				title : 'Status',
//				width : '30%',
//				edit : true
			},

			comment : {
				title : 'Comment',
//				width : '30%',
//				edit : true
			},

		}
	});
	$('#ApplicationTableContainer').jtable('load');
});
