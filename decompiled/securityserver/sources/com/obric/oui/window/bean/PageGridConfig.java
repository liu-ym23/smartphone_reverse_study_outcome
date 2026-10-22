package com.obric.oui.window.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class PageGridConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f315a;
    public final PageColumns b;
    public final PageGutter c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PageMargin f316d;

    public PageGridConfig(String r1, PageColumns r2, PageGutter r3, PageMargin r4) {
        this.f315a = r1;
        this.b = r2;
        this.c = r3;
        this.f316d = r4;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof PageGridConfig) == false) goto L14;
        PageGridConfig r4 = (PageGridConfig) r3;
        String r0 = r4.f315a;
        if (Intrinsics.a(this.f315a, r0) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.a(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.a(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.a(this.f316d, r4.f316d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        int r0 = 0;
        String r1 = this.f315a;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L6:
        int r3 = r2 * 31;
        PageColumns r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        PageGutter r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        PageMargin r10 = this.f316d;
        if (r10 == null) goto L18;
        r0 = r10.hashCode();
    L18:
        return r9 + r0;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "PageGridConfig(gridMode=" + this.f315a + ", pageColumns=" + this.b + ", pageGutter=" + this.c + ", pageMargin=" + this.f316d + ")";
    }
}
