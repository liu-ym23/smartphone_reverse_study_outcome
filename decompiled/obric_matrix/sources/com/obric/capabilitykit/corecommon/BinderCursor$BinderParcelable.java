package com.obric.capabilitykit.corecommon;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\rH\u0016R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0004¨\u0006\u0013"}, d2 = {"Lcom/obric/capabilitykit/corecommon/BinderCursor$BinderParcelable;", "Landroid/os/Parcelable;", "binder", "Landroid/os/IBinder;", "(Landroid/os/IBinder;)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "mBinder", "getMBinder", "()Landroid/os/IBinder;", "setMBinder", "describeContents", "", "writeToParcel", "", "dest", "flags", "Companion", "capabilitykitcorecommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BinderCursor$BinderParcelable implements Parcelable {
    public static final Parcelable.Creator<BinderCursor$BinderParcelable> CREATOR = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private IBinder f8100f;

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"com/obric/capabilitykit/corecommon/BinderCursor$BinderParcelable$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/corecommon/BinderCursor$BinderParcelable;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/capabilitykit/corecommon/BinderCursor$BinderParcelable;", "capabilitykitcorecommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<BinderCursor$BinderParcelable> {
        a() {
        }

        public BinderCursor$BinderParcelable a(Parcel r1) {
            o.f(r1, "source");
            return new BinderCursor$BinderParcelable(r1);
        }

        public BinderCursor$BinderParcelable[] b(int r1) {
            return new BinderCursor$BinderParcelable[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ BinderCursor$BinderParcelable createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ BinderCursor$BinderParcelable[] newArray(int r1) {
            return b(r1);
        }
    }

    static {
        CREATOR = new a();
    }

    public BinderCursor$BinderParcelable(Parcel r2) {
        o.f(r2, "source");
        IBinder r3 = r2.readStrongBinder();
        o.e(r3, "source.readStrongBinder()");
        this.f8100f = r3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.f(r1, "dest");
        r1.writeStrongBinder(this.f8100f);
    }
}
