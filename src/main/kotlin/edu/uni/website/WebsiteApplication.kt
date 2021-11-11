package edu.uni.website

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.io.FileInputStream
import java.io.FileNotFoundException


@SpringBootApplication
class WebsiteApplication
    fun main(args: Array<String>) {
        runApplication<WebsiteApplication>(*args)

        try {
            val serviceAccount = FileInputStream("src/main/resources/servicekey.json")
            val options = FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build()

            FirebaseApp.initializeApp(options)
        } catch (e: FileNotFoundException) {
            println("Service key not Set")
        }
    }