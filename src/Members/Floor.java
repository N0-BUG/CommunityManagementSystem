package Members;

public class Floor {
    private String floor_no;
    private String floor_manager;
    private String floor_host;
    private int floor_sum;
    private String floor_houseNumber;
    private int floor_index;

    public Floor(int floor_index, String floor_no, String floor_manager, String floor_host, int floor_sum, String floor_houseNumber) {
        this.floor_no = floor_no;
        this.floor_manager = floor_manager;
        this.floor_host = floor_host;
        this.floor_sum = floor_sum;
        this.floor_houseNumber = floor_houseNumber;
        this.floor_index = floor_index;
    }

    public Floor(String floor_no, String floor_manager, String floor_host, int floor_sum, String floor_houseNumber) {
        this.floor_no = floor_no;
        this.floor_manager = floor_manager;
        this.floor_host = floor_host;
        this.floor_sum = floor_sum;
        this.floor_houseNumber = floor_houseNumber;
    }

    public String getFloor_no() {
        return floor_no;
    }

    public String getFloor_manager() {
        return floor_manager;
    }

    public String getFloor_host() {
        return floor_host;
    }

    public int getFloor_sum() {
        return floor_sum;
    }

    public String getFloor_houseNumber() {
        return floor_houseNumber;
    }

    public int getFloor_index() {
        return floor_index;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
