import db.querystates.QueryCreator;

public class Main {
    public static void main(String[] args) {

        String query = QueryCreator
                .select("id", "car")
                .from("Cars")
                .create();
        System.out.println(query);
    }
}
