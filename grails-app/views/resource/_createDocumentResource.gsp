<!-- Modal -->
<div class="modal fade" id="myModal4" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Share Documents</h4>
            </div>

            <div class="modal-body">
                <g:form class="form-horizontal" controller="DocumentResource" action="save">

                    <div class="form-group">
                        <label class="control-label col-sm-2">Document:</label>

                        <div class="col-sm-10">
                            <input type="file" class="form-control" name="document">
                        </div>

                        <div class="form-group">
                            <label class="control-label col-lg-2">Description:</label>

                            <div class="col-sm-10">
                                <textarea class="form-control" rows="5"
                                          name="documentResourceDescription" placeholder="Enter Description"></textarea>
                            </div>
                        </div>

                        <div class="dropdown col-lg-12">
                            <div class="col-lg-2">
                                <label class="control-label ">Topic:</label>

                            </div>

                            <div class="col-lg-10">
                                <select class="form-control" name="topicName">
                                    %{--<g:each in="${session.user.getUserTopics()}" var="topiclist">--}%
                                        %{--<option value="${topicList}">${topicList}</option>--}%
                                    %{--</g:each>--}%
                                </select>
                            </div>

                        </div>

                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Share</button>

                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </g:form>
            </div>
        </div>

    </div>
</div>
