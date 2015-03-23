package hsfridaygraphjobs

import java.io.File

import scala.io.Source

/**
 * Created by gmgilmore on 3/20/15.
 */
object Wordplay extends App{

  val lines = Source.fromFile(new File("src/resources/sowpods.txt")).getLines

  val anagramsThing:Map[Map[Char, Int],Set[WordLetters]] = lines.foldLeft(Map[Map[Char, Int], Set[WordLetters]]())(foo)

  println((anagramsThing.filter(_._2.size > 1) map {case (m, wl) => m.foldLeft(0)(_+_._2) -> wl}).toIndexedSeq.sortBy(-_._1).take(1))

//  val letterDictionary:Map[Char, WordLetters] = lines.foldLeft(Map[Char, WordLetters]())(foo2)
//  println((letterDictionary.toVector.sortBy(-_._2.word.length).take(1)))

  def foo(m: Map[Map[Char, Int], Set[WordLetters]], w:String) =  {
    if (w.nonEmpty){
      val trimWord = w.trim.toLowerCase
      val wl = WordLetters(trimWord)
      if (m.contains(wl.letterCount)) m + (wl.letterCount -> (m(wl.letterCount) + wl))
      else m + (wl.letterCount -> Set(wl))
    }
    else m
  }

  def foo2(m: Map[Char, WordLetters], w:String):Map[Char, WordLetters] =  {
    if (w.nonEmpty){
      val trimWord = w.trim.toLowerCase
      val wl = WordLetters(trimWord)
      var tempMap: Map[Char, WordLetters] = m
      wl.letterCount.filter(_._2 > 0).foreach { case (l, c) => {
        if (tempMap.contains(l)) {
          if (tempMap(l).letterCount(l) < c) tempMap = tempMap + (l -> wl)
        }
        else tempMap = tempMap + (l -> wl)
        }
      }
      tempMap
    }
    else m
  }

}

case class WordLetters(word:String){
  val letterCount:Map[Char, Int] = {
    var letterDictionary:Map[Char, Int] = ("abcdefghijljklmnopqurstuvwxyz" map (l => (l,0))).toMap
    word.foreach(l => letterDictionary = letterDictionary + (l -> (letterDictionary(l) + 1)))
    letterDictionary
  }

  val wordHash = {
    letterCount.toIndexedSeq.sortBy(_._1).foldLeft(""){case (s, (l,c)) => s + s"$l + ${if (c <10) s"0$c" else c}"}
  }
}

