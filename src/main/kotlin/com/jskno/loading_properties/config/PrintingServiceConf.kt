package com.jskno.loading_properties.config

import com.jskno.loading_properties.service.PrintingJustLogginService
import com.jskno.loading_properties.service.PrintingService
import com.jskno.loading_properties.service.PrintingToA4ServiceImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@Configuration
class PrintingServiceConf {

    @Bean
    @Profile("dev")
    fun devPrintingService(): PrintingService = PrintingJustLogginService()

    @Bean
    @Profile("prod")
    fun prodPrintingService(): PrintingService = PrintingToA4ServiceImpl()
}