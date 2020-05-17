@file:Suppress("unused")

package io.akryl.antd

import react.React
import kotlin.js.json

@JsModule("antd/lib/input-number")
@JsNonModule
private external val InputNumber : AntdComponent

sealed class NumericValue {
    abstract val value: Any
    override fun toString() = value.toString()

    class Number(override val value: kotlin.Number): NumericValue()
    class String(override val value: kotlin.String): NumericValue()
}

sealed class NumericStep {
    abstract val value: Any
    override fun toString() = value.toString()

    class Number(override val value: kotlin.Number): NumericStep()

    class Decimal(override val value: String): NumericStep() {
        init {
            checkNotNull(value.toDoubleOrNull()) { "Invalid value for decimal step: '$value'" }
        }
    }
}

fun inputNumber(
    autoFocus: Boolean? = undefined,
    disabled: Boolean? = undefined,
    formatter: ((String) -> String)? = undefined,
    max: Number? = undefined,
    min: Number? = undefined,
    parser: ((String) -> NumericValue)? = undefined,
    precision: Int? = undefined,
    decimalSeparator: String? = undefined,
    size: ElementSize? = undefined,
    step: NumericStep? = undefined,
    type: String? = undefined,
    value: NumericValue? = undefined,
    onChange: ((NumericValue) -> Unit)? = undefined,
    onPressEnter: (() -> Unit)? = undefined
) = React.createElement(
    InputNumber.default,
    json(
        "autoFocus" to autoFocus,
        "disabled" to disabled,
        "formatter" to formatter,
        "max" to max,
        "min" to min,
        "parser" to parser?.let { fn ->
            { value: String ->
                fn(value).value
            }
        }.orUndefined(),
        "precision" to precision,
        "decimalSeparator" to decimalSeparator,
        "size" to size?.toString().orUndefined(),
        "step" to step?.value.orUndefined(),
        "type" to type,
        "value" to value?.value.orUndefined(),
        "onChange" to onChange?.let { fn ->
            { value: Any ->
                when (value) {
                    is Number -> fn(NumericValue.Number(value))
                    is String -> fn(NumericValue.String(value))
                }
            }
        }.orUndefined(),
        "onPressEnter" to onPressEnter
    )
)
