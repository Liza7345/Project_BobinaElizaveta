fun compressString(text: String): String {
    if (text.length <= 1)
        return text
    var result = ""
    var count = 1
    for (i in 0 until text.length - 1) {
        if (text[i] == text[i + 1]) {
            count++
        } else {
            result += text[i]
            if (count > 1)
                result += count
            count = 1

        }
    }
    result += text[text.length - 1]
    if (count > 1) {
        result += count
    }
    return result
}
fun countAndSortChars (text: String){
    val freqMap = text.groupingBy { it }.eachCount()
    val sortedKeys = freqMap.keys.sorted()
    for (ch in sortedKeys) {
        println("$ch - ${freqMap[ch]}")
    }
}
fun decimalToBinary(number: Int): String {
    var n = number
    var binary = ""
    while (n > 0){
        binary = (n%2).toString() + binary
        n /= 2
    }
    return binary
}
fun calculate(num1: Double, num2: Double, op:String): Double? {
    return when (op){
        "+" -> num1 + num2
        "-" -> num1 - num2
        "*" -> num1*num2
        "/" -> {
            if (num2 == 0.0){
                null
            }
            else num1/num2
        }
        else -> null
    }
}
fun stepen (n: Int, x: Int): Int? {
    if (x==0) {
        return if (n==0) 1 else null
    }
    if (x==1) {
        return if (n==1) 0 else null
    }
    if (n==1) {
        return 0
    }
    var p = 1
    var y = 0
    while (p <= n) {
        if (p==n) return y
        p*=x
        y++
    }
    return null
}
fun createCh (d1: Int, d2: Int): Int? {
    return when {
        d1 % 2 == 1 && d2 % 2 == 0 -> d2*10+d1
        d1 % 2 == 0 && d2 % 2 == 1 -> d1*10+d2
        d1 % 2 == 1 && d2 % 2 == 1 -> d2*10+d1
        else -> null
    }
}
fun main() {
    println("Введите строку: ")
    val str = readln()
    if (str.isEmpty()) {
        println ("Введена пустая строка")
        return
    }
    val result = compressString(str)
    println("Результат: $result")
    countAndSortChars(str)
    println("Введите натуральное число: " )
    val inputNum = readln()
    val number = inputNum.toIntOrNull()
    if (number == null || number < 0){
        println("Ошибка! Введено не натуральное число")
        return
    }
    val binary = decimalToBinary(number)
    println("Число $number В двоичной системе: $binary")

    println ("Введите числа и операции через пробел: " )
    val input = readln().trim().split(" ")
    if (input.size != 3){
        println("Error")
        return
    }
    val num1 = input[0].toDoubleOrNull()
    val num2 = input[1].toDoubleOrNull()
    val op = input[2]
    if (num1 == null || num2 == null){
        println("Ошибка")
        return
    }
    val calcResult = calculate(num1,num2,op)
    if (calcResult == null){
        println ("Ошибка!")
    }
    else {
        println ("$calcResult")
    }
    println ("Введите число n: ")
    val n = readln().toIntOrNull()
    println ("Введите основание степени x: ")
    val x = readln().toIntOrNull()
    if (n==null || x== null) {
        println ("Ошибка")
        return
    }
    val y = stepen(n,x)
    if (y!=null) {
        println ("Существует: $x^$y = $n")
    }
    else {
        println ("Не существует!")
    }
    println ("Введите первую цифру: ")
    val d1 = readln().toIntOrNull()
    println ("Введите вторую цифру: ")
    val d2 = readln().toIntOrNull()
    if (d1 == null || d2 == null || d1 !in 0..9 || d2 !in 0..9 || d1 == d2) {
        println ("Ошибка")
        return
    }
    val ch = createCh (d1,d2)
    if (ch != null) {
        println ("Существует: $ch")
    }
    else {
        println ("Невозможно")
    }
}
