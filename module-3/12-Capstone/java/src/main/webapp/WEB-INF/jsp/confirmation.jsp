<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="common/header.jsp" %>

<p>Thank you for your survey!</p>
<table class="topParksTable">
		<tr> 
			<th>&nbsp;</th> <th>&nbsp;</th> <th>Number of responses</th>
		</tr>
	<c:forEach items="${topParks}" var="park">

		<tr> 
			<td > 
				<c:url var="/parkDetail" value="/parkDetail"/>
				<c:url var="imageLink" value="/img/parks/${park.key.toLowerCase() }.jpg" />
				<a href="${parkDetail }"><img src="${imageLink }" class="congratsImage"/></a>
			</td>
			<td>
				<c:out value="${parkList[park.key].parkName}"/>
			</td>
			<td>
				<c:out value="${park.value }" />
			</td>
		</tr>	

	</c:forEach>
</table>

<%@include file="common/footer.jsp" %>