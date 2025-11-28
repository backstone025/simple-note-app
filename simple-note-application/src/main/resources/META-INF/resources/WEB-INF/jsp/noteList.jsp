<%@include file="common/header.jspf" %>
<%@include file="common/navbar.jspf" %>

<h2>category tree</h2>
<div id="category-container" class="mt-4">
</div>

<script>
    const treeDataString = '<c:out value="${categoryTree}" escapeXml="false" />';
    const treeData = JSON.parse(treeDataString);

    function buildTreeHTML(treeData){
        if(!treeData || treeData.length === 0){
            return '';
        }
        let html = '<ul>';

        treeData.forEach(item => {
            html += '<li>';

            html += item.name;

            if(item.children && item.children.length > 0) {
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

<%@include file="common/footer.jspf" %>