package com.laz.projectile;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class Projectile extends Image {

    float fX, fY, fWidth, fHeight, fStateTime, fDir, fCurrentLife;
    boolean isAlive;
    TextureAtlas taProjectile;
    TextureRegion trFrame, trLeft[], trRight[];
    Animation aniProjectile[];
    MagicButton btnMagic;

    public Projectile(float fX, float fY, float fWidth, float fHeight) {
        this.fX = fX;
        this.fY = fY;
        this.fWidth = fWidth;
        this.fHeight = fHeight;

        taProjectile = new TextureAtlas("projectile.atlas");

        trLeft = new TextureRegion[3];
        trRight = new TextureRegion[3];
        for (int i = 0; i < 3; i++) {
            trLeft[i] = taProjectile.findRegion("left" + (i + 1)); //load left-facing images
            trRight[i] = taProjectile.findRegion("right" + (i + 1)); //load right-facing images
        }
        trFrame = new TextureRegion(trRight[0]);

        aniProjectile = new Animation[2];
        aniProjectile[0] = new Animation(0.1f, trLeft); //load left-facing animations
        aniProjectile[1] = new Animation(0.1f, trRight); //load right-facing animations

        this.setVisible(false);
    }

    @Override
    public void act(float fDelta) {
        if (isAlive) {
            this.setVisible(true);
            if (fDir == 0) {
                trFrame = aniProjectile[0].getKeyFrame(fStateTime, true);
                fX -= 5;
            } else if (fDir == 1) {
                trFrame = aniProjectile[1].getKeyFrame(fStateTime, true);
                fX += 5;
            }
            fCurrentLife--;
        }

        if (fCurrentLife == 0) {
            resetProjectile();
        }
    }

    public void resetProjectile() {
        this.setVisible(false);
        isAlive = false;
        fCurrentLife = 75;
        fX = 55;
    }

    @Override
    public void draw(Batch batch, float fAlpha) {
        batch.draw(trFrame, fX, fY, fWidth, fHeight);
        fStateTime += Gdx.graphics.getDeltaTime();
    }

    public void setButton(MagicButton btnMagic) {
        this.btnMagic = btnMagic;
        btnMagic.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float fX, float fY) {
                if (!isAlive) {
                    fDir = 1;
                    isAlive = true;
                }
            }
        });
    }
}
