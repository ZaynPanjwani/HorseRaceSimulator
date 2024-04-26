import java.awt.*;
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
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(this);
            objectOutputStream.close();
            fileOutputStream.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(File saveFile) {
        try {
            FileInputStream fileInputStream = new FileInputStream(saveFile);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            SaveFile save = (SaveFile) objectInputStream.readObject();
            this.balance = save.balance;
            this.horses = save.horses;
            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
