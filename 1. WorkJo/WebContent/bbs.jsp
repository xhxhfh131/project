<%@page import="dto.common.UserInfo"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bbs.BbsDAO"%>
<%@page import="dto.Bbs"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>
<%-- SessionDTO user_info = (SessionDTO) session.getAttribute("userinfo");  --%>
<%-- String user_id = (String)request.getAttribute("userid"); --%>
<%   List<Bbs> list = (List<Bbs>) request.getAttribute("list"); %>
<% session.getAttribute("userinfo"); %>
<% UserInfo user_info = (UserInfo)session.getAttribute("userinfo"); %>

<%  // 인증된 세션이 없는경우, 해당페이지를 볼 수 없게 함.
//     if (session.getAttribute("user_no") == null) {
//         response.sendRedirect("/main");
//     }
%>

<jsp:include page="/views/common/headerKKH.jsp"></jsp:include>

   <div class="content-wrapper">
      <div class="row writeWrapper">
         <table class="table table-striped writeF"
            style="text-align: center; border: 1px solid #dddddd" >
            <thead>
               <tr>
                  <th style="background-color: #eeeeee; text-align: center;">번호</th>
                  <th style="background-color: #eeeeee; text-align: center;">제목</th>
                  <th style="background-color: #eeeeee; text-align: center;">작성자</th>
                  <th style="background-color: #eeeeee; text-align: center;">작성일</th>
               </tr>
            </thead>
            <tbody>
               <%   for(int i=0; i<list.size(); i++) { %>
               <tr>
                  <td><%=list.get(i).getArticle_no()%></td>
                  <td><a href="/board?ano=<%=list.get(i).getArticle_no()%>">
                  <%=list.get(i).getArticle_title()%></a></td>
                  <td><%=list.get(i).getUser_name()%></td>
                  <td><%=list.get(i).getRevision_date() %></td>
               </tr>
                  
               <% } %>
            </tbody>
         </table>

         <!-- 회원만 넘어가게 -->      
         <%-- 
             if(user_info.getGrade_no() == 10){ 
         --%>
            
         <%--
            } else {
         --%>
<!--          <button class="btn btn-primary pull-right" -->
<!--             onclick="if(confirm('로그인 하세요'))location.href='/login';" -->
<!--             type="button">글쓰기</button> -->
         <%--
            }
         --%>
      </div>
      <!-- 페이지 넘기기 -->
      <jsp:include page="paging.jsp" />
      <% if(user_info.getUser_grade() == 2 ){ %>
         <div class="writeBt"><a href="write.jsp" class="btn btn-primary pull-right " >글쓰기</a> </div>
      <% } else { 
         System.out.println("뻒....");
       } %>
      </div>
<jsp:include page="/views/common/footerKKH.jsp"></jsp:include>