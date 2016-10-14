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
          <p>Welcome, ${msg}!</p>
          <!--<p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a></p>-->
      </div>
      <div class="row well">
        <div class="[ col-xs-12 col-sm-offset-2 col-sm-8 ]">
          <ul class="event-list">
            <li>
              <time datetime="2014-07-20">
                <span class="day">4</span>
                <span class="month">Jul</span>
                <span class="year">2014</span>
                <span class="time">ALL DAY</span>
              </time>
              <div class="info">
                <h2 class="title"><a href="#">Independence Day</a></h2>
                <p class="desc">United States Holiday</p>
              </div>
            </li>

            <li>
              <time datetime="2014-07-20 0000">
                <span class="day">8</span>
                <span class="month">Jul</span>
                <span class="year">2014</span>
                <span class="time">12:00 AM</span>
              </time>
              <div class="info">
                <h2 class="title">One Piece Unlimited World Red</h2>
                <p class="desc">PS Vita</p>
              </div>
            </li>

            <li>
              <time datetime="2014-07-20 2000">
                <span class="day">20</span>
                <span class="month">Jan</span>
                <span class="year">2014</span>
                <span class="time">8:00 PM</span>
              </time>
              <div class="info">
                <h2 class="title">Mouse0270's 24th Birthday!</h2>
                <p class="desc">Bar Hopping in Erie, Pa.</p>
              </div>
            </li>

            <li>
              <time datetime="2014-07-31 1600">
                <span class="day">31</span>
                <span class="month">Jan</span>
                <span class="year">2014</span>
                <span class="time">4:00 PM</span>
              </time>
              <div class="info">
                <h2 class="title">Disney Junior Live On Tour!</h2>
                <p class="desc"> Pirate and Princess Adventure</p>
              </div>
            </li>
          </ul>
        </div>
      </div>
  </div>
  <%@include file="template/footer.jsp"%>
