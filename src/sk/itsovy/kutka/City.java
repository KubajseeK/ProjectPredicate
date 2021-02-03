package sk.itsovy.kutka;

public class City {
    private int pop;
    private String code;
    private String district;
    private String name;

    public City(int pop, String code, String district, String name) {
        this.pop = pop;
        this.code = code;
        this.district = district;
        this.name = name;
    }

    public int getPop() {
        return pop;
    }

    public void setPop(int pop) {
        this.pop = pop;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "City{" +
                "pop=" + pop +
                ", code='" + code + '\'' +
                ", district='" + district + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
