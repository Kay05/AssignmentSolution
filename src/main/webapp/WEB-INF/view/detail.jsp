<%--
  Created by IntelliJ IDEA.
  User: kuda
  Date: 10/15/2016
  Time: 1:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="template/header.jsp"%>
<!-- About Starts -->
<div class="container">
  <div class="row jumbotron well">
    <h1>Project: ${project.title}</h1>
  </div>
  <div class="row well">
    <div class="col-xs-12 col-md-6 col-lg-6">
      <div class="panel panel-primary">
        <!-- Default panel contents -->
        <div class="panel-heading">Project ID: ${project.pk}</div>
        <div class="panel-body">
          <p>${project.description}</p>
        </div>

        <!-- List group -->
        <ul class="list-group">
          <li class="list-group-item"><i class="fa fa-calendar"></i> Start Date: ${project.start_date}</li>
          <li class="list-group-item"><i class="fa fa-calendar"></i> End Date: ${project.end_date}</li>
          <li class="list-group-item"><i class="fa fa-money"></i> Billable: <c:if test="${project.is_billable}">Yes</c:if><c:if test="${!project.is_billable}">No</c:if></li>
          <li class="list-group-item"><i class="fa fa-check-circle-o"></i> Active: <c:if test="${project.is_active}">Yes</c:if><c:if test="${!project.is_active}">No</c:if></li>
        </ul>
      </div>
    </div>
    <div class="col-xs-12 col-md-6 col-lg-6">
      <h3>Tasks</h3>
      <div class="timeline">

        <c:if test="${not empty project.task_set}">
          <c:forEach var="task" items="${project.task_set}">
            <!-- Line component -->
            <div class="line text-muted"></div>

            <!-- Separator -->
            <div class="separator text-muted">
              <time>${task.due_date.split('-')[2]}. ${task.due_date.split('-')[1]}. ${task.due_date.split('-')[0]} </time>
            </div>
            <!-- /Separator -->

            <!-- /Panel -->

            <!-- Panel -->
            <article class="panel panel-primary">

              <!-- Icon -->
              <div class="panel-heading icon">
                <i class="fa fa-plus"></i>
              </div>
              <!-- /Icon -->

              <!-- Heading -->
              <div class="panel-heading">
                <h2 class="panel-title">${task.title}</h2>
              </div>
              <!-- /Heading -->

              <!-- Body -->
              <div class="panel-body">
                <i class="fa fa-calendar-times-o"></i> Estimated Hours: ${task.estimated_hours}<br/>
                <i class="fa fa-calendar"></i> Due Date: ${task.due_date}
              </div>
              <!-- /Body -->

              <!-- Footer -->
              <div class="panel-footer">
                <small>Task ID: ${task.id}<br/> Project ID: ${task.project}</small>
              </div>
              <!-- /Footer -->

            </article>
            <!-- /Panel -->
          </c:forEach>
        </c:if>
        <!-- Panel -->
        <article class="panel panel-info panel-outline">

          <!-- Icon -->
          <div class="panel-heading icon">
            <i class="glyphicon glyphicon-info-sign"></i>
          </div>
          <!-- /Icon -->

          <!-- Body -->
          <div class="panel-body">
            <c:if test="${not empty project.task_set}">Tasks End.</c:if>
            <c:if test="${empty project.task_set}">No Tasks.</c:if>
          </div>
          <!-- /Body -->

        </article>
        <!-- /Panel -->

      </div>
      <!-- /Timeline -->

    </div>
    </div>
  </div>
</div>
<%@include file="template/footer.jsp"%>
