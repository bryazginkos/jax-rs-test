/**
 * Created by kos on 09.05.16.
 */
var utilModule = angular.module('utilModule', []);

utilModule.directive('contactGroup', function() {
    return {
        restrict: 'E',
        templateUrl: 'template/groupTemplate.html',
        replace: false,
        scope : {
            group : '=ngModel',
            index : '=ngIndex'
        }
    }
});