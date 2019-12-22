package com.boni.rhythmtapper.actors

import com.badlogic.gdx.scenes.scene2d.Stage
import com.boni.rhythmtapper.base.BaseActor

class FallingBox (x: Float, y: Float, stage: Stage) : BaseActor(x, y, stage) {
    init {
        loadTexture("box.png")
        setScale(0.75f, 0.75f)
    }

    override fun act(delta: Float) {
        super.act(delta)
        applyPhysics(delta)
    }
}