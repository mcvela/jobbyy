package jobby

import org.springframework.web.servlet.support.RequestContextUtils
/**
 * SecurityFilters
 * A filters class is used to execute code before and after a controller action is executed and also after a view is rendered
 */
class SecurityFilters {
	transient springSecurityService
    def messageSource
    def filters = {
        all(controller:'*', action:'*') {
            before = {
				log.info messageSource.getMessage('log.access.controller.action.message', [controllerName, actionName].toArray(), request.getLocale())
				
            }
            after = { Map model ->

            }
            afterView = { Exception e ->

            }
        }
    }
}
