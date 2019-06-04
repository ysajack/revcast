function checkNumOfDays(val) {
	//document.getElementById("demo").innerHTML = "You selected: " + val;
	var d2 = document.getElementById("date2");
	var d3 = document.getElementById("date3");
	
	if(val == 2 || val == 3){
		d2.type = "date";
	}
	else {
		d2.type = "hidden";
	}
	
	if(val == 3){
		d3.type = "date";
	}
	else {
		d3.type = "hidden";
	}						
}

function checkEdit() {
	//document.getElementById("demo").innerHTML = "You selected: " + val;
	var details = document.getElementById("leave-details");
	var edit = document.getElementById("edit_leave");
	
	if(val == 2 || val == 3){
		d2.type = "date";
	}
	else {
		d2.type = "hidden";
	}
	
	if(val == 3){
		d3.type = "date";
	}
	else {
		d3.type = "hidden";
	}						
}

/*	Below just adding but not re-updating
 * $.each(data, function(index, value) {
		// alert( index + ": " + value );
		var x = document.getElementById("bybio");
		var option = document.createElement("option");
		option.text = value;
		option.name = value;
		x.add(option);
}); */


//For Listing/cascading projects in dropdown by BIO - PROJECT PAGE
$(document).ready(function() {
	$("#bio").change(function() {
		var bioval = $("#bio").val();
		$.get("projectDropdown", {
			bio : bioval
		}, function(res) {
			var data = $.parseJSON(res); //parse json
			// $("#test").text(data); //to display text
			var select = $('#project');
			select.find('option').remove(); //Remove the list and then re-updated
			var allProjects = "All Projects";
			$('<option>').val(allProjects).text(allProjects).appendTo(select); //all projects place holder
			$.each(data, function(index, value) {
				$('<option>').val(value.projectId).text(value.projectName).appendTo(select); //storing project id in value, storing project name in text in <option>
			});
		});
	});
});

//For Filtering on PROJECT PAGE - by Project
$(document).ready(function() {
	$("#project").change(function() {
		var prjId = $("#project").val();
		var bioval = $("#bio").val();
		$.get("resourceFilter", {
			projectId : prjId,
			bio : bioval
		}, function(res) {
			//to display in inner html
			document.getElementById("fill-table").innerHTML = res; //Will overwrite and fill the table by the filter		
		});
	});
});






//For Listing/cascading projects in dropdown by BIO - PROJECT PAGE
$(document).ready(function() {
	$("#bybio").change(function() {
		var bioval = $("#bybio").val();
		$.get("projectDropdown", {
			bio : bioval
		}, function(res) {
			var data = $.parseJSON(res); //parse json
			// $("#test").text(data); //to display text
			var select = $('#byproject');
			select.find('option').remove(); //Remove the list and then re-updated
			var allProjects = "All Projects";
			$('<option>').val(allProjects).text(allProjects).appendTo(select); //all projects place holder
			$.each(data, function(index, value) {
				$('<option>').val(value.projectId).text(value.projectName).appendTo(select); //storing project id in value, storing project name in text in <option>
			});
		});
	});
});

//For Filtering on PROJECT PAGE - by Project
$(document).ready(function() {
	$("#byproject").change(function() {
		var prjId = $("#byproject").val();
		var bioval = $("#bybio").val();
		$.get("projectFilter", {
			projectId : prjId,
			bio : bioval
		}, function(res) {
			//to display in inner html
			document.getElementById("fill-table").innerHTML = res; //Will overwrite and fill the table by the filter		
		});
	});
});




