class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?"{
	      constraints {
			 // apply constraints here
		  }
	  }
        
		"/$controller"(action: "list")

        "/$controller/show/$id"(action: "show")

        "/$controller/$id"(parseRequest: true) {
            action = [GET: "show", PUT: "update", DELETE: "delete", POST: "save"]
        }

		"/"(view:"/index")
		"500"(view:'/error')
	}
}
