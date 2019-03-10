# jppm-java
using pmml file for prediction

Usages (using jpmml library to read pmml file created in the project spark-pmml-java project and making prediction)

Download the project:
git clone https://github.com/hexana/jpmml-java.git

build the project
cd jpmml-java; mvn clean install

Example:
java -jar spark-pmml-0.0.1-SNAPSHOT-jar-with-dependencies.jar <pmml file path>

stroke {result=0, probability_entries=[0=0.9739583333333334, 1=0.026041666666666668], entityId=16, confidence_entries=[]}

