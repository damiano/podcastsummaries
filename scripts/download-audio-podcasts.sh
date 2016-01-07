#!/bin/sh
CUR_DIR=`pwd`
cd `dirname $0`

for URL in `cut -f 2 ../data/documents/documents_urls.tsv | tr -d \"`
do 
  wget -c -P ../data/documents/audio-podcasts $URL
done

cd  $CUR_DIR
