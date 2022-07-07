package com.mazeltov.sample.util

import org.slf4j.*
import org.springframework.beans.factory.annotation.*
import org.springframework.beans.factory.config.*
import org.springframework.stereotype.*

@Component
class BeanPostProcessorForLogEnvVariable : BeanPostProcessor {

    @Volatile
    private var counter = 0

    private val logger = LoggerFactory.getLogger(BeanPostProcessorForLogEnvVariable::class.java)

    @Value("\${POSTGRES_HOST}")
    lateinit var host: String

    var port: Int = 0
        @Value("\${POSTGRES_PORT}")
        set

    @Value("\${POSTGRES_DB_NAME}")
    lateinit var name: String

    @Value("\${POSTGRES_USER}")
    lateinit var user: String
    @Value("\${POSTGRES_PASSWORD}")
    lateinit var password: String


    override fun postProcessBeforeInitialization(bean: Any, beanName: String): Any? {
        counter = counter.inc()
        if (counter == 1) {
            logger.info("DB URL jdbc:postgresql://$host:$port/$name?useUnicode=true&serverTimezone=UTC")
            logger.info("User name: $user ; Password: $password")
        }
        return super.postProcessBeforeInitialization(bean, beanName)
    }
}
