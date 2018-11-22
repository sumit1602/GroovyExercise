<%@ page contentType="text/html"%>
<body>
<div>
    <h1>Hello ${userName} ,Please login using the new password</h1>
    <h3>${newPassword}</h3>
    <g:link url="${serverUrl}/login/index">Login</g:link>
</div>
</body>