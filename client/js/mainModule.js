/**
 * Created by kos on 08.05.16.
 */
var module = angular.module('app', ['utilModule']);

module.controller('addCtrl', function($scope, $http) {
    $scope.groups = [{id : 1, name : 'Group1'}, {id : 2, name : 'Group2'}];
    $scope.addresses = [{value : 'Address1'}, {value: 'Address2'}];
    $scope.additionalFields = [{type : 1, value : '22.05.1991'}, {type : 2, value : 'http://google.com'}];
});