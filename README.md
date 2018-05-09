# xml2groovy-jenkins-DSL-configure-block
This is a small script that helps to convert the XML to groovy mark up. Why you may need this reverse engineering? -> Jenkins DSL, I was creating Jenkins DSL for 'freeStyleJob' and encountered couple of plugins which do not support any DSL for it like IBM UCD, for such plugins only option left creating XML by groovy. I took existing xml from another similar existing job and used it to create at template in groovy script

    <list name="example-list">
        <technology>
            <name>Groovy</name>
        </technology>
    </list>
    
    //will be converted to 
    
    list(name:'example-list')
    {technology
    {name('Groovy')
    }
    }
    
    //Copy and use any online js beautifier or IDE to format it 
    
    list(name: 'example-list') {
      technology {
          name('Groovy')
      }
    }
