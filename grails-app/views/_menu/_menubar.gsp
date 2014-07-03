<sec:ifAllGranted roles="ROLE_ADMIN">

<g:if test="${controllerName=='tripas' || grailsApplication.config.admin.tripas.contains(controllerName)}">
   
	<div class="">
		<ul class="nav nav-tabs tableEditAdmini"  data-role="listview" data-split-icon="gear" data-filter="true">
		 
			<g:each status="i" var="c" in="${grailsApplication.config.admin.tripas.sort { it} }">
				<li class="controller${params.controller == c ? " active" : ""}">
					<g:link controller="${c}" action="list">
						<g:message code="${c}.label" default="${c.capitalize()}"/>
					</g:link>
				</li>
			</g:each>
			
		</ul>
	</div>

</g:if>
</sec:ifAllGranted>
<sec:ifAllGranted roles="ROLE_USER">
 <%/*%>

<div class="">
	<ul class="nav nav-tabs" data-role="listview" data-split-icon="gear" data-filter="true">
	 
		<g:each status="i" var="c" in="${grailsApplication.controllerClasses.sort { it.logicalPropertyName } }">
			<li class="controller${params.controller == c.logicalPropertyName ? " active" : ""}">
				<g:link controller="${c.logicalPropertyName}" action="index">
					<g:message code="${c.logicalPropertyName}.label" default="${c.logicalPropertyName.capitalize()}"/>
				</g:link>
			</li>
		</g:each>
		
	</ul>
</div>
<%*/%>
  </sec:ifAllGranted>