package com.android.settings.servicemanager;

import android.content.Intent;
import com.bytedance.news.common.service.manager.IService;
import kotlin.Metadata;

/* JADX INFO: compiled from: ISettingsFeatureService.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/android/settings/servicemanager/ISettingsFeatureService;", "Lcom/bytedance/news/common/service/manager/IService;", "isGoogleSettingsItemVisible", "", "isWifiFailAuth", "intent", "Landroid/content/Intent;", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface ISettingsFeatureService extends IService {

    /* JADX INFO: compiled from: ISettingsFeatureService.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean isGoogleSettingsItemVisible(ISettingsFeatureService r0) {
            return true;
        }
    }

    boolean isGoogleSettingsItemVisible();

    boolean isWifiFailAuth(Intent r1);
}
