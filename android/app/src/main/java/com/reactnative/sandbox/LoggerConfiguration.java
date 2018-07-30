package com.reactnative.sandbox;

import android.util.Log;

import com.facebook.common.logging.FLog;
import com.facebook.common.logging.LoggingDelegate;
import com.skype4life.logging.FileLogFormatter;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

/**
 * Logger configuration interface
 */
public class LoggerConfiguration {
  private static final String TAG = "ReactLogging";
  private static FileHandler handler;

	/**
   *
   * @param file file to write logs to
   * @param minLogLevel minimum log level would be written to file
   * @param maxFileSize maximum file size
   * @param countFiles maximum count of files stored
	 */
  public static void configureLogger(File file, int minLogLevel, int maxFileSize, int countFiles) {
    LoggingDelegate delegate = new JavaLoggingDelegate();
    delegate.setMinimumLoggingLevel(minLogLevel);
    FLog.setLoggingDelegate(delegate);
    if (handler == null) {
      try {
        handler = new FileHandler(file.getAbsolutePath(), maxFileSize, countFiles, true);
        handler.setFormatter(new FileLogFormatter());
        Logger global = Logger.getLogger("");
        Handler[] handlers = global.getHandlers();
        // we are removing log handlers in order to have Logcat logging in JavaLoggingDelegate
        // this way we could control app logging with proguard
        for(Handler loggerHandler: handlers) {
          global.removeHandler(loggerHandler);
        }
        global.addHandler(handler);
      } catch (IOException e) {
        Log.e(TAG, "logging initialization failed", e);
      }
    }
  }
}
