# lookup-service
small service maintains lookups, resource bundle, all entries in form of key value</br>
Mostly almost all microservices <br/>
each service will pull it's lookups by their prefixes   
 
# prerequisites
config server should be up and run<br/>
<a href="https://github.com/JavaAdore/config-server">https://github.com/JavaAdore/config-server</a> <br/>
eureka server should be up and run<br/>
<a href="https://github.com/JavaAdore/eureka-server">https://github.com/JavaAdore/eureka-server</a> <br/>

authorization server should be up and run<br/>

<a href="https://github.com/JavaAdore/authorization-server">https://github.com/JavaAdore/authorization-server</a> <br/>


zipkin server nice be up and run so you can track the request<br/>
<a href="https://github.com/JavaAdore/zipkin-server">https://github.com/JavaAdore/zipkin-server</a> <br/>


Postgres DB <br/>
RabbitMQ <br/>
Redis (used for caching) <br/>
 


 

environment variables should be added

# ZIPKIN_SERVER_IP = 127.0.0.1
127.0.0.1 the ip of machine where zipkin server runs
# SLEUTH_LOGGING_LEVEL=info
level of sleuth loggin

# RABBITMQ_LISTENER_IP = 127.0.0.1
# RABBITMQ_LISTENER_PORT = 5672
# RABBITMQ_DEFAULT_USER = user
change user to username of rabbitmq
# RABBITMQ_DEFAULT_PASS = password
change password to username of rabbitmq


# POSTGRES_SERVER_IP    = 127.0.0.1
# POSTGRES_SERVER_PORT  = 5432
# POSTGRES_DBNAME 	    = postgres     
 
 
# AUTHORIZATION_SERVER_IP=127.0.0.1
# AUTHORIZATION_SERVER_PORT=8888

# EUREKA_SERVER_IP      = 127.0.0.1
# EUREKA_SERVER_PORT    = 8761

# REDIS_SERVER_IP		= 127.0.0.1
# REDIS_SERVER_PORT    = 5432
# REDIS_SERVER_PASSWORD= testPassword


# user-service provides the following functionalities

void saveResourceBundleEntry(ResourceBundleEntry resourceBundleEntry) throws ServiceException;

Map<String, String> getResourceBundleMap(String prefex, String localeCode) throws ServiceException;

# build
as root/Administration <br/>
mvn clean install docker:removeImage docker:build
# run
java -jar target/lookup-service.jar
