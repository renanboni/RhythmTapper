package com.boni.rhythmtapper.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.boni.rhythmtapper.utils.FileUtils;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		// new LwjglApplication(new RhythmTapper(), config);
		FileUtils.Companion.showOpenDialog();
	}
}
