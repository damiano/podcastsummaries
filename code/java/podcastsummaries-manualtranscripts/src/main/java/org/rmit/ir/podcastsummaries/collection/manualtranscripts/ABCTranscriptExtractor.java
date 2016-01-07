package org.rmit.ir.podcastsummaries.collection.manualtranscripts;

import java.io.File;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;

import com.google.common.base.Joiner;

public class ABCTranscriptExtractor extends TranscriptExtractor {

	private static final String[] TITLE_ATTRIBUTE = { "name", "Title" };
	private static final String[] TITLE_ATTRIBUTE_2 = { "name", "DC.title" };
	
	private static final String[] DESCRIPTION_ATTRIBUTE = { "name", "Description" };
	private static final String[] DESCRIPTION_ATTRIBUTE_2 = { "name", "DC.description" };
	

	private static final String[] TRANSCRIPT_ATTRIBUTE = { "class", "body" };

	private static final String[] TRANSCRIPT_ATTRIBUTE_2 = { "class", "first" };

	private static final String[] TRANSCRIPT_ATTRIBUTE_3 = { "class", "section" };

	private static final String ABC_SOURCE = "ABC";

	@Override
	public Transcript extractTranscript(String url) throws Exception {
		Document doc = Jsoup.connect(url).get();
		return extract(doc);
	}

	@Override
	public Transcript extractTranscript(File localFile) throws Exception {
		Document doc = Jsoup.parse(localFile, "UTF-8", "");
		return extract(doc);
	}

	private Transcript extract(Document doc) throws Exception {

		Elements mp3Links = doc.getElementsByAttributeValueMatching("href", ".mp3");
		boolean found = false;
		Iterator<Element> iter = mp3Links.iterator();
		Element elem2 = null;
		while (!found && iter.hasNext()) {
			elem2 = iter.next();
			if (elem2.text().contains("MP3 download"))
				found = true;
		}
		String audioURL = "";
		if (found)
			audioURL = elem2.attr("href");

		Elements titleElement = doc.getElementsByAttributeValue(TITLE_ATTRIBUTE_2[0], TITLE_ATTRIBUTE_2[1]);
		if (titleElement.size() == 0)
			titleElement = doc.getElementsByAttributeValue(TITLE_ATTRIBUTE[0], TITLE_ATTRIBUTE[1]);
		String title = titleElement.get(0).attr("content");
		
		Elements descriptionElement = doc.getElementsByAttributeValue(DESCRIPTION_ATTRIBUTE_2[0], DESCRIPTION_ATTRIBUTE_2[1]);
		if (descriptionElement.size() == 0)
			descriptionElement = doc.getElementsByAttributeValue(DESCRIPTION_ATTRIBUTE[0], DESCRIPTION_ATTRIBUTE[1]);
		String description = descriptionElement.get(0).attr("content");
		

		String manualTranscript;
		Elements transcriptElement = doc.getElementsByAttributeValue(TRANSCRIPT_ATTRIBUTE[0], TRANSCRIPT_ATTRIBUTE[1]);

		if (transcriptElement.size() == 0) {
			transcriptElement = doc.getElementsByAttributeValue(TRANSCRIPT_ATTRIBUTE_2[0], TRANSCRIPT_ATTRIBUTE_2[1]);
			if (transcriptElement.size() > 0) {
				StringBuffer buffer = new StringBuffer();
				Element e = transcriptElement.get(0);
				buffer.append(e.val());
				while (!e.val().contains("h2")) {
					e = e.nextElementSibling();
					buffer.append(e.val());
				}

				manualTranscript = buffer.toString();
			} else {
				transcriptElement = doc.getElementsContainingOwnText("Transcript");
				if (transcriptElement.size() == 0) {
					transcriptElement = doc.getElementsByAttributeValue(TRANSCRIPT_ATTRIBUTE_3[0],
							TRANSCRIPT_ATTRIBUTE_3[1]);
					manualTranscript = Joiner.on(' ').join(transcriptElement.get(6).childNodes());
				} else {
					int i = 0;
					Element elem = transcriptElement.get(i);

					while (!elem.tagName().equals("h2")) {
						elem = transcriptElement.get(i);
						i++;
					}

					manualTranscript = elem.nextSibling().toString();
				}
			}

		} else {
			manualTranscript = Joiner.on(' ').join(transcriptElement.get(0).childNodes());
		}

		manualTranscript = Jsoup.clean(manualTranscript, new Whitelist());

		Transcript parsedTranscript = new Transcript(title, description, manualTranscript, ABC_SOURCE, audioURL);
		return parsedTranscript;

	}
}
