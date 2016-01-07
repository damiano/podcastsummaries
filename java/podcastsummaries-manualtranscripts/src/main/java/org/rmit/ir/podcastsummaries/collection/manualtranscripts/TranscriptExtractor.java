package org.rmit.ir.podcastsummaries.collection.manualtranscripts;

import java.io.File;

public abstract class TranscriptExtractor {

	public TranscriptExtractor() {
		// System.setProperty("http.proxyHost", "proxy.rmit.edu.au");
		// System.setProperty("http.proxyPort", "8080");
	}

	public abstract Transcript extractTranscript(String url) throws Exception;

	public abstract Transcript extractTranscript(File localFile) throws Exception;

}
