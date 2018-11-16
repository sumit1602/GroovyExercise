<!DOCTYPE html>
<html lang="en">
<head>

    <title></title>
    <meta name="layout" content="main">

</head>

<body>

<div class=" container">

    <div class="col-lg-7">

        <g:render template="userProfileInfo"></g:render>
        <br/><br/>
        <g:render template="userTopics"></g:render>

    </div>

    <div class="col-lg-5">

        <g:render template="userInfoUpdate"></g:render>
        <g:render template="userChangePassword"></g:render>

    </div>
</div>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>