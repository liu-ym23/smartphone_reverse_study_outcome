package com.obric.capabilitykit.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.obric.capabilitykit.common.execution.JobResult;
import com.obric.capabilitykit.common.intent.IntentResult;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public interface ICapabilityFeedbackReceiver extends IInterface {

    public static class Default implements ICapabilityFeedbackReceiver {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
        public boolean isCardViewVisible(long r1) throws RemoteException {
            return false;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
        public boolean isKeyguardReallyLocked() throws RemoteException {
            return false;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
        public void onActionResultRecv(String r1, String r2, boolean r3) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
        public void onFinishFloatingActivity(long r1) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
        public void onHideIntentResultCard(long r1) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
        public void onJobResultRecv(String r1, String r2, boolean r3, JobResult r4) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
        public void onUpdateIntentResult(long r1, IntentResult r3, boolean r4, Map r5) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
        public void onUpdateIntentResultWithRequest(String r1, IntentResult r2, boolean r3, Map r4) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICapabilityFeedbackReceiver {
        private static final String DESCRIPTOR = "com.obric.capabilitykit.common.ICapabilityFeedbackReceiver";
        public static final int TRANSACTION_isCardViewVisible = 6;
        public static final int TRANSACTION_isKeyguardReallyLocked = 7;
        public static final int TRANSACTION_onActionResultRecv = 1;
        public static final int TRANSACTION_onFinishFloatingActivity = 5;
        public static final int TRANSACTION_onHideIntentResultCard = 3;
        public static final int TRANSACTION_onJobResultRecv = 4;
        public static final int TRANSACTION_onUpdateIntentResult = 2;
        public static final int TRANSACTION_onUpdateIntentResultWithRequest = 8;

        public static class Proxy implements ICapabilityFeedbackReceiver {
            public static ICapabilityFeedbackReceiver sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
            public boolean isCardViewVisible(long r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeLong(r5);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(6, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r3 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r4 = Stub.getDefaultImpl().isCardViewVisible(r5);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
            public boolean isKeyguardReallyLocked() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(7, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r3 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r4 = Stub.getDefaultImpl().isKeyguardReallyLocked();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
            public void onActionResultRecv(String r4, String r5, boolean r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r4);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                r0.writeInt(r6 ? 1 : 0);     // Catch: Throwable -> L12
                if (this.mRemote.transact(1, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onActionResultRecv(r4, r5, r6);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
            public void onFinishFloatingActivity(long r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeLong(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(5, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onFinishFloatingActivity(r5);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
            public void onHideIntentResultCard(long r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeLong(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(3, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onHideIntentResultCard(r5);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
            public void onJobResultRecv(String r5, String r6, boolean r7, JobResult r8) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeString(r5);     // Catch: Throwable -> L16
                r0.writeString(r6);     // Catch: Throwable -> L16
                r0.writeInt(r7 ? 1 : 0);     // Catch: Throwable -> L16
                if (r8 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r8.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(4, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onJobResultRecv(r5, r6, r7, r8);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
            public void onUpdateIntentResult(long r8, IntentResult r10, boolean r11, Map r12) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeLong(r8);     // Catch: Throwable -> L16
                if (r10 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r10.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L7:
                r0.writeInt(r11 ? 1 : 0);     // Catch: Throwable -> L16
                r0.writeMap(r12);     // Catch: Throwable -> L16
                if (this.mRemote.transact(2, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onUpdateIntentResult(r8, r10, r11, r12);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
            public void onUpdateIntentResultWithRequest(String r5, IntentResult r6, boolean r7, Map r8) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeString(r5);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L7:
                r0.writeInt(r7 ? 1 : 0);     // Catch: Throwable -> L16
                r0.writeMap(r8);     // Catch: Throwable -> L16
                if (this.mRemote.transact(8, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onUpdateIntentResultWithRequest(r5, r6, r7, r8);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICapabilityFeedbackReceiver asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICapabilityFeedbackReceiver) == false) goto L12;
            return (ICapabilityFeedbackReceiver) r0;
        L12:
            return new Proxy(r2);
        }

        public static ICapabilityFeedbackReceiver getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICapabilityFeedbackReceiver r1) {
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r1 == null) goto L9;
            Proxy.sDefaultImpl = r1;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r9, Parcel r10, Parcel r11, int r12) throws RemoteException {
            if (r9 == 1598968902) goto L46;
            IntentResult<?> r0 = null;
            IntentResult<?> r1 = null;
            JobResult r2 = null;
            boolean r3 = false;
            switch(r9) {
                case 1: goto L41;
                case 2: goto L32;
                case 3: goto L30;
                case 4: goto L22;
                case 5: goto L20;
                case 6: goto L18;
                case 7: goto L16;
                case 8: goto L8;
                default: goto L7;
            };
        L8:
            r10.enforceInterface(DESCRIPTOR);
            String r13 = r10.readString();
            if (r10.readInt() == 0) goto L12;
            r1 = IntentResult.CREATOR.a(r10);
        L12:
            if (r10.readInt() == 0) goto L14;
            r3 = true;
        L14:
            onUpdateIntentResultWithRequest(r13, r1, r3, r10.readHashMap(getClass().getClassLoader()));
            return true;
        L16:
            r10.enforceInterface(DESCRIPTOR);
            boolean r8 = isKeyguardReallyLocked();
            r11.writeNoException();
            r11.writeInt(r8 ? 1 : 0);
            return true;
        L18:
            r10.enforceInterface(DESCRIPTOR);
            boolean r14 = isCardViewVisible(r10.readLong());
            r11.writeNoException();
            r11.writeInt(r14 ? 1 : 0);
            return true;
        L20:
            r10.enforceInterface(DESCRIPTOR);
            onFinishFloatingActivity(r10.readLong());
            return true;
        L22:
            r10.enforceInterface(DESCRIPTOR);
            String r15 = r10.readString();
            String r16 = r10.readString();
            if (r10.readInt() == 0) goto L26;
            r3 = true;
        L26:
            if (r10.readInt() == 0) goto L28;
            r2 = JobResult.CREATOR.createFromParcel(r10);
        L28:
            onJobResultRecv(r15, r16, r3, r2);
            return true;
        L30:
            r10.enforceInterface(DESCRIPTOR);
            onHideIntentResultCard(r10.readLong());
            return true;
        L32:
            r10.enforceInterface(DESCRIPTOR);
            long r17 = r10.readLong();
            if (r10.readInt() == 0) goto L35;
            r0 = IntentResult.CREATOR.a(r10);
        L35:
            IntentResult<?> r5 = r0;
            if (r10.readInt() == 0) goto L38;
            boolean r6 = true;
        L39:
            onUpdateIntentResult(r17, r5, r6, r10.readHashMap(getClass().getClassLoader()));
            return true;
        L38:
            r6 = false;
            goto L39
        L41:
            r10.enforceInterface(DESCRIPTOR);
            String r18 = r10.readString();
            String r19 = r10.readString();
            if (r10.readInt() == 0) goto L44;
            r3 = true;
        L44:
            onActionResultRecv(r18, r19, r3);
            return true;
        L7:
            return super.onTransact(r9, r10, r11, r12);
        L46:
            r11.writeString(DESCRIPTOR);
            return true;
        }
    }

    boolean isCardViewVisible(long r1) throws RemoteException;

    boolean isKeyguardReallyLocked() throws RemoteException;

    void onActionResultRecv(String r1, String r2, boolean r3) throws RemoteException;

    void onFinishFloatingActivity(long r1) throws RemoteException;

    void onHideIntentResultCard(long r1) throws RemoteException;

    void onJobResultRecv(String r1, String r2, boolean r3, JobResult r4) throws RemoteException;

    void onUpdateIntentResult(long r1, IntentResult r3, boolean r4, Map r5) throws RemoteException;

    void onUpdateIntentResultWithRequest(String r1, IntentResult r2, boolean r3, Map r4) throws RemoteException;
}
