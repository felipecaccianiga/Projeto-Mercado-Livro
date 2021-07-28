package com.mercadolivro.repository

import com.mercadolivro.enums.BookStatus
import com.mercadolivro.model.BookModel
import com.mercadolivro.model.CustomerModel
import org.springframework.data.repository.CrudRepository

interface BookRepository: CrudRepository<BookModel, Int> { //interface pega como base o BookModel e o id como Int
    fun findByStatus(status: BookStatus): List<BookModel> //metodo para encontrar status "ATIVOS"

}