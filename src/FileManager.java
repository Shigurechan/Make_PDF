import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import java.util.List;

public class FileManager
{
    //ファイルタイプ
	public enum type
	{
		Directory,	//ディレクトリ
		File,		//単一の画像ファイル
		Invalid		//対応していないファイル
	}
	
	static List<Image> GetFilePath_Directory(File path)
	{
		System.out.println(path.toPath());
	
		File[] file = path.listFiles();
		List<String> fileList = new ArrayList<String>();


		for(int i = 0; i < file.length; i++)
		{
			fileList.add(file[i].toString());
		}		

		Collections.sort(fileList);


		List<Image> image = new ArrayList<Image>();


		for(int i = 0; i < fileList.size(); i++)
		{
//			System.out.println(fileList.get(i));
			image.add(Image.GetImage(new File(fileList.get(i)).toPath()));
		} 

		
		return image;

	}
    


	//ファイルかディレクトリかを選別
    public static type GetFileType(File file)
	{
		if(file.exists() == true)
		{				
			if(file.isFile() == true)
			{
				String extension = file.getName().substring(file.getName().lastIndexOf("."));
				
				if(extension.equals(".png") || extension.equals(".jpg") || extension.equals(".jpeg"))
				{					
					return type.File;
				}	
			}
			else
			{	
				return type.Directory;
			}
		}
		else
		{
			System.out.println("対応形式ではりません: " + file.getName());
			return type.Invalid;
		}	
		
		return type.Invalid;
	}
}
