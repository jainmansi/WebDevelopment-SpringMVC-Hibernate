var app3 = angular.module('app3', []);

// Define the Controller and implement the Scope
app3.controller('myCtrl', function($scope) {

  $scope.groceries = [
    {item: "Tomatoes", purchased: false},
    {item: "Potatoes", purchased: false},
    {item: "Bread", purchased: false},
    {item: "Hummus", purchased: false}
  ];

});
