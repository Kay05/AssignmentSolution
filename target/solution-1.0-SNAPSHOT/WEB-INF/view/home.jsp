<%--
  Created by IntelliJ IDEA.
  User: kuda
  Date: 10/13/2016
  Time: 9:26 PM
  To change this template use File | Settings | File Templates.
--%>
  <%@include file="template/header.jsp"%>
    <!-- About Starts -->
  <div class="container">
      <div class="row jumbotron well">
          <h1>Projects</h1>
          <p>Welcome, ${msg}! ${projects[0].title}</p>
          <!--<p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a></p>-->
      </div>
      <div class="row well">
        <div class="[ col-xs-12 col-sm-offset-2 col-sm-8 ]">
          <ul class="event-list">
            <c:forEach items="${projects}" var="project">
                <li>
                  <time datetime="2014-07-20">
                    <span class="day">${project.start_date.split('-')[2]}</span>
                    <span class="month">${project.start_date.split('-')[1]}</span>
                    <span class="year">${project.start_date.split('-')[0]}</span>
                    <span class="time">ALL DAY</span>
                  </time>
                  <div class="info">
                    <h2 class="title"><a href="#">${project.title}</a></h2>
                    <p class="desc">${project.description}</p>
                  </div>
                </li>
            </c:forEach>
          </ul>
        </div>
      </div>
  </div>
  <%@include file="template/footer.jsp"%>
