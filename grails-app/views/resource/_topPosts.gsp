<div class="col-md-12">
    <div class="panel panel-primary">
        <div class="panel-heading">Top post</div>



        <g:each in="${topPostList}" var="topPosts">
            <div class="panel-body" style="height: 130px; width: 100%;">
                <div class="media">
                    <div class="media-left">
                        <ls:userImage id="${topPosts.topicId}" height="100" width="100"/>
                    </div>

                    <div class="media-body">
                        <h4 class="media-heading">${topPosts.ownerFullName}
                            %{--<small>@${topPosts.ownerFirstName}</small>--}%
                        </h4>
                        <span>
                            <a href="${createLink(controller: 'topic', action: 'show', id: topPosts.topicId)}">${topPosts.topicName}</a>
                        </span>

                        <p>${topPosts.resourceDescription}</p>

                        <div>
                            <a href="#" style="  color: red; "><i class="fab fa-google-plus-g"></i></a>
                            <a href="#" style="  color: blue; "><i class="fab fa-facebook-square"></i></a>
                            <a href="#" style="  color: blue; "><i class="fab fa-twitter"></i></a>

                            <p style="text-align: right;margin-top: -20px">
                                <a href="${createLink(controller: 'resource', action: 'showPosts', id: topPosts.resourceId)}">View post</a>
                            </p>
                        </div>
                        <br/>

                    </div>

                </div>

            </div>
            <hr/>
        </g:each>

    </div>
</div>
















%{--<div class="col-sm-12">--}%
%{--<div class="panel panel-primary">--}%
%{--<div class="panel-heading">Top Posts<p>--}%

%{--<div class="dropdown" style="text-align: right;margin-top: -20px;"><button--}%
%{--class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Dropdown Example--}%
%{--<span class="caret"></span></button>--}%
%{--<ul class="dropdown-menu">--}%
%{--<li><a href="#">Public</a></li>--}%
%{--<li><a href="#">Private</a></li>--}%
%{--</ul>--}%
%{--</div>--}%
%{--</div>--}%

%{--<div class="panel-body" style="height: 150px; width: 100%;">--}%
%{--<div class="media">--}%
%{--<div class="media-left">--}%
%{--<img src="avatar.jpg" class="media-object" style="width:90px; border: 1px solid black;">--}%
%{--</div>--}%

%{--<div class="media-body">--}%
%{--<h4 class="media-heading">Sumit chaudhary</h4>--}%

%{--<p>I'm self motivating and hard-working guy,I always want to learn new things.</p>--}%

%{--<div><a href="#" style="  color: red; "><i class="fab fa-google-plus-g"></i></a>   <a href="#"--}%
%{--style="  color: blue; "><i--}%
%{--class="fab fa-facebook-square"></i></a>    <a href="#" style="  color: blue; "><i--}%
%{--class="fab fa-twitter"></i></a>--}%

%{--<p style="text-align: right;margin-top: -20px"><a>View post</a></p></div>--}%
%{--</div>--}%
%{--</div>--}%
%{--<br>--}%

%{--</div>--}%
%{--</div>--}%
%{--</div>--}%