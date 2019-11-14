<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="common/header.jsp" %>


<h2><c:out value="${park.parkName}"/></h2>

<div>
	<c:url var="imageLink" value="/img/parks/${park.parkCode.toLowerCase() }.jpg" />
	<img src="${imageLink }" />
</div>

<div>
	<p>
		<em>"<c:out value="${park.inspirationalQuote }" />" -<c:out
				value="${park.inspirationalQuoteSource }" /></em>
	</p>
</div>

<div>
	<p>
		<c:out value="${park.parkDescription }" />
	</p>
	<c:choose>
		<c:when test="${park.entryFee == '0.00' }" >	
			<p> Entry Fee: Free! </p>
		</c:when>
		<c:otherwise>	
			<p>
				Entry Fee: $
				<c:out value="${park.entryFee }" />
			</p>
		</c:otherwise>
	</c:choose>