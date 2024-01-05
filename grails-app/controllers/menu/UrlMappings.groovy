package menu

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller:"dishes")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
