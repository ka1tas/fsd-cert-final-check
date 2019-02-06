FROM tomcat:8.5.37-jre8
COPY ./angular/viewnews/dist/viewnewsui/. /usr/local/tomcat/webapps/viewnewsui
COPY ./service/target/viewnews.war /usr/local/tomcat/webapps