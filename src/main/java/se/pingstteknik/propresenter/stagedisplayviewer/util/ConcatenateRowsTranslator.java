package se.pingstteknik.propresenter.stagedisplayviewer.util;

import static se.pingstteknik.propresenter.stagedisplayviewer.config.Property.DIVIDER;

/**
 * @author Daniel Kihlgren
 * @version 1.2.1
 * @since 1.0.0
 */
public class ConcatenateRowsTranslator {

    private static final String NEWLINE = "\n";

    public String transformSceneText(String currentSlideText) {
        return reconstructTextFromRows(splitString(currentSlideText));
    }

    private String[] splitString(String currentSlideText) {
        return currentSlideText.split(NEWLINE);
    }

    private String reconstructTextFromRows(String[] rows) {
        StringBuilder aggregatedText = new StringBuilder();
        for (int row = 0; row < rows.length - 1; row++) {
            aggregatedText.append(rows[row].trim());
            aggregatedText.append(row % 2 == 0 ? DIVIDER : NEWLINE);
        }
        aggregatedText.append(rows[rows.length-1].trim());

        return aggregatedText.toString();
    }
}