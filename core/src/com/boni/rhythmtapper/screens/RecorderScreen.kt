package com.boni.rhythmtapper.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.audio.Music
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.boni.rhythmtapper.SongData
import com.boni.rhythmtapper.base.BaseGame
import com.boni.rhythmtapper.base.BaseScreen
import com.boni.rhythmtapper.utils.FileUtils

class RecorderScreen : BaseScreen() {

    private var isRecording: Boolean = false

    private lateinit var loadButton: TextButton
    private lateinit var recordButton: TextButton
    private lateinit var saveButton: TextButton

    private lateinit var music: Music
    private lateinit var songData: SongData
    private var lastSongPosition: Float = 0f

    override fun initialize() {
        isRecording = false

        setupLoadButton()
        setupRecordButton()
        setupSaveButton()
        setupLayout()
    }

    private fun setupLayout() {
        uiTable.add(loadButton)
        uiTable.row()
        uiTable.add(recordButton)
        uiTable.row()
        uiTable.add(saveButton)
        uiTable.row()
    }

    private fun setupSaveButton() {
        saveButton = TextButton("Save Keystroke File", BaseGame.textButtonStyle)
        saveButton.addListener {
            if (!isTouchEvent(it)) {
                return@addListener false
            }

            val textFile = FileUtils.showSaveDialog()

            if (textFile != null) {
                songData.writeToFile(textFile)
            }

            true
        }
    }

    private fun setupRecordButton() {
        recordButton = TextButton("Record Keystrokes", BaseGame.textButtonStyle)
        recordButton.addListener {
            if (!isTouchEvent(it)) {
                return@addListener false
            }

            if (!isRecording) {
                music.play()
                isRecording = true
                lastSongPosition = 0f
            }

            true
        }
    }

    private fun setupLoadButton() {
        loadButton = TextButton("Load Music File", BaseGame.textButtonStyle)
        loadButton.addListener {
            if (!isTouchEvent(it)) {
                return@addListener false
            }

            val musicFile = FileUtils.showOpenDialog()

            if (musicFile != null) {
                music = Gdx.audio.newMusic(musicFile)
                songData = SongData()
                songData.songName = musicFile.name()
            }

            true
        }
    }

    override fun update(dt: Float) {
        if (isRecording) {
            if (music.isPlaying) {
                lastSongPosition = music.position
            } else {
                isRecording = false
                songData.songDuration = lastSongPosition
            }
        }
    }

    override fun keyDown(keycode: Int): Boolean {
        if (isRecording) {
            val key = Input.Keys.toString(keycode)
            val time = music.position

            songData.addKeyTime(key, time)
        }

        return false
    }
}