import scala.io.Source
object readlargetextfile {
	val largeGraph = Source.fromFile("/Users/gmgilmore/Dropbox/ScalaDev/hsfridaygraphjobs/src/resources").getLines
                                                  //> java.io.FileNotFoundException: /Users/gmgilmore/Dropbox/ScalaDev/hsfridaygra
                                                  //| phjobs/src/resources (Is a directory)
                                                  //| 	at java.io.FileInputStream.open(Native Method)
                                                  //| 	at java.io.FileInputStream.<init>(FileInputStream.java:138)
                                                  //| 	at scala.io.Source$.fromFile(Source.scala:91)
                                                  //| 	at scala.io.Source$.fromFile(Source.scala:76)
                                                  //| 	at scala.io.Source$.fromFile(Source.scala:54)
                                                  //| 	at readlargetextfile$$anonfun$main$1.apply$mcV$sp(readlargetextfile.scal
                                                  //| a:3)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at readlargetextfile$.main(readlargetextfile.scala:2)
                                                  //| 	at readlargetextfile.main(readlargetextfile.scala)
	
}