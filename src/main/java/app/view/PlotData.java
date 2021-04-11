package app.view;

import app.genetic.core.Population;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class PlotData {
    private static List<Integer> epochs = new ArrayList<>();
    private static List<Double> maxGrades = new ArrayList<>();
    private static List<Double> means = new ArrayList<>();
    private static List<Double> standardDeviations = new ArrayList<>();

    public static void clearPlotData() {
        epochs.clear();
        maxGrades.clear();
        means.clear();
        standardDeviations.clear();
    }

    public static String getPlotData() {
        JSONArray epochs = new JSONArray();
        epochs.addAll(getEpochs());

        JSONArray maxGrades = new JSONArray();
        maxGrades.addAll(getMaxGrades());
        JSONObject functionValuePlotData = new JSONObject();
        functionValuePlotData.put("title", "Function value");
        functionValuePlotData.put("x", epochs);
        functionValuePlotData.put("y", maxGrades);


        JSONArray meanValues = new JSONArray();
        meanValues.addAll(getMeans());
        JSONObject meanFunctionValuePlotData = new JSONObject();
        meanFunctionValuePlotData.put("title", "Mean function value");
        meanFunctionValuePlotData.put("x", epochs);
        meanFunctionValuePlotData.put("y", meanValues);


        JSONArray standardDeviations = new JSONArray();
        standardDeviations.addAll(getStandardDeviations());
        JSONObject standardDeviationsPlotData = new JSONObject();
        standardDeviationsPlotData.put("title", "Standard deviations");
        standardDeviationsPlotData.put("x", epochs);
        standardDeviationsPlotData.put("y", standardDeviations);

        List<String> plots = new ArrayList<>();
        plots.add(functionValuePlotData.toString());
        plots.add(meanFunctionValuePlotData.toString());
        plots.add(standardDeviationsPlotData.toString());

        return plots.toString();
    }

    public static List<Double> getMaxGrades() {
        return maxGrades;
    }

    public static String getMaxGradesAsJson() {
        JSONObject obj = new JSONObject();
        return JSONArray.toJSONString(maxGrades);
    }

    public static List<Double> getMeans() {
        return means;
    }

    public static List<Double> getStandardDeviations() {
        return standardDeviations;
    }

    public static void createEpochsAxis(int epochsNumber) {
        epochs = new ArrayList<>();
        for (int i = 0; i < epochsNumber; i++) {
            epochs.add(i+1);
        }
    }

    public static List<Integer> getEpochs() {
        return epochs;
    }

    public static void setParams(Population population) {
        int bestIt = 0;
        double best = population.getElement(0).getGrade();
        double sum = 0;
        double mean = 0;
        for(int i = 0; i < population.getPopulationSize(); i++) {
            if(population.getElement(i).getGrade() > best) {
                bestIt = i;
                best = population.getElement(i).getGrade();
            }
            sum += calculateValue(i, population);
        }
        mean = sum / population.getPopulationSize();

        double squaresSum = 0;
        for(int i = 0; i < population.getPopulationSize(); i++) {
            squaresSum += Math.pow(calculateValue(i, population) - mean, 2);
        }

        means.add(mean);
        maxGrades.add(calculateValue(bestIt, population));
        standardDeviations.add(Math.sqrt(squaresSum / population.getPopulationSize()));
    }

    private static double calculateValue(int i, Population population) {
        return Math.pow(population.getFirstChromosomeRealNumber(i), 2) + Math.pow(population.getSecondChromosomeRealNumber(i), 2);
    }

    public static final String getPlotHtmlTemplate() {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Genetic algorithm - Results</title>\n" +
                "    <script src=\"https://cdn.plot.ly/plotly-latest.min.js\"></script>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div id=\"plot-container\"></div>\n" +
                "<script>\n" +
                "\n" +
                "    //INSERT_JSON_HERE\n" +
                "\n" +
                "    const plots = JSON.parse(json);\n" +
                "    const container = document.getElementById('plot-container');\n" +
                "\n" +
                "    plots.forEach((plot, i) => {\n" +
                "        const plotData = [{\n" +
                "            mode: 'lines',\n" +
                "            line: {color: '#b55400'},\n" +
                "            x: plot.x,\n" +
                "            y: plot.y\n" +
                "        }];\n" +
                "\n" +
                "        const plotLayout = {\n" +
                "            title: plot.title,\n" +
                "            uirevision: 'true',\n" +
                "            xaxis: {autorange: true},\n" +
                "            yaxis: {autorange: true}\n" +
                "        };\n" +
                "\n" +
                "        const plotContainer = document.createElement(\"div\");\n" +
                "        plotContainer.id = `plot-${i}`;\n" +
                "        plotContainer.style.marginBottom = '20px';\n" +
                "        container.appendChild(plotContainer);\n" +
                "\n" +
                "        Plotly.react(`plot-${i}`, plotData, plotLayout);\n" +
                "    });\n" +
                "</script>\n" +
                "</body>\n" +
                "</html>";
    }
}
