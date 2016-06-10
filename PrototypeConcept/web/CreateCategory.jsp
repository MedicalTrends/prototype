<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/SMTK" prefix="SMTK" %>
<html>
<head>
    <title>Crear Categoría</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
</head>
<body id="body">


<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Tipo relación</h4>
            </div>
            <div class="modal-body">

                <div class="form-horizontal">
                    <label>Tipo: </label>
                    <select id="selectType" class="form-control">
                        <option value="" disabled selected>Seleccione un tipo</option>
                        <option value="8005">Concepto a tipo básico</option>
                        <option value="8001">Concepto a concepto</option>
                        <option value="3">Concepto a tabla auxiliar</option>
                        <option value="4">Concepto a SNOMED CT</option>
                    </select>
                </div>
            </div>
            <div class="modal-footer">

                <button id="myBtn2" type="button" class="btn btn-primary">Aceptar</button>
            </div>
        </div>
    </div>
</div>


<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel2">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel2">Tipo relación</h4>
            </div>
            <div class="modal-body">
                <div class="form-horizontal">

                    <label>Nombre: </label>
                    <input id="nombreRelacion" class="form-control"/>
                    <label>Multiplicidad: </label>
                    <input id="MultiplicidadTipoRel" class="form-control"/>
                    <label>Orden: </label>
                    <input id="orden2" class="form-control"/>
                    <label>Requerido</label>
                    <label class="radio-inline">
                        <input type="radio" name="nombreAuto" id="manual" value="option1"> Si
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="nombreAuto" id="autogenerado" value="option2"> No
                    </label>
                    <br/>
                    <input class="hidden" type="text" name="idTipo" id="idTipo" value="">
                    <input class="hidden" type="text" id="nameTipo" value="">
                    <div id="tipoDiv">


                    </div>

                </div>

            </div>
            <div class="modal-footer">
                <input type="button" class="btn btn-success" value="Agregar relación" disabled/>
                <button onclick="addCreateRelationship('dataTableRelationship')" type="button" class="btn btn-primary">Agregar</button>
            </div>
        </div>
    </div>
</div>


<div class="container">
    <h3>Nueva Categoría</h3>
    <form method="post" action="addcategory" class="form-horizontal">
        <SMTK:FormCategory/>
        <div  style="text-align: right;">
            <button  type="submit" class="btn btn-primary">Crear categoría</button>
        </div>

    </form>


</div>

<script src="colum.js"></script>
<script src="modal.js"></script>
</body>
</html>
