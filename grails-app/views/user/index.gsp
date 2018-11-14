<!DOCTYPE html>
<html lang="en">
<head>

    <title></title>
    <meta name="layout" content="main">

</head>

<body>

<div class="container">
    <div class="col-lg-6">
        <div class="panel panel-primary col-lg-12">
            <div class="panel-body">
                <div class="col-sm-12">
                    <div class="row">

                        <div class="col-sm-3">
                            <ls:userImage username="${session.user.fullName}" height="100" width="100"/>
                        </div>

                        <div class="col-sm-9">

                            <p>${session.user.getFullName()}<br>
                                <small class="text-muted">@${session.user.fullName}</small>
                            </p>

                            <div class="row">

                                <h6 class="text-muted col-sm-6">Subscriptions
                                    <p class="text-primary">30</p>
                                </h6>

                                <h6 class="text-muted col-sm-6">Topics
                                    <p class="text-primary">50</p>
                                </h6>

                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>


        <br><br>


        %{--____--}%



        <g:render template="/resource/recentShares"></g:render>

        <g:render template="/resource/topPosts"></g:render>

    </div>

    <div class="col-lg-6">

        <br><br>
        <g:render template="/resource/createLinkResource"></g:render>
        <g:render template="/user/inbox"></g:render>
        <br><br>

        <br><br>
        <g:render template="/resource/createDocumentResource"></g:render>
        %{--<g:render template="subscriptions"></g:render>--}%

        <br>

        %{--<div class="col-lg-12"><br></div>--}%
        %{--<br>--}%

        %{--<g:render template="/topic/trendingTopics"></g:render>--}%

        %{--</div>--}%

</body>
</html>