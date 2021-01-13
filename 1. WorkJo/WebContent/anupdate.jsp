<%@page import="dto.common.UserInfo"%>
<%@page import="dto.SessionDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>
<%-- SessionDTO user_info = (SessionDTO) session.getAttribute("userinfo");  --%>
<%-- String user_id = (String)request.getAttribute("userid"); --%>
<% session.getAttribute("userinfo"); %>
<% UserInfo user_info = (UserInfo)session.getAttribute("userinfo"); %>
<jsp:include page="/views/common/headerKKH.jsp"></jsp:include>
<script type="text/javascript">
window.onload = function() {
	writeForm.onsubmit = function() {
//  		alert("form submit")
		
		var article_title_value = document.getElementsByName("article_title")[0];
		var article_content_value = document.getElementsByName("article_content")[0];

		if( article_title_value == '' || article_title_value == null ) {
			alert("입력이 안 된 사항이 있습니다.")
			return false;
		}
		if( article_content_value == '' || article_content_value == null ) {
			alert("입력이 안 된 사항이 있습니다.")
			return false;
		}
		
	}
}
</script>

</head>
<body>
	<%
// 		String user_id = null;
// 		if (session.getAttribute("user_id") != null) {
// 			user_id = (String) session.getAttribute("user_id");
// 		}
	%>

	<div class="content-wrapper">
		<div class="row writeWrapper">
			<form class="writeF" id="writeForm" method="post" action="/anwrite" style="width: 2000px;">
				<table class="table table-striped"
					style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th colspan="2" style="background-color: #eeeeee; text-align: center;">공지사항</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="text" class="form-control"
								placeholder="글 제목" name="article_title" maxlength="50"></td>
						</tr>
						<tr>
							<td><textarea class="form-control" placeholder="글 내용"
									name="article_content" maxlength="2048" style="height: 500px;"></textarea></td>
						</tr>
 						<tr> 
 							<td><input type="password" class="form-control" name="article_pw"
 								placeholder="비밀번호" style="width: 250px;"></td> 
 						</tr> 
					</tbody>
				</table>
				<div class="writeBt">
				<input type="submit" class="btn btn-primary pull-right" value="글쓰기" >
				</div>
			</form>
		</div>
	</div>
<jsp:include page="/views/common/footerKKH.jsp"></jsp:include>