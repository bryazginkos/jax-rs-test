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

utilModule.directive('contactAddresses', function() {
    return {
        restrict: 'E',
        templateUrl: 'template/addressTemplate.html',
        replace: false,
        scope : {
            addresses : '='
        },
        link : function ($scope) {
            $scope.addAddress = function () {
                $scope.addresses.push({value: ''});
            }

            $scope.deleteAddress = function (addressId) {
                $scope.addresses.splice(addressId, 1);
            }
        }
    }
});