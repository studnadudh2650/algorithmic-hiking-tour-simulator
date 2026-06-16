package th.rosenheim.oop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Handles the generation of Markdown-formatted output files.
 *
 * Responsibilities:
 * - Generates an overview of all tours.
 * - Creates detailed reports for each tour, including participant and item information.
 * - Writes the generated content to .md files.
 */

public class MarkdownWriter {

    public static void writeTourOverview(List<Tour> tours) {
        StringBuilder sb = new StringBuilder();
        sb.append("# Tour Overview\n\n");

        for (Tour tour : tours) {
            sb.append("## ").append(tour.getName()).append("\n");
            sb.append("- 📅 Date: ").append(tour.getDate()).append("\n");
            sb.append("- 🧑‍✈️ Guide: ").append(tour.getTourGuide().getName()).append("\n");
            sb.append("- 👨‍👩‍👧 Participants: ").append(tour.getParticipants().size()).append("\n\n");
        }

        try {
            Files.writeString(Path.of("tour-overview.md"), sb.toString());
        } catch (IOException e) {
            System.err.println("❌ Failed to write overview markdown: " + e.getMessage());
        }
    }

    public static void writeTourDetails(Tour tour) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ").append(tour.getName()).append(" Details\n\n");

        sb.append("- 📅 Date: ").append(tour.getDate()).append("\n");
        sb.append("- 🧑‍✈️ Tour Guide: ").append(tour.getTourGuide().getName()).append("\n\n");

        for (Participant p : tour.getParticipants()) {
            sb.append("## ").append(p.getName()).append(" (age: ").append(p.getAge()).append(")\n");
            sb.append("- 🎒 Carries:\n");
            double totalWeight = 0;

            if (p.getBackpack().isEmpty()) {
                sb.append("  - ⚠️ Carries nothing!\n");
            } else {
                for (Item item : p.getBackpack()) {
                    sb.append("  - ").append(item.getName()).append(" (").append(item.getWeight()).append(" kg)\n");
                    totalWeight += item.getWeight();
                }
            }

            sb.append("- 💪 Total: ").append(totalWeight).append(" kg\n\n");
        }

        String filename = "tour-" + tour.getName().toLowerCase().replace(" ", "-") + ".md";
        try {
            Files.writeString(Path.of(filename), sb.toString());
        } catch (IOException e) {
            System.err.println("❌ Failed to write tour markdown: " + e.getMessage());
        }
    }
}