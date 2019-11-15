<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:import url="/WEB-INF/jsp/common/header.jsp" />

	<c:url value="/homePage" var="homePageUrl"/>
<ul>
	<c:forEach items="${parks }" var="park"> 
	<c:url value="img/parks/${fn:toLowerCase(park.parkCode) }.jpg" var="parkImg"/>
	<c:url value="parkDetail" var="parkUrl"/>	
	
	<li class="park-box">
		<a href="${ parkUrl }/${park.parkCode}"><img class="park-list-img" src="${parkImg }"/></a>
		<a class = "park-list-name" href="${ parkUrl }/${park.parkCode}">${park.parkName } (${ park.state})</a>
		<p class="park-list-description">${park.parkDescription }</p>
	
	</li>
	</c:forEach>


</ul>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />


