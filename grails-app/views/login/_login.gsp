<div class="col-lg-12" style="margin-top: 25px">
    <div class="panel panel-default">
        <div class="panel-heading " style="background:#007efc">
            <h3 style="color:white">Login</h3>
        </div>

        <div class="panel-body">
            <g:form controller="login" action="loginHandler" method="post">
                <div class="form-group col-lg-10">
                    <label>UserName</label>
                    <input class="form-control" type="text" name="loginusername"
                           placeholder="Enter Your Username">
                </div>

                <div class="col-lg-2"></div>

                <div class="form-group col-lg-10">
                    <label>Password</label>
                    <input class="form-control" type="password" name="loginpassword"
                           placeholder="Enter Your Password">

                </div>

                <div class="col-lg-12"></div>

                <div class="form-group col-lg-5">
                    <p><g:link action="forgetPassword">Forget Password</g:link></p>
                </div>

                <div class="form-group col-lg-10">
                    <input type="submit" class="form-control btn-primary" style="background:#007efc">
                </div>

            </g:form>

        </div>
    </div>
</div>