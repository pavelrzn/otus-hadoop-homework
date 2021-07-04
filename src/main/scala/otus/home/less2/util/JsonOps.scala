package otus.home.less2.util

import org.json4s.jackson.Serialization.writePretty
import org.json4s.{DefaultFormats, FieldSerializer, JValue}
import otus.home.less2.AfricanCountries.Country

object JsonOps {
  implicit val formats = DefaultFormats + FieldSerializer[Country]()

  def getAfricanCountries(list: List[JValue], region: String): List[Country] = {
    list
      .filter(jV => (jV \ "region").extract[String] == region)
      .map(jValue =>
        Country(
          (jValue \ "name" \ "official").extract[String],
          (jValue \ "capital").extract[List[String]].headOption,
          (jValue \ "area").extract[Int])
      )
  }

  def ser(list: List[Country]): String = writePretty(list)

}
