import java.io.*;
import java.util.ArrayList;

public class SaveFile implements Serializable {
    public int balance;
    public ArrayList<HorseInfo> horses;

    public SaveFile() {
        this.balance = 1000;
        this.horses = new ArrayList<>();
    }

    public void save(File saveFile) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(saveFile);
            ObjectOutputStream os = new ObjectOutputStream(fileOutputStream);
            os.writeObject(this);
            os.close();
            fileOutputStream.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(File saveFile) {
        try {
            FileInputStream fileInputStream = new FileInputStream(saveFile);
            ObjectInputStream os = new ObjectInputStream(fileInputStream);
            SaveFile save = (SaveFile) os.readObject();
            this.balance = save.balance;
            this.horses = save.horses;
            os.close();
            fileInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
