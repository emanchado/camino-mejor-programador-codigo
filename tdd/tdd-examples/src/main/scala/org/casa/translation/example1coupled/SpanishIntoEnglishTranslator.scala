package org.casa.translation.example1coupled

class SpanishIntoEnglishTranslator {
  def translate(spanish: String) {
    println(spanish.split(' ').map(_ match {
      case "yo" => "I"
      case "soy" => "am"
      case _ => "mmmeh"
    }).mkString(" "))
  }
}
