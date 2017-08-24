var app = angular.module('myApp4', []);
app.controller('customersCtrl', function($scope, $http, $interval) {
	//$http.get('http://localhost:8080/displayWines?account=111')
    //.then(function(res){
	
	//$scope.names = res.data;
   // });
	
	
	
	
	
	$scope.selectInfo=function(yid, yname, ysum, ybrand, yprice, yurl){
		$('#id').val(yid);
		$('#name').val(yname);
		$('#quantity').val(ysum);
		$('#brand').val(ybrand);
		$('#price').val(yprice);
		$('#url').val(yurl);
		
		}

	
	
	
	$(document).ready(function() {
		setTimeout(
				  function() 
				  {
				    //do something special
				
		
		
	
	$http.get('http://localhost:8080/displayInventory')
  .then(function(res){
	
	$scope.namesthree = res.data;
	
  });
	
	
	
				  }, 5000);
	});
	
	
	
	
	$('#add').click(function(){
	
		setTimeout(
				  function() 
				  {
				    //do something special
				
		
		
	
	$http.get('http://localhost:8080/displayPurchased?account='+document.getElementsByName('account')[0].value)
    .then(function(res){
	
	$scope.namestwo = res.data;
    });
	
	
	
				  }, 5000);
	
	})
	
	
	$('#addWineInventory').click(function(){
	
		setTimeout(
				  function() 
				  {
				    //do something special
				
		
		
	
	$http.get('http://localhost:8080/displayWine?account='+document.getElementsByName('account')[0].value)
    .then(function(res){
	
	$scope.namestwo = res.data;
    });
	
	
	
				  }, 5000);
	
	})
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		$('#remove').click(function(){
			setTimeout(
					  function() 
					  {
	
	$http.get('http://localhost:8080/displayPurchased?account='+document.getElementsByName('account')[0].value)
    .then(function(res){
	
	$scope.namestwo = res.data;
    });
	
					  }, 5000);
	
	
	})
	
	
	
	

	
	
	
	
	
		$('#removeWineInventory').click(function(){
			setTimeout(
					  function() 
					  {
	
	$http.get('http://localhost:8080/displayWine?account='+document.getElementsByName('account')[0].value)
    .then(function(res){
	
	$scope.namestwo = res.data;
    });
	
					  }, 5000);
	
	
	})
	

	
		
	
	
	
	
});
	

	
	
	
	
