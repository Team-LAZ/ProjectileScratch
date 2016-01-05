package com.laz.projectile;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

public class GameStage extends Stage {

    OrthographicCamera camera;
    MagicButton magicButton;
    Projectile projectile;

    public GameStage() {
        super(new ScalingViewport(Scaling.stretch, 800, 480, new OrthographicCamera(800, 480)));

        initCamera();
        initControls();
        initProjectile();

        Gdx.input.setInputProcessor(this);
    }

    public void initCamera() {
        camera = new OrthographicCamera(800, 480);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0f);
    }

    public void initControls() {
        magicButton = new MagicButton(55, 100);
        addActor(magicButton);
    }

    public void initProjectile() {
        projectile = new Projectile(55, 100, 75, 50);
        projectile.setButton(magicButton);
        addActor(projectile);
    }
}
