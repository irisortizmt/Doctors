function leerReser(){
    $.ajax({
        url:'http://127.0.0.1:8080/api/Reservation/all',
        type:'GET',
        datatype:'JSON',
        success:function(respuesta){
            console.log(respuesta);
            pintarTablaReser(respuesta);
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
function guardarReser(){
    let data = {
        startDate:$("#startDate").val(),
        devolutionDate:$("#devDate").val(),
        status: $("#status").val(),
        doctor:{
            id:$("#Doctor").val()},
        client: {
            idClient:$("#Client").val()},
    };
    let dataToSend=JSON.stringify(data);
    console.log(dataToSend);
    $.ajax({
        url:'http://127.0.0.1:8080/api/Reservation/save',
        type:'POST',
        data:dataToSend,
        contentType:'application/JSON',
        success:function(respuesta){
            $("#resultadoReser").empty();
            $("#startDate").val("");
            $("#devDate").val("");
            $("#status").val("");
            $("#Doctor").val("");
            $("#Client").val("");
            leerReser();
            alert("Guardado con éxito");
        }
    });
}
function pintarTablaReser(items) {
    let myTable = "<table><th scope='col'><th>ID</th><th>START-DATE</th><th>DEVOLUTION-DATE</th><th>STATUS</th></th></th><th>DOCTOR</th><th>ID CLIENT</th><th>NAME CLIENT</th><th>EMAIL CLIENT</th><th>SCORE</th>";
    for (i = 0; i < items.length; i++) {
        myTable += "<tr>";
        myTable += "<td>" +"</td>"
        myTable += "<td>" + items[i].idReservation + "</td>";
        myTable += "<td>" + items[i].startDate.slice(0,10) + "</td>";
        myTable += "<td>" + items[i].devolutionDate.slice(0,10) + "</td>";
        myTable += "<td>" + items[i].status + "</td>";
        myTable += "<td>" + items[i].doctor.name + "</td>";
        myTable += "<td>" + items[i].client.idClient + "</td>";
        myTable += "<td>" + items[i].client.name + "</td>";
        myTable += "<td>" + items[i].client.email + "</td>";
        myTable += "<td>" + items[i].score+ "</td>";
        myTable += "<td> <button onclick='borrarReser(" + items[i].idReservation + ")'>Borrar</button></td>";
        myTable += "<td> <button onclick='editarReser(" + items[i].idReservation + ")'>Actualizar</button></td>";
        myTable += "</tr>";
        console.log(items[i].id)
    }
    $("#resultadoReser").append(myTable);
    myTable = "</table>";
}

    function editarReser(id) {
        let data = {
            idReservation: id,
            startDate: $("#startDate").val(),
            devolutionDate: $("#devDate").val(),
            status: $("#status").val(),
        };
        let dataToSend = JSON.stringify(data);
        console.log(dataToSend);
        $.ajax({
            url: 'http://localhost:8080/api/Reservation/update',
            type: 'PUT',
            data: dataToSend,
            contentType: "application/JSON",
            datatype: "JSON",
            success: function (respuesta) {
                $("#resultadoReser").empty();
                $("#startDate").val("");
                $("#devDate").val("");
                $("#status").val("");
                $("#Doctor").val("");
                $("#Client").val("");
                leerReser();
                alert("Se ha actualizado")
            }
        });
    }

    function borrarReser(idReservation) {
        let data = {
            idReservation: idReservation
        };
        let dataToSend = JSON.stringify(data);
        $.ajax({
            url: 'http://127.0.0.1:8080/api/Reservation/' + idReservation,
            type: 'DELETE',
            data: dataToSend,
            contentType: "application/JSON",
            datatype: "JSON",
            success: function (respuesta) {
                $("#resultadoReser").empty();
                leerReser();
                alert("Se ha eliminado");
            }, error: function (e) {
                console.log(e);
                alert("Algo salió mal");
            }
        });
    }
