<%--<ul class="nav pull-right">--%>
	<li class="dropdown">
<%--	--%>
<sec:ifNotLoggedIn>

		<a class="dropdown-toggle" data-toggle="dropdown" href="#">
			<!-- TODO: integrate Springsource Security etc. and show User's name ... -->
    		<i class="glyphicon glyphicon-user"></i>
    		<g:message code="security.signin.label"/><b class="caret"></b>
		</a>

		<ul class="dropdown-menu" role="menu">
			<li class="form-container">
			
			
			<div class="modal-body">
	
		
			

             <div class='login_message' id='loginUpdate'></div>
            <form action='/j_spring_security_check' method='POST'  id='ajaxLoginForm' name='ajaxLoginForm' class='cssform' autocomplete='off'>
            <p>
                 
                <input type='text' placeholder="<g:message code="springSecurity.login.username.label"/>" class='text_' name='j_username' id='username'/>
            </p>
 
            <p>
                 
                <input type='password' placeholder="<g:message code="springSecurity.login.password.label"/>" class='text_' name='j_password' id='password'/>
            </p>
          <%--   <div class="controls">
            
                <p id="remember_me_holder" >
                    <label for='remember_me' class="checkbox"><input type='checkbox' class='chk' name='${rememberMeParameter}' id='remember_me' <g:if test='${hasCookie}'>checked='checked'</g:if>/> <g:message code="springSecurity.login.remember.me.label"/></label>
                </p>
            </div>--%>
            <div class="controls">
                <p id="remember_me_holder" >
                    <label for='remember_me' class="checkbox"><input type='checkbox' class='chk' name='_spring_security_remember_me' id='remember_me' /> <g:message code="springSecurity.login.remember.me.label"/></label>
                </p>
            </div>
            </form>
            
            
<div class="modal-footer">
    <input
        onclick="jQuery('#loginUpdate').html('Accediendo...');
                 jQuery.ajax({
                              type:'POST',
                              data:$('#ajaxLoginForm').serialize(),
                              url:'/j_spring_security_check',
                              success:function(data,textStatus){
                                      if(data.success){
                                         $('#invalidsession').modal('hide').on('hidden', function(){
                                            jQuery('#invalidsession').html('');
                                            
                                         });
                                      }
                                      else{
                                    	 
                                         jQuery('#loginUpdate').html(data.error);
                                      }
                                      document.location.href='/inside/usersgui';//login and go to this page
                              },
                              error:function(XMLHttpRequest,textStatus,errorThrown){}
                 });return false"
        type="button"
        name="Login"
        value="${message(code: "springSecurity.login.button")}"
        id="submit"
        
        class="btn btn-success">
</div>
            
        </div>

			
			
				<%--<form action="/j_spring_security_check" method="post" accept-charset="UTF-8">
				<form action="login" method="post" accept-charset="UTF-8">
					<input class="form-control" style="margin-bottom: 15px;" type="text"		placeholder="Username" id="username" name="username">
					<input class="form-control" style="margin-bottom: 15px;" type="password"	placeholder="Password" id="password" name="password">
					<input style="float: left; margin-right: 10px;" type="checkbox" name="remember-me" id="remember-me" value="1">
					<label class="string optional" for="user_remember_me"> Remember me</label>
					<input class="btn btn-primary btn-block" type="submit" id="sign-in" value="Sign In">
				</form>
                                
                 <form role="form" id='loginForm2' class='form-horizontal' action='${postUrl}' method='POST' autocomplete='off'>
				<div class="form-group ${hasErrors(bean: _DemoPageInstance, field: 'name', 'error')} ">
					<h3> <g:message code="springSecurity.login.header"/> </h3>
				</div>
				
				<div class="form-group ${hasErrors(bean: _DemoPageInstance, field: 'name', 'error')} ">
					<label for='username' class="control-label"><g:message code="springSecurity.login.username.label"/>:</label>
					<div class="controls">
						<input type='text' class='form-control col-md-4' name='j_username' id='username'/>
					</div>
				</div>
	
				<div class="form-group ${hasErrors(bean: _DemoPageInstance, field: 'name', 'error')} ">
					<label for='password' class="control-label"><g:message code="springSecurity.login.password.label"/>:</label>
					<div class="controls">
						<input type='password' class='form-control col-md-4' name='j_password' id='password'/>
					</div>
				</div>
				
				<div id="remember_me_holder" class="form-group">
					<label for='remember_me' class="control-label"><g:message code="springSecurity.login.remember.me.label"/></label>
					<div class="controls">
						<bs:checkBox class="form-control col-md-4" name="${rememberMeParameter}" value="${hasCookie}" />
					</div>
				</div>
				
				<div class="form-group">
					<input type='submit' id="submit" class="btn btn-success" value='${message(code: "springSecurity.login.button")}'/>
				</div>
		</form> 
             --%>                   
                                
              	<!-- NOTE: the renderDialog MUST be placed outside the NavBar (at least for Bootstrap 2.1.1): see bottom of main.gsp -->
				<g:render template="/_common/modals/registerTextLink"/>
		                  
			</li>
		 
			 
		</ul>

</sec:ifNotLoggedIn>
<sec:ifLoggedIn>

 		<a class="dropdown-toggle" role="button" data-toggle="dropdown" data-target="#" href="#">
 			<!-- TODO: Only show menu items based on permissions (e.g., Guest has no account page) -->
 			<i class="glyphicon glyphicon-user icon-white"></i>
 			<sec:loggedInUserInfo field="username"/><b class="caret"></b>
 		</a>
 		<ul class="dropdown-menu" role="menu"> 
 			<!-- TODO: Only show menu items based on permissions --> 
 			<li class=""><a href="${createLink(uri: '/')}"> 
 				<i class="glyphicon glyphicon-user"></i> 
 				<g:message code="user.show.label"/> 
 			</a></li> 
 			<li class=""><a href="${createLink(uri: '/')}"> 
 				<i class="glyphicon glyphicon-cogs"></i> 
 				<g:message code="user.settings.change.label"/> 
 			</a></li> 
 			 
 			<li class="divider"></li> 
 			<li class=""><a href="${createLink(uri: '/logout')}"> 
 				<i class="glyphicon glyphicon-off"></i> 
 				<g:message code="security.signoff.label"/> 
 			</a></li> 
 		</ul> 
 
</sec:ifLoggedIn>

	</li>
<%--</ul>--%>

<noscript>
<ul class="nav pull-right">
	<li class="">
		<g:link controller="user" action="show"><g:message code="default.user.unknown.label"/></g:link>
	</li>
</ul>
</noscript>
