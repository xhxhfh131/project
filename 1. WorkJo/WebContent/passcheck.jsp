<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 <div id="wrap">
        <form action="/" method="POST">
            <input type="hidden" name="article_pw" value="board_check_pass">
            <input type="hidden" name="num" value="">
            <label for="pass">비밀번호</label>
            <input type="pass" id="pass" name="pass">
            <br><br>
            <input type="radio" id="update" name="article_title" value="update">
            <label for="update">수정</label>
            <br>           
            <input type="radio" id="delete" name="article_content" value="delete">
            <label for="delete">삭제</label>
            <br><br>
            <input type="submit" value="확인">
            <input type="button" value="취소" onclick="window.close()">
        </form>
    </div>

</body>
</html>