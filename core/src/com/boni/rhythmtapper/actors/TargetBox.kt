package com.boni.rhythmtapper.actors

import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.utils.Align
import com.boni.rhythmtapper.base.BaseActor
import com.boni.rhythmtapper.base.BaseGame

class TargetBox(letter: String, x: Float, y: Float, stage: Stage) : BaseActor(x, y, stage) {
    init {
        loadTexture("box.png")
        setSize(64f, 64f)

        val letterLabel = Label(letter, BaseGame.labelStyle).also {
            it.setSize(64f, 64f)
            it.setAlignment(Align.center)
            it.color = color
        }

        addActor(letterLabel)
    }
}