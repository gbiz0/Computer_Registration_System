<%
    HttpServletRequest httpServletRequest = (HttpServletRequest) request;

    HttpSession sessao = httpServletRequest.getSession();

    if (sessao.getAttribute("usuario") != null) {
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/jquery-1.10.1.js" type="text/javascript"></script>
        <script src="js/jquery.validate.min.js" type="text/javascript"></script>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Raleway&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
    <title>Cadastro de Computadores | System Computer</title>
</head>
<body>
    <style>
        *{
            font-family: 'Raleway', sans-serif;
            padding: 0;
            margin: 0;
            box-sizing:border-box;
            -webkit-box-sizing:border-box;
            -moz-box-sizing:border-box;
            -webkit-font-smoothing:antialiased;
            -moz-font-smoothing:antialiased;
            -o-font-smoothing:antialiased;
            font-smoothing:antialiased;
            text-rendering:optimizeLegibility;
        }
        #contact{
            background: #5700BA;
            padding:25px;
            margin:50px 0;
            border-radius: 20px;
        }
        .container {
            max-width:500px;
            width:100%;
            margin:0 auto;
            position:relative;
        }
        fieldset {
            border: medium none !important;
            margin: 0 0 10px;
            min-width: 100%;
            padding: 0;
            width: 100%;
        }

        #contact input[type="text"], #contact input[type="number"]{
            width:100%;
            border:1px solid #CCC;
            background:#FFF;
            margin:0 0 5px;
            padding:10px;
            border-radius: 5px;
        }

        #contact input[type="text"]:hover, #contact input[type="number"]:hover{
            -webkit-transition:border-color 0.3s ease-in-out;
            -moz-transition:border-color 0.3s ease-in-out;
            transition:border-color 0.3s ease-in-out;
            border:1px solid #AAA;
        }

        #contact textarea {
            height:100px;
            max-width:100%;
            resize:none;
        }

        #contact button[type="submit"] {
            cursor:pointer;
            width:100%;
            border:none;
            background:#6500D9;
            color:#FFF;
            margin:0 0 5px;
            padding:10px;
            font-size:15px;
            border-radius: 15px;
        }

        #contact button[type="submit"]:hover {
            background:black;
            -webkit-transition:background 0.3s ease-in-out;
            -moz-transition:background 0.3s ease-in-out;
            transition:background-color 0.3s ease-in-out;
        }

        #contact button[type="submit"]:active {
            box-shadow:inset 0 1px 3px rgba(0, 0, 0, 0.5);
        }

        #contact input:focus, #contact textarea:focus {
            outline:0;
            border:1px solid #999;
        }


        body{
            background-color: #D9D9D9;
        }
        h1{
            color: #7900FF;
            margin-top: 1rem;
            font-size: 2rem;
            text-align: center;
            font-weight: 700;
        }
        p{
            text-align: center;
            font-size: 1.3rem;
            color: black;
        }
        input{
            display: flex;
            margin-left: auto;
            margin-right: auto;
        }
        ul li{
            display: flex;
            justify-content: center;

        }
        ul li a{
            color: 7900FF;
            text-transform: uppercase;
            text-decoration: none;
            transition: 0.2s;
            font-size: 1.5rem;
            align-items: center;
        }
        #back:hover{
            color: black;
            margin-top: 2px;
            opacity: 2;
            display: block;
        }
        .cadastrar{
            font-size: 1.5rem;
            background-color: #8257e6;
            color: white;
            text-decoration: none;
        }


        .cadastrar select{
            border-radius: 10px;
        }

        #clonablediv {
            width: 25%;
            display: flex;
            flex-direction: column;
        }

        #clonablediv .toclone {
            margin-bottom: 1rem;
        }
        
        .wrapper a {
            padding: 1rem; 
        }
    </style>
    <div class="container">
        <h1>Cadastrar Computador</h1>
        <form id="contact" name="cadastrarcomputador" action="CadastrarComputador" method="POST">

            <fieldset>
                <input  placeholder="Nome do Fornecedor" type="text" name="fornecedorProduto">
            </fieldset>

            <fieldset>
                <input placeholder="Preço do Produto" type="number" name="precoProduto">
            </fieldset>

            <fieldset>
                <input placeholder="Ram" type="number" name="ramComputador">
            </fieldset>

            <fieldset>
                <input placeholder="Ssd" type="number" name="ssdComputador">
            </fieldset>

            <select name="idTipo">
                <c:forEach var="tipo" items="${tipocomputadores}">

                    <option value ="${tipo.idTipo}">${tipo.tipoComputador}</option>
                </c:forEach>
            </select>
            <br>
            <br>

            <script type="text/javascript">
                function add() {
                    const clonable = document.getElementsByClassName('toclone')[0].cloneNode(true)
                    document.getElementById('clonablediv').appendChild(clonable)
                }

                function remove() {
                    const clonables = document.getElementsByClassName('toclone')
                    if (clonables.length > 1)
                        clonables[clonables.length - 1].remove()
                }
            </script>

            <div class="wrapper">
                <div id="clonablediv">
                    <select class="toclone" name="idItem">
                        <c:forEach var="item" items="${itens}">
                            <option value="${item.idItem}">
                                ${item.nomeItem}</option>
                            </c:forEach>
                    </select>
                </div>
                <a type="button" class="add" onClick="add()"><i class="bi bi-plus-circle"></i></a>
                <a type="button" class="remove" onClick="remove()"><i class="bi bi-dash-circle"></i></a>
            </div>

            <fieldset>
                <button class="cadastrar" type="submit" name="cadastrar" value="Cadastrar">Enviar</button>
            </fieldset>
        </form>    
    </div>

    <ul>
        <li><a id="back" href="start.jsp">Voltar</a></li>
    </ul>
    <p colspan="2" align="center">${mensagem}</p>

</body>
</html>
<%
    } else {
        ((HttpServletResponse) response).sendRedirect("index.html");
    }
%>