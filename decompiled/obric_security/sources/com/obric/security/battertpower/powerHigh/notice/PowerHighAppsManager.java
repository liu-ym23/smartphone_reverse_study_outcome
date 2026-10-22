package com.obric.security.battertpower.powerHigh.notice;

import android.app.ActivityManager;
import android.content.Context;
import com.bytedanceos.securitycenter.SecurityCenterApplication;
import com.bytedanceos.securitycenter.SharedPreferUtil;
import com.google.gson.Gson;
import com.obric.olog.OLog;
import com.obric.security.battertpower.powerHigh.HighPowerAppManager;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PowerHighAppsManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J6\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001c2\u0006\u0010\u0017\u001a\u00020\u00182\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001cJ@\u0010\u001e\u001a4\u0012\u0004\u0012\u00020 \u0012\n\u0012\b\u0012\u0004\u0012\u00020 0!0\u001fj\u001e\u0012\u0004\u0012\u00020 \u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020 0!j\b\u0012\u0004\u0012\u00020 `#`\"2\u0006\u0010\u0017\u001a\u00020\u0018J\u001e\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001c2\u0006\u0010\u0017\u001a\u00020\u0018J>\u0010%\u001a\u00020\n2\u001a\u0010&\u001a\u0016\u0012\u0004\u0012\u00020 \u0018\u00010!j\n\u0012\u0004\u0012\u00020 \u0018\u0001`#2\u001a\u0010'\u001a\u0016\u0012\u0004\u0012\u00020 \u0018\u00010!j\n\u0012\u0004\u0012\u00020 \u0018\u0001`#JF\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001c2\u0016\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001c2\u0016\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001cJ\u0006\u0010+\u001a\u00020\u0016J6\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001c2\u0006\u0010\u0017\u001a\u00020\u00182\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001cJ\u0006\u0010-\u001a\u00020\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006."}, d2 = {"Lcom/obric/security/battertpower/powerHigh/notice/PowerHighAppsManager;", "", "()V", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "setGson", "(Lcom/google/gson/Gson;)V", "isregisterUidListener", "", "getIsregisterUidListener", "()Z", "setIsregisterUidListener", "(Z)V", "uidListener", "Landroid/app/ActivityManager$OnUidImportanceListener;", "getUidListener", "()Landroid/app/ActivityManager$OnUidImportanceListener;", "setUidListener", "(Landroid/app/ActivityManager$OnUidImportanceListener;)V", "clearLocalPowerHighApps", "", "context", "Landroid/content/Context;", "filterDeadProcesses", "Ljava/util/ArrayList;", "Lcom/obric/security/battertpower/powerHigh/notice/PowerHighApp;", "Lkotlin/collections/ArrayList;", "powerHighApps", "getAllProcessRunning", "Ljava/util/HashMap;", "", "Ljava/util/HashSet;", "Lkotlin/collections/HashMap;", "Lkotlin/collections/HashSet;", "getLocalPowerHighApps", "hasOverlap", "set1", "set2", "mergeAndRemoveDuplicates", "list1", "list2", "registerUidListener", "savePowerHighApps", "unregisterUidListener", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class PowerHighAppsManager {
    public static final PowerHighAppsManager INSTANCE = null;
    private static Gson gson;
    private static boolean isregisterUidListener;
    private static ActivityManager.OnUidImportanceListener uidListener;

    static {
        INSTANCE = new PowerHighAppsManager();
        uidListener = new PowerHighAppsManager$uidListener$1();
    }

    private PowerHighAppsManager() {
    }

    public final boolean getIsregisterUidListener() {
        return isregisterUidListener;
    }

    public final void setIsregisterUidListener(boolean r1) {
        isregisterUidListener = r1;
    }

    public final Gson getGson() {
        return gson;
    }

    public final void setGson(Gson r1) {
        gson = r1;
    }

    public final ArrayList<PowerHighApp> savePowerHighApps(Context r3, ArrayList<PowerHighApp> r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "powerHighApps");
        if (gson != null) goto L5;
        gson = new Gson();
    L5:
        Gson r2 = gson;
        if (r2 == null) goto L8;
        String r5 = r2.toJson(r4);
    L9:
        SharedPreferUtil.commitAsynchronously(r3.getSharedPreferences(PowerHighWarningReceiver.PREF_FILE, 0).edit().putString(PowerHighWarningReceiver.LOCAL_POWER_HIGH_APPS, r5));
        return r4;
    L8:
        r5 = null;
        goto L9
    }

    public final void clearLocalPowerHighApps(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        SharedPreferUtil.commitAsynchronously(r2.getSharedPreferences(PowerHighWarningReceiver.PREF_FILE, 0).edit().putString(PowerHighWarningReceiver.LOCAL_POWER_HIGH_APPS, ""));
    }

    public final ArrayList<PowerHighApp> mergeAndRemoveDuplicates(ArrayList<PowerHighApp> r5, ArrayList<PowerHighApp> r6) {
        Intrinsics.checkNotNullParameter(r5, "list1");
        Intrinsics.checkNotNullParameter(r6, "list2");
        ArrayList<PowerHighApp> r4 = new ArrayList();
        HashSet<String> r0 = HighPowerAppManager.Companion.getAllowBgPowerList();
        Iterator<PowerHighApp> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L8;
        PowerHighApp r1 = r7.next();
        if (PowerHighAppChecker.isSkip(SecurityCenterApplication.getContext(), r1.getPackageName(), r0) == true) goto L4;
        r4.add(r1);
        goto L4
    L8:
        HashSet r8 = new HashSet();
        Iterator<PowerHighApp> r2 = r4.iterator();
    L10:
        if (r2.hasNext() == false) goto L12;
        r8.add(r2.next().getPackageName());
        goto L10
    L12:
        Iterator<PowerHighApp> r9 = r5.iterator();
    L14:
        if (r9.hasNext() == false) goto L20;
        PowerHighApp r3 = r9.next();
        if (r8.contains(r3.getPackageName()) == true) goto L14;
        if (PowerHighAppChecker.isSkip(SecurityCenterApplication.getContext(), r3.getPackageName(), r0) == true) goto L14;
        r4.add(r3);
        goto L14
    L20:
        return r4;
    }

    public final ArrayList<PowerHighApp> getLocalPowerHighApps(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        OLog.i("PowerHighAppsManager", "get local power high apps start");
        Type r3 = new PowerHighAppsManager$getLocalPowerHighApps$type$1().getType();
        String r5 = r4.getSharedPreferences(PowerHighWarningReceiver.PREF_FILE, 0).getString(PowerHighWarningReceiver.LOCAL_POWER_HIGH_APPS, "");
        if (gson != null) goto L5;
        gson = new Gson();
    L5:
        Gson r1 = gson;
        if (r1 == null) goto L8;
        ArrayList<PowerHighApp> r6 = (ArrayList) r1.fromJson(r5, r3);
    L9:
        if (r6 != null) goto L11;
        r6 = new ArrayList();
    L11:
        OLog.i("PowerHighAppsManager", "get local power high apps end - list:" + r6);
        return r6;
    L8:
        r6 = null;
        goto L9
    }

    public final HashMap<Integer, HashSet<Integer>> getAllProcessRunning(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        HashMap<Integer, HashSet<Integer>> r3 = new HashMap();
        Object r5 = r4.getSystemService("activity");
        if (r5 == null) goto L19;
        Iterator<ActivityManager.RunningAppProcessInfo> r6 = ((ActivityManager) r5).getRunningAppProcesses().iterator();
    L6:
        if (r6.hasNext() == false) goto L17;
        ActivityManager.RunningAppProcessInfo r0 = r6.next();
        if ((r0.flags & 2) != 0) goto L6;
        if (r0.importance >= 400) goto L6;
        int r1 = r0.uid;
        int r2 = r0.pid;
        HashSet<Integer> r7 = r3.get(Integer.valueOf(r0.uid));
        if (r7 != null) goto L16;
        r7 = new HashSet();
        r3.put(Integer.valueOf(r0.uid), r7);
    L16:
        r7.add(Integer.valueOf(r0.pid));
        goto L6
    L17:
        return r3;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
    }

    public final ArrayList<PowerHighApp> filterDeadProcesses(Context r10, ArrayList<PowerHighApp> r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "powerHighApps");
        HashMap<Integer, HashSet<Integer>> r12 = getAllProcessRunning(r10);
        ArrayList<PowerHighApp> r0 = new ArrayList();
        Iterator<PowerHighApp> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L18;
        PowerHighApp r1 = r13.next();
        OLog.i("PowerHighAppsManager", "正在检测是否活着：" + r1.getUid() + ", pkg: " + r1.getPackageName() + ",app.pid:" + r1.getPid());
        if (r12.containsKey(Integer.valueOf(r1.getUid())) == true) goto L7;
        OLog.d("PowerHighAppsManager", "没有活着，不会展现：" + r1.getUid() + ", pkg: " + r1.getPackageName() + ",app.pid:" + r1.getPid());
        goto L4
    L7:
        HashSet<Integer> r3 = r12.get(Integer.valueOf(r1.getUid()));
        HashSet<Integer> r6 = r1.getPid();
        if (r6 == null) goto L13;
        if (r6.size() != 0) goto L13;
        r1.setPid(r3);
        r0.add(r1);
        OLog.e("PowerHighAppsManager", "发现高耗电app:" + r1.getUid() + ", pkg: " + r1.getPackageName() + ",app.pid:" + r1.getPid() + ", processId: " + r3);
    L13:
        if (hasOverlap(r1.getPid(), r3) == true) goto L14;
        OLog.d("PowerHighAppsManager", "虽然活着，但是pid变了:" + r1.getUid() + ", pkg: " + r1.getPackageName() + ",app.pid:" + r1.getPid() + ", processId: " + r3);
        goto L4
    L14:
        r0.add(r1);
        OLog.e("PowerHighAppsManager", "发现高耗电app:" + r1.getUid() + ", pkg: " + r1.getPackageName() + ",app.pid:" + r1.getPid() + ", processId: " + r3);
        goto L4
    L18:
        if (r0.size() != 0) goto L20;
        OLog.d("PowerHighAppsManager", "没有运行中的进程，进程可能kill或休眠");
    L20:
        return r0;
    }

    public final boolean hasOverlap(HashSet<Integer> r4, HashSet<Integer> r5) {
        if (r4 == null) goto L23;
        if (r5 != null) goto L7;
        return false;
    L7:
        if (r4.size() > r5.size()) goto L9;
        HashSet<Integer> r0 = r4;
    L11:
        if (r4.size() > r5.size()) goto L13;
        r4 = r5;
    L13:
        Iterator<Integer> r6 = r0.iterator();
    L15:
        if (r6.hasNext() == false) goto L25;
        if (r4.contains(r6.next()) == false) goto L15;
        return true;
    L25:
        return false;
    L9:
        r0 = r5;
        goto L11
    L23:
        return false;
    }

    public final ActivityManager.OnUidImportanceListener getUidListener() {
        return uidListener;
    }

    public final void setUidListener(ActivityManager.OnUidImportanceListener r1) {
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        uidListener = r1;
    }

    public final void registerUidListener() {
        if (isregisterUidListener == false) goto L5;
        return;
    L5:
        isregisterUidListener = true;
        OLog.d("PowerHighAppsManager", "UID: 注册监听 新重要性");     // Catch: Exception -> L11
        Object r0 = SecurityCenterApplication.getContext().getSystemService("activity");     // Catch: Exception -> L11
        if (r0 == null) goto L10;
        ((ActivityManager) r0).addOnUidImportanceListener(uidListener, 400);     // Catch: Exception -> L11
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");     // Catch: Exception -> L11
    L11:
        e = move-exception;
        OLog.e("PowerHighAppsManager", "registerUidListener error", e);
    }

    public final void unregisterUidListener() {
        if (isregisterUidListener == true) goto L5;
        return;
    L5:
        isregisterUidListener = false;
        OLog.d("PowerHighAppsManager", "UID: 注销监听 新重要性");     // Catch: Exception -> L11
        Object r0 = SecurityCenterApplication.getContext().getSystemService("activity");     // Catch: Exception -> L11
        if (r0 == null) goto L10;
        ((ActivityManager) r0).removeOnUidImportanceListener(uidListener);     // Catch: Exception -> L11
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");     // Catch: Exception -> L11
    L11:
        e = move-exception;
        OLog.e("PowerHighAppsManager", "unregisterUidListener error", e);
    }
}
