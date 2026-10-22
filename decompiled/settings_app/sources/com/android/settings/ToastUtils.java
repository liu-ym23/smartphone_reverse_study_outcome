package com.android.settings;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.Toast;
import com.android.settings.utils.ThreadUtils;
import com.obric.olog.OLog;
import com.obric.oui.toast.OToast;
import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: classes2.dex */
public class ToastUtils {
    private static final String TAG = "ToastUtils";
    private static SoftReference<OToast> sLastToastRef;

    public ToastUtils() {
    }

    static /* synthetic */ void lambda$show$0(Context r0, int r1) {
        show(r0, r1);
    }

    public static OToast show(final Context r1, final int r2) {
        if (postShowIfNeeded(new ToastUtils$$ExternalSyntheticLambda0(r1, r2)) == false) goto L7;
        return null;
    L7:
        return showInView(r1, r2);
    }

    static /* synthetic */ void lambda$show$1(Context r0, CharSequence r1) {
        show(r0, r1);
    }

    public static OToast show(final Context r1, final CharSequence r2) {
        if (postShowIfNeeded(new ToastUtils$$ExternalSyntheticLambda5(r1, r2)) == false) goto L7;
        return null;
    L7:
        return showInView(r1, r2);
    }

    public static OToast show(final Activity r2, final int r3) {
        if (r2 != null) goto L7;
        OLog.e(TAG, "show(resId): context is null", new Throwable());
        return null;
    L7:
        if (postShowIfNeeded(new ToastUtils$$ExternalSyntheticLambda4(r2, r3)) == false) goto L10;
        return null;
    L10:
        return show(r2, r2.getString(r3));
    }

    static /* synthetic */ void lambda$show$2(Activity r0, int r1) {
        show(r0, r1);
    }

    public static OToast show(final Activity r2, final CharSequence r3) {
        if (r2 != null) goto L7;
        OLog.e(TAG, "show(text): context is null->" + r3, new Throwable());
        return null;
    L7:
        if (postShowIfNeeded(new ToastUtils$$ExternalSyntheticLambda2(r2, r3)) == false) goto L9;
        return null;
    L9:
        OToast r4 = obtainToastLocked(r2, r3);
        r4.show();
        return r4;
    }

    static /* synthetic */ void lambda$show$3(Activity r0, CharSequence r1) {
        show(r0, r1);
    }

    public static OToast showLeftIcon(final Activity r2, final CharSequence r3, final int r4) {
        if (r2 != null) goto L7;
        OLog.e(TAG, "showLeftIcon(iconId): context is null->" + r3, new Throwable());
        return null;
    L7:
        if (postShowIfNeeded(new ToastUtils$$ExternalSyntheticLambda6(r2, r3, r4)) == false) goto L10;
        return null;
    L10:
        return showLeftIcon(r2, r3, r2.getDrawable(r4));
    }

    static /* synthetic */ void lambda$showLeftIcon$4(Activity r0, CharSequence r1, int r2) {
        showLeftIcon(r0, r1, r2);
    }

    public static OToast showLeftIcon(final Activity r2, final CharSequence r3, final Drawable r4) {
        if (r2 != null) goto L7;
        OLog.e(TAG, "showLeftIcon(icon): context is null->" + r3, new Throwable());
        return null;
    L7:
        if (postShowIfNeeded(new ToastUtils$$ExternalSyntheticLambda8(r2, r3, r4)) == false) goto L9;
        return null;
    L9:
        OToast r5 = obtainToastLocked(r2, r3);
        r5.setLeftDrawable(r4);
        r5.show();
        return r5;
    }

    static /* synthetic */ void lambda$showLeftIcon$5(Activity r0, CharSequence r1, Drawable r2) {
        showLeftIcon(r0, r1, r2);
    }

    static /* synthetic */ void lambda$showInView$6(Context r0, CharSequence r1) {
        showInView(r0, r1);
    }

    public static OToast showInView(final Context r2, final CharSequence r3) {
        if (postShowIfNeeded(new ToastUtils$$ExternalSyntheticLambda1(r2, r3)) == false) goto L5;
        return null;
    L5:
        Activity r0 = getActivity(r2);
        if (r0 != null) goto L11;
        if (r2 == null) goto L11;
        Toast.makeText(r2, r3, 0).show();
        OLog.e(TAG, "showInView:", new Throwable());
        return null;
    L11:
        return show(r0, r3);
    }

    static /* synthetic */ void lambda$showInView$7(Context r0, int r1) {
        showInView(r0, r1);
    }

    public static OToast showInView(final Context r2, final int r3) {
        if (postShowIfNeeded(new ToastUtils$$ExternalSyntheticLambda3(r2, r3)) == false) goto L5;
        return null;
    L5:
        Activity r0 = getActivity(r2);
        if (r0 != null) goto L11;
        if (r2 == null) goto L11;
        Toast.makeText(r2, r3, 0).show();
        OLog.e(TAG, "showInView:", new Throwable());
        return null;
    L11:
        return show(r0, r3);
    }

    public static OToast showToastWithOffset(Activity r0, int r1, int r2) {
        return show(r0, r1);
    }

    public static OToast showOceanToast(Activity r0, CharSequence r1) {
        return show(r0, r1);
    }

    private static Activity getActivity(Context r1) {
        if ((r1 instanceof Activity) == true) goto L5;
        return null;
    L5:
        return (Activity) r1;
    }

    private static OToast obtainToastLocked(Activity r3, CharSequence r4) {
        SoftReference<OToast> r0 = sLastToastRef;
        if (r0 == null) goto L5;
        OToast r1 = r0.get();
    L6:
        if (r1 != null) goto L13;
    L11:
        OToast r2 = new OToast(r3, String.valueOf(r4), 80, true);
        sLastToastRef = new SoftReference(r2);
        return r2;
    L13:
        r1.cancel();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        OLog.e(TAG, "cancel last toast failed", th);
        goto L11
    L5:
        r1 = null;
        goto L6
    }

    private static boolean postShowIfNeeded(final Runnable r1) {
        if (ThreadUtils.isMainThread() == false) goto L6;
        return false;
    L6:
        ThreadUtils.postOnMainThread(new ToastUtils$$ExternalSyntheticLambda7(r1));
        return true;
    }

    static /* synthetic */ void lambda$postShowIfNeeded$8(Runnable r2) {
        r2.run();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        OLog.e(TAG, "show on main thread error", e);
    }
}
