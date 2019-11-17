<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:import url="/WEB-INF/jsp/common/header.jsp" />

	<c:url value="/homePage" var="homePageUrl"/>
	<c:url value="/survey" var="surveyUrl"/>






<form:form action="${surveyUrl }"  method="POST" id="survey" modelAttribute="survey">
	<div class="dropdowns">
		<form:label path="parkCode">Favorite Park:</form:label>
		<form:select path="parkCode">
			<c:forEach items="${parks }" var="park">
				<form:option class="option" value="${park.parkCode }" >${park.parkName }</form:option>
			</c:forEach>
		</form:select>
		<form:errors path="parkCode" cssClass="errors"/>
	</div>
	<div>
	<form:label path="email">Email:</form:label>
	<form:input path="email" />
	<form:errors path="email" cssClass="error"/>
	</div>
	
	<div class="">

			<form:label path="state">State of Residence:</form:label>
			<form:select path="state" id="state">
		        <form:options class="option" items="${usaStates}"  />
		    </form:select>
		    <form:errors path="state" cssClass="error"/>
	</div>
	<div>
			<form:label path="activityLevel">Physical Activity Level:</form:label>
			<form:select path="activityLevel" id="activityLevel">
		        <form:option class="option" value="inactive" label="Inactive"/> 
		        <form:option class="option" value="sedentary" label="Sedentary"/> 
		        <form:option class="option" value="active" label="Active"/> 
		        <form:option class="option" value="extremely active" label ="Extremely Active"/> 
		    </form:select>

    <form:errors path="activityLevel" cssClass="error"/>
    </div>
    
    <div>
    <label for="button"></label>
	<input type="submit" id="button" class="button" />
	</div>
</form:form>

<%-- 
<form action="/confirmation" method="POST" id="survey">
	
	--%>
	<%--Favorite drop, email text, state of res drop, activity radio --%>
	<%-- 
	<label for="">Favorite</label>
	
		<input type="text" id="favorite-park" name="favorite-park"></input>
		<select name="favoritePark" form="survey">
			<c:forEach items="${parks }" var="park">
			<option value="${park.parkName}">${park.parkName }</option>
			
			</c:forEach>
		
		</select>


</form>

 --%>
<%--

<ul>
	<c:forEach items="${parks }" var="park"> 
	<c:url value="img/parks/${fn:toLowerCase(park.parkCode) }.jpg" var="parkImg"/>
	<c:url value="parkDetail" var="parkUrl"/>	
	
	<li>
		<a href="${ parkUrl }"><img src="${parkImg }"/></a>
		<a href="${ parkUrl }">${park.parkName } ${ park.state}</a>
		<p>${park.parkDescription }</p>
	
	</li>
	</c:forEach>


</ul>
 --%>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />


