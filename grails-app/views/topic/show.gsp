<!DOCTYPE html>


<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <title></title>

    <meta name="layout" content="main">

</head>

<body>

<div class="container">
    <div class="col-lg-5">
        <div class="col-lg-12">
            <div class=" panel panel-default     ">
                <div class="panel-heading " style="background: grey">
                    <p>

                    <h3 style="color:white">Topic</h3></p>
                </div>

                <div class="panel-body  ">
                    <div class="col-lg-12">
                        <div class="col-sm-3">
                            Photo

                        </div>
                        <div class="col-lg-9">
                            <div class="col-lg-12">
                                <h5><a href="#">GRAILS</a> <span
                                        STYLE="color: #007efc ">Visibility(PUBLIC)</span></h5>
                            </div>

                            <div class="col-lg-12">
                                <div class="col-lg-5">
                                    <small
                                            class="text-muted">@ownerUsername</small>
                                    <div>SUBSCRIBE</div>
                                </div>

                                <div class="col-lg-5">
                                    <p style="color: red">Subscriptions</p>
                                    <p1 style="color: blue">50</p1>

                                </div>

                                <div class="col-lg-2">
                                    <p style="color: red">Post</p>
                                    <p1 style="color: blue">30</p1>
                                </div>

                            </div>

                        </div>
                    </div>

                </div>
            </div>

        </div>

        <div class="col-lg-12">
            <div class=" panel panel-default     ">
                <div class="panel-heading " style="background: grey">
                    <p>

                    <h3 style="color:white">User:topicName</h3></p>
                </div>

                <div class="panel-body  ">

                    <div class="col-lg-12">
                        <div class="col-sm-3">
                            Image of user
                        </div>

                        <div class="col-lg-9">
                            <div class="col-lg-12">
                                <h5>subscribedUser.name</h5>

                                <p class="text-muted">@subscribedUser</p>
                            </div>

                            <div class="col-lg-12">
                                <div class="col-lg-6">
                                    <p style="color: red">Subscriptions</p>
                                    <p1 style="color: blue">50</p1>
                                </div>

                                <div class="col-lg-6">
                                    <p style="color: red">Topics</p>
                                    <p1 style="color: blue">30</p1>

                                </div>

                            </div>

                        </div>
                    </div>

                    <div class="col-lg-12">
                        <hr>
                        <div class="col-sm-3">
                            Image of user
                        </div>

                        <div class="col-lg-9">
                            <div class="col-lg-12">
                                <h5>subscribedUser.name</h5>

                                <p class="text-muted">@subscribedUser</p>
                            </div>

                            <div class="col-lg-12">
                                <div class="col-lg-6">
                                    <p style="color: red">Subscriptions</p>
                                    <p1 style="color: blue">50</p1>
                                </div>

                                <div class="col-lg-6">
                                    <p style="color: red">Topics</p>
                                    <p1 style="color: blue">30</p1>

                                </div>

                            </div>

                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
    <div class="col-lg-7">
        <div class="col-lg-12">
            <div class="col-lg-12">
                <div class=" panel panel-default     ">
                    <div class="panel-heading col-lg-12" style="background: #007efc;">
                        <div class="col-lg-4">
                            <h3 style="color:white">Posts:</h3>
                        </div>

                        <div class="col-lg-8">
                            <div class="topnav pull-rigth " style="background-color: #007efc">

                                <div class="search-container">
                                    <form action="/action_page.php">
                                        <input type="text" placeholder="Search.." name="search">
                                        <button type="submit" style="background-color: #007efc;margin-right: 0px"><i
                                                class="fa fa-search"
                                                style="font-size:25px;color:white;background-color: #007efc"></i>
                                        </button>
                                    </form>
                                </div>
                            </div>
                        </div>

                    </div>

                    <div class="panel-body  ">

                        <div class="col-lg-12">
                            <div class="col-sm-3">
                                photo of resource owner
                            </div>

                            <div class="col-lg-9">
                                <div class="col-sm-12">
                                    <br>

                                    <span>resource.ownerName &nbsp;&nbsp;&nbsp;&nbsp;<small
                                            class="text-muted">resource.ownerUsername</small>

                                        <a href="#" class="pull-right">topicVO.topicName</a>
                                        <br><br>

                                        <div class="col-lg-12">
                                            <p>resourceDescription</p>
                                        </div>

                                    </span>

                                    <div>
                                        <i class="fa fa-facebook-square fa-lg" aria-hidden="true"></i>
                                        <i class="fa fa-google-plus fa-lg" aria-hidden="true"></i>
                                        <i class="fa fa-twitter-square fa-lg" aria-hidden="true"></i>
                                        <span class="pull-right" style="margin-right: 0px;color: #007efc">
                                            <g:if test="">
                                                <a href="#">View Link</a>
                                            </g:if>
                                            <g:else>
                                                <a href="#">Download</a>
                                                <a href="#">Mark as Read</a>
                                            </g:else>
                                            <a href="#">View Post</a>


                                        </span>
                                    </div>
                                </div>

                            </div>
                        </div>
                        </g:each>
                    </div>
                </div>

            </div>

        </div>
    </div>

</div>

</body>
</html>