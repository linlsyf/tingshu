package com.github.eprendre.tingshu.sources

/**
 * 自动嗅探提取音频
 */
object AudioUrlWebViewSniffExtractor : AudioUrlExtractor {
    /**
     * @param isDeskTop true 加载 PC 页面, false 加载手机页面
     * @param validateUrl 一般默认的音频提取足够用了，当有额外的需求时，提供此回调以自定义验证嗅探的地址是否符合要求
     */
    @JvmOverloads
    fun setUp(isDeskTop: Boolean = false, validateUrl: ((String) -> Boolean)? = null) {
        throw RuntimeException("Stub!")
    }
}