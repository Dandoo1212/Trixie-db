import db.querystates.QueryCreator;
import testEntities.DummyEntity;
import utils.Conditions;

import static utils.Conditions.where;
import static utils.SetParameter.setParameter;
import static utils.StringParameter.stringParameter;

public class Main {
    public static void main(String[] args) {

        String query = QueryCreator
                .select("id", "car")
                .from("Cars")
                .join("Engines", where("engines.id")
                        .isEqualTo("cars.engine_id"))
                .where(where("engines.name")
                        .isBetween(stringParameter("RoyceRoyce"), stringParameter(("Porsche"))))
                .orderBy(stringParameter("orderBy"))
                .create();
        System.out.println(query);

        String whereQuery = QueryCreator
                .select()
                .from("Point")
                .where("x > 2")
                .create();

        System.out.println(whereQuery);

        String whereQueryWithConditions = QueryCreator
                .select()
                .from("Point")
                .where(Conditions
                        .where("x")
                        .isGreaterThan(stringParameter("2")))
                .create();

        String ownCondition = QueryCreator
                .select()
                .from("Point")
                .where(Conditions
                        .where("leftOperand")
                        .ownCondition("MY OWN CONDITION", "rightOperand"))
                .create();

        System.out.println("OWN");
        System.out.println(ownCondition);


        String selectQuery = QueryCreator
                .select("x", "y")
                .from("Point")
                .create();
        System.out.println(selectQuery);

        String asteriskQuery = QueryCreator
                .select()
                .from("Point")
                .create();
        System.out.println(asteriskQuery);

        String insertQuery = QueryCreator
                .insert("Cars", "Name")
                .values(stringParameter("Porsche"), stringParameter("Carrera"))
                .create();

        System.out.println(insertQuery);

        String deleteQuery = QueryCreator
                .delete("Cars")
                .where(where("Name")
                        .isEqualTo(stringParameter("RoyceRoyce")))
                .create();

        System.out.println(deleteQuery);

        String updateQuery = QueryCreator
                .update("Cars")
                .set(setParameter("Name", "RoyceRoyce"))
                .where(where("Name")
                        .isEqualTo("Porsche"))
                .create();

        System.out.println(updateQuery);

        String query1 = QueryCreator
                .select("")
                .from("")
                .create();
        System.out.println(query1);

        String selectFromClassQuery = QueryCreator
                .select(DummyEntity.class)
                .from(DummyEntity.class)
                .create();
        System.out.println(selectFromClassQuery);

        String selectAllFromQuery = QueryCreator
                .selectAllFrom(DummyEntity.class)
                .create();
        System.out.println(selectAllFromQuery);

    }
}
