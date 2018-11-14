<div class="col-lg-12 " style="margin-top: 25px">

    <div class=" panel panel-default  ">
        <div class="panel-heading " style="background:#ADFF2F">
            <p>

            <h3 style="color:white">Profile</h3></p>
        </div>

        <div class="panel-body ">
            <g:uploadForm controller="user" action="updateUser" enctype="multipart/form-data">
                <div class="form-group col-lg-10">
                    <label>First Name*</label>
                    <input class="form-control" type="text" placeholder="Enter your firstName" name="updatedFirstName" required>
                </div>

                <div class="form-group col-lg-10">
                    <label>Last Name*</label>
                    <input class="form-control" type="text" placeholder="Enter your lastName" name="updateLastName" required>
                </div>

                <div class="form-group col-lg-10">
                    <label>Username*</label>
                    <input class="form-control" type="text" placeholder="Enter your username" name="updatedUsername" required>
                </div>

                <div class="col-lg-2"></div>

                <div class="form-group col-lg-10">
                    <label>Photo</label>
                    <input class="form-control" align="right" type="file" name="updatedPhoto">
                </div>

                <div class="col-lg-12"></div>

                <div class="form-group col-lg-10">
                    <input type="submit" class="form-control btn-primary">
                </div>

            </g:uploadForm>

        </div>
    </div>
</div>