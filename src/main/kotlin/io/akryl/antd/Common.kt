@file:Suppress("unused")

package io.akryl.antd

import react.Component

external interface AntdComponent {
    val default: Component<dynamic>
}

fun initializeAntd() {
    js("require('antd/dist/antd.css')")
}

internal fun <T : Any> T?.orUndefined(): T? = this ?: undefined
