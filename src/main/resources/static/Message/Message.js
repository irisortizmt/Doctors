function leerMessage(){
    $.ajax({
        url:'http://127.0.0.1:8080/api/Message/all',
        type:'GET',
        datatype:'JSON',
        success:function(respuesta){
            console.log(respuesta);
            pintarTablaMessage(respuesta);
        }
    });
}
function leerDoctores(){
    $.ajax({
        url:'http://127.0.0.1:8080/api/Doctor/all',
        type:'GET',
        datatype:'JSON',
        success:function(respuesta){
            SelectD(respuesta);
            console.log(respuesta);
        }
    });
}
function SelectD(items){
    console.log(items);
    for (let j = 0; j < items.length; j++) {
        $('#Doctor').append("<option value="+items[j].id+" id="+items[j].id+">"+items[j].name+"</option>");
        $('#Doctor').val("");
    }
}
function leerClient(){
    $.ajax({
        url:'http://127.0.0.1:8080/api/Client/all',
        type:'GET',
        datatype:'JSON',
        success:function(respuesta){
            SelectCl(respuesta);
            console.log(respuesta);
        }
    });
}

function SelectCl(items){
    console.log(items);
    for (let k = 0; k < items.length; k++) {
        $('#Client').append("<option value="+items[k].idClient+" id="+items[k].idClient+">"+items[k].name+"</option>");
        $('#Client').val("");
    }
}

function guardarMessage(){
    let data = {
        messageText:$("#message").val(),
        doctor:{
            id:$("#Doctor").val()},
        client: {
            idClient:$("#Client").val()}
    };
    let dataToSend=JSON.stringify(data);
    console.log(dataToSend);
    $.ajax({
        url:'http://127.0.0.1:8080/api/Message/save',
        type:'POST',
        data:dataToSend,
        contentType:'application/JSON',
        success:function(respuesta){
            $("#resultadoMessage").empty();
            $("#message").val("");
            $("#Doctor").val("");
            $("#Client").val("");
            leerMessage();
            alert("Guardado con éxito");
        }
    });
}
function pintarTablaMessage(items){
    let myTable="<table><th scope='col'><th>MESSAGE</th><th>DOCTOR</th><th>CLIENT</th>";
    for (i=0; i<items.length; i++){
        myTable+="<tr>";
        myTable+="<td>"+"</td>";
        myTable+="<td>"+items[i].messageText+"</td>";
        myTable+="<td>"+items[i].doctor.name+"</td>";
        myTable+="<td>"+items[i].client.name+"</td>";
        myTable+="<td> <button onclick='borrarMessage("+items[i].idMessage+")'>Borrar</button></td>";
        myTable += "<td> <button onclick='editarMessage("+items[i].idMessage+")'>Actualizar</button></td>";
        myTable+="</tr>";
        console.log(items[i].id)
    }
    $("#resultadoMessage").append(myTable);
    myTable="</table>";
}
function editarMessage(id){
    let data = {
        idMessage:id,
        messageText:$("#message").val(),
    };
    let dataToSend=JSON.stringify(data);
    console.log(dataToSend);
    $.ajax({
        url:'http://localhost:8080/api/Message/update',
        type:'PUT',
        data:dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuesta){
            $("#resultadoMessage").empty();
            $("#message").val("");
            $("#Doctor").val("");
            $("#Client").val("");
            leerMessage();
            alert("Se ha actualizado")
        }
    });
}

function borrarMessage(idMessage){
    let data={
        idMessage:idMessage
    };
    let dataToSend=JSON.stringify(data);
    $.ajax({
        url:'http://127.0.0.1:8080/api/Message/'+idMessage,
        type:'DELETE',
        data:dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuesta){
            $("#resultadoMessage").empty();
            leerMessage();
            alert("Se ha eliminado");
        }, error: function (e) {
            console.log(e);
            alert("Algo salió mal");
        }
    });
}