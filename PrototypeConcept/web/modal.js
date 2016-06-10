/**
 * Created by stk-des01 on 06-06-16.
 */


var modal = document.getElementById('myModal');
var modal2 = document.getElementById('myModal2');
var body = document.getElementById('body');
var btn = document.getElementById("myBtn");
var btn2 = document.getElementById("myBtn2");
var span = document.getElementsByClassName("close")[0];
var span2 = document.getElementsByClassName("close")[1];
var selectType = document.getElementById('selectType');


function allCategory() {

    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            loadCategory(xmlhttp);
        }
    };
    var url = "allCategory";
    xmlhttp.open("GET", url, true);
    xmlhttp.send();


}

function loadCategory(xml) {


    var x, i, xmlDoc, txt;
    xmlDoc = xml.responseXML;
    txt = "";
    x = xmlDoc.getElementsByTagName("option");
    var select = document.getElementById('selectAllCategories');
    select.length = 0;
    for (i = 0; i < x.length; i++) {


        var option = document.createElement("option");
        option.text = x[i].childNodes[0].nodeValue;
        option.value = x[i].nextElementSibling.textContent;
        select.add(option);
    }

}


btn.onclick = function () {
    modal.style.display = "block";
    modal.classList.add("in");
    body.classList.add("modal-open");
    body.style.paddingRight = "13px";

}
btn2.onclick = function () {

    if (selectType.value == '8005') {
        document.getElementById('nameTipo').value=selectType.selectedOptions[0].text;
        document.getElementById('idTipo').value='8005';
        document.getElementById('tipoDiv').innerHTML = "<label>Tipo: </label>" +
            "<select id=\"selectAllCategories\"  class=\"form-control\">" +
            "<option>String</option>" +
            "<option>Int</option>" +
            "<option>Boolean</option>" +
            "<option>Float</option>" +
            "</select>";
    }
    if (selectType.value == '8001') {
        document.getElementById('nameTipo').value=selectType.selectedOptions[0].text;
        document.getElementById('idTipo').value=8001;
        document.getElementById('tipoDiv').innerHTML = "<label>Categoría: </label>" +
            "<select id=\"selectAllCategories\" class=\"form-control\" >" +
            "</select>";
        allCategory();
    }
    if (selectType.value == '3') {
        document.getElementById('tipoDiv').innerHTML = "3";
    }
    if (selectType.value == '4') {
        document.getElementById('tipoDiv').innerHTML = "4";
    }


    modal.style.display = "none";
    modal2.style.display = "block";
    modal2.classList.add("in");
    body.classList.add("modal-open");
    body.style.paddingRight = "13px";

}

span.onclick = function () {
    modal.style.display = "none";
    modal2.style.display = "none";
}

span2.onclick = function () {
    modal.style.display = "none";
    modal2.style.display = "none";
}




window.onclick = function (event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
    if (event.target == modal2) {
        modal2.style.display = "none";
    }
}

