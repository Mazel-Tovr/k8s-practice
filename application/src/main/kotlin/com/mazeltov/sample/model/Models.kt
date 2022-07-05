package com.mazeltov.sample.model

import com.mazeltov.sample.util.*
import javax.persistence.*

@Entity
@Table(name = "cat")
data class Cat(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_id")
    var id: Long,
    var name: String,
    var color: String,
    var description: String = "",
    var weight: Int,
)

@NoArg
data class CatDto(
    var name: String,
    var color: String,
    var description: String = "",
    var weight: Int,
)

fun CatDto.toCat() = Cat(id = 0, name = name, color = color, description = description, weight = weight)
fun Cat.toDto() = CatDto(name = name, color = color, description = description, weight = weight)
