class UrlMappings {

    static mappings = {

        "/$controller/$action?/$id?" {
	        constraints {
			    // apply constraints here
            }
        }

        "/${controller}s"(parseRequest: true) {
            action = [GET: "list"]
        }

        "/$controller"(parseRequest: true) {
            action = [POST: "create", GET: "read"]
        }

        "/$controller/$id"(parseRequest: true) {
            action = [GET: "read", DELETE: "delete", PUT: "update"]
        }

        "/"(view: "/index")
        "500"(view: '/error')
    }
}
