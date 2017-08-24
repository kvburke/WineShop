/**
 * 
 */


$(document).ready(function () {

        $("#buy").click(
            function () {
                AlertSave();
            }            
        );
    });

function AlertSave() {
	$.getJSON('http://localhost:8080/total?account='+document.getElementsByName('account')[0].value, function(data) {
		alert(data[0].total);
		$(location).attr('href', 'http://stackoverflow.com/'+data[0].total);
		
});
	
	
	$.getJSON('http://localhost:8080/403?account='+document.getElementsByName('account')[0].value, function(data) {
		alert(data[0].total);
		$(location).attr('href', 'http://stackoverflow.com/'+data[0].total);
		
});
	
	
}







