
<div class="col-lg-6">
    <div class="panel panel-primary ">
        <div class="panel-heading">Inbox</div>
        %{--<g:each in="" var="unReadResources">--}%
            <div class="panel-body">
                <div class="col-lg-12">
                    <div class="col-sm-3">
                        %{--<ls:userImage username="${unReadResources.fullName}" height="100" width="100"/>--}%
                    </div>

                    <div class="col-lg-9">
                        <p>SUMIT <span
                                style="color: darkgray">@SUMIT</span>
                            <span class="pull-right"
                                  style="margin-right: 0px;color: #007efc;font-size: small"><a href="${createLink(controller: 'topic', action: 'show')}">GRAILS</a></span>
                        </p>

                        <p>$description is here </p>

                        <i class="fa fa-facebook-official fa-lg" aria-hidden="true"></i>
                        <i class="fa fa-google fa-lg" aria-hidden="true"></i>
                        <i class="fa fa-twitter fa-lg" aria-hidden="true"></i>
                        <span class="pull-right" style="margin-right: 0px;color: #007efc">
                            <g:link controller="download" action="index"
                                    style="color: #007efc;font-size: small">Download</g:link>

                            <g:link controller="readingItem" action="changeisRead" params="">Mark Read</g:link>
                            <a href="${createLink(controller:'resource',action:'showPost')}">View Post</a>
                        </span>

                    </div>
                </div>
            </div>
        %{--</g:each>--}%
    </div>

</div>