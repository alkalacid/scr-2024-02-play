package module

import di.AppModule
import models.dao.repositories.{PhoneRecordRepository, PhoneRecordRepositoryCRUD, PhoneRecordRepositoryCRUDImpl, PhoneRecordRepositoryImpl, SongRepository, SongRepositoryImpl}
import models.services.{LogService, LogServiceImpl, ProductService, ProductServiceImpl}

class ScrModule extends AppModule{
  override def configure(): Unit = {
    bindSingleton[LogService, LogServiceImpl]
    bindSingleton[PhoneRecordRepository, PhoneRecordRepositoryImpl]
    bindSingleton[SongRepository, SongRepositoryImpl]
    bindSingleton[PhoneRecordRepositoryCRUD, PhoneRecordRepositoryCRUDImpl]
    bindSingleton[ProductService, ProductServiceImpl]

  }
}
