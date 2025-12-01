<%@include file="../common/header.jspf"%>
<%@include file="../common/navbar.jspf"%>

<div class="container">
    <a href="noteEdit.jsp" class="btn btn-success">edit</a>
    <h1>Title : ${note.title}</h1>
    > ${note.contents}
</div>

<%@include file="../common/footer.jspf"%>