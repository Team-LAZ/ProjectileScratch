package com.laz.projectile;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class MagicButton extends Button {

    Skin skMagic;
    ButtonStyle bsMagic;

    public MagicButton(float fX, float fY) {
        setBounds(fX, fY, 80, 80);

        skMagic = new Skin();
        skMagic.add("magic_button", new Texture("magic_button.png"));

        bsMagic = new ButtonStyle();
        bsMagic.up = skMagic.getDrawable("magic_button");
        setStyle(bsMagic);
    }
}
