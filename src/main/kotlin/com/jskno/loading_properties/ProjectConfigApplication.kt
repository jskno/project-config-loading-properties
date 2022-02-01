package com.jskno.loading_properties

import com.jskno.loading_properties.config.DynamoConfigurationProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.PropertySource
import org.springframework.context.annotation.PropertySources

@SpringBootApplication
@PropertySource(
    "/additional-file.properties"
)
@EnableConfigurationProperties(DynamoConfigurationProperties::class)
class ProjectConfigLoadingPropertiesApplication

fun main(args: Array<String>) {
    runApplication<ProjectConfigLoadingPropertiesApplication>(*args)
}
