import java.io.FileReader
import java.util.Scanner

fun main() {
    // 輸入字典
    val sc = Scanner(FileReader("words.txt"))
    var words: MutableList<String> = mutableListOf()        // 全部的字
    var re: MutableList<String> = mutableListOf()           // 刪除的字
    while (sc.hasNext()) {
        words.add(sc.next())
    }

    // 輸入參數
    val input = Scanner(System.`in`)
    val green: MutableList<String> = mutableListOf()        // 綠色字
    val greennum: MutableList<Int> = mutableListOf()        // 所在位置
    val yellow: MutableList<String> = mutableListOf()       // 黃色字
    val yellownum: MutableList<Int> = mutableListOf()       // 所在位置
    val gray: MutableList<String> = mutableListOf()         // 灰色字
    var cnt = 0
    while (cnt <= 2) {
        val term = input.next()
        if (term == "END") {
            cnt += 1
        } else if (cnt == 0) {
            green.add(term)
            greennum.add(input.nextInt())
        } else if (cnt == 1) {
            yellow.add(term)
            yellownum.add(input.nextInt())
        } else {
            gray.add(term)
        }
    }
    println("綠色字   : " + green.toString())
    println("所在位置 : " + greennum.toString())
    println("黃色字   : " + yellow.toString())
    println("所在位置 : " + yellownum.toString())
    println("灰色字   : " + gray.toString())

    // 篩選
    loop@ for (k in 0..(words.size-1)) {                      // 灌入不合的綠色值
        for (i in 0..(green.size - 1)) {
            if(words[k][greennum[i]] != green[i][0])  {
                re.add(words[k])
                continue@loop
            }
        }

        for (i in 0..(yellow.size - 1)) {               // 灌入不合黃色值
            cnt = 0
            for (t in 0..4) {
                if (t == yellownum[i]) {
                    if (words[k][t] == yellow[i][0]) {
                        re.add(words[k])
                        continue@loop
                    }
                } else if (words[k][t] == yellow[i][0]) cnt += 1
            }
            if (cnt == 0) {
                re.add(words[k])
                continue@loop
            }
        }

        for (i in 0..(gray.size-1)) {                   // 灌入不合灰色值
            for (t in 0..4) {
                if (words[k][t] == gray[i][0]) {
                    re.add(words[k])
                    continue@loop
                }
            }
        }
    }

    // 從words刪除不合的元素
    for (i in 0..re.size-1) {
        val remov = re[i]
        words.remove(remov)
    }

    // print 可能的英文單字
    println("--------可能的英文單字-----------")
    for (i in 0..words.size-1) println(words[i])
}