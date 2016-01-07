#!/bin/sh
CUR_DIR=`pwd`
cd `dirname $0`

cd ../code/java/podcastsummaries-manualtranscripts
mvn clean compile assembly:single
cd $CUR_DIR/`dirname $0`
java -jar ../code/java/podcastsummaries-manualtranscripts/target/*-jar-with-dependencies.jar ../data/documents/documents_urls.tsv ../data/documents/manual-transcripts ../data/documents/metadata.tsv

cd $CUR_DIR
