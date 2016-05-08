/**
 * Created by kos on 08.05.16.
 */
var module = angular.module('app', []);

module.controller('addCtrl', function($scope, $http) {
    $scope.groups = [{id : 1, name : 'Group1'}, {id : 2, name : 'Group2'},];
    $scope.addresses = ['Address1', 'Address2']
});