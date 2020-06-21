@file:Suppress("EnumEntryName", "unused")

package io.akryl.antd

import io.akryl.dom.css.CssStyle
import io.akryl.dom.css.toStyleJson
import io.akryl.dom.html.concatChildrenToArray
import io.akryl.dom.html.concatStyle
import react.React
import react.ReactElement
import kotlin.js.json

@JsModule("antd/lib/divider")
@JsNonModule
private external val Divider: AntdComponent

enum class DividerOrientation {
    left,
    center,
    right,
}

enum class DividerType {
    horizontal,
    vertical,
}

fun divider(
    dashed: Boolean? = undefined,
    orientation: DividerOrientation? = undefined,
    type: DividerType? = undefined,
    plain: Boolean? = undefined,

    css: CssStyle? = undefined,
    className: CharSequence? = undefined,
    style: CssStyle? = undefined,

    children: List<ReactElement<*>>? = undefined,
    child: ReactElement<*>? = undefined,
    text: String? = undefined
) = React.createElement(
    Divider.default,
    json(
        "dashed" to dashed,
        "orientation" to orientation?.toString().orUndefined(),
        "type" to type?.toString().orUndefined(),
        "plain" to plain,
        "className" to concatStyle(css, className),
        "style" to style?.toStyleJson()
    ),
    children = *concatChildrenToArray(children, child, text)
)
