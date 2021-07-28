package com.mercadolivro.controller.request

import com.fasterxml.jackson.annotation.JsonAlias
import java.math.BigDecimal

data class PostBookRequest (
    var name: String,
    var price: BigDecimal,
    @JsonAlias("customer_id") //quando recebermos um customer_id, ele vai ser referenciado ao customerId do PostBook
    var customerId: Int
)