import org.example.ArithmeticsParserListener
import org.example.MyArithmeticsParser


fun main() {


    val parser = MyArithmeticsParser()
    while (true) {
        println("Enter string (if you want to stop, enter word \"stop\" (without commas):")
        val inputString = readln();
        if (inputString == "stop")
            break
        println(parser.parse(inputString))
    }
    return
}