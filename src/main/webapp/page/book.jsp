<%@ page import="ir.maktabsharif.dto.book.BookResponseDto" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: anon
  Date: 10/16/2026
  Time: 12:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book</title>
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/toastify-js/src/toastify.min.css">
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/toastify-js"></script>

</head>
<body>

<form onsubmit="addBook(event)">
    <label for="title">Title</label>
    <input id="title" name="title">
    <label for="author">Author</label>
    <input id="author" name="author">
    <label for="publicationYear">publicationYear</label>
    <input id="publicationYear" name="publicationYear" type="number" min="1900" max="2026">

    <button>Submit</button>
</form>
<table border="1" width="500" align="center">
    <tr bgcolor="00FF7F">
        <th><b>Title</b></th>
        <th><b>Author</b></th>
        <th><b>Publication Year</b></th>
    </tr>
    <%-- Fetching the attributes of the request object
         which was previously set by the servlet
          "StudentServlet.java"
    --%>
    <%
        List<BookResponseDto> std =
                (List<BookResponseDto>) request.getAttribute("books");
        for (BookResponseDto b : std) {
    %>
    <%-- Arranging data in tabular form
    --%>
    <tr>
        <td><%=b.title()%>
        </td>
        <td><%=b.author()%>
        </td>
        <td><%=b.publicationYear()%>
        </td>
        <td onclick="deleteBook(<%=b.id()%>)">🗑️
        </td>
    </tr>
    <%}%>
</table>

</body>

<script>
    async function deleteBook(id) {
        fetch("http://localhost:8080/book" + "/" + id, {
            method: "DELETE"
        }).then(() => {
            Toastify({
                text: "Book with ID: " + id + " deleted successfully",
                duration: 3000,
                destination: "https://github.com/houtanrocky",
                newWindow: true,
                close: true,
                gravity: "top", // `top` or `bottom`
                position: "left", // `left`, `center` or `right`
                stopOnFocus: true, // Prevents dismissing of toast on hover
                style: {
                    background: "linear-gradient(to right, #00b09b, #96c93d)",
                },
                onClick: function () {
                } // Callback after click
            }).showToast().then(() => {
                window.location.reload();
            });
        })
    }

    async function addBook(event) {
        event.preventDefault();
        const formData = new FormData(event.target);

        const author = formData.get('author');
        const title = formData.get('title');
        const publicationYear = formData.get('publicationYear');

        fetch("http://localhost:8080/book", {
            method: "POST",
            body: JSON.stringify({
                    author,
                    title,
                    publicationYear
                }
            )
        }).then(() => {
            window.location.reload();
        })

        //
        // await fetch("http://localhost:8080/book", {
        //     method: "POST",
        //     body: {
        //         author,
        //         title,
        //         publicationYear
        //     }
        // })
        // window.location.reload();
    }
</script>
</html>
