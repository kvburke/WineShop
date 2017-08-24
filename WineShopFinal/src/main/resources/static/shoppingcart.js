/**
 * 
 */



var form = document.getElementById("shoppingcart");
var username = form.elements["uname"];
var password = form.elements["pword"];

var idxField = form.elements["idx"];
var brandField = form.elements["brand"];
var idField = form.elements["id"];
var accountField = form.elements["account"];
var usernameField = form.elements["username"];
var nameField = form.elements["name"];
var priceField = form.elements["price"];
var quantityField = form.elements["quantity"];
var urlField = form.elements["url"];
var checkedField = form.elements["checked"];

var app = angular.module('myApp', []);
app.controller('customersCtrl', function($scope, $http, $interval) {
	
	$scope.selectInfo2=function(yidx, yid, yurl, ybrand, yname, yprice, yquantity){
		$('#idx').val(yidx);
		$('#id').val(yid);
		$('#name').val(yname);
		$('#brand').val(ybrand);
		$('#quantity').val(yquantity);
		$('#price').val(yprice);
		$('#url').val(yurl);
	}
	
	
	
	$http.get('http://localhost:8080/displayWines?account='+document.getElementsByName('account')[0].value)
   .then(function(res){
	
	$scope.names = res.data;
    });

	$interval(function () {
	
	$http.get('http://localhost:8080/displayWines?account='+document.getElementsByName('account')[0].value)
    .then(function(res){
	
	$scope.namestwo = res.data;
    });
	
	}, 5000);
});


app.controller('customerstwoCtrl', function($scope, $http, $) {
	
	$scope.selectInfo2=function(yidx2, yid, yurl, ybrand, yname, yprice, yquantity){
		$('#idx').val(yidx);
		$('#id').val(yid);
		$('#name').val(yname);
		$('#brand').val(ybrand);
		$('#quantity').val(yquantity);
		$('#price').val(yprice);
		$('#url').val(yurl);
	}
	
	
	
	$http.get('http://localhost:8080/displayPurchased?account='+document.getElementsByName('account')[0].value)
   .then(function(restwo){
	
	$scope.names = restwo.data;
    });
});


$('#load').click(function() {
	
	
	
		
	
	
	
  //  $.ajax({
  //      type: 'GET',
  //     url: '/displaywines/'+accountField,
   //     data: $('#inventoryDetails').serialize(),
    //    dataType:"json", //to parse string into JSON object,
      //  success: function(data){ 
        //    if(data){
          //      var len = data.length;
            //    var txt = "";
              //  if(len > 0){
                //    for(var i=0;i<len;i++){
                  //      if(data[i].brand && data[i].id && data[i].name && data[i].price && data[i].quantity && data[i].url && data[i].checked){
                    //        txt += "<tr><td>"+data[i].brand+"</td><td>"+data[i].id+"</td><td>"+data[i].name+"</td><td>"+data[i].quantity+"</td><td>"+data[i].url+"</td><td>"+data[i].checked+"</td></tr>";
                      //      console.log("your message here");
                       // }
        //            }
          //          if(txt != ""){
          //              $("#inventorytable").append(txt).removeClass("hidden");
          //          }
        //        }
      //      }
     //   },
     //   error: function(jqXHR, textStatus, errorThrown){
     //       alert('error: ' + textStatus + ': ' + errorThrown);
    //    }
   // });
    return false;//suppress natural form submission
});



$('#add').click(function() {

	var brandField = $("#brand").val();
	var idField = $("#id").val();
	var accountField = $("#account").val();
	var usernameField = $("#username").val();
	var nameField = $("#name").val();
	var priceField = $("#price").val();
	var quantityField = $("#quantity").val();
	var urlField = $("#url").val();
	
	
	
	console.log("add");

	
	
	
	
	
	
    
	$.get("http://localhost:8080/addWine", {id: idField, account: accountField, url: urlField, username: usernameField, brand: brandField, name: nameField, price: priceField, quantity: quantityField});
	//$.get("http://localhost:8080/addWine", {id: "1", account: "111", url: "www.google.com", username: "kvburke", brand: "apple", name: "kevin burke", price: "1.09", quantity: "1"});
	
	
	

	
	
	
	
	
	
    return false;//suppress natural form submission
});




$('#addWineInventory').click(function() {

	var brandField = $("#brand").val();
	var idField = $("#id").val();
	var accountField = $("#account").val();
	var usernameField = $("#username").val();
	var nameField = $("#name").val();
	var priceField = $("#price").val();
	var quantityField = $("#quantity").val();
	var urlField = $("#url").val();
	
	
	
	

	
	
	
	
	
	
    
	$.get("http://localhost:8080/addWineInventory", {id: idField, account: accountField, url: urlField, username: usernameField, brand: brandField, name: nameField, price: priceField, quantity: quantityField});
	//$.get("http://localhost:8080/addWine", {id: "1", account: "111", url: "www.google.com", username: "kvburke", brand: "apple", name: "kevin burke", price: "1.09", quantity: "1"});
	
	
	

	
	
	
	
	
	
    return false;//suppress natural form submission
});











$('#remove').click(function() {
	var idxField = $("#idx").val();
	var brandField = $("#brand").val();
	var idField = $("#id").val();
	var accountField = $("#account").val();
	var usernameField = $("#username").val();
	var nameField = $("#name").val();
	var priceField = $("#price").val();
	var quantityField = $("#quantity").val();
	var urlField = $("#url").val();
	
	
	
    
	$.get("http://localhost:8080/removeWine", {idx: idxField, id: idField, account: accountField, url: urlField, username: usernameField, brand: brandField, name: nameField, price: priceField, quantity: quantityField});
	//$.get("http://localhost:8080/addWine", {id: "1", account: "111", url: "www.google.com", username: "kvburke", brand: "apple", name: "kevin burke", price: "1.09", quantity: "1"});
	
	
	
	

	
	
	
	
	
    return false;//suppress natural form submission
});




$('#removeWineInventory').click(function() {

	var brandField = $("#brand").val();
	var idField = $("#id").val();
	var accountField = $("#account").val();
	var usernameField = $("#username").val();
	var nameField = $("#name").val();
	var priceField = $("#price").val();
	var quantityField = $("#quantity").val();
	var urlField = $("#url").val();
	
	
	
    
	$.get("http://localhost:8080/removeWineInventory", {id: idField, account: accountField, url: urlField, username: usernameField, brand: brandField, name: nameField, price: priceField, quantity: quantityField});
	//$.get("http://localhost:8080/addWine", {id: "1", account: "111", url: "www.google.com", username: "kvburke", brand: "apple", name: "kevin burke", price: "1.09", quantity: "1"});
	
	
	
	

	
	
	
	
	
    return false;//suppress natural form submission
});






$('#total').click(function() {
	var getJSON = function(url) {
		  return new Promise(function(resolve, reject) {
		    var xhr = new XMLHttpRequest();
		    xhr.open('get', url, true);
		    xhr.responseType = 'json';
		    xhr.onload = function() {
		      var status = xhr.status;
		      if (status == 200) {
		        resolve(xhr.response);
		      } else {
		        reject(status);
		      }
		    };
		    xhr.send();
		  });
		};

		getJSON('http://localhost:8080/total?account='+accountField).then(function(data) {
		    alert('Your Json result is:  ' + data.result); //you can comment this, i used it to debug

		    result.innerText = data.result; //display the result in an HTML element
		}, function(status) { //error detection....
		  alert('Something went wrong.');
		});

});




