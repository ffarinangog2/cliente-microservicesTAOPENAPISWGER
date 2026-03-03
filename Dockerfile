# Imagen base con Java 21
FROM eclipse-temurin:21-jdk-alpine

# Directorio dentro del contenedor
WORKDIR /app

# Copiar el jar al contenedor
COPY target/*.jar app.jar

# Exponer el puerto del microservicio
EXPOSE 9095

# Comando de arranque
ENTRYPOINT ["java","-jar","app.jar"]