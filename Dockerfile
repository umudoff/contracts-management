FROM openjdk:8
EXPOSE 8085
COPY target/contract-management.jar /contract-management.jar
ENTRYPOINT ["java","-jar", "/contract-management.jar"]

#ADD target/contract-management.jar contract-management.jar
#ENTRYPOINT ["java","-jar", "/contract-management.jar"]