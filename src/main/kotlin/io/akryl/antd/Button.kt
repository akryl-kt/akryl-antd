@file:Suppress("unused", "EnumEntryName")

package io.akryl.antd

import io.akryl.dom.css.CssStyle
import io.akryl.dom.css.toStyleJson
import io.akryl.dom.html.concatChildrenToArray
import io.akryl.dom.html.concatStyle
import react.React
import react.ReactElement
import kotlin.js.json

@JsModule("antd/lib/button")
@JsNonModule
private external val Button: AntdComponent

enum class ButtonShape {
    circle,
    round
}

enum class ButtonType {
    primary,
    ghost,
    dashed,
    link,
}

fun button(
    disabled: Boolean? = undefined,
    ghost: Boolean? = undefined,
    href: String? = undefined,
    htmlType: String? = undefined,
    icon: ReactElement<*>? = undefined,
    loading: Boolean? = undefined,
    shape: ButtonShape? = undefined,
    size: ElementSize? = undefined,
    target: String? = undefined,
    type: ButtonType? = undefined,
    onClick: (() -> Unit)? = undefined,
    block: Boolean? = undefined,
    danger: Boolean? = undefined,

    css: CssStyle? = undefined,
    className: CharSequence? = undefined,
    style: CssStyle? = undefined,

    children: List<ReactElement<*>>? = undefined,
    child: ReactElement<*>? = undefined,
    text: String? = undefined
) = React.createElement(
    Button.default,
    json(
        "disabled" to disabled,
        "ghost" to ghost,
        "href" to href,
        "htmlType" to htmlType,
        "icon" to icon,
        "loading" to loading,
        "shape" to shape?.toString(),
        "size" to size?.toString(),
        "target" to target,
        "type" to type?.toString(),
        "onClick" to onClick,
        "block" to block,
        "danger" to danger,
        "className" to concatStyle(css, className),
        "style" to style?.toStyleJson()
    ),
    children = *concatChildrenToArray(children, child, text)
)
