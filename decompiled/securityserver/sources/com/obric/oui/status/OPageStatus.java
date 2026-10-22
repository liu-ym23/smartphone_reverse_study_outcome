package com.obric.oui.status;

import android.widget.LinearLayout;
import com.obric.oui.button.OButton;
import com.obric.oui.progress.ODownloadProgressView;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OPageStatus extends LinearLayout {

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public final /* synthetic */ class WhenMappings {
        static {
            int[] r0 = new int[SizeSpec.values().length];
            r0[0] = 1;
            r0[1] = 2;
            r0[2] = 3;
            int[] r1 = new int[SizeSpec.values().length];
            r1[0] = 1;
            r1[1] = 2;
            r1[2] = 3;
            int[] r2 = new int[SizeSpec.values().length];
            r2[0] = 1;
            r2[1] = 2;
            r2[2] = 3;
        }
    }

    @NotNull
    public final OButton getButton() {
        Intrinsics.m("button");
        throw null;
    }

    @Nullable
    public final OTextView getLoadingResultView() {
        return null;
    }

    @Nullable
    public final ODownloadProgressView getLoadingView() {
        return null;
    }

    @NotNull
    public final OTextView getMessageView() {
        Intrinsics.m("messageView");
        throw null;
    }

    @NotNull
    public final OTextView getTitleView() {
        Intrinsics.m("titleView");
        throw null;
    }

    public final void setLoadingLayout(int r1) {
        Intrinsics.m("loadingContainer");
        throw null;
    }

    public final void setLoadingResult(@Nullable CharSequence r1) {
    }

    public final void setLoadingResultColor(int r1) {
    }

    public final void setMessage(@Nullable CharSequence r1) {
        Intrinsics.m("messageView");
        throw null;
    }

    public final void setMessageColor(int r1) {
        Intrinsics.m("messageView");
        throw null;
    }

    public final void setTitle(@Nullable CharSequence r1) {
        Intrinsics.m("titleView");
        throw null;
    }

    public final void setTitleColor(int r1) {
        Intrinsics.m("titleView");
        throw null;
    }

    public final void setType(int r3) {
        if (r3 != 0) goto L5;
        Intrinsics.m("contentContainer");
        throw null;
    L5:
        if (r3 != 1) goto L7;
        Intrinsics.m("contentContainer");
        throw null;
    L7:
        if (r3 == 2) goto L9;
        return;
    L9:
        Intrinsics.m("contentContainer");
        throw null;
    }
}
