<%@page import="br.com.projetocomputador.model.Computador"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>Listagem de Computadores</title>
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
              font-size: 30px;
              color: #7900FF;
              text-transform: uppercase;
              font-weight: 300;
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
            <h1>Lista de Computadores</h1>
            <div class="tbl-header">
                <table cellpadding="0" cellspacing="0" border="0">

                   <thead>
                       <tr>
                           <th align="center">ID Computador</th>
                           <th align="center">Fornecedor</th>
                           <th align="center">Preço</th>
                           <th align="center">Ssd</th>
                           <th align="center">Ram</th>
                           <th align="center">ID Produto</th>
                           <th align="center">Tipo</th>
                           <th align="center" colspan="2">Editar</th>
                       </tr>
                   </thead>
                </table>
            </div>
            <%
                List<Computador> computadores = (List<Computador>)request.getAttribute("computadores");
                for(Computador computador:computadores){
            %>
            
            <table cellpadding="0" cellspacing="0" border="0">
      <tbody>
            <tr>
                <td><%=computador.getIdComputador()%></td>
                <td><%=computador.getFornecedorProduto()%></td>
                <td><%=computador.getPrecoProduto()%></td>
                <td><%=computador.getSsdComputador()%></td>
                <td><%=computador.getRamComputador()%></td>
                <td><%=computador.getIdProduto()%></td>
                <td><%=computador.getIdTipo().getTipoComputador()%></td>
                <td><a href="ExcluirComputador?idProduto=<%=computador.getIdProduto()%>">Excluir</a></td>
                <td><a href="CarregarComputador?idProduto=<%=computador.getIdProduto()%>">Alterar</a></td>
            </tr>
            
            <%
                }
            %>
      </tbody>
        </table>    
        <ul>
                <li><a href="index.jsp" class="fade-in">Voltar</a></p></li>
        </ul>
    </body>
</html>
