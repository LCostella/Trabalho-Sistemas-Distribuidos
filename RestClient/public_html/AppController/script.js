var app = angular.module("switchableGrid", ['ngResource']);

app.factory('instagram', function($resource){
	return {
		fetchPopular: function(callback){
                    var api = $resource('https://api.instagram.com/v1/media/popular?client_id=:client_id&callback=JSON_CALLBACK',{
				client_id: '642176ece1e7445e99244cec26f4de1f'
			},{
                            fetch:{method:'JSONP'}
			});
		}
	}
});

function SwitchableGridController($scope, $http){
	$scope.layout = 'grid';
        $scope.mostraAbbasRest = [];
        $scope.mostraAbbasRest1 = {};
        $scope.mostraAbbasRest2 = '';
        $scope.mostraAbbasRest3 = '';
        $scope.mostraAbbasRest4 = '';
        $scope.items = {
                codigo: '',
                email: '',
                nome: ''
            };
        
        $scope.buscaContatoPorCidade = function (){
            $http({ url: '//localhost:18263/ServicoREST/webresources/Rest/listContatoPorCidade',
                    method: "GET",
                    headers: {'Content-type': 'application/json'},
                    params: { codigo:$scope.codigo, estado:$scope.estado, nome:$scope.nome }
            }).success(function (data) {
                console.log(data);
                $scope.items.nome = data[0].nome;
                $scope.items.codigo = data[0].codigo;
                $scope.items.email = data[0].email;
                //$scope.mostraAbbasRest.push($scope.items);
            }).error(function (data) {
            });
        };
        
        $scope.buscarContato = function (){
            $http({ url: '//localhost:18263/ServicoREST/webresources/Rest/buscarContato',
                    method: "GET",
                    headers: {'Content-type': 'application/json'},
                    params: { contact:$scope.contact }
            }).success(function (data) {
                console.log(data);
                $scope.mostraAbbasRest1 = data;
            }).error(function (data) {
            });
        };
        
        $scope.inserirContato = function (){
            $http({ url: '//localhost:18263/ServicoREST/webresources/Rest/inserirContato',
                    method: "POST",
                    headers: {'Content-type': 'application/json'},
                    params: {nome:$scope.nome, email:$scope.email, cep:$scope.cep, codigo:$scope.codigo, complemento:$scope.complemento,
                    endereco:$scope.endereco, alternaEmail:$scope.alternaEmail }
            }).success(function (data) {
                console.log(data);
                $scope.mostraAbbasRest2 = data;
            }).error(function (data) {
            });
        };
        
        $scope.alterarContato = function (){
            $http({ url: '//localhost:18263/ServicoREST/webresources/Rest/alterarContato',
                    method: "PUT",
                    headers: {'Content-type': 'application/json'},
                    params: {nome:$scope.nome, email:$scope.email, cep:$scope.cep, codigo:$scope.codigo, complemento:$scope.complemento,
                    endereco:$scope.endereco, alternaEmail:$scope.alternaEmail }
            }).success(function (data) {
                console.log(data);
                $scope.mostraAbbasRest3 = data;
            }).error(function (data) {
            });
        };
        
        $scope.excluirContato = function (){
            $http({ url: '//localhost:18263/ServicoREST/webresources/Rest/excluirContato',
                    method: "DELETE",
                    headers: {'Content-type': 'application/json'},
                    params: {codigo:$scope.codigo }
            }).success(function (data) {
                console.log(data);
                $scope.mostraAbbasRest4 = data;
            }).error(function (data) {
            });
        };
}