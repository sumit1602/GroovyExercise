
%{--<div id="myModal3" class="modal fade" role="dialog">--}%
    %{--<div class="modal-dialog">--}%
        %{--<div class="modal-content">--}%
            %{--<div class="modal-header">--}%
                %{--<button type="button" class="close" data-dismiss="modal">&times;</button>--}%
                %{--<h4 class="modal-title">Add Link</h4>--}%
            %{--</div>--}%

            %{--<div class="modal-body">--}%

                %{--<g:form controller="linkResource" action="save">--}%
                    %{--<div class="form-group">--}%
                        %{--<label class="control-label col-lg-2" for="link">Link*:</label>--}%

                        %{--<div class="col-lg-10">--}%
                            %{--<input type="url" class="form-control" id="link" placeholder="Enter link"--}%
                                   %{--name="link">--}%
                        %{--</div>--}%
                    %{--</div>--}%

                    %{--<div class="form-group">--}%
                        %{--<label class="control-label col-lg-2" for="description">Description*:</label>--}%

                        %{--<div class="col-lg-10">--}%
                            %{--<textarea class="form-control" rows="5" name="description" id="description"></textarea>--}%
                        %{--</div>--}%
                    %{--</div>--}%


                    %{--<div class=" form-group col-lg-12">--}%

                        %{--<select class="form-control" name="id">--}%
                            %{--<label class="control-label col-lg-2" for="topic">Topic*:</label>--}%
                            %{--<div class="col-lg-10">--}%
                            %{--<g:each in="${session.user.getUserTopics()}" var="topic">--}%
                                %{--<option value="${topic.id}">${topic}</option>--}%
                            %{--</g:each>--}%
                            %{--</div>--}%
                        %{--</select>--}%
                    %{--</div>--}%
                    %{--<br>--}%

                    %{--<div class="media-bottom">--}%
                        %{--<div class="form-group">--}%
                            %{--<div class="col-sm-4 pull-right">--}%
                                %{--<button type="submit" class="btn btn-primary">Create</button>--}%
                                %{--<button type="button" class="btn btn-default" data-dismiss="modal">Close--}%
                                %{--</button>--}%
                            %{--</div>--}%
                        %{--</div>--}%
                    %{--</div>--}%
                %{--</g:form>--}%

            %{--</div>--}%

        %{--</div>--}%
    %{--</div>--}%
%{--</div>--}%



<div id="myModal3" class="modal fade" role="dialog" >
    <div class="modal-dialog">

    <div class="modal-content col-md-12">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h4 class="modal-title">Add Link</h4>
        </div>
        <g:form controller="linkResource" action="save">
            <div class="modal-body">
                <div class="col-md-12">
                    <div class="col-sm-2">
                        <label class="control-label" for="link">Link*:</label>
                    </div>

                    <div class="col-sm-10">
                        <input type="url" class="form-control" id="link" placeholder="Enter link" name="link">
                    </div>
                </div>

                <div class="col-md-12">
                    <div class="col-sm-2">
                        <label class="control-label" for="description">Description*:</label>
                    </div>

                    <div class="col-sm-10">
                        <textarea class="form-control" name="description" id="description"
                                  placeholder="Enter description here.."></textarea>
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
