package me.nucleartux.date;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class DateModule extends ReactContextBaseJavaModule {
  private FragmentActivity mActivity = null;

  public DateModule(ReactApplicationContext reactContext, FragmentActivity activity) {
    super(reactContext);
    mActivity = activity;
  }

  @Override
  public String getName() {
    return "DateAndroid";
  }

  @ReactMethod
  public void showDatepicker(Callback errorCallback, Callback successCallback) {
    this.showDatepickerWithInitialDate(null, null, errorCallback, successCallback);
  }

  @ReactMethod
  public void showDatepickerWithInitialDate(String dateTimeFormat, String initialDateString, Callback errorCallback,
                                            Callback successCallback) {
    DialogFragment dateDialog = new DatePicker(DateFormatHelper.parseDate(initialDateString, dateTimeFormat),
            errorCallback, successCallback);
    dateDialog.show(mActivity.getSupportFragmentManager(), "datePicker");
  }

  @ReactMethod
  public void showDatepickerWithInitialMinMaxDate(String dateTimeFormat, String initialDateString,
            String minDateString, String maxDateString, Callback errorCallback,
            Callback successCallback) {
    DialogFragment dateDialog = new DatePicker(DateFormatHelper.parseDate(initialDateString, dateTimeFormat),
            DateFormatHelper.parseDate(minDateString, dateTimeFormat),
            DateFormatHelper.parseDate(maxDateString, dateTimeFormat),
            errorCallback, successCallback);
    dateDialog.show(mActivity.getSupportFragmentManager(), "datePicker");
  }

  @ReactMethod
  public void showTimepicker(Callback errorCallback, Callback successCallback) {
    this.showTimepickerWithInitialTime(null, null, errorCallback, successCallback);
  }

  @ReactMethod
  public void showTimepickerWithInitialTime(String dateTimeFormat, String initialDateString, Callback errorCallback,
                                            Callback successCallback) {
    DialogFragment dateDialog = new TimePicker(DateFormatHelper.parseDate(initialDateString, dateTimeFormat),
            errorCallback, successCallback);
    dateDialog.show(mActivity.getSupportFragmentManager(), "timePicker");
  }
}
