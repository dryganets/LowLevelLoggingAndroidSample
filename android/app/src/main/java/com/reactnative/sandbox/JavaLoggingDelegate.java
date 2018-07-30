package com.reactnative.sandbox;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import android.util.Log;

import com.facebook.common.logging.LoggingDelegate;

/**
 * This implementation is way more configurable then android.Log
 * java logging implementation of {@link LoggingDelegate}.
 */
public class JavaLoggingDelegate implements LoggingDelegate {

  private static final String UNKNOWN_TAG = "ReactUnknown";

  private final ThreadLocal<Map<String, Logger>> loggers;

  private int mMinimumLoggingLevel = Log.WARN;

  public JavaLoggingDelegate() {
    loggers = new ThreadLocal<Map<String, Logger>>() {
      @Override
      protected Map<String, Logger> initialValue() {
        return new HashMap<>();
      }
    };
  }

  @Override
  public void setMinimumLoggingLevel(int level) {
    mMinimumLoggingLevel = level;
  }

  @Override
  public int getMinimumLoggingLevel() {
    return mMinimumLoggingLevel;
  }

  @Override
  public boolean isLoggable(int level) {
    return mMinimumLoggingLevel <= level;
  }

  @Override
  public void v(String tag, String msg) {
    println(Log.VERBOSE, tag, msg);
  }

  @Override
  public void v(String tag, String msg, Throwable tr) {
    println(Log.VERBOSE, tag, msg, tr);
  }

  @Override
  public void d(String tag, String msg) {
    println(Log.DEBUG, tag, msg);
  }

  @Override
  public void d(String tag, String msg, Throwable tr) {
    println(Log.DEBUG, tag, msg, tr);
  }

  @Override
  public void i(String tag, String msg) {
    println(Log.INFO, tag, msg);
  }

  @Override
  public void i(String tag, String msg, Throwable tr) {
    println(Log.INFO, tag, msg, tr);
  }

  @Override
  public void w(String tag, String msg) {
    println(Log.WARN, tag, msg);
  }

  @Override
  public void w(String tag, String msg, Throwable tr) {
    println(Log.WARN, tag, msg, tr);
  }

  @Override
  public void e(String tag, String msg) {
    println(Log.ERROR, tag, msg);
  }

  @Override
  public void e(String tag, String msg, Throwable tr) {
    println(Log.ERROR, tag, msg, tr);
  }

  /**
   * <p> Note: this gets forwarded to {@code android.util.Log.e} as {@code android.util.Log.wtf}
   * might crash the app.
   */
  @Override
  public void wtf(String tag, String msg) {
    println(Log.ERROR, tag, msg);
  }

  /**
   * <p> Note: this gets forwarded to {@code android.util.Log.e} as {@code android.util.Log.wtf}
   * might crash the app.
   */
  @Override
  public void wtf(String tag, String msg, Throwable tr) {
    println(Log.ERROR, tag, msg, tr);
  }

  @Override
  public void log(int priority, String tag, String msg) {
    println(priority, tag, msg);
  }

  private void println(int priority, String tag, String msg) {
    getLogger(tag).log(getLevel(priority), msg);
    printToLogcat(priority, tag, msg, null);
  }

  private void println(int priority, String tag, String msg, Throwable tr) {
    getLogger(tag).log(getLevel(priority), msg, tr);
    printToLogcat(priority, tag, msg, tr);
  }

  /**
   * We are printing logs to logcat to be able to control logcat logging with our proguard config
   */
  private void printToLogcat(int priority, String tag, String msg, Throwable tr) {
    // In Logger configuration
    String message = msg;
    if (tr != null) {
      message = msg + "\n" + Log.getStackTraceString(tr);
    }
    Log.println(priority, tag, message);
  }

  private Logger getLogger(String tag) {
    Map<String, Logger> loggersMap = loggers.get();
    String normalizedTag = tag;

    if (normalizedTag == null) {
      normalizedTag = UNKNOWN_TAG;
    }
    
    Logger logger = loggersMap.get(normalizedTag);
    if (logger == null) {
      logger = Logger.getLogger(normalizedTag);
      loggersMap.put(normalizedTag, logger);
    }
    return logger;
  }

  private Level getLevel(int levelIndex) {
    Level level;

    switch (levelIndex) {
      case Log.VERBOSE:
        level = Level.FINEST;
        break;
      case Log.DEBUG:
        level = Level.FINE;
        break;
      case Log.INFO:
        level = Level.INFO;
        break;
      case Log.WARN:
        level = Level.WARNING;
        break;
      case Log.ERROR:
      case Log.ASSERT:
        level = Level.SEVERE;
        break;
      default:
        level = Level.FINEST;
    }

    return level;
  }
}
