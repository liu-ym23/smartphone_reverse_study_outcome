package android.support.v4.os;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ResultReceiver implements Parcelable {
    public static final Parcelable.Creator<ResultReceiver> CREATOR = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final boolean f215f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final Handler f216g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    android.support.v4.os.a f217h;

    class a implements Parcelable.Creator<ResultReceiver> {
        a() {
        }

        public ResultReceiver a(Parcel r1) {
            return new ResultReceiver(r1);
        }

        public ResultReceiver[] b(int r1) {
            return new ResultReceiver[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ResultReceiver createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ResultReceiver[] newArray(int r1) {
            return b(r1);
        }
    }

    class b extends android.support.v4.os.a.AbstractBinderC0013a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ ResultReceiver f218f;

        b(ResultReceiver r1) {
            this.f218f = r1;
        }

        @Override // android.support.v4.os.a
        public void h0(int r3, Bundle r4) {
            ResultReceiver r2 = this.f218f;
            Handler r0 = r2.f216g;
            if (r0 == null) goto L5;
            r0.post(new c(r2, r3, r4));
            return;
        L5:
            r2.b(r3, r4);
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final int f219f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final Bundle f220g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ ResultReceiver f221h;

        c(ResultReceiver r1, int r2, Bundle r3) {
            this.f221h = r1;
            this.f219f = r2;
            this.f220g = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f221h.b(this.f219f, this.f220g);
        }
    }

    static {
        CREATOR = new a();
    }

    ResultReceiver(Parcel r2) {
        this.f215f = false;
        this.f216g = null;
        this.f217h = android.support.v4.os.a.AbstractBinderC0013a.a(r2.readStrongBinder());
    }

    protected void b(int r1, Bundle r2) {
    }

    public void d(int r3, Bundle r4) {
        if (this.f215f == false) goto L9;
        Handler r0 = this.f216g;
        if (r0 == null) goto L7;
        r0.post(new c(this, r3, r4));
        return;
    L7:
        b(r3, r4);
        return;
    L9:
        android.support.v4.os.a r2 = this.f217h;
        if (r2 == null) goto L17;
        r2.h0(r3, r4);     // Catch: RemoteException -> L13
        return;
    L18:
        return;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel r1, int r2) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f217h != null) goto L6;
        this.f217h = new b(this);     // Catch: Throwable -> L9
    L6:
        r1.writeStrongBinder(this.f217h.asBinder());     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
    }
}
