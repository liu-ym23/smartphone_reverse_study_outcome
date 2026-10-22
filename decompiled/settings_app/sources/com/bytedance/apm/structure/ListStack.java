package com.bytedance.apm.structure;

import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ListStack<T> implements IStack<T> {
    private List<T> list;
    int size;
    private int top;

    @Override // com.bytedance.apm.structure.IStack
    public void clear() {
    }

    public ListStack() {
        this.list = new LinkedList();
        this.top = 0;
        this.size = 0;
    }

    @Override // com.bytedance.apm.structure.IStack
    public T pop() {
        T r0 = this.list.get(this.top - 1);
        this.list.remove(this.top - 1);
        this.size--;
        return r0;
    }

    @Override // com.bytedance.apm.structure.IStack
    public void push(T r2) {
        this.list.add(r2);
        this.size++;
        this.top++;
    }

    @Override // com.bytedance.apm.structure.IStack
    public T peek() {
        return this.list.get(this.top - 1);
    }

    @Override // com.bytedance.apm.structure.IStack
    public boolean isEmpty() {
        if (this.size != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int size() {
        return this.list.size();
    }
}
