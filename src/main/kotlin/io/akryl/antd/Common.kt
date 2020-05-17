@file:Suppress("unused", "EnumEntryName")

package io.akryl.antd

import react.Component

external interface AntdComponent {
    val default: Component<dynamic>
}

enum class ElementSize {
    large,
    middle,
    small,
}

fun initializeAntd() {
    js("require('antd/dist/antd.css')")
}

internal fun <T : Any> T?.orUndefined(): T? = this ?: undefined
