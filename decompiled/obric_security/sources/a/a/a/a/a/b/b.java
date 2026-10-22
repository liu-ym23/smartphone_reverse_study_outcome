package a.a.a.a.a.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.obric.matrix.sdk.push.cross_process.CrossProcessService;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface b extends IInterface {

    public static abstract class a extends Binder implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f7a = 0;

        /* JADX INFO: renamed from: a.a.a.a.a.b.b$a$a, reason: collision with other inner class name */
        public static class C0002a implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f8a;

            public C0002a(IBinder r1) {
                this.f8a = r1;
            }

            @Override // a.a.a.a.a.b.b
            public void a(String r4, String r5, List r6, a.a.a.a.a.b.a r7) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.matrix.push.common.cross_process.ICrossProcessInterface");     // Catch: Throwable -> L9
                r0.writeString(r4);     // Catch: Throwable -> L9
                r0.writeString(r5);     // Catch: Throwable -> L9
                r0.writeList(r6);     // Catch: Throwable -> L9
                r0.writeStrongBinder((a.a.a.a.a.b.a.AbstractBinderC0000a) r7);     // Catch: Throwable -> L9
                if (this.f8a.transact(1, r0, r1, 0) == true) goto L6;
                int r3 = a.f7a;     // Catch: Throwable -> L9
            L6:
                r1.readException();     // Catch: Throwable -> L9
                r1.recycle();
                r0.recycle();
                return;
            L9:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f8a;
            }
        }

        public a() {
            attachInterface(this, "com.obric.matrix.push.common.cross_process.ICrossProcessInterface");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r5, Parcel r6, Parcel r7, int r8) {
            if (r5 != 1) goto L5;
            r6.enforceInterface("com.obric.matrix.push.common.cross_process.ICrossProcessInterface");
            String r9 = r6.readString();
            String r10 = r6.readString();
            ArrayList r0 = r6.readArrayList(getClass().getClassLoader());
            IBinder r11 = r6.readStrongBinder();
            if (r11 != null) goto L13;
            a.a.a.a.a.b.a r12 = null;
        L19:
            ((CrossProcessService.a) this).a(r9, r10, r0, r12);
            r7.writeNoException();
            return true;
        L13:
            IInterface r2 = r11.queryLocalInterface("com.obric.matrix.push.common.cross_process.ICrossProcessCallbackInterface");
            if (r2 != null) goto L16;
        L18:
            r12 = new a.a.a.a.a.b.a.AbstractBinderC0000a.C0001a(r11);
            goto L19
        L16:
            if ((r2 instanceof a.a.a.a.a.b.a) == false) goto L18;
            r12 = (a.a.a.a.a.b.a) r2;
            goto L19
        L5:
            if (r5 != 1598968902) goto L7;
            r7.writeString("com.obric.matrix.push.common.cross_process.ICrossProcessInterface");
            return true;
        L7:
            return super.onTransact(r5, r6, r7, r8);
        }
    }

    void a(String r1, String r2, List r3, a.a.a.a.a.b.a r4);
}
