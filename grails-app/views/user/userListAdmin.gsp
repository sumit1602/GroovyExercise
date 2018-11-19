<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="layout" content="main">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>

<div class="container">
    <div class="col-sm-12">
        <div class="panel-heading" STYLE="background: yellow"><center>ALL USERS</center></div>
        <table class="table tab-content" border="2px solid red">
            <thead>
            <tr>
                <th>NAME</th>
                <th>EMAIL</th>
                <th>IS_ACTIVE</th>
                <th>CHANGE_ACTIVE_STATUS</th>
                %{--<th>TOPIC_COUNT</th>--}%
                <th>RESOURCE_COUNT</th>
                <th>SUBSCRIPTION_COUNT</th>
            </tr>
            </thead>

            <tbody>
            <g:each in="${allUsers}" var="user">
                <tr>
                    <td>${user.fullName}</td>
                    <td>${user.email}</td>
                    <td>${user.isActive}</td>
                    <td>
                    <a href="${createLink(controller: 'user', action: 'activateDeactivate', id: "${user.userId}")}">
                        <g:if test="${user.isActive}">
                            DeActivate
                        </g:if>
                        <g:else>
                            Activate
                        </g:else>
                    </a>
                    </td>

                    %{--<td>user.topicCount</td>--}%
                    <td>${user.resourceCount}</td>
                    <td>${user.subscriptionCount}</td>
                </tr>
            </g:each>
            </tbody>

        </table>
    </div>
</div>

</body>
</html>
