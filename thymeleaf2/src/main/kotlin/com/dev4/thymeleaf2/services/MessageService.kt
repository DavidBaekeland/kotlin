package com.dev4.thymeleaf2.services

import com.dev4.thymeleaf2.models.Message
import com.dev4.thymeleaf2.models.UpdateMessage
import com.dev4.thymeleaf2.repositories.MessageRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MessageService()  {
    @Autowired
    lateinit var repository: MessageRepository


    fun getMessages(): List<Message>  {
        return repository.findAll()
    }

    fun addMessage(message: Message): Message  {
        return repository.save(message)
    }

    fun deleteMessage(id: Long)  {
        return repository.deleteById(id)
    }

    fun updateMessage(updateMessage: UpdateMessage)  {
        var message: Message = repository.getById(updateMessage.id)
        println(message)
        message.message = updateMessage.message
        message.author = updateMessage.author
        repository.save(message)
    }

}
