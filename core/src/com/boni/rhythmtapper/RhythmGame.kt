package com.boni.rhythmtapper

import com.boni.rhythmtapper.base.BaseGame
import com.boni.rhythmtapper.screens.RecorderScreen
import com.boni.rhythmtapper.screens.RhythmScreen

class RhythmGame: BaseGame() {
    override fun create() {
        super.create()
        setActiveScreen(RhythmScreen())
    }
}