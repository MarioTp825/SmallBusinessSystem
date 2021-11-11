package edu.uni.website.interfaces

import edu.uni.website.models.ProductsSchema
import org.springframework.stereotype.Component

@Component
interface DataBaseConnector {
    fun getAllProducts(): List<ProductsSchema.Product>
}