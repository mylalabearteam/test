<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		
	</head>
	<body>
		<a href="/admin/index">admin</a>
		
		
		<script type="text/javascript">
		$(function(){
			$("#btn").click(function(){
				$.ajax({
					url: "https://apis.data.go.kr/B551011/PhotoGalleryService1/galleryList1?serviceKey=5yOr8%2FoR%2FU6nAz5ysFlKnUQ4wayzOogsGSLvrEmu3HET2C43zlryMCB0eAutsCw9wa0xeGjc6BAdQC1YO3LT1A%3D%3D&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest&arrange=A&_type=json",
					type: "get",
					dataType:"json",
					success: function(data){
						alert("성공");
						console.log(data);
					},
					error: function(){
						alert("실패");
					}
				});// ajax
			});// btn
		});// jquery
		</script>

<button type="button" id="btn">button</button>

	
	
	
	</body>
</html>