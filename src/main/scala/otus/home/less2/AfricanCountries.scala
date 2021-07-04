package otus.home.less2

import org.json4s._
import org.json4s.jackson.JsonMethods._
import otus.home.less2.util.IOops._
import otus.home.less2.util.JsonOps._


object AfricanCountries extends App {
  val outFile = args(0)

  case class Country(name: String, capital: Option[String], area: Int)

  val jsonOpt = readFromUrl("https://raw.githubusercontent.com/mledoze/countries/master/countries.json")
  val allCountries: List[JValue] = jsonOpt.map(parse(_).children).getOrElse(Nil)

  val africanCountries = getAfricanCountries(allCountries, "Africa")
  val topTenAria = getTopAria(10, africanCountries)

  writeToFile(outFile, ser(topTenAria))


  private def getTopAria(count: Int, countries: List[Country]): List[Country] = {
    countries.sortWith(_.area > _.area)
      .take(count)
  }
}
