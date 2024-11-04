package Model;

public class Classmates {

    private int id;
    private String F;
    private String I;
    private String O;
    private String time;

    //НАЧАЛО конструкторы
    public Classmates() {
    }
    public Classmates(int id, String F, String I, String O, String time) {
        this.id = id;
        this.F = F;
        this.I = I;
        this.O = O;
        this.time = time;
    }
    public Classmates(String F, String I, String O, String time) {
        this.F = F;
        this.I = I;
        this.O = O;
        this.time = time;
    }
    //КОНЕЦ конструкторы


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getI() {
        return I;
    }

    public String getO() {
        return O;
    }

    public void setO(String o) {
        O = o;
    }

    public void setI(String i) {
        I = i;
    }

    public String getF() {
        return F;
    }

    public void setF(String f) {
        F = f;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

