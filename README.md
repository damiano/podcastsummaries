# [Podcast Summaries](http://damiano.github.io/podcastsummaries/)

This repository contains the dataset used to analyze user preferences of podcast summaries.


We provide all the releasable data:
 * Queries
 * Query biased summaries, for both text and audio channels
 * Automatic transcripts
 * Relevance and preference judgments

We also release a software package to download the copyrighted content:
* Audio podcasts (mp3)
* Manual transcripts

The repository is organized as follows:
```
.
+-- data
|   +-- documents
|   |      +-- audio-podcasts               
|   |      +-- manual-transcripts
|   |      +-- automatic-transcripts.tar.gz
|   |      +-- documents_urls.tsv
|   +-- examples
|   +-- judgments
|   |      +--preference-task
|   |      +--relevance-task
|   +-- summaries
|   |      +--audio
|   |      +--text
|   +-- queries.tsv
+-- java
|   +-- podcastsummaries-manualtranscripts
+-- scripts
|   +-- download-audio-podcasts.sh
|   +-- extract-manual-transcripts.sh
```

## Documents
### Audio Podcasts
### Manual Transcripts
### Automatic Transcripts

## Queries

## Judgments
### Relevance Task
### Preference Task

## Summaries
### Text Summaries
### Audio Summaries

## Examples
The 'data/examples' directory include some examples of SERP pages with audio summaries extracted from automatic transcripts. Use [HTML preview]("http://htmlpreview.github.io/") to render the HTML files.

- Example 1: http://htmlpreview.github.io/?https://github.com/damiano/podcastsummaries/blob/master/data/examples/example1.html
- Example 2: http://htmlpreview.github.io/?https://github.com/damiano/podcastsummaries/blob/master/data/examples/example2.html



For more information, please contact [Damiano Spina](http://www.damianospina.com/contact).
