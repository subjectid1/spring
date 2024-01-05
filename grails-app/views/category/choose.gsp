<!--
  Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
  Click nbfs://nbhost/SystemFileSystem/Templates/Groovy/_view.gsp to edit this template
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="layout" content="main"/>
        <title>Choose Category</title>
    </head>
    <body>
  <div class="ui compact menu">
  <div class="ui simple dropdown item">
    Category
    <i class="dropdown icon"></i>
    <div class="menu">
        <g:each in='${menu.Category.all}' var='c'>
      <a href='${createLink(uri:'/dishes/create?category=')+c.id}' class="item">${c.name}</a>
      </g:each>
    </div>
  </div>
</div>
    </body>
</html>
