@file:Suppress("ClassName", "unused")

package io.akryl.antd

import io.akryl.dom.css.CssStyle
import io.akryl.dom.css.toStyleJson
import io.akryl.dom.html.concatChildrenToArray
import io.akryl.dom.html.concatStyle
import org.w3c.dom.events.Event
import react.React
import react.ReactElement
import kotlin.js.json

@JsModule("antd/lib/checkbox")
@JsNonModule
private external val Checkbox: AntdComponent

object checkbox {
    operator fun invoke(
        autoFocus: Boolean? = undefined,
        checked: Boolean? = undefined,
        disabled: Boolean? = undefined,
        indeterminate: Boolean? = undefined,
        onChange: ((e: Event) -> Unit)? = undefined,

        css: CssStyle? = undefined,
        className: CharSequence? = undefined,
        style: CssStyle? = undefined,

        children: List<ReactElement<*>>? = undefined,
        child: ReactElement<*>? = undefined,
        text: String? = undefined
    ) = React.createElement(
        Checkbox.default,
        json(
            "autoFocus" to autoFocus,
            "checked" to checked,
            "disabled" to disabled,
            "indeterminate" to indeterminate,
            "onChange" to onChange,
            "className" to concatStyle(css, className),
            "style" to style?.toStyleJson()
        ),
        children = *concatChildrenToArray(children, child, text)
    )
}
