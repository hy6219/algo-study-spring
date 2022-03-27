import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader
import java.util.*

fun main(args: Array<String>) {
    System.setIn(FileInputStream("input.txt"))
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    val N = st.nextToken().toInt()

    val pq = PriorityQueue<Int>(kotlin.Comparator { a, b ->
        val aa = Math.abs(a)
        val bb = Math.abs(b)
        if (aa == bb)
            if (a < b) return@Comparator -1
            else return@Comparator 1
        return@Comparator aa - bb
    })

    for (i in 0 until N) {
        st = StringTokenizer(br.readLine())
        val x = st.nextToken().toInt()
        if (x == 0) {
            if (pq.size == 0) {
                println("0")
            } else {
                val value = pq.poll()
                println(value)
            }
        } else {
            pq.offer(x)
        }
    }
}