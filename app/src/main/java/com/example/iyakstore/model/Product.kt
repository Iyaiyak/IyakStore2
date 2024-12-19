package com.example.iyakstore.model

class Product {

    var id: Int
    var name: String
    var price: Int
    var description: String
    var photo: String

    constructor(id: Int, name: String, price: Int, description: String, photo: String) {
        this.id = id
        this.name = name
        this.price = price
        this.description = description
        this.photo = photo
    }
}