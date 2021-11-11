package edu.uni.website.repositories

import com.google.firebase.cloud.FirestoreClient
import edu.uni.website.interfaces.DataBaseConnector
import edu.uni.website.models.ProductsSchema.Product
import org.springframework.stereotype.Component

@Component
class FirebaseRepository: DataBaseConnector {
    override fun getAllProducts(): List<Product> {
        val storage = FirestoreClient.getFirestore()
        val products = storage.collection("servicios").whereEqualTo("disponible", true)
        val documents = products.get().get()
        if (documents.isEmpty) return mutableListOf()
        val response = mutableListOf<Product>()
        for (doc in documents) {
            val ans = doc.toObject(Product::class.java)
            response.add(ans)
        }
        return response
    }
}