package com.boni.rhythmtapper

import com.boni.rhythmtapper.base.BaseGame
import com.boni.rhythmtapper.screens.RecorderScreen

class RecorderGame: BaseGame() {
    override fun create() {
        super.create()
        setActiveScreen(RecorderScreen())
    }
}