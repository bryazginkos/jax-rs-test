/**
 * Created by kos on 08.05.16.
 */
var module = angular.module('app', ['utilModule']);

module.controller('addCtrl', function($scope, $http) {
    $scope.groups = [{id : 1, name : 'Group1'}, {id : 2, name : 'Group2'}];
    $scope.addresses = ['Address1', 'Address2'];
    $scope.additionalFields = [{type : 1, value : '22.05.1991'}, {type : 2, value : 'http://google.com'}];
    $scope.fieldTypes = [
        {id : 1, value : 'Date'},
        {id : 2, value : 'URL'},
        {id : 3, value : 'Text'},
        {id : 4, value : 'Int'},
        {id : 5, value : 'Email'}
    ];
});