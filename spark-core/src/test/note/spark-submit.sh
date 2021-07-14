bin/spark-submit \
--class org.apache.spark.examples.SparkPi \
--master local[2] \
./examples/jars/spark-examples_2.11-2.1.1.jar \
10

bin/spark-submit \
--class org.apache.spark.examples.SparkPi \
--master spark://master100:7077 \
./examples/jars/spark-examples_2.11-2.1.1.jar \
10