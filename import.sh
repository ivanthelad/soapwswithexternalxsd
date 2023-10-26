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

# Import API
az apim api import --path $APIPath --resource-group $ResourceGroupName \
    --service-name $APIMServiceName --api-id $APIId \
    --specification-format $SpecificationFormat --specification-url $SpecificationURL \
    --wsdl-service-name $WsdlServiceName --wsdl-endpoint-name $WsdlEndpointName