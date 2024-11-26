package normativecontrol.core.rendering.css

import org.jetbrains.annotations.Contract

class Style(
    val classes: MutableList<String> = mutableListOf(),
    noInline: Boolean = false
) {
    val rules: MutableList<Rule> by lazy { mutableListOf() }
    val size: Int
        get() = rules.size

    var noInline: Boolean = false
        private set

    init {
        this.noInline = noInline
    }

    override fun toString(): String {
        val result = StringBuilder()
        for (rule in rules) {
            val r = rule.serialize()
            if (r != null) {
                result.append(r).append(";")
            }
        }

        return result.toString()
    }

    operator fun plusAssign(fn: context(Style, StyleProperties, StyleBuilder) () -> Unit) {
        fn(this, StyleProperties, StyleBuilder)
    }

    fun apply(detached: Detached) {
        detached.styleInitializer(this, StyleProperties, StyleBuilder)
    }

    @Contract(pure = true)
    fun fold(another: Style): Style {
        val result = Style(noInline = noInline && another.noInline)
        result.classes.addAll(classes)
        result.classes.addAll(another.classes)
        result.rules.addAll(rules)
        result.rules.addAll(another.rules)
        return result
    }

    class Detached(val styleInitializer: context(Style, StyleProperties, StyleBuilder) () -> Unit)
}