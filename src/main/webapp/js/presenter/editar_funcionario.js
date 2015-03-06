angular.module("FuncionarioModuloController").controller("EditarFuncionarioPresenter", [
    "$scope",
    "$routeParams",
    "FuncionarioService",
    function($scope, $routeParams,FuncionarioService)
    {
        
        var editarFuncionario = function()
        {
        	FuncionarioService.editarFuncionario(
              
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
            $scope.command = editarFuncionario;
            $scope.id = $routeParams.funcionario_id;
            $scope.nome = "";
            $scope.sobrenome = "";
            $scope.cargo = "";
            $scope.response = "";
        };
    }
]);
