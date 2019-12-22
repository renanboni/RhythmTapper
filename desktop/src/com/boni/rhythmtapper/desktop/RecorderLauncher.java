package com.boni.rhythmtapper.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.boni.rhythmtapper.RecorderGame;
import com.boni.rhythmtapper.base.BaseGame;

public class RecorderLauncher {
    public static void main (String[] arg) {
        BaseGame game = new RecorderGame();
        new LwjglApplication(game, "Recorder", 800, 600);
    }
}
