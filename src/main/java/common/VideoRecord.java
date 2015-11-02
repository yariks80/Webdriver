package common;

import java.awt.*;
import org.monte.screenrecorder.ScreenRecorder;
/**
 * Created by HOME on 02.11.2015.
 *
 */
public class VideoRecord {
    private static ScreenRecorder screenRecorder;

    public static void startRecording() throws Exception {
        GraphicsConfiguration gc = GraphicsEnvironment
                .getLocalGraphicsEnvironment().getDefaultScreenDevice()
                .getDefaultConfiguration();

        screenRecorder = new ScreenRecorder(gc);
        screenRecorder.start();
    }

    public static void stopRecording() throws Exception {
        screenRecorder.stop();
    }
}
