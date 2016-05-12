/**
 * Created by kos on 08.05.16.
 */
var module = angular.module('app', ['utilModule', 'ngFileUpload']);

module.controller('mainCtrl', function($scope, $http) {
    $scope.contact = {};
    $scope.contact.groupList = [{id : 1, name : 'Group1'}, {id : 2, name : 'Group2'}];
    $scope.contact.addressList = [{value : 'Address1'}, {value: 'Address2'}];
    $scope.contact.additionalFields = [{type : 1, value : '22.05.1991'}, {type : 2, value : 'http://google.com'}];
    $scope.contact.name = 'Kostya';
    $scope.contact.imageName = '323';

    $scope.addContact = function () {
        var contact = {
            id : $scope.contact.id,
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
            alert('Error: status=' + response.status + ' message=' + JSON.stringify(response.data));
        });
    };

    $scope.showAll = function () {
        $http({
            method: 'GET',
            url: '/api/contacts?page=' + $scope.pageNum + '&size=' + $scope.pageSize 
        }).then(function successCallback(response) {
            alert('Ok');
            $scope.contacts = response.data;
        }, function errorCallback(response) {
            alert('Error: status=' + response.status + ' message=' + response.data);
        });
    };

    $scope.editContact = function (contact) {
        $scope.contact = {
            id : contact.id,
            name : contact.name,
            imageName : contact.imageName,
            groupList : copy(contact.groupList),
            addressList : copy(contact.addressList),
            additionalFields : createAdditionalFields(contact.additionalInfoList)
        };
    };

    $scope.resetContact = function () {
        $scope.contact = {};
    };

    $scope.deleteContact = function (id) {
        $http({
            method: 'DELETE',
            url: '/api/contact/' + id
        }).then(function successCallback(response) {
            alert('Ok');
        }, function errorCallback(response) {
            alert('Error: status=' + response.status + ' message=' + response.data);
        });
    };
});

function createAdditionalInfoList(additionalFields) {
    var additionalInfoList = [];
    if (additionalFields != undefined) {
        additionalFields.forEach(function (additionalField) {
            if (additionalField != undefined) {
                switch (additionalField.type) {
                    case 1:
                    {
                        additionalInfoList.push({dateValue: additionalField.value});
                        break;
                    }
                    case 2:
                    {
                        additionalInfoList.push({urlValue: additionalField.value});
                        break;
                    }
                    case 3:
                    {
                        additionalInfoList.push({textValue: additionalField.value});
                        break;
                    }
                    case 4:
                    {
                        additionalInfoList.push({intValue: additionalField.value});
                        break;
                    }
                    case 5:
                    {
                        additionalInfoList.push({emailValue: additionalField.value});
                        break;
                    }
                }
            }
        });
    }
    return additionalInfoList;
};

function createAdditionalFields(additionalInfoList) {
    var additionalFields = [];
    if (additionalInfoList != undefined) {
        additionalInfoList.forEach(function (additionalInfo) {
            if (additionalInfo != undefined) {
                if (additionalInfo.dateValue != undefined) {
                    additionalFields.push({type: 1, value: additionalInfo.dateValue});
                } else if (additionalInfo.urlValue != undefined) {
                    additionalFields.push({type: 2, value: additionalInfo.urlValue})
                } else if (additionalInfo.textValue != undefined) {
                    additionalFields.push({type: 3, value: additionalInfo.textValue})
                } else if (additionalInfo.intValue != undefined) {
                    additionalFields.push({type: 4, value: additionalInfo.intValue})
                } else if (additionalInfo.emailValue != undefined) {
                    additionalFields.push({type: 5, value: additionalInfo.emailValue})
                }
            }
        });
    }
    return additionalFields;
};

function copy(obj) {
    //todo something better
    return JSON.parse(JSON.stringify(obj));
}


module.controller('uploadCtrl', ['$scope', 'Upload', function ($scope, Upload) {
    // upload later on form submit or something similar
    $scope.submit = function() {
        if ($scope.form.file.$valid && $scope.file) {
            $scope.upload($scope.file);
        }
    };

    // upload on file select or drop
    $scope.upload = function (file) {
        Upload.upload({
            url: '/api/image',
            data: {file: file}
        }).then(function (resp) {
            $scope.imageName = resp.data;
        }, function (response) {
            alert('Error: status=' + response.status + ' message=' + response.data);
        }, function (evt) {
            var progressPercentage = parseInt(100.0 * evt.loaded / evt.total);
            console.log('progress: ' + progressPercentage + '% ' + evt.config.data.file.name);
        });
    };
}]);

