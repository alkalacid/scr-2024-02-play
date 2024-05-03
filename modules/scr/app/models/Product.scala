package models

case class Product(id: String, title: String, price: Int, item: Map[String, ProductItem])

case class ProductItem(id: String, price: Int, amount: Int, isInStock: Boolean)
