<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Raleway&display=swap" rel="stylesheet">
        <title>Home | System Computer</title>
    </head>
    <body>
        <style>
            *{
                font-family: 'Raleway', sans-serif;
                padding: 0;
                margin: 0;
            }
            body{
                height: 100vh;
                background-color: #D9D9D9;
                background-size: cover;
                background-repeat: no-repeat;
            }
            main
            {
                display: flex;
                flex-direction: column;
                justify-content: space-around;
                align-items: center;
                height: 100%;
            }
            #back{
                position: absolute;
                left: 35px;
                margin-bottom: 40rem;
                font-size: 2.5rem;
            }
            h1{
                color: #7900FF;
                margin-top: 4rem;
                font-size: 3rem;
                text-align: center;
                font-weight: 700;
                
            }
            ul
            {
                margin: auto auto;
                width: 30%;
                display: flex;
                justify-content: space-around;
                align-items: center;
                
            }
            ul li{
                display: inline-block;
                justify-content: space-between;
            }
            ul li a{
                color: black;
                text-transform: uppercase;
                text-decoration: none;
                transition: 0.2s;
                font-size: 2rem;
            }
            a:hover{
                color: #7900FF;
                margin-bottom: 4px;
                font-size: 2rem;
                opacity: 2;
                display: block;
            }
            
            .fade-in{
                animation-name: fade-in;
                animation-duration: 0.5s;
                animation-iteration-count: 1;
                animation-timing-function: ease-in;
            }

            @keyframes fade-in{
                0% {
                    transform: translate(0, -10px);
                    opacity: 0;
                }
                100%{
                    transform: translate(0, 0px);
                    opacity: 1;
                }
            }

            @keyframes slide-menu-down{
                100%{
                    width: 100vw;
                    height: 14rem;
                }
            }

            @keyframes slide-menu-up{
                100%{
                    width: 40px;
                }
            }
            @keyframes fade-out{
                0% {
                    transform: translate(0, 0px);
                    opacity: 1;
                }
                100%{
                    transform: translate(0, -10px);
                    opacity: 0;
                }
            }
            
            
        </style>
        
        <main>
            <a id="back" href="index.jsp" class="fade-in"><i class="bi bi-chevron-left"></i></a>

            <h1 class="fade-in">Controle de Computadores</h1><br><br>
            <br>
            <hr>
                ${message}
            <ul>
                <li><a href="CarregarTipoComputador" class="fade-in">Cadastrar</a></li>
                
                <li><a href="ListarComputador" class="fade-in">Listar</a></li>                
            </ul>
           
        </main>
        
    </body>
</html>
