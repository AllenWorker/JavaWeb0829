

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.3/build/pure-min.css" integrity="sha384-cg6SkqEOCV1NbJoCu11+bm0NvBRc8IYLRGXkmNrqUBfTjmMYwNKPWBTIKyw9mHNJ" crossorigin="anonymous">
    </head>
    <body style="padding: 20px">
        <form action="/JavaWeb0829/servlet/bmi">
            姓名: <input type="text" name="name"><p/>
            身高: <input type="number" name="h"><p/>
            體重: <input type="number" name="w"><p/>
            <input type="submit" value="計算">
        </form>
        
        <form class="pure-form pure-form-aligned" action="/JavaWeb0829/servlet/bmi" method="post">
            <fieldset>
                <legend>BMI Forms</legend>
                <div class="pure-control-group">
                    <label for="aligned-name">姓名:</label>
                    <input type="text" id="aligned-name" placeholder="姓名" name="name" />
                    <span class="pure-form-message-inline">This is a required field.</span>
                </div>
                <div class="pure-control-group">
                    <label for="aligned-height">身高:</label>
                    <input type="number" id="aligned-height" placeholder="身高" name="h" />
                </div>
                <div class="pure-control-group">
                    <label for="aligned-weight">體重:</label>
                    <input type="number" id="aligned-weight" placeholder="體重" name="w" />
                </div>
                <div class="pure-controls">
                    <button type="submit" class="pure-button pure-button-primary">Submit</button>
                </div>
            </fieldset>
        </form>
    </body>
</html>
