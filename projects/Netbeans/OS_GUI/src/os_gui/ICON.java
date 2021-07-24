package os_gui;

import java.util.ArrayList;

public class ICON {

    public static ArrayList<String> IconTypes = new ArrayList<String>();
    public String Imgae;
    private String type;
    private float size;
    private String title;

    public ICON(String Imgae, String type, float size, String title) {
        this.Imgae = Imgae;
        this.type = type;
        this.size = size;
        this.title = title;

    }

    public ICON(String type, float size, String title) {

    }

    public void setType(String type) {
        if (IconTypes.contains(type)) {
            this.type = type;
        } else {
            this.type = "undefined";
        }

    }

    public String getType() {
        return type;
    }

    public String getImgae() {
        return Imgae;
    }

    public void setImgae(String Imgae) {
        this.Imgae = Imgae;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

}
