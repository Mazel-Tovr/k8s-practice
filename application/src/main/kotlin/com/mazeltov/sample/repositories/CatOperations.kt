package com.mazeltov.sample.repositories

import com.mazeltov.sample.model.*
import org.springframework.data.jpa.repository.*
import org.springframework.stereotype.*

@Repository
interface CatOperations : JpaRepository<Cat, Long> {
    fun findByName(name: String): Cat?
}
