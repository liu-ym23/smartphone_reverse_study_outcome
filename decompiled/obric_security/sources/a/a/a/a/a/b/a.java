package a.a.a.a.a.b;

import a.a.a.a.a.c.c;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.obric.matrix.push.common.cross_process.CrossProcessService;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: a.a.a.a.a.b.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0000a extends Binder implements a {

        /* JADX INFO: renamed from: a.a.a.a.a.b.a$a$a, reason: collision with other inner class name */
        public static class C0001a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f6a;

            public C0001a(IBinder r1) {
                this.f6a = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f6a;
            }
        }

        public AbstractBinderC0000a() {
            attachInterface(this, "com.obric.matrix.push.common.cross_process.ICrossProcessCallbackInterface");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface("com.obric.matrix.push.common.cross_process.ICrossProcessCallbackInterface");
            ArrayList r8 = r5.readArrayList(getClass().getClassLoader());
            CrossProcessService.b r3 = (CrossProcessService.b) this;
            c.a(CrossProcessService.access$getTAG$p(r3.f14a), "on " + r3.b + " callback");
            a.a.a.a.a.b.c.a r9 = r3.c;     // Catch: Exception -> L15
            if (r9 == null) goto L17;
            r9.a(r8);     // Catch: Exception -> L15
        L17:
            r6.writeNoException();
            return true;
        L15:
            e = move-exception;
            c.a(CrossProcessService.access$getTAG$p(r3.f14a), "on " + r3.b + " onCallback error", e);
            goto L17
        L5:
            if (r4 != 1598968902) goto L7;
            r6.writeString("com.obric.matrix.push.common.cross_process.ICrossProcessCallbackInterface");
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        }
    }
}
