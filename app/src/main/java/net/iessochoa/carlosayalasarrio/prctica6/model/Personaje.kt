package net.iessochoa.carlosayalasarrio.prctica6.model

import java.sql.Date


data class Personaje(

    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val image: String,
    val created: Date

/*val episode: List<String>,
val location: Location,
val origin: Origin,
val url: String*/
)