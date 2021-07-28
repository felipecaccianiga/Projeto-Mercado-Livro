package com.mercadolivro.service

import com.mercadolivro.model.CustomerModel
import com.mercadolivro.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(
    val CustomerRepository: CustomerRepository //para a classe funcionar, é preciso de um CustomerRepository
) {
    //val customers = mutableListOf<CustomerModel>() //cria uma lista customers

    fun getAll(name: String?): List<CustomerModel> { //a função vai retornar os atributos descritos na customer model
        name?.let {
            //return customers.filter { it.name.contains(name, true) } //recebe-se por parametro um trecho de nome e esse .let verifica se o registro contem isso
            return CustomerRepository.findByNameContaining(it)
        }
        //return customers
        return CustomerRepository.findAll().toList()
    }
    fun create(customer: CustomerModel) { //função para criar um customer
        /*val id = if(customers.isEmpty()){ //se a lista estiver vazia, o valor 1 é atribuido ao id, senao, vai somando +1 ao id
            1
        }else{
            customers.last().id!!.toInt() + 1
        }
        customer.id = id
        customers.add(customer)*/ //adiciona nomes e emails na lista customers
        CustomerRepository.save(customer)//cria um customer e implementa na tabela do banco de dados
    }
    fun getById(id: Int): CustomerModel { //recebe a variavel passada no GetMapping (id)
        //return customers.filter { it.id == id }.first() //se o registro tiver algum id igual ao passado na url, ele é retornado
        return CustomerRepository.findById(id).get()
    }
    fun update(customer: CustomerModel) { //usa as informacoes do PutCustomerRequest
        /*customers.filter { it.id == customer.id }.first().let {
            it.name = customer.name     //com a variavel .let, podemos acessar o customer a partir do "it" e alocar o que for atualizado
            it.email = customer.email   //em sua respectiva variavel
            //a variavel let só é usada se a condicao "{it.id == id} for true*/
        if (!CustomerRepository.existsById(customer.id!!)){
            throw Exception()//se o customer nao existir, ele joga uma exception e para de rodar
        }
        CustomerRepository.save(customer)
    }
    fun delete(id: Int) { //recebe a variavel passada no GetMapping (id)
        //customers.removeIf { it.id == id } //o id é deletado se o do registro for igual ao da url, passada pelo usuario
        if (!CustomerRepository.existsById(id)){
            throw Exception()//se o customer nao existir, ele joga uma exception e para de rodar
        }
        CustomerRepository.deleteById(id)
    }
}