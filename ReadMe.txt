Camel Project for Spring 
=========================================

To build this project use

    mvn install

To run the project you can execute the following Maven goal

    mvn camel:run

For more help see the Apache Camel documentation

    http://camel.apache.org/


##############################################################
How to use this Demo : 
    
1) Populate database 
you can create as many records as you like by changing parameter n

	curl "http://localhost:8123/populate?name=toto&description=leaning&age=10&occupation=student&n=20"
	curl "http://localhost:8123/populate?name=titi&description=teaching&age=35&occupation=teacher&n=10"

2) Test Extraction

	curl -X PUT --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{	"occupation": "student"	}' 'http://localhost:8123/extract'

Watch the file target/event.txt and target/extract.txt

3) Test a failure to see exception handing by entering wrong inputs
	curl -X PUT --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{	"tttt": "xxxx"	}' 'http://localhost:8123/extract'

Watch the file target/event.txt

#############################################################
To compare streaming vs non streaming : 

1)change the heap size 

	export MAVEN_OPTS="-Xmx128m"

2)Run the project 

	mvn clean package camel:run

3)Populate  2 million records
	
	curl "http://localhost:8123/populate?name=titi&description=teaching&age=35&occupation=teacher&n=2000000"
 
4) Test with streaming and see that there is no heap space issue
	curl -X PUT --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{	"occupation": "teacher"	}' 'http://localhost:8123/extract'
	
5) Test without streaming to see a out of mem error
	curl http://localhost:8123/extractNoStream
	