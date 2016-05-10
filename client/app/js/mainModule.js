/**
 * Created by kos on 08.05.16.
 */
var module = angular.module('app', ['utilModule']);

module.controller('addCtrl', function($scope, $http) {
    $scope.groupList = [{id : 1, name : 'Group1'}, {id : 2, name : 'Group2'}];
    $scope.addressList = [{value : 'Address1'}, {value: 'Address2'}];
    $scope.additionalFields = [{type : 1, value : '22.05.1991'}, {type : 2, value : 'http://google.com'}];
    $scope.name = 'Kostya';
    $scope.imageName = '323';

    $scope.addContact = function () {
        var contact = {
            name: $scope.name,
            imageName: $scope.imageName,
            groupList: $scope.groupList,
            addressList: $scope.addressList,
            additionalInfoList: createAdditionalInfoList($scope.additionalFields)
        };
        
        $http({
            method: 'POST',
            url: '/api/contact',
            data : contact,
        }).then(function successCallback(response) {
            // this callback will be called asynchronously
            // when the response is available
        }, function errorCallback(response) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
        });
    }
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
