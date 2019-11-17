<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="common/header.jsp" %>

<h2>Thank you for your survey!</h2>
<table class="topParksTable">
	
	<c:forEach items="${topParks}" var="park">

		<tr class="park-box responses"> 
			<td class="response-img-td"> 
				<c:url var="imageLink" value="/img/parks/${park.key.toLowerCase() }.jpg" />
				<img src="${imageLink }" class="congratsImage park-list-img responses-img"/>
			</td>
			<td class="park-list-name responses-name">
				<c:out value="${parkList[park.key].parkName}"/>
			</td>
			<td class="response-number">
				Survey responses: <c:out value="${park.value }" />
			</td>
		</tr>	

	</c:forEach>
</table>

<%@include file="common/footer.jsp" %>