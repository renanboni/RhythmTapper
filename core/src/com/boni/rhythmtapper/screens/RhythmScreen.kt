package com.boni.rhythmtapper.screens

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.boni.rhythmtapper.actors.FallingBox
import com.boni.rhythmtapper.actors.TargetBox
import com.boni.rhythmtapper.base.BaseActor
import com.boni.rhythmtapper.base.BaseScreen

class RhythmScreen : BaseScreen() {

    private lateinit var keyList: ArrayList<String>
    private lateinit var colorList: ArrayList<Color>
    private lateinit var targetList: ArrayList<TargetBox>
    private lateinit var fallingLists: ArrayList<ArrayList<FallingBox>>

    override fun initialize() {
        setupBackground()

        keyList = arrayListOf("F", "G", "H", "J")
        colorList = arrayListOf(Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE)

        val targetTable = Table().also {
            it.setFillParent(true)
            it.add().colspan(4).expandY()
            it.row()
        }
        mainStage.addActor(targetTable)

        targetList = arrayListOf()
        for (i in 0 until 4) {
            val tb = TargetBox(stage = mainStage, x = 0f, y = 0f, color = colorList[i], letter = keyList[i])
            targetList.add(tb)
            targetTable.add(tb).pad(32f)
        }

        fallingLists = arrayListOf()
        for (i in 0 until 4) {
            fallingLists.add(arrayListOf())
        }
    }

    private fun setupBackground() {
        val background = BaseActor(stage = mainStage).also {
            it.loadTexture("space.png")
            it.setSize(800f, 600f)
        }

        BaseActor.setWorldBounds(background)
    }

    override fun update(dt: Float) {

    }

    override fun keyDown(keycode: Int): Boolean {
        return false
    }
}