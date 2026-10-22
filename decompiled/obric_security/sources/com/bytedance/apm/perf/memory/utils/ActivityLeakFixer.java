package com.bytedance.apm.perf.memory.utils;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.data.pipeline.CommonDataPipeline;
import com.bytedance.apm.data.type.EventData;
import com.bytedance.apm.logging.Logger;
import com.bytedance.apm.samplers.SamplerHelper;
import java.lang.reflect.Field;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityLeakFixer {
    public static final String ACTIVITY_LEAK_EVENT = "activity_leak_event";
    private static final String TAG = "ActivityLeakFixer";

    public ActivityLeakFixer() {
    }

    public static void fixInputMethodManagerLeak(Context r12) {
        long r0 = System.currentTimeMillis();
        if (r12 == null) goto L30;
        InputMethodManager r5 = (InputMethodManager) r12.getSystemService("input_method");
        if (r5 == null) goto L30;
        String[] r6 = {"mCurRootView", "mServedView", "mNextServedView"};
        int r7 = 0;
    L10:
        if (r7 >= 3) goto L30;
        Field r8 = r5.getClass().getDeclaredField(r6[r7]);     // Catch: Throwable -> L24
        if (r8.isAccessible() == true) goto L15;
        r8.setAccessible(true);     // Catch: Throwable -> L24
    L15:
        Object r9 = r8.get(r5);     // Catch: Throwable -> L24
        if ((r9 instanceof View) == false) goto L28;
        View r10 = (View) r9;     // Catch: Throwable -> L24
        if (r10.getContext() != r12) goto L21;
        r8.set(r5, null);     // Catch: Throwable -> L24
        goto L28
    L21:
        if (ApmContext.isDebugMode() == false) goto L30;
        Logger.i(TAG, new String[]{"fixInputMethodManagerLeak break, context is not suitable, get_context=" + r10.getContext() + " dest_context=" + r12});     // Catch: Throwable -> L24
    L28:
        r7 = r7 + 1;
    L24:
        th = move-exception;
        if (ApmContext.isDebugMode() == false) goto L28;
        Logger.e(TAG, new String[]{"failed to fix InputMethodManagerLeak, " + th.toString()});
    L30:
        if (ApmContext.isDebugMode() == false) goto L42;
        Logger.i(TAG, new String[]{"fixInputMethodManagerLeak done, cost: " + (System.currentTimeMillis() - r0) + " ms."});
        return;
    }

    public static void uploadLeakEvent(String r10) {
        boolean r0 = SamplerHelper.getServiceSwitch(ACTIVITY_LEAK_EVENT);
        if (ApmContext.isDebugMode() == false) goto L5;
        Logger.i(TAG, new String[]{"activity_leak_event : " + r0});
    L5:
        if (r0 == true) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r10) == true) goto L17;
        JSONObject r7 = new JSONObject();     // Catch: Exception -> L11
        r7.put(r10, 1);     // Catch: Exception -> L11
        CommonDataPipeline.getInstance().handle(new EventData(ACTIVITY_LEAK_EVENT, 0, null, r7, null, null));     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static void unbindDrawables(Activity r8) {
        long r0 = System.currentTimeMillis();
        if (r8 == null) goto L24;
        if (r8.getWindow() == null) goto L24;
        if (r8.getWindow().peekDecorView() == null) goto L24;
    L19:
        th = move-exception;
        if (ApmContext.isDebugMode() == false) goto L27;
        Logger.w(TAG, new String[]{"caught unexpected exception when unbind drawables.", th.getMessage()});
    L27:
        if (ApmContext.isDebugMode() == false) goto L32;
        Logger.i(TAG, new String[]{"unbindDrawables done, cost: " + (System.currentTimeMillis() - r0) + " ms."});
        return;
    L32:
        return;
    L9:
        if (r8.isDestroyed() == true) goto L12;
        return;
    L12:
        if (r8.getWindow().getContext() != r8) goto L27;
        View r5 = r8.getWindow().peekDecorView().getRootView();     // Catch: Throwable -> L19
        ViewGroup r6 = (ViewGroup) r5.findViewById(R.id.content);     // Catch: Throwable -> L19
        if (r6.getChildCount() <= 0) goto L27;
        if (r6.getChildAt(0).getContext() != r8) goto L27;
        unbindDrawablesAndRecycleInView(r5, r8);     // Catch: Throwable -> L19
    L24:
        if (ApmContext.isDebugMode() == false) goto L27;
        Logger.i(TAG, new String[]{"unbindDrawables, ui or ui's window is null, skip rest works."});
        goto L27
    }

    private static void unbindDrawablesAndRecycleInView(View r1, Activity r2) {
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.getContext() != null) goto L8;
        return;
    L8:
        if (r1.getContext() != r2) goto L16;
        recycleBackground(r1);
        if ((r1 instanceof ImageView) == false) goto L13;
        recycleImageView((ImageView) r1);
    L13:
        if ((r1 instanceof TextView) == false) goto L16;
        recycleTextViewCompound((TextView) r1);
    L16:
        if ((r1 instanceof ViewGroup) == false) goto L19;
        recycleViewGroupByView((ViewGroup) r1, r2);
        return;
    }

    private static void recycleBackground(View r2) {
        if (r2.getBackground() == null) goto L9;
        r2.getBackground().setCallback(null);     // Catch: Throwable -> L6
        r2.setBackgroundDrawable(null);     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    private static void recycleImageView(ImageView r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        Drawable r0 = r2.getDrawable();
        if (r0 == null) goto L7;
        r0.setCallback(null);
    L7:
        r2.setImageDrawable(null);
    }

    private static void recycleTextViewCompound(TextView r5) {
        Drawable[] r0 = r5.getCompoundDrawables();
        int r1 = r0.length;
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L9;
        Drawable r4 = r0[r2];
        if (r4 == null) goto L8;
        r4.setCallback(null);
    L8:
        r2 = r2 + 1;
        goto L4
    L9:
        r5.setCompoundDrawables(null, null, null, null);
    }

    private static void recycleViewGroupByView(ViewGroup r3, Activity r4) {
        int r0 = r3.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        unbindDrawablesAndRecycleInView(r3.getChildAt(r1), r4);
        r1 = r1 + 1;
        goto L3
    }
}
