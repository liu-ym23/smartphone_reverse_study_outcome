package com.android.settings;

import android.content.Context;
import android.text.TextUtils;
import com.android.settings.wifi.WifiTrackerLibProvider;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FeatureFactory {
    private static final boolean DEBUG = false;
    private static final String LOG_TAG = "FeatureFactory";
    protected static Context sAppContext;
    protected static FeatureFactory sFactory;

    public static final class FactoryNotFoundException extends RuntimeException {
        public FactoryNotFoundException(Throwable r2) {
            super("Unable to create factory. Did you misconfigure Proguard?", r2);
        }
    }

    public abstract WifiTrackerLibProvider getWifiTrackerLibProvider();

    public FeatureFactory() {
    }

    public static FeatureFactory getFactory(Context r2) {
        FeatureFactory r0 = sFactory;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (sAppContext != null) goto L8;
        sAppContext = r2.getApplicationContext();
    L8:
        String r1 = r2.getString(R.string.config_featureFactory);
        if (TextUtils.isEmpty(r1) == true) goto L16;
        FeatureFactory r3 = (FeatureFactory) r2.getClassLoader().loadClass(r1).newInstance();     // Catch: Throwable -> L12
        sFactory = r3;     // Catch: Throwable -> L12
        return r3;
    L12:
        e = move-exception;
        throw new FactoryNotFoundException(e);
    L16:
        throw new UnsupportedOperationException("No feature factory configured");
    }

    public static Context getAppContext() {
        return sAppContext;
    }
}
