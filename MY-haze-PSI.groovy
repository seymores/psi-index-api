import org.jsoup.*

String URL = "http://apims.doe.gov.my/apims/hourly2.php"

def doc = Jsoup.connect(URL).get();
def result = doc.select("table.table1 tr");


result.each { tr ->
    def row = tr.select("td")
    println " ---- row---\n" + row[0].text() + " " + row[1].text()

}
println "---"

/*
String lastUpdated = result[2]?.replaceAll(",","")

String overall24hr = result[0].trim()?.replaceAll(",","")
String overall24hrVal = overall24hr?.split(": ")[1]

String current3hr = result[1].trim()
String current3hrVal = current3hr?.split(": ")[1]

println "Update=${lastUpdated}, size=${result.size()}, result=${result} >>> 24-hr=${overall24hr}, 24=${overall24hrVal}, ${current3hr}, 3-hr=${current3hrVal}"


Elements links = doc.select("a[href]"); // a with href
Elements pngs = doc.select("img[src$=.png]");
  // img with src ending .png

Element masthead = doc.select("div.masthead").first();
  // div with class=masthead

Elements resultLinks = doc.select("h3.r > a"); // direct a after h3
*/