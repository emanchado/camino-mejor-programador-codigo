package org.casa.translation.example3

class SpanishIntoEnglishTranslator(val splitter: (String) => Seq[String]) {
  def translate(spanish: String): String = {
    val split = splitter(spanish)
    split.map(_ match {
      case "yo" => "I"
      case "soy" => "am"
      case _ => "mmmeh"
    }).mkString(" ")
  }
}