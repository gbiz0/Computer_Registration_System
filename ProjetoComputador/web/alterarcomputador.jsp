<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar dados</title>
    </head>
    <body>
        <style>
            *{
                font-family: 'Raleway', sans-serif;
                padding: 0;
                margin: 0;
            }
            body{
                background-image: url(train.jpg);
                background-size: cover;
                background-repeat: no-repeat;
            }
            h1{
                color: #8257e6;
                margin-top: 1rem;
                font-size: 3rem;
                text-align: center;
                font-weight: 700;
            }
            p{
                text-align: center;
                font-size: 1.3rem;
                color: white;
            }
            input{
                display: flex;
                margin-left: auto;
                margin-right: auto;
            }
            ul li{
                display: flex;
            }
            ul li a{
                color: white;
                text-transform: uppercase;
                text-decoration: none;
                transition: 0.2s;
                font-size: 2rem;
                align-items: center;
            }
            a:hover{
                color: #8257e6;
                font-size: 2rem;
                opacity: 2;
                display: block;
            }
        </style>
        <h1 align="center">Alterar dados</h1>
        <form name="alterarcomputador" action="AlterarComputador" method="POST">

                        <p colspan="2" align="center">${mensagem}</p>
                    
                        <p>ID:</p>
                        <input type="text" name="idComputador" value="${computador.idComputador}" readonly="true">
                        
                        <p>Fornecedor</p>
                        <input type="text" name="fornecedorComputador" value="${computador.fornecedorComputador}">
                            
                        <p>Preço:</p>
                        <input type="text" name="precoComputador" value="${computador.precoComputador}">
                            
                        <p>Ram:</p>
                        <input type="text" name="ramComputador" value="${computador.ramComputador}">
                            
                        <p>Ssd:</p>
                        <input type="text" name="ssdComputador" value="${computador.ssdComputador}">
                 

                        <input type="submit" name="cadastrar" value="Cadastrar">

                <a href="index.jsp">Voltar</a>
        </form>
    </body>
</html>
