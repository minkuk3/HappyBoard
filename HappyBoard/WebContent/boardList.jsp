
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="kr.co.happy.*"%>
<%@page import="java.util.ArrayList"%>

<%
 ArrayList<BoardDTO> list = (ArrayList<BoardDTO>)request.getAttribute("date");
%>                                                                            

<% if(list.size() > 0 ){ %>
	<div class="table_box">
		<table>
			<colgroup >
				<col class="col_1">
				<col class="col_2">
				<col class="col_3">
			</colgroup>

			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>날짜</th>
				</tr>
			</thead>
	
			<tbody>		
				<%for(BoardDTO a : list) {%>
				<tr>
					<td><%= a.getSeq() %></td>
					<td><%= a.getBtitle() %></td>
					<td><%= a.getBregdate() %></td>
				</tr>
				<%} %>		
			</tbody>
		</table>
	</div>
	
	<div class="write_btn">
		<button onclick="locatoin.href='boardWrite'" type="button">글쓰기</button>
	</div>
	
<% } else { %>
	내용이 없습니다.
<% }%>

	

