<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style>
		table, tr, td{
			border-collapse: collapse;
			
		}
		.hi{border-top: 1px solid black;}
		</style>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
			function ajaxBtn(){
				alert()
				
			        console.log("데이터 전송");

			        fetch("/todo", {
			            method: 'post',
			            headers: {
			                'content-type': 'application/json'
			            },
			            body : JSON.stringify({
			            	"id":0, "userId":"aaa","title":"todo0","done": "false"
			            })
			        })
			    
				
				/*$.ajax({
					url: "/todo",
					method: "post",
					data:{"id":0, "userId":"aaa","title":"todo0","done": "false"},
					success: function(data){
						alert('연결성공');
						console.log(data);
						 
					},
					error: function(){
						alert("연결실패");
					}
				});// ajax
				*/
			}
			</script>
	</head>
	<body>
		<h1>index</h1>
		<a onclick = "ajaxBtn()">todo</a>	
		
		
		<table>
		<tr>
			<td>1</td>
			<td>2</td>
			<td>3</td>
		</tr>
		<tr class="hi" >
			<td class="hi">4</td>
			<td class="hi">5</td>
			<td class="hi">6</td>
		</tr>
		<tr>
			<td class="hi">7</td>
			<td>9</td>
			<td>0</td>
		</tr>
		<tr>
			<td>7</td>
			<td>9</td>
			<td>0</td>
		</tr>
		<tr>
			<td>7</td>
			<td>9</td>
			<td>0</td>
		</tr>
		
		
		</table>
		
		
		
	</body>
</html>