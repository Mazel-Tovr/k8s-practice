package com.mazeltov.sample.endpoints

import com.mazeltov.sample.model.*
import com.mazeltov.sample.repositories.*
import jdk.jfr.*
import org.springframework.beans.factory.annotation.*
import org.springframework.http.*
import org.springframework.http.MediaType.*
import org.springframework.web.bind.annotation.*

@RestController
class CatController {

    @Autowired
    private lateinit var catOperations: CatOperations

    @PostMapping("\${api.cat.rout}", consumes = [APPLICATION_JSON_VALUE], produces = [APPLICATION_JSON_VALUE])
    fun createCat(@RequestBody catDto: CatDto): ResponseEntity<*> {
        return ResponseEntity(catOperations.save(catDto.toCat()), HttpStatus.CREATED)
    }

    @GetMapping("\${api.cat.rout}/{name}", produces = [APPLICATION_JSON_VALUE])
    fun getCatByName(@PathVariable("name") name: String): ResponseEntity<*> {
        return catOperations.findByName(name)?.toDto()?.let {
            ResponseEntity(it, HttpStatus.OK)
        } ?: ResponseEntity("Cat $name not found", HttpStatus.NOT_FOUND)
    }

}
