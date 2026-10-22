package com.obric.security.battertpower.powerHigh;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.obric.securitycenter.api.settings.SettingsUtils;
import com.obric.taskmanager.TaskWithCallback;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HighPowerWhitelistTask.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\u0002H\u0016R\u0016\u0010\u0006\u001a\n \u0007*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/security/battertpower/powerHigh/HighPowerWhitelistTask;", "Lcom/obric/taskmanager/TaskWithCallback;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "appContext", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class HighPowerWhitelistTask extends TaskWithCallback<String> {
    private final Context appContext;

    public HighPowerWhitelistTask(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.appContext = r2.getApplicationContext();
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }

    @Override // java.util.concurrent.Callable
    public String call() {
        SettingsUtils r0 = SettingsUtils.INSTANCE;
        Context r8 = this.appContext;
        Intrinsics.checkNotNullExpressionValue(r8, "appContext");
        r0.initSettingsConfig(r8);
        if (HighPowerAppManager.Companion.isNeedInit() == true) goto L5;
        return "";
    L5:
        HashSet<String> r9 = HighPowerAppManager.Companion.getAllowBgPowerList();
        HashSet<String> r1 = HighPowerAppManager.Companion.getManualPackageSet();
        if (HighPowerAppManager.Companion.hasLastWhitelist() == false) goto L19;
        HashSet<String> r2 = HighPowerAppManager.Companion.getLastWhitelist();
        HashSet r3 = new HashSet(r9);
        ArrayList r4 = new ArrayList();
        Iterator r5 = r3.iterator();
    L9:
        if (r5.hasNext() == false) goto L18;
        Object r6 = r5.next();
        String r7 = (String) r6;
        if (r1.contains(r7) == false) goto L13;
    L15:
        boolean r10 = false;
    L16:
        if (r10 == false) goto L9;
        r4.add(r6);
        goto L9
    L13:
        if (r2.contains(r7) == false) goto L15;
        r10 = true;
        goto L16
    L18:
        r9.removeAll(r4);
    L19:
        Iterator<T> r11 = HighPowerAppManager.Companion.getWhiteList().iterator();
    L21:
        if (r11.hasNext() == false) goto L25;
        String r12 = (String) r11.next();
        if (r1.contains(r12) == true) goto L21;
        r9.add(r12);
        goto L21
    L25:
        HighPowerAppManager.Companion.updateAllowBgPowerList(r9);
        HighPowerAppManager.Companion.init();
        return "";
    }
}
