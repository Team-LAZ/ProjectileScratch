package com.laz.projectile.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.laz.projectile.ProjectileScratch;

public class HtmlLauncher extends GwtApplication {

    @Override
    public GwtApplicationConfiguration getConfig() {
        return new GwtApplicationConfiguration(800, 480);
    }

    @Override
    public ApplicationListener getApplicationListener() {
        return new ProjectileScratch();
    }
}