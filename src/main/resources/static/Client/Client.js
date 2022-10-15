function leerClient(){
    $.ajax({
        url:'http://127.0.0.1:8080/api/Client/all',
        type:'GET',
        datatype:'JSON',
        success:function(respuesta){
            console.log(respuesta);
            pintarTablaClient(respuesta);
        }
    });
}
function guardarClient(){
    let data = {
        name:$("#nameC").val(),
        email:$("#email").val(),
        age:$("#age").val(),
        password:$("#password").val(),
    };
    let dataToSend=JSON.stringify(data);
    console.log(dataToSend);
    $.ajax({
        url:'http://127.0.0.1:8080/api/Client/save',
        type:'POST',
        data:dataToSend,
        contentType:'application/JSON',
        success:function(respuesta){
            $("#resultadoClient").empty();
            $("#nameC").val("");
            $("#email").val("");
            $("#age").val("");
            $("#password").val("");
            leerClient();
            alert("Guardado con éxito");
        }
    });
}
function pintarTablaClient(items){
    let myTable="<table><th scope='col'><th>NAME</th><th>EMAIL</th><th>AGE</th><th>PASSWORD</th>";
    for (i=0; i<items.length; i++){
        myTable+="<tr>";
        myTable+="<td>"+"</td>";
        myTable+="<td>"+items[i].name+"</td>";
        myTable+="<td>"+items[i].email+"</td>";
        myTable+="<td>"+items[i].age+"</td>";
        myTable+="<td>"+items[i].password+"</td>";
        myTable+="<td> <button onclick='borrarClient("+items[i].idClient+")'>Borrar</button></td>";
        myTable += "<td> <button onclick='editarClient("+items[i].idClient+")'>Actualizar</button></td>";
        myTable+="</tr>";
        console.log(items[i].id)
    }
    $("#resultadoClient").append(myTable);
    myTable="</table>";
}

function editarClient(id){
    let data = {
        idClient:id,
        name: $("#nameC").val(),
        email:$("#email").val(),
        age:$("#age").val(),
        password:$("#password").val(),
    };
    let dataToSend=JSON.stringify(data);
    console.log(dataToSend);
    $.ajax({
        url:'http://127.0.0.1:8080/api/Client/update',
        type:'PUT',
        data:dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuesta){
            $("#resultadoClient").empty();
            $("#nameC").val("");
            $("#email").val("");
            $("#age").val("");
            $("#password").val("");
            leerClient();
            alert("Se ha actualizado")
        }
    });
}

function borrarClient(idClient){
    let data={
        idClient:idClient,
    };
    let dataToSend=JSON.stringify(data);
    console.log(dataToSend);
    $.ajax({
        url:'http://127.0.0.1:8080/api/Client/'+idClient,
        type:'DELETE',
        data:dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuesta){
            $("#resultadoClient").empty();
            leerClient();
            alert("Se ha eliminado");
        }, error: function (e) {
            console.log(e);
            alert("Algo salió mal");
        }
    });
}

