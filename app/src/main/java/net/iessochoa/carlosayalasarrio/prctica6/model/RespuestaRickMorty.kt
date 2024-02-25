package net.iessochoa.carlosayalasarrio.prctica6.model

import com.google.gson.annotations.SerializedName

data class RespuestaRickMorty(
    val info: Info,

    @SerializedName("results")
    val personajes: List<Personaje>
)