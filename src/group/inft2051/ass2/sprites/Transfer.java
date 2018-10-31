package group.inft2051.ass2.sprites;

import com.nlcode.cn1.core.ResourceManager;
import com.nlcode.cn1.core.graphics.Animation;
import com.nlcode.cn1.core.graphics.Sprite;

public class Transfer extends Sprite
{
    private int transfer = 0;

    public Transfer()
    {
        Animation anim = new Animation();
        anim.addFrame(ResourceManager.loadImage("/Black.png"), 200);
        setAnimation(anim);
        setActive(true);
    }

    public  void event_spriteHorizontalCollision(Sprite sprite)
    {
        transferCollision(sprite);
    }

    public void event_spriteVerticalCollision(Sprite sprite)
    {
        transferCollision(sprite);
    }


    public int getTransfer() {
        return transfer;
    }

    /**
     * @param transfer the transfer to set
     */
    public void setTransfer(int transfer) {
        this.transfer = transfer;
    }

    private void transferCollision(Sprite sprite)
    {
        if (sprite instanceof  Plumber)
        {
            Plumber objMario = ((Plumber) sprite);
            this.setTransfer(1);
        }
    }
}
