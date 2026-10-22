package com.android.settings.serviceapi;

import android.content.Context;
import com.bytedance.news.common.service.manager.IService;
import kotlin.Metadata;

/* JADX INFO: compiled from: IFingerprintService.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/android/settings/serviceapi/IFingerprintService;", "Lcom/bytedance/news/common/service/manager/IService;", "getFingerprintEnrollAreaBottomMargin", "", "context", "Landroid/content/Context;", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface IFingerprintService extends IService {
    float getFingerprintEnrollAreaBottomMargin(Context r1);
}
