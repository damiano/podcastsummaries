package org.rmit.ir.podcastsummaries.collection.manualtranscripts;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import com.google.common.base.Charsets;

public class ExtractTranscriptsMain {

	public static void main(String[] args) throws IOException {

		if (args.length < 3) {
			System.out.println("3 parameters needed: INPUT_FILE OUTPUT_TRANSCRIPTS_DIR OUTPUT_METADATA_FILE");
			System.exit(1);
		}

		String inputFile = args[0];
		String outputTranscriptsDir = args[1];
		String outputMetadataFile = args[2];

		TranscriptExtractor extractor = new ABCTranscriptExtractor();

		CsvReader reader = new CsvReader(inputFile, '\t', Charsets.UTF_8);

		CsvWriter writer = new CsvWriter(outputMetadataFile, '\t', Charsets.UTF_8);
		String[] header = { "id", "title", "description", "audioURL" };

		writer.writeRecord(header);

		reader.readHeaders();
		while (reader.readRecord()) {
			String[] record = reader.getValues();

			String id = record[0];
			String audioURL = record[1];
			String transcriptURL = record[2];
            System.out.println("Extracting transcript of document " + id + "...");
			try {
				Transcript transcript = extractor.extractTranscript(transcriptURL);
				if (!transcript.getManualTranscript().isEmpty()
						|| !transcript.getManualTranscript().contains("ranscript will be available shortly")) {

					// Write manual transcript
					File outputFile = new File(outputTranscriptsDir + "/" + id);
					FileUtils.writeStringToFile(outputFile, transcript.getManualTranscript());

					// Write metadata
					String[] metadataRecord = { id, transcript.getTitle(), transcript.getDescription(), audioURL };
					writer.writeRecord(metadataRecord);
				}
			} catch (Exception e) {
				System.out.println("Unable to extract transcript for document \t" + id);
				e.printStackTrace();
			}
		}

		writer.close();
	}
}