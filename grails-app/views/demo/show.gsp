%{--<!doctype html>--}%
%{--<html>--}%
%{--<head>--}%
    %{--<meta name="layout" content="demopage"/>--}%
    %{--<title>demo layout page</title>--}%
%{--</head>--}%
%{--<body>--}%

%{--<% out << "Hello SUMIT!" %>--}%

%{--HELLO  SUMIT<br />--}%
%{--<user:isAdmin username="admin">--}%
    %{--this is admin--}%
   %{--<p> ${username}</p>--}%
%{--</user:isAdmin>--}%



%{--<user:repeat times="4"> my user name is :   </user:repeat>>--}%
%{--my user name is : ${username}--}%
%{--<g:render template="demoTemplate" model="[username: 'sumit11chaudhary']" />--}%
%{--</body>--}%
%{--</html>--}%
