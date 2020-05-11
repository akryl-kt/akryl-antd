@file:Suppress("EnumEntryName", "unused")

package io.akryl.antd

import io.akryl.dom.css.CssStyle
import io.akryl.dom.css.toStyleJson
import io.akryl.dom.html.concatStyle
import react.React
import react.ReactElement
import kotlin.js.json

@JsModule("antd/lib/pagination")
@JsNonModule
private external val Pagination : AntdComponent

enum class PageType {
    page,
    prev,
    next,
    jumpPrev,
    jumpNext,
}

enum class PaginationSize {
    default,
    small,
}

private val pageTypes = mapOf(
    "page" to PageType.page,
    "prev" to PageType.prev,
    "next" to PageType.next,
    "jump-prev" to PageType.jumpPrev,
    "jump-next" to PageType.jumpNext
)

fun pagination(
    current: Int,
    pageSize: Int,
    disabled: Boolean? = undefined,
    hideOnSinglePage: Boolean? = undefined,
    itemRender: ((page: Int, type: PageType, originalElement: ReactElement<*>) -> ReactElement<*>)? = undefined,
    pageSizeOptions: List<Int>? = undefined,
    showLessItems: Boolean? = undefined,
    showQuickJumper: Boolean? = undefined,
    showSizeChanger: Boolean? = undefined,
    showTitle: Boolean? = undefined,
    showTotal: ((total: Int, range: Pair<Int, Int>) -> ReactElement<*>)? = undefined,
    simple: Boolean? = undefined,
    size: PaginationSize? = undefined,
    responsive: Boolean? = undefined,
    total: Int? = undefined,
    onChange: ((page: Int, pageSize: Int) -> Unit)? = undefined,
    onShowSizeChange: ((current: Int, size: Int) -> Unit)? = undefined,

    css: CssStyle? = undefined,
    className: CharSequence? = undefined,
    style: CssStyle? = undefined
) = React.createElement(
    Pagination.default,
    json(
        "current" to current,
        "pageSize" to pageSize,
        "disabled" to disabled,
        "hideOnSinglePage" to hideOnSinglePage,
        "itemRender" to itemRender?.let { fn ->
            { page: Int, type: String, originalElement: ReactElement<*> ->
                fn(page, pageTypes[type] ?: error("Unknown page type '$type'"), originalElement)
            }
        }.orUndefined(),
        "pageSizeOptions" to pageSizeOptions?.toTypedArray().orUndefined(),
        "showLessItems" to showLessItems,
        "showQuickJumper" to showQuickJumper,
        "showSizeChanger" to showSizeChanger,
        "showTitle" to showTitle,
        "showTotal" to showTotal?.let { fn ->
            { total: Int, range: Array<Int> ->
                fn(total, Pair(range[0], range[1]))
            }
        }.orUndefined(),
        "simple" to simple,
        "size" to size?.toString(),
        "responsive" to responsive,
        "total" to total,
        "onChange" to onChange,
        "onShowSizeChange" to onShowSizeChange,
        "className" to concatStyle(css, className),
        "style" to style?.toStyleJson()
    )
)