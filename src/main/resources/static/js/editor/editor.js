'use strict'

var editor = angular.module('editor', [])
.controller('chapterController', ['$scope', function($scope) {

		$scope.chapters = [];
	
	    $scope.addChapter = function() {
			var newChapter = {
				"id": 0,
				"title": "Lorem ipsum dol sit amet",
				"content": "Lorem ipsum dol sit amet"
			};
			
			var id = getMaxChapterID();
			$scope.debug = id;
			newChapter.id = id + 1;
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
		
	
}]);