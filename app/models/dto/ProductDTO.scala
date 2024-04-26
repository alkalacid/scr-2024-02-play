package models.dto

case class ProductDTO(id: String, title: String, price: Int, items: Map[String, ProductItemDTO])