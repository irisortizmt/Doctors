function leerSpecialty(){
    $.ajax({
        url:'http://127.0.0.1:8080/api/Specialty/all',
        type:'GET',
        datatype:'JSON',
        success:function(respuesta){
            console.log(respuesta);
            pintarTablaSpecialty(respuesta);
        }
    });
}
function guardarSpecialty(){
    let data = {
        name:$("#nameS").val(),
        description:$("#descriptionS").val(),
    };
    let dataToSend=JSON.stringify(data);
    console.log(dataToSend);
    $.ajax({
        url:'http://127.0.0.1:8080/api/Specialty/save',
        type:'POST',
        data:dataToSend,
        contentType:'application/JSON',
        success:function(respuesta){
            $("#resultado").empty();
            $("#nameS").val("");
            $("#descriptionS").val("");
            $("#doctors").val("");
            leerSpecialty();
            alert("Guardado con éxito");
        }
    });
}

function pintarTablaSpecialty(items) {
    let myTable = "<table><th scope='col'><th>NAME</th><th>DESCRIPTION</th><th>DOCTORS</th>";
    for (i = 0; i < items.length; i++) {
        myTable += "<tr>";
        myTable += "<td>" + "</td>";
        myTable += "<td>" + items[i].name + "</td>";
        myTable += "<td>" + items[i].description + "</td>";
        myTable += "<td>" + items[i].doctors.name+ "</td>";
        myTable += "<td> <button onclick='borrarSpecialty("+items[i].id+")'>Borrar</button></td>";
        myTable += "<td> <button onclick='editarSpecialty("+items[i].id+")'>Actualizar</button></td>";
        myTable += "</tr>";
        console.log(items[i].id)
    }
    $("#resultado").append(myTable);
    myTable = "</table>";
}

function editarSpecialty(id){
    let data = {
        id:id,
        name:$("#nameS").val(),
        description:$("#descriptionS").val(),
    };
    let dataToSend=JSON.stringify(data);
    console.log(dataToSend);
    $.ajax({
        url:'http://localhost:8080/api/Specialty/update',
        type:'PUT',
        data:dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuesta){
            $("#resultado").empty();
            $("#name").val("");
            $("#description").val("");
            $("#doctors").val("");
            leerSpecialty();
            alert("Se ha actualizado");
        }
    });
}

function borrarSpecialty(id){
    let data={
        id:id,
    };
    let dataToSend=JSON.stringify(data);
    console.log(id);
    $.ajax({
        url:'http://127.0.0.1:8080/api/Specialty/'+id,
        type:'DELETE',
        data:dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuesta){
            $("#resultado").empty();
            leerSpecialty();
            alert("Se ha eliminado");
        }, error: function (e) {
            console.log(e);
            alert("Algo salió mal");
        }
    });
}
