<%@include file="common/header.jspf" %>
<%@include file="common/navbar.jspf" %>
<div class="container">
    <h2>category tree</h2>
    <div id="category-container" class="mt-4"></div>
    <div>
        <table class="table">
            <thead>
            <tr>
                <th>Title</th>
                <th>Type</th>
                <th>Date</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${noteList}" var="note">
                <tr class="clickable-row" data-note-id="${note.id}">
                    <td>${note.title}</td>
                    <td>${note.type}</td>
                    <td>${note.date}</td>
                    <td><a href="note-delete?noteId=${note.id}&nodeId=${note.groupid}" class="btn btn-warning">DELETE</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>


<script>
    const treeDataString = '<c:out value="${categoryTree}" escapeXml="false" />';
    const treeData = JSON.parse(treeDataString);

    function buildTreeHTML(treeData) {
        if (!treeData || treeData.length === 0) {
            return '';
        }
        let html = '<ul>';

        treeData.forEach(item => {
            html += '<li>';

            html += '<a href="#" class="clickable-node" data-category-id="' + item.id + '">';
            html += item.name;
            html += '</a>';

            if (item.children && item.children.length > 0) {
                html += buildTreeHTML(item.children);
            }
            html += '</li>';
        });
        html += '</ul>';
        return html;
    }

    const treeHTML = buildTreeHTML(treeData);
    document.getElementById('category-container').innerHTML = treeHTML;
</script>

<script>
    const clickableNode = document.querySelectorAll(".clickable-node");

    clickableNode.forEach(node => {
        node.addEventListener("click", function () {
            const categoryId = node.getAttribute('data-category-id');
            const url = "/note-list?nodeId=" + categoryId;

            window.location.href = url;
        });
    });
</script>

<script>
    const clickableRows = document.querySelectorAll(".clickable-row");

    clickableRows.forEach(row => {
        row.addEventListener("click", function () {
            const noteId = row.getAttribute('data-note-id');
            const url = "note-read?noteId=" + noteId;

            window.location.href = url;
        })
    })
</script>

<style>
    .clickable-row {
        cursor: pointer;
    }

    .clickable-row {
        background-color: beige;
    }

    .clickable-row:hover {
        background-color: cyan;
    }
</style>
<style>
    .clickable-node {
        color: black;
        text-decoration: none;
    }

    .clickable-node:hover {
        color: black;
        background-color: cyan;
    }
</style>

<%@include file="common/footer.jspf" %>