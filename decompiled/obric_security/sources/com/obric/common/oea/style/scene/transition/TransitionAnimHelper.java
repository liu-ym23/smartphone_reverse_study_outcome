package com.obric.common.oea.style.scene.transition;

import android.app.Activity;
import android.view.WindowManager;
import androidx.fragment.app.FragmentTransaction;
import com.obric.common.oea.foundation.util.OEALogger;
import com.obric.common.oea.foundation.util.SdkInit;
import com.obric.common.oea.style.R;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TransitionAnimHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007J\u001a\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0018\u0010\u0013\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0014\u0010\u0014\u001a\u00020\u0015*\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0012H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/common/oea/style/scene/transition/TransitionAnimHelper;", "", "()V", "TAG", "", "sdkInit", "Lcom/obric/common/oea/foundation/util/SdkInit;", "enableModalTransition", "", "layoutParams", "Landroid/view/WindowManager$LayoutParams;", "enable", "", "enableSearchTransition", "overrideEnterAnim", "activity", "Landroid/app/Activity;", "animStyle", "Lcom/obric/common/oea/style/scene/transition/TransitionAnimStyle;", "overrideExitAnim", "setOUICustomAnimations", "Landroidx/fragment/app/FragmentTransaction;", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class TransitionAnimHelper {
    public static final TransitionAnimHelper INSTANCE = null;
    private static final String TAG = "TransitionAnimHelper";
    private static final SdkInit sdkInit = null;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4 = null;

        static {
            int[] r0 = new int[TransitionAnimStyle.values().length];
            $EnumSwitchMapping$0 = r0;
            r0[TransitionAnimStyle.SubpageInOut.ordinal()] = 1;
            r0[TransitionAnimStyle.SettingsInOut.ordinal()] = 2;
            int[] r1 = new int[TransitionAnimStyle.values().length];
            $EnumSwitchMapping$1 = r1;
            r1[TransitionAnimStyle.Standard.ordinal()] = 1;
            r1[TransitionAnimStyle.Modal.ordinal()] = 2;
            r1[TransitionAnimStyle.Search.ordinal()] = 3;
            int[] r2 = new int[TransitionAnimStyle.values().length];
            $EnumSwitchMapping$2 = r2;
            r2[TransitionAnimStyle.SubpageInOut.ordinal()] = 1;
            r2[TransitionAnimStyle.SettingsInOut.ordinal()] = 2;
            int[] r3 = new int[TransitionAnimStyle.values().length];
            $EnumSwitchMapping$3 = r3;
            r3[TransitionAnimStyle.Standard.ordinal()] = 1;
            r3[TransitionAnimStyle.Modal.ordinal()] = 2;
            r3[TransitionAnimStyle.Search.ordinal()] = 3;
            int[] r4 = new int[TransitionAnimStyle.values().length];
            $EnumSwitchMapping$4 = r4;
            r4[TransitionAnimStyle.Standard.ordinal()] = 1;
            r4[TransitionAnimStyle.Modal.ordinal()] = 2;
            r4[TransitionAnimStyle.Search.ordinal()] = 3;
        }
    }

    static {
        INSTANCE = new TransitionAnimHelper();
        sdkInit = new SdkInit();
    }

    private TransitionAnimHelper() {
    }

    @JvmStatic
    public static final void overrideEnterAnim(Activity r12, TransitionAnimStyle r13) {
        Intrinsics.checkNotNullParameter(r12, "activity");
        Intrinsics.checkNotNullParameter(r13, "animStyle");
        int r0 = WhenMappings.$EnumSwitchMapping$0[r13.ordinal()];
        if (r0 == 1) goto L7;
        if (r0 == 2) goto L6;
        TransitionAnimStyle r1 = r13;
    L8:
        String r3 = r12.getClass().getSimpleName();
        if (r13 == r1) goto L11;
        OEALogger.e$default(OEALogger.INSTANCE, TAG, "overrideEnterAnim, " + r13 + " is deprecated: , use " + r1 + " instead, activity: " + r3, null, 4, null);
    L12:
        int r2 = WhenMappings.$EnumSwitchMapping$1[r1.ordinal()];
        if (r2 == 1) goto L20;
        if (r2 != 2) goto L16;
        r12.overridePendingTransition(R.anim.oui_modal_open_enter, R.anim.oui_modal_open_exit);
        return;
    L16:
        if (r2 == 3) goto L18;
        OEALogger.INSTANCE.w(TAG, "overrideEnterAnim, unsupported anim style: " + r13 + "，activity: " + r3);
        return;
    L18:
        r12.overridePendingTransition(R.anim.oui_search_open_enter, R.anim.oui_search_open_exit);
        return;
    L20:
        r12.overridePendingTransition(R.anim.oui_activity_open_enter, R.anim.oui_activity_open_exit);
        return;
    L11:
        OEALogger.INSTANCE.r(TAG, "overrideEnterAnim, animStyle: " + r13 + "，activity: " + r3);
        goto L12
    L6:
        r1 = TransitionAnimStyle.Modal;
        goto L8
    L7:
        r1 = TransitionAnimStyle.Standard;
        goto L8
    }

    @JvmStatic
    public static final void overrideExitAnim(Activity r12, TransitionAnimStyle r13) {
        Intrinsics.checkNotNullParameter(r12, "activity");
        Intrinsics.checkNotNullParameter(r13, "animStyle");
        String r0 = r12.getClass().getSimpleName();
        int r1 = WhenMappings.$EnumSwitchMapping$2[r13.ordinal()];
        if (r1 == 1) goto L7;
        if (r1 == 2) goto L6;
        TransitionAnimStyle r2 = r13;
    L9:
        if (r13 == r2) goto L11;
        OEALogger.e$default(OEALogger.INSTANCE, TAG, "overrideExitAnim, " + r13 + " is deprecated, use " + r2 + " instead，activity: " + r0, null, 4, null);
    L12:
        int r3 = WhenMappings.$EnumSwitchMapping$3[r2.ordinal()];
        if (r3 == 1) goto L20;
        if (r3 != 2) goto L16;
        r12.overridePendingTransition(R.anim.oui_modal_close_enter, R.anim.oui_modal_close_exit);
        return;
    L16:
        if (r3 == 3) goto L18;
        OEALogger.INSTANCE.w(TAG, "overrideExitAnim, unsupported anim style: " + r13 + "，activity: " + r0);
        return;
    L18:
        r12.overridePendingTransition(R.anim.oui_search_close_enter, R.anim.oui_search_close_exit);
        return;
    L20:
        r12.overridePendingTransition(R.anim.oui_activity_close_enter, R.anim.oui_activity_close_exit);
        return;
    L11:
        OEALogger.INSTANCE.r(TAG, "overrideExitAnim, animStyle: " + r13 + "，activity: " + r0);
        goto L12
    L6:
        r2 = TransitionAnimStyle.Modal;
        goto L9
    L7:
        r2 = TransitionAnimStyle.Standard;
        goto L9
    }

    @JvmStatic
    public static final FragmentTransaction setOUICustomAnimations(FragmentTransaction r4, TransitionAnimStyle r5) {
        Intrinsics.checkNotNullParameter(r4, "$this$setOUICustomAnimations");
        Intrinsics.checkNotNullParameter(r5, "animStyle");
        OEALogger.INSTANCE.r(TAG, "setOUICustomAnimations, animStyle: " + r5);
        int r0 = WhenMappings.$EnumSwitchMapping$4[r5.ordinal()];
        if (r0 != 1) goto L5;
        Intrinsics.checkNotNullExpressionValue(r4.setCustomAnimations(R.anim.oui_activity_open_enter, R.anim.oui_activity_open_exit, R.anim.oui_activity_close_enter, R.anim.oui_activity_close_exit), "setCustomAnimations(\n   …e_exit,\n                )");
    L12:
        return r4;
    L5:
        if (r0 != 2) goto L7;
        Intrinsics.checkNotNullExpressionValue(r4.setCustomAnimations(R.anim.oui_modal_open_enter, R.anim.oui_modal_open_exit, R.anim.oui_modal_close_enter, R.anim.oui_modal_close_exit), "setCustomAnimations(\n   …e_exit,\n                )");
        goto L12
    L7:
        if (r0 == 3) goto L9;
        OEALogger.INSTANCE.w(TAG, "setOUICustomAnimations, unsupported anim style: " + r5);
        goto L12
    L9:
        Intrinsics.checkNotNullExpressionValue(r4.setCustomAnimations(R.anim.oui_search_open_enter, R.anim.oui_search_open_exit, R.anim.oui_search_close_enter, R.anim.oui_search_close_exit), "setCustomAnimations(\n   …e_exit,\n                )");
        goto L12
    }

    public static /* synthetic */ void enableModalTransition$default(WindowManager.LayoutParams r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = true;
    L5:
        enableModalTransition(r0, r1);
    }

    @JvmStatic
    public static final void enableModalTransition(WindowManager.LayoutParams r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r7, "layoutParams");
        OEALogger.INSTANCE.r(TAG, "enableModalTransition, enable: " + r8);
        Class<?> r0 = Class.forName("android.view.WindowManagerExt");     // Catch: Exception -> L5
        Intrinsics.checkNotNullExpressionValue(r0, "Class.forName(\"android.view.WindowManagerExt\")");     // Catch: Exception -> L5
        Method r1 = r0.getMethod("enableModelTransition", new Class[]{WindowManager.LayoutParams.class, Boolean.TYPE});     // Catch: Exception -> L5
        Intrinsics.checkNotNullExpressionValue(r1, "windowManagerExtClass.ge…imitiveType\n            )");     // Catch: Exception -> L5
        r1.invoke(null, new Object[]{r7, Boolean.valueOf(r8)});     // Catch: Exception -> L5
        return;
    }

    public static /* synthetic */ void enableSearchTransition$default(WindowManager.LayoutParams r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = true;
    L5:
        enableSearchTransition(r0, r1);
    }

    @JvmStatic
    public static final void enableSearchTransition(WindowManager.LayoutParams r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r7, "layoutParams");
        OEALogger.INSTANCE.r(TAG, "enableSearchTransition, enable: " + r8);
        Class<?> r0 = Class.forName("android.view.WindowManagerExt");     // Catch: Exception -> L5
        Intrinsics.checkNotNullExpressionValue(r0, "Class.forName(\"android.view.WindowManagerExt\")");     // Catch: Exception -> L5
        Method r1 = r0.getMethod("enableSearchTransition", new Class[]{WindowManager.LayoutParams.class, Boolean.TYPE});     // Catch: Exception -> L5
        Intrinsics.checkNotNullExpressionValue(r1, "windowManagerExtClass.ge…imitiveType\n            )");     // Catch: Exception -> L5
        r1.invoke(null, new Object[]{r7, Boolean.valueOf(r8)});     // Catch: Exception -> L5
        return;
    }
}
