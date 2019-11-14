<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>National Park</title>
    <%--<c:url value="/css/npgeek.css" var="cssHref" /> --%>
    <link rel="stylesheet" href="${cssHref}">
</head>

<body>
    <header>
    		<c:url value="/" var="homePageHref" />
    		<c:url value="/img/logo.png" var="logoSrc" />
        <a href="${homePageHref}">
        		<img src="${logoSrc}" alt="National Parks Geek Logo" />
        </a>
        <h1></h1>
        <%--<p>Description </p>--%>
    </header>
    <nav>
        <h2>National Parks</h2>
        <p>More about Parks!</p>
      	<c:url value="/homePage" var="homePageUrl"/> 
      	<c:url value="/survey" var="surveyUrl"/> 
      	<c:url value="/topParks" var="topParksUrl"/> 
        
        
        <ul>
            <li><a href="${homePage }">Home</a></li>
            <li><a href="${surveyUrl }">Survey</a></li>
            <li><a href="${topParksUrl }">Top Parks</a></li>
        </ul>
    </nav>
    
    
    <%--note that body and html are open tags that should be closed--%>