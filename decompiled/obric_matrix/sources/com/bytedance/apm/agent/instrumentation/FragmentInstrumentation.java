package com.bytedance.apm.agent.instrumentation;

import android.annotation.TargetApi;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.Keep;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.CoroutineLiveDataKt;
import com.bytedance.apm.internal.ApmDelegate;
import com.bytedance.apm.o.a.c;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class FragmentInstrumentation {
    private static final String TAG = "FragmentInstrumentation";
    private static long sCheckVisibilityStartTime;
    private static String sFragmentName;
    private static long sMaxWaitTime;
    private static HashSet<String> sMethodSet;
    private static long sOnActivityCreatedEnd;
    private static long sOnActivityCreatedStart;
    private static long sOnCreateEnd;
    private static String sOnCreateFragmentName;
    private static long sOnCreateStart;
    private static long sOnCreateTime;
    private static ViewTreeObserver.OnGlobalLayoutListener sOnGlobalLayoutListener;
    private static long sOnResumeEnd;
    private static long sOnResumeStart;
    private static long sOnViewCreatedEnd;
    private static long sOnViewCreatedStart;
    private static WeakReference<View> sRootViewRef;
    private static Runnable sWaitViewTimeoutRunnable;

    static class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Integer f1256f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f1257g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f1258h;

        a(Integer r1, long r2, String r4) {
            this.f1256f = r1;
            this.f1257g = r2;
            this.f1258h = r4;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (FragmentInstrumentation.access$000() != null) goto L5;
            return;
        L5:
            if (FragmentInstrumentation.access$000().get() == null) goto L33;
            View r0 = ((View) FragmentInstrumentation.access$000().get()).findViewById(this.f1256f.intValue());     // Catch: Exception -> L29
            if (FragmentInstrumentation.access$100() != 0) goto L10;
            FragmentInstrumentation.access$102(System.currentTimeMillis());     // Catch: Exception -> L29
        L10:
            if (r0 != null) goto L12;
            return;
        L12:
            if (r0.getVisibility() == 0) goto L14;
            return;
        L14:
            if (r0.getWidth() <= 0) goto L36;
            long r1 = System.currentTimeMillis();     // Catch: Exception -> L29
            if (((View) FragmentInstrumentation.access$000().get()).getViewTreeObserver().isAlive() == true) goto L18;
        L20:
            FragmentInstrumentation.access$202(null);     // Catch: Exception -> L29
            FragmentInstrumentation.access$002(null);     // Catch: Exception -> L29
            if (FragmentInstrumentation.access$300() == null) goto L23;
            com.bytedance.apm.f0.a.a().removeCallbacks(FragmentInstrumentation.access$300());     // Catch: Exception -> L29
        L23:
            long r2 = r1 - this.f1257g;     // Catch: Exception -> L29
            if ((r1 - FragmentInstrumentation.access$100()) > 1) goto L26;
            return;
        L26:
            if (r2 >= FragmentInstrumentation.access$400()) goto L38;
            com.bytedance.apm.o.b.a.d(FragmentInstrumentation.access$500(), this.f1258h, r2);     // Catch: Exception -> L29
            return;
        L38:
            return;
        L18:
            if (FragmentInstrumentation.access$200() == null) goto L20;
            ((View) FragmentInstrumentation.access$000().get()).getViewTreeObserver().removeOnGlobalLayoutListener(FragmentInstrumentation.access$200());     // Catch: Exception -> L29
            goto L20
        L36:
            return;
        L33:
            return;
        }
    }

    static class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (FragmentInstrumentation.access$200() != null) goto L5;
            return;
        L5:
            if (FragmentInstrumentation.access$000() != null) goto L7;
            return;
        L7:
            if (FragmentInstrumentation.access$000().get() == null) goto L15;
            ((View) FragmentInstrumentation.access$000().get()).getViewTreeObserver().removeOnGlobalLayoutListener(FragmentInstrumentation.access$200());     // Catch: Exception -> L10
            return;
        L15:
            return;
        }
    }

    static {
        sMethodSet = new HashSet(32);
    }

    public FragmentInstrumentation() {
    }

    static /* synthetic */ WeakReference access$000() {
        return sRootViewRef;
    }

    static /* synthetic */ WeakReference access$002(WeakReference r0) {
        sRootViewRef = r0;
        return r0;
    }

    static /* synthetic */ long access$100() {
        return sCheckVisibilityStartTime;
    }

    static /* synthetic */ long access$102(long r0) {
        sCheckVisibilityStartTime = r0;
        return r0;
    }

    static /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener access$200() {
        return sOnGlobalLayoutListener;
    }

    static /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener access$202(ViewTreeObserver.OnGlobalLayoutListener r0) {
        sOnGlobalLayoutListener = r0;
        return r0;
    }

    static /* synthetic */ Runnable access$300() {
        return sWaitViewTimeoutRunnable;
    }

    static /* synthetic */ long access$400() {
        return sMaxWaitTime;
    }

    static /* synthetic */ String access$500() {
        return sFragmentName;
    }

    static boolean isValid(String r1) {
        if (TextUtils.isEmpty(sFragmentName) == false) goto L5;
        return false;
    L5:
        if (TextUtils.equals(r1, sFragmentName) == false) goto L10;
        return true;
    L10:
        return false;
    }

    @Keep
    public static void onCreate(String r4) {
        sOnCreateFragmentName = r4;
        sOnCreateTime = System.currentTimeMillis();
        if (sMaxWaitTime != 0) goto L6;
        sMaxWaitTime = ApmDelegate.k().i().i();
        return;
    }

    @Keep
    public static void onHiddenChanged(Fragment r6, boolean r7) {
        c.a(r6, !r7);
        if (r7 == true) goto L9;
        String r0 = r6.getClass().getCanonicalName();     // Catch: Exception -> L6
        registerOnGlobalLayoutListener(r0, r6.getView(), com.bytedance.apm.g0.i.a.c(r0), System.currentTimeMillis(), "fragmentOnHiddenChangedToViewShow");     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    @Keep
    public static void onPause(Fragment r1) {
        if (r1.getUserVisibleHint() == true) goto L5;
        return;
    L5:
        if (r1.isHidden() == true) goto L9;
        c.a(r1, false);
        return;
    }

    @Keep
    public static void onResume(Fragment r7) {
        if (r7.getUserVisibleHint() == true) goto L5;
        return;
    L5:
        if (r7.isHidden() == true) goto L16;
        String r1 = r7.getClass().getCanonicalName();
        c.a(r7, true);     // Catch: Exception -> L12
        if (TextUtils.equals(r1, sOnCreateFragmentName) == true) goto L10;
        return;
    L10:
        Integer r3 = com.bytedance.apm.g0.i.a.c(r1);     // Catch: Exception -> L12
        registerOnGlobalLayoutListener(r1, r7.getView(), r3, sOnCreateTime, "fragmentOnCreateToViewShow");     // Catch: Exception -> L12
        return;
    L17:
        return;
    }

    @Keep
    public static void onTrace(Fragment r11, String r12, String r13, boolean r14) {
        if (TextUtils.equals("onCreate", r13) == false) goto L10;
        if (r14 == false) goto L7;
        sFragmentName = r12;
        sOnCreateStart = System.currentTimeMillis();
        return;
    L7:
        if (isValid(r12) == false) goto L57;
        sOnCreateEnd = System.currentTimeMillis();
        return;
    L57:
        return;
    L10:
        if (TextUtils.equals("onViewCreated", r13) == false) goto L20;
        if (isValid(r12) == false) goto L20;
        long r15 = sOnCreateStart;
        if (r14 == false) goto L17;
        if (r15 <= 0) goto L59;
        sOnViewCreatedStart = System.currentTimeMillis();
        return;
    L59:
        return;
    L17:
        if (r15 <= 0) goto L61;
        sOnViewCreatedEnd = System.currentTimeMillis();
        return;
    L61:
        return;
    L20:
        if (TextUtils.equals("onActivityCreated", r13) == false) goto L30;
        if (isValid(r12) == false) goto L30;
        long r16 = sOnCreateStart;
        if (r14 == false) goto L27;
        if (r16 <= 0) goto L63;
        sOnActivityCreatedStart = System.currentTimeMillis();
        return;
    L63:
        return;
    L27:
        if (r16 <= 0) goto L65;
        sOnActivityCreatedEnd = System.currentTimeMillis();
        return;
    L65:
        return;
    L30:
        if (TextUtils.equals("onResume", r13) == true) goto L32;
        return;
    L32:
        if (isValid(r12) == false) goto L68;
        if (r14 == false) goto L38;
        if (sOnCreateStart <= 0) goto L69;
        sOnResumeStart = System.currentTimeMillis();
        return;
    L69:
        return;
    L38:
        if (sOnCreateStart <= 0) goto L71;
        long r6 = System.currentTimeMillis();
        sOnResumeEnd = r6;
        if ((r6 - sOnCreateStart) < CoroutineLiveDataKt.DEFAULT_TIMEOUT) goto L54;
    L51:
        sOnCreateStart = 0;
        sFragmentName = null;
        return;
    L54:
        JSONObject r17 = new JSONObject();     // Catch: Exception -> L53
        r17.put("begin_time", sOnCreateStart);     // Catch: Exception -> L53
        r17.put("end_time", sOnResumeEnd);     // Catch: Exception -> L53
        JSONObject r7 = new JSONObject();     // Catch: Exception -> L53
        r7.put("onCreate", sOnCreateEnd - sOnCreateStart);     // Catch: Exception -> L53
        r7.put("onViewCreated", sOnViewCreatedEnd - sOnViewCreatedStart);     // Catch: Exception -> L53
        r7.put("onActivityCreated", sOnActivityCreatedEnd - sOnActivityCreatedStart);     // Catch: Exception -> L53
        r7.put("onResume", sOnResumeEnd - sOnResumeStart);     // Catch: Exception -> L53
        r7.put("fragment_create_to_resume", sOnResumeEnd - sOnCreateStart);     // Catch: Exception -> L53
        if (r11 != null) goto L44;
    L46:
        r17.put("page_type", "fragment");     // Catch: Exception -> L53
        JSONObject r18 = new JSONObject();     // Catch: Exception -> L53
        if (sMethodSet.contains(sFragmentName + r13) == true) goto L49;
        boolean r1 = true;
    L50:
        r18.put("is_first", r1);     // Catch: Exception -> L53
        r18.put("scene", r12);     // Catch: Exception -> L53
        sMethodSet.add(sFragmentName + r13);     // Catch: Exception -> L53
        com.bytedance.apm.o.b.a.a("page_load", r7, r18, r17);     // Catch: Exception -> L53
        goto L51
    L49:
        r1 = false;
        goto L50
    L44:
        if (r11.getActivity() == null) goto L46;
        r17.put("attached_activity", r11.getActivity().getClass().getName());     // Catch: Exception -> L53
        goto L46
    L71:
        return;
    }

    @TargetApi(16)
    private static void registerOnGlobalLayoutListener(String r2, View r3, Integer r4, long r5, String r7) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.intValue() <= 0) goto L21;
        sFragmentName = r2;
        WeakReference<View> r6 = sRootViewRef;
        if (r6 != null) goto L9;
    L18:
        sRootViewRef = new WeakReference(r3);
        sCheckVisibilityStartTime = 0;
        sOnGlobalLayoutListener = new a(r4, r5, r7);
        r3.getViewTreeObserver().addOnGlobalLayoutListener(sOnGlobalLayoutListener);
        sWaitViewTimeoutRunnable = new b();
        com.bytedance.apm.f0.a.a().postDelayed(sWaitViewTimeoutRunnable, sMaxWaitTime);
        return;
    L9:
        if (r6.get() == r3) goto L18;
        ViewTreeObserver r8 = sRootViewRef.get().getViewTreeObserver();
        if (r8.isAlive() == false) goto L16;
        ViewTreeObserver.OnGlobalLayoutListener r0 = sOnGlobalLayoutListener;
        if (r0 == null) goto L16;
        r8.removeOnGlobalLayoutListener(r0);
    L16:
        if (sWaitViewTimeoutRunnable == null) goto L18;
        com.bytedance.apm.f0.a.a().removeCallbacks(sWaitViewTimeoutRunnable);
        goto L18
    }

    @Keep
    public static void setUserVisibleHint(Fragment r6, boolean r7) {
        if (r6.isResumed() == true) goto L5;
        return;
    L5:
        if (r6.isHidden() == true) goto L14;
        c.a(r6, r7);
        if (r7 == false) goto L15;
        String r0 = r6.getClass().getCanonicalName();     // Catch: Exception -> L10
        Integer r2 = com.bytedance.apm.g0.i.a.c(r0);     // Catch: Exception -> L10
        registerOnGlobalLayoutListener(r0, r6.getView(), r2, System.currentTimeMillis(), "fragmentUserVisibleToViewShow");     // Catch: Exception -> L10
        return;
    L16:
        return;
    L15:
        return;
    }
}
