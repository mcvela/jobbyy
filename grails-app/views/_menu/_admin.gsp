<li class="dropdown">
	<a class="dropdown-toggle"   href="#">
   		<i class="glyphicon glyphicon-wrench"></i>
		<g:message code="default.admin.label"/><b class="caret"></b>
	</a>
	<ul class="dropdown-menu">
		<li class="">
			<a tabindex="-1" href="#"><b>Technical Admin</b></a>
		</li>
		<g:if env="development">
		<li class="">
			<a href="${createLink(uri: '/inside/dbconsole')}" >
				<i class="glyphicon glyphicon-dashboard"></i>
				<g:message code="default.dbconsole.label"/>
			</a>
		</li>
		</g:if>
		<li class="">
			<a href="${createLink(uri: '/inside/systeminfo')}">
				<i class="glyphicon glyphicon-info-sign"></i>
				<g:message code="default.systeminfo.label"/>
			</a>
		</li>
                <li class="">
                    <a href="${createLink(uri: '/inside/usersgui')}" >
				<i class="glyphicon glyphicon-user"></i>
				<g:message code="default.usuarios.label"/>
			</a>
		</li>
         </li>
               
                
	</ul>
</li>
