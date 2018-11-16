%{--<div id="myModal2" class="modal fade" role="dialog">--}%
    %{--<div class="modal-dialog">--}%

        %{--<div class="modal-content">--}%
            %{--<div class="modal-header">--}%
                %{--<button type="button" class="close" data-dismiss="modal">&times;</button>--}%
                %{--<h4 class="modal-title">Send Invitation</h4>--}%
            %{--</div>--}%

            %{--<div class="modal-body">--}%
                %{--<g:form class="form-horizontal" controller="invitation" action="index">--}%
                    %{--<div class="form-group">--}%
                        %{--<label class="control-label col-sm-2">Email:</label>--}%

                        %{--<div class="col-sm-10">--}%
                            %{--<input type="email" class="form-control" name="inviteEmail">--}%
                        %{--</div>--}%
                    %{--</div>--}%

                    %{--<br><br>--}%
                    %{--<div class="dropdown">--}%
                        %{--<label class="control-label col-sm-2">Topic:</label>--}%


                        %{--<div class="col-sm-10">--}%
                        %{--<select class="form-control  " name="topicName">--}%


                   %{----------}%

                    %{--</select>--}%
                %{--</div>--}%

                    %{--<br/><br><br>--}%

                    %{--<div class="modal-footer">--}%
                        %{--<button type="button" class="btn btn-default" data-dismiss="modal">Share</button>--}%

                        %{--<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>--}%
                    %{--</div>--}%
                %{--</g:form>--}%

            %{--</div>--}%

            %{--</div>--}%

        %{--</div>--}%
    %{--</div>--}%
%{--</div>--}%

<div id="myModal2" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Send Invitation</h4>
            </div>

            <div class="modal-body row">
                <g:form controller="invitation" action="index">
                    <div class="form-group col-lg-12">
                        <label class="control-label col-sm-2">Email:</label>
                        <div class="col-sm-10">
                            <input type="email" class="form-control" name="inviteEmail">
                        </div>
                    </div>

                    <br><br>
                    <div class="dropdown col-lg-12">
                        <div class="col-lg-2">
                            <label class="control-label ">Topic:</label>

                        </div>

                        <div class="col-lg-10">
                            <select class="form-control " name="topicVisibility">
                                <option value="">Public</option>
                                <option value="">Private</option>
                            </select>
                        </div>

                    </div>
                    <br><br>


                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary">Send</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>

                </g:form>

            </div>
        </div>

    </div>
</div>