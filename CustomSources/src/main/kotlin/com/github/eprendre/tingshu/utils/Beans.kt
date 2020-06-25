package com.github.eprendre.tingshu.utils

data class Book(
    val coverUrl: String,//封面链接
    val bookUrl: String,//书籍链接
    val title: String,//标题
    val author: String,//作者
    val artist: String//演播
) {
    var sourceId: String? = null//源id，代表这本书属于某个源
    var intro: String = ""
    var status: String = ""
}

data class Episode(val title: String, val url: String)

interface IMenu {
    fun getType(): Int
}

data class CategoryTab(
    val title: String,
    val url: String
) : IMenu {

    override fun getType(): Int {
        return 1
    }
}

data class BookDetail(
    val playList: List<Episode>,
    val intro: String? = "",
    val artist: String = "",
    val author: String = "",
    val episodesCount: Int = 0,
    val coverUrl: String = ""
)


/**
 * 大分类
 */
data class CategoryMenu(
    val title: String, //大分类标题
    val tabs: List<CategoryTab>//子分类
) : IMenu {

    override fun getType(): Int {
        return 0
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other !is CategoryMenu) {
            return false
        }

        return tabs == other.tabs
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + tabs.hashCode()
        return result
    }
}

data class Category(
    val list: List<Book>,
    val currentPage: Int,
    val totalPage: Int,
    val currentUrl: String,
    val nextUrl: String
)