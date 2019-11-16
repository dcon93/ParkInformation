<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<%@include file="common/header.jsp"%>

<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.8.0/css/bulma.min.css">
    <script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>

<div class="tile is-ancestral">
	<div class="tile is-parent is-4">
		<div class="is-child box">
		<c:url var="imageLink"
			value="/img/parks/${park.parkCode.toLowerCase()}.jpg" />
		<img class = " image "src="${imageLink }" />
		</div>
	</div>
	<div class="is-parent tile">
	<div class="tile box is-child">
	<h2 class="title">
		<c:out value="${park.parkName}" />
	</h2>
		<p>
		<c:out value="${park.parkDescription }" />
		</p>
		<br><br>
		<p class="content">
			<em>"<c:out value="${park.inspirationalQuote }" />" <br><br>
				&emsp;&emsp;-<c:out
					value="${park.inspirationalQuoteSource }" /></em>
		</p>
	</div>
	</div>
</div>

<div>
</div>


<div class="tile is-ancestral">
<div class="tile is-parent">
<table class="table is-fullwidth tile is-child box">
	
	<tr>
		<th>Entry Fee: </th>
	<td>
	<c:choose>
		<c:when test="${park.entryFee == 0.0 }">
			Free!
		</c:when>
		<c:otherwise>
			
				$
				<c:out value="${park.entryFee }" />
			
		</c:otherwise>
	</c:choose>
	</td>
	</tr>
	<tr>
		<th>State:</th>
		<td><c:out value="${park.state }" /></td>
	</tr>
	<tr>
		<th>Acreage:</th>
		<td><c:out value="${park.acreage}" /></td>
	</tr>
	<tr>
		<th>Established:</th>
		<td><c:out value="${park.yearFounded }" /></td>
	</tr>
	<tr>
		<th>Number of Visitors:</th>
		<td><c:out value="${park.annualVisitorCount }" /></td>
	</tr>
	</table>
	</div>
	<div class="tile is-parent">
	<table class="table is-fullwidth tile box is-child">
	<tr>
		<th>Elevation:</th>
		<td><c:out value="${park.elevationInFeet }" /></td>
	</tr>
	<tr>
		<th>Climate:</th>
		<td><c:out value="${park.climate }" /></td>
	</tr>
	<tr>
		<th>Total Miles of Trails:</th>
		<td><c:out value="${park.milesOfTrail }" /></td>
	</tr>
	<tr>
	<th>Total Number of Campsites:</th>
	<td>
	<c:choose>
		<c:when test="${park.numberOfCampsites == 0 }">
			<p> No Campsites Available</p>
		</c:when>
		<c:otherwise>
			<p>
				
				<c:out value="${park.numberOfCampsites }" />
			</p>
		</c:otherwise>
	</c:choose>
	</td>
	</tr>
	<tr>
		<th>Total Number of Animal Species:</th>
		<td><c:out value="${park.numberOfAnimalSpecies }" /></td>
	</tr>
</table>
</div>
</div>



<div class="tile is-ancestral">
<%--<div class="oneDayWeatherContainer">
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
		</div> --%>


		
		<div class="fiveDayWeatherContainer tile is-parent">
			<c:forEach items="${parkWeather}" var="forecastWeather">
					<div class="individualForecasts tile is-child box">
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
						<c:if test="${forecastWeather.fiveDayForeCast ==1}">			
							<div class="content">
							<p>
								<strong><c:out value="${parkWeather[0].weatherMessage}" /></strong>
							</p>
							</div>
						</c:if>
							</div>
						</div>
					</div>
				
			</c:forEach>




			<c:url var="conversionSubmit" value="/parkDetail/${park.parkCode}" />

			<form class="is-child tile box is-2" method="post" action="${CelsiusCalculator }">
					<div class="control">
				<div class="field">
					
						<label class="radio"><input class = "radio"type="radio" name="convert" value="C">Celsius</label>
					</div>
					</div>
					<div class="control">	
					<div class="field">	
	
						 <label class="radio"><input	type="radio" name="convert" value="F"/>Fahrenheit </label>

					</div>
					</div>
			
					
					<div class="field control">
							<button	class="button is-link"type="submit">Submit</button>
				
					</div>
			</form>
					</div>

			
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


</div>
<%@include file="common/footer.jsp"%>