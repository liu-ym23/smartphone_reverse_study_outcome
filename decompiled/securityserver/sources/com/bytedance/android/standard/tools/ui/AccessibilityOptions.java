package com.bytedance.android.standard.tools.ui;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class AccessibilityOptions {

    @Nullable
    private final CharSequence className;

    @Nullable
    private final String contentDescription;
    private final boolean isAccessibilityHeading;

    @Metadata
    public static final class Builder {
        private CharSequence className;
        private String contentDescription;
        private boolean isAccessibilityHeading;

        public Builder() {
        }

        @NotNull
        public final AccessibilityOptions build() {
            return new AccessibilityOptions(this.contentDescription, this.isAccessibilityHeading, this.className);
        }

        @NotNull
        public final Builder setAccessibilityHeading(boolean r1) {
            this.isAccessibilityHeading = r1;
            return this;
        }

        @NotNull
        public final Builder setClassName(@NotNull CharSequence r2) {
            Intrinsics.g(r2, "name");
            this.className = r2;
            return this;
        }

        @NotNull
        public final Builder setContentDescription(@NotNull String r2) {
            Intrinsics.g(r2, "desc");
            this.contentDescription = r2;
            return this;
        }
    }

    public AccessibilityOptions() {
        String r1 = null;
        boolean r2 = false;
        CharSequence r3 = null;
        this(r1, r2, r3, 7, null);
    }

    @Nullable
    public final CharSequence getClassName() {
        return this.className;
    }

    @Nullable
    public final String getContentDescription() {
        return this.contentDescription;
    }

    public final boolean isAccessibilityHeading() {
        return this.isAccessibilityHeading;
    }

    public AccessibilityOptions(@Nullable String r1, boolean r2, @Nullable CharSequence r3) {
        this.contentDescription = r1;
        this.isAccessibilityHeading = r2;
        this.className = r3;
    }

    public /* synthetic */ AccessibilityOptions(String r2, boolean r3, CharSequence r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = false;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
