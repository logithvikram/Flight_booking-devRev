
	<%@ include file="common/header.jspf" %>
    <%@ include file="common/navigation.jspf" %>
		<div class="container">
			<h1>List of Flight</h1>
			<table class="table">
				<thead>
					<tr>
						<th>Id</th>
						<th>Model</th>
<%--						<th>Class</th>--%>
						<th>Seating Capacity</th>
						<th>placeId</th>
                        <th>Book</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${flights}" var="flight">
						<tr>
							<td>${flight.id}</td>
							<td>${flight.model}</td>
<%--							<td>${flight.color}</td>--%>
							<td>${flight.seatingCapacity}</td>
							<td>${flight.placeId}</td>
                            <td><a href="book-flight?flightId=${flight.id}&username=${username}" class="btn btn-warning">Book</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<%@ include file="common/footer.jspf" %>
