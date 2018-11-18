<!DOCTYPE html>
<html lang="en">
<head>
    <title>LinkSharing-Project</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">


    <style>
    .header1{
        padding: 10px 10px 10px 10px;
        margin: 0px 0px 20px 0px;
        border: 2px solid green;
        border-radius: 20px;
    }
    .input-group{
        float: right;
    }

    </style>
    <g:layoutHead/>
</head>
<body>

<form class="form-inline">
<div class="header1 col-lg-12">
    <div class=" col-lg-8">
        <span>

            <div>
                %{--<button type="button" class="btn btn-link"--}%
                         %{--href="${createLink(controller: 'login', action: 'index')}">Link Sharing</button>--}%
%{--<g:form controller="search" action="index">--}%
    <span>
        <a class="navbar-brand" href="${createLink(controller: 'login', action: 'index')}">Link Sharing</a>
    </span>
                <g:form controller="search" action="index">
                    <div class="input-group" class="col align-self-end">
                        <input type="text" class="form-control " placeholder="Search" name="search">

                        <div class="input-group-btn">
                            <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i>
                            </button>
                        </div>
                    </div>
                </g:form>
            </div>
        </span>
    </div>

    <ul class="nav navbar-nav col-lg-4">

        <g:if test="${session.user}">

            <li class="col-lg-1" style="padding: 0px">
                <a href="#myModal" data-toggle="modal" data-target="#myModal">
                    <i class="fa fa-comments" style="font-size:20px;color:lawngreen"></i>
                </a>
            </li>
            <g:render template="/topic/createTopic"></g:render>


            <li class="col-lg-1" style="padding: 0px">
                <a href="#myModal2" data-toggle="modal" data-target="#myModal2">
                    <i class="fa fa-envelope"style="font-size:20px;color:yellow"></i>
            </a>
            </li>
            <g:render template="/topic/email"></g:render>

            <li class="col-lg-1" style="padding: 0px">
                <a href="#myModal3" data-toggle="modal" data-target="#myModal3">
                    <i class="fa fa-link"style="font-size:20px;color:red"></i>
                </a>
            </li>
            <g:render template="/resource/createLinkResource"></g:render>


            <li class="col-lg-1" style="padding: 0px">
                <a href="#myModal4" data-toggle="modal" data-target="#myModal4">
                    <i class="fa fa-file" style="font-size:20px;color:black"></i>
                </a>
            </li>
            <g:render template="/resource/createDocumentResource"></g:render>


            <li class="dropdown  col-lg-8" style="padding: 2px">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-user"style="font-size:20px"></i>
                    ${session.user.getFullName()}
                    <span class="caret"></span>
                </a>
                <ul class="dropdown-menu" class="col align-self-end">
                    <li><g:link controller="user" action="editProfile">Profile</g:link></li>
                    <g:if test="${session.user}">
                        <li><g:link controller="user" action="showUserList">Users</g:link></li>
                        <li><g:link controller="user" action="showTopics">Topic</g:link></li>
                        <li><g:link controller="resource" action="showPosts">Post</g:link></li>
                    </g:if>
                    <g:if test ="${session.user.admin}">
                        <li><g:link controller="user" action="showUserList">Admin</g:link></li>
                    </g:if>
                    <li><g:link controller="login" action="logout">Logout</g:link></li>
                </ul>
            </li>
        </g:if>

    </ul>
    </div>
</form>

%{--<g:if test="${session.user == null}">--}%
    <g:if test="${flash.error}">
        <g:message message="${flash.error}"></g:message>
    </g:if>
    <g:if test="${flash.message}">
        <g:message message="${flash.message}"></g:message>
    </g:if>
%{--</g:if>--}%
<g:layoutBody/>

</body>
</html>