@file:Suppress("ClassName", "unused")

package io.akryl.antd

import org.w3c.dom.events.Event
import react.React
import react.ReactElement
import kotlin.js.json

external interface ResizeEvent {
    val width: Number
    val height: Number
}

@JsModule("antd/lib/input")
@JsNonModule
private external val Input : AntdComponent

@JsModule("antd/lib/input/TextArea")
@JsNonModule
private external val TextArea : AntdComponent

@JsModule("antd/lib/input/Search")
@JsNonModule
private external val Search : AntdComponent

@JsModule("antd/lib/input/Group")
@JsNonModule
private external val Group : AntdComponent

@JsModule("antd/lib/input/Password")
@JsNonModule
private external val Password : AntdComponent

object input {
    operator fun invoke(
        addonAfter: ReactElement<*>? = undefined,
        addonBefore: ReactElement<*>? = undefined,
        disabled: Boolean? = undefined,
        id: String? = undefined,
        maxLength: Int? = undefined,
        prefix: ReactElement<*>? = undefined,
        size: ElementSize? = undefined,
        suffix: ReactElement<*>? = undefined,
        type: String? = undefined,
        value: String? = undefined,
        onChange: ((Event) -> Unit)? = undefined,
        onPressEnter: ((Event) -> Unit)? = undefined,
        allowClear: Boolean? = undefined
    ) = React.createElement(
        Input.default,
        json(
            "addonAfter" to addonAfter,
            "addonBefore" to addonBefore,
            "disabled" to disabled,
            "id" to id,
            "maxLength" to maxLength,
            "prefix" to prefix,
            "size" to size?.toString().orUndefined(),
            "suffix" to suffix,
            "type" to type,
            "value" to value,
            "onChange" to onChange,
            "onPressEnter" to onPressEnter,
            "allowClear" to allowClear
        )
    )

    fun textArea(
        autoSize: Boolean? = undefined,
        disabled: Boolean? = undefined,
        id: String? = undefined,
        maxLength: Int? = undefined,
        value: String? = undefined,
        onPressEnter: ((Event) -> Unit)? = undefined,
        allowClear: Boolean? = undefined,
        onResize: ((ResizeEvent) -> Unit)? = undefined,
        onChange: ((Event) -> Unit)? = undefined
    ) = React.createElement(
        TextArea.default,
        json(
            "autoSize" to autoSize,
            "disabled" to disabled,
            "id" to id,
            "maxLength" to maxLength,
            "value" to value,
            "onPressEnter" to onPressEnter,
            "allowClear" to allowClear,
            "onResize" to onResize,
            "onChange" to onChange
        )
    )
}