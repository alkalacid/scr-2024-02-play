package controllers

import com.google.inject.Inject
import models.Product
import models.dao.entities.Product
import models.services.LogService
import models.services.ProductServiceImpl
import play.api.libs.json.Json
import play.api.mvc.Action

class ProductController @Inject()(val logService: LogService, val productService: ProductServiceImpl) extends Authorization {

  def getProducts(title: String): Action[List[Product]] = Action{
    Ok(productService.getProducts(title))
  }

  def addProduct(): Action[Product] = Action(parse.json[Product]){ rc =>
    Ok(Json.toJson(productService.addProduct(rc.body)))
  }

  def updateProduct(): Action[Product] = Action(parse.json[Product]){ rc =>
    Ok(Json.toJson(productService.updateProduct(rc.body)))
  }

  def deleteProduct(productId: String): Action[List[Product]] = Action{
    Ok(Json.toJson(productService.deleteProduct(productId)))
  }
}
