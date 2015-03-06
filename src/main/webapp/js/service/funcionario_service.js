angular.module("FuncionarioModuloServices").factory("FuncionarioService", [
    "$http",
    function($http)
    {
        function FuncionarioServiceObject()
        {
            var self = this;

            self.getFuncionarios = function(fn_success, fn_error)
            {
                $http({
                    method: "POST",
                    url: "rest/funcionario/lista",
                    data: {request : null },
                    cache: false,
                    responseType: "json"
                }).
                success(function(data , status , headers, config)
                {
                    if(data.erro != null)
                    {
                        fn_error(data.erro);
                    }
                    else if (data.resposta == null)
                    {
                        fn_error("NULL response.");
                    }
                    else
                    {
                        var funcionarios = [];

                        if(data.resposta != null)
                        {
                            for(var i = 0; i < data.resposta.length; ++i)
                            {
                            	funcionarios.push(new Funcionario(
                                    data.resposta[i].nome,
                                    data.resposta[i].sobrenome,
                                    data.resposta[i].cargo,
                                    data.resposta[i].id
                                    
                            	));
                            	
                            }
                        }

                        fn_success(funcionarios);
                    }
                }).
                error(function(data, status, headers, config) {
                	fn_error("AJAX ERROR:\n" + config.method + ": " + config.url + "\nstatus: " + status + "\nresponse: " + angular.toJson(data, true)); 
                	});
            };

            self.cadastraFuncionario = function(id,nome,sobrenome,cargo,fn_success, fn_error)
            {
                $http({
                    method: "POST",
                    url: "rest/funcionario/cria",
                    data: {request : {
                    					id : null ,
				                        nome : nome,
				                        sobrenome : sobrenome,
				                        cargo : cargo
				                      }
                    },
                    cache: false,
                    responseType: "json"
                }).
                success(function(data , status , headers, config)
                {
                    if(data.erro != null)
                    {
                        fn_error(data.erro);
                    }
                    else if (data.resposta == null)
                    {
                        fn_error("NULL response.");
                    }
                    else
                    {

                        fn_success(data.resposta);
                    }
                 
                }).error(function(data, status, headers, config) {
                	fn_error("AJAX ERROR:\n" + config.method + ": " + config.url + "\nstatus: " + status + "\nresponse: " + angular.toJson(data, true)); 
                  });
            };

            self.removeFuncionario = function(id,fn_success, fn_error)
            {
                $http({
                    method: "POST",
                    url: "rest/funcionario/remove",
                    data: {request : {
				                        id : id,
				                      }
                    },
                    cache: false,
                    responseType: "json"
                }).
                success(function(data , status , headers, config)
                {
                    if(data.erro != null)
                    {
                        fn_error(data.erro);
                    }
                    else if (data.resposta == null)
                    {
                        fn_error("NULL response.");
                    }
                    else
                    {

                        fn_success(data.resposta);
                    }
                 
                }).error(function(data, status, headers, config) {
                	fn_error("AJAX ERROR:\n" + config.method + ": " + config.url + "\nstatus: " + status + "\nresponse: " + angular.toJson(data, true)); 
                  });
            };
            
            self.editarFuncionario = function(id,nome,sobrenome,cargo,fn_success, fn_error)
            {
                $http({
                    method: "POST",
                    url: "rest/funcionario/edita",
                    data: {request : {
                        nome : nome,
                        sobrenome : sobrenome,
                        cargo : cargo,
                        id : id
                      }
                    },
                    
                    cache: false,
                    responseType: "json"
                }).
                success(function(data , status , headers, config)
                {
                    if(data.erro != null)
                    {
                        fn_error(data.erro);
                    }
                    else if (data.resposta == null)
                    {
                        fn_error("NULL response.");
                    }
                    else
                    {

                        fn_success(data.resposta);
                    }
                 
                }).error(function(data, status, headers, config) {
                	fn_error("AJAX ERROR:\n" + config.method + ": " + config.url + "\nstatus: " + status + "\nresponse: " + angular.toJson(data, true)); 
                  });
            };
        
        }

         return new FuncionarioServiceObject();
    }
]);