package controllers

import models.dto.ProductDTO
import models.services.ProductServiceImpl
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}

object ProductController extends Controller{

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
