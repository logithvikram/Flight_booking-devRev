<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">

	<h1>Enter Departure place Details</h1>
	<form:form method="post" modelAttribute="place">
		<fieldset class="mb-3">
			<form:label path="username">Departure Place:</form:label>
			<form:input type="text" path="username" required="required"/>
			<form:errors path="username" cssClass="text-warning"/>
		</fieldset>

		<fieldset class="mb-3">
			<form:label path="assignedFlightId">Assign FlightId:</form:label>
			<form:input type="text" path="assignedFlightId" required="required"/>
			<form:errors path="assignedFlightId" cssClass="text-warning"/>
		</fieldset>

		<input type="submit" class="btn btn-success"/>
	</form:form>

</div>

<%@ include file="common/footer.jspf" %>

