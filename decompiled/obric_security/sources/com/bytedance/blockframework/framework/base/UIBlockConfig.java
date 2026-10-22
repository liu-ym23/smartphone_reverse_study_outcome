package com.bytedance.blockframework.framework.base;

import android.view.ViewGroup;
import com.bytedance.blockframework.framework.task.BlockInflater;
import com.bytedance.blockframework.framework.task.DefaultLayoutInflater;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IUIBlock.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003J=\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010$\u001a\u00020\u00072\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006)"}, d2 = {"Lcom/bytedance/blockframework/framework/base/UIBlockConfig;", "", "parentId", "", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "createUIOnMainThread", "", "replaceParent", "viewInflater", "Lcom/bytedance/blockframework/framework/task/BlockInflater;", "(ILandroid/view/ViewGroup$LayoutParams;ZZLcom/bytedance/blockframework/framework/task/BlockInflater;)V", "getCreateUIOnMainThread", "()Z", "setCreateUIOnMainThread", "(Z)V", "getLayoutParams", "()Landroid/view/ViewGroup$LayoutParams;", "setLayoutParams", "(Landroid/view/ViewGroup$LayoutParams;)V", "getParentId", "()I", "setParentId", "(I)V", "getReplaceParent", "setReplaceParent", "getViewInflater", "()Lcom/bytedance/blockframework/framework/task/BlockInflater;", "setViewInflater", "(Lcom/bytedance/blockframework/framework/task/BlockInflater;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class UIBlockConfig {
    private boolean createUIOnMainThread;
    private ViewGroup.LayoutParams layoutParams;
    private int parentId;
    private boolean replaceParent;
    private BlockInflater viewInflater;

    public UIBlockConfig() {
        this(0, null, false, false, null, 31, null);
    }

    public static /* synthetic */ UIBlockConfig copy$default(UIBlockConfig r3, int r4, ViewGroup.LayoutParams r5, boolean r6, boolean r7, BlockInflater r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.parentId;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.layoutParams;
    L8:
        ViewGroup.LayoutParams r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.createUIOnMainThread;
    L11:
        boolean r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.replaceParent;
    L14:
        boolean r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.viewInflater;
    L17:
        int r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final int component1() {
        return this.parentId;
    }

    public final ViewGroup.LayoutParams component2() {
        return this.layoutParams;
    }

    public final boolean component3() {
        return this.createUIOnMainThread;
    }

    public final boolean component4() {
        return this.replaceParent;
    }

    public final BlockInflater component5() {
        return this.viewInflater;
    }

    public final UIBlockConfig copy(int r7, ViewGroup.LayoutParams r8, boolean r9, boolean r10, BlockInflater r11) {
        Intrinsics.checkNotNullParameter(r11, "viewInflater");
        return new UIBlockConfig(r7, r8, r9, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof UIBlockConfig) == true) goto L8;
        return false;
    L8:
        UIBlockConfig r6 = (UIBlockConfig) r5;
        if (this.parentId == r6.parentId) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.layoutParams, r6.layoutParams) == true) goto L15;
        return false;
    L15:
        if (this.createUIOnMainThread == r6.createUIOnMainThread) goto L18;
        return false;
    L18:
        if (this.replaceParent == r6.replaceParent) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.viewInflater, r6.viewInflater) == true) goto L23;
        return false;
    L23:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int r0 = Integer.hashCode(this.parentId) * 31;
        ViewGroup.LayoutParams r1 = this.layoutParams;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (r0 + r2) * 31;
        boolean r4 = this.createUIOnMainThread;
        ?? r5 = 1;
        ?? r6 = r4;
        if (r4 == false) goto L9;
        r6 = 1;
    L9:
        int r7 = (r3 + r6) * 31;
        boolean r8 = this.replaceParent;
        if (r8 == true) goto L14;
        r5 = r8;
    L14:
        return ((r7 + r5) * 31) + this.viewInflater.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "UIBlockConfig(parentId=" + this.parentId + ", layoutParams=" + this.layoutParams + ", createUIOnMainThread=" + this.createUIOnMainThread + ", replaceParent=" + this.replaceParent + ", viewInflater=" + this.viewInflater + ')';
    }

    public UIBlockConfig(int r2, ViewGroup.LayoutParams r3, boolean r4, boolean r5, BlockInflater r6) {
        Intrinsics.checkNotNullParameter(r6, "viewInflater");
        this.parentId = r2;
        this.layoutParams = r3;
        this.createUIOnMainThread = r4;
        this.replaceParent = r5;
        this.viewInflater = r6;
    }

    public final int getParentId() {
        return this.parentId;
    }

    public final void setParentId(int r1) {
        this.parentId = r1;
    }

    public final ViewGroup.LayoutParams getLayoutParams() {
        return this.layoutParams;
    }

    public final void setLayoutParams(ViewGroup.LayoutParams r1) {
        this.layoutParams = r1;
    }

    public final boolean getCreateUIOnMainThread() {
        return this.createUIOnMainThread;
    }

    public final void setCreateUIOnMainThread(boolean r1) {
        this.createUIOnMainThread = r1;
    }

    public final boolean getReplaceParent() {
        return this.replaceParent;
    }

    public final void setReplaceParent(boolean r1) {
        this.replaceParent = r1;
    }

    public /* synthetic */ UIBlockConfig(int r4, ViewGroup.LayoutParams r5, boolean r6, boolean r7, DefaultLayoutInflater r8, int r9, DefaultConstructorMarker r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = -1;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = null;
    L8:
        ViewGroup.LayoutParams r11 = r5;
        boolean r0 = false;
        if ((r9 & 4) == 0) goto L11;
        boolean r1 = false;
    L13:
        if ((r9 & 8) != 0) goto L17;
        r0 = r7;
    L17:
        if ((r9 & 16) == 0) goto L19;
        r8 = DefaultLayoutInflater.INSTANCE;
    L19:
        this(r4, r11, r1, r0, r8);
        return;
    L11:
        r1 = r6;
        goto L13
    }

    public final BlockInflater getViewInflater() {
        return this.viewInflater;
    }

    public final void setViewInflater(BlockInflater r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.viewInflater = r2;
    }
}
