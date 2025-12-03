<%@include file="../common/header.jspf" %>
<%@include file="../common/navbar.jspf" %>

<div class="container">
    <%--@elvariable id="note" type="java"--%>
    <form:form method="post" modelAttribute="note">
        <div class="header">
            <div class="header-info">
                <fieldset class="mb-3">
                    <h1>
                        <form:label path="title">Title : </form:label>
                        <form:input path="title" type="text" required="required"/>
                        <form:errors path="title" cssClass="text-warning"/>
                    </h1>
                </fieldset>
                <fieldset class="mb-3">
                    <h4>
                        <form:label path="date">Date : </form:label>
                        <form:input path="date" type="text" required="required"/>
                        <form:errors path="date" cssClass="text-warning"/>
                    </h4>
                </fieldset>
                <fieldset class="mb-3">
                    <h4>
                        <form:label path="username">Author : </form:label>
                        <form:input path="username" type="text" required="required"/>
                        <form:errors path="username" cssClass="text-warning"/>
                    </h4>
                </fieldset>

            </div>
            <div class="right-align">
                <form:hidden path="id"/>
                <form:hidden path="groupid"/>
                <form:hidden path="type"/>
                <form:hidden path="state"/>
                <form:hidden path="metainfo"/>
                <input type="submit" class="btn btn-success" value="complete"/>
            </div>
        </div>
        <div class="block">
            <hr>
            <fieldset class="mb-3">
                <form:label path="contents">
                    <p>
                        -->>>--
                    </p>
                </form:label>
                <form:textarea path="contents"
                               rows="15"
                               class="form-control"
                               required="required"/>
                <form:errors path="contents" cssClass="text-warning"/>
            </fieldset>
        </div>
    </form:form>
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
<%@include file="../common/footer.jspf" %>