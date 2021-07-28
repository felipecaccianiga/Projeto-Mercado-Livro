package com.mercadolivro.controller.request

//foi criado para nao pegar todas as informacoes do model, no caso o "id"

data class PutCustomerRequest(
    var name: String,
    var email: String
)