## testing build and run 
* mvn clean package
* mvn spring-boot:run


## Calling country 1

curl --header "content-type: text/xml" -d @request.xml http://localhost:8080/ws  > output.xml   && xmllint --format output.xml
## Calling country 2 

curl --header "content-type: text/xml" -d @request2.xml http://localhost:8080/ws  > output.xml   && xmllint --format output.xml


## Calling weather 

curl --header "content-type: text/xml" -d @weatherrequest.xml http://localhost:8080/ws  > output.xml   && xmllint --format output.xml

