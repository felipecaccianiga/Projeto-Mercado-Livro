package com.mercadolivro.repository

import com.mercadolivro.model.CustomerModel
import org.springframework.data.repository.CrudRepository

interface CustomerRepository: CrudRepository<CustomerModel, Int> { //interface pega como base o CustomerModel e o id como Int
    fun findByNameContaining(name: String): List<CustomerModel>
}