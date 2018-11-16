%{--<div id="myModal3" class="modal fade" role="dialog">--}%
%{--<div class="modal-dialog">--}%

%{--<div class="modal-content">--}%
%{--<div class="modal-header">--}%
%{--<button type="button" class="close" data-dismiss="modal">&times;</button>--}%
%{--<h4 class="modal-title">Share Link</h4>--}%
%{--</div>--}%

%{--<div class="modal-body">--}%
%{--<g:form class="form-horizontal" controller="linkResource" action="save">--}%
%{--<div class="form-group">--}%
%{--<label class="control-label col-sm-2">Link: </label>--}%

%{--<div class="col-lg-10">--}%
%{--<input type="text" class="form-control" name="link"--}%
%{--placeholder="Enter link">--}%
%{--</div>--}%
%{--</div>--}%
%{--<br><br>--}%

%{--<div class="form-group">--}%
%{--<label class="control-label col-sm-4">Description: </label>--}%

%{--<div class="col-lg-8">--}%
%{--<textarea class="form-control" rows="4"--}%
%{--name="linkTopicDescription" placeholder="Enter Description"></textarea>--}%
%{--</div>--}%
%{--</div>--}%

%{--<div class="dropdown col-lg-12" >--}%
%{--<div class="col-lg-2">--}%
%{--<label clcass="control-label ">Topic: </label>--}%

%{--</div>--}%
%{--<div class="col-lg-10">--}%
%{--<select class="form-control " name="topicName">--}%
%{--<g:each in="${session.user.getUserTopics()}" var="topicList">--}%
%{--<option value="${topicList}">${topicList}</option>--}%
%{--</g:each>--}%
%{--</select>--}%
%{--</div>--}%


%{--</div>--}%
%{--<br>--}%

%{--<div class="modal-footer">--}%
%{--<button type="button" class="btn btn-default" data-dismiss="modal">Share</button>--}%

%{--<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>--}%
%{--</div>--}%
%{--</g:form>--}%

%{--</div>--}%
%{--</div>--}%
%{--</div>--}%
%{--</div>--}%














<div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Link Share</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="recipient-name" class="col-form-label">Link:</label>
                        <input type="text" class="form-control" id="recipient-name">
                    </div>
                    <br><br>

                    <div class="form-group">
                        <label for="message-text" class="col-form-label">Description:</label>
                        <textarea class="form-control" id="message-text"></textarea>
                    </div>

                    <div>
                        <label for="message-text" class="col-form-label">Topic: </label>
                        <g:select name="visibility" from="${com.ttn.linksharing.enums.Visibility.values()}"/>
                    </div>
                </form>
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-primary">Share</button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
