
<g:if test="${controllerName=='inside' || grailsApplication.config.admin.inside.contains(controllerName)}">
  <header id="Header" class=" masthead"><%// jumbotron masthead%>
	<div class="container">
		<h1 class="title"><g:layoutTitle default="${meta(name:'app.name')}" /></h1>
	</div>
</header>
</g:if>
<g:else>
<header id="Header" class="jumbotron masthead"><%// jumbotron masthead%>
	<div class="container">
		<h1 class="title"><g:layoutTitle default="${meta(name:'app.name')}" /></h1>
	</div>
</header>	
            
</g:else>


