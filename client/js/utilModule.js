/**
 * Created by kos on 09.05.16.
 */
var utilModule = angular.module('utilModule', []);

utilModule.directive('contactGroups', function() {
    return {
        restrict: 'E',
        templateUrl: 'template/groupTemplate.html',
        replace: false,
        scope : {
            groups : '='
        },
        link : function ($scope) {
            $scope.addGroup = function () {
                $scope.groups.push({id : null, name : ''});
            }

            $scope.deleteGroup = function (groupId) {
                $scope.groups.splice(groupId, 1);
            }
        }
    }
});