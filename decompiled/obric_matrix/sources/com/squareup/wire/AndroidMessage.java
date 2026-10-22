package com.squareup.wire;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import java.lang.reflect.Array;
import k.h;
import kotlin.Metadata;
import kotlin.b0;
import kotlin.n0.a;
import kotlin.n0.d.g;
import kotlin.n0.d.o;
import kotlin.s0.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 \u0015*\u0014\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001*\u0014\b\u0001\u0010\u0004*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00012\u00020\u0005:\u0002\u0015\u0016B\u001f\b\u0004\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/squareup/wire/AndroidMessage;", "Lcom/squareup/wire/Message;", "M", "Lcom/squareup/wire/Message$Builder;", "B", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "dest", "", "flags", "Lkotlin/f0;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "Lcom/squareup/wire/ProtoAdapter;", "adapter", "Lk/h;", "unknownFields", "<init>", "(Lcom/squareup/wire/ProtoAdapter;Lk/h;)V", "Companion", "ProtoAdapterCreator", "wire-runtime"}, k = 1, mv = {1, 1, 15})
public abstract class AndroidMessage<M extends Message<M, B>, B extends Message.Builder<M, B>> extends Message<M, B> implements Parcelable {
    public static final Companion Companion = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ)\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00020\u0005\"\u0004\b\u0002\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/squareup/wire/AndroidMessage$Companion;", "", "E", "Lcom/squareup/wire/ProtoAdapter;", "adapter", "Landroid/os/Parcelable$Creator;", "newCreator", "(Lcom/squareup/wire/ProtoAdapter;)Landroid/os/Parcelable$Creator;", "<init>", "()V", "wire-runtime"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g r1) {
            this();
        }

        public final <E> Parcelable.Creator<E> newCreator(ProtoAdapter<E> r1) {
            o.g(r1, "adapter");
            return new ProtoAdapterCreator(r1);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u00028\u00020\u0002B\u0017\b\u0000\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00028\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/squareup/wire/AndroidMessage$ProtoAdapterCreator;", "M", "Landroid/os/Parcelable$Creator;", "Landroid/os/Parcel;", "input", "createFromParcel", "(Landroid/os/Parcel;)Ljava/lang/Object;", "", "size", "", "newArray", "(I)[Ljava/lang/Object;", "Lcom/squareup/wire/ProtoAdapter;", "adapter", "Lcom/squareup/wire/ProtoAdapter;", "<init>", "(Lcom/squareup/wire/ProtoAdapter;)V", "wire-runtime"}, k = 1, mv = {1, 1, 15})
    private static final class ProtoAdapterCreator<M> implements Parcelable.Creator<M> {
        private final ProtoAdapter<M> adapter;

        public ProtoAdapterCreator(ProtoAdapter<M> r2) {
            o.g(r2, "adapter");
            this.adapter = r2;
        }

        @Override // android.os.Parcelable.Creator
        public M createFromParcel(Parcel r2) {
            o.g(r2, "input");
            ProtoAdapter<M> r1 = this.adapter;
            byte[] r3 = r2.createByteArray();
            o.b(r3, "input.createByteArray()");
            return r1.decode(r3);
        }

        @Override // android.os.Parcelable.Creator
        public M[] newArray(int r1) {
            d<?> r0 = this.adapter.getType();
            if (r0 == null) goto L5;
            Class r2 = a.c(r0);
        L6:
            Object r3 = Array.newInstance(r2, r1);
            if (r3 == null) goto L11;
            return (M[]) ((Object[]) r3);
        L11:
            throw new b0("null cannot be cast to non-null type kotlin.Array<M>");
        L5:
            r2 = null;
            goto L6
        }
    }

    static {
        Companion = new Companion(null);
    }

    protected AndroidMessage(ProtoAdapter<M> r2, h r3) {
        o.g(r2, "adapter");
        o.g(r3, "unknownFields");
        super(r2, r3);
    }

    public static final <E> Parcelable.Creator<E> newCreator(ProtoAdapter<E> r1) {
        return Companion.newCreator(r1);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.g(r1, "dest");
        r1.writeByteArray(encode());
    }
}
