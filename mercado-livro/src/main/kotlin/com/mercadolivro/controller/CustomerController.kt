package com.mercadolivro.controller

import com.mercadolivro.service.CustomerService
import com.mercadolivro.controller.request.PostCustomerRequest
import com.mercadolivro.controller.request.PutCustomerRequest
import com.mercadolivro.extension.toCustomerModel
import com.mercadolivro.model.CustomerModel
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("customer") //cria um caminho customer
class CustomerController(
    val CustomerService: CustomerService
) {
    @GetMapping
    fun getAll(@RequestParam name: String?): List<CustomerModel> { //a função vai retornar os atributos descritos na customer model
        return CustomerService.getAll(name)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //quando esse endpoint for chamado, o status created vai aparecer como resposta da requisição
    fun create(@RequestBody customer: PostCustomerRequest) { //função para criar um customer
        CustomerService.create(customer.toCustomerModel())
    }

    @GetMapping("/{id}") //recebe o id na url do postman
    fun getCustomer(@PathVariable id: Int): CustomerModel { //recebe a variavel passada no GetMapping (id)
        return CustomerService.getById(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) //retorna um "no content"
    fun update(@PathVariable id: Int, @RequestBody customer: PutCustomerRequest) { //usa as informacoes do PutCustomerRequest
        CustomerService.update(customer.toCustomerModel(id))
    }

    @DeleteMapping("/{id}") //recebe o id na url do postman
    @ResponseStatus(HttpStatus.NO_CONTENT) //retorna um "no content"
    fun delete(@PathVariable id: Int) { //recebe a variavel passada no GetMapping (id)
        CustomerService.delete(id)
    }
}