<div class="panel panel-primarycol-lg-12" style="margin-top: 25px" >
    <div class="panel-body" style="border-style: solid; border-color: #ADFF2F; border-radius: 25px;">
        <div class="col-md-12">
            <div class="col-md-3">
                <ls:userImage id="${session.user.id}" height="110" width="110"/>
            </div>

            <div class="col-sm-9">

                <h4>${session.user.getFullName()}<br>

                    <small class="text-muted">@${session.user.getUserName()}</small>
                </h4>

                <h6 class="text-muted col-sm-6">Subscriptions
                    <p class="text-primary">50</p>
                </h6>

                <h6 class="text-muted col-sm-6">Topics
                    <p class="text-primary">30</p>
                </h6>

            </div>
        </div>

    </div>
</div>