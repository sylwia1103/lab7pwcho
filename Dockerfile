FROM java:8  
COPY . /
WORKDIR /  
RUN javac MyClass.java
CMD ["java", "-classpath", "mysql-connector-java-8.0.12.jar:.","MyClass"]

