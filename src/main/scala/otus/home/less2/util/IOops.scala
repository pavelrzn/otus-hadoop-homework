package otus.home.less2.util

import java.io.PrintWriter

import scala.io.Source
import scala.util.Using

object IOops {

  def readFromUrl(url: String): Option[String] = {
    Using(Source.fromURL(url)) { _.mkString }
      .toOption
  }

  def writeToFile(fileName: String, string: String): Unit = {
    Using(new PrintWriter(fileName)) {
      _.write(string)
    }
  }

}
