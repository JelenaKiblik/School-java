package ee.taltech.iti0202.cakeorder;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

public class CakeOrderProcessor {
    public enum CakeOrderProcessorType {
        MAKE_DAIRY_FREE,
        COUNT_TOTAL_SUM,
        REMOVE_BEST_BEFORE_DAY_OVER
    }

    private CakeOrderProcessorType type;

    public CakeOrderProcessor(CakeOrderProcessorType type) {
        this.type = type;
    }

    public String process(String jsonInput) {
        String result = "";
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(jsonInput);
        JsonObject object = element.getAsJsonObject();
        JsonArray array = object.get("cakes").getAsJsonArray();

        for (int i = 0; i < array.size(); i++) {
            JsonElement cakesArray = array.get(i);
            for (int l = 0; l < cakesArray.getAsJsonObject().get("ingredients").getAsJsonArray().size(); l++) {
                String ingredient = cakesArray.getAsJsonObject().get("ingredients").getAsJsonArray().get(l)
                        .getAsString();
                System.out.println(ingredient);
                if (type.equals(CakeOrderProcessorType.MAKE_DAIRY_FREE)) {
                    if (ingredient.equals("milk")) {
                        cakesArray.getAsJsonObject().get("ingredients").getAsJsonArray().set(l,
                                new JsonPrimitive("plant-milk"));
                    } else if (ingredient.equals("cream-cheese")) {
                        cakesArray.getAsJsonObject().get("ingredients").getAsJsonArray().set(l,
                                new JsonPrimitive("plant-cream-cheese"));
                    }
                    System.out.println(object);
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        CakeOrderProcessor orderProcessor = new CakeOrderProcessor(CakeOrderProcessorType.MAKE_DAIRY_FREE);
        System.out.println(orderProcessor.process(
                "{\n"
                        + "  \"cakes\": [\n"
                        + "    {\n"
                        + "      \"name\": \"Sacher\",\n"
                        + "      \"BBD\": \"2019-04-29\",\n"
                        + "      \"price\": 14.00,\n"
                        + "      \"kg\": 2.00,\n"
                        + "      \"ingredients\": [\"flour\", \"chocolate\", \"milk\", \"sugar\", \"eggs\"]\n"
                        + "    },\n"
                        + "    {\n"
                        + "      \"name\": \"New York Cheesecake\",\n"
                        + "      \"BBD\": \"2019-04-30\",\n"
                        + "      \"price\": 10.00,\n"
                        + "      \"kg\": 1.50,\n"
                        + "      \"ingredients\": [\"flour\", \"cream-cheese\", \"milk\", \"sugar\", \"eggs\"]\n"
                        + "\n"
                        + "    }\n"
                        + "  ]\n"
                        + "}"
        ));
    }
}
