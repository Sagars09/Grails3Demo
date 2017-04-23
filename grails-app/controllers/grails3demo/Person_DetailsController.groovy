package grails3demo
import grails.plugin.springsecurity.annotation.Secured

class Person_DetailsController {

    @Secured('ROLE_USER')
    def index() {

        def details = Person.createCriteria().list {
            order ("dateCreated", "desc")
            maxResults(1)
        }
        //render details.first()?.message
        render (view: 'index')
    }
}
