fun main() {
    println("Введите строку: ")
    val str = readln()
    println()
    var result = ""
    var count =1
    for (i in str.indices) {
        if (i < str.length -1 && str[i] == str[i+1]) {
            count++
        } else {
            result += str[i]
            if (count > 1) result += count
            count=1

        }
    }
    println(result)
}
