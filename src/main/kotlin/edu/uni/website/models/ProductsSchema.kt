package edu.uni.website.models

import com.google.gson.annotations.SerializedName
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.data.annotation.Id

sealed class ProductsSchema {
    @EntityScan("servicios")
    data class Product (
        @Id var id: Int? = 0,
        var nombre : String? = "",
        var descripcion : String? = "",
        var resumen : String? = "",
        var categoria : String? = "",
        var precio : Double? = 0.0,
        var imagen : String? = "",
        var disponible : Boolean? = false
    )
}
