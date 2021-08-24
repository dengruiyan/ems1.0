<%@page pageEncoding="UTF-8" contentType="text/html; utf-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>regist</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/ems/css/style.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/ems/js/jquery-3.5.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#fm").submit(function () {
                //alert("fasdfasd");
                /*var username = $("#username").val();
                var password = $("#password").val();
                var name = $("#name").val();
                var sex = $("#input[type=radio]:checked").val();
                var code = $("#code").val();*/
                /*var user={
                    username:username,
                    password:password,
                    name:name,
                    sex:sex
                };*/
                //alert(user);
                //发送ajax请求
                $.ajax({
                    type:"POST",
                    url:"${pageContext.request.contextPath}/user/user_regist",
                    //data:"user.username="+username+"user.password="+password+"user.realName="+name+"user.sex="+sex,code:code,
                    data:$("#fm").serialize(),
                    dataType:"JSON",
                    success:function (result) {
                        if(result.success){
                            //alert("11111");
                            location.href="${pageContext.request.contextPath}/ems/login.jsp";
                        }else{
                            if(result.backResult == "用户名已存在") {
                                $("#sp1").html("<font color='red'>" + result.backResult + "</font>");
                            }else{
                                $("#sp2").html("<font color='red'>" + result.backResult + "</font>");
                            }
                        }
                    }
                });
                return false;
            });
        });
    </script>
</head>
<body>
<div id="wrap">
    <div id="top_content">
        <div id="header">
            <div id="rightheader">
                <p>
                    2009/11/20
                    <br />
                </p>
            </div>
            <div id="topheader">
                <h1 id="title">
                    <a href="#">main</a>
                </h1>
            </div>
            <div id="navigation">
            </div>
        </div>
        <div id="content">
            <p id="whereami">
            </p>
            <h1>
                注册
            </h1>
            <form action="" method="post" id="fm">
                <table cellpadding="0" cellspacing="0" border="0"
                       class="form_table">

                    <tr>
                        <td valign="middle" align="right">
                            用户名:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="user.username" id="username" /><span id="sp1"></span>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            真实姓名:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="user.realName" id="name"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            密码:
                        </td>
                        <td valign="middle" align="left">
                            <input type="password" class="inputgri" name="user.password" id="password"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            性别:
                        </td>
                        <td valign="middle" align="left">
                            男
                            <input type="radio" class="inputgri" name="user.sex" value="m" checked="checked" />
                            女
                            <input type="radio" class="inputgri" name="user.sex" value="f" />
                        </td>
                    </tr>

                    <tr>
                        <td valign="middle" align="right">
                            验证码:
                            <img src="${pageContext.request.contextPath}/validationCodeServlet.png" style="float: right;height: 40px;" id="img" />
                            <a href="javascript:;" onclick="document.getElementById('img').src = '${pageContext.request.contextPath}/validationCodeServlet.png?validateCode='+(new Date()).getTime()">换一张</a>
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="code" id="code" /><span id="sp2"></span>

                        </td>
                    </tr>
                </table>
                <p>
                    <input type="submit" class="button" value="Submit &raquo;" />
                </p>
            </form>
        </div>
    </div>
    <div id="footer">
        <div id="footer_bg">
            ABC@126.com
        </div>
    </div>
</div>
</body>
</html>
