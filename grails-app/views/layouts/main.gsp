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
    <g:link controller='task' action='create' class="ui primary button">Add Task</g:link>
  </div>
  <div class="item">
    <g:link controller='member' action='create' class="ui button">New Member</g:link>
  </div>
      <div class="item">
    <g:link controller='event' action='create' class="ui green button">Report Event</g:link>
  </div>
</div>

<g:layoutBody/>
 

<div id="spinner" class="spinner" style="display:none;">
    <g:message code="spinner.alt" default="Loading&hellip;"/>
</div>

<asset:javascript src="application.js"/>

</body>
</html>
