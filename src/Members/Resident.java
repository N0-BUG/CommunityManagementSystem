package Members;

public class Resident {
    private String resident_name;
    private String resident_phone;
    private String resident_houseNumber;
    private String resident_gender;
    private int resident_index;

    public Resident(int resident_index, String resident_name, String resident_phone, String resident_houseNumber, String resident_gender) {
        this.resident_name = resident_name;
        this.resident_phone = resident_phone;
        this.resident_houseNumber = resident_houseNumber;
        this.resident_gender = resident_gender;
        this.resident_index = resident_index;
    }

    public Resident(String resident_name, String resident_phone, String resident_houseNumber, String resident_gender) {
        this.resident_name = resident_name;
        this.resident_phone = resident_phone;
        this.resident_houseNumber = resident_houseNumber;
        this.resident_gender = resident_gender;
    }

    public String getResident_name() {
        return resident_name;
    }

    public String getResident_phone() {
        return resident_phone;
    }

    public String getResident_houseNumber() {
        return resident_houseNumber;
    }

    public String getResident_gender() {
        return resident_gender;
    }

    public int getResident_index() {
        return resident_index;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
