package group.inft2051.ass2.sprites;

import com.codename1.ui.Image;
import com.nlcode.cn1.core.ResourceManager;
import com.nlcode.cn1.core.graphics.Animation;

public class PlumberNormal extends Plumber
{
	public PlumberNormal() {
		//knight walk left
		Image knight01l = ResourceManager.loadImage("/k01.png");
		Image knight02l = ResourceManager.loadImage("/k02.png");
		Image knight03l = ResourceManager.loadImage("/k03.png");
		//stand
		Image knight04s = ResourceManager.loadImage("/_IDLE_000.png");
		//Right
		Image knight01d = ResourceManager.loadImage("/k04.png");
		Image knight02d = ResourceManager.loadImage("/k05.png");
		Image knight03d = ResourceManager.loadImage("/k06.png");
		Image knight04d = ResourceManager.loadImage("/k07.png");
		//jumping
		Image knight01j = ResourceManager.loadImage("/_JUMP_000.png");
		Image knight02j = ResourceManager.loadImage("/_JUMP_001.png");
		Image knight03j = ResourceManager.loadImage("/_JUMP_002.png");
		Image knight04j = ResourceManager.loadImage("/_JUMP_003.png");
		Image knight05j = ResourceManager.loadImage("/_JUMP_004.png");
		Image knight06j = ResourceManager.loadImage("/_JUMP_005.png");
		Image knight07j = ResourceManager.loadImage("/_JUMP_006.png");

		// create the attack animation
		Image knight01c = ResourceManager.loadImage("/_ATTACK_000.png");
		Image knight02c = ResourceManager.loadImage("/_ATTACK_001.png");
		Image knight03c = ResourceManager.loadImage("/_ATTACK_002.png");
		Image knight04c = ResourceManager.loadImage("/_ATTACK_003.png");
		Image knight05c = ResourceManager.loadImage("/_ATTACK_004.png");
		Image knight06c = ResourceManager.loadImage("/_ATTACK_005.png");
		Image knight07c = ResourceManager.loadImage("/_ATTACK_006.png");
		//Animacion Mario caminando a la izquierda
		
		setAnimCaminandoIzquierda(new Animation());
		getAnimCaminandoIzquierda().addFrame(knight01l, 150);
		getAnimCaminandoIzquierda().addFrame(knight02l, 150);
		getAnimCaminandoIzquierda().addFrame(knight03l, 150);
		//Animacion Mario caminando a la derecha
		setAnimCaminandoDerecha(new Animation());
		getAnimCaminandoDerecha().addFrame(knight01d, 150);
		getAnimCaminandoDerecha().addFrame(knight02d, 150);
		getAnimCaminandoDerecha().addFrame(knight03d, 150);
		getAnimCaminandoDerecha().addFrame(knight04d, 150);
		//Animacion Mario Parado a la izquierda
		setAnimParadoIzquierda(new Animation());
		getAnimParadoIzquierda().addFrame(knight04s, 100);
		//Animacion Mario Parado a la derecha
		setAnimParadoDerecha(new Animation());
		getAnimParadoDerecha().addFrame(knight04s, 100);
		//Animacion Mario Saltando a la izquierda
		setAnimSaltandoIzquierda(new Animation());
		getAnimSaltandoIzquierda().addFrame(knight01j, 100);
		getAnimSaltandoIzquierda().addFrame(knight02j, 100);
		getAnimSaltandoIzquierda().addFrame(knight03j, 100);
		getAnimSaltandoIzquierda().addFrame(knight04j, 100);
		getAnimSaltandoIzquierda().addFrame(knight05j, 100);
		getAnimSaltandoIzquierda().addFrame(knight06j, 100);
		getAnimSaltandoIzquierda().addFrame(knight07j, 100);

		//Animacion Mario Saltando a la derecha
		setAnimSaltandoDerecha(new Animation());
		getAnimSaltandoDerecha().addFrame(knight01j, 100);
		getAnimSaltandoDerecha().addFrame(knight02j, 100);
		getAnimSaltandoDerecha().addFrame(knight03j, 100);
		getAnimSaltandoDerecha().addFrame(knight04j, 100);
		getAnimSaltandoDerecha().addFrame(knight05j, 100);
		getAnimSaltandoDerecha().addFrame(knight06j, 100);
		getAnimSaltandoDerecha().addFrame(knight07j, 100);

		//Animacion por Defecto
		setAnimation(this.getAnimParadoDerecha());
		//Velocidad
		setVelocidad(0.3f);
		setActive(true);
	}
}
