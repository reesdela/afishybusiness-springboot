FROM tomcat:10.1

COPY /target/afishybusiness.war /usr/local/tomcat/webapps/

CMD [ "catalina.sh", "run" ]