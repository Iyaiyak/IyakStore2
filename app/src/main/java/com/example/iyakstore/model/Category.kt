package com.example.iyakstore.model

class Category {

    var id: Int
    var name:String
    var photo: String

    constructor(id: Int, name: String, photo: String) {
        this.id = id
        this.name = name
        this.photo = photo
    }
}