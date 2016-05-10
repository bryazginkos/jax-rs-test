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
            };

            $scope.deleteGroup = function (groupId) {
                $scope.groups.splice(groupId, 1);
            };
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
            };

            $scope.deleteAddress = function (addressId) {
                $scope.addresses.splice(addressId, 1);
            };
        }
    }
});

utilModule.directive('contactAdditionalFields', function() {
    return {
        restrict: 'E',
        templateUrl: 'template/additionalFieldTemplate.html',
        replace: false,
        scope : {
            additionalFields : '='
        },
        link : function ($scope) {
            $scope.addAdditionalField = function () {
                $scope.additionalFields.push({type : 3, value : ''});
            };

            $scope.deleteAdditionalField = function (additionalFieldIndex) {
                $scope.additionalFields.splice(additionalFieldIndex, 1);
            };

            $scope.fieldTypes = [
                {id : 1, value : 'Date'},
                {id : 2, value : 'URL'},
                {id : 3, value : 'Text'},
                {id : 4, value : 'Int'},
                {id : 5, value : 'Email'}
            ];
        }
    }
});

utilModule.directive('contacts', function() {
    return {
        restrict: 'E',
        templateUrl: 'template/contactTemplate.html',
        replace: false,
        scope : {
            contacts : '='
        }
    }
});