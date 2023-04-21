
	<%@ include file="common/header.jspf" %>
    <%@ include file="common/navigation.jspf" %>
		<div class="container">
			<h1>List of Flights</h1>
			<table class="table">
				<thead>
					<tr>
						<th>Flight Id</th>
						<th>Model</th>
						<th>Seating Model</th>
<%--						<th>Seating class</th>--%>
						<th>Available For Booking?</th>
						<th>PlaceId</th>
                        <th>Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${flights}" var="flight">
						<tr>
							<td>${flight.id}</td>
							<td>${flight.model}</td>
<%--							<td>${flight.color}</td>--%>
							<td>${flight.seatingCapacity}</td>
							<td>${flight.availableForBooking}</td>
							<td>${flight.placeId}</td>
                            <td><a href="delete-flight?id=${flight.id}" class="btn btn-warning">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href="add-flight" class="btn btn-success">Add Flight</a>
		</div>
		<%@ include file="common/footer.jspf" %>
