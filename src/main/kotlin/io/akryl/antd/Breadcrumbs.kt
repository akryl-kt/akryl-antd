@file:Suppress("ClassName", "unused")

package io.akryl.antd

import io.akryl.dom.css.CssStyle
import io.akryl.dom.css.toStyleJson
import io.akryl.dom.html.concatChildrenToArray
import io.akryl.dom.html.concatStyle
import org.w3c.dom.events.MouseEvent
import react.React
import react.ReactElement
import kotlin.js.json

@JsModule("antd/lib/breadcrumb/Breadcrumb")
@JsNonModule
private external val Breadcrumb : AntdComponent

@JsModule("antd/lib/breadcrumb/BreadcrumbItem")
@JsNonModule
private external val BreadcrumbItem : AntdComponent

@JsModule("antd/lib/breadcrumb/BreadcrumbSeparator")
@JsNonModule
private external val BreadcrumbSeparator : AntdComponent

object breadcrumb {
    operator fun invoke(
        separator: ReactElement<*>? = undefined,

        css: CssStyle? = undefined,
        className: CharSequence? = undefined,
        style: CssStyle? = undefined,

        children: List<ReactElement<*>>? = undefined,
        child: ReactElement<*>? = undefined,
        text: String? = undefined
    ) = React.createElement(
        Breadcrumb.default,
        json(
            "separator" to separator,
            "className" to concatStyle(css, className),
            "style" to style?.toStyleJson()
        ),
        children = *concatChildrenToArray(children, child, text)
    )

    fun item(
        href: String? = undefined,
        overlay: (() -> ReactElement<*>)? = undefined,
        onClick: ((e: MouseEvent) -> Unit)? = undefined,

        css: CssStyle? = undefined,
        className: CharSequence? = undefined,
        style: CssStyle? = undefined,

        children: List<ReactElement<*>>? = undefined,
        child: ReactElement<*>? = undefined,
        text: String? = undefined
    ) = React.createElement(
        BreadcrumbItem.default,
        json(
            "href" to href,
            "overlay" to overlay,
            "onClick" to onClick,
            "className" to concatStyle(css, className),
            "style" to style?.toStyleJson()
        ),
        children = *concatChildrenToArray(children, child, text)
    )

    fun separator(
        css: CssStyle? = undefined,
        className: CharSequence? = undefined,
        style: CssStyle? = undefined,

        children: List<ReactElement<*>>? = undefined,
        child: ReactElement<*>? = undefined,
        text: String? = undefined
    ) = React.createElement(
        BreadcrumbSeparator.default,
        json(
            "className" to concatStyle(css, className),
            "style" to style?.toStyleJson()
        ),
        children = *concatChildrenToArray(children, child, text)
    )
}
