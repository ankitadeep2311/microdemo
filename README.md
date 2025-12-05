Microservices multi-module Maven scaffold (user, orders, catalog, api-gateway)

How to use:
1. Import this project in IntelliJ/Eclipse as a Maven project using the root pom.xml.
2. Build all modules: mvn clean package
3. Run a service: mvn -pl user-service spring-boot:run
4. Build Docker images and deploy to Kubernetes as needed.

Replace 'yourdockerid' placeholders when building Docker images for remote clusters.
