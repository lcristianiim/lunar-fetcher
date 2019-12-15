/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package lunar.fetcher;

import com.google.gson.Gson;
import lunar.model.LunarDataSet;
import lunar.model.LunarDataSetsBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        int startYear = Integer.parseInt(args[0]);
        int endYear = Integer.parseInt(args[1]);
        int numberRepresentationOfPlace = Integer.parseInt(args[2]);
        String location = args[3];

       List<LunarDataSet> result = createLunarSets(startYear, endYear, numberRepresentationOfPlace, location);

       writeLunarDataToJsonFile(startYear, endYear, result);
   }

    private static void writeLunarDataToJsonFile(int startYear, int endYear, List<LunarDataSet> result) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(startYear + "-" + endYear + ".json")) {
            String jsonString = gson.toJson(result);
            writer.write(jsonString);
          } catch (IOException e) {
            LOGGER.log(Level.SEVERE,"exception " + e.getMessage());
        }
    }

    private static List<LunarDataSet> createLunarSets(int startYear, int endYear, int numberRepresentationOfPlace, String location) {
        LunarDataSetsBuilder builder = new LunarDataSetsBuilder(
                startYear, endYear, numberRepresentationOfPlace, location);
        return builder.generateLunarData();
    }
}
