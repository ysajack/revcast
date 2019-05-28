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

function lookDetails(str) {
	  var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (xhttp.readyState == 4 && xhttp.status == 200) {
	      document.getElementById("statdetails").innerHTML = xhttp.responseText;
	 
	    }
	  }
	  xhttp.open("GET", "orderdetails.php?ordernum="+str, true);
	  xhttp.send();
}

$(document).ready(function(){
    $("#").click(function(){
       // $("#edit_leave").slideDown("slow");
    	$("#").show();
        $("#").hide();
    });

});