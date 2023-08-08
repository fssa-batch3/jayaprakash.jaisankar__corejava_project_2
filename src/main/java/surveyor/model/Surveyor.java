package surveyor.model;



public class Surveyor {
    private String name;
    private String taluk;
    private String email;

    public Surveyor(String name, String taluk, String email) {
        this.name = name;
        this.taluk = taluk;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaluk() {
        return taluk;
    }

    public void setTaluk(String taluk) {
        this.taluk = taluk;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Surveyor [name=" + name + ", taluk=" + taluk + ", email=" + email + "]";
    }
}
