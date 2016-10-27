/**
 * Created by baavish on 9/14/2016.
 */
function faceRecognition(){
    var image=document.getElementById("image").value;
    var url="https://gateway-a.watsonplatform.net/visual-recognition/api/v3/classify?api_key=4a6a1383af4ca0d3fc67e8ee3d44060460917da3&url="+image+"&version=2016-05-20";
    $.ajax({
        url: url,
        success: function (response) {
            console.log(response);
        }
    });
}
