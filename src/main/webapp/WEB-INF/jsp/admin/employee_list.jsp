<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ page import="com.hr.util.MTimeUtil"%>


<%@ page import="com.hr.vo.EmpDeptPosVO" %>
<%@ page import="java.util.List" %>
<% String path = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>HR医院 - 在职员工列表</title>
	<meta name="keywords" content="">
	<meta name="description" content="">

	<link rel="shortcut icon" href="favicon.ico">
	<link href="<%=path %>/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
	<link href="<%=path %>/css/font-awesome.css?v=4.4.0" rel="stylesheet">

	<!-- Data Tables -->
	<link href="<%=path %>/css/plugins/dataTables/dataTables.bootstrap.css"
		  rel="stylesheet">
	<link href="<%=path %>/css/animate.css" rel="stylesheet">
	<link href="<%=path %>/css/style.css?v=4.1.0" rel="stylesheet">

	<link rel="stylesheet" type="text/css" href="<%=path %>/dist/sweetalert.css">
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
	<div class="row">
		<div class="col-sm-12">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
					<h5>在职员工列表</h5>
				</div>
				<div class="ibox-content">
					<div style="margin-bottom: 8px">
						<a href="<%=path %>/employee/toAdd" class="btn btn-success">添加员工</a>
					</div>
					<table class="table table-striped table-bordered table-hover dataTables-example">
						<thead>
						<tr>
							<th>序号</th>
							<th>工号</th>
							<th>姓名</th>
							<th>性别</th>
							<th>电话</th>
							<th>部门名称</th>
							<th>职称</th>
							<th>入职时间</th>
							<th>管理</th>
						</tr>
						</thead>
						<tbody>
						<%
							List<EmpDeptPosVO> list= (List<EmpDeptPosVO>) request.getAttribute("list");
							int index = 0;
							for(EmpDeptPosVO edp : list){
						%>
						<tr class="gradeA">
							<td><%=index++ %></td>
							<td><%=edp.getEmployeeNumber() %></td>
							<td><%=edp.getEmpName() %></td>
							<td><%=edp.getGender() %></td>
							<td><%=edp.getTelephone() %></td>
							<td><%=edp.getDeptName() %></td>
							<td><%=edp.getPositionName() %></td>
							<%
								String intime = MTimeUtil.dateFormat(edp.getInTime());
							%>
							<td><%=intime %></td>
							<td><a href="<%=path %>/employee/<%=edp.getEmpId() %>/detial.do" class="btn btn-info">查看</a>&nbsp;&nbsp;
								<a href="<%=path %>/employee/<%=edp.getEmpId()  %>/toUpdate.do" class="btn btn-primary">修改</a>&nbsp;&nbsp;
								<a onclick="del(<%=edp.getEmpId()  %>)" class="btn btn-danger delete">删除</a></td>
						</tr>
						<%
							}
						%>
						</tbody>
					</table>
					<!--分页div删除-->
				</div>
			</div>
		</div>
	</div>
</div>

<!-- 全局js -->
<script src="<%=path %>/js/jquery.min.js?v=2.1.4"></script>
<script src="<%=path %>/js/bootstrap.min.js?v=3.3.6"></script>
<script src="<%=path %>/js/plugins/jeditable/jquery.jeditable.js"></script>

<!-- Data Tables -->
<script src="<%=path %>/js/plugins/dataTables/jquery.dataTables.js"></script>
<script src="<%=path %>/js/plugins/dataTables/dataTables.bootstrap.js"></script>

<!-- 自定义js -->
<script src="<%=path %>/js/content.js?v=1.0.0"></script>

<!-- layer javascript -->
<script src="js/plugins/layer/layer.min.js"></script>

<script type="text/javascript">

    function del(id){
        parent.layer.confirm('确认删除？', {
            btn: ['确认','取消'], //按钮
            shade: false //不显示遮罩
        }, function(){
            parent.layer.msg('删除成功！', {icon: 1});
            location.href="./"+ id +"/delete.do";
        });
    }
</script>
</body>
</html>
