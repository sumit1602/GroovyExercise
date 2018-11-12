

<div class="panel-body ">
<g:uploadForm controller="user" action="updateUser" enctype="multipart/form-data">
    <div class="form-group col-lg-10">
        <label>First Name*</label>
        <input class="form-control" type="text" name="updatedFirstname" required>
    </div>

    <div class="form-group col-lg-10">
        <label>Last Name*</label>
        <input class="form-control" type="text" name="updateLastname" required>
    </div>

    <div class="form-group col-lg-10">
        <label>Username*</label>
        <input class="form-control" type="text" name="updatedUsername" required>
    </div>

    <div class="col-lg-2"></div>

    <div class="form-group col-lg-10">
        <label>Photo</label>
        <input class="form-control" type="file" name="updatedPhoto">

    </div>

    <div class="col-lg-12"></div>

    <div class="form-group col-lg-10">
        <input type="submit" class="form-control btn-primary">
    </div>

</g:uploadForm>
</div>