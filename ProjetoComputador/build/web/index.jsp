<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Raleway&display=swap" rel="stylesheet">
        <title>Início | System Computer</title>
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
                width: 100%;
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
            <h1 class="fade-in">Controle de Computadores</h1><br><br>
            
            <ul>
                <li><a href="acessarusuario.jsp" class="fade-in">Login</a></li>
                <li><a href="cadastrarusuario.jsp" class="fade-in">Cadastrar</a></li>
            </ul>
    
        </main>
            </body>
</html>
