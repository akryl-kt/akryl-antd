package io.akryl.antd.icons

import io.akryl.dom.css.CssStyle
import io.akryl.dom.css.toStyleJson
import io.akryl.dom.html.concatStyle
import react.Component
import react.React
import kotlin.js.json

external interface AntdIcon {
    val default: Component<dynamic>
}

operator fun AntdIcon.invoke(
    spin: Boolean? = undefined,
    rotate: Number? = undefined,
    twoToneColor: String? = undefined,

    css: CssStyle? = undefined,
    className: CharSequence? = undefined,
    style: CssStyle? = undefined
) = React.createElement(
    this.default,
    json(
        "spin" to spin,
        "rotate" to rotate,
        "twoToneColor" to twoToneColor,
        "className" to concatStyle(css, className),
        "style" to style?.toStyleJson()
    )
)
