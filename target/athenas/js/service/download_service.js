angular.module("DownloadModuloServices").factory("DownloadService", [
    "$http",
    function($http)
    {
        function DownloadServiceObject()
        {
            var self = this;

            self.downloadPdf = function(fn_success, fn_error)
            {
                $http({
                    method: "GET",
                    url: "rest/download/pdf",
                    cache: false,
                    responseType:'arraybuffer'
                }).
                success(function(data , status , headers, config)
                {
                    if(data.erro != null)
                    {
                        fn_error(data.erro);
                    }
                    else if (data== null)
                    {
                        fn_error("NULL response.");
                    }
                    else
                    {

                        fn_success(data);
                    }
                 
                }).error(function(data, status, headers, config) {
                	fn_error("AJAX ERROR:\n" + config.method + ": " + config.url + "\nstatus: " + status + "\nresponse: " + angular.toJson(data, true)); 
                  });
            };
        
        }

         return new DownloadServiceObject();
    }
]);