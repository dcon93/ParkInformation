<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="common/header.jsp" %>

<h2>Thank you for your survey!</h2>
<table class="topParksTable">
	
	<c:forEach items="${topParks}" var="park">
		<c:url value="parkDetail" var="parkUrl"/>
		<tr class="park-box responses"> 
			<td class="response-img-td"> 
				<c:url var="imageLink" value="/img/parks/${park.key.toLowerCase() }.jpg" />
				<a href="${ parkUrl }/${parkList[park.key].parkCode}"><img src="${imageLink }" class="congratsImage park-list-img responses-img"/></a>
			</td>
			<td class="park-list-name responses-name">
				<a href="${ parkUrl }/${parkList[park.key].parkCode}">
					<c:out value="${parkList[park.key].parkName}"/>
				</a>
			</td>
			<td class="response-number">
				Survey responses: <c:out value="${park.value }" />
			</td>
		</tr>	

	</c:forEach>
</table>

<%@include file="common/footer.jsp" %>