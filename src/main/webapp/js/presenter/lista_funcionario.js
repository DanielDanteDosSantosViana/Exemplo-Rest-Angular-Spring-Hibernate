angular.module("FuncionarioModuloController").controller("ListaFuncionarioPresenter", [
    "$scope",
    "$routeParams",
    "FuncionarioService",
    function($scope, $routeParams,FuncionarioService)
    {
        
        var listaFuncionarios = function()
        {
        	FuncionarioService.getFuncionarios(
              function(data)
              {
                  $scope.funcionarios = data;
              },
              function(data) {
                  $scope.response = data;
              }
            );
        };

        var removeFuncionario = function(id)
        {
        	FuncionarioService.removeFuncionario(
        	   $scope.id = id,
              
        	   function(data)
              {
                   $scope.command();
              },
              function(data) {
                  $scope.response = data;
                  $scope.command();
              }
            );
        };

        /*
        
        var editarFuncionario = function(funcionario)
        {
        	FuncionarioService.removeFuncionario(
        	   $scope.id = id,
              
        	   function(data)
              {
                   $scope.command();
              },
              function(data) {
                  $scope.response = data;
                  $scope.command();
              }
            );
        };
         
         */
        
        //construtor
        {
            $scope.command = listaFuncionarios;
            $scope.remove = removeFuncionario;
           // $scope.editar = removeFuncionario;
            $scope.funcionarios = [];
            $scope.response = "";
            $scope.command();
        };
    }
]);