import java.security.KeyStore.TrustedCertificateEntry
import java.util.Scanner
import kotlin.random.Random
import kotlin.random.nextInt


fun randAns(): String{
    var ret = ""
    while (ret.length != 6) {
        val a = Random.nextInt(0..99)
        val b = Random.nextInt(0..99)
        val op = Random.nextInt(0..3).let{ "+-*/"[it] }
        when (op) {
            '+' -> ret = "$a+$b=${a+b}"
            '-' -> if (a >= b)
                ret = "$a-$b=${a-b}"
            '*' -> ret = "$a*$b=${a*b}"
            '/' -> if (b != 0 && a%b == 0)
                ret = "$a/$b=${a/b}"
        }
    }
    return ret
}



fun main() {
    val ans = randAns()
    //val guess = mutableListOf<Int>()
    val guess = Scanner(System.`in`).next()
    val colorMap = mutableMapOf<Int, String>(1 to "gray", 2 to "gray", 3 to "gray", 4 to "gray", 5 to "gray", 6 to "gray")

    println(colorMap)

    if (guess == ans) {
        println("你贏了!!")
        println("ans : $ans")
        println("guess : $guess")
    } else if(guess.length != 6) {
        println("長度不對")
    } else {
        var term = ' '
        var cnt = 0
        for (i in guess) {
            // 判斷有無負數、運算符相鄰、最後一格是否為運算符
            if (cnt == 0 && i in "+-*/=" ) {
                println("格式錯誤 : 第一格不能為運算符號")
                term = 'F'
                break
            } else if (i in "+-*/=" && term in "+-*/=") {
                println("格式錯誤 : 不能有負數 and 運算符號不能相鄰")
                term = 'F'
                break
            } else if (cnt == 5 && i in "+-*/") {
                println("格式錯誤 : 最後一格不能為運算符號")
                term = 'F'
                break
            }
            term = i
            cnt += 1
        }
        // 判斷等式相不相同 (在沒有負數的情況下)
        if (term != 'F'){
            println("無負數、運算符相鄰、最後一格為運算符")
            for (i in guess) :
        }
    }
    println(ans)
}

