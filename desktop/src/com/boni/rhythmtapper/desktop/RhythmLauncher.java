package com.boni.rhythmtapper.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.boni.rhythmtapper.RecorderGame;
import com.boni.rhythmtapper.RhythmGame;
import com.boni.rhythmtapper.base.BaseGame;

public class RhythmLauncher {
    public static void main (String[] arg) {
        BaseGame game = new RhythmGame();
        new LwjglApplication(game, "Rhythm", 800, 600);
    }
}
