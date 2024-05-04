package models.dao.entities

import org.squeryl.KeyedEntity

case class Product(id: String, title: String, price: Int) extends KeyedEntity[String]