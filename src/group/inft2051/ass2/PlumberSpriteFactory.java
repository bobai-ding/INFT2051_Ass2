package group.inft2051.ass2;

import com.nlcode.cn1.core.graphics.Sprite;
import com.nlcode.cn1.core.graphics.SpriteFactory;
import group.inft2051.ass2.sprites.Coin;
import group.inft2051.ass2.sprites.Transfer;

public class PlumberSpriteFactory implements SpriteFactory
{
	public Sprite getSprite(String spriteName) {
		Sprite sprite = null;
		if (spriteName.equalsIgnoreCase("coin")){
			sprite = new Coin();
		}
		if (spriteName.equalsIgnoreCase("transfer")){
			sprite = new Transfer();
		}
		return sprite;
	}
}
