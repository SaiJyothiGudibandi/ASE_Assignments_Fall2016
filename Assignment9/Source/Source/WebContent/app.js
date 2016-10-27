'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [])


    .controller('View1Ctrl', function ($scope, $http) {
        $scope.getToneAnalysis = function () {
        	var abc={"document_tone":{"tone_categories":[{"tones":[{"score":0.105542,"tone_id":"anger","tone_name":"Anger"},{"score":0.134394,"tone_id":"disgust","tone_name":"Disgust"},{"score":0.150116,"tone_id":"fear","tone_name":"Fear"},{"score":0.083824,"tone_id":"joy","tone_name":"Joy"},{"score":0.605555,"tone_id":"sadness","tone_name":"Sadness"}],"category_id":"emotion_tone","category_name":"Emotion Tone"},{"tones":[{"score":0.0,"tone_id":"analytical","tone_name":"Analytical"},{"score":0.0,"tone_id":"confident","tone_name":"Confident"},{"score":0.75152,"tone_id":"tentative","tone_name":"Tentative"}],"category_id":"language_tone","category_name":"Language Tone"},{"tones":[{"score":0.912326,"tone_id":"openness_big5","tone_name":"Openness"},{"score":0.1406,"tone_id":"conscientiousness_big5","tone_name":"Conscientiousness"},{"score":0.471871,"tone_id":"extraversion_big5","tone_name":"Extraversion"},{"score":0.567799,"tone_id":"agreeableness_big5","tone_name":"Agreeableness"},{"score":0.386687,"tone_id":"emotional_range_big5","tone_name":"Emotional Range"}],"category_id":"social_tone","category_name":"Social Tone"}]},"sentences_tone":[{"sentence_id":0,"text":"A word is dead when it is said, some say.","input_from":0,"input_to":41,"tone_categories":[{"tones":[{"score":0.105542,"tone_id":"anger","tone_name":"Anger"},{"score":0.134394,"tone_id":"disgust","tone_name":"Disgust"},{"score":0.150116,"tone_id":"fear","tone_name":"Fear"},{"score":0.083824,"tone_id":"joy","tone_name":"Joy"},{"score":0.605555,"tone_id":"sadness","tone_name":"Sadness"}],"category_id":"emotion_tone","category_name":"Emotion Tone"},{"tones":[{"score":0.0,"tone_id":"analytical","tone_name":"Analytical"},{"score":0.0,"tone_id":"confident","tone_name":"Confident"},{"score":0.75152,"tone_id":"tentative","tone_name":"Tentative"}],"category_id":"language_tone","category_name":"Language Tone"},{"tones":[{"score":0.912326,"tone_id":"openness_big5","tone_name":"Openness"},{"score":0.1406,"tone_id":"conscientiousness_big5","tone_name":"Conscientiousness"},{"score":0.471871,"tone_id":"extraversion_big5","tone_name":"Extraversion"},{"score":0.567799,"tone_id":"agreeableness_big5","tone_name":"Agreeableness"},{"score":0.386687,"tone_id":"emotional_range_big5","tone_name":"Emotional Range"}],"category_id":"social_tone","category_name":"Social Tone"}]},{"sentence_id":1,"text":"Emily Dickinson","input_from":42,"input_to":57,"tone_categories":[]}]};
        	
            var toneAnalysisData = document.getElementById("toneAnalysisData").value;
            if (toneAnalysisData != null && toneAnalysisData != "") {
                //This is the API that gives the list of venues based on the place and search query.
                var handler = $http.get("https://gateway.watsonplatform.net/tone-analyzer/api/v3/tone?version=2016-05-19&text=A%20word%20is%20dead%20when%20it%20is%20said,%20some%20say.%20Emily%20Dickinson");
               handler.success(function (data) {
                console.log(abc.document_tone.tone_categories[0].tones[0].tone_name);
                    if (abc != null) {
                    	var table='';
                        table+="<label id='tableLabel'>Tone Analysis Data</label>";
                        table+="<tbody>";
                        for (var i = 0; i < abc.document_tone.tone_categories.length; i++) {
                        	for (var j=0; j< abc.document_tone.tone_categories[i].tones.length; j++){
                        	 table+="<tr><td>Score</td><td>"+abc.document_tone.tone_categories[i].tones[j].score+"</td>";
                        	 table+="<td>Tone Name</td><td>"+abc.document_tone.tone_categories[i].tones[j].tone_name+"</td></tr>";
                        	}
                        }	
                        table+="</tbody>";
                        document.getElementById("data").innerHTML=table;
                    }

                })
                handler.error(function (data) {
                    alert("There was some error processing your request. Please try after some time.");
                });
            }
        }
    });
