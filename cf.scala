import scala.io.StdIn._
import scala.collection._

object Main extends App {
    val line = readLine
    val map = mutable.Map[Char, Int]()
    for(i <- 0 until 4) {
        val c = line.charAt(i)
        if(map.contains(c)){
            map.update(c, map(c)+1)
        }else{
            map += (c -> 1)
        }
    }
    var max = map.valuesIterator.max
    var kind = map.size
    
    if (map.contains('*')) {
        kind -= 1
        max += 1
    }
    if(max == 4) {
        println("FourCard")
    } else if(max == 3) {
        println("ThreeCard")
    } else if(max == 2 && kind == 2) {
        println("TwoPair")
    } else if (max == 2) {
        println("OnePair")
    } else {
        println("NoPair")
    }
}
