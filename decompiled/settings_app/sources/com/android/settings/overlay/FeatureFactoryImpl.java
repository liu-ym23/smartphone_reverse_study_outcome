package com.android.settings.overlay;

import android.content.Context;
import com.android.settings.applications.ApplicationFeatureProvider;
import com.android.settings.applications.ApplicationFeatureProviderImpl;
import com.android.settings.dashboard.DashboardFeatureProvider;
import com.android.settings.dashboard.DashboardFeatureProviderImpl;
import com.android.settings.enterprise.EnterprisePrivacyFeatureProvider;
import com.android.settings.enterprise.EnterprisePrivacyFeatureProviderImpl;
import com.android.settings.slices.SlicesFeatureProvider;
import com.android.settings.slices.SlicesFeatureProviderImpl;
import com.android.settings.users.UserFeatureProvider;
import com.android.settings.users.UserFeatureProviderImpl;
import com.android.settings.wifi.WifiTrackerLibProvider;
import com.android.settingslib.core.instrumentation.MetricsFeatureProvider;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FeatureFactoryImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00198VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\b\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u001e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\b\u001a\u0004\b\u001f\u0010 R\u001b\u0010\"\u001a\u00020#8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\b\u001a\u0004\b$\u0010%¨\u0006+"}, d2 = {"Lcom/android/settings/overlay/FeatureFactoryImpl;", "Lcom/android/settings/overlay/FeatureFactory;", "()V", "applicationFeatureProvider", "Lcom/android/settings/applications/ApplicationFeatureProviderImpl;", "getApplicationFeatureProvider", "()Lcom/android/settings/applications/ApplicationFeatureProviderImpl;", "applicationFeatureProvider$delegate", "Lkotlin/Lazy;", "dashboardFeatureProvider", "Lcom/android/settings/dashboard/DashboardFeatureProviderImpl;", "getDashboardFeatureProvider", "()Lcom/android/settings/dashboard/DashboardFeatureProviderImpl;", "dashboardFeatureProvider$delegate", "enterprisePrivacyFeatureProvider", "Lcom/android/settings/enterprise/EnterprisePrivacyFeatureProviderImpl;", "getEnterprisePrivacyFeatureProvider", "()Lcom/android/settings/enterprise/EnterprisePrivacyFeatureProviderImpl;", "enterprisePrivacyFeatureProvider$delegate", "metricsFeatureProvider", "Lcom/android/settingslib/core/instrumentation/MetricsFeatureProvider;", "getMetricsFeatureProvider", "()Lcom/android/settingslib/core/instrumentation/MetricsFeatureProvider;", "metricsFeatureProvider$delegate", "slicesFeatureProvider", "Lcom/android/settings/slices/SlicesFeatureProviderImpl;", "getSlicesFeatureProvider", "()Lcom/android/settings/slices/SlicesFeatureProviderImpl;", "slicesFeatureProvider$delegate", "userFeatureProvider", "Lcom/android/settings/users/UserFeatureProviderImpl;", "getUserFeatureProvider", "()Lcom/android/settings/users/UserFeatureProviderImpl;", "userFeatureProvider$delegate", "wifiTrackerLibProvider", "Lcom/android/settings/wifi/WifiTrackerLibProvider;", "getWifiTrackerLibProvider", "()Lcom/android/settings/wifi/WifiTrackerLibProvider;", "wifiTrackerLibProvider$delegate", "getSurveyFeatureProvider", "Lcom/android/settings/overlay/SurveyFeatureProvider;", "context", "Landroid/content/Context;", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class FeatureFactoryImpl extends FeatureFactory {
    private final Lazy applicationFeatureProvider$delegate;
    private final Lazy dashboardFeatureProvider$delegate;
    private final Lazy enterprisePrivacyFeatureProvider$delegate;
    private final Lazy metricsFeatureProvider$delegate;
    private final Lazy slicesFeatureProvider$delegate;
    private final Lazy userFeatureProvider$delegate;
    private final Lazy wifiTrackerLibProvider$delegate;

    @Override // com.android.settings.overlay.FeatureFactory
    public SurveyFeatureProvider getSurveyFeatureProvider(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return null;
    }

    public FeatureFactoryImpl() {
        this.dashboardFeatureProvider$delegate = LazyKt.lazy(FeatureFactoryImpl$dashboardFeatureProvider$2.INSTANCE);
        this.slicesFeatureProvider$delegate = LazyKt.lazy(FeatureFactoryImpl$slicesFeatureProvider$2.INSTANCE);
        this.wifiTrackerLibProvider$delegate = LazyKt.lazy(FeatureFactoryImpl$wifiTrackerLibProvider$2.INSTANCE);
        this.metricsFeatureProvider$delegate = LazyKt.lazy(FeatureFactoryImpl$metricsFeatureProvider$2.INSTANCE);
        this.enterprisePrivacyFeatureProvider$delegate = LazyKt.lazy(FeatureFactoryImpl$enterprisePrivacyFeatureProvider$2.INSTANCE);
        this.applicationFeatureProvider$delegate = LazyKt.lazy(FeatureFactoryImpl$applicationFeatureProvider$2.INSTANCE);
        this.userFeatureProvider$delegate = LazyKt.lazy(FeatureFactoryImpl$userFeatureProvider$2.INSTANCE);
    }

    @Override // com.android.settings.overlay.FeatureFactory
    public /* bridge */ /* synthetic */ ApplicationFeatureProvider getApplicationFeatureProvider() {
        return getApplicationFeatureProvider();
    }

    @Override // com.android.settings.overlay.FeatureFactory
    public /* bridge */ /* synthetic */ DashboardFeatureProvider getDashboardFeatureProvider() {
        return getDashboardFeatureProvider();
    }

    @Override // com.android.settings.overlay.FeatureFactory
    public /* bridge */ /* synthetic */ EnterprisePrivacyFeatureProvider getEnterprisePrivacyFeatureProvider() {
        return getEnterprisePrivacyFeatureProvider();
    }

    @Override // com.android.settings.overlay.FeatureFactory
    public /* bridge */ /* synthetic */ SlicesFeatureProvider getSlicesFeatureProvider() {
        return getSlicesFeatureProvider();
    }

    @Override // com.android.settings.overlay.FeatureFactory
    public /* bridge */ /* synthetic */ UserFeatureProvider getUserFeatureProvider() {
        return getUserFeatureProvider();
    }

    @Override // com.android.settings.overlay.FeatureFactory
    public DashboardFeatureProviderImpl getDashboardFeatureProvider() {
        return (DashboardFeatureProviderImpl) this.dashboardFeatureProvider$delegate.getValue();
    }

    @Override // com.android.settings.overlay.FeatureFactory
    public SlicesFeatureProviderImpl getSlicesFeatureProvider() {
        return (SlicesFeatureProviderImpl) this.slicesFeatureProvider$delegate.getValue();
    }

    @Override // com.android.settings.overlay.FeatureFactory
    public WifiTrackerLibProvider getWifiTrackerLibProvider() {
        return (WifiTrackerLibProvider) this.wifiTrackerLibProvider$delegate.getValue();
    }

    @Override // com.android.settings.overlay.FeatureFactory
    public MetricsFeatureProvider getMetricsFeatureProvider() {
        return (MetricsFeatureProvider) this.metricsFeatureProvider$delegate.getValue();
    }

    @Override // com.android.settings.overlay.FeatureFactory
    public EnterprisePrivacyFeatureProviderImpl getEnterprisePrivacyFeatureProvider() {
        return (EnterprisePrivacyFeatureProviderImpl) this.enterprisePrivacyFeatureProvider$delegate.getValue();
    }

    @Override // com.android.settings.overlay.FeatureFactory
    public ApplicationFeatureProviderImpl getApplicationFeatureProvider() {
        return (ApplicationFeatureProviderImpl) this.applicationFeatureProvider$delegate.getValue();
    }

    @Override // com.android.settings.overlay.FeatureFactory
    public UserFeatureProviderImpl getUserFeatureProvider() {
        return (UserFeatureProviderImpl) this.userFeatureProvider$delegate.getValue();
    }
}
