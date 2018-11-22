<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="layout" content="main">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
<div class="col-lg-12">
    <div class="panel panel-primary col-lg-6" style="background: #ADFF2F">
        <div class="panel-heading" style="background: #ADFF2F">
            <h4>Topics:  "${topicVO.name}"</h4>
            <g:form class="form-inline" controller="search" action="index">
                <div class="input-group" class="col align-self-end" style="margin-top: -35px; border-radius: 20px;">
                    %{--<input type="text" class="form-control " placeholder="Search" name="search">--}%

                    <div class="input-group-btn">

                        <div class="input-group">
                            <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="glyphicon glyphicon-search"></i>

                                </button>
                            </span>
                            <input type="text" class="form-control" placeholder="Search" name="search">
                            <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="glyphicon glyphicon-remove-circle"></i>
                                </button>
                            </span>
                        </div>

                    </div>
                </div>
            </g:form>
        </div>


        <div class="panel-body">
            <div class="col-md-12">

                <div class="col-lg-9">
                    <div class="col-lg-12">

                        <div class="form-group">
                            <input type="text" class="form-control" name="newTopicName"
                                   placeholder="${topicVO.name}">
                            <g:hiddenField name="id" value="${topicVO.id}"/>
                        </div>
                    </div>


                    <div class="col-lg-12">
                        <div class="col-sm-6">
                            <h3 class="text-muted">@${topicVO.createdBy}</h3>
                        </div>

                        <div class="col-sm-3">
                            <h4 class="text-muted pull-left">Subscriptions
                                <p class="text-primary">${topicVO.subscriptionCount}</p>
                            </h4>
                        </div>

                        <div class="col-sm-3">
                            <h4 class="text-muted  pull-right">Post
                                <p class="text-primary">${topicVO.postCount}</p>
                            </h4>
                        </div>
                    </div>
                </div>

            </div>

            <div class="col-lg-12">

            </div>

            <div class="col-lg-12">

                <div class="col-lg-1">
                </div>
            </div>

        </div>

    </div>
</div>
</body>
</html>