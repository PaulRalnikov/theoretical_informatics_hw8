import org.example.MyArithmeticsParser
import kotlin.test.Test
import kotlin.test.assertEquals

internal class Test {

    private fun testExpressionList(testCases: List<Pair<String, String>>) {
        val parser = MyArithmeticsParser()
        for (testCase in testCases) {
            assertEquals(testCase.second, parser.parse(testCase.first))
        }
    }

    @Test
    fun testMath() {
        testExpressionList(
            listOf(
                ("2+3;" to "2+3=5;"),
                ("3*7;" to "3*7=21;"),
                ("2+3*7;" to "2+3*7=23;"),
                ("(3+7)*(0+2);" to "(3+7)*(0+2)=20;"),
                ("(1+4)*(2*3);" to "(1+4)*(2*3)=30;"),
                ("(3)+(1);" to "(3)+(1)=4;"),
                ("11*3+15;" to "11*3+15=48;"),
            )
        )
    }

    @Test
    fun testAssignment() {
        testExpressionList(
            listOf(
                ("a=(2+1)*(1*3);" to "a=9;"),
                ("b=a;" to "b=9;"),
                ("a+b;" to "a+b=18;"),
                ("a*b+1;" to "a*b+1=82;"),
                ("a=b*2+1;" to "a=19;"),
                ("a*3;" to "a*3=57;"),
            )
        )
    }

    @Test
    fun testSpecialCases() {
        val errorMessage = "Parse error"

        testExpressionList(
            listOf(
                ("a;" to errorMessage),
                ("a=2;" to "a=2;"),
                ("a" to errorMessage),
                ("a=a;" to "a=2;"),
                ("a=b;" to errorMessage),
                ("b=c;" to errorMessage),
                ("0a;" to errorMessage),
                ("#;" to errorMessage),
                ("asdasd10;" to errorMessage),
                (";" to errorMessage),
                ("a=1;=" to errorMessage),
                ("a=;" to errorMessage),
            )
        )
    }
}