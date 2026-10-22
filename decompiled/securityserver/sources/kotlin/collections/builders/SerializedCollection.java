package kotlin.collections.builders;

import java.io.Externalizable;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class SerializedCollection implements Externalizable {
    public Collection b;
    public final int c;

    @Metadata
    public static final class Companion {
    }

    public SerializedCollection() {
        this.b = EmptyList.b;
        this.c = 0;
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput r13) {
        Intrinsics.f(r13, "input");
        byte r0 = r13.readByte();
        int r1 = r0 & 1;
        if ((r0 & (-2)) != 0) goto L32;
        int r2 = r13.readInt();
        if (r2 < 0) goto L30;
        int r4 = 0;
        if (r1 == 0) goto L16;
        if (r1 != 1) goto L14;
        SetBuilder r3 = new SetBuilder(r2);
    L10:
        if (r4 >= r2) goto L12;
        r3.add(r13.readObject());
        r4 = r4 + 1;
        goto L10
    L12:
        MapBuilder r14 = r3.b;
        r14.b();
        r14.p = true;
        Collection r5 = r3;
    L23:
        this.b = r5;
        return;
    L14:
        throw new InvalidObjectException("Unsupported collection type tag: " + r1 + '.');
    L16:
        if (r2 < 0) goto L28;
        ListBuilder r6 = new ListBuilder(new Object[r2], 0, 0, false, null, null);
    L18:
        if (r4 >= r2) goto L21;
        r6.add(r13.readObject());
        r4 = r4 + 1;
        goto L18
    L21:
        if (r6.i != null) goto L26;
        r6.e();
        r6.f = true;
        r5 = r6;
        goto L23
    L26:
        throw new IllegalStateException();
    L28:
        throw new IllegalArgumentException("capacity must be non-negative.".toString());
    L30:
        throw new InvalidObjectException("Illegal size value: " + r2 + '.');
    L32:
        throw new InvalidObjectException("Unsupported flags value: " + r0 + '.');
    }

    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput r2) {
        Intrinsics.f(r2, "output");
        r2.writeByte(this.c);
        r2.writeInt(this.b.size());
        Iterator r1 = this.b.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r2.writeObject(r1.next());
        goto L4
    }
}
