package models.dao.entities

import org.squeryl.KeyedEntity

case class ProductItem(id: String, price: Int, amount: Int, isInStock: Boolean, productId: String) extends KeyedEntity[String]