// locations to search for config files that get merged into the main config;
// config files can be ConfigSlurper scripts, Java properties files, or classes
// in the classpath in ConfigSlurper format

// grails.config.locations = [ "classpath:${appName}-config.properties",
//                             "classpath:${appName}-config.groovy",
//                             "file:${userHome}/.grails/${appName}-config.properties",
//                             "file:${userHome}/.grails/${appName}-config.groovy"]

// if (System.properties["${appName}.config.location"]) {
//    grails.config.locations << "file:" + System.properties["${appName}.config.location"]
// }
grails.app.context="/"
grails.project.groupId = appName // change this to alter the default package name and Maven publishing destination

// The ACCEPT header will not be used for content negotiation for user agents containing the following strings (defaults to the 4 major rendering engines)
grails.mime.disable.accept.header.userAgents = ['Gecko', 'WebKit', 'Presto', 'Trident']
grails.mime.types = [ // the first one is the default format
    all:           '*/*', // 'all' maps to '*' or the first available format in withFormat
    atom:          'application/atom+xml',
	woff:          'application/x-woff',
    css:           'text/css',
    csv:           'text/csv',
    form:          'application/x-www-form-urlencoded',
    html:          ['text/html','application/xhtml+xml'],
    js:            'text/javascript',
    json:          ['application/json', 'text/json'],
    multipartForm: 'multipart/form-data',
    rss:           'application/rss+xml',
    text:          'text/plain',
    hal:           ['application/hal+json','application/hal+xml'],
    xml:           ['text/xml', 'application/xml']
]

import org.apache.log4j.DailyRollingFileAppender
import grails.plugin.springsecurity.SpringSecurityUtils

// URL Mapping Cache Max Size, defaults to 5000
//grails.urlmapping.cache.maxsize = 1000

// What URL patterns should be processed by the resources plugin
grails.resources.adhoc.patterns = ['/images/*', '/css/*', '/js/*', '/plugins/*']
grails.resources.adhoc.excludes = ['/WEB-INF/**']

// Legacy setting for codec used to encode data with ${}
grails.views.default.codec = "html"

// The default scope for controllers. May be prototype, session or singleton.
// If unspecified, controllers are prototype scoped.
grails.controllers.defaultScope = 'singleton'

// GSP settings
grails {
    views {
        gsp {
            encoding = 'UTF-8'
            htmlcodec = 'xml' // use xml escaping instead of HTML4 escaping
            codecs {
                expression = 'html' // escapes values inside ${}
                scriptlet = 'html' // escapes output from scriptlets in GSPs
                taglib = 'none' // escapes output from taglibs
                staticparts = 'none' // escapes output from static template parts
            }
        }
        // escapes all not-encoded output at final stage of outputting
        // filteringCodecForContentType.'text/html' = 'html'
    }
}

admin.inside=[""] 

grails.converters.encoding = "UTF-8"
// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = 'Instance'

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder = false
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true
// packages to include in Spring bean scanning
grails.spring.bean.packages = []
// whether to disable processing of multi part requests
grails.web.disable.multipart=false

// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password']

// configure auto-caching of queries by default (if false you can cache individual queries with 'cache: true')
grails.hibernate.cache.queries = false

environments {
    development {
        grails.logging.jul.usebridge = true
    }
    production {
        grails.logging.jul.usebridge = false
        // TODO: grails.serverURL = "http://www.changeme.com"
    }
}
// log4j configuration
log4j = {
	// Example of changing the log pattern for the default console
	// appender:
	//
	//appenders {
	//    console name:'stdout', layout:pattern(conversionPattern: '%c{2} %m%n')
	//}
	appenders {
		appender new DailyRollingFileAppender(
			name: 'dailyAppender',
			datePattern: "'.'yyyy-MM-dd",
			fileName: "logs/jobbyy.log",
			//layout: pattern(conversionPattern: '%d{ISO8601} %-5p %c{2} %m%n'))
			layout: pattern(conversionPattern: "%d{yyyy-MM-dd'T'HH:mm:ss.SSSZ}{GMT+0} %p %t H-_@server_ip_@:_@server_port_@ D-%X{MDC_DOMAIN} %c - %m%n %throwable"))
	}

	error  'org.codehaus.groovy.grails.web.servlet',  //  controllers
		   'org.codehaus.groovy.grails.web.pages', //  GSP
		   'org.codehaus.groovy.grails.web.sitemesh', //  layouts
		   'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
		   'org.codehaus.groovy.grails.web.mapping', // URL mapping
		   'org.codehaus.groovy.grails.commons', // core / classloading
		   'org.codehaus.groovy.grails.plugins', // plugins
		   'org.codehaus.groovy.grails.orm.hibernate', // hibernate integration
		   'org.springframework',
		   'org.hibernate',
		   'net.sf.ehcache.hibernate'
		   
	info dailyAppender: 'grails.app' // Jobbyy
	info dailyAppender: 'jobbyy.security.user' // Jobbyy , out of grails.app
	info dailyAppender: 'jobbyy.security' // Jobbyy security, out of grails.app
	 
	environments {
		development {
			debug	'org.hibernate.SQL',
					'org.hibernate.transaction', // optionally
					'org.apache.cxf', // cxf
					'org.springframework.security'
			
					
			// Enable Hibernate SQL logging with param values
//			trace 'org.hibernate.type'
			
			// Debug spring security plugin
//			trace 'org.springframework.security.access.vote'
//			trace 'org.springframework.security'
		}
		test {
			debug	'org.hibernate.SQL',
					'org.hibernate.transaction' // optionally
//					'org.apache.cxf', // cxf
//					'org.springframework.security'
			
					
			// Enable Hibernate SQL logging with param values
			trace 'org.hibernate.type'
			
			// Debug spring security plugin
//			trace 'org.springframework.security.access.vote'
//			trace 'org.springframework.security'
		}

		production {
			debug	'org.apache.cxf' // cxf
//			'org.hibernate.SQL'
			//'org.hibernate.transaction' // optionally
					
//					'org.springframework.security'
			
			
			// Enable Hibernate SQL logging with param values
//			trace 'org.hibernate.type'
		}
	}
}




// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.logout.postOnly = false
grails.plugin.springsecurity.useSessionFixationPrevention = false
grails.plugin.springsecurity.userLookup.userDomainClassName = 'jobbyy.security.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'jobbyy.security.UserRole'
grails.plugin.springsecurity.authority.className = 'jobbyy.security.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	'/':                              ['permitAll'],
	'/index':                         ['permitAll'],
	'/index.gsp':                     ['permitAll'],
	'/**/js/**':                      ['permitAll'],
	'/**/css/**':                     ['permitAll'],
	'/**/images/**':                  ['permitAll'],
        '/images/**/**':                  ['permitAll'],
        '/js/**/**':                      ['permitAll'],
        '/less/**/**':                    ['permitAll'],
        '/css/**/**':                     ['permitAll'],
        '/static/**/**':                  ['permitAll'],
	'/**/favicon.ico':                ['permitAll'],
        
        
        '/logout/**':                     ['permitAll'],
        '/login/**':                      ['permitAll'],
        '/j_spring_security_facebook_redirect': ['permitAll'],
        '/j_spring_security_check':       ['permitAll'],
    
        '/register/**':                   ['permitAll'],
       
    
        '/siteinfo/**/**':                ['permitAll'],
        '/includes/**/**':                ['permitAll'],
        '/home/**/**':                    ['permitAll'],
    
        '/dbdoc/**':                      ['ROLE_ADMIN'],
        '/tripas/**':                     ['ROLE_ADMIN'],
        '/dbconsole/**':                  ['ROLE_ADMIN'],
        '/user/**/**':                    ['ROLE_ADMIN'],
        '/role/**':                       ['ROLE_ADMIN'],
        '/securityInfo/**':               ['ROLE_ADMIN'],
        '/siteinfo/systeminfo':           ['ROLE_ADMIN'],
        '/registrationCode/**':           ['ROLE_ADMIN'] 
        , '/**/**/**/**':                    ['permitAll']
     
]

// Configuration of the mail account
grails {
    mail {
         host = "smtp.gmail.com"
         port = 465
         username = "youremail@gmail.com"
         password = ""
         props = ["mail.smtp.auth":"true",
                  "mail.smtp.socketFactory.port":"465",
                  "mail.smtp.socketFactory.class":"javax.net.ssl.SSLSocketFactory",
                  "mail.smtp.socketFactory.fallback":"false"]
    }
}
grails.mail.default.from="youremail@gmail.com"



///////// BOOTSTRAP
grails.plugins.twitterbootstrap.fixtaglib = true
grails.plugins.twitterbootstrap.defaultBundle = 'bundle_bootstrap'

grails.resources.modules = {

    'custom-bootstrap' {
        dependsOn 'bootstrap'
        resource url:[dir: 'less', file: 'custom-bootstrap.less'], attrs:[rel: "stylesheet/less", type:'css']
    }

}

//i18n Fields

i18nFields {
    locales = ['en_US', 'es_ES']
}

