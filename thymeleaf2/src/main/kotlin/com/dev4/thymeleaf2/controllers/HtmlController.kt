package com.dev4.thymeleaf2.controllers

//import com.dev4.thymeleaf2.services.MessageService
//import com.dev4.thymeleaf2.models.Message
import com.dev4.thymeleaf2.models.CreateMessage
import com.dev4.thymeleaf2.models.Message
import com.dev4.thymeleaf2.models.UpdateMessage
import com.dev4.thymeleaf2.services.MessageService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping

@Controller
class HtmlController() {

    @Autowired
    lateinit var service: MessageService

    @GetMapping("/")
    fun index(model:Model): String {
        model.addAttribute("name", "David")
        return "index"
    }

    @GetMapping("/message")
    fun listMessages(model:Model): String {
        var list: List <Message> = service.getMessages()
        model.addAttribute("list", list)
        model.addAttribute("message", CreateMessage()) // werkt niet van entity
        return "messages"
    }

    @PostMapping("/addMessage")
    fun addMessages(@ModelAttribute("message") createMessage: CreateMessage, model: Model): String {
        service.addMessage(Message(createMessage.author, createMessage.message))
        return "redirect:/message"
    }

    @GetMapping("/deleteMessage{id}")
    fun deleteMessages(id: Long, model: Model): String {
        service.deleteMessage(id)
        return "redirect:/message"
    }

    @PostMapping("/putMessage{id}")
    fun putMessages(@ModelAttribute("putMessage") updateMessage: CreateMessage, id: Long, model: Model): String {
        println(updateMessage)
        println(id)
        service.updateMessage(UpdateMessage(id, updateMessage.author, updateMessage.message))
        return "redirect:/message"
    }
}