var bytes = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get('sample_data.txt'));
var content = new java.lang.String(bytes);
var lines = content.split("\r\n");
var csv = new Array();
var chartData =new Array();
for (var i = 0; i < lines.length; i++) {
    csv[i] =lines[i].split(",");
    chartData[i] = new javafx.scene.chart.PieChart.Data(csv[i][0], csv[i][1]);
}
var pieChartData = javafx.collections.FXCollections.observableArrayList(chartData);
var chart = new javafx.scene.chart.PieChart(pieChartData);
chart.setTitle("Population of the Continents");
$STAGE.scene = new javafx.scene.Scene(chart);
$STAGE.title = "Pie chart";

