<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
    <jsp:useBean id="mod" class="com.model.User" scope="session" />
    <html>

    <head>
        <meta charset="ISO-8859-1">
        <title>Insert title here</title>
    </head>
    <style>
        body {
            background: #89e1e9;
        }
        
        form {
            width: 60%;
            margin: 60px auto;
            background: #efefef;
            padding: 60px 120px 80px 120px;
            text-align: center;
            -webkit-box-shadow: 2px 2px 3px rgba(0, 0, 0, 0.1);
            box-shadow: 2px 2px 3px rgba(0, 0, 0, 0.1);
        }
        
        label {
            display: block;
            position: relative;
            margin: 40px 0px;
        }
        
        .label-txt {
            position: absolute;
            top: -1.6em;
            padding: 10px;
            font-family: sans-serif;
            font-size: .8em;
            letter-spacing: 1px;
            color: rgb(120, 120, 120);
            transition: ease .3s;
        }
        
        .input {
            width: 100%;
            padding: 10px;
            background: transparent;
            border: none;
            outline: none;
        }
        
        .line-box {
            position: relative;
            width: 100%;
            height: 2px;
            background: #BCBCBC;
        }
        
        .line {
            position: absolute;
            width: 0%;
            height: 2px;
            top: 0px;
            left: 50%;
            transform: translateX(-50%);
            background: #e17bee;
            transition: ease .6s;
        }
        
        .input:focus+.line-box .line {
            width: 100%;
        }
        
        .label-active {
            top: -3em;
        }
        
        button {
            display: inline-block;
            padding: 12px 24px;
            background: rgb(220, 220, 220);
            font-weight: bold;
            color: rgb(120, 120, 120);
            border: none;
            outline: none;
            border-radius: 3px;
            cursor: pointer;
            transition: ease .3s;
        }
        
        #ll {
            padding-left: 10%;
        }
        
        button:hover {
            background: #8BC34A;
            color: #ffffff;
        }
        
        #al {
            visibility: hidden;
        }
        .button {
    display: block;
    margin: 0px 330px;
    width: 115px;
    height: 25px;
    background: #4E9CAF;
    padding: 10px;
    text-align: center;
    border-radius: 5px;
    color: white;
    font-weight: bold;
    line-height: 25px;
}
    </style>

    <body>
        <div class="container">

            <div id="al" class="alert alert-primary" role="alert">

            </div>
            <form>
                <div class="container">
                    <h1>Hi , ${user.uname}</h1>
                    <br>
                    <div class="row">
                    <br>
                        <div class="col">
                            <a class="button" href="sub1qs.jsp?un=${user.uname}">PYTHON</a>
                        </div>
                        <br>
                        <div class="col">
                            <a class="button" href="sub2qs.jsp?un=${user.uname}">JAVA</a>
                        </div>
                        <br>
                        <div class="col">
                            <a class="button" href="sub3qs.jsp?un=${user.uname}">C++</a>
                        </div>
                        <br>
                        <div class="col">
                            <a class="button" href="sub4qs.jsp?un=${user.uname}">C</a>
                        </div>
                        <br>
                    </div>
                    <br>
                    <a class="button" href="getmarks.jsp?un=${user.uname}">Show Marks</a>
                    <br>
                    <br>
                    <a  href="index1.html">Home</a>

                </div>

            </form>
            <script src="formscript.js"></script>

            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>

    </html>