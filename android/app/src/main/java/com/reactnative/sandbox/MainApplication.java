package com.reactnative.sandbox;

import android.app.Application;
import android.content.Context;
import android.os.Environment;
import android.util.Log;

import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class MainApplication extends Application implements ReactApplication {

  private static final String APP_LOG_PREFIX = BuildConfig.APPLICATION_ID;
  private static final String APP_LOG_PATTERN = APP_LOG_PREFIX + ".%g.log";

  private static final int LOG_FILE_SIZE = 2 * 1024 * 1024;
  private static final int LOGS_COUNT = 4;

  static File getAppLogsPath(Context context) {
    return (Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED) ? context.getExternalCacheDir() : context.getCacheDir();
  }

  private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
    @Override
    public boolean getUseDeveloperSupport() {
      return BuildConfig.DEBUG;
    }

    @Override
    protected List<ReactPackage> getPackages() {
      return Arrays.<ReactPackage>asList(
          new MainReactPackage()
      );
    }

    @Override
    protected String getJSMainModuleName() {
      return "index";
    }
  };

  @Override
  public ReactNativeHost getReactNativeHost() {
    return mReactNativeHost;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    File filePattern = new File(getAppLogsPath(this), APP_LOG_PATTERN);
    LoggerConfiguration.configureLogger(filePattern, Log.VERBOSE, LOG_FILE_SIZE, LOGS_COUNT);
    SoLoader.init(this, /* native exopackage */ false);
  }
}
