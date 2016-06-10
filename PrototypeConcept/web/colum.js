function addCreateRelationship(tableID) {

    var table = document.getElementById(tableID);
    var select = document.getElementById('selectRelationship');
    var orden= document.getElementById('orden2');
    var nombre= document.getElementById('nombreRelacion');
    var idTipo= document.getElementById('idTipo');
    var nameTipo= document.getElementById('nameTipo');
    var multiplicidad= document.getElementById('MultiplicidadTipoRel');
    var categoryDes= document.getElementById('selectAllCategories');
    

    var rowCount = table.rows.length;
    var row = table.insertRow(rowCount);


    var cell1 = row.insertCell(0);
    cell1.innerHTML = nombre.value;

    //Nombre

    var element = document.createElement("input");
    element.className = "hidden";
    element.type = "text";
    element.name = "name"+(rowCount-1);
    element.value= nombre.value;
    cell1.appendChild(element);

    //ID Relacion ()

    var element1 = document.createElement("input");
    element1.className = "hidden";
    element1.type = "text";
    element1.name = "idRel"+(rowCount-1);
    cell1.appendChild(element1);

    if(idTipo.value!=8005){
        var element5 = document.createElement("input");
        element5.className = "hidden";
        element5.type = "text";
        element5.name = "categoryDes"+(rowCount-1);
        element5.value = categoryDes.selectedOptions[0].value;
        cell1.appendChild(element5);
    }


    

    var cell2 = row.insertCell(1);
    cell2.innerHTML = nameTipo.value;

    var element2 = document.createElement("input");
    element2.className = "hidden";
    element2.type = "text";
    element2.name = "idTipo"+(rowCount-1);
    element2.value=idTipo.value;
    cell2.appendChild(element2);

    var cell3 = row.insertCell(2);
    cell3.innerHTML = orden.value;

    //Orden
    var element4 = document.createElement("input");
    element4.className = "hidden";
    element4.type = "text";
    element4.name = "orden"+(rowCount-1);
    element4.value= orden.value;
    cell3.appendChild(element4);


    var cell4 = row.insertCell(3);
    cell4.innerHTML = multiplicidad.value;

    var element3 = document.createElement("input");
    element3.className = "hidden";
    element3.type = "text";
    element3.name = "multiplicidad"+(rowCount-1);
    element3.value= multiplicidad.value;
    cell4.appendChild(element3);


    orden.value="";
    nombre.value="";
    idTipo.value="";
    nameTipo.value="";
    multiplicidad.value="";

    modal.style.display = "none";
    modal2.style.display = "none";

}

function addRelationship(tableID) {
    
    var table = document.getElementById(tableID);
    var select = document.getElementById('selectRelationship');
    var orden= document.getElementById('orden');

    var rowCount = table.rows.length;
    var row = table.insertRow(rowCount);


    var cell1 = row.insertCell(0);
    cell1.innerHTML = select.selectedOptions[0].text;

    //Nombre

    var element = document.createElement("input");
    element.className = "hidden";
    element.type = "text";
    element.name = "name"+(rowCount-1);
    cell1.appendChild(element);
    
    //ID Relacion ()

    var element1 = document.createElement("input");
    element1.className = "hidden";
    element1.type = "text";
    element1.name = "idRel"+(rowCount-1);
    element1.value= select.value;
    cell1.appendChild(element1);

    var cell2 = row.insertCell(1);
    var cell3 = row.insertCell(2);
    cell3.innerHTML = orden.value;

    //Orden
    var element2 = document.createElement("input");
    element2.className = "hidden";
    element2.type = "text";
    element2.name = "orden"+(rowCount-1);
    element2.value= orden.value;
    cell3.appendChild(element2);


    var cell4 = row.insertCell(3);
    cell4.innerHTML = select.value;


    orden.value="";
}

function addDescription(tableID) {
    var table = document.getElementById(tableID);
    var termino = document.getElementById('termino').value;
    var sensibilidad = document.getElementById('sensibilidad').value;
    var tipo = document.getElementById('tipoTermino').value;

    var rowCount = table.rows.length;
    var row = table.insertRow(rowCount);
    
    
    var cell1 = row.insertCell(0);
    cell1.innerHTML = termino;
    var element = document.createElement("input");
    element.className = "hidden";
    element.type = "text";
    element.name = "termino"+(rowCount-1);
    element.value= termino;
    cell1.appendChild(element);

    row.insertCell(1);
    var cell2 = row.insertCell(2);
    cell2.innerHTML = tipo;


    var element2 = document.createElement("input");
    element2.className = "hidden";
    element2.type = "text";
    element2.name = "tipo"+(rowCount-1);
    element2.value= tipo;
    cell2.appendChild(element2);


    row.insertCell(3);
    var cell3 = row.insertCell(4);
    cell3.innerHTML = sensibilidad;

    var element1 = document.createElement("input");
    element1.className = "hidden";
    element1.type = "text";
    element1.name = "sensibilidad"+(rowCount-1);
    element1.value= sensibilidad;
    cell3.appendChild(element1);

    var cell4 = row.insertCell(5);
    cell4.innerHTML = 'A. Mauro';
    row.insertCell(6);
}

function addRelation(tableID,TerminoID,OrdenID,VigenciaID,nombreTabla,idDescription) {
    var table = document.getElementById(tableID);
    var termino = document.getElementById(TerminoID).value;
    var orden = document.getElementById(OrdenID).value;
    var idDescriptionDato = document.getElementById(idDescription).value;
    var tablaName=nombreTabla;
    var vigencia;

    var radios = document.getElementsByName(VigenciaID);

    for (var i = 0, length = radios.length; i < length; i++) {
        if (radios[i].checked) {
            vigencia=radios[i].value;
            break;
        }
    }

    var rowCount = table.rows.length;
    var row = table.insertRow(rowCount);


    var cell0 = row.insertCell(0);
    cell0.innerHTML = termino;

    var element0 = document.createElement("input");
    element0.className = "hidden";
    element0.type = "text";
    element0.name = tablaName+"dato["+(rowCount-1)+"]";
    element0.value= idDescriptionDato;
    cell0.appendChild(element0);

    var cell1 = row.insertCell(1);
    cell1.innerHTML = orden;
    var cell2 = row.insertCell(2);
    cell2.innerHTML = vigencia;
    row.insertCell(3);

    document.getElementById(TerminoID).value="";
    document.getElementById(OrdenID).value="";

}

function addRow(tableID) {
    var table = document.getElementById(tableID);
    var rowCount = table.rows.length;
    var row = table.insertRow(rowCount);


    var cell2 = row.insertCell(0);
    var element2 = document.createElement("input");
    element2.className = "form-control";
    element2.type = "text";
    element2.name = tableID+"dato"+(rowCount-1);
    cell2.appendChild(element2);


}

function deleteRow(tableID) {
    try {
        var table = document.getElementById(tableID);
        var rowCount = table.rows.length;

        for (var i = 0; i < rowCount; i++) {
            var row = table.rows[i];
            var chkbox = row.cells[0].childNodes[0];
            if (null != chkbox && true == chkbox.checked) {
                table.deleteRow(i);
                rowCount--;
                i--;
            }


        }
    } catch (e) {
        alert(e);
    }
}

function findConcept(idSelect, idPattern) {
    var pattern = document.getElementById(idPattern).value;
    var select = document.getElementById(idSelect);
    if (select.style.visibility == 'hidden') {
        select.style.visibility = 'visible';
        select.style.zIndex = 1;
        select.size = 5;
        select.position = "relative";
        select.style.width = 67.3 + "%";
        select.background = 'white';
    }
    if (pattern.length >= 3) {

        var xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                loadConcept(xmlhttp, idSelect);
            }
        };
        var url = "findDescription?pattern=" + pattern;
        xmlhttp.open("GET", url, true);
        xmlhttp.send();
    } else {
        if (select.style.visibility != 'hidden')select.style.visibility = 'hidden';
        select.length = 0;
        select.size = 0;
    }


}

function loadConcept(xml, idSelect) {
    var x, i, xmlDoc, txt;
    xmlDoc = xml.responseXML;
    txt = "";
    x = xmlDoc.getElementsByTagName("ListOptions");
    x = x[0];
    var select = document.getElementById(idSelect);
    select.length = 0;
    for (i = 0; i < x.childElementCount; i++) {

        var option = document.createElement("option");
        var y=x.childNodes[i];
        option.text = y.childNodes[0].childNodes[0].nodeValue;
        option.value = y.childNodes[1].childNodes[0].nodeValue;
        select.add(option);
    }
}

function selectConcept(idSelect, idPattern,idDescription) {

    var selected = document.getElementById(idSelect);
    document.getElementById(idPattern).value = selected.selectedOptions[0].text;
    document.getElementById(idDescription).value = selected.value;
    selected = document.getElementById(idSelect);
    selected.style.visibility = 'hidden';
    selected.size = 0;

}