<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>TIME SHEET </title>
       <asset:javascript src="jquery-3.5.1.min.js"/>
    <asset:javascript src="index.global.min.js"/>






</head>
<body>   Choose Member:<div class="ui compact menu">
  <div class="ui simple dropdown item">
<g:if test='${params.member}'>
    ${params.member} 
    </g:if>
<g:else>
    ${time.Member.all.getAt(0)} 
    </g:else>
    <i class="dropdown icon"></i>
    <div class="menu">
        <g:each in='${time.Member.all}' var='m'>
      <a href="${createLink(uri:'/?member='+m.name)}" class="item">${m.name}</a>
   </g:each>
    </div>
  </div>
</div> 
      <div id='calendar'></div>

<g:if test='${flash.message}'>
<script>
    alert('${flash.message}')
</script>
</g:if>
      <script>

  document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');

    var calendar = new FullCalendar.Calendar(calendarEl, {
      timeZone: 'UTC',
      initialView: 'timeGridFourDay',
      headerToolbar: {
        left: 'prev,next',
        center: 'title',
        right: 'timeGridDay,timeGridFourDay'
      },
      views: {
        timeGridFourDay: {
          type: 'timeGrid',
          duration: { days: 5 },
          buttonText: '5 day'
        }
      },
      <g:if test='${params.date}'>
          initialDate: "<g:formatDate format="yyyy-MM-dd" date="${new Date(params.date)}"/>",
          </g:if>
      events:  [
      <g:if test='${params.member}'>
      <g:each in='${time.Event.findAllByMember(time.Member.findByName(params.member))}' var='e'>
    {
      "title": "${e.title}",
      "start": "<g:formatDate format="yyyy-MM-dd" date="${(e.date)}"/>T<g:if test='${e.start<10}'>0</g:if>${e.start}:00:00",
      "end": "<g:formatDate format="yyyy-MM-dd" date="${(e.date)}"/>T<g:if test='${e.end<10}'>0</g:if>${e.end}:00:00"
    },
     </g:each>
          </g:if>
      <g:else>
               <g:each in='${time.Event.findAllByMember(time.Member.all.getAt(0))}' var='e'>
      {
      "title": "${e.title}",
      "start": "<g:formatDate format="yyyy-MM-dd" date="${(e.date)}"/>T<g:if test='${e.start<10}'>0</g:if>${e.start}:00:00",
      "end": "<g:formatDate format="yyyy-MM-dd" date="${(e.date)}"/>T<g:if test='${e.end<10}'>0</g:if>${e.end}:00:00"
    },
     </g:each>
          </g:else>
          
  ]
    });

    calendar.render();
  });

</script>
</body>
</html>
