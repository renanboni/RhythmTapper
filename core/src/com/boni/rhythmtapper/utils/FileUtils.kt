package com.boni.rhythmtapper.utils

import com.badlogic.gdx.files.FileHandle
import javax.swing.JFileChooser

class FileUtils {

    companion object {
        private var isFinished: Boolean = false
        private var fileHandle: FileHandle? = null

        private const val OPEN_DIALOG = 1
        private const val SAVE_DIALOG = 2

        fun showOpenDialog(): FileHandle? {
            return showDialog(OPEN_DIALOG)
        }

        fun showSaveDialog(): FileHandle? {
            return showDialog(SAVE_DIALOG)
        }

        private fun showDialog(dialogType: Int): FileHandle? {
            val fileChooser = JFileChooser()

            if (dialogType == OPEN_DIALOG) {
                fileChooser.showOpenDialog(null)
            } else {
                fileChooser.showSaveDialog(null)
            }

            val file = fileChooser.selectedFile

            return FileHandle(file)
        }
    }
}