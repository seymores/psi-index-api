import groovy.json.*

log.info "Params=${params}"

def countryVal = request.location?: request.country?: "singapore"
def cityVal = request.city

def result = datastore.execute {
    select all from result    
    where country == countryVal
    if (cityVal) {
        and city == cityVal
    }
    limit 1
}

log.info result[0].toString()
result = result[0]
def json = new JsonBuilder(
    current     : "${result.currentValue}",
    overall     : "${result.overallValue}",
    title       : "${result.title}",
    body        : "${result.body}",
    checkTime   : "${result.checkTime}",
    lastUpdate  : "${result.lastUpdate}"
) 

response.contentType = "application/json"
json.writeTo(response.writer)
