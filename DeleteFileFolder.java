import java.io.File;

public class DeleteFileFolder {

    public static void main(String[] args) {
        File file = new File("/home/arshdeep/folderName");
        if (file.exists()) {
            while (file.list().length != 0) {
                deleteContent(file);
            }
            if (file.delete()) {
                System.out.println("File deleted successfully");
            } else {
                System.out.println("File deleted un-successful");
            }
        }
    }

    public static void deleteContent(File file) {
        if (file.isDirectory()) {
            if (file.list().length != 0) {
                for (int i = 0; i < file.list().length; i++) {
                    File child = new File(file, file.list()[i]);
                    deleteContent(child);
                }
            } else {
                file.delete();
            }
        } else {
            file.delete();
        }
    }
}
