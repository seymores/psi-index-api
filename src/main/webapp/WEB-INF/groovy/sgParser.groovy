import com.google.appengine.api.datastore.Entity
import org.jsoup.*


String URL = "http://weather.nea.gov.sg/MapControl.aspx?ds=PSIMaps"

def doc = Jsoup.connect(URL).get();
//println doc

def data = doc.select("span.lblwarningmessage").text().split("     ").collect{ it.trim() };
try {

    String lastUpdated = data[2]?.replaceAll(",","")

    String overall24hr = data[0].trim()?.replaceAll(",","")
    String overall24hrVal = overall24hr?.split(": ")[1]

    String current3hr = data[1].trim()
    String current3hrVal = current3hr?.split(": ")[1]
    log.info "Update=${lastUpdated}, size=${data.size()}, result=${data} >>> 24-hr=${overall24hr}, 24=${overall24hrVal}, ${current3hr}, 3-hr=${current3hrVal}"

    // current     : result.currentValue
    // overall     : result.overallValue
    // title       : result.title,
    // body        : result.body,
    // lastUpdate  : result.lastUpdate

    log.info " >>>> " + geo

    def result          = new Entity("result")
    result.currentValue = current3hrVal
    result.overallValue = overall24hrVal 
    result.title        = current3hr
    result.body         = overall24hr
    result.checkTime    = lastUpdated
    result.lastUpdate   = new Date()
    result.country      = "singapore"
    result.city         = "singapore"
    result.save()

} catch (e) { log.warning e.message }


