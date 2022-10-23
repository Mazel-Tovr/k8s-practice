package com.mazeltov.sample.endpoints

import org.springframework.http.*
import org.springframework.web.bind.annotation.*


@RestController
class EnvController {

    @GetMapping("\${api.env.rout}")
    fun getJasypt(): ResponseEntity<*> {
        return ResponseEntity(System.getProperty("jasypt.encryptor.password"), HttpStatus.OK)
    }

    @GetMapping("\${api.env.rout}/{name}")
    fun getNamed(@PathVariable("name") name: String): ResponseEntity<*> {
        return ResponseEntity(System.getProperty(name), HttpStatus.OK)
    }
}
