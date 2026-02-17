package com.teic.library;

import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.InfoCmp;
import org.jline.utils.NonBlockingReader;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {
        try {
            Terminal terminal = TerminalBuilder.builder().system(true).build();

            NonBlockingReader reader = terminal.reader();

            PrintWriter writer = terminal.writer();

            writer.println("Press any key (or 'q' to quit)");
            writer.flush();

            long startTime = System.nanoTime();

            while (System.nanoTime() - startTime < 5_000_000_000L) {
                try {
                    if (reader.available() > 0) {
                        int c = reader.read();
                        writer.println("Read Character: " + (char) c);
                        writer.flush();
                    }

                    writer.print(".");
                    writer.flush();
                    TimeUnit.MILLISECONDS.sleep(500);
                }
                catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }

            writer.println("Goodbye!");
            terminal.close();
        }
        catch (IOException e) {
            System.err.println("Error creating terminal: " + e.getMessage());
        }
    }
}
