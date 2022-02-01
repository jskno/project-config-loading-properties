# Project Configuration: Loading properties

There are several configuration sources:
* property and yaml files
* environment variables
* command-line arguments

We will see different ways to load properties values navigating BankService from top to down.
  
### From default application.properties by default

* We define the property bankName which is loaded in the service because application.properties and the like files are loaded by default

### From an additional properties file

* We define the property additionalBankName and have to declare the additional file in PropertySource annotation

### From application-$profile.properties files

* We define same property in application-dev.properties and application-prod.properties and defined active profile in default application.properties or command line args or environment variable

### From Environment Spring class

* We autowire Environment interface and get the property by key

### Defining beans from a unique interface with a specif profile for each bean implementation.

* We autowire PrintingService interface and define active profile as usual. In this case the bean has different functionality in dev vs prod but there is no dev/prod enviroments properties in play

### Loading properties in a clase by prefix to avoid @Value annotations

* We define the MailServer component with a specific property file to load its configuration (@PropertySource) and specifiying the prefix so that the members of the class has to match the property names (@ConfigurationProperties)

### Loading in smart way properties to a library Service that depends of profiles also

* We mock the external library service class that needs some configuration (DynamoDbAsynClient). That bean is defined in a @Configuration class and the bean method receives as an argument the DynamoConfigurationProperties that load properties form file
* Needs in the property class @ConstructorBinding and @ConfigurationProperties(prefix = "application.dynamo")
* In the main app class @EnableConfigurationProperties(DynamoConfigurationProperties::class)
* See same pattern in Kakfa properties from load-properties-app

------------------------------
### Additional Links

These additional project and references should also help you:

* [Loading-properties-app](https://github.com/jskno/loading-properties-app)


