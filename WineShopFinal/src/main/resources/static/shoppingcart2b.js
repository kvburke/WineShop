/**
 * 
 */
var app = angular.module('myApp3', []);
app.controller('totalCtrl', function($scope, $http) {
	//$http.get('http://localhost:8080/displayWines?account=111')
    //.then(function(res){
	
	//$scope.names = res.data;
   // });
	
	$http.get('http://localhost:8080/total?account='+document.getElementsByName('account')[0].value)
    .then(function(res){
	
	$scope.totaltwo = res.data;
    });
	
	
});
	



function customerViewModel() {
    var self = this;

    self.customerList = ko.observableArray();

    self.getCustomers = function () {
        $.ajax({
            type: 'GET',   
            url: 'http://localhost:8080/total?account='+document.getElementsByName('account')[0].value,
            contentType: "application/javascript",
            dataType: "json",
            success: function(data) {
                var observableData = ko.mapping.fromJS(data);
                var array = observableData();
                self.customerList(array);
            },
            error:function(jq, st, error){
                alert(error);
            }
        });
    };
}

$(document).ready(function () {
    ko.applyBindings(new customerViewModel());
});