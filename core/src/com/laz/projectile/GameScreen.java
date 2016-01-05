package com.laz.projectile;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

public class GameScreen implements Screen {

    private GameStage stage;

    public GameScreen() {
        stage = new GameStage();
    }

    @Override
    public void render(float fDelta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.draw();
        stage.act(fDelta);
    }

    @Override
    public void resize(int nWidth, int nHeight) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
