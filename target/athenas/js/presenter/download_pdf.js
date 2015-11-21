
'use strict';

angular.module("DownloadModuloController").controller("DownloadPresenter", [
    "$scope",
    "$routeParams",
    "DownloadService",
    function($scope, $routeParams,DownloadService)
    {
        
        var download = function()
        {
        	DownloadService.downloadPdf(
              
              function(response)
              {
            	  var fileName = "test.pdf";
            	  var a = document.createElement("a");
                  document.body.appendChild(a);
                  a.style = "display: none";

        		  var file = new Blob([(response)], {type: 'application/pdf'});
        		  var fileURL = URL.createObjectURL(file);
        		  a.href = fileURL;
        		  a.download = fileName;
        		  a.click();
              },
              
              function(response) {
                  $scope.response = response;
              }
            );
        };
        //construtor
        {
        	//$scope.content;
            $scope.command = download;
            
        };

    }
]);
