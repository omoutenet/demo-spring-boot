package ch.ebu.ipush;

import org.springframework.boot.CommandLineRunner;

import java.util.concurrent.Callable;

/**
 * Created by sopra_om on 02.02.2017.
 */
public interface InitCommandLineRunner extends CommandLineRunner {
    String WAIT = "wait";

    boolean isInProgress();

    String getMessageStatus();

    Callable<String> getMessageStatusAsync();
}
