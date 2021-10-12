fun remainderLenght(n: Int): Int {
    var remainder = Array<Boolean>(1000, {false})
    var len = 0
    var numerator = 1

    while (!remainder[numerator % n] && numerator % n != 0 ) {
        remainder[numerator] = true
        numerator *= 10
        numerator %= n
        len += 1
    }

    return len
}


fun main() {
    var max_len = -1
    var number = -1
    var cur_len = 0

    for (i in 1..999) {
        cur_len = remainderLenght(i)
        if (cur_len > max_len) {
            max_len = cur_len
            number = i
        }
    }

    println("number: $number")
    println("fraction period: $max_len")
}

