<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title> JARDIN SHOP </title>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="description" content="JARDIN" />
<meta name="keywords" content="JARDIN" />
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scaleable=no" />
<link rel="stylesheet" type="text/css" href="../css/reset.css" />
<link rel="stylesheet" type="text/css" href="../css/content.css" />
<script type="text/javascript" src="../js/jquery.min.js"></script>
</head>
<body>
<div id="layerWrap">
<script type="text/javascript">
function submitBtn(){
	alert($("#cpw").val())
	$("#user_pw").val($("#cpw").val()); 
	cgpw.submit();
	//parent.$.fancybox.close();	
	//parent.$.fancybox.submit();
}
</script>
<div class="inputWrap">
<form action="modimem" method="get" name="cgpw">
		
	<div class="inputBody">
		<div class="title">비밀번호 변경</div>
		<p class="close"><a onclick="parent.$.fancybox.close();" href="javascript:;"><img src="../images/btn/btn_input_close.gif" alt="닫기" /></a></p>


		<div class="checkDiv">
			
			
			<table summary="새로운 비밀번호로 변경 하실수 있습니다." class="checkTable" border="1" cellspacing="0">
				<caption>비밀번호 변경</caption>
				<colgroup>
				<col width="48%" />
				<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th scope="row"><span>현재 비밀번호</span></th>
						<td><input type="password" class="w215" value="${oldpw }" /></td>
					</tr>
					<tr>
						<th scope="row"><span>새로운 비밀번호</span></th>
						<td><input type="password" id="cpw" name="cpw" class="w215" /></td>
					</tr>
					<tr>
						<th scope="row"><span>새로운 비밀번호 <u>재입력</u></span></th>
						<td><input type="password" class="w215" /></td>
					</tr>
				</tbody>
			</table>
			
			
		</div>


		<div class="centerbrn pd10">
			<a onclick="submitBtn()">확인</a>
		</div>

	</div>
</form>
</div>


</div>
</body>
</html>