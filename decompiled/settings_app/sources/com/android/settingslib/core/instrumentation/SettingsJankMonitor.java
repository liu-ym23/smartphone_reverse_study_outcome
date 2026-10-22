package com.android.settingslib.core.instrumentation;

import android.view.View;
import androidx.preference.PreferenceGroupAdapter;
import androidx.preference.TwoStatePreference;
import androidx.recyclerview.widget.RecyclerView;
import com.android.internal.jank.InteractionJankMonitor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SettingsJankMonitor.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u001a\u0010\u0011\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \b*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/android/settingslib/core/instrumentation/SettingsJankMonitor;", "", "()V", "MONITORED_ANIMATION_DURATION_MS", "", "getMONITORED_ANIMATION_DURATION_MS$annotations", "jankMonitor", "Lcom/android/internal/jank/InteractionJankMonitor;", "kotlin.jvm.PlatformType", "scheduledExecutorService", "Ljava/util/concurrent/ScheduledExecutorService;", "detectSwitchPreferenceClickJank", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "preference", "Landroidx/preference/TwoStatePreference;", "detectToggleJank", "tag", "", "view", "Landroid/view/View;", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SettingsJankMonitor {
    public static final SettingsJankMonitor INSTANCE = null;
    public static final long MONITORED_ANIMATION_DURATION_MS = 300;
    private static final InteractionJankMonitor jankMonitor = null;
    private static final ScheduledExecutorService scheduledExecutorService = null;

    /* JADX INFO: renamed from: $r8$lambda$4oeGQv8l5wpJ2J6vNLGifK-VsaM, reason: not valid java name */
    public static /* synthetic */ void m755$r8$lambda$4oeGQv8l5wpJ2J6vNLGifKVsaM() {
        detectToggleJank$lambda$0();
    }

    public static /* synthetic */ void getMONITORED_ANIMATION_DURATION_MS$annotations() {
    }

    private SettingsJankMonitor() {
    }

    static {
        INSTANCE = new SettingsJankMonitor();
        jankMonitor = InteractionJankMonitor.getInstance();
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
    }

    @JvmStatic
    public static final void detectSwitchPreferenceClickJank(RecyclerView r2, TwoStatePreference r3) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        Intrinsics.checkNotNullParameter(r3, "preference");
        RecyclerView.Adapter r0 = r2.getAdapter();
        if ((r0 instanceof PreferenceGroupAdapter) == false) goto L5;
        PreferenceGroupAdapter r1 = (PreferenceGroupAdapter) r0;
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        RecyclerView.ViewHolder r4 = r2.findViewHolderForAdapterPosition(r1.getPreferenceAdapterPosition(r3));
        if (r4 != null) goto L11;
        return;
    L11:
        String r5 = r3.getKey();
        View r6 = r4.itemView;
        Intrinsics.checkNotNullExpressionValue(r6, "viewHolder.itemView");
        detectToggleJank(r5, r6);
        return;
    L5:
        r1 = null;
        goto L6
    }

    @JvmStatic
    public static final void detectToggleJank(String r3, View r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        InteractionJankMonitor.Configuration.Builder r5 = InteractionJankMonitor.Configuration.Builder.withView(57, r4);
        if (r3 == null) goto L6;
        r5.setTag(r3);
    L6:
        if (jankMonitor.begin(r5) == false) goto L9;
        scheduledExecutorService.schedule(new SettingsJankMonitor$$ExternalSyntheticLambda0(), 300, TimeUnit.MILLISECONDS);
        return;
    }

    private static final void detectToggleJank$lambda$0() {
        jankMonitor.end(57);
    }
}
