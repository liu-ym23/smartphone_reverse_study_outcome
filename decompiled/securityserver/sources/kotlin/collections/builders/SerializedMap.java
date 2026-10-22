package kotlin.collections.builders;

import a.a;
import java.io.Externalizable;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class SerializedMap implements Externalizable {
    public Map b;

    @Metadata
    public static final class Companion {
    }

    public SerializedMap() {
        this.b = MapsKt.b();
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput r6) {
        Intrinsics.f(r6, "input");
        byte r0 = r6.readByte();
        if (r0 != 0) goto L14;
        int r1 = r6.readInt();
        if (r1 < 0) goto L12;
        MapBuilder r2 = new MapBuilder(r1);
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L9;
        r2.put(r6.readObject(), r6.readObject());
        r3 = r3 + 1;
        goto L7
    L9:
        r2.b();
        r2.p = true;
        this.b = r2;
        return;
    L12:
        throw new InvalidObjectException("Illegal size value: " + r1 + '.');
    L14:
        throw new InvalidObjectException(a.e(r0, "Unsupported flags value: "));
    }

    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput r3) {
        Intrinsics.f(r3, "output");
        r3.writeByte(0);
        r3.writeInt(this.b.size());
        Iterator r2 = this.b.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        Map.Entry r0 = (Map.Entry) r2.next();
        r3.writeObject(r0.getKey());
        r3.writeObject(r0.getValue());
        goto L4
    }
}
