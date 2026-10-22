package com.bytedanceos.security.debug.settings;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.obric.securitycenter.api.settings.SettingsKey;
import dalvik.system.DexFile;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: compiled from: SettingsKeyClassScanner.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¨\u0006\n"}, d2 = {"Lcom/bytedanceos/security/debug/settings/SettingsKeyClassScanner;", "", "()V", "scan", "", "Ljava/lang/Class;", "context", "Landroid/content/Context;", "packagePrefixes", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class SettingsKeyClassScanner {
    public static final SettingsKeyClassScanner INSTANCE = null;

    static {
        INSTANCE = new SettingsKeyClassScanner();
    }

    private SettingsKeyClassScanner() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List scan$default(SettingsKeyClassScanner r0, Context r1, List r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = CollectionsKt.listOf(new String[]{"com.obric.", "com.bytedanceos."});
    L6:
        return r0.scan(r1, r2);
    }

    public final List<Class<?>> scan(Context r18, List<String> r19) {
        Intrinsics.checkNotNullParameter(r18, "context");
        Intrinsics.checkNotNullParameter(r19, "packagePrefixes");
        ApplicationInfo r1 = r18.getApplicationInfo();
        ArrayList r3 = new ArrayList(2);
        r3.add(r1.sourceDir);
        String[] r2 = r1.splitSourceDirs;
        if (r2 == null) goto L5;
        Intrinsics.checkNotNullExpressionValue(r2, "it");
        CollectionsKt.addAll(r3, r2);
    L5:
        ArrayList r4 = new ArrayList(64);
        Iterator r5 = r3.iterator();
    L7:
        if (r5.hasNext() == false) goto L38;
        String r6 = (String) r5.next();
        if (r6 != null) goto L12;
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L46
    L12:
        Enumeration<String> r7 = new DexFile(r6).entries();
    L14:
        if (r7.hasMoreElements() == false) goto L7;
        String r8 = r7.nextElement();
        boolean r9 = true;
        if ((!r19.isEmpty()) == false) goto L30;
        List<String> r10 = r19;
        if ((r10 instanceof Collection) == true) goto L20;
    L22:
        Iterator<T> r11 = r10.iterator();
    L24:
        if (r11.hasNext() == false) goto L28;
        String r12 = (String) r11.next();
        Intrinsics.checkNotNullExpressionValue(r8, "className");
        if (StringsKt.startsWith$default(r8, r12, false, 2, null) == false) goto L24;
        r9 = false;
    L28:
        if (r9 == false) goto L30;
    L20:
        if (r10.isEmpty() == false) goto L22;
    L30:
        Intrinsics.checkNotNullExpressionValue(r8, "className");
        if (StringsKt.indexOf$default(r8, Typography.dollar, 0, false, 6, null) >= 0) goto L14;
        Class<?> r13 = Class.forName(r8, false, r18.getClassLoader());     // Catch: Throwable -> L47
        if (r13.getAnnotation(SettingsKey.class) == null) goto L14;
        r4.add(r13);
        goto L14
    L38:
        HashSet r0 = new HashSet();
        ArrayList r14 = new ArrayList();
        Iterator r15 = r4.iterator();
    L40:
        if (r15.hasNext() == false) goto L45;
        Object r16 = r15.next();
        if (r0.add(((Class) r16).getName()) == false) goto L40;
        r14.add(r16);
        goto L40
    L45:
        return r14;
    }
}
