Repo to demo soap ws that used multipeel external xsd. the purpose is to reproduce and issue on apim

## testing build and run 
* mvn clean package
* mvn spring-boot:run


## Calling country 1

curl --header "content-type: text/xml" -d @request.xml http://localhost:8080/ws  > output.xml   && xmllint --format output.xml
## Calling country 2 

curl --header "content-type: text/xml" -d @request2.xml http://localhost:8080/ws  > output.xml   && xmllint --format output.xml


## Calling weather 

curl --header "content-type: text/xml" -d @weatherrequest.xml http://localhost:8080/ws  > output.xml   && xmllint --format output.xml
## build it 
└─> docker  build   --platform linux/amd64 -t ivmckinl.azurecr.io/soapxsd:v2 .

### Deploy on ACI cos its easy peasy 

export RG="soapxsddemo"
export aciname="soapxsddemo"
export IMAGE="ivmckinl.azurecr.io/soapxsd:latest"
az group create --name $RG --location westeurope
az container create --resource-group $RG --name $aciname --image $IMAGE --dns-name-label $aciname --ports 8080
az container show --resource-group $RG --name $aciname --query "{FQDN:ipAddress.fqdn,ProvisioningState:provisioningState}" --out table

### WSDL can be found under 
http://soapxsddemo.westeurope.azurecontainer.io:8080/ws/wsdl.wsdl

### https://www.tutorialworks.com/wsdl/

