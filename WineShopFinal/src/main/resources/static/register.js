/**
 * 
 */
var form = document.getElementById("register");
var usernameField = form.elements["usernname"];
var passwordField = form.elements["password"];



$('#create').click(function() {

	
	var usernameField = $("#username").val();
	var passwordField = $("#password").val();
	
	
	
	
	

	
	
	
	
	
	
    
	$.get("http://localhost:8080/addUser", {username: usernameField, password: passwordField});
	//$.get("http://localhost:8080/addWine", {id: "1", account: "111", url: "www.google.com", username: "kvburke", brand: "apple", name: "kevin burke", price: "1.09", quantity: "1"});
	
	
	

	
	
	
	
	
	
    return false;//suppress natural form submission
});
