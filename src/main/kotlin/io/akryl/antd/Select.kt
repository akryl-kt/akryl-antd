@file:Suppress("EnumEntryName", "unused")

package io.akryl.antd

import io.akryl.dom.css.CssStyle
import io.akryl.dom.css.toStyleJson
import io.akryl.dom.html.concatChildrenToArray
import io.akryl.dom.html.concatStyle
import react.React
import react.ReactElement
import kotlin.js.json

@JsModule("antd/lib/select")
@JsNonModule
private external val Select: AntdComponent

enum class SelectMode {
    multiple,
    tags,
}

data class Option<T>(
    val label: String,
    val value: T
)

fun <T> select(
    value: List<T>,
    allowClear: Boolean? = undefined,
    autoClearSearchValue: Boolean? = undefined,
    autoFocus: Boolean? = undefined,
    defaultActiveFirstOption: Boolean? = undefined,
    disabled: Boolean? = undefined,
    dropdownClassName: CharSequence? = undefined,
    dropdownMatchSelectWidth: Boolean? = undefined,
    dropdownStyle: CssStyle? = undefined,
    filterOption: Boolean? = undefined,
    labelInValue: Boolean? = undefined,
    listHeight: Number? = undefined,
    maxTagCount: Number? = undefined,
    maxTagTextLength: Number? = undefined,
    maxTagPlaceholder: (() -> ReactElement<*>)? = undefined,
    mode: SelectMode? = undefined,
    notFoundContent: ReactElement<*>? = undefined,
    options: List<Option<T>>? = undefined,
    placeholder: ReactElement<*>? = undefined,
    showArrow: Boolean? = undefined,
    showSearch: Boolean? = undefined,
    size: ElementSize? = undefined,
    suffixIcon: ReactElement<*>? = undefined,
    removeIcon: ReactElement<*>? = undefined,
    clearIcon: ReactElement<*>? = undefined,
    menuItemSelectedIcon: ReactElement<*>? = undefined,
    virtual: Boolean? = undefined,
    onBlur: (() -> Unit)? = undefined,
    onChange: (() -> Unit)? = undefined,
    onDeselect: (() -> Unit)? = undefined,
    onFocus: (() -> Unit)? = undefined,
    onInputKeyDown: (() -> Unit)? = undefined,
    onMouseEnter: (() -> Unit)? = undefined,
    onMouseLeave: (() -> Unit)? = undefined,
    onPopupScroll: (() -> Unit)? = undefined,
    onSearch: (() -> Unit)? = undefined,
    onSelect: ((T) -> Unit)? = undefined,
    defaultOpen: Boolean? = undefined,
    open: Boolean? = undefined,
    onDropdownVisibleChange: ((isOpen: Boolean) -> Unit)? = undefined,
    loading: Boolean? = undefined,
    bordered: Boolean? = undefined,

    css: CssStyle? = undefined,
    className: CharSequence? = undefined,
    style: CssStyle? = undefined,

    children: List<ReactElement<*>>? = undefined,
    child: ReactElement<*>? = undefined,
    text: String? = undefined
) = React.createElement(
    Select.default,
    json(
        "value" to value.toTypedArray(),
        "allowClear" to allowClear,
        "autoClearSearchValue" to autoClearSearchValue,
        "autoFocus" to autoFocus,
        "defaultActiveFirstOption" to defaultActiveFirstOption,
        "disabled" to disabled,
        "dropdownClassName" to dropdownClassName?.toString().orUndefined(),
        "dropdownMatchSelectWidth" to dropdownMatchSelectWidth,
        "dropdownStyle" to dropdownStyle?.toStyleJson().orUndefined(),
        "filterOption" to filterOption,
        "labelInValue" to labelInValue,
        "listHeight" to listHeight,
        "maxTagCount" to maxTagCount,
        "maxTagTextLength" to maxTagTextLength,
        "maxTagPlaceholder" to maxTagPlaceholder,
        "mode" to mode?.toString().orUndefined(),
        "notFoundContent" to notFoundContent,
        "options" to options?.toTypedArray().orUndefined(),
        "placeholder" to placeholder,
        "showArrow" to showArrow,
        "showSearch" to showSearch,
        "size" to size?.toString().orUndefined(),
        "suffixIcon" to suffixIcon,
        "removeIcon" to removeIcon,
        "clearIcon" to clearIcon,
        "menuItemSelectedIcon" to menuItemSelectedIcon,
        "virtual" to virtual,
        "onBlur" to onBlur,
        "onChange" to onChange,
        "onDeselect" to onDeselect,
        "onFocus" to onFocus,
        "onInputKeyDown" to onInputKeyDown,
        "onMouseEnter" to onMouseEnter,
        "onMouseLeave" to onMouseLeave,
        "onPopupScroll" to onPopupScroll,
        "onSearch" to onSearch,
        "onSelect" to onSelect,
        "defaultOpen" to defaultOpen,
        "open" to open,
        "onDropdownVisibleChange" to onDropdownVisibleChange,
        "loading" to loading,
        "bordered" to bordered,
        "className" to concatStyle(css, className),
        "style" to style?.toStyleJson()
    ),
    children = *concatChildrenToArray(children, child, text)
)

// TODO
//  Add option element
//  Better callbacks typing

