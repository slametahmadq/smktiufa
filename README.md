# smktiufa
#Prerequisites

JDK >= 1.6
Maven 3
MySQL
Nodejs
Grunt CLI
Bower
Quickstart

#Running Yama

Generate from archetype

mvn archetype:generate \
-DarchetypeGroupId=org.meruvian.yama \
-DarchetypeArtifactId=yama-starter-archetype \
-DarchetypeVersion=2.0.0.Beta2
Change database configuration on webapi/src/main/resources/config/yama-dev.yml Create database schema

Install node and bower dependency in webpp directory

$ cd <yama-root-directory>/webapp
$ npm install
$ bower install
Run Yama

$ cd <yama-root-directory>
$ mvn test -Pwebapi
