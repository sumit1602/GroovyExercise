<div class="col-md-12">
    <div class="panel panel-primary">
        <div class="panel-heading">Recent Shares</div>
        <g:each in="${recentShareList}" var="recentShare">

            <div class="panel-body" style="height: 130px; width: 100%;">
                    <div class="col-lg-2">
                        <ls:userImage id="${recentShare.resourceId}" height="100" width="100"/>
                    </div>

                    <div class="col-md-10">
                        <h4 class="col-lg-8" style="text-align: left">${recentShare.ownerFullName}<small>@${recentShare.ownerFirstName}</small></h4>
                        <h4 class="col-lg-4" style="text-align: right" p\>
                            <a href="${createLink(controller: 'topic', action: 'show', id: recentShare.topicId)}">${recentShare.topicName}</a>
                        </h4>
                        <div class="col-lg-12">
                            <p>${recentShare.resourceDescription}</p>
                        </div>

                        <div class="col-lg-12">
                            <a href="https://mail.google.com/mail/u/0/#inbox" style="  color: red; "><i class="fab fa-google-plus-g"></i></a>
                            <a href="https://newers.facebook.com/" style="  color: blue; "><i class="fab fa-facebook-square"></i></a>
                            <a href="https://twitter.com/login" style="  color: blue; "><i class="fab fa-twitter"></i></a>

                            <p style="text-align: right;margin-top: -20px">
                                %{--<a href="${createLink(controller: 'resource', action: 'showPosts', id: recentShare.resourceId)}">View post</a>--}%
                                <a href="${createLink(controller: 'topic', action: 'show', id: "${recentShare.topicId}")}">View post</a>
                            </p>
                        </div>
                    </div>


                <br>
            </div>
            <hr/>
        </g:each>

    </div>
</div>
