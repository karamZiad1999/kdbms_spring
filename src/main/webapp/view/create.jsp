<html>
<head>
    <meta charset="ISO-8859-1">
    <title>KDBMS</title>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-md bg-dark navbar-dark">

    <a class="navbar-brand" href="#">KDBMS</a>
</nav>
<br>
<br>
<div class = "container">
    <div class = "row">
        <div class ="col-lg-6 col-md-6 col-sm-6 container justify-content-center card">
            <h1 class = "text-center"> Insert New Record </h1>
            <div class = "card-body">
                <form action="/${schema}/${table}/create" method="POST">
                    <div class ="form-group">
                        <input type="text" name="values"/>
                    </div>
                    <div class = "box-footer">
                        <button type="submit" class = "btn btn-primary">Submit</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>