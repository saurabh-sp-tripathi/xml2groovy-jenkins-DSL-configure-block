# xml2groovy-jenkins-DSL-configure-block
This is a small script that helps to convert the XML to groovy mark up. Why you may need this reverse engineering? -> Jenkins DSL, I was creating Jenkins DSL for 'freeStyleJob' and encountered couple of plugins which do not support any DSL for it like ~~IBM UCD~~, for such plugins only option left creating XML by groovy. I took existing xml from another similar existing job and used it to create at template in groovy script
```
    <list name="example-list">
        <technology>
            <name>Groovy</name>
        </technology>
    </list>
```    
  //will be converted to :arrow_double_down:
```    
    list(name:'example-list')
    {technology
    {name('Groovy')
    }
    }
```    
  //Copy and use any online js beautifier or IDE to format it :arrow_double_down:
```    
    list(name: 'example-list') {
      technology {
          name('Groovy')
      }
    }
```
Another example from real jenkins plugin could be maven plugin (just for the sake of example , we do have a maven build step plugin dsl)


	<hudson.tasks.Maven>
	    <targets>clean package -Pmy-profile -U</targets>
	    <mavenName>MAVEN 3.5.0</mavenName>
	    <usePrivateRepository>false</usePrivateRepository>
	    <settings class="jenkins.mvn.DefaultSettingsProvider" />
	    <globalSettings class="jenkins.mvn.DefaultGlobalSettingsProvider" />
	    <injectBuildVariables>false</injectBuildVariables>
	</hudson.tasks.Maven>

Will be converted to :arrow_double_down:

    hudson.tasks.Maven
    {targets('clean package -Pmy-profile -U')
    mavenName('MAVEN 3.5.0')
    usePrivateRepository('false')
    settings(class:'jenkins.mvn.DefaultSettingsProvider')
    globalSettings(class:'jenkins.mvn.DefaultGlobalSettingsProvider')
    injectBuildVariables('false')
    }

After formatting you may use this in jenkins freestyle job as :arrow_double_down:

    configure { node ->
		    	node / builders << 'hudson.tasks.Maven' {
				    targets('clean package -Pmy-profile -U')
				    mavenName('MAVEN 3.5.0')
				    usePrivateRepository('false')
				    settings(class: 'jenkins.mvn.DefaultSettingsProvider')
				    globalSettings(class: 'jenkins.mvn.DefaultGlobalSettingsProvider')
				    injectBuildVariables('false')
				}
    }



