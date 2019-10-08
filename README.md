# 02-microservices-individual-tasks-stefanleithenmayr

## First create the project via Maven
`mvn io.quarkus:quarkus-maven-plugin:0.21.1:create \
    -DprojectGroupId=at.htl \
    -DprojectArtifactId=cardealer-service \
    -DclassName="at.htl.services.car.controller.EmployeeController" \
    -Dpath="/cardealer" \
    -Dextensions="resteasy-jackson, hibernate-validator"`
