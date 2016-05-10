/**
 * Created by kos on 08.05.16.
 */
var module = angular.module('app', ['utilModule']);

module.controller('mainCtrl', function($scope, $http) {
    $scope.contact = {};
    $scope.contact.groupList = [{id : 1, name : 'Group1'}, {id : 2, name : 'Group2'}];
    $scope.contact.addressList = [{value : 'Address1'}, {value: 'Address2'}];
    $scope.contact.additionalFields = [{type : 1, value : '22.05.1991'}, {type : 2, value : 'http://google.com'}];
    $scope.contact.name = 'Kostya';
    $scope.contact.imageName = '323';

    $scope.addContact = function () {
        var contact = {
            name: $scope.contact.name,
            imageName: $scope.contact.imageName,
            groupList: $scope.contact.groupList,
            addressList: $scope.contact.addressList,
            additionalInfoList: createAdditionalInfoList($scope.contact.additionalFields)
        };

        $http({
            method: 'POST',
            url: '/api/contact',
            data : contact,
        }).then(function successCallback(response) {
            alert('Ok');
        }, function errorCallback(response) {
            alert('Error');
        });
    };

    $scope.showAll = function () {
        $http({
            method: 'GET',
            url: '/api/contacts'
        }).then(function successCallback(response) {
            alert('Ok');
            $scope.contacts = response.data;
        }, function errorCallback(response) {
            alert('Error');
        });
    };

    $scope.editContact = function (contact) {
        $scope.contact = contact; //todo additional info structure
    };

    $scope.resetContact = function () {
        $scope.contract = {};
    };

    $scope.deleteContact = function (id) {
        $http({
            method: 'DELETE',
            url: '/api/contact/' + id
        }).then(function successCallback(response) {
            alert('Ok');
        }, function errorCallback(response) {
            alert('Error');
        });
    };
});

function createAdditionalInfoList(additionalFields) {
    var additionalInfoList = [];
    additionalFields.forEach(function (additionalField) {
        if (additionalField != null) {
            switch (additionalField.type) {
                case 1: {
                    additionalInfoList.push({dateValue : additionalField.value});
                    break;
                }
                case 2: {
                    additionalInfoList.push({urlValue : additionalField.value});
                    break;
                }
                case 3: {
                    additionalInfoList.push({textValue : additionalField.value});
                    break;
                }
                case 4: {
                    additionalInfoList.push({intValue : additionalField.value});
                    break;
                }
                case 5: {
                    additionalInfoList.push({emailValue : additionalField.value});
                    break;
                }
            }
        }
    });
    return additionalInfoList;
};

