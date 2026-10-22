package com.bytedance.blockframework.framework.base;

import android.view.ViewGroup;
import com.bytedance.blockframework.framework.base.BaseBlock;
import com.bytedance.blockframework.framework.task.BlockInflater;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BlockBuilder.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000*\u0010\b\u0000\u0010\u0001*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u000f\u0010/\u001a\u00028\u0000H\u0000¢\u0006\u0004\b0\u00101R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\t\"\u0004\b\u0016\u0010\u000bR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000e\"\u0004\b\u001f\u0010\u0010R\u001e\u0010 \u001a\u00020!8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u000e\"\u0004\b(\u0010\u0010R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u00062"}, d2 = {"Lcom/bytedance/blockframework/framework/base/BaseBlockBuilder;", "Block", "Lcom/bytedance/blockframework/framework/base/BaseBlock;", "", "()V", "condition", "Lkotlin/Function0;", "", "getCondition", "()Lkotlin/jvm/functions/Function0;", "setCondition", "(Lkotlin/jvm/functions/Function0;)V", "createUIOnMainThread", "getCreateUIOnMainThread", "()Z", "setCreateUIOnMainThread", "(Z)V", "immediateBind", "getImmediateBind", "setImmediateBind", "instance", "getInstance", "setInstance", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "getLayoutParams", "()Landroid/view/ViewGroup$LayoutParams;", "setLayoutParams", "(Landroid/view/ViewGroup$LayoutParams;)V", "lazyActive", "getLazyActive", "setLazyActive", "parentId", "", "getParentId", "()I", "setParentId", "(I)V", "replaceParent", "getReplaceParent", "setReplaceParent", "viewInflater", "Lcom/bytedance/blockframework/framework/task/BlockInflater;", "getViewInflater", "()Lcom/bytedance/blockframework/framework/task/BlockInflater;", "setViewInflater", "(Lcom/bytedance/blockframework/framework/task/BlockInflater;)V", "build", "build$blockframework_release", "()Lcom/bytedance/blockframework/framework/base/BaseBlock;", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class BaseBlockBuilder<Block extends BaseBlock<?, ?>> {
    private Function0<Boolean> condition;
    private boolean createUIOnMainThread;
    private boolean immediateBind;
    public Function0<? extends Block> instance;
    private ViewGroup.LayoutParams layoutParams;
    private boolean lazyActive;
    private int parentId;
    private boolean replaceParent;
    private BlockInflater viewInflater;

    public BaseBlockBuilder() {
        this.condition = BaseBlockBuilder$condition$1.INSTANCE;
        this.parentId = -1;
    }

    public final Function0<Block> getInstance() {
        Function0<? extends Block> r0 = this.instance;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("instance");
        return null;
    }

    public final void setInstance(Function0<? extends Block> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.instance = r2;
    }

    public final Function0<Boolean> getCondition() {
        return this.condition;
    }

    public final void setCondition(Function0<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.condition = r2;
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

    public final boolean getReplaceParent() {
        return this.replaceParent;
    }

    public final void setReplaceParent(boolean r1) {
        this.replaceParent = r1;
    }

    public final BlockInflater getViewInflater() {
        return this.viewInflater;
    }

    public final void setViewInflater(BlockInflater r1) {
        this.viewInflater = r1;
    }

    public final boolean getCreateUIOnMainThread() {
        return this.createUIOnMainThread;
    }

    public final void setCreateUIOnMainThread(boolean r1) {
        this.createUIOnMainThread = r1;
    }

    public final boolean getImmediateBind() {
        return this.immediateBind;
    }

    public final void setImmediateBind(boolean r1) {
        this.immediateBind = r1;
    }

    public final boolean getLazyActive() {
        return this.lazyActive;
    }

    public final void setLazyActive(boolean r1) {
        this.lazyActive = r1;
    }

    public final Block build$blockframework_release() {
        return getInstance().invoke();
    }
}
