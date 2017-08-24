var app = angular.module('myApp2', []);
app.controller('customersCtrl', function($scope, $http, $interval) {
	//$http.get('http://localhost:8080/displayWines?account=111')
    //.then(function(res){
	
	//$scope.names = res.data;
   // });
	
	
	
	$scope.selectInfo2=function(yidx, yid, yurl, ybrand, yname, yprice, yquantity){
		$('#idx').val(yidx);
		$('#id').val(yid);
		$('#name').val(yname);
		$('#brand').val(ybrand);
		$('#quantity').val(yquantity);
		$('#price').val(yprice);
		$('#url').val(yurl);
	}
	
	
	
	
	
	
	
	
	$(document).ready(function() {
		setTimeout(
				  function() 
				  {
				    //do something special
				
		
		
	
	$http.get('http://localhost:8080/displayPurchased?account='+document.getElementsByName('account')[0].value)
  .then(function(res){
	
	$scope.namestwo = res.data;
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
	

	
	
	
	
