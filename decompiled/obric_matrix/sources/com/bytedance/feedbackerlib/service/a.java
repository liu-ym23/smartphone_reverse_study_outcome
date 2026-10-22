package com.bytedance.feedbackerlib.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.bytedance.feedbackerlib.service.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0145a extends Binder implements a {

        /* JADX INFO: renamed from: com.bytedance.feedbackerlib.service.a$a$a, reason: collision with other inner class name */
        private static class C0146a implements a {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static a f4663g;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private IBinder f4664f;

            C0146a(IBinder r1) {
                this.f4664f = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f4664f;
            }

            @Override // com.bytedance.feedbackerlib.service.a
            public void b() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.bytedance.feedbackerlib.service.IFeedbackCommonInfo");     // Catch: Throwable -> L13
                if (this.f4664f.transact(8, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (AbstractBinderC0145a.k0() == null) goto L10;
                AbstractBinderC0145a.k0().b();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.feedbackerlib.service.a
            public void f() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.bytedance.feedbackerlib.service.IFeedbackCommonInfo");     // Catch: Throwable -> L13
                if (this.f4664f.transact(9, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (AbstractBinderC0145a.k0() == null) goto L10;
                AbstractBinderC0145a.k0().f();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.feedbackerlib.service.a
            public String getALogFilesDir() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.bytedance.feedbackerlib.service.IFeedbackCommonInfo");     // Catch: Throwable -> L13
                if (this.f4664f.transact(6, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r4 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (AbstractBinderC0145a.k0() == null) goto L10;
                String r5 = AbstractBinderC0145a.k0().getALogFilesDir();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.feedbackerlib.service.a
            public int getAid() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.bytedance.feedbackerlib.service.IFeedbackCommonInfo");     // Catch: Throwable -> L13
                if (this.f4664f.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (AbstractBinderC0145a.k0() == null) goto L10;
                int r5 = AbstractBinderC0145a.k0().getAid();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.feedbackerlib.service.a
            public String getAppId() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.bytedance.feedbackerlib.service.IFeedbackCommonInfo");     // Catch: Throwable -> L13
                if (this.f4664f.transact(2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r4 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (AbstractBinderC0145a.k0() == null) goto L10;
                String r5 = AbstractBinderC0145a.k0().getAppId();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.feedbackerlib.service.a
            public String getChannel() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.bytedance.feedbackerlib.service.IFeedbackCommonInfo");     // Catch: Throwable -> L13
                if (this.f4664f.transact(5, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r4 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (AbstractBinderC0145a.k0() == null) goto L10;
                String r5 = AbstractBinderC0145a.k0().getChannel();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.feedbackerlib.service.a
            public String getDid() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.bytedance.feedbackerlib.service.IFeedbackCommonInfo");     // Catch: Throwable -> L13
                if (this.f4664f.transact(3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r4 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (AbstractBinderC0145a.k0() == null) goto L10;
                String r5 = AbstractBinderC0145a.k0().getDid();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.feedbackerlib.service.a
            public String getUpdateVersionCode() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.bytedance.feedbackerlib.service.IFeedbackCommonInfo");     // Catch: Throwable -> L13
                if (this.f4664f.transact(4, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r4 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (AbstractBinderC0145a.k0() == null) goto L10;
                String r5 = AbstractBinderC0145a.k0().getUpdateVersionCode();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.feedbackerlib.service.a
            public String getUserId() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.bytedance.feedbackerlib.service.IFeedbackCommonInfo");     // Catch: Throwable -> L13
                if (this.f4664f.transact(7, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r4 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (AbstractBinderC0145a.k0() == null) goto L10;
                String r5 = AbstractBinderC0145a.k0().getUserId();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public AbstractBinderC0145a() {
            attachInterface(this, "com.bytedance.feedbackerlib.service.IFeedbackCommonInfo");
        }

        public static a j0(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface("com.bytedance.feedbackerlib.service.IFeedbackCommonInfo");
            if (r0 == null) goto L12;
            if ((r0 instanceof a) == false) goto L12;
            return (a) r0;
        L12:
            return new C0146a(r2);
        }

        public static a k0() {
            return C0146a.f4663g;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 == 1598968902) goto L25;
            switch(r4) {
                case 1: goto L23;
                case 2: goto L21;
                case 3: goto L19;
                case 4: goto L17;
                case 5: goto L15;
                case 6: goto L13;
                case 7: goto L11;
                case 8: goto L9;
                case 9: goto L7;
                default: goto L6;
            };
        L7:
            r5.enforceInterface("com.bytedance.feedbackerlib.service.IFeedbackCommonInfo");
            f();
            r6.writeNoException();
            return true;
        L9:
            r5.enforceInterface("com.bytedance.feedbackerlib.service.IFeedbackCommonInfo");
            b();
            r6.writeNoException();
            return true;
        L11:
            r5.enforceInterface("com.bytedance.feedbackerlib.service.IFeedbackCommonInfo");
            String r3 = getUserId();
            r6.writeNoException();
            r6.writeString(r3);
            return true;
        L13:
            r5.enforceInterface("com.bytedance.feedbackerlib.service.IFeedbackCommonInfo");
            String r8 = getALogFilesDir();
            r6.writeNoException();
            r6.writeString(r8);
            return true;
        L15:
            r5.enforceInterface("com.bytedance.feedbackerlib.service.IFeedbackCommonInfo");
            String r9 = getChannel();
            r6.writeNoException();
            r6.writeString(r9);
            return true;
        L17:
            r5.enforceInterface("com.bytedance.feedbackerlib.service.IFeedbackCommonInfo");
            String r10 = getUpdateVersionCode();
            r6.writeNoException();
            r6.writeString(r10);
            return true;
        L19:
            r5.enforceInterface("com.bytedance.feedbackerlib.service.IFeedbackCommonInfo");
            String r11 = getDid();
            r6.writeNoException();
            r6.writeString(r11);
            return true;
        L21:
            r5.enforceInterface("com.bytedance.feedbackerlib.service.IFeedbackCommonInfo");
            String r12 = getAppId();
            r6.writeNoException();
            r6.writeString(r12);
            return true;
        L23:
            r5.enforceInterface("com.bytedance.feedbackerlib.service.IFeedbackCommonInfo");
            int r13 = getAid();
            r6.writeNoException();
            r6.writeInt(r13);
            return true;
        L6:
            return super.onTransact(r4, r5, r6, r7);
        L25:
            r6.writeString("com.bytedance.feedbackerlib.service.IFeedbackCommonInfo");
            return true;
        }
    }

    void b();

    void f();

    String getALogFilesDir();

    int getAid();

    String getAppId();

    String getChannel();

    String getDid();

    String getUpdateVersionCode();

    String getUserId();
}
