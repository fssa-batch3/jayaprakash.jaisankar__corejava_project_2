package stampmodule.model;


public class Stamp {
    private String stampName;
    private String img;
    private double rupees;
    private String description;

    public String getStampName() {
        return stampName;
    }

    public void setStampName(String stampName) {
        this.stampName = stampName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public double getRupees() {
        return rupees;
    }

    public void setRupees(double rupees) {
        this.rupees = rupees;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
