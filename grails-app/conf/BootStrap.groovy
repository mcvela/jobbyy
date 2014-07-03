import jobbyy.security.User;
import jobbyy.security.Role;
import jobbyy.security.UserRole;

class BootStrap {
	def authenticateService
	
	def init = { servletContext ->
	   
		def adminRole = Role.findByAuthority("ROLE_ADMIN") ?: new Role(authority: "ROLE_ADMIN").save(failOnError: true)
		def userRole = Role.findByAuthority("ROLE_USER") ?: new Role(authority: "ROLE_USER").save(failOnError: true)
		def anonymousRole = Role.findByAuthority("ROLE_ANONYMOUS") ?: new Role(authority: "ROLE_ANONYMOUS").save(failOnError: true)
		
		def defaultUser = User.findByUsername("admin") ?: new User(username: "admin", password: "admin", email: "admin@jobbyy.com", enabled: true, accountExpired: false, accountLocked: false, passwordExpired: false).save(failOnError: true)
		if (!defaultUser.authorities.contains(adminRole)) {
			UserRole.create defaultUser, adminRole
		}
		if (!defaultUser.authorities.contains(anonymousRole)) {
			UserRole.create defaultUser, anonymousRole
		}
	   
		
	}
	def destroy = {
	}
}
 
