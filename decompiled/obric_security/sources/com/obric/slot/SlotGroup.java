package com.obric.slot;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SlotGroup.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000eR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/slot/SlotGroup;", "", "()V", "entries", "", "Lcom/obric/slot/SlotGroup$Entry;", "add", "", "slot", "Lcom/obric/slot/Slot;", "condition", "Lkotlin/Function0;", "", "resolve", "", "Entry", "slot_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SlotGroup {
    private final List<Entry> entries;

    /* JADX INFO: compiled from: SlotGroup.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/slot/SlotGroup$Entry;", "", "slot", "Lcom/obric/slot/Slot;", "condition", "Lkotlin/Function0;", "", "(Lcom/obric/slot/Slot;Lkotlin/jvm/functions/Function0;)V", "getCondition", "()Lkotlin/jvm/functions/Function0;", "getSlot", "()Lcom/obric/slot/Slot;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "slot_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class Entry {
        private final Function0<Boolean> condition;
        private final Slot slot;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Entry copy$default(Entry r0, Slot r1, Function0 r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.slot;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.condition;
        L9:
            return r0.copy(r1, r2);
        }

        public final Slot component1() {
            return this.slot;
        }

        public final Function0<Boolean> component2() {
            return this.condition;
        }

        public final Entry copy(Slot r1, Function0<Boolean> r2) {
            Intrinsics.checkNotNullParameter(r1, "slot");
            Intrinsics.checkNotNullParameter(r2, "condition");
            return new Entry(r1, r2);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof Entry) == true) goto L8;
            return false;
        L8:
            Entry r6 = (Entry) r5;
            if (Intrinsics.areEqual(this.slot, r6.slot) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.condition, r6.condition) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.slot.hashCode() * 31) + this.condition.hashCode();
        }

        public String toString() {
            return "Entry(slot=" + this.slot + ", condition=" + this.condition + ")";
        }

        public Entry(Slot r2, Function0<Boolean> r3) {
            Intrinsics.checkNotNullParameter(r2, "slot");
            Intrinsics.checkNotNullParameter(r3, "condition");
            this.slot = r2;
            this.condition = r3;
        }

        public final Function0<Boolean> getCondition() {
            return this.condition;
        }

        public final Slot getSlot() {
            return this.slot;
        }
    }

    public SlotGroup() {
        this.entries = new ArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void add$default(SlotGroup r0, Slot r1, AnonymousClass1 r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = AnonymousClass1.INSTANCE;
    L5:
        r0.add(r1, r2);
    }

    public final void add(Slot r2, Function0<Boolean> r3) {
        Intrinsics.checkNotNullParameter(r2, "slot");
        Intrinsics.checkNotNullParameter(r3, "condition");
        this.entries.add(new Entry(r2, r3));
    }

    public final List<Slot> resolve() {
        List<Entry> r3 = this.entries;
        ArrayList r0 = new ArrayList();
        Iterator<T> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Object r1 = r4.next();
        if (((Entry) r1).getCondition().invoke().booleanValue() == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        ArrayList r2 = r0;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r6 = r2.iterator();
    L10:
        if (r6.hasNext() == false) goto L13;
        r5.add(((Entry) r6.next()).getSlot());
        goto L10
    L13:
        return r5;
    }
}
