function reportDate(){
    var dateOne = document.getElementById("startDate").value;
    var dateTwo = document.getElementById("devDate").value;
    $.ajax({
        url:'http://127.0.0.1:8080/api/Reservation/report-dates/'+dateOne+"/"+dateTwo,
        type:'GET',
        datatype:'JSON',
        success:function(respuesta){
            console.log(respuesta);
            pintarRep(respuesta);
        }
    });
}
function pintarRep(items){
    let myTable="<table><th scope='col'><th>ID</th><th>START-DATE</th><th>DEVOLUTION-DATE</th><th>STATUS</th>";
    for (i=0; i<items.length; i++){
        myTable+="<tr>";
        myTable+="<td>"+"</td>";
        star=items[i].startDate
        fin=items[i].devolutionDate
        myTable+="<td>"+items[i].idReservation+"</td>";
        myTable+="<td>"+star.slice(0,10)+"</td>";
        myTable+="<td>"+fin.slice(0,10)+"</td>";
        myTable+="<td>"+items[i].status+"</td>";
        myTable+="</tr>";
        console.log(items[i].idReservation)
    }
    $("#resultadoRep").append(myTable);
    myTable="</table>";
}
function reportStatus(){
    $.ajax({
        url:'http://127.0.0.1:8080/api/Reservation/report-status/',
        type:'GET',
        datatype:'JSON',
        success:function(respuesta){
            console.log(respuesta);
            pintarStatus(respuesta);
        }
    });
}
function pintarStatus(respuesta){
    let myTable="<table><scope='col'><th>CANCELLED</th><th>COMPLETED</th>";
    myTable+="<tr>";
    myTable+="<td>"+respuesta.cancelled+"</td>";
    myTable+="<td>"+respuesta.completed+"</td>";
    myTable+="</tr>";
    console.log(respuesta)
    $("#repStatus").append(myTable);
    myTable="</table>";
}

function topClients(){
    $.ajax({
        url:'http://127.0.0.1:8080/api/Reservation/report-clients/',
        type:'GET',
        datatype:'JSON',
        success:function(respuesta){
            console.log(respuesta);
            pintarTop(respuesta);
        }
    });
}

function pintarTop(items){
    let myTable="<table><th scope='col'><th>POSITION</th><th>CLIENT</th><th>NUM-RESERVATIONS</th>";
    for (i=0; i<items.length; i++){
        myTable+="<tr>";
        myTable+="<td>"+"</td>";
        pos=i+1;
        myTable+="<th>"+pos+"</th>";
        myTable+="<td>"+items[i].client.name+"</td>";
        myTable+="<td>"+items[i].total+"</td>";
        myTable+="</tr>";
        console.log(items[i].idReservation)
    }
    $("#resultadoTop").append(myTable);
    myTable="</table>";
}