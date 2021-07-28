package com.mercadolivro.controller

import com.mercadolivro.service.BookService
import com.mercadolivro.service.CustomerService
import com.mercadolivro.controller.request.PostBookRequest
import com.mercadolivro.extension.toBookModel
import com.mercadolivro.model.BookModel
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("book") //cria um caminho book na url
class BookController(
    val bookService: BookService,
    val customerService: CustomerService
){
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: PostBookRequest){
        val customer = customerService.getById(request.customerId)//pega o customer com esse valor "customerId"
        bookService.create(request.toBookModel(customer))
    }
    @GetMapping
    fun findAll(): List<BookModel> {
        return bookService.findAll()
    }
    @GetMapping("/active")
    fun findActives(): List<BookModel>{
        return bookService.findActives()
    }
    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): BookModel{
        return bookService.findById(id).orElseThrow()
    }
}