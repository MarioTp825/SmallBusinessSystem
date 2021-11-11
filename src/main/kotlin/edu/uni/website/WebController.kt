package edu.uni.website

import com.google.gson.Gson
import edu.uni.website.interfaces.DataBaseConnector
import edu.uni.website.models.MailSchema
import io.grpc.netty.shaded.io.netty.handler.codec.http.HttpHeaders.getHeader
import io.netty.handler.codec.http.HttpHeaders.getHeader
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import javax.servlet.http.HttpServletRequest


@Controller
class WebController {
    @Autowired private lateinit var dataBase: DataBaseConnector

    @GetMapping("/")
    fun index(model: Model) = "redirect:/home"

    @GetMapping("/home")
    fun home (model: Model): String {
        val products = dataBase.getAllProducts()
        model["title"] = "Inicio"
        model["sendMail"] = MailSchema.Email("","","","")
        model["products"] = products
        return "index"
    }

    @PostMapping("/sendMessage")
    fun sendMessage(@ModelAttribute sendMail: MailSchema.Email, model: Model): String {
        val gson = Gson()
        println("Mail: ${gson.toJson(sendMail)}")
        return "redirect:/home"
    }
}