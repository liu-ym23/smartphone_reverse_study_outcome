package android.hidl.base.V1_0;

import android.icu.text.Bidi;
import android.os.HidlSupport;
import android.os.HwBinder;
import android.os.HwBlob;
import android.os.HwParcel;
import android.os.IHwBinder;
import android.os.IHwInterface;
import android.os.RemoteException;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public interface IBase extends IHwInterface {
    public static final String kInterfaceName = "android.hidl.base@1.0::IBase";

    public static final class Proxy implements IBase {
        private IHwBinder mRemote;

        public Proxy(IHwBinder r1) {
            this.mRemote = (IHwBinder) Objects.requireNonNull(r1);
        }

        @Override // android.hidl.base.V1_0.IBase
        public IHwBinder asBinder() {
            return this.mRemote;
        }

        public String toString() {
            return interfaceDescriptor() + "@Proxy";
        L4:
            return "[class or subclass of android.hidl.base@1.0::IBase]@Proxy";
        }

        public final boolean equals(Object r1) {
            return HidlSupport.interfacesEqual(this, r1);
        }

        public final int hashCode() {
            return asBinder().hashCode();
        }

        @Override // android.hidl.base.V1_0.IBase
        public ArrayList<String> interfaceChain() throws RemoteException {
            HwParcel r0 = new HwParcel();
            r0.writeInterfaceToken(IBase.kInterfaceName);
            HwParcel r1 = new HwParcel();
            this.mRemote.transact(256067662, r0, r1, 0);     // Catch: Throwable -> L6
            r1.verifySuccess();     // Catch: Throwable -> L6
            r0.releaseTemporaryStorage();     // Catch: Throwable -> L6
            ArrayList<String> r4 = r1.readStringVector();     // Catch: Throwable -> L6
            r1.release();
            return r4;
        L6:
            th = move-exception;
            r1.release();
            throw th;
        }

        @Override // android.hidl.base.V1_0.IBase
        public String interfaceDescriptor() throws RemoteException {
            HwParcel r0 = new HwParcel();
            r0.writeInterfaceToken(IBase.kInterfaceName);
            HwParcel r1 = new HwParcel();
            this.mRemote.transact(256136003, r0, r1, 0);     // Catch: Throwable -> L6
            r1.verifySuccess();     // Catch: Throwable -> L6
            r0.releaseTemporaryStorage();     // Catch: Throwable -> L6
            String r4 = r1.readString();     // Catch: Throwable -> L6
            r1.release();
            return r4;
        L6:
            th = move-exception;
            r1.release();
            throw th;
        }

        @Override // android.hidl.base.V1_0.IBase
        public ArrayList<byte[]> getHashChain() throws RemoteException {
            HwParcel r0 = new HwParcel();
            r0.writeInterfaceToken(IBase.kInterfaceName);
            HwParcel r1 = new HwParcel();
            int r10 = 0;
            this.mRemote.transact(256398152, r0, r1, 0);     // Catch: Throwable -> L9
            r1.verifySuccess();     // Catch: Throwable -> L9
            r0.releaseTemporaryStorage();     // Catch: Throwable -> L9
            ArrayList<byte[]> r12 = new ArrayList();     // Catch: Throwable -> L9
            HwBlob r2 = r1.readBuffer(16);     // Catch: Throwable -> L9
            int r11 = r2.getInt32(8);     // Catch: Throwable -> L9
            HwBlob r3 = r1.readEmbeddedBuffer(r11 * 32, r2.handle(), 0, true);     // Catch: Throwable -> L9
            r12.clear();     // Catch: Throwable -> L9
        L4:
            if (r10 >= r11) goto L7;
            byte[] r4 = new byte[32];     // Catch: Throwable -> L9
            r3.copyToInt8Array(r10 * 32, r4, 32);     // Catch: Throwable -> L9
            r12.add(r4);     // Catch: Throwable -> L9
            r10 = r10 + 1;
            goto L4
        L7:
            r1.release();
            return r12;
        L9:
            th = move-exception;
            r1.release();
            throw th;
        }

        @Override // android.hidl.base.V1_0.IBase
        public void setHALInstrumentation() throws RemoteException {
            HwParcel r0 = new HwParcel();
            r0.writeInterfaceToken(IBase.kInterfaceName);
            HwParcel r1 = new HwParcel();
            this.mRemote.transact(256462420, r0, r1, 1);     // Catch: Throwable -> L6
            r0.releaseTemporaryStorage();     // Catch: Throwable -> L6
            r1.release();
            return;
        L6:
            th = move-exception;
            r1.release();
            throw th;
        }

        @Override // android.hidl.base.V1_0.IBase
        public boolean linkToDeath(IHwBinder.DeathRecipient r1, long r2) throws RemoteException {
            return this.mRemote.linkToDeath(r1, r2);
        }

        @Override // android.hidl.base.V1_0.IBase
        public void ping() throws RemoteException {
            HwParcel r0 = new HwParcel();
            r0.writeInterfaceToken(IBase.kInterfaceName);
            HwParcel r1 = new HwParcel();
            this.mRemote.transact(256921159, r0, r1, 0);     // Catch: Throwable -> L6
            r1.verifySuccess();     // Catch: Throwable -> L6
            r0.releaseTemporaryStorage();     // Catch: Throwable -> L6
            r1.release();
            return;
        L6:
            th = move-exception;
            r1.release();
            throw th;
        }

        @Override // android.hidl.base.V1_0.IBase
        public DebugInfo getDebugInfo() throws RemoteException {
            HwParcel r0 = new HwParcel();
            r0.writeInterfaceToken(IBase.kInterfaceName);
            HwParcel r1 = new HwParcel();
            this.mRemote.transact(257049926, r0, r1, 0);     // Catch: Throwable -> L6
            r1.verifySuccess();     // Catch: Throwable -> L6
            r0.releaseTemporaryStorage();     // Catch: Throwable -> L6
            DebugInfo r4 = new DebugInfo();     // Catch: Throwable -> L6
            r4.readFromParcel(r1);     // Catch: Throwable -> L6
            r1.release();
            return r4;
        L6:
            th = move-exception;
            r1.release();
            throw th;
        }

        @Override // android.hidl.base.V1_0.IBase
        public void notifySyspropsChanged() throws RemoteException {
            HwParcel r0 = new HwParcel();
            r0.writeInterfaceToken(IBase.kInterfaceName);
            HwParcel r1 = new HwParcel();
            this.mRemote.transact(257120595, r0, r1, 1);     // Catch: Throwable -> L6
            r0.releaseTemporaryStorage();     // Catch: Throwable -> L6
            r1.release();
            return;
        L6:
            th = move-exception;
            r1.release();
            throw th;
        }

        @Override // android.hidl.base.V1_0.IBase
        public boolean unlinkToDeath(IHwBinder.DeathRecipient r1) throws RemoteException {
            return this.mRemote.unlinkToDeath(r1);
        }
    }

    public static abstract class Stub extends HwBinder implements IBase {
        @Override // android.hidl.base.V1_0.IBase
        public IHwBinder asBinder() {
            return this;
        }

        @Override // android.hidl.base.V1_0.IBase
        public final String interfaceDescriptor() {
            return IBase.kInterfaceName;
        }

        @Override // android.hidl.base.V1_0.IBase
        public final boolean linkToDeath(IHwBinder.DeathRecipient r1, long r2) {
            return true;
        }

        @Override // android.hidl.base.V1_0.IBase
        public final void ping() {
        }

        @Override // android.hidl.base.V1_0.IBase
        public final void setHALInstrumentation() {
        }

        @Override // android.hidl.base.V1_0.IBase
        public final boolean unlinkToDeath(IHwBinder.DeathRecipient r1) {
            return true;
        }

        public Stub() {
        }

        @Override // android.hidl.base.V1_0.IBase
        public final ArrayList<String> interfaceChain() {
            return new ArrayList(Arrays.asList(new String[]{IBase.kInterfaceName}));
        }

        @Override // android.hidl.base.V1_0.IBase
        public final ArrayList<byte[]> getHashChain() {
            return new ArrayList(Arrays.asList(new byte[][]{new byte[]{-67, -38, -74, 24, 77, 122, 52, 109, -90, -96, Bidi.MAX_EXPLICIT_LEVEL, -64, -126, -116, -15, -102, 105, 111, 76, -86, 54, 17, -59, Ascii.US, 46, 20, 86, 90, 20, -76, 15, -39}}));
        }

        @Override // android.hidl.base.V1_0.IBase
        public final DebugInfo getDebugInfo() {
            DebugInfo r2 = new DebugInfo();
            r2.pid = HidlSupport.getPidIfSharable();
            r2.ptr = 0;
            r2.arch = 0;
            return r2;
        }

        @Override // android.hidl.base.V1_0.IBase
        public final void notifySyspropsChanged() {
            HwBinder.enableInstrumentation();
        }

        public IHwInterface queryLocalInterface(String r2) {
            if (IBase.kInterfaceName.equals(r2) == false) goto L5;
            return this;
        L5:
            return null;
        }

        public void registerAsService(String r1) throws RemoteException {
            registerService(r1);
        }

        public String toString() {
            return interfaceDescriptor() + "@Stub";
        }

        public void onTransact(int r5, HwParcel r6, HwParcel r7, int r8) throws RemoteException {
            int r2 = 0;
            boolean r3 = true;
            switch(r5) {
                case 256067662: goto L66;
                case 256131655: goto L59;
                case 256136003: goto L52;
                case 256398152: goto L42;
                case 256462420: goto L36;
                case 256660548: goto L31;
                case 256921159: goto L24;
                case 257049926: goto L17;
                case 257120595: goto L11;
                case 257250372: goto L6;
                default: goto L93;
            };
        L93:
            return;
        L6:
            if ((r8 & 1) == 0) goto L8;
            r2 = 1;
        L8:
            if (r2 == 0) goto L74;
            r7.writeStatus(Integer.MIN_VALUE);
            r7.send();
            return;
        L74:
            return;
        L11:
            if ((r8 & 1) == 0) goto L13;
            r2 = 1;
        L13:
            if (r2 == 1) goto L15;
            r7.writeStatus(Integer.MIN_VALUE);
            r7.send();
            return;
        L15:
            r6.enforceInterface(IBase.kInterfaceName);
            notifySyspropsChanged();
            return;
        L17:
            if ((r8 & 1) != 0) goto L20;
            r3 = false;
        L20:
            if (r3 == false) goto L22;
            r7.writeStatus(Integer.MIN_VALUE);
            r7.send();
            return;
        L22:
            r6.enforceInterface(IBase.kInterfaceName);
            DebugInfo r4 = getDebugInfo();
            r7.writeStatus(0);
            r4.writeToParcel(r7);
            r7.send();
            return;
        L24:
            if ((r8 & 1) != 0) goto L27;
            r3 = false;
        L27:
            if (r3 == false) goto L29;
            r7.writeStatus(Integer.MIN_VALUE);
            r7.send();
            return;
        L29:
            r6.enforceInterface(IBase.kInterfaceName);
            ping();
            r7.writeStatus(0);
            r7.send();
            return;
        L31:
            if ((r8 & 1) == 0) goto L33;
            r2 = 1;
        L33:
            if (r2 == 0) goto L82;
            r7.writeStatus(Integer.MIN_VALUE);
            r7.send();
            return;
        L82:
            return;
        L36:
            if ((r8 & 1) == 0) goto L38;
            r2 = 1;
        L38:
            if (r2 == 1) goto L40;
            r7.writeStatus(Integer.MIN_VALUE);
            r7.send();
            return;
        L40:
            r6.enforceInterface(IBase.kInterfaceName);
            setHALInstrumentation();
            return;
        L42:
            if ((r8 & 1) != 0) goto L45;
            r3 = false;
        L45:
            if (r3 == false) goto L47;
            r7.writeStatus(Integer.MIN_VALUE);
            r7.send();
            return;
        L47:
            r6.enforceInterface(IBase.kInterfaceName);
            ArrayList<byte[]> r9 = getHashChain();
            r7.writeStatus(0);
            HwBlob r10 = new HwBlob(16);
            int r11 = r9.size();
            r10.putInt32(8, r11);
            r10.putBool(12, false);
            HwBlob r12 = new HwBlob(r11 * 32);
        L48:
            if (r2 >= r11) goto L50;
            r12.putInt8Array(r2 * 32, r9.get(r2));
            r2 = r2 + 1;
            goto L48
        L50:
            r10.putBlob(0, r12);
            r7.writeBuffer(r10);
            r7.send();
            return;
        L52:
            if ((r8 & 1) != 0) goto L55;
            r3 = false;
        L55:
            if (r3 == false) goto L57;
            r7.writeStatus(Integer.MIN_VALUE);
            r7.send();
            return;
        L57:
            r6.enforceInterface(IBase.kInterfaceName);
            String r13 = interfaceDescriptor();
            r7.writeStatus(0);
            r7.writeString(r13);
            r7.send();
            return;
        L59:
            if ((r8 & 1) != 0) goto L62;
            r3 = false;
        L62:
            if (r3 == false) goto L64;
            r7.writeStatus(Integer.MIN_VALUE);
            r7.send();
            return;
        L64:
            r6.enforceInterface(IBase.kInterfaceName);
            r7.writeStatus(0);
            r7.send();
            return;
        L66:
            if ((r8 & 1) != 0) goto L69;
            r3 = false;
        L69:
            if (r3 == false) goto L71;
            r7.writeStatus(Integer.MIN_VALUE);
            r7.send();
            return;
        L71:
            r6.enforceInterface(IBase.kInterfaceName);
            ArrayList<String> r14 = interfaceChain();
            r7.writeStatus(0);
            r7.writeStringVector(r14);
            r7.send();
        }
    }

    IHwBinder asBinder();

    DebugInfo getDebugInfo() throws RemoteException;

    ArrayList<byte[]> getHashChain() throws RemoteException;

    ArrayList<String> interfaceChain() throws RemoteException;

    String interfaceDescriptor() throws RemoteException;

    boolean linkToDeath(IHwBinder.DeathRecipient r1, long r2) throws RemoteException;

    void notifySyspropsChanged() throws RemoteException;

    void ping() throws RemoteException;

    void setHALInstrumentation() throws RemoteException;

    boolean unlinkToDeath(IHwBinder.DeathRecipient r1) throws RemoteException;

    static IBase asInterface(IHwBinder r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        IHwInterface r2 = r4.queryLocalInterface(kInterfaceName);
        if (r2 != null) goto L8;
    L11:
        Proxy r3 = new Proxy(r4);
        Iterator<String> r5 = r3.interfaceChain().iterator();     // Catch: RemoteException -> L19
    L14:
        if (r5.hasNext() == false) goto L18;
        if (r5.next().equals(kInterfaceName) == false) goto L14;
        return r3;
    L18:
        return null;
    L8:
        if ((r2 instanceof IBase) == false) goto L11;
        return (IBase) r2;
    }

    static IBase castFrom(IHwInterface r0) {
        if (r0 != null) goto L5;
        return null;
    L5:
        return asInterface(r0.asBinder());
    }

    static IBase getService(String r1, boolean r2) throws RemoteException {
        return asInterface(HwBinder.getService(kInterfaceName, r1, r2));
    }

    static IBase getService(boolean r1) throws RemoteException {
        return getService("default", r1);
    }

    static IBase getService(String r1) throws RemoteException {
        return asInterface(HwBinder.getService(kInterfaceName, r1));
    }

    static IBase getService() throws RemoteException {
        return getService("default");
    }
}
