<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Grails"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>

    <asset:stylesheet src="application.css"/>
    <asset:stylesheet src="semantic.min.css"/>
    <g:layoutHead/>
</head>

<body>
<div class="ui menu">
  <div class="item">
    <g:link controller='category' action='create' class="ui primary button">Add Category</g:link>
  </div>
  <div class="item">
    <g:link controller='filter' action='create' class="ui button">New Filter</g:link>
  </div>
     <div class="item">
         <g:link controller='option' action='create' class="ui orange basic button">New Option</g:link>
  </div>
       <div class="item">
         <g:link controller='category' action='choose' class="ui teal button">Upload Dishes</g:link>
  </div>
</div>

<g:layoutBody/>

 

<div id="spinner" class="spinner" style="display:none;">
    <g:message code="spinner.alt" default="Loading&hellip;"/>
</div>

<asset:javascript src="application.js"/>

</body>
</html>