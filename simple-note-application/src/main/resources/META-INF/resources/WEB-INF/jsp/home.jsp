<%@include file="common/header.jspf" %>
<%@include file="common/navbar.jspf" %>
<div class="container">
    <h1>Simple Note Home</h1>
    <h3>
        <!-- Suppose that root node's ID is 1. -->
        <a href="note-list?nodeId=1">recent log</a>
    </h3>
    <div>
        <table class="table">
            <thead>
            <tr>
                <th>User</th>
                <th>type</th>
                <th>Date</th>
                <th>Title</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${notes}" var="note">
                <tr>
                    <td>${note.username}</td>
                    <td>${note.type}</td>
                    <td>${note.date}</td>
                    <td>${note.title}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<%@include file="common/footer.jspf" %>