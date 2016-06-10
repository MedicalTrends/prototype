<%--
  Created by IntelliJ IDEA.
  User: stk-des01
  Date: 26-05-16
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/SMTK" prefix="SMTK" %>
<html>
<head>
    <title>Crear Concepto</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
</head>
<body>

<div class="container">
    <h3>Nuevo Concepto</h3>

    <form action="addConcept" method="post" class="form-horizontal">
        <div class="panel panel-default">
            <div class="panel-body">
                <div class="container">
                    <label class="radio-inline">
                        <input type="radio" name="Autogenerado" value="false"> Manual
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="Autogenerado" value="true"> Autogenerado
                    </label>
                    <br/>
                </div>
                <div class="form-group">
                    <label  for="FSN" class="col-sm-2 control-label">FSN (*)</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" name="FSN" id="FSN">
                    </div>
                    <div class="col-sm-5">
                        <label class="radio-inline">
                           Sensible a mayúsculas:
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="SensibilidadFSN" value="true"> Si
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="SensibilidadFSN" value="false"> No
                        </label>
                    </div>
                </div>
                <div class="form-group">
                    <label for="Preferido" class="col-sm-2 control-label">Preferido (*)</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" id="Preferido" name="Preferida">
                    </div>
                    <div class="col-sm-5">
                        <label class="radio-inline">
                            Sensible a mayúsculas:
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="SensibilidadPref" value="true"> Si
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="SensibilidadPref" value="false"> No
                        </label>
                    </div>
                </div>
                <div class="container">
                    <label>Indicadores</label>
                    <div class="checkbox">
                        <label>
                            <input name="revisar" type="checkbox" value="">
                            Revisar
                        </label>
                    </div>
                    <div class="checkbox">
                        <label>
                            <input name="consultar" type="checkbox" value="">
                            Consultar
                        </label>
                    </div>
                    <br/>
                </div>
                <div class="container">
                    <div class="col-sm-1">
                        <label>Término: </label>
                    </div>
                    <div class="col-sm-3">
                        <input id="termino" class="form-control"/>
                    </div>
                    <div class="col-sm-3">
                        <select id="sensibilidad"  class="form-control">
                            <option value="" disabled selected>Sensibilidad a mayúsculas</option>
                            <option>Insensible </option>
                            <option>Sensible</option>
                        </select>
                    </div>
                    <div  class="col-sm-3">
                        <select id="tipoTermino" class="form-control">
                            <option value="" disabled selected>Tipo descripción</option>
                            <option>ABREVIADO</option>
                            <option>SINONIMO</option>
                            <option>AMBIGUO</option>
                            <option>MAL ESCRITO</option>
                        </select>
                    </div>
                    <div class="col-sm-1">
                        <input type="button" value="Agregar" onclick="addDescription('dataTable')" />
                    </div>


                </div>
                <br/>
                <div class="container col-sm-12">

                    <div class="table-responsive">
                        <table id="dataTable" name="tablaDescripciones" class="table table-bordered table-condensed">
                            <thead>
                            <tr>
                                <td>Término</td>
                                <td>Estado</td>
                                <td>Tipo</td>
                                <td>Fecha creación</td>
                                <td>Sensibilidad</td>
                                <td>Usuario</td>
                                <td>Acción</td>
                            </tr>
                            </thead>
                            <tr>
                            </tr>
                        </table>
                    </div>

                </div>

            </div>
        </div>


        <SMTK:CC/>

        <SMTK:TypeBasic/>

        <div class="form-group">
            <div class="col-md-4 col-md-offset-4"><input class="form-control" type="submit"></div>

        </div>
    </form>
</div>

<script src="colum.js"></script>
</body>
</html>
