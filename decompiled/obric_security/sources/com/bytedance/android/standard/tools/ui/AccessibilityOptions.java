package com.bytedance.android.standard.tools.ui;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AccessibilityUtils.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u000eB'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/standard/tools/ui/AccessibilityOptions;", "", "contentDescription", "", "isAccessibilityHeading", "", "className", "", "(Ljava/lang/String;ZLjava/lang/CharSequence;)V", "getClassName", "()Ljava/lang/CharSequence;", "getContentDescription", "()Ljava/lang/String;", "()Z", "Builder", "mohist-standard-tools_release"}, k = 1, mv = {1, 1, 15})
public final class AccessibilityOptions {
    private final CharSequence className;
    private final String contentDescription;
    private final boolean isAccessibilityHeading;

    /* JADX INFO: compiled from: AccessibilityUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0006R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/standard/tools/ui/AccessibilityOptions$Builder;", "", "()V", "className", "", "contentDescription", "", "isAccessibilityHeading", "", "build", "Lcom/bytedance/android/standard/tools/ui/AccessibilityOptions;", "setAccessibilityHeading", "heading", "setClassName", "name", "setContentDescription", "desc", "mohist-standard-tools_release"}, k = 1, mv = {1, 1, 15})
    public static final class Builder {
        private CharSequence className;
        private String contentDescription;
        private boolean isAccessibilityHeading;

        public Builder() {
        }

        public final Builder setAccessibilityHeading(boolean r2) {
            this.isAccessibilityHeading = r2;
            return this;
        }

        public final Builder setClassName(CharSequence r2) {
            Intrinsics.checkParameterIsNotNull(r2, "name");
            this.className = r2;
            return this;
        }

        public final Builder setContentDescription(String r2) {
            Intrinsics.checkParameterIsNotNull(r2, "desc");
            this.contentDescription = r2;
            return this;
        }

        public final AccessibilityOptions build() {
            return new AccessibilityOptions(this.contentDescription, this.isAccessibilityHeading, this.className);
        }
    }

    public AccessibilityOptions() {
        this(null, false, null, 7, null);
    }

    public AccessibilityOptions(String r1, boolean r2, CharSequence r3) {
        this.contentDescription = r1;
        this.isAccessibilityHeading = r2;
        this.className = r3;
    }

    public /* synthetic */ AccessibilityOptions(String r2, boolean r3, CharSequence r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        String r7 = (String) null;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = false;
    L9:
        if ((r5 & 4) == 0) goto L11;
        CharSequence r8 = (CharSequence) null;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }

    public final String getContentDescription() {
        return this.contentDescription;
    }

    public final boolean isAccessibilityHeading() {
        return this.isAccessibilityHeading;
    }

    public final CharSequence getClassName() {
        return this.className;
    }
}
