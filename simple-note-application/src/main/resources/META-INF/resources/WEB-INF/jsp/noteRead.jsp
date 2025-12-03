<%@include file="common/header.jspf" %>
<%@include file="common/navbar.jspf" %>

<div class="container">
    <div class="header">
        <div class="header-info">
            <h1>Title : ${note.title}</h1>
            <h4>Date : ${note.date}</h4>
            <h4>Author : ${note.username}</h4>
        </div>
        <div class="right-align">
            <a href="note-edit?noteId=${note.id}" class="btn btn-success">edit</a>
        </div>
    </div>
    <hr>
    <p>
        -->>>--
    </p>
    <div class="block">${note.contents}
    </div>
</div>

<style>
    .header {
        display: flex;
        width: 100%;
        align-items: flex-start;
        margin-bottom: 20px;
    }

    .header-info {
        flex-grow: 1;
    }

    .right-align {
        margin-left: auto;
    }
</style>
<style>
    .block {
        white-space: pre-wrap;
    }
</style>
<%@include file="common/footer.jspf" %>