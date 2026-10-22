package com.android.settings.teaevent;

import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import com.android.settingslib.accessibility.AccessibilityUtils;
import com.bytedance.apm.constant.PerfConsts;
import com.obric.olog.OLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProvisionTeaEvent.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u000e\u001a\u00020\u000f2$\b\u0002\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0011j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001`\u0012H\u0007J>\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042$\b\u0002\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0011j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001`\u0012H\u0007J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u001a\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u0004H\u0007J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\"\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0007J\u0018\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001dH\u0003J\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u001a\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u0004H\u0007J*\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u001f\u001a\u00020\u001dH\u0007J$\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u00042\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\fH\u0002J\u0018\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010#\u001a\u00020$H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/android/settings/teaevent/ProvisionTeaEvent;", "", "()V", "KEY_CURRENT_PAGE", "", "KEY_ENTER_TIMESTAMP", "KEY_OVERRIDE_ENTER", "KEY_OVERRIDE_ENTER_PRE_PAGE", "KEY_PREVIOUS_PAGE", "PREFIX", "TAG", "mEnterPage", "", "mInEnterPage", "bootSetupComplete", "", "params", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "click", PerfConsts.KEY_CURRENT_GALVANIC, "type", "enterPage", "intent", "Landroid/content/Intent;", "previous", "getPageName", "getPrePageName", "leavePage", "", "overrideOutEnterPage", "overrideEnter", "uploadEvent", "eventName", "uploadSimCardSlot", "simSlot", "", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ProvisionTeaEvent {
    public static final ProvisionTeaEvent INSTANCE = null;
    public static final String KEY_CURRENT_PAGE = "event_current_page";
    private static final String KEY_ENTER_TIMESTAMP = "event_enter_timestamp";
    private static final String KEY_OVERRIDE_ENTER = "event_override_enter";
    private static final String KEY_OVERRIDE_ENTER_PRE_PAGE = "event_override_enter_pre_page";
    public static final String KEY_PREVIOUS_PAGE = "event_previous_page";
    private static final String PREFIX = "provision_";
    private static final String TAG = "UploadTeaEvent";
    private static Map<String, ? extends Object> mEnterPage;
    private static Map<String, ? extends Object> mInEnterPage;

    static {
        INSTANCE = new ProvisionTeaEvent();
    }

    @JvmStatic
    public static final void click(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, PerfConsts.KEY_CURRENT_GALVANIC);
        Intrinsics.checkNotNullParameter(r3, "type");
        click$default(r2, r3, null, 4, null);
    }

    @JvmStatic
    public static final void enterPage(String r2) {
        Intrinsics.checkNotNullParameter(r2, PerfConsts.KEY_CURRENT_GALVANIC);
        enterPage$default(r2, null, 2, null);
    }

    @JvmStatic
    public static final String getPrePageName(Intent r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        Intrinsics.checkNotNullParameter(r4, PerfConsts.KEY_CURRENT_GALVANIC);
        return getPrePageName$default(r3, r4, false, 4, null);
    }

    @JvmStatic
    public static final void leavePage(String r2) {
        Intrinsics.checkNotNullParameter(r2, PerfConsts.KEY_CURRENT_GALVANIC);
        leavePage$default(r2, null, 2, null);
    }

    @JvmStatic
    public static final void overrideOutEnterPage(String r7, String r8, Intent r9) {
        Intrinsics.checkNotNullParameter(r7, PerfConsts.KEY_CURRENT_GALVANIC);
        Intrinsics.checkNotNullParameter(r8, "previous");
        Intrinsics.checkNotNullParameter(r9, "intent");
        overrideOutEnterPage$default(r7, r8, r9, false, 8, null);
    }

    private ProvisionTeaEvent() {
    }

    public static /* synthetic */ void enterPage$default(String r0, String r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = "";
    L5:
        enterPage(r0, r1);
    }

    @JvmStatic
    public static final void enterPage(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, PerfConsts.KEY_CURRENT_GALVANIC);
        Intrinsics.checkNotNullParameter(r3, "previous");
        if (r2.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        HashMap r1 = new HashMap();
        r1.put("current_page", r2);
        r1.put("previouse_page", r3);
        INSTANCE.uploadEvent("provision_enter_page", r1);
        r1.put(KEY_ENTER_TIMESTAMP, Long.valueOf(SystemClock.uptimeMillis()));
        mEnterPage = r1;
        return;
    L5:
        r0 = false;
        goto L6
    }

    @JvmStatic
    public static final void enterPage(Intent r4) {
        Intrinsics.checkNotNullParameter(r4, "intent");
        String r0 = getPageName(r4);
        enterPage(r0, getPrePageName$default(r4, r0, false, 4, null));
    }

    public static /* synthetic */ void leavePage$default(String r0, String r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = "";
    L5:
        leavePage(r0, r1);
    }

    @JvmStatic
    public static final void leavePage(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, PerfConsts.KEY_CURRENT_GALVANIC);
        Intrinsics.checkNotNullParameter(r4, "previous");
        if (r3.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        HashMap r1 = new HashMap();
        r1.put("current_page", r3);
        r1.put("previouse_page", r4);
        Map<String, ? extends Object> r5 = mEnterPage;
        Long r6 = null;
        if (r5 == null) goto L11;
        Object r7 = r5.get(KEY_ENTER_TIMESTAMP);
    L13:
        if ((r7 instanceof Long) == false) goto L15;
        r6 = (Long) r7;
    L15:
        if (r6 == null) goto L17;
        long r8 = r6.longValue();
    L19:
        if (r8 < 0) goto L21;
        r1.put("duration", Long.valueOf(SystemClock.uptimeMillis() - r8));
    L21:
        INSTANCE.uploadEvent("provision_leave_obric_os_page", r1);
        return;
    L17:
        r8 = -1;
        goto L19
    L11:
        r7 = null;
        goto L13
    L5:
        r0 = false;
        goto L6
    }

    @JvmStatic
    public static final void leavePage(Intent r2) {
        Intrinsics.checkNotNullParameter(r2, "intent");
        String r0 = getPageName(r2);
        leavePage(r0, getPrePageName(r2, r0, true));
    }

    public static /* synthetic */ void click$default(String r0, String r1, HashMap r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L5;
        r2 = new HashMap();
    L5:
        click(r0, r1, r2);
    }

    @JvmStatic
    public static final void click(String r1, String r2, HashMap<String, Object> r3) {
        Intrinsics.checkNotNullParameter(r1, PerfConsts.KEY_CURRENT_GALVANIC);
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "params");
        if (r1.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        HashMap<String, Object> r4 = r3;
        r4.put("current_page", r1);
        r4.put("button_type", r2);
        INSTANCE.uploadEvent("provision_obric_page_click", r4);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static /* synthetic */ void bootSetupComplete$default(HashMap r0, int r1, Object r2) {
        if ((r1 & 1) == 0) goto L5;
        r0 = new HashMap();
    L5:
        bootSetupComplete(r0);
    }

    @JvmStatic
    public static final void bootSetupComplete(HashMap<String, Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        INSTANCE.uploadEvent("provision_obric_onboarding_complete", r2);
    }

    @JvmStatic
    public static final void uploadSimCardSlot(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, PerfConsts.KEY_CURRENT_GALVANIC);
        HashMap r0 = new HashMap();
        HashMap r1 = r0;
        r1.put("sim_cnt", Integer.valueOf(r3));
        r1.put("current_page", r2);
        INSTANCE.uploadEvent("provision_os_sim_status", r1);
    }

    private final void uploadEvent(String r1, Map<String, ? extends Object> r2) {
        TeaEventReportUtil.INSTANCE.report(r1, r2);
        OLog.d(TAG, r1 + AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR + r2);
    }

    @JvmStatic
    private static final String getPrePageName(String r10, boolean r11) {
        Map<String, ? extends Object> r0 = mEnterPage;
        String r1 = null;
        if (r0 == null) goto L5;
        Object r2 = r0.get("current_page");
    L7:
        if ((r2 instanceof String) == false) goto L9;
        String r3 = (String) r2;
    L11:
        if (r3 != null) goto L13;
        r3 = "";
    L13:
        Map<String, ? extends Object> r4 = mEnterPage;
        if (r4 == null) goto L16;
        Object r5 = r4.get(KEY_OVERRIDE_ENTER);
    L18:
        if ((r5 instanceof Boolean) == false) goto L20;
        Boolean r6 = (Boolean) r5;
    L21:
        boolean r7 = false;
        if (r6 == null) goto L24;
        boolean r8 = r6.booleanValue();
    L25:
        Map<String, ? extends Object> r9 = mEnterPage;
        if (r9 == null) goto L28;
        Object r12 = r9.get("previouse_page");
    L30:
        if ((r12 instanceof String) == false) goto L32;
        String r13 = (String) r12;
    L33:
        if (r13 != null) goto L35;
        r13 = "";
    L35:
        String r14 = r3;
        if (r14.length() <= 0) goto L38;
        boolean r15 = true;
    L39:
        if (r15 == false) goto L54;
        if (Intrinsics.areEqual(r10, r3) == false) goto L54;
        Map<String, ? extends Object> r16 = mEnterPage;
        if (r16 == null) goto L45;
        Object r17 = r16.get("previouse_page");
    L47:
        if ((r17 instanceof String) == false) goto L49;
        r1 = (String) r17;
    L49:
        if (r1 != null) goto L52;
        return "";
    L52:
        return r1;
    L45:
        r17 = null;
    L54:
        if (r14.length() <= 0) goto L56;
        r7 = true;
    L56:
        if (r7 == true) goto L58;
    L72:
        return r3;
    L58:
        if (Intrinsics.areEqual(r10, r13) == false) goto L72;
        if (r8 == false) goto L72;
        if (r11 == false) goto L72;
        Map<String, ? extends Object> r18 = mEnterPage;
        if (r18 == null) goto L64;
        Object r19 = r18.get(KEY_OVERRIDE_ENTER_PRE_PAGE);
    L66:
        if ((r19 instanceof String) == false) goto L68;
        r1 = (String) r19;
    L68:
        if (r1 != null) goto L71;
        return "";
    L71:
        return r1;
    L64:
        r19 = null;
        goto L66
    L38:
        r15 = false;
        goto L39
    L32:
        r13 = null;
        goto L33
    L28:
        r12 = null;
        goto L30
    L24:
        r8 = false;
        goto L25
    L20:
        r6 = null;
        goto L21
    L16:
        r5 = null;
        goto L18
    L9:
        r3 = null;
        goto L11
    L5:
        r2 = null;
        goto L7
    }

    public static /* synthetic */ String getPrePageName$default(Intent r0, String r1, boolean r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L6;
        r2 = false;
    L6:
        return getPrePageName(r0, r1, r2);
    }

    @JvmStatic
    public static final String getPrePageName(Intent r5, String r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r5, "intent");
        Intrinsics.checkNotNullParameter(r6, PerfConsts.KEY_CURRENT_GALVANIC);
        String r8 = getPrePageName(r6, r7);
        String r1 = r5.getStringExtra(KEY_PREVIOUS_PAGE);
        boolean r3 = false;
        boolean r2 = r5.getBooleanExtra(KEY_OVERRIDE_ENTER, false);
        String r4 = r1;
        if (r4 != null) goto L5;
    L6:
        r3 = true;
    L8:
        if (r3 == true) goto L14;
        if (r2 == false) goto L14;
        if (r7 == true) goto L14;
        OLog.d(TAG, "getPrePageName(5):" + r8);
        return r1;
    L14:
        if (TextUtils.isEmpty(r8) == true) goto L17;
        OLog.d(TAG, "getPrePageName(1):" + r8);
        Intrinsics.checkNotNull(r8);
        return r8;
    L17:
        String r9 = r5.getStringExtra(KEY_PREVIOUS_PAGE);
        if (TextUtils.isEmpty(r9) == true) goto L21;
        OLog.d(TAG, "getPrePageName(2):" + r9);
        Intrinsics.checkNotNull(r9);
        return r9;
    L21:
        OLog.d(TAG, "getPrePageName(3)");
        return "";
    L5:
        if (r4.length() != 0) goto L8;
        goto L6
    }

    @JvmStatic
    public static final String getPageName(Intent r3) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r4 = r3.getStringExtra(KEY_CURRENT_PAGE);
        if (TextUtils.isEmpty(r4) == true) goto L6;
        OLog.d(TAG, "getPageName(1):" + r4);
        Intrinsics.checkNotNull(r4);
        return r4;
    L6:
        OLog.d(TAG, "getPageName(2)");
        return "";
    }

    public static /* synthetic */ void overrideOutEnterPage$default(String r0, String r1, Intent r2, boolean r3, int r4, Object r5) {
        if ((r4 & 8) == 0) goto L5;
        r3 = true;
    L5:
        overrideOutEnterPage(r0, r1, r2, r3);
    }

    @JvmStatic
    public static final void overrideOutEnterPage(String r10, String r11, Intent r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, PerfConsts.KEY_CURRENT_GALVANIC);
        Intrinsics.checkNotNullParameter(r11, "previous");
        Intrinsics.checkNotNullParameter(r12, "intent");
        boolean r1 = true;
        if (r10.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return;
    L8:
        if (r11.length() > 0) goto L11;
        r1 = false;
    L11:
        if (r1 == false) goto L38;
        Map<String, ? extends Object> r2 = mEnterPage;
        Long r3 = null;
        if (r2 == null) goto L15;
        Object r4 = r2.get("previouse_page");
    L17:
        if ((r4 instanceof String) == false) goto L19;
        String r5 = (String) r4;
    L20:
        if (r5 != null) goto L22;
        r5 = "";
    L22:
        HashMap r6 = new HashMap();
        HashMap r7 = r6;
        r7.put("current_page", r10);
        r7.put("previouse_page", r11);
        r7.put(KEY_OVERRIDE_ENTER, Boolean.valueOf(r13));
        r7.put(KEY_OVERRIDE_ENTER_PRE_PAGE, r5);
        if (r13 == false) goto L35;
        Map<String, ? extends Object> r8 = mEnterPage;
        if (r8 == null) goto L27;
        Object r9 = r8.get(KEY_ENTER_TIMESTAMP);
    L29:
        if ((r9 instanceof Long) == false) goto L31;
        r3 = (Long) r9;
    L31:
        if (r3 == null) goto L33;
        long r14 = r3.longValue();
    L34:
        r7.put(KEY_ENTER_TIMESTAMP, Long.valueOf(r14));
        mEnterPage = r7;
        goto L35
    L33:
        r14 = -1;
        goto L34
    L27:
        r9 = null;
    L35:
        r12.putExtra(KEY_PREVIOUS_PAGE, r11);
        r12.putExtra(KEY_CURRENT_PAGE, r10);
        r12.putExtra(KEY_OVERRIDE_ENTER, r13);
        r12.putExtra(KEY_OVERRIDE_ENTER_PRE_PAGE, r5);
        OLog.d(TAG, "overrideEnterPage:" + r6);
        return;
    L19:
        r5 = null;
        goto L20
    L15:
        r4 = null;
        goto L17
    L38:
        return;
    L5:
        r0 = false;
        goto L6
    }
}
