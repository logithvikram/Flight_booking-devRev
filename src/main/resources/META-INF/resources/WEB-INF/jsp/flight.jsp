<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="seating" style="display: flex;padding-right: 400px;padding-top: 50px;">
<div class="container" style="width: 400px; ">

	<h1>Enter Flight Details</h1>

	<form:form method="post" modelAttribute="flight">

		<fieldset class="mb-3">
			<form:label path="model">Fligh Name </form:label>
			<form:input type="text" path="model" required="required"/>
			<form:errors path="model" cssClass="text-warning"/>
		</fieldset>

		<fieldset class="mb-3">
        			<form:label path="seatingCapacity">Seating Model</form:label>
        			<form:input type="text" path="seatingCapacity" required="required"/>
        			<form:errors path="seatingCapacity" cssClass="text-warning"/>
        </fieldset>

		<input type="submit" class="btn btn-success"/>

	</form:form>

</div>

<div class="class-details" style="border-width:3px; width: 300px; margin-left: 100px; border-style:solid; border-color:black; padding: 1em;">

	<p>
	<h2>Seating Model</h2>
	1-Economic class<br>
	2-Business class<br>
	3-Sleeper class<br>
	</p>
</div>
</div>
<%@ include file="common/footer.jspf" %>

