package com.mercadolivro.controller.request

import com.mercadolivro.model.CustomerModel

//foi criado para nao pegar todas as informacoes do model, no caso o "id"

data class PostCustomerRequest(
    var name: String,
    var email: String
){
    fun toCustomerModel(): CustomerModel{
        return CustomerModel(name = this.name, email =  this.email)
    }
}