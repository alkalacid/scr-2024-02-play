package models.services

import com.google.inject.Inject
import models.dao.entities.{Product, ProductItem}
import models.dao.repositories.ProductRepository

trait ProductService {
  def getProducts(filterByTitle: String): List[Product]
  def addProduct(product: Product): Product
  def updateProduct(product: Product): Product
  def deleteProduct(productId: String): List[Product]
}

class ProductServiceImpl @Inject()(val productRepository: ProductRepository) extends ProductService {

  override def getProducts(filterByTitle: String): List[Product] = {
    filterByTitle match {
      case null => productRepository.list()
      case _ => productRepository.findByTitle(filterByTitle)
    }
  }

  override def addProduct(product: Product): Product = {
    productRepository.insert(product)
    product
  }

  override def updateProduct(productDTO: Product): Product = {
    productRepository.update(productDTO)
    productDTO
  }

  override def deleteProduct(productId: String): List[Product] = {
    productRepository.delete(productId)
    productRepository.list()
  }
}
