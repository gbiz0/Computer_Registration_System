<%
    HttpServletRequest httpServletRequest = (HttpServletRequest) request;

    HttpSession sessao = httpServletRequest.getSession();

    if (sessao.getAttribute("usuario") != null) {
%>

<%@page import="br.com.projetocomputador.model.Item"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Raleway&display=swap" rel="stylesheet">
         <title>Listagem de Fornecedores | System Computer</title>
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
            }
  
            h1{
              margin-top: 2rem;
              font-size: 2rem;
              color: #7900FF;
              font-weight: 700;
              text-align: center;
              margin-bottom: 2rem;
            }
            table{
              width:100%;
              table-layout: fixed;
            }
            .tbl-header{
              background-color: rgba(255,255,255,0.3);
             }
            .tbl-content{
              height:300px;
              overflow-x:auto;
              margin-top: 0px;
              border: 1px solid rgba(255,255,255,0.3);
            }
            th{
              padding: 20px 15px;
              text-align: center;
              font-weight: 500;
              font-size: 12px;
              color: #7900FF;
              text-transform: uppercase;
            }
            td{
              padding: 15px;
              text-align: center;
              vertical-align:middle;
              font-weight: 300;
              font-size: 12px;
              color: black;
              border-bottom: solid 1px rgba(255,255,255,0.1);
            }
            a{
                text-decoration: none;
                color: #7900FF;
            }
            a:hover{
                color: black;
            }

            ul li{
                text-align: center;
                font-size: 1.5rem;
                text-transform: uppercase;
            }

        </style>
            <h1>Itens Cadastrados</h1>
            <div class="tbl-header">
                <table cellpadding="0" cellspacing="0" border="0">

                   <thead>
                       <tr>
                           <th align="center">ID</th>
                           <th align="center">Nome Item</th>
                       </tr>
                   </thead>
                </table>
            </div>
            <%
                List<Item> itens = (List<Item>)request.getAttribute("itens");
                for(Item item:itens){
            %>
            
            <table cellpadding="0" cellspacing="0" border="0">
      <tbody>
            <tr>
                    <td><%=item.getIdItem()%></td>
                    <td><%=item.getNomeItem()%></td>
            </tr>
            
            <%
                }
            %>
      </tbody>
        </table>    
        <ul>
                <li><a href="start.jsp" class="fade-in">Voltar</a></p></li>
        </ul>
    </body>
</html>
<%
    }else{
        ((HttpServletResponse) response).sendRedirect("index.html");
    }
%>