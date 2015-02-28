import scala.io.Source
object readlargetextfile {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(161); 
	val largeGraph = Source.fromFile("/Users/gmgilmore/Dropbox/ScalaDev/hsfridaygraphjobs/src/resources").getLines;System.out.println("""largeGraph  : Iterator[String] = """ + $show(largeGraph ))}
	
}
