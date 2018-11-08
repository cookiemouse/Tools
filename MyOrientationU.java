package com.yundian.cookie.project_login.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class MyOrientationU implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mSensor;
    private Context mContext;
    private float direction;

    private OnOrientationListener mOnOrientationListener;

    public MyOrientationU(Context context) {
        this.mContext = context;
        mSensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ORIENTATION) {
            float x = event.values[SensorManager.DATA_X];
            if (Math.abs(x - direction) > 1.0) {
                if (mOnOrientationListener != null) {
                    mOnOrientationListener.onChanged(x);
                }
            }
            direction = x;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    public void start() {
        if (null != mSensorManager) {
            mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        }
        if (null != mSensor) {
            mSensorManager.registerListener(this, mSensor, SensorManager.SENSOR_DELAY_UI);
        }
    }

    public void stop() {
        mSensorManager.unregisterListener(this);
    }

    public interface OnOrientationListener {
        void onChanged(float direction);
    }

    public void setOnOrientationListener(OnOrientationListener listener) {
        this.mOnOrientationListener = listener;
    }
}
