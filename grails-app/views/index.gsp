<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Menu</title>
</head>
<body>
<div class="ui secondary pointing menu">
  <g:each in='${menu.Category.all}' var='c' status='i'>
    <g:if test='${(i==0&&!params.category)||params.category==c.id.toString()}'>
      <a class="active item">
    ${c.name}<g:set var="category" value="${c}" />
  </a>
  </g:if>
      <g:else>
  <a class="item" href="${createLink(uri:'/?category='+c.id)}">
     ${c.name}
  </a>
  </g:else>
  </g:each>
  <div class="right menu">
    <a class="ui item">
      Logout
    </a>
  </div>
</div>
<div class="ui segment">
    <div class="ui grid">
  <div class="three wide column"> <div class="ui vertical large menu"> 
     <g:each in='${menu.Filter.findAllByCategory(category)}' var='f'>
  <div class="item">
    <div class="header" style="color:olive">${f.name}</div>
    <div class="menu">
        <g:each in='${menu.Option.findAllByFilter(f)}' var='o'>
   <div class="ui slider checkbox">
       <g:if test='${session.(o.id)}'>
  <input type="checkbox" checked="true" onchange="check('${o.id}')">
  </g:if>
  <g:else>
        <input type="checkbox"  onchange="check('${o.id}')">
      </g:else>
  <label>${o.name}</label>
</div> 
     </g:each>
    </div>
  </div>
   </g:each>
 
 
</div></div>
  <div class="thirteen wide column"><div class="ui five cards">
   <g:each in='${dishes}' var='d'>
  <div class="card">
    <div class="image">
      <img src='${createLink(controller:"dishes",action:"view",id:d.id)}'>
    </div>
      <div class="content">
    <h3 class="header">${d.name}<a class="ui tag label">$${d.price}</a></h3>
    <div class="meta">
  <g:each in='${d.options}' var='o'>
       
    <div class="ui red horizontal olive label">${o.name}</div>
 
 
      </g:each>
    </div>
   
  </div>
      <div class="extra content">
      <span class="right floated">
           <g:link controller='dishes' action='buy' id='${d.id}' class="ui mini basic green button">Buy</g:link>
      </span>
      <span>
        <i class="user icon"></i>
        ${d.buyer} buyer
      </span>
    </div>
  </div>
      </g:each>
      </div></div>
  
</div>


</div>
<script>
    function check(o){window.location.href='${createLink(controller:"option",action:"check")}'+'?id='+o
    }
    </script>
</body>
</html>
