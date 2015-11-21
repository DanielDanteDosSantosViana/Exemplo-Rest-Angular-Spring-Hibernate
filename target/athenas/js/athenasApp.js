
angular.module("FuncionarioModuloServices", []);
angular.module("FuncionarioModuloController", []);
angular.module("DownloadModuloController", []);
angular.module("DownloadModuloServices", []);

/* APP */
var app = angular.module("athenasApp", [
"ngRoute",
"FuncionarioModuloController",
"FuncionarioModuloServices",
"DownloadModuloController",
"DownloadModuloServices"
]);

app.config(function($routeProvider){
	
	$routeProvider.when('/funcionario/cadastro',
			{
				templateUrl:'partials/cadastro.tpl.html',
				
			});

	$routeProvider.when('/funcionario/listar',
			{
				templateUrl:'partials/lista.tpl.html',
			});

	$routeProvider.when('/funcionario/editar/:funcionario_id',
			{
				templateUrl:'partials/editar.tpl.html',
			});
	
	$routeProvider.when('/funcionario/remove/:id_funcionario',
			{
				templateUrl:'partials/lista.tpl.html',
			});
	
	$routeProvider.when('/download/pdf',
			{
				templateUrl:'partials/download.tpl.html',
			});


	
	$routeProvider.otherwise({redirectTo:'/funcionario/listar'});
	
});