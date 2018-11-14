<div class="col-lg-12">
    <div class="container-fluid">
        <div class="panel-heading">
            <h3>Change Password</h3>
        </div>

        <div class="panel-body">
            <div class="form-group">
                <label>Password*</label>
                <input class="form-control" type="text" name="newPassword" required></div>
        </div>

        <div class="form-group">
            <label>Confirm Password*</label>
            <input class="form-control" type="text" name="confirmNewPassword" required>
        </div>
    </div>
</div>

<div class="col-lg-12 " style="margin-top: 25px">

    <div class=" panel panel-default  ">
        <div class="panel-heading " style="background:#007efc">

            <p>

            <h3 style="color:white">Change Password</h3></p>
        </div>

        <div class="panel-body ">
            <g:form controller="user" action="changePassword">
                <div class="form-group col-lg-10">
                    <label>Password*</label>
                    <input class="form-control" type="text" name="updatedPassword">
                </div>

                <div class="form-group col-lg-10">
                    <label>Confirm Password*</label>
                    <input class="form-control" type="password" name="updatedConfirmPassword">
                </div>


                <div class="col-lg-2"></div>


                <div class="col-lg-12"></div>

                <div class="form-group col-lg-10">
                    <input type="submit" class="form-control btn-primary">
                </div>

            </g:form>

        </div>
    </div>
</div>
