// WITH_NEW_INFERENCE

// !DIAGNOSTICS: -DEBUG_INFO_SMARTCAST
fun bar(x: Int) = x + 1

fun foo() {
    val x: Int? = null

    if (x != null) {
        bar(x)
        if (<!SENSELESS_COMPARISON!>x != null<!>) {
            bar(x)
            if (1 < 2) bar(x)
            if (1 > 2) bar(x)
        }
        if (<!SENSELESS_COMPARISON!>x == null<!>) {
            bar(x)
        }
        if (<!SENSELESS_COMPARISON!>x == null<!>) bar(x) else bar(x)
        bar(bar(x))
    } else if (<!SENSELESS_COMPARISON!><!DEBUG_INFO_CONSTANT!>x<!> == null<!>) {
        bar(<!TYPE_MISMATCH, DEBUG_INFO_CONSTANT!>x<!>)
        if (<!SENSELESS_COMPARISON!><!DEBUG_INFO_CONSTANT!>x<!> != null<!>) {
            bar(x)
            if (<!SENSELESS_COMPARISON!>x == null<!>) bar(x)
            if (<!SENSELESS_COMPARISON!>x == null<!>) bar(x) else bar(x)
            bar(bar(x) + bar(x))
        } else if (<!SENSELESS_COMPARISON!><!DEBUG_INFO_CONSTANT!>x<!> == null<!>) {
            bar(<!TYPE_MISMATCH, DEBUG_INFO_CONSTANT!>x<!>)
        }
    }

}
