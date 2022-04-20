import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

/*
####################################
# PDF生成
####################################
*/

public class Generater extends Thread
{
    PDDocument document = new PDDocument();
    List<PDPage> page = new ArrayList<PDPage>();
    List<String> path = new ArrayList<String>();
    String name;
    public void setFile(List<Image> image,String n)
    {
        name = n;
        for(int i = 0; i < image.size(); i++)
        {
            path.add(image.get(i).getPath());
            PDRectangle rec = new PDRectangle();
            
            rec.setUpperRightX(image.get(i).getSize_X());
            rec.setUpperRightY(image.get(i).getSize_Y());
            rec.setLowerLeftX(0);
            rec.setLowerLeftY(0);
                
            page.add(new PDPage(rec));

            document.addPage(page.get(page.size() - 1 ));					
        }       
			
    }


    @Override
    public void run()
    {
        try
        {
            for(int i = 0; i < page.size(); i++)
            {
                System.out.println(path.get(i));
                PDImageXObject xImage = PDImageXObject.createFromFile(path.get(i),document);
                PDPageContentStream stream = new PDPageContentStream(document,page.get(i));
                stream.drawImage(xImage, 0,0);
                stream.close();
            }

            document.save(name + ".pdf");
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }

    }
    
}
    