package com.jskno.loading_properties.service

import com.jskno.loading_properties.config.DynamoDbAsynClient
import com.jskno.loading_properties.config.MailServer
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.env.Environment
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct

@Service
class BankService {

    companion object {
        private val LOGGGER = LoggerFactory.getLogger(BankService::class.java)
    }

    @Value("\${default.bank.name}")
    private lateinit var bankName: String

    @Value("\${additional.bank.name}")
    private lateinit var additionalBankName: String

    @Value("\${profile.bank.location}")
    private lateinit var profileBankLocation: String

    @Autowired
    private lateinit var environment: Environment

    @Autowired
    private lateinit var printingService: PrintingService

    @Autowired
    private lateinit var mailServer: MailServer

    @Autowired
    private lateinit var dynamoDbAsynClient: DynamoDbAsynClient

    @PostConstruct
    fun loggingProperties() {
        LOGGGER.info("************************")
        LOGGGER.info("Default Bank Name: $bankName")
        LOGGGER.info("Additional Bank Name: $additionalBankName")
        LOGGGER.info("Profile Bank Location: $profileBankLocation")
        LOGGGER.info("Profile Bank Location: ${environment.getProperty("profile.bank.location")} (from Environment object)")
        printingService.print()
        mailServer.sendEmail()
        LOGGGER.info("Dynamo properties: ${dynamoDbAsynClient.region} - ${dynamoDbAsynClient.endpoint} - ${dynamoDbAsynClient.table}")
        LOGGGER.info("************************")

    }


}