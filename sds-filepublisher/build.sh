#!/bin/bash

SDS_HOME=..
JAVA_HOME=/usr/lib/jvm/jre/

javac -cp "$JAVA_HOME/lib/:$SDS_HOME/lib/*:$SDS_HOME/web/WEB-INF/lib/*" org/koslab/symmetric/FilePublisher.java

mkdir dist/

zip -r dist/koslab-sds-filepublisher.jar org/
