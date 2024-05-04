package models.dao.repositories

import models.dao.entities.Product
import models.dao.schema.ProductSchema

trait ProductRepository {
  def list(): List[Product]
  def findByTitle(title: String): List[Product]
  def insert(product: Product): Unit
  def update(product: Product): Unit
  def delete(id: String): Unit
}

class ProductRepositoryImpl extends ProductRepository{
  val products = ProductSchema.products

  import org.squeryl.PrimitiveTypeMode._

  override def list(): List[Product] = transaction(from(products)(r => select(r)).toList)
  override def findByTitle(title: String): List[Product] =
    transaction(from(products)(r => where(r.title === title) select(r) ).toList)
  override def insert(product: Product): Unit =
    transaction(products.insert(product))
  override def update(product: Product): Unit =
    transaction(products.update(product))
  override def delete(id: String): Unit =
    transaction(products.deleteWhere(_.id === id))
}
