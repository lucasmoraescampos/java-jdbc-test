rm -rf out
javac -cp lib/mysql-connector-java-8.0.30.jar -d out src/main/java/App.java
java -cp "out:lib/mysql-connector-java-8.0.30.jar" App
