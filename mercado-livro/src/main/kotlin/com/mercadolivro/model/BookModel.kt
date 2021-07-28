package com.mercadolivro.model

import com.mercadolivro.enums.BookStatus
import java.math.BigDecimal
import javax.persistence.*


//classe para criar o modelo de cliente, com id, nome e email

@Entity(name = "book") //referencia a tabela "customer" criada no MySql
data class BookModel(
    @Id //informa que o id é um Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //informa que o valor do id é gerado automaticamente
    var id: Int? = null,

    @Column //informa que as duas variaveis sao colunas no banco de dados
    var name: String,

    @Column
    var price: BigDecimal, //especifico para valores monetarios

    @Column
    @Enumerated(EnumType.STRING)// indica que será passado um texto
    var status: BookStatus? = null,

    @ManyToOne
    @JoinColumn(name = "customer_id")//referencia a variavel para a coluna customer_id
    var customer: CustomerModel? = null
)