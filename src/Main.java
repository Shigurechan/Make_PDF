import java.io.IOException;
import java.io.File;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;

import java.util.concurrent.Callable;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class Main
{
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
			
        List<Image> image = FileManager.GetFilePath_Directory(new File(fileName));
        Generater gen = new Generater();
        gen.setFile(image,new File(fileName).getName());

        gen.run();


        scanner.close();
    }    
}