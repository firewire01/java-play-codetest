/*!
 * Demo App
 *
 * @author jaycverg <jaycverg@gmail.com>
 */
(function() {

    'use strict';

    angular.module('customerApp', [])
           .controller('BaseController', ['$scope', '$http', BaseController]);
    

    function BaseController($scope, $http)
    {
        $scope.send = function() {
            
            $scope.isProcessing = true;
            $scope.sortedCustomers = [];

            $http.post('/customers', $scope.jsonText).then(onSuccess, onFail);
        };

        function onSuccess(resp) {
            $scope.isProcessing = false;
            $scope.sortedCustomers = resp.data;
        }

        function onFail(resp) {
            $scope.isProcessing = false;
            alert('Process failure...');
        }
    }


})();

