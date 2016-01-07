package org.rmit.ir.podcastsummaries.collection.manualtranscripts;

import org.rmit.ir.utils.HashUtils;

public class Transcript {

	private String id;
	private String title;
	private String description;
	private String manualTranscript;
	private String source;
	private String audioURL;

	public Transcript(String title, String description, String manualTranscript, String source, String audioURL) {
		this.title = title;
		this.id = HashUtils.md5hash(title);
		this.setDescription(description);
		this.manualTranscript = manualTranscript;

		this.source = source;
		this.audioURL = audioURL;

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getManualTranscript() {
		return manualTranscript;
	}

	public void setManualTranscript(String transcript) {
		this.manualTranscript = transcript;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getMp3() {
		return audioURL;
	}

	public void setMp3(String mp3) {
		this.audioURL = mp3;
	}

	public String getTitleMD5() {
		return id;
	}

	public void setTitleMD5(String titleMD5) {
		this.id = titleMD5;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
