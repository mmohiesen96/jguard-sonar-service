build:
	mvn clean install

build-par:
	mvn clean install -T 16C

build-for:
	mvn clean install -U