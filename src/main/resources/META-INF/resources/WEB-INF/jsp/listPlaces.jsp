
	<%@ include file="common/header.jspf" %>
    <%@ include file="common/navigation.jspf" %>
		<div class="container">
			<h1>List of Places</h1>
			<table class="table">
				<thead>
					<tr>
						<th>Place Code</th>
						<th>City Name</th>
						<th>Assigned FlightId</th>
						<th>Delete</th>
						<th>Used Flight</th>
                        <th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${places}" var="place">
						<tr>
							<td>${place.id}</td>
							<td>${place.username}</td>
							<td>${place.assignedFlightId}</td>
                            <td><a href="delete-place?id=${place.id}" class="btn btn-warning">Delete</a></td>
                            <td><a href="place/used-flights?placeId=${place.id}" class="btn btn-warning">Used Flights</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href="add-place" class="btn btn-success">Add Place</a>
		</div>
		<%@ include file="common/footer.jspf" %>
