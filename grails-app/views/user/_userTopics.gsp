<div class="panel panel-primary ">
    <div class="panel-heading" style="background: #ADFF2F">
        <h4>Topics</h4>
        <g:form class="form-inline" controller="search" action="index">
            <div class="input-group" class="col align-self-end" style="margin-top: -35px; border-radius: 20px;">
                %{--<input type="text" class="form-control " placeholder="Search" name="search">--}%
                <div class="input-group-btn">
                    %{--<button class="btn btn-default " type="submit">--}%
                    %{--<i class="glyphicon glyphicon-search" class="col align-self-left"></i>--}%
                    %{--</button>--}%
                    %{--<button class="btn btn-default" type="submit">--}%
                    %{--<i class="glyphicon glyphicon-remove-circle"></i>--}%
                    %{--</button>--}%
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
    <g:each in="${userTopics}" var="topics">
        <div class="panel-body">
            <g:form controller="topic" action="changeName" class="form-inline">
                <div class="col-md-12">
                    <div class="col-md-3">
                        <ls:userImage id="${session.user.id}" height="110" width="110"/>
                    </div>


                    <div class="col-lg-9">
                        <div class="col-lg-12">

                            <div class="form-group">
                                <input type="text" class="form-control" name="newTopicName"
                                       placeholder="${topics.name}">
                                <g:hiddenField name="id" value="${topics.id}"/>
                                <button class="btn btn-default" type="submit">Save</button>
                            </div>
                        </div>


                        <div class="col-lg-12">
                            <div class="col-sm-6">
                                <h3 class="text-muted">@${topics.createdBy}</h3>
                            </div>

                            <div class="col-sm-3">
                                <h4 class="text-muted pull-left">Subscriptions
                                    <p class="text-primary">${topics.subscriptionCount}</p>
                                </h4>
                            </div>

                            <div class="col-sm-3">
                                <h4 class="text-muted  pull-right">Post
                                    <p class="text-primary">${topics.postCount}</p>
                                </h4>
                            </div>

                        </div>
                    </div>

                </div>

                <div class="col-lg-12">

                </div>

                <div class="col-lg-12">
                    %{--<select class="col-lg-4" name="subscriptionSeriousness">--}%
                    %{--<option class="placeholder" select disabled value="">SERIOUSNESS</option>--}%
                    %{--<option value="VERYSERIOUS">Very Serious</option>--}%
                    %{--<option value="SERIOUS">Serious</option>--}%
                    %{--<option value="CASUAL">Casual</option>--}%
                    %{--</select>--}%
                    <div class="col-lg-1">
                    </div>

                    <div class="col-lg-4">
                        <select class="form-control " name="topicSeriousness">
                            <span class="caret"></span>
                            <option value="VERYSERIOUS">Very Serious</option>
                            <option value="SERIOUS">Serious</option>
                            <option value="CASUAL">Casual</option>
                        </select>

                        %{--<g:select name="visibility" id="topicsSeriousness" value="${topics.seriousness}"--}%
                                  %{--from="${com.ttn.linksharing.enums.Seriousness.values()}"/>--}%
                    </div>

                    <div class="col-lg-4">
                        %{--<select class="form-control " name="topicVisibility"  onchange="changeVisibility(${topics.id}, this.value)">--}%
                        %{--<span class="caret"></span>--}%
                        %{--<option value="placeholder" selected disabled value="">${topics.visibility}</option>--}%
                        %{--<option value="${enums.Visibility.PRIVATE}">PRIVATE</option>--}%
                        %{--<option value="${enums.Visibility.PUBLIC}">PUBLIC</option>--}%
                        %{----}%
                        %{--</select>--}%

                        <g:select name="visibility" id="topicsVisibility" value="${topics.visibility}"
                                  from="${com.ttn.linksharing.enums.Visibility.values()}"/>
                    </div>
                    %{--<div>--}%

                    %{--<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown" style="display: block">Seriousness--}%
                    %{--<span class="caret"></span></button>--}%
                    %{--<ul class="dropdown-menu">--}%
                    %{--<li><a href="#">Very Serious</a></li>--}%
                    %{--<li><a href="#">Serious</a></li>--}%
                    %{--<li><a href="#">Casual</a></li>--}%
                    %{--</ul>--}%
                    %{--</div>--}%

                    <div class="col-lg-1" style="padding: 0px">
                        <a href="#myModal2" data-toggle="modal" data-target="#myModal2">
                            <i class="fa fa-envelope" style="font-size:30px;color:yellow"></i>
                        </a>
                    </div>

                    <div class="col-lg-1" style="padding: 0px">
                        <a href="#myModal4" data-toggle="modal" data-target="#myModal4">
                            <i class="fa fa-file" style="font-size:30px;color:black"></i>
                        </a>
                    </div>

                    <a class="col-lg-1" style="padding: 0px">
                        %{--<g:form controller="topic" action="delete" >--}%
                        %{--<input type="hidden"  type="button" name="id" value="${topics.id}"/>--}%
                        %{--<button type="submit" class="btn"><i class="glyphicon glyphicon-trash" style="font-size:25px;color:black"></i>--}%
                        %{--</button>--}%

                        %{--</g:form>--}%
                        <a href="" onclick="topicDelete(${topics.id})">
                            <span type="img" class="glyphicon glyphicon-trash"
                                  style="font-size:25px;color:black"></span>
                        </a>
                </div>
            </g:form>
        </div>

    %{--  <g:form href="${createLink(controller: 'topic', action: 'delete')}">

          <div class="col-lg-1" style="padding: 0px">
              <input type="button" name="id" value="${topics.id}">
              <i class="glyphicon glyphicon-trash" style="font-size:30px;color:green"></i>
          </div>
      </g:form>--}%


    %{--</div>--}%
        <hr/>
    </g:each>

    <script>
        function topicDelete(id) {
            var info = confirm("Are you Sure.....!!! think again ?");
            if (info) {
                $.ajax({
                    url: "http://localhost:8080/Linksharing/topic/delete",
                    type: "POST",
                    contentType: "application/json; charset=utf-8",
                    data: {id: id},
                    success: function (data) {
                        console.log(data)
                        alert(data)
                    },
                    error: function (data) {
                        alert(data)
                    }

                });
            }
        }
    </script>
    %{--<script>--}%
    %{--function changeTopicVisibility(id, value) {--}%
    %{--console.log("id is ===", id)--}%
    %{--console.log(" value is  ===", value)--}%
    %{--var info= confirm("DO YOU REALLY WANT TO CHANGE VISIBILITY.!!! think again ?")--}%
    %{--if(info ==  true){--}%
    %{--$.ajax({--}%
    %{--url: "http://localhost:8080/Linksharing/topic/changeVisibility",--}%
    %{--type: "POST",--}%
    %{--data: {id: id, value: value},--}%
    %{--success: function (data) {--}%
    %{--alert(data)--}%
    %{--},--}%
    %{--error: function (data) {--}%
    %{--alert(data)--}%
    %{--}--}%
    %{--})--}%
    %{--}--}%
    %{--}--}%
    %{--</script>--}%
</div>

