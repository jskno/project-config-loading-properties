package com.jskno.loading_properties.service

import org.slf4j.LoggerFactory

class PrintingToA4ServiceImpl: PrintingService {

    companion object {
        private val LOGGER = LoggerFactory.getLogger(PrintingToA4ServiceImpl::class.java)
    }

    override fun print() {
        LOGGER.info("Printing in real A4 format to production printers")
    }
}