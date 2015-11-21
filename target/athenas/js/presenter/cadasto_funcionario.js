angular.module("FuncionarioModuloController").controller("CadastroFuncionarioPresenter", [
    "$scope",
    "$routeParams",
    "FuncionarioService",
    function($scope, $routeParams,FuncionarioService)
    {
        
        var cadastraFuncionario = function()
        {
        	FuncionarioService.cadastraFuncionario(
              
        	  $scope.id,
        	  $scope.nome,
              $scope.sobrenome,
              $scope.cargo,

              function(data)
              {
        		  alert(data);
                  $scope.response = data;
              },
              
              function(data) {
                  $scope.response = data;
              }
            );
        };
        //construtor
        {
            $scope.command = cadastraFuncionario;
            $scope.nome = "";
            $scope.sobrenome = "";
            $scope.cargo = "";
            $scope.id = "";
            $scope.response = "";
          
        };
    }
]);
