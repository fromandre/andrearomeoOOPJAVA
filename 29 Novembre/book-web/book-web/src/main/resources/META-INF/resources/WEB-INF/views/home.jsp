<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Books</title>
</head>
<body>
<h1>l'elenco dei miei books</h1><table>    
<tr>        
<th>            Autore        </th>       
<th>            Titolo        </th>   
</tr>    <c:forEach items="${books}" var="book">
<tr>       
<td>
${book.author}        
</td>
<td>
${book.title}
</td>
</tr>
</c:forEach>
</table>
</body>
</html>
