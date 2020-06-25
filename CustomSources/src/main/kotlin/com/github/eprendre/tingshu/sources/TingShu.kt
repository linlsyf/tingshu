package com.github.eprendre.tingshu.sources

import com.github.eprendre.tingshu.utils.Book
import com.github.eprendre.tingshu.utils.BookDetail
import com.github.eprendre.tingshu.utils.Category
import com.github.eprendre.tingshu.utils.CategoryMenu

abstract class TingShu {
    /**
     * 随便生成一个 UUID 即可, 用来判断一本书属于哪个源。
     */
    abstract fun getSourceId(): String
    /**
     * 需要提供合法的网址，有时候用来判断链接是否属于某个源。
     */
    abstract fun getUrl(): String

    /**
     * 站点名称
     */
    abstract fun getName(): String

    /**
     * 站点简介
     */
    open fun getDesc() = ""

    /**
     * 返回 Pair 的第二个 Int 参数为最大页数，用来判断是否有下一页。
     * 若部分网站无法获取总页数，但确定有下一页的，可以返回当前页数+1。
     */
    abstract fun search(keywords: String, page: Int): Pair<List<Book>, Int>

    /**
     * 选择合适的音频提取逻辑
     */
    abstract fun getAudioUrlExtractor(): AudioUrlExtractor

    /**
     * 分类菜单
     */
    abstract fun getCategoryMenus(): List<CategoryMenu>

    /**
     * 分类页面的列表
     */
    abstract fun getCategoryList(url: String): Category


    /**
     * 当前站点的章节列表是否需要分页加载
     * app端会优化分页加载的逻辑
     */
    open fun isMultipleEpisodePages() = false

    /**
     *
     */
    abstract fun getBookDetailInfo(bookUrl: String, loadEpisodes: Boolean = true, loadFullPages: Boolean = true): BookDetail

    open fun reset() = run { }

    /**
     * 当前源是否可搜索
     */
    open fun isSearchable() = true

    /**
     * 当前源是否有发现分类的相关内容
     */
    open fun isDiscoverable() = true

    /**
     * 当前源的音频地址是否能被缓存
     */
    open fun isCacheable() = true

    /**
     * 当前源的解析是否没有用到 WebView <br>
     * 如果返回 false 代表当前源的解析不需要 WebView 的介入，那么这个源会在未集成 WebView 的设备上展示出来(比如手表)。
     */
    open fun isWebViewNotRequired() = false
}

interface AudioUrlExtractor {

}