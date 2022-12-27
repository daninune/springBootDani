$(document).ready(function() {
    alert("Probando la función ready()");
});
$("#new").click(function(){

    $("#addEmployee-modal").modal();
});

function edit(idemployee){
alert("edit idemployee  "+idemployee);
}