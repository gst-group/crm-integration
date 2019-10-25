<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset==UTF-8">
	<link rel="stylesheet" type="text/css" href="<c:url value='/styles/JSONFormatter.css'/>">
	<script type="text/javascript" src="<c:url value='/scripts/common/common.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/scripts/jquery/jquery-1.8.2.min.js'/>"></script>
	<SCRIPT type="text/javascript" src="<c:url value='/scripts/jquery/jquery.json-2.2.js'/>"></SCRIPT>
	<script type="text/javascript" src="<c:url value='/scripts/JSONFormatter.js'/>"></script>
	<title>CRM</title>
</head>

<body>
	<br />
	<input type="button" id="btnClient" class="form_button"
		style="padding: 8px; font: 13.3333px Arial; margin-left: 15px; border: 1px solid; height: 33px; cursor: pointer; width: 150px; background: #269CE9; color: #FFF"
		value="获取客户列表" />
	<br />
	<input type="button" id="btnClientV1" class="form_button"
		style="padding: 8px; font: 13.3333px Arial; margin-left: 15px; border: 1px solid; height: 33px; cursor: pointer; width: 150px; background: #269CE9; color: #FFF"
		value="获取客户列表V1" />
	<div style="border: 1px solid #D8D8B2; background-color: #EEE; padding: 10px">
		<div id="output" style="display: block; word-break: break-all; word-wrap: break-word;"></div>
	</div>


	<script>
		function getContextPath() {
			return "${pageContext.request.contextPath}";
		}

		function format(json) {
			$("#output").html("");
			if (json == null || json == "") {
				json = { "msg": "没有数据" }
			}
			JSONFormatter.format(json, { 'appendTo': '#output', 'collapse': true, 'list_id': 'json' });
		}

		function getClientsHandler(result) {
			console.log(result);
			alert(JSON.stringify(result));
			var json;
			if (result.errorCode == 0) {
				json = result.departments;
			} else {
				json = result;
			}

			format(json);
		}
		var openUserId = "${openUser.openUserId}"
		var savedUserId = sessionStorage.getItem("openUserId");

		if (openUserId !== savedUserId) {
			sessionStorage.setItem("openUserId", openUserId);
		}

		$(function () {
			//获取客户列表
			$("#btnClient").click(function () {
				var url = getContextPath() + '/crm/getCustomerAccounts';
				ajaxAsyncGet(url+"?" + $.param({
					openUserId: openUserId
				}),null, getClientsHandler);
			});

			$("#btnClientV1").click(function () {
				var url = getContextPath() + '/crm/getCustomerAccountsV1';
				ajaxAsyncGet(url+"?" + $.param({
					openUserId: openUserId
				}),null, getClientsHandler);
			});
		})


	</script>
</body>

</html>