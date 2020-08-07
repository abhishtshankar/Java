import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
public class Tets{
    public static void main (String args[]){
        try{
            new ZipFile("file name you to create.zip").addFile("path of the file to be zipped");
            System.out.println("Zipped Sucessfully");
        }
        catch(java.util.zip.ZipException e){
            e.printStackTrace();
        }
    }
}
