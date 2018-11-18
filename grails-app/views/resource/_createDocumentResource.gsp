<div id="myModal4" class="modal fade" role="dialog" >
    <div class="modal-dialog">

    <div class="modal-content col-md-12">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h4 class="modal-title">Add Link</h4>
        </div>
        <g:form controller="DocumentResource" action="save">
            <div class="modal-body">
                <div class="col-md-12">
                    <div class="col-sm-2">
                        <label class="control-label" for="filepath">Document:</label>
                    </div>

                    <div class="col-sm-10">
                        <input type="file" name="filepath" id="filepath" multiple>
                    </div>
                </div>

                <div class="col-md-12">
                    <div class="col-sm-2">
                        <label class="control-label" for="description">Description*:</label>
                    </div>

                    <div class="col-sm-10">
                        <textarea class="form-control" name="description" id="description" placeholder="Enter Description"></textarea>
                    </div>
                </div>
            </div>

            <div class="col-md-12">
                <div class="col-sm-2">
                    <label class="control-label col-lg-2" for="id">Topic*:</label>
                </div>

                <div class="col-sm-10">
                    <select class="form-control" name="id" id="id">
                        <g:each in="${session.user.getUserTopics()}" var="topic">
                            <option value="${topic.id}">${topic}</option>
                        </g:each>
                    </select>
                </div>
            </div>
            <br><br><br><br><br><br><br>
            <div class="modal-footer">
                <button type="submit" class="btn btn-primary">Create</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
            </div>


        </g:form>
    </div>
</div>




%{--<!-- Modal -->--}%
%{--<div class="modal fade" id="myModal4" role="dialog">--}%
    %{--<div class="modal-dialog">--}%

        %{--<!-- Modal content-->--}%
        %{--<div class="modal-content">--}%
            %{--<div class="modal-header">--}%
                %{--<button type="button" class="close" data-dismiss="modal">&times;</button>--}%
                %{--<h4 class="modal-title">Share Documents</h4>--}%
            %{--</div>--}%

            %{--<div class="modal-body">--}%
                %{--<g:form class="form-horizontal" controller="DocumentResource" action="save">--}%
                    %{--<form>--}%
                        %{--<div class="form-group">--}%
                            %{--<label class="control-label col-sm-3">Document:</label>--}%
                            %{--<div class="col-sm-9">--}%
                                %{--<input type="file" name="filepath" id="filepath" multiple>--}%
                            %{--</div>--}%

                            %{--<div class="form-group">--}%
                                %{--<label class="control-label col-lg-3">Description:</label>--}%
                                %{--<div class="col-sm-9">--}%
                                    %{--<textarea class="form-control" rows="5" name="description" id="description" placeholder="Enter Description"></textarea>--}%
                                %{--</div>--}%
                            %{--</div>--}%

                            %{--<div class="dropdown col-lg-12">--}%
                                %{--<div class="col-lg-2">--}%
                                    %{--<label class="control-label ">Topic:</label>--}%

                                %{--</div>--}%
                                %{--<br>--}%
                                %{--<div class="col-lg-10">--}%
                                    %{--<select class="form-control" name="id">--}%
                                        %{--<g:each in="${session.user.getUserTopics()}" var="topic">--}%
                                            %{--<option value="${topic.id}">${topic}</option>--}%
                                        %{--</g:each>--}%
                                    %{--</select>--}%
                                %{--</div>--}%

                            %{--</div>--}%
                            %{--<br><br><br><br>--}%

                            %{--<div class="modal-footer">--}%
                                %{--<button type="submit" class="btn btn-primary">Share</button>--}%
                                %{--<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>--}%
                            %{--</div>--}%
                        %{--</div>--}%
                    %{--</form>--}%
                %{--</g:form>--}%
            %{--</div>--}%
        %{--</div>--}%

    %{--</div>--}%
%{--</div>--}%
