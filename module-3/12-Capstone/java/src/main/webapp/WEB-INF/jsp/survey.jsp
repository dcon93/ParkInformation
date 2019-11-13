<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:import url="/WEB-INF/jsp/common/header.jsp" />

	<c:url value="/homePage" var="homePageUrl"/>



<form action="/confirmation" method="POST" id="survey">
	
	
	<%--Favorite drop, email text, state of res drop, activity radio --%>
	
	<label for="">Favorite</label>
	
		<input type="text" id="favorite-park" name="favorite-park"></input>
		<select name="favoritePark" form="survey">
			<c:forEach items="${parks }" var="park">
			<option value="${park.parkName}">${park.parkName }</option>
			
			</c:forEach>
		
		</select>


</form>




<ul>
	<c:forEach items="${parks }" var="park"> 
	<c:url value="img/parks/${fn:toLowerCase(park.parkCode) }.jpg" var="parkImg"/>
	<c:url value="parkDetail" var="parkUrl"/>	
	
	<li>
		<a href="${ parkUrl }"><img src="${parkImg }"/></a>
		<a href="${ parkUrl }">${park.parkName } ($park.state)</a>
		<p>${park.parkDescription }</p>
	
	</li>
	</c:forEach>


</ul>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />


