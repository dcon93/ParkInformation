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
	
	<p>
		State:
		<c:out value="${park.state }" />
	</p>
			<p>
				Acreage:
				<c:out value="${park.acreage}" /> <c:choose> <c:when test="${convert == 'C' }"> sq km</c:when><c:otherwise>sq. mi.</c:otherwise></c:choose>
			</p>
	<p>
		Established:
		<c:out value="${park.yearFounded }" />
	</p>
	<p>
		Number of Visitors:
		<c:out value="${park.annualVisitorCount }" />
	</p>
			<p>
				Elevation: <c:out value="${park.elevationInFeet }" /> <c:choose> <c:when test="${convert == 'C' }"> m</c:when><c:otherwise>ft.</c:otherwise></c:choose>
			</p>
	<p>
		Total Miles of Trails:
		<c:out value="${park.milesOfTrail }" /> <c:choose> <c:when test="${convert == 'C' }"> km</c:when><c:otherwise>mi.</c:otherwise></c:choose>
	</p>
	<c:choose>
		<c:when test="${park.numberOfCampsites == 0 }" >
			<p>Total Number of Campsites: No Campsites Available</p>
		</c:when>
		<c:otherwise>
			<p>
				Total Number of Campsites:
				<c:out value="${park.numberOfCampsites }" />
			</p>
		</c:otherwise>
	</c:choose>
	<p>
		Total Number of Animal Species:
		<c:out value="${park.numberOfAnimalSpecies }" />
	</p>
</div>