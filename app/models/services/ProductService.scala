package models.services

import models.dto.{ProductDTO, ProductItemDTO}
trait ProductService {
  def getProducts(filterByTitle: String): List[ProductDTO]
  def addProduct(product: ProductDTO): List[ProductDTO]
  def updateProduct(product: ProductDTO): List[ProductDTO]
  def deleteProduct(productId: String): List[ProductDTO]
}

class ProductServiceImpl extends ProductService {

  private var products: List[ProductDTO] = List(
    ProductDTO("1", "product1", 20, Map(
      "1" -> ProductItemDTO("1", 20, 2, isInStock = true),
      "2" -> ProductItemDTO("2", 20, 2, isInStock = true)
    )),
    ProductDTO(
      "2", "product2", 30, Map(
      "3" -> ProductItemDTO("3", 30, 2, isInStock = true),
      "4" -> ProductItemDTO("4", 30, 2, isInStock = true)
    ))
  )

  override def getProducts(filterByTitle: String): List[ProductDTO] = {
    filterByTitle match {
      case null => products
      case _ => products.filter(product => product.title == filterByTitle)
    }
  }

  override def addProduct(product: ProductDTO): List[ProductDTO] = {
    product :: products
  }

  override def updateProduct(productDTO: ProductDTO): List[ProductDTO] = {
    products = products.map(product => if (product.id == productDTO.id) productDTO else product)
    products
  }

  override def deleteProduct(productId: String): List[ProductDTO] = {
    products = products.filter(_.id != productId)
    products
  }
}
