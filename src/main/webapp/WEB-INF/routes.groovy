
get "/", forward: "/WEB-INF/pages/index.gtpl"
get "/datetime", forward: "/datetime.groovy"
get "/api", forward: "/api.groovy"
get "/api/sg", forward: "/sgParser.groovy"
get "/api/my", forward: "/myParser.groovy"

get "/favicon.ico", redirect: "/images/gaelyk-small-favicon.png"
