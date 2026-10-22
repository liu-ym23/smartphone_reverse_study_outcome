package com.obric.matrix.push_api;

import android.content.Context;
import android.content.Intent;
import com.bytedance.news.common.service.manager.IService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\bH&J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H&¨\u0006\u0017"}, d2 = {"Lcom/obric/matrix/push_api/IPush;", "Lcom/bytedance/news/common/service/manager/IService;", "init", "", "context", "Landroid/content/Context;", "initLockedWhenStart", "isLockedWhenStart", "", "registerPushClickListener", "iPushClickListener", "Lcom/obric/matrix/push_api/IPushClickListener;", "registerPushInterceptor", "iPushInterceptor", "Lcom/obric/matrix/push_api/IPushInterceptor;", "registerPushShowListener", "iPushShowListener", "Lcom/obric/matrix/push_api/IPushShowListener;", "showNotification", "notification", "Lcom/obric/matrix/push_api/Notification;", "intent", "Landroid/content/Intent;", "push_api_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IPush extends IService {
    void init(Context r1);

    void initLockedWhenStart();

    boolean isLockedWhenStart();

    void registerPushClickListener(a r1);

    void registerPushInterceptor(b r1);

    void registerPushShowListener(c r1);

    void showNotification(e r1, Intent r2);
}
