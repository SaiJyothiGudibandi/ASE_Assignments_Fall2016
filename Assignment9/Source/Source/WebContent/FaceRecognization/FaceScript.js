function faceRecognition(){
    var image=document.getElementById("image").value;
    var url="https://gateway-a.watsonplatform.net/visual-recognition/api/v3/classify?api_key=4a6a1383af4ca0d3fc67e8ee3d44060460917da3&url="+image+"&version=2016-05-20";
    $.ajax({
        url: url,
        success: function (response) {
    image+="<label id='imageLabel'>Image</label><img src='"+url+"' id='Image'>";
    document.getElementById("image").innerHTML=image;
    var table='';
    table+="<label id='tableLabel'>Image Data</label>";
    table+="<tbody>";
            table+="<tr><td>Class</td><td>"+response.images[0].classifiers[0].classes[0].class+"</td>";
            table+="<tr><td>Class</td><td>"+response.images[0].classifiers[0].classes[0].score+"</td>";
    table+="</tbody>";
    document.getElementById("data").innerHTML=table;
},
    error:function(){
        console.log("false");
    }
});
}

