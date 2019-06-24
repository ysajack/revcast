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

/*************Filtering PROJECT PAGE**************/
//BIOs dropdown list
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
		
		//Nested call - Results list will auto populate for all projects under a bio
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

//Cascading/filtering dropdown projects list
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
/***************************/



/*****************Filtering RESOURCE PAGE*****************/
//BIOs dropdown list
$(document).ready(function() {
	$("#bybio-res").change(function() {
		var bioval = $("#bybio-res").val();
		$.get("projectDropdown", {
			bio : bioval
		}, function(res) {
			var data = $.parseJSON(res); //parse json
			// $("#test").text(data); //to display text
			var select = $('#byproject-res');
			select.find('option').remove(); //Remove the list and then re-updated
			var allProjects = "All Projects";
			$('<option>').val(allProjects).text(allProjects).appendTo(select); //all projects place holder
			$.each(data, function(index, value) {
				$('<option>').val(value.projectId).text(value.projectName).appendTo(select); //storing project id in value, storing project name in text in <option>
			});
		});
		
		//Nested call - Results list will auto populate for all projects under a bio
		var prjId = $("#byproject-res").val();
		var bioval = $("#bybio-res").val();
		$.get("resourceFilter", {
			projectId : prjId,
			bio : bioval
		}, function(res) {
			//to display in inner html
			document.getElementById("fill-table").innerHTML = res; //Will overwrite and fill the table by the filter		
		});
		
	});
});

//Cascading/filtering dropdown projects list
$(document).ready(function() {
	$("#byproject-res").change(function() {
		var prjId = $("#byproject-res").val();
		var bioval = $("#bybio-res").val();
		$.get("resourceFilter", {
			projectId : prjId,
			bio : bioval
		}, function(res) {
			//to display in inner html
			document.getElementById("fill-table").innerHTML = res; //Will overwrite and fill the table by the filter		
		});
	});
});

/********************/

/*************Filtering on ADMIN ALLOCATE ASSOCIATES PAGE**************/
//BIOs dropdown list
$(document).ready(function() {
	$("#bybio-admin").change(function() {
		var bioval = $("#bybio-admin").val();
		$.get("projectDropdown", {
			bio : bioval
		}, function(res) {
			var data = $.parseJSON(res); //parse json
			// $("#test").text(data); //to display text
			var select = $('#byproject-admin');
			select.find('option').remove(); //Remove the list and then re-updated
			var allProjects = "All Projects";
			$('<option>').val(allProjects).text(allProjects).appendTo(select); //all projects place holder
			$.each(data, function(index, value) {
				$('<option>').val(value.projectId).text(value.projectName).appendTo(select); //storing project id in value, storing project name in text in <option>
			});
		});
		
		//Nested call - Results list will auto populate for all projects under a bio
		var prjId = $("#byproject-admin").val();
		var bioval = $("#bybio-admin").val();
		var assoId = $("input[name=associateId]").val();
		var assoName = $("input[name=associateName]").val();
		$.get("projectFilter", {
			projectId : prjId,
			bio : bioval,
			associateId : assoId,
			associateName : assoName
		}, function(res) {
			//to display in inner html
			document.getElementById("allocateAssociate").innerHTML = res; //Will overwrite and fill the table by the filter		
		});
		
	});
});

//Cascading/filtering dropdown projects list
$(document).ready(function() {
	$("#byproject-admin").change(function() {
		var prjId = $("#byproject-admin").val();
		var bioval = $("#bybio-admin").val();
		var assoId = $("input[name=associateId]").val();
		var assoName = $("input[name=associateName]").val();
		$.get("projectFilter", {
			projectId : prjId,
			bio : bioval,
			associateId : assoId,
			associateName : assoName
		}, function(res) {
			//to display in inner html
			document.getElementById("allocateAssociate").innerHTML = res; //Will overwrite and fill the table by the filter		
		});
	});
});
/***************************/

$(document).ready(function() {

});
