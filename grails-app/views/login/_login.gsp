

%{--<div class="col-lg-12" style="margin-top: 20px">--}%
    %{--<div class="panel panel-default">--}%
        %{--<div class="panel-heading " style="background:#007efc">--}%
            %{--<h3 style="color:white">Login</h3>--}%
        %{--</div>--}%

        %{--<div class="panel-body">--}%
            %{--<g:form controller="login" action="loginHandler" method="post">--}%
                %{--<div class="form-group col-lg-10">--}%
                    %{--<label>Email/UserName*</label>--}%
                    %{--<input class="form-control" type="text" name="loginusername"--}%
                           %{--placeholder="Enter Your Email/Username">--}%
                %{--</div>--}%

                %{--<div class="col-lg-2"></div>--}%

                %{--<div class="form-group col-lg-10">--}%
                    %{--<label>Password*</label>--}%
                    %{--<input class="form-control" type="password" name="loginpassword"--}%
                           %{--placeholder="Enter Your Password">--}%

                %{--</div>--}%

                %{--<div class="col-lg-12"></div>--}%

                %{--<div class="form-group col-lg-5">--}%
                    %{--<p><g:link action="forgetPassword">Forget Password</g:link></p>--}%
                %{--</div>--}%

                %{--<div class="form-group col-lg-10">--}%
                    %{--<input type="submit" class="form-control btn-primary" style="background:#007efc">--}%
                %{--</div>--}%

            %{--</g:form>--}%

        %{--</div>--}%
    %{--</div>--}%
%{--</div>--}%











%{-------------------------------}%

<!doctype html>
<html>
<head>
    <meta name="layout" content="main">
    <g:form class="LinkSharing" url="controller:'login',action:'loginHandler';">
    </g:form>
</head>
<body>
<div class="col-sm-12"><div class="panel panel-primary">
    <div class="panel-heading">Email</div>

    <div class="panel-body" style="height: 210px; width: auto;">
        <g:form controller="login" action="loginHandler">
            <div class="form-group">
                <label for="username">Email address*</label>
                <input type="text" name="username" class="form-control" id="username" value="${username}"
                       placeholder="Enter email">
            </div>

            <div class="form-group">
                <label for="password">Password*</label>
                <input type="password" name="password" class="form-control" id="password" value="${password}"
                       placeholder="Password">
            </div>

            <div><a href=${createLink(controller: 'login',action: 'forgotPassword')}>Forgot Password</a>
                <button type="submit" class="btn btn-primary" style="float: right; margin-top: 0px;">Submit</button>
            </div>
        </g:form>
    </div>
</div>
</div>
</body>
</html>