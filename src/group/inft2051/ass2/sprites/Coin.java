package group.inft2051.ass2.sprites;

import com.nlcode.cn1.core.ResourceManager;
import com.nlcode.cn1.core.graphics.Animation;
import com.nlcode.cn1.core.graphics.Sprite;


public class Coin extends Sprite
{
	private float gravity = 0.002f;

	public Coin() {
	    Animation anim = new Animation();
		anim.addFrame(ResourceManager.loadImage("/s_coin_01.png"), 200);
		anim.addFrame(ResourceManager.loadImage("/s_coin_02.png"), 200);
		anim.addFrame(ResourceManager.loadImage("/s_coin_03.png"), 200);
		anim.addFrame(ResourceManager.loadImage("/s_coin_04.png"), 200);
		setAnimation(anim);
		setActive(true);
	}

	public void update(long time) {
		//Gravedad
		this.setSpeedY(this.getGravity() * time);
		super.update(time);
	}

	public float getGravity() {
		return gravity;
	}

	@Override
	public void event_spriteHorizontalCollision(Sprite sprite) {
		coinCollision(sprite);
	}
	
	@Override
	public void event_spriteVerticalCollision(Sprite sprite) {
		coinCollision(sprite);
	}
	
	private void coinCollision(Sprite sprite) {
		if (sprite instanceof Plumber) {
			Plumber objMario = ((Plumber) sprite);
			//this.sound.replay();
			objMario.setCoins(objMario.getCoins() + 1);
			this.getStage().getSprites().remove(this);
		}
	}
}
