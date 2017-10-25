// WITH_NEW_INFERENCE

fun bar(x: Int): Int = x + 1

fun foo() {
    val x: Int? = null

    do {
        bar(<!TYPE_MISMATCH!>x<!>)
    } while (x == null)
    bar(<!DEBUG_INFO_SMARTCAST!>x<!>)
    
    val y: Int? = null
    do {
        bar(<!TYPE_MISMATCH!>y<!>)
    } while (y != null)
    bar(<!TYPE_MISMATCH, DEBUG_INFO_CONSTANT!>y<!>)
}
