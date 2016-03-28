# Build myapp server Docker container
FROM jetty
MAINTAINER t.girault@gmail.com

# Copie des sources dans le répertoire apache
COPY planning-authorization-server/target/planning-authorization-server.war /var/lib/jetty/webapps/
COPY planning-resource-server/target/planning-resource-server.war /var/lib/jetty/webapps/