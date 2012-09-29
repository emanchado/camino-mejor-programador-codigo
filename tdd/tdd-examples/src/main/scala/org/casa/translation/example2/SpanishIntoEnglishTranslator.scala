package org.casa.translation.example2

class SpanishIntoEnglishTranslator {
  def translate(spanish: String): String =
    spanish.split(' ').map(_ match {
      case "yo" => "I"
      case "soy" => "am"
      case _ => "mmmeh"
    }).mkString(" ")
}