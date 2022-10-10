function leerSpecialties(){
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
        id:$("#idSpecialty").val(),
        name:$("#nameSp").val(),
        description:$("#descriptionSp").val(),
        doctors:{
            id:$("#doctors").val()}
    };
    let dataToSend=JSON.stringify(data);
    console.log(dataToSend);
    $.ajax({
        url:'http://127.0.0.1:8080/api/Specialty/save',
        type:'POST',
        data:dataToSend,
        contentType:'application/JSON',
        success:function(respuesta){
            $("#resultadoSpecialty").empty();
            $("#idSpecialty").val("")
            $("#nameSp").val("");
            $("#descriptionSp").val("");
            $("#doctors").val("");
            leerSpecialties();
            alert("Guardado con éxito");
        }
    });
}
function pintarTablaSpecialty(items){
    let myTable="<table><th scope='col'><th>NAME</th><th>DESCRIPTION</th><th>DOCTORS</th>";
    for (i=0; i<items.length; i++){
        myTable+="<tr>";
        myTable+="<td>"+"</td>";
        myTable+="<td>"+items[i].name+"</td>";
        myTable+="<td>"+items[i].description+"</td>";
        myTable+="<td>"+items[i].doctors.name+"</td>";
        myTable+="<td> <button onclick='borrarDoctor("+items[i].id+")'>Borrar</button></td>";
        myTable+="</tr>";
        console.log(items[i].id)
    }
    $("#resultadoSpecialty").append(myTable);
    myTable="</table>";
}

function leerDoctores(){
    $.ajax({
    url:'http://127.0.0.1:8080/api/Doctor/all',
    type:'GET',
    datatype:'JSON',
    success:function(respuesta){
        console.log(respuesta);
        pintarTablaDoctores(respuesta);
    }
    });
}

function guardarDoctor(){
    let data = {
        id:$("#id").val,
        name:$("#name").val(),
        department:$("#department").val(),
        year: $("#graduate_year").val(),
        description:$("#description").val(),
        specialty:{
            id:$("#specialty").val()}
    };
    let dataToSend=JSON.stringify(data);
    console.log(dataToSend);
    $.ajax({
        url:'http://127.0.0.1:8080/api/Doctor/save',
        type:'POST',
        data:dataToSend,
        contentType:'application/JSON',
        success:function(respuesta){
            $("#resultadoDoctor").empty();
            $("#id").val("")
            $("#name").val("");
            $("#department").val("");
            $("#graduate_year").val("");
            $("#description").val("");
            $("#specialty").val("");
            leerDoctores();
            alert("Guardado con éxito");
        }
    });
}

function pintarTablaDoctores(items){
    let myTable="<table><th scope='col'><th>NAME</th><th>DEPARTMENT</th><th>GRADUATE_YEAR</th><th>DESCRIPTION</th><th>SPECIALTY</th>";
    for (i=0; i<items.length; i++){
        myTable+="<tr>";
        myTable+="<td>"+"</td>";
        myTable+="<td>"+items[i].name+"</td>";
        myTable+="<td>"+items[i].department+"</td>";
        myTable+="<td>"+items[i].year+"</td>";
        myTable+="<td>"+items[i].description+"</td>";
        myTable+="<td>"+items[i].specialty.name+"</td>";
        myTable+="<td> <button onclick='borrarDoctor("+items[i].id+")'>Borrar</button></td>";
        myTable+="</tr>";
        console.log(items[i].id)
    }
    $("#resultadoDoctor").append(myTable);
    myTable="</table>";
}

function editarDoctor(){
    let data = {
        id:$("#id").val(),
        name:$("#name").val(),
        department:$("#department").val(),
        year: $("#graduate_year").val(),
        description:$("#description").val(),
    };
    let dataToSend=JSON.stringify(data);
    console.log(dataToSend);
    $.ajax({
        url:'http://localhost:8080/api/Doctor/update',
        type:'PUT',
        data:dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuesta){
            $("#resultadoDoctor").empty();
            $("#id").val("");
            $("#name").val("");
            $("#department").val("");
            $("#graduate_year").val("");
            $("#description").val("");
            leerDoctores();
            alert("Se ha actualizado")
        }
    });
}

function borrarDoctor(id){
    let data={
        id:id
    };
    let dataToSend=JSON.stringify(data);
    $.ajax({
        url:'http://127.0.0.1:8080/api/Doctor/'+id,
        type:'DELETE',
        data:dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuesta){
            $("#resultadoDoctor").empty();
            leerDoctores();
            alert("Se ha eliminado");
        }, error: function (e) {
            console.log(e);
            alert("Algo salió mal");
        }
    });
}


