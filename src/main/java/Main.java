import db.querystates.QueryCreator;
import utils.EmptyCondition;

public class Main {
    public static void main(String[] args) {

        String query = QueryCreator
                .select("id", "car")
                .from("Cars")
                .join("Engines",
                        EmptyCondition.where("engines.id")
                                .isEqualTo("cars.engine_id"))
                .where(EmptyCondition.where("engine.name").isEqualTo("RoyceRoyce"))
                .create();
        System.out.println(query);
    }
}
