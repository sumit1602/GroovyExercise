
<div class="panel panel-primary ">
    <div class="panel-heading">
        <h3 class="panel-title">
            Trending topics
        </h3>
    </div>
    <div class="panel-body">
        <div class="row">
            <div class="col-sm-12">
                <div class="row">
                    <div class="col-sm-3">
                        <ls:userImage id="${session.user.id}" height="110" width="110"/>
                    </div>

                    <div class="col-sm-9">
                        <a href="${createLink(controller: 'topic', action: 'show')}"
                           class="pull-left">GRAIL</a>
                        <br>

                        <div class="row">
                            <div class="col-sm-6">
                                <h6 class="text-muted">@${session.user.firstName}</h6>
                            </div>

                            <div class="col-sm-3">
                                <h6 class="text-muted pull-left">Subscriptions</h6>
                                <h6 class="text-primary">50</h6>
                            </div>

                            <div class="col-sm-3">
                                <h6 class="text-muted  pull-right">Post
                                    <br>
                                    <br>

                                    <p class="text-primary">40</p>
                                </h6>
                            </div>



                            <select class="pull-right" name="subscriptionSeriousness">
                                <option class="placeholder" selected disabled
                                        value="">SERIOUSNESS</option>
                                <option value="VERYSERIOUS">Very Serious</option>
                                <option value="SERIOUS">Serious</option>
                                <option value="CASUAL">Casual</option>
                            </select>



                            <div>
                                <select class="pull-right" name="topicVisibility">
                                    <option class="placeholder" selected disabled
                                            value="">Visibility</option>
                                    <option value="PRIVATE">Private</option>
                                    <option value="PUBLIC">Public</option>
                                </select>
                            </div>


                        </div>
                    </div>
                </div>
            </div>

        </div>

    </div>

    <div class="col-lg-12">
        <hr>
    </div>
</div>