package controllers

import com.google.inject.Inject
import models.Product
import models.services.LogService
import models.dto.ProductDTO
import models.services.ProductServiceImpl
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}

class ProductController @Inject()(val logService: LogService) extends Authorization {

  def list = authorize{ rc =>
    logService.log("Hello from ProductController")
    Ok(views.html.products.list(List(
      Product("product1", 20),
      Product("product2", 30),
      Product("product3", 40),
      Product("product4", 50),
      Product("product4", 60)
    )))
  private def productService: ProductServiceImpl = new ProductServiceImpl

  def getProducts(title: String): Action[List[ProductDTO]] = Action{
    Ok(productService.getProducts(title))
  }

  def addProduct(): Action[ProductDTO] = Action(parse.json[ProductDTO]){ rc =>
    Ok(Json.toJson(productService.addProduct(rc.body)))
  }

  def updateProduct(): Action[ProductDTO] = Action(parse.json[ProductDTO]){ rc =>
    Ok(Json.toJson(productService.updateProduct(rc.body)))
  }

  def deleteProduct(productId: String): Action[List[ProductDTO]] = Action{
    Ok(Json.toJson(productService.deleteProduct(productId)))
  }
}
