import java.io.File;
import java.nio.file.Path;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

/*
############################
イメージクラス
############################
*/
public class Image 
{

    public Image(int x,int y,String p)
    {
        sizeX = x;
        sizeY = y;
        path = p;
    }

    public int getSize_X()
    {
        return sizeX;
    }


    public int getSize_Y()
    {
        return sizeY;
    }

    public String getPath()
    {
        return path;
    }

    private int sizeX;
    private int sizeY;    
    String path;


    


    //イメージを取得
    static Image GetImage(Path path)
    {
        BufferedImage image = null;

        try
        {
            image = ImageIO.read(new File(path.toString()));
        }
        catch(Exception e)
        {
            System.out.println(e.getStackTrace());
        }


        return new Image(image.getWidth(),image.getHeight(),path.toString());

    }

}
