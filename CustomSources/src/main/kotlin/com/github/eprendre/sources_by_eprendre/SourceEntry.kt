package com.github.eprendre.sources_by_eprendre

import com.github.eprendre.tingshu.sources.TingShu

object SourceEntry {
    @JvmStatic
    fun getSources(): List<TingShu> {
        return listOf(
            JDLG
        )
    }
}