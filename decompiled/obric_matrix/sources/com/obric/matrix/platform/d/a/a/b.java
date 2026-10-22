package com.obric.matrix.platform.d.a.a;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface b extends IInterface {

    public static abstract class a extends Binder implements b {
        public a() {
            attachInterface(this, "com.obric.matrix.platform.sdk.ones.account.IAccountService");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 == 1598968902) goto L32;
            PendingIntent r0 = null;
            Bundle r1 = null;
            switch(r4) {
                case 1: goto L28;
                case 2: goto L27;
                case 3: goto L26;
                case 4: goto L25;
                case 5: goto L24;
                case 6: goto L20;
                case 7: goto L19;
                case 8: goto L18;
                case 9: goto L17;
                case 10: goto L16;
                case 11: goto L15;
                case 12: goto L14;
                case 13: goto L13;
                case 14: goto L12;
                case 15: goto L11;
                case 16: goto L8;
                default: goto L7;
            };
        L8:
            r5.enforceInterface("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            V(r5.readString(), r5.readString(), com.obric.matrix.platform.d.a.a.a.AbstractBinderC0256a.a(r5.readStrongBinder()));
        L9:
            r6.writeNoException();
            return true;
        L11:
            r5.enforceInterface("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            X(r5.readString(), r5.readString(), com.obric.matrix.platform.d.a.a.a.AbstractBinderC0256a.a(r5.readStrongBinder()));
            goto L9
        L12:
            r5.enforceInterface("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            Z(r5.readString(), r5.readString(), r5.readString(), com.obric.matrix.platform.d.a.a.a.AbstractBinderC0256a.a(r5.readStrongBinder()));
            goto L9
        L13:
            r5.enforceInterface("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            j(r5.readString(), r5.readString(), com.obric.matrix.platform.d.a.a.a.AbstractBinderC0256a.a(r5.readStrongBinder()));
            goto L9
        L14:
            r5.enforceInterface("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            M(r5.readString(), com.obric.matrix.platform.d.a.a.a.AbstractBinderC0256a.a(r5.readStrongBinder()));
            goto L9
        L15:
            r5.enforceInterface("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            w(r5.readString(), com.obric.matrix.platform.d.a.a.a.AbstractBinderC0256a.a(r5.readStrongBinder()));
            goto L9
        L16:
            r5.enforceInterface("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            P(r5.readString(), r5.readString(), com.obric.matrix.platform.d.a.a.a.AbstractBinderC0256a.a(r5.readStrongBinder()));
            goto L9
        L17:
            r5.enforceInterface("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            N(r5.readString(), r5.readString(), r5.readInt(), com.obric.matrix.platform.d.a.a.a.AbstractBinderC0256a.a(r5.readStrongBinder()));
            goto L9
        L18:
            r5.enforceInterface("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            T(r5.readString(), r5.readString(), com.obric.matrix.platform.d.a.a.a.AbstractBinderC0256a.a(r5.readStrongBinder()));
            goto L9
        L19:
            r5.enforceInterface("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            q(r5.readString(), com.obric.matrix.platform.d.a.a.a.AbstractBinderC0256a.a(r5.readStrongBinder()));
            goto L9
        L20:
            r5.enforceInterface("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            if (r5.readInt() == 0) goto L23;
            r1 = (Bundle) Bundle.CREATOR.createFromParcel(r5);
        L23:
            x(r1, r5.readString(), com.obric.matrix.platform.d.a.a.a.AbstractBinderC0256a.a(r5.readStrongBinder()));
            goto L9
        L24:
            r5.enforceInterface("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            S(r5.readString(), r5.readString(), com.obric.matrix.platform.d.a.a.a.AbstractBinderC0256a.a(r5.readStrongBinder()));
            goto L9
        L25:
            r5.enforceInterface("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            y(r5.readString(), r5.readInt(), com.obric.matrix.platform.d.a.a.a.AbstractBinderC0256a.a(r5.readStrongBinder()));
            goto L9
        L26:
            r5.enforceInterface("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            forceUpdateAccount();
            goto L9
        L27:
            r5.enforceInterface("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            c0(com.obric.matrix.platform.d.a.a.a.AbstractBinderC0256a.a(r5.readStrongBinder()));
            goto L9
        L28:
            r5.enforceInterface("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            if (r5.readInt() == 0) goto L31;
            r0 = (PendingIntent) PendingIntent.CREATOR.createFromParcel(r5);
        L31:
            v(r0);
            goto L9
        L7:
            return super.onTransact(r4, r5, r6, r7);
        L32:
            r6.writeString("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            return true;
        }
    }

    void M(String r1, com.obric.matrix.platform.d.a.a.a r2);

    void N(String r1, String r2, int r3, com.obric.matrix.platform.d.a.a.a r4);

    void P(String r1, String r2, com.obric.matrix.platform.d.a.a.a r3);

    void S(String r1, String r2, com.obric.matrix.platform.d.a.a.a r3);

    void T(String r1, String r2, com.obric.matrix.platform.d.a.a.a r3);

    void V(String r1, String r2, com.obric.matrix.platform.d.a.a.a r3);

    void X(String r1, String r2, com.obric.matrix.platform.d.a.a.a r3);

    void Z(String r1, String r2, String r3, com.obric.matrix.platform.d.a.a.a r4);

    void c0(com.obric.matrix.platform.d.a.a.a r1);

    void forceUpdateAccount();

    void j(String r1, String r2, com.obric.matrix.platform.d.a.a.a r3);

    void q(String r1, com.obric.matrix.platform.d.a.a.a r2);

    void v(PendingIntent r1);

    void w(String r1, com.obric.matrix.platform.d.a.a.a r2);

    void x(Bundle r1, String r2, com.obric.matrix.platform.d.a.a.a r3);

    void y(String r1, int r2, com.obric.matrix.platform.d.a.a.a r3);
}
