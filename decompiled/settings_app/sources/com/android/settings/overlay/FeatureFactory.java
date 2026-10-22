package com.android.settings.overlay;

import android.content.Context;
import com.android.settings.applications.ApplicationFeatureProvider;
import com.android.settings.dashboard.DashboardFeatureProvider;
import com.android.settings.enterprise.EnterprisePrivacyFeatureProvider;
import com.android.settings.slices.SlicesFeatureProvider;
import com.android.settings.users.UserFeatureProvider;
import com.android.settings.wifi.WifiTrackerLibProvider;
import com.android.settingslib.core.instrumentation.MetricsFeatureProvider;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FeatureFactory.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 #2\u00020\u0001:\u0001#B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H&R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u00020\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0017\u001a\u00020\u0018X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0012\u0010\u001b\u001a\u00020\u001cX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006$"}, d2 = {"Lcom/android/settings/overlay/FeatureFactory;", "", "()V", "applicationFeatureProvider", "Lcom/android/settings/applications/ApplicationFeatureProvider;", "getApplicationFeatureProvider", "()Lcom/android/settings/applications/ApplicationFeatureProvider;", "dashboardFeatureProvider", "Lcom/android/settings/dashboard/DashboardFeatureProvider;", "getDashboardFeatureProvider", "()Lcom/android/settings/dashboard/DashboardFeatureProvider;", "enterprisePrivacyFeatureProvider", "Lcom/android/settings/enterprise/EnterprisePrivacyFeatureProvider;", "getEnterprisePrivacyFeatureProvider", "()Lcom/android/settings/enterprise/EnterprisePrivacyFeatureProvider;", "metricsFeatureProvider", "Lcom/android/settingslib/core/instrumentation/MetricsFeatureProvider;", "getMetricsFeatureProvider", "()Lcom/android/settingslib/core/instrumentation/MetricsFeatureProvider;", "slicesFeatureProvider", "Lcom/android/settings/slices/SlicesFeatureProvider;", "getSlicesFeatureProvider", "()Lcom/android/settings/slices/SlicesFeatureProvider;", "userFeatureProvider", "Lcom/android/settings/users/UserFeatureProvider;", "getUserFeatureProvider", "()Lcom/android/settings/users/UserFeatureProvider;", "wifiTrackerLibProvider", "Lcom/android/settings/wifi/WifiTrackerLibProvider;", "getWifiTrackerLibProvider", "()Lcom/android/settings/wifi/WifiTrackerLibProvider;", "getSurveyFeatureProvider", "Lcom/android/settings/overlay/SurveyFeatureProvider;", "context", "Landroid/content/Context;", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class FeatureFactory {
    public static final Companion Companion = null;
    private static Context _appContext;
    private static FeatureFactory _factory;

    /* JADX INFO: compiled from: FeatureFactory.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0006H\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0002\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u00068FX\u0087\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/android/settings/overlay/FeatureFactory$Companion;", "", "()V", "_appContext", "Landroid/content/Context;", "_factory", "Lcom/android/settings/overlay/FeatureFactory;", "appContext", "getAppContext$annotations", "getAppContext", "()Landroid/content/Context;", "featureFactory", "getFeatureFactory$annotations", "getFeatureFactory", "()Lcom/android/settings/overlay/FeatureFactory;", "setFactory", "", "factory", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getAppContext$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getFeatureFactory$annotations() {
        }

        private Companion() {
        }

        public final FeatureFactory getFeatureFactory() {
            FeatureFactory r1 = FeatureFactory.access$get_factory$cp();
            if (r1 == null) goto L6;
            return r1;
        L6:
            throw new UnsupportedOperationException("No feature factory configured");
        }

        public final Context getAppContext() {
            Context r1 = FeatureFactory.access$get_appContext$cp();
            if (r1 == null) goto L6;
            return r1;
        L6:
            throw new UnsupportedOperationException("No feature factory configured");
        }

        @JvmStatic
        public final void setFactory(Context r1, FeatureFactory r2) {
            Intrinsics.checkNotNullParameter(r1, "appContext");
            Intrinsics.checkNotNullParameter(r2, "factory");
            FeatureFactory.access$set_appContext$cp(r1);
            FeatureFactory.access$set_factory$cp(r2);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static final Context getAppContext() {
        return Companion.getAppContext();
    }

    public static final FeatureFactory getFeatureFactory() {
        return Companion.getFeatureFactory();
    }

    @JvmStatic
    public static final void setFactory(Context r1, FeatureFactory r2) {
        Companion.setFactory(r1, r2);
    }

    public abstract ApplicationFeatureProvider getApplicationFeatureProvider();

    public abstract DashboardFeatureProvider getDashboardFeatureProvider();

    public abstract EnterprisePrivacyFeatureProvider getEnterprisePrivacyFeatureProvider();

    public abstract MetricsFeatureProvider getMetricsFeatureProvider();

    public abstract SlicesFeatureProvider getSlicesFeatureProvider();

    public abstract SurveyFeatureProvider getSurveyFeatureProvider(Context r1);

    public abstract UserFeatureProvider getUserFeatureProvider();

    public abstract WifiTrackerLibProvider getWifiTrackerLibProvider();

    public FeatureFactory() {
    }

    public static final /* synthetic */ Context access$get_appContext$cp() {
        return _appContext;
    }

    public static final /* synthetic */ FeatureFactory access$get_factory$cp() {
        return _factory;
    }

    public static final /* synthetic */ void access$set_appContext$cp(Context r0) {
        _appContext = r0;
    }

    public static final /* synthetic */ void access$set_factory$cp(FeatureFactory r0) {
        _factory = r0;
    }
}
