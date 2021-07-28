package com.mercadolivro.model

import javax.persistence.*


//classe para criar o modelo de cliente, com id, nome e email

@Entity(name = "customer") //referencia a tabela "customer" criada no MySql
data class CustomerModel(
    @Id //informa que o id é um Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //informa que o valor do id é gerado automaticamente
    var id: Int? = null,
    @Column //informa que as duas variaveis sao colunas no banco de dados
    var name: String,
    @Column
    var email: String
)