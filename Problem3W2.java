public class Problem3W2 {

    static void parseInventoryRecord(String csvLine) {

        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
        } else {

            System.out.println(
                "Product: " + fields[0]
                + " | SKU: " + fields[1]
                + " | Qty: " + fields[2]
            );
        }
    }

    public static void main(String[] args) {

        String data = "Wireless Mouse,WM-2201,150";

        parseInventoryRecord(data);
    }
}