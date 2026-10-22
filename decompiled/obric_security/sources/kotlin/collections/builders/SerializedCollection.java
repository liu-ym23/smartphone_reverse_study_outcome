package kotlin.collections.builders;

import com.ss.android.message.log.PushLog;
import java.io.Externalizable;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ListBuilder.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0019\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkotlin/collections/builders/SerializedCollection;", "Ljava/io/Externalizable;", "()V", "collection", "", PushLog.KEY_TAG, "", "(Ljava/util/Collection;I)V", "readExternal", "", "input", "Ljava/io/ObjectInput;", "readResolve", "", "writeExternal", "output", "Ljava/io/ObjectOutput;", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SerializedCollection implements Externalizable {
    public static final Companion Companion = null;
    private static final long serialVersionUID = 0;
    public static final int tagList = 0;
    public static final int tagSet = 1;
    private Collection<?> collection;
    private final int tag;

    /* JADX INFO: compiled from: ListBuilder.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lkotlin/collections/builders/SerializedCollection$Companion;", "", "()V", "serialVersionUID", "", "tagList", "", "tagSet", "kotlin-stdlib"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public SerializedCollection(Collection<?> r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "collection");
        this.collection = r2;
        this.tag = r3;
    }

    public SerializedCollection() {
        this(CollectionsKt.emptyList(), 0);
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput r2) {
        Intrinsics.checkNotNullParameter(r2, "output");
        r2.writeByte(this.tag);
        r2.writeInt(this.collection.size());
        Iterator<?> r1 = this.collection.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r2.writeObject(r1.next());
        goto L4
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput r6) {
        Intrinsics.checkNotNullParameter(r6, "input");
        byte r0 = r6.readByte();
        int r1 = r0 & 1;
        if ((r0 & (-2)) != 0) goto L25;
        int r2 = r6.readInt();
        if (r2 < 0) goto L23;
        int r3 = 0;
        if (r1 != 0) goto L9;
        List r4 = CollectionsKt.createListBuilder(r2);
    L17:
        if (r3 >= r2) goto L19;
        r4.add(r6.readObject());
        r3 = r3 + 1;
        goto L17
    L19:
        List r7 = CollectionsKt.build(r4);
    L20:
        this.collection = r7;
        return;
    L9:
        if (r1 != 1) goto L15;
        Set r5 = SetsKt.createSetBuilder(r2);
    L11:
        if (r3 >= r2) goto L13;
        r5.add(r6.readObject());
        r3 = r3 + 1;
        goto L11
    L13:
        r7 = SetsKt.build(r5);
        goto L20
    L15:
        throw new InvalidObjectException("Unsupported collection type tag: " + r1 + '.');
    L23:
        throw new InvalidObjectException("Illegal size value: " + r2 + '.');
    L25:
        throw new InvalidObjectException("Unsupported flags value: " + r0 + '.');
    }

    private final Object readResolve() {
        return this.collection;
    }
}
