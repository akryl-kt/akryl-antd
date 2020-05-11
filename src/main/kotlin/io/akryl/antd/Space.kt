@file:Suppress("ClassName", "EnumEntryName", "unused")

package io.akryl.antd

import io.akryl.dom.css.CssStyle
import io.akryl.dom.css.toStyleJson
import io.akryl.dom.html.concatChildrenToArray
import io.akryl.dom.html.concatStyle
import react.React
import react.ReactElement
import kotlin.js.json

@JsModule("antd/lib/space")
@JsNonModule
private external val Space: AntdComponent

enum class SpaceAlign {
    start,
    end,
    center,
    baseline,
}

enum class SpaceDirection {
    vertical,
    horizontal,
}

sealed class SpaceSize<out T>(val value: T) {
    object small : SpaceSize<String>("small")
    object middle : SpaceSize<String>("middle")
    object large : SpaceSize<String>("large")
    class custom(value: Number) : SpaceSize<Number>(value)
}

fun space(
    align: SpaceAlign? = undefined,
    direction: SpaceDirection? = undefined,
    size: SpaceSize<Any>? = undefined,

    css: CssStyle? = undefined,
    className: CharSequence? = undefined,
    style: CssStyle? = undefined,

    children: List<ReactElement<*>>? = undefined,
    child: ReactElement<*>? = undefined,
    text: String? = undefined
) = React.createElement(
    Space.default,
    json(
        "align" to align?.toString(),
        "direction" to direction?.toString(),
        "size" to size?.value,
        "className" to concatStyle(css, className),
        "style" to style?.toStyleJson()
    ),
    children = *concatChildrenToArray(children, child, text)
)