import de.rotex.fileboxx.*

class BootStrap {

    def springSecurityService

    def init = { servletContext ->

        new User(
            username: "admin",
            enabled: true,
            password: springSecurityService.encodePassword('admin')
        ).save(flush: true, failOnError: true)

        def uklawitter = new User(
            username: "uklawitter",
            enabled: true,
            password: springSecurityService.encodePassword('uklawitter')
        ).save(flush: true, failOnError: true)

        new TagList(name: "Webservice").save(failOnError: true)
        new TagList(name: "Service").save(failOnError: true)
        new TagList(name: "Marketing").save(failOnError: true)

        def driverTag = new Tag(name: "Treiber").save(failOnError: true)
        def mySqlTag = new Tag(name: "MySQL").save(failOnError: true)
        def webserviceTag = new Tag(name: "Webservice").save(failOnError: true)
        def serviceTag = new Tag(name: "Service").save(failOnError: true)
        def marketingTag = new Tag(name: "Marketing").save(failOnError: true)

        new FileBoxxFile(
                name: "driver112.jar",
                description: "MySQL Treiber V.1.1.2",
                createdBy: uklawitter
            )
            .addToTags(driverTag).addToTags(mySqlTag).addToTags(webserviceTag)
            .save(failOnError: true)
        new FileBoxxFile(
                name: "pressebild.jpg",
                description: "Pressebild",
                createdBy: uklawitter
            )
            .addToTags(marketingTag)
            .save(failOnError: true)
        new FileBoxxFile(
                name: "mysql_browser_7.3.exe",
                description: "MySQL Browserver V.7.3",
                createdBy: uklawitter
            )
            .addToTags(mySqlTag).addToTags(webserviceTag)
            .save(failOnError: true)
        new FileBoxxFile(
                name: "projektplan17.jpg",
                description: "Projektplan #4708",
                createdBy: uklawitter
            )
            .addToTags(serviceTag)
            .save(failOnError: true)
    }
    def destroy = {
    }
}
