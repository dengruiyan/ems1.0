<%@page pageEncoding="UTF-8" contentType="text/html; utf-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>emplist</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/ems/css/style.css" />

    <script type="text/javascript" src="${pageContext.request.contextPath}/ems/js/jquery-3.5.1.min.js"></script>
    <script type="text/javascript">
        /*$(function () {
            //alert("adsfasdf");

            $("#delEmp").live("click",function(){
                alert("sadfasdf111111a");
                var empId = $(this).parent().prev().prev().prev().prev().text();
                var con = confirm("是否确定删除？");
                if(con==true){
                    location.href = "${pageContext.request.contextPath}/employee/employee_deleteById?id="+empId;
                }
            })
        });*/
        function del(id) {
            if(window.confirm("请问是否确定删除？")){
                location.href = "${pageContext.request.contextPath}/employee/employee_deleteById?id="+id;
            }
        }
    </script>
</head>
<body>
<div id="wrap">
    <div id="top_content">
        <div id="header">
            <div id="rightheader">
                <p id = "p">

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
                Welcome: ${sessionScope.user.username}
            </h1>
            <table class="table">
                <tr class="table_header">
                    <td>
                        ID
                    </td>
                    <td>
                        Name
                    </td>
                    <td>
                        Salary
                    </td>
                    <td>
                        Age
                    </td>
                    <td>
                        Operation
                    </td>
                </tr>
                <c:forEach items="${requestScope.list}" var="emp">
                <tr class="row1">
                    <td>
                        ${emp.id}
                    </td>
                    <td>
                        ${emp.name}
                    </td>
                    <td>
                       ${emp.salary}
                    </td>
                    <td>
                       ${emp.age}
                    </td>
                    <td>
                        <%--<a href="javascript:void(0)" id="delEmp">delete emp</a>&nbsp;--%>
                        <a href="javascript:void(0)" onclick="del('${emp.id}')">delete emp</a>
                        <a href="${pageContext.request.contextPath}/employee/employee_selectById?id=${emp.id}">update emp</a>
                    </td>
                </tr>
                </c:forEach>
            </table>
            <p>
                <input type="button" class="button" value="Add Employee" onclick="location='${pageContext.request.contextPath}/ems/addEmp.jsp'"/>
            </p>
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
