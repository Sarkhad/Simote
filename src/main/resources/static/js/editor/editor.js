'use strict'

var editor = angular.module('editor', ['ngTagsInput', "ng-showdown", 'monospaced.elastic' ] )
.controller('editorController', function( $scope, $http ) {
	

		$scope.companies = [];
	
      	$scope.loadTags = function(query) {
    	  return [ { text: 'hello' }, { text: 'world' } ];//$http.get('/tags?query=' + query);
      	};
      	
      	//TODO
      	$scope.testPost =  function() {
      		
      		var res = $http({
      		    url: "/personal/editor/create", 
      		    method: "POST",
      		    params: { json: angular.toJson( $scope.creative ) }
      		 });
    		//var res = $http.post( "/add", angular.toJson( $scope.creative ));
    		
    		res.success(function(data, status, headers, config) {
    			$scope.message = data;
    		});
    		res.error(function(data, status, headers, config) {
    			alert( "failure message: " + JSON.stringify({data: data}));
    		});
      	}
      	
      	$scope.postCreative =  function() {
      		
      		var res = $http({
      		    url: "/add", 
      		    method: "GET",
      		    params: { json: angular.toJson( $scope.creative ) }
      		 });
    		//var res = $http.post( "/add", angular.toJson( $scope.creative ));
    		
    		res.success(function(data, status, headers, config) {
    			$scope.message = data;
    		});
    		res.error(function(data, status, headers, config) {
    			alert( "failure message: " + JSON.stringify({data: data}));
    		});
      	}
      	
		$scope.chapters = [];
		
		$scope.creative = {
				chapters: $scope.chapters
		}
	
	    $scope.addChapter = function() {
			var newChapter = {
				"id": 0,
				"title": "",
				"content": ""
			};
			
			var id = getMaxChapterID();
			$scope.debug = id;
			newChapter.id = id + 1;
			
			newChapter.content = 'Enter your [Markdown][1] here.' +
		    '\n' +
		    '\n- *first*' +
		    '\n- **second**' +
		    '\n- third' +
		    '\n' +
		    '\n[1]: http://daringfireball.net/projects/markdown/syntax';
			
			
			$scope.chapters[ id ] = newChapter;
	    };
		
		function getMaxChapterID() {
			return $scope.chapters.length;
		}
		
		$scope.removeChapter = function( id ) {
			$scope.chapters.splice( id - 1, 1 );
			shiftChapterIndexes();
		}
		
		function shiftChapterIndexes() {
			var index = 1;
			$scope.chapters.forEach( function( chapter ) {
				chapter.id = index;
				index++;
			});
		}
		
	
});