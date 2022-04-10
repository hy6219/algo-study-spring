import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader
import java.util.*

fun main(args: Array<String>) {
    System.setIn(FileInputStream("input.txt"))
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    var N = st.nextToken().toInt()

    // solution 1. greedy
    var ret = 0
    while (N >= 0) {
        if (N % 5 == 0) {
            ret += (N / 5)
            println(ret)
            return
        }
        N -= 3
        ret++
    }

    println(-1)

    // solution 2. dp
//    val arr = Array<Int>(N + 1) { 0 }
//    arr[3] = 1
//    arr[5] = 1
//
//    //런타임 에러 (ArrayIndexOutOfBounds)
//    for (i in 6..N) {
//        if (arr[i - 3] > 0) {
//            arr[i] = arr[i - 3] + 1
//        }
//
//        if (arr[i - 5] > 0) {
//            arr[i] = if (arr[i] > 0) {
//                min(arr[i], arr[i - 5] + 1) // 이 경우를 모르겠음
//            } else {
//                arr[i - 5] + 1
//            }
//        }
//    }
//
//    if (arr[N] == 0) {
//        println("-1")
//    } else {
//        println(arr[N])
//    }
}