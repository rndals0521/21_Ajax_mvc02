<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	div{text-align: center;}
	table{width: 600px; margin: auto;}
	table, th, td {
		border: 1px solid darkgray;
		text-align: center;
		border-collapse: collapse;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
   $(function() {
	 	$("#btn1").click(function() {
			$("#table").empty();
			$.ajax({
				url : "/MyController01",
				methode : "post",
				dataType : "text",
				success : function(data) {
					var table = "<thead>";
					table += "<tr><th>id</th><th>name</th><th>subject</th><th>content</th><th>email</th><th>pwd</th><th>regdate</th><tr>";
					table += "</thead><tbody>";
					var people = data.split("/");
					for(var k in people){
						table +="<tr>";
						var people_info = people[k].split(",");
						for ( var y in people_info) {
								table +="<td>"+people_info[y]+"</td>";
						}
						table +="</tr>";
					}
					table +="</tbody>";
					$("#table").append(table);
					
				},
				error : function() {
					alert("읽기실패");
				}
			});
		});
	 	
	 	$("#btn2").click(function() {
			$("#table").empty();
			$.ajax({
				url : "/MyController02",
				methode : "post",
				dataType : "xml",
				success : function(data) {
					var table = "<thead>";
					table += "<tr><th>id</th><th>name</th><th>subject</th><th>content</th><th>email</th><th>pwd</th><th>regdate</th><tr>";
					table += "</thead><tbody>";
					$(data).find("product").each(function(){
						table +="<tr>";
						table +="<td>" + $(this).attr("id")+"</td>";
						table +="<td>" + $(this).text()+"</td>";
						table +="<td>" + $(this).attr("subject")+"</td>";
						table +="<td>" + $(this).attr("content")+"</td>";
						table +="<td>" + $(this).attr("email")+"</td>";
						table +="<td>" + $(this).attr("pwd")+"</td>";
						table +="<td>" + $(this).attr("regdate")+"</td>";
						table +="</tr>";
					});
					
					table +="</tbody>";
					$("#table").append(table);
					
				},
				error : function() {
					alert("읽기실패");
				}
			});
		});
	 	$("#btn3").click(function() {
			$("#table").empty();
			$.ajax({
				url : "/MyController03",
				methode : "post",
				dataType : "json",
				success : function(data) {
					var table = "<thead>";
					table += "<tr><th>id</th><th>name</th><th>subject</th><th>content</th><th>email</th><th>pwd</th><th>regdate</th><tr>";
					table += "</thead><tbody>";
					$.each(data, function(k,v) {
						table += "<tr><td>"+ v["id"]+"</td><td>"+v["name"]+"</td><td>"+ v["subject"]+"</td><td>"+ v["content"]+"</td><td>"+ v["email"]+"</td><td>"+ v["pwd"]+"</td><td>"+ v["regdate"]+"</td></tr>";
					});
					
					table +="</tbody>";
					$("#table").append(table);
					
				},
				error : function() {
					alert("읽기실패");
				}
			});
		});
   });
</script>
<script type="text/javascript"></script>
</head>
<body>
	<div>
		<button id="btn1">Text 정보가져오기</button>
		<button id="btn2">XML 태그/속성 정보가져오기</button>
		<button id="btn3">JSON 정보가져오기</button>
	</div>
	<hr>
	<div>
		<table id="table"></table>
	</div>
</body>
</html>