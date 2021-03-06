<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@attribute name="sleep" required="true" rtexprvalue="true" %>
<html>
  <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {

        var data = google.visualization.arrayToDataTable([
          ['項目', '小時'],
          ['工作',     11],
          ['飲食',      2],
          ['交流',  2],
          ['看電視', 2],
          ['睡覺',    ${sleep}]
        ]);

        var options = {
          title: 'My Daily Activities',
          is3D:true
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      }
    </script>
  </head>
  <body>
    <div id="piechart" style="width: 900px; height: 500px;"></div>
  </body>
</html>
