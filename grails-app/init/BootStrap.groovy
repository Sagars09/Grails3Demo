import com.grails3demo.Role
import com.grails3demo.User
import com.grails3demo.UserRole
import grails3demo.*

class BootStrap {

    def init = { servletContext ->

        new Person(message: 'Spring Security Startup!!')
        new Person(message: 'Running Successfully!!')

        def userRole = new Role(authority: 'ROLE_USER').save(flush: true)
        def admin = new User(username: 'demo@gmail.com', password: 'demo').save(flush: true)

        UserRole.create(admin, userRole)

        UserRole.withSession {
            it.flush()
            it.clear()
        }
    }
    def destroy = {
    }
}
