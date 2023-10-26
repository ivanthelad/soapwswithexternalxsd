# API Management service-specific details
APIMServiceName="simpleapim"
ResourceGroupName="APIM"

# API-specific details
APIId="order-api"
APIPath="order"
SpecificationFormat="Wsdl"
SpecificationURL="http://soapxsddemo.westeurope.azurecontainer.io:8080/ws/wsdl.wsdl"

WsdlServiceName="OrdersAPI"
WsdlEndpointName="basic"

az apim api import --path $APIPath --resource-group $ResourceGroupName \
    --service-name $APIMServiceName --api-id $APIId \
    --specification-format $SpecificationFormat --specification-path /Users/ivmckinl/projects/randv/soapwswithexternalxsd/src/main/resources/example.wsdl \
    --wsdl-service-name $WsdlServiceName --wsdl-endpoint-name $WsdlEndpointName
# Import API
exit
az apim api import --path $APIPath --resource-group $ResourceGroupName \
    --service-name $APIMServiceName --api-id $APIId \
    --specification-format $SpecificationFormat --specification-url $SpecificationURL \
    --wsdl-service-name $WsdlServiceName --wsdl-endpoint-name $WsdlEndpointName