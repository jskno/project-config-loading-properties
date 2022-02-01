package com.jskno.loading_properties.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "application.dynamo")
class DynamoConfigurationProperties(
    var customerTableName: String = "",
    var region: String = "",
    var endpoint: String = ""
)