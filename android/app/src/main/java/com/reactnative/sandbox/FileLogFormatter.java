package com.reactnative.sandbox;

import java.util.Calendar;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/**
 * Highly optimized and thread safe log formatter
 */
public class FileLogFormatter extends java.util.logging.Formatter {

  public static final String EOL = System.getProperty("line.separator");
  private final ThreadLocal<Calendar> calendar = new ThreadLocal<Calendar>() {

    @Override
    public Calendar initialValue() {
      return Calendar.getInstance(TimeZone.getTimeZone("GMT"));
    }
  };

  public FileLogFormatter() {
  }

  private String timePrefix(LogRecord record) {
    StringBuilder result = new StringBuilder(64);
    Calendar calendar = this.calendar.get();
    calendar.setTimeInMillis(record.getMillis());
    appendTwoDigitInt(result, calendar.get(Calendar.MONTH) + 1);
    result.append('-');
    appendTwoDigitInt(result, calendar.get(Calendar.DAY_OF_MONTH));
    result.append(' ');
    appendTwoDigitInt(result, calendar.get(Calendar.HOUR_OF_DAY));
    result.append(':');
    appendTwoDigitInt(result, calendar.get(Calendar.MINUTE));
    result.append(':');
    appendTwoDigitInt(result, calendar.get(Calendar.SECOND));
    result.append('.');
    appendThreeDigitInt(result, calendar.get(Calendar.MILLISECOND));
    result.append(' ')
      .append(getLevelChar(record.getLevel()))
      .append(' ')
      .append(record.getLoggerName())
      .append(": ");

    return result.toString();
  }

  private char getLevelChar(Level level) {
   int levelValue = level.intValue();

    if (levelValue == Level.SEVERE.intValue()) {
      return 'E';
    } else if (levelValue == Level.WARNING.intValue()) {
      return 'W';
    } if (levelValue == Level.CONFIG.intValue() || levelValue == Level.INFO.intValue()) {
      return 'I';
    } else if (levelValue == Level.FINE.intValue()) {
      return 'D';
    } else {
      return 'V';
    }
  }

  private void appendTwoDigitInt(StringBuilder builder, int value) {
    if (value < 10) {
      builder.append(0);
    }
    builder.append(value);
  }

  private void appendThreeDigitInt(StringBuilder builder, int value) {
    if (value < 100) {
      builder.append(0);
    }
    appendTwoDigitInt(builder, value);
  }

  @Override
  public synchronized String format(LogRecord logRecord) {
    StringBuilder result = new StringBuilder(512);
    String prefix = timePrefix(logRecord);

    result.append(prefix)
      .append(logRecord.getMessage())
      .append(EOL);

    Throwable throwable = logRecord.getThrown();
    if (throwable != null) {
      result.append(prefix).append(throwable.getMessage());
      result.append(EOL);
      for (StackTraceElement stackFrame : throwable.getStackTrace()) {
        result.append(prefix)
          .append('\t')
          .append(stackFrame.getClassName()).append('.')
          .append(stackFrame.getMethodName()).append('(')
          .append(stackFrame.getFileName())
          .append(':')
          .append(stackFrame.getLineNumber())
          .append(')')
          .append(EOL);
      }
    }

    return result.toString();
  }
}
