package com.jskno.loading_properties.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DynamoClientConfig(private val dynamoConfigurationProperties: DynamoConfigurationProperties) {

    @Bean
    fun dynamoDBAsynClient(): DynamoDbAsynClient {
        with(dynamoConfigurationProperties) {
            return DynamoDbAsynClient(region, endpoint, customerTableName)
        }
    }
}

data class DynamoDbAsynClient(
    val region: String, val endpoint: String, val table: String
)