package com.bytedance.sysoptimizer.sp;

import java.util.LinkedList;

/* JADX INFO: loaded from: classes3.dex */
public class SPLinkedList extends LinkedList {
    @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue
    public boolean add(Object r1) {
        return true;
    }

    @Override // java.util.LinkedList, java.util.Deque, java.util.Queue
    public Object poll() {
        return null;
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
    public boolean remove(Object r1) {
        return true;
    }

    public SPLinkedList() {
    }
}
