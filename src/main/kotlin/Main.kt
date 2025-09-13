
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

    fun main() {
        println("Введите строку: ")
        val str = readln()
        if (str.isEmpty()) {
            println ("Вы ввели пустую строку!")
            return
        }
        val result = compressString(str)
        println("Результат: $result")
    }