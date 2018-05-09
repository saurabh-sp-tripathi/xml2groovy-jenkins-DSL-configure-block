def text = '''
    <list name="example-list">
        <technology>
            <name>Groovy</name>
        </technology>
    </list>
'''

def list = new XmlSlurper().parseText(text) 
def printMarkUp(list) {
    def attr = list.attributes().toString().replace("[", "").replace("]", "")
    if (attr.size() == 1) {
        attr = "";
    } else {
        attrVal = attr.split(":");
        attr = "("+attrVal[0]+":'"+attrVal[1]+"')";
        //println attr
    }
    //println "node attributes : ${attr.size()}"
    if(list.children().size() > 0) {
    println "${list.name()}${attr}"
    print "{"
        list.children().each {
            child -> 
            printMarkUp(child)
        }
        println "}"
    }
    else {
        if(list.text()?.trim()) {
            println "${list.name()}('${list.text()}')"            
        } else {
            println "${list.name()}()"
        }
    }
}

printMarkUp(list)