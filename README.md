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

# Abstract

We address the challenge of extracting "query biased audio
summaries" from podcasts to support users in making relevance
decisions in spoken document search via an audio-only communication
channel.  We performed a crowdsourced experiment that demonstrates
that transcripts of spoken documents created using Automated Speech
Recognition (ASR), even with significant errors, are effective sources
of document summaries or "snippets" for supporting users in making
relevance judgments against a query. In particular, results show that
summaries generated from ASR transcripts are comparable, in utility
and user-judged preference, to spoken summaries generated from
error-free manual transcripts of the same collection. We also observed
that content-based audio summaries are at least as preferred as
synthesized summaries obtained from manually curated metadata, such as
title and description. 
We describe a methodology for constructing a
new test collection which we have made publicly available.

# Citation

Please cite the article below if you use this resource in your research:

Damiano Spina, Johanne R. Trippas, Lawrence Cavedon, Mark Sanderson
[Extracting Audio Summaries to Support Effective Spoken Document Search](http://www.damianospina.com/wp-content/uploads/2016/10/summaries-noisytranscripts-JASIST2016-preprint.pdf)
Journal of the Association for Information Science and Technology. To Appear.

## BibTex
```
@article{spina_extracting,
	author = "Spina, Damiano and Trippas, Johanne R. and Cavedon, Lawrence and Sanderson, Mark",
        title = {Extracting Audio Summaries to Support Effective Spoken Document Search},
        journal = {Journal of the Association for Information Science and Technology},
        year = {To Appear}
}
```
<!---
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
-->

## Examples
The 'data/examples' directory include some examples of SERP pages with audio summaries extracted from automatic transcripts. Use [HTML preview]("http://htmlpreview.github.io/") to render the HTML files.

- Example 1: http://htmlpreview.github.io/?https://github.com/damiano/podcastsummaries/blob/master/data/examples/example1.html
- Example 2: http://htmlpreview.github.io/?https://github.com/damiano/podcastsummaries/blob/master/data/examples/example2.html



For more information, please contact [Damiano Spina](http://www.damianospina.com/contact).
