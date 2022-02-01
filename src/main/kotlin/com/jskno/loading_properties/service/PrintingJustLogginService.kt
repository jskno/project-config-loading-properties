package com.jskno.loading_properties.service

import org.slf4j.LoggerFactory

class PrintingJustLogginService: PrintingService {

    companion object {
        private val LOGGER = LoggerFactory.getLogger(PrintingToA4ServiceImpl::class.java)
    }
    override fun print() {
        LOGGER.info("Just logging for dev environment")
    }
}