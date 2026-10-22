package com.bytedanceos.securitycenter.scan;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SharedPrefsScanSettingsRepository.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0016\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedanceos/securitycenter/scan/SharedPrefsScanSettingsRepository;", "Lcom/bytedanceos/securitycenter/scan/ScanSettingsRepository;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "appContext", "kotlin.jvm.PlatformType", "isCloudScanEnabled", "", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class SharedPrefsScanSettingsRepository implements ScanSettingsRepository {
    public static final Companion Companion = null;
    private static final boolean DEFAULT_CLOUD_DETECTION = true;
    private static final String KEY_CLOUD_DETECTION = "cloud_detection";
    private static final String PREFS_NAME = "safe_check_settings";
    private final Context appContext;

    /* JADX INFO: compiled from: SharedPrefsScanSettingsRepository.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedanceos/securitycenter/scan/SharedPrefsScanSettingsRepository$Companion;", "", "()V", "DEFAULT_CLOUD_DETECTION", "", "KEY_CLOUD_DETECTION", "", "PREFS_NAME", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public SharedPrefsScanSettingsRepository(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.appContext = r2.getApplicationContext();
    }

    @Override // com.bytedanceos.securitycenter.scan.ScanSettingsRepository
    public boolean isCloudScanEnabled() {
        return this.appContext.getSharedPreferences(PREFS_NAME, 0).getBoolean(KEY_CLOUD_DETECTION, true);
    }
}
