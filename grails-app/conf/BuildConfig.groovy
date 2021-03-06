grails.servlet.version = "2.5" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.work.dir = "target/work"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
//grails.project.war.file = "target/${appName}-${appVersion}.war"
grails.project.war.file = "target/${appName}-${appVersion}.war"
grails.project.plugins.dir="plugins"

grails.project.fork = [
    // configure settings for compilation JVM, note that if you alter the Groovy version forked compilation is required
    //  compile: [maxMemory: 256, minMemory: 64, debug: false, maxPerm: 256, daemon:true],

    // configure settings for the test-app JVM, uses the daemon by default
    test: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, daemon:true],
    // configure settings for the run-app JVM
    run: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
    // configure settings for the run-war JVM
    war: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
    // configure settings for the Console UI JVM
    console: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256]
]

grails.project.dependency.resolver = "maven" // or ivy
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // specify dependency exclusions here; for example, uncomment this to disable ehcache:
        // excludes 'ehcache'
    }
    log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve
    legacyResolve false // whether to do a secondary resolve on plugin installation, not advised and here for backwards compatibility

    repositories {
        inherits true // Whether to inherit repository definitions from plugins

        grailsPlugins()
        grailsHome()
        mavenLocal()
        grailsCentral()
        mavenCentral()
        // uncomment these (or add new ones) to enable remote dependency resolution from public Maven repositories
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
        mavenRepo "http://repo.spring.io/milestone/"
	   }

    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes e.g.
        // runtime 'mysql:mysql-connector-java:5.1.27'
        // runtime 'org.postgresql:postgresql:9.3-1100-jdbc41'
    }

    plugins {
        // plugins for the build system only
         build ':tomcat:7.0.50.1'
		 // build ':tomcat:7.0.54'//grails 2.4.2
        
        ///mysql
         
        compile ":mysql-connectorj:5.1.22.1"

        // plugins for the compile step
        compile ":scaffolding:2.0.0" //":scaffolding:2.0.2"
		// compile ':scaffolding:2.1.2'//// grails 2.4.2
		compile ':cache:1.1.1'
		// compile ':cache:1.1.7'//// grails 2.4.2
		//compile ':asset-pipeline:1.8.11'//// grails 2.4.2
		
        //compile ":twitter-bootstrap:3.1.1"
        
        compile ":kickstart-with-bootstrap:1.1.0"
        //compile ":font-awesome-resources:4.0.3.0"
        //compile ":lesscss-resources:1.3.3"
        
       
         
        //runtime ":twitter-bootstrap:3.1.1"//runtime ":twitter-bootstrap:2.3.1"
        // plugins needed at runtime but not for compilation
        
        runtime ":hibernate:3.6.10.8" // or ":hibernate4:4.3.1.1"
		// runtime ':hibernate4:4.3.5.4' // grails 2.4.2
        runtime ":database-migration:1.3.8"
        runtime ":jquery:1.11.0.1"
        runtime ":resources:1.2.6"
        
       
        
        // spring security core
        compile ':spring-security-core:2.0-RC2'
        // spring security facebook
        //compile ":spring-security-facebook:0.15.2-CORE2"
        
        // email
        compile ':mail:1.0.1'
        
        // spring-security-gui
        compile ':spring-security-ui:1.0-RC1'
        
       
		 runtime ':db-reverse-engineer:0.5'
        
        // Uncomment these (or add new ones) to enable additional resources capabilities
        //runtime ":zipped-resources:1.0.1"
        //runtime ":cached-resources:1.1"
        //runtime ":yui-minify-resources:0.1.5"

        // An alternative to the default resources plugin is the asset-pipeline plugin
        //compile ":asset-pipeline:1.5.0"

        // Uncomment these to enable additional asset-pipeline capabilities
        //compile ":sass-asset-pipeline:1.5.1"
        //compile ":less-asset-pipeline:1.5.0"
        //compile ":coffee-asset-pipeline:1.5.0"
        //compile ":handlebars-asset-pipeline:1.0.0.3"
    }
}
