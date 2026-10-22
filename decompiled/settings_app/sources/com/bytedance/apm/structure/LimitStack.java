package com.bytedance.apm.structure;

/* JADX INFO: loaded from: classes3.dex */
public class LimitStack<T> extends ListStack<T> {
    int maxSize;

    public LimitStack(int r1) {
        this.maxSize = r1;
    }

    @Override // com.bytedance.apm.structure.ListStack, com.bytedance.apm.structure.IStack
    public void push(T r3) {
        if (this.size < this.maxSize) goto L5;
        pop();
    L5:
        super.push(r3);
    }
}
