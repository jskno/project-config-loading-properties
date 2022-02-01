package com.jskno.loading_properties.config

import org.slf4j.LoggerFactory
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "validate")
@PropertySource("classpath:property-validation.properties")
class MailServer(
    val propertiesMap: Map<String, String>,
    var address: String = "") {

    companion object {
        private val LOGGER = LoggerFactory.getLogger(MailServer::class.java)
    }

    fun sendEmail() {
        LOGGER.info("Sending this email content: $propertiesMap" )
        LOGGER.info("To the address: $address" )
    }
}