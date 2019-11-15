<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="common/header.jsp"%>


<div class="tile is-ancestral">

	<c:url var="imageLink"
		value="/img/parks/${park.parkCode.toLowerCase()}.jpg" />
	<img class = "is-full-width"src="${imageLink }" />
	<h2>
		<c:out value="${park.parkName}" />
	</h2>

<div>
	<p>
		<em>"<c:out value="${park.inspirationalQuote }" />" -<c:out
				value="${park.inspirationalQuoteSource }" /></em>
	</p>
</div>
<div class="container is-fluid">
  <div class="notification">
    This container is <strong>centered</strong> on desktop.
  </div>
</div>
<div>
	<p>
		<c:out value="${park.parkDescription }" />
	</p>
	<c:choose>
		<c:when test="${park.entryFee == 0.0 }">
			<p>Entry Fee: Free!</p>
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
		<c:out value="${park.acreage}" />
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
		Elevation:
		<c:out value="${park.elevationInFeet }" />
	</p>
	<p>
		Climate:
		<c:out value="${park.climate }" />
	</p>
	<p>
		Total Miles of Trails:
		<c:out value="${park.milesOfTrail }" />
	</p>
	<c:choose>
		<c:when test="${park.numberOfCampsites == 0 }">
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

<div class="oneDayWeatherContainer">
			<c:forEach items="${parkWeather}" var="forecastWeather">
				<c:if test="${forecastWeather.fiveDayForeCast < 1}">
					<div class="individualForecasts">
						<div class="individualImage">
							<c:url var="weatherImage"
 								value="/img/weather/" />
 							<img src="${weatherImage}${forecastWeather.forecast}.png" /> 
						</div>
						<div class="individualWeatherInfo">
							<div>
								High:
								<c:out value="${forecastWeather.tempHigh}" />
							</div>
							<div>
								Low:
								<c:out value="${forecastWeather.tempLow}" />
							</div>
						</div>
					</div>
				</c:if>
			</c:forEach>
		</div>



		<div class="fiveDayWeatherContainer">
			<c:forEach items="${parkWeather}" var="forecastWeather">
				<c:if test="${forecastWeather.fiveDayForeCast > 0}">
					<div class="individualForecasts">
						<div class="individualImage">
							<c:url var="weatherImage"
 								value="/img/weather/" />
 							<img src="${weatherImage}${forecastWeather.forecast}.png" /> 
						</div>
						<div class="individualWeatherInfo">
							<div>
								High:
								<c:out value="${forecastWeather.tempHigh}" />
							</div>
							<div>
								Low:
								<c:out value="${forecastWeather.tempLow}" />
							</div>
						</div>
					</div>
				</c:if>
			</c:forEach>




			<c:url var="conversionSubmit" value="/parkDetail/${park.parkCode}" />
			<form method="post" action="${CelsiusCalculator }">
				<input type="radio" name="convert" value="C">Celcius <input
					type="radio" name="convert" value="F">Fahrenheit <input
					type="submit">
			</form>
			
<%-- 							<c:if test="${F == false}"> --%>
<%-- 								<fmt:formatNumber var="formattedCHigh" maxFractionDigits="0" value="${((forecast.highTemp - 32) * (.5556)) }" /> --%>
<%-- 								High <c:out value="${formattedCHigh}" />  --%>
<%-- 								<fmt:formatNumber var="formattedCLow" maxFractionDigits="0" value="${((forecast.highTemp - 32) * (.5556)) }" /> --%>
<%-- 								Low <c:out value="${formattedCLow}" />  --%>
<%-- 							</c:if> --%>
<%-- 							<c:if test="${F == true || F == null}"> --%>
<%-- 								High <c:out value="${forecast.highTemp}" />  --%>
<%-- 								Low <c:out value="${forecast.lowTemp}" />  --%>
<%-- 							</c:if>							 --%>
			<p>
				<strong><c:out value="${parkWeather[0].weatherMessage}" /></strong>
			</p>
</div>
</div>
<%@include file="common/footer.jsp"%>