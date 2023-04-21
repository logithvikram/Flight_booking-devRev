
	<%@ include file="common/header.jspf" %>
    <%@ include file="common/navigation.jspf" %>
		<div class="container">
			<h1>List of All flights</h1>
			<table class="table">
				<thead>
					<tr>
						<th>FlightId</th>
						<th>Departure place</th>
						<th>Request Status</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${flight_requests}" var="cr">
						<tr>
							<td>${cr.flightId}</td>
							<td>${cr.placeId}</td>
							<td>${cr.requestStatus}</td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
		<%@ include file="common/footer.jspf" %>
