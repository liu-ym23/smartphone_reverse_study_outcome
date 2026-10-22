package com.obric.security;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.UserInfo;
import android.os.UserHandle;
import android.os.UserManager;
import com.obric.olog.OLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SettingsInitialize.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lcom/obric/security/SettingsInitialize;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class SettingsInitialize extends BroadcastReceiver {
    public static final Companion Companion = null;
    private static final List<String> PRIMARY_CONTROLS = null;
    private static final String TAG = "Settings";

    /* JADX INFO: compiled from: SettingsInitialize.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/security/SettingsInitialize$Companion;", "", "()V", "PRIMARY_CONTROLS", "", "", "TAG", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    public SettingsInitialize() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r8, Intent r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "intent");
        Object r7 = r8.getSystemService("user");
        if (r7 == null) goto L18;
        UserInfo r10 = ((UserManager) r7).getUserInfo(UserHandle.myUserId());
        if (r10 != null) goto L7;
        return;
    L7:
        if (r10.isManagedProfile() != true) goto L21;
        OLog.i(TAG, "Received broadcast: " + r9.getAction() + ", add cross profile filters");
        PackageManager r11 = r8.getPackageManager();
        Iterator<T> r12 = PRIMARY_CONTROLS.iterator();
    L11:
        if (r12.hasNext() == false) goto L22;
        Intent r2 = new Intent((String) r12.next());
        r2.addCategory("android.intent.category.DEFAULT");
        List<ResolveInfo> r1 = r11.queryIntentActivities(r2, 193);
        Intrinsics.checkNotNullExpressionValue(r1, "pm.queryIntentActivities(redeliverIntent, flag)");
        Iterator<T> r3 = r1.iterator();
    L14:
        if (r3.hasNext() == false) goto L11;
        ResolveInfo r4 = (ResolveInfo) r3.next();
        r11.addCrossProfileIntentFilter(r4.filter, r10.id, r10.profileGroupId, 2);
        OLog.d(TAG, "add cross profile filter, " + r10 + ", " + r4.activityInfo);
        goto L14
    L22:
        return;
    L21:
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.os.UserManager");
    }

    static {
        Companion = new Companion(null);
        PRIMARY_CONTROLS = CollectionsKt.listOf(new String[]{"android.settings.INTERNAL_STORAGE_SETTINGS", "android.settings.BATTERY_SAVER_SETTINGS"});
    }
}
