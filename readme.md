```
    ____                           _                      __
   / __ \_________  ____ _      __(_)___  ____ __________/ /
  / / / / ___/ __ \/ __ \ | /| / / /_  / / __ `/ ___/ __  /
 / /_/ / /  / /_/ / /_/ / |/ |/ / / / /_/ /_/ / /  / /_/ /
/_____/_/   \____/ .___/|__/|__/_/_/___/\__,_/_/   \__,_/ __      __
                /_/             / /____  ____ ___  ____  / /___ _/ /____
                               / __/ _ \/ __ `__ \/ __ \/ / __ `/ __/ _ \
                              / /_/  __/ / / / / / /_/ / / /_/ / /_/  __/
                              \__/\___/_/ /_/ /_/ .___/_/\__,_/\__/\___/
                                               /_/
```
This is a [Dropwizard] template that has a single resource `TemplateResource` that can be accessed by via `template` endpoint. I have created this template to make it easier to start working on Dropwizard projects, as everything is already set up to begin work with Dropwizard framework.

### Packages
* configuration - currently configures `ObjectMapper` that can be used to parse `String` to a POJO.
* factories - contains a factory for resources.
* model - used for parsing a POJO to a JSON object for the template response.
* resources - template resource that has HTTP GET and POST methods and produces a JSON object.

### Example calls
##### GET
`/template` response:
```json
{
    "hello" : "world"
}
```

`/template?name={name}` response:
```json
{
    "hello" : "{name}"
}
```
##### POST
`/template` request with:
```json
{
    "hello" : "{name}"
}
```
produces response:
```json
{
    "hello" : "{name}"
}
```
`/template` request with an empty body produces response:
```json
{
    "hello" : "world"
}
```

### What is used?
In this Dropwizard template, I have used Dropwizard framework version 0.9.2 and [Apache Maven] for the project management.

[Dropwizard]: <http://www.dropwizard.io/0.9.2/docs/>
[Apache Maven]: <https://maven.apache.org/>