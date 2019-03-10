# jppm-java
using pmml file for prediction

Usages (using jpmml library to read pmml file created in the project spark-pmml-java and making prediction)
in real sceanrio a rest end point can receive the parameters and an argument map  will be created and will be used for predication.

Download the project:
git clone https://github.com/hexana/jpmml-java.git

build the project
cd jpmml-java; mvn clean install

Example:
java -jar spark-pmml-0.0.1-SNAPSHOT-jar-with-dependencies.jar <pmml file path>
  
this is going to be a test

USER VALUE::Male

USER VALUE::Yes

USER VALUE::Private

USER VALUE::55

USER VALUE::1.0

USER VALUE::0

USER VALUE::17.6
  
stroke {result=0, probability_entries=[0=0.9739583333333334, 1=0.026041666666666668], entityId=16, confidence_entries=[]}

