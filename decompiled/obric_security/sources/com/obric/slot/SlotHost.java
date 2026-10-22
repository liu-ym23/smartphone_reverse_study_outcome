package com.obric.slot;

import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SlotHost.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0017\u0018B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u000bJ\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J%\u0010\u0010\u001a\u0004\u0018\u0001H\u0011\"\b\b\u0000\u0010\u0011*\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0014¢\u0006\u0002\u0010\u0015J\u0006\u0010\u0016\u001a\u00020\u000bR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/slot/SlotHost;", "", "()V", "container", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "defaultContainer", "sections", "", "Lcom/obric/slot/SlotHost$Section;", "addSlot", "", "group", "Lcom/obric/slot/SlotGroup;", "destroy", "destroySection", "findSlot", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/obric/slot/Slot;", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/obric/slot/Slot;", "refresh", "Section", "SlotEntry", "slot_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SlotHost {
    private final ViewGroup defaultContainer;
    private final List<Section> sections;

    /* JADX INFO: compiled from: SlotHost.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/obric/slot/SlotHost$Section;", "", "container", "Landroid/view/ViewGroup;", "entries", "", "Lcom/obric/slot/SlotHost$SlotEntry;", "(Landroid/view/ViewGroup;Ljava/util/List;)V", "getContainer", "()Landroid/view/ViewGroup;", "getEntries", "()Ljava/util/List;", "slot_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class Section {
        private final ViewGroup container;
        private final List<SlotEntry> entries;

        public Section(ViewGroup r2, List<SlotEntry> r3) {
            Intrinsics.checkNotNullParameter(r2, "container");
            Intrinsics.checkNotNullParameter(r3, "entries");
            this.container = r2;
            this.entries = r3;
        }

        public final ViewGroup getContainer() {
            return this.container;
        }

        public final List<SlotEntry> getEntries() {
            return this.entries;
        }
    }

    /* JADX INFO: compiled from: SlotHost.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/obric/slot/SlotHost$SlotEntry;", "", "slot", "Lcom/obric/slot/Slot;", "view", "Landroid/view/View;", "(Lcom/obric/slot/Slot;Landroid/view/View;)V", "getSlot", "()Lcom/obric/slot/Slot;", "getView", "()Landroid/view/View;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "slot_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class SlotEntry {
        private final Slot slot;
        private final View view;

        public static /* synthetic */ SlotEntry copy$default(SlotEntry r0, Slot r1, View r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.slot;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.view;
        L9:
            return r0.copy(r1, r2);
        }

        public final Slot component1() {
            return this.slot;
        }

        public final View component2() {
            return this.view;
        }

        public final SlotEntry copy(Slot r1, View r2) {
            Intrinsics.checkNotNullParameter(r1, "slot");
            Intrinsics.checkNotNullParameter(r2, "view");
            return new SlotEntry(r1, r2);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof SlotEntry) == true) goto L8;
            return false;
        L8:
            SlotEntry r6 = (SlotEntry) r5;
            if (Intrinsics.areEqual(this.slot, r6.slot) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.view, r6.view) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.slot.hashCode() * 31) + this.view.hashCode();
        }

        public String toString() {
            return "SlotEntry(slot=" + this.slot + ", view=" + this.view + ")";
        }

        public SlotEntry(Slot r2, View r3) {
            Intrinsics.checkNotNullParameter(r2, "slot");
            Intrinsics.checkNotNullParameter(r3, "view");
            this.slot = r2;
            this.view = r3;
        }

        public final Slot getSlot() {
            return this.slot;
        }

        public final View getView() {
            return this.view;
        }
    }

    public SlotHost() {
        this.sections = new ArrayList();
        this.defaultContainer = null;
    }

    public SlotHost(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
        this.sections = new ArrayList();
        this.defaultContainer = r2;
    }

    public final void addSlot(SlotGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "group");
        ViewGroup r0 = this.defaultContainer;
        if (r0 == null) goto L7;
        addSlot(r0, r2);
        return;
    L7:
        throw new IllegalStateException("No default container. Use addSlot(container, group) instead.");
    }

    public final void addSlot(ViewGroup r8, SlotGroup r9) {
        Intrinsics.checkNotNullParameter(r8, "container");
        Intrinsics.checkNotNullParameter(r9, "group");
        destroySection(r8);
        List<Slot> r10 = r9.resolve();
        ArrayList r0 = new ArrayList();
        Iterator<T> r1 = r10.iterator();
        int r2 = 0;
    L4:
        if (r1.hasNext() == false) goto L9;
        Object r3 = r1.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        Slot r5 = (Slot) r3;
        View r6 = r5.createView();
        r8.addView(r6);
        r5.onPositioned(r6, r2, r10.size());
        r5.bindView(r6);
        r0.add(new SlotEntry(r5, r6));
        r2 = r4;
        goto L4
    L9:
        this.sections.add(new Section(r8, r0));
    }

    public final void refresh() {
        Iterator<T> r3 = this.sections.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        Iterator<T> r0 = ((Section) r3.next()).getEntries().iterator();
    L7:
        if (r0.hasNext() == false) goto L4;
        SlotEntry r1 = (SlotEntry) r0.next();
        r1.component1().bindView(r1.component2());
        goto L7
    }

    public final void destroy() {
        Iterator<T> r0 = this.sections.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        Section r1 = (Section) r0.next();
        Iterator<T> r2 = r1.getEntries().iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        SlotEntry r3 = (SlotEntry) r2.next();
        r3.component1().onDestroy(r3.component2());
        goto L7
    L9:
        r1.getEntries().clear();
        r1.getContainer().removeAllViews();
        goto L4
    L10:
        this.sections.clear();
    }

    public final <T extends Slot> T findSlot(Class<T> r4) {
        Intrinsics.checkNotNullParameter(r4, "clazz");
        List<Section> r3 = this.sections;
        ArrayList r0 = new ArrayList();
        Iterator<T> r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        CollectionsKt.addAll(r0, ((Section) r5.next()).getEntries());
        goto L4
    L6:
        ArrayList r1 = r0;
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        r6.add(((SlotEntry) r2.next()).getSlot());
        goto L8
    L10:
        Iterator r7 = r6.iterator();
    L12:
        if (r7.hasNext() == false) goto L16;
        Object r8 = r7.next();
        if (r4.isInstance((Slot) r8) == false) goto L12;
    L18:
        if ((r8 instanceof Slot) == true) goto L20;
        return null;
    L20:
        return (T) r8;
    L16:
        r8 = null;
        goto L18
    }

    private final void destroySection(ViewGroup r4) {
        Iterator<T> r0 = this.sections.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((Section) r1).getContainer() != r4) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L4;
    L12:
        Section r3 = (Section) r1;
        if (r3 == null) goto L26;
        Iterator<T> r5 = r3.getEntries().iterator();
    L16:
        if (r5.hasNext() == false) goto L18;
        SlotEntry r6 = (SlotEntry) r5.next();
        r6.component1().onDestroy(r6.component2());
        goto L16
    L18:
        r3.getEntries().clear();
        r3.getContainer().removeAllViews();
        this.sections.remove(r3);
        return;
    L26:
        return;
    L8:
        r2 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }
}
