package vendor.qti.hardware.touchscreen.V1_0;

import android.hidl.base.V1_0.DebugInfo;
import android.hidl.base.V1_0.IBase;
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

/* JADX INFO: loaded from: classes6.dex */
public interface ITouchscreen extends IBase {
    public static final String kInterfaceName = "vendor.qti.hardware.touchscreen@1.0::ITouchscreen";

    public static final class Proxy implements ITouchscreen {
        private IHwBinder mRemote;

        public Proxy(IHwBinder r1) {
            this.mRemote = (IHwBinder) Objects.requireNonNull(r1);
        }

        @Override // vendor.qti.hardware.touchscreen.V1_0.ITouchscreen, android.hidl.base.V1_0.IBase
        public IHwBinder asBinder() {
            return this.mRemote;
        }

        public String toString() {
            return interfaceDescriptor() + "@Proxy";
        L4:
            return "[class or subclass of vendor.qti.hardware.touchscreen@1.0::ITouchscreen]@Proxy";
        }

        public final boolean equals(Object r1) {
            return HidlSupport.interfacesEqual(this, r1);
        }

        public final int hashCode() {
            return asBinder().hashCode();
        }

        @Override // vendor.qti.hardware.touchscreen.V1_0.ITouchscreen
        public int setGloveMode(int r4) throws RemoteException {
            HwParcel r0 = new HwParcel();
            r0.writeInterfaceToken(ITouchscreen.kInterfaceName);
            r0.writeInt32(r4);
            HwParcel r5 = new HwParcel();
            this.mRemote.transact(1, r0, r5, 0);     // Catch: Throwable -> L6
            r5.verifySuccess();     // Catch: Throwable -> L6
            r0.releaseTemporaryStorage();     // Catch: Throwable -> L6
            int r3 = r5.readInt32();     // Catch: Throwable -> L6
            r5.release();
            return r3;
        L6:
            th = move-exception;
            r5.release();
            throw th;
        }

        @Override // vendor.qti.hardware.touchscreen.V1_0.ITouchscreen
        public boolean supportsGloveModeControl() throws RemoteException {
            HwParcel r0 = new HwParcel();
            r0.writeInterfaceToken(ITouchscreen.kInterfaceName);
            HwParcel r1 = new HwParcel();
            this.mRemote.transact(2, r0, r1, 0);     // Catch: Throwable -> L6
            r1.verifySuccess();     // Catch: Throwable -> L6
            r0.releaseTemporaryStorage();     // Catch: Throwable -> L6
            boolean r4 = r1.readBool();     // Catch: Throwable -> L6
            r1.release();
            return r4;
        L6:
            th = move-exception;
            r1.release();
            throw th;
        }

        @Override // vendor.qti.hardware.touchscreen.V1_0.ITouchscreen
        public int setTouchSize(int r4) throws RemoteException {
            HwParcel r0 = new HwParcel();
            r0.writeInterfaceToken(ITouchscreen.kInterfaceName);
            r0.writeInt32(r4);
            HwParcel r5 = new HwParcel();
            this.mRemote.transact(3, r0, r5, 0);     // Catch: Throwable -> L6
            r5.verifySuccess();     // Catch: Throwable -> L6
            r0.releaseTemporaryStorage();     // Catch: Throwable -> L6
            int r3 = r5.readInt32();     // Catch: Throwable -> L6
            r5.release();
            return r3;
        L6:
            th = move-exception;
            r5.release();
            throw th;
        }

        @Override // vendor.qti.hardware.touchscreen.V1_0.ITouchscreen
        public boolean supportsTouchSizeControl() throws RemoteException {
            HwParcel r0 = new HwParcel();
            r0.writeInterfaceToken(ITouchscreen.kInterfaceName);
            HwParcel r1 = new HwParcel();
            this.mRemote.transact(4, r0, r1, 0);     // Catch: Throwable -> L6
            r1.verifySuccess();     // Catch: Throwable -> L6
            r0.releaseTemporaryStorage();     // Catch: Throwable -> L6
            boolean r4 = r1.readBool();     // Catch: Throwable -> L6
            r1.release();
            return r4;
        L6:
            th = move-exception;
            r1.release();
            throw th;
        }

        @Override // vendor.qti.hardware.touchscreen.V1_0.ITouchscreen
        public int setGestureMode(int r4) throws RemoteException {
            HwParcel r0 = new HwParcel();
            r0.writeInterfaceToken(ITouchscreen.kInterfaceName);
            r0.writeInt32(r4);
            HwParcel r5 = new HwParcel();
            this.mRemote.transact(5, r0, r5, 0);     // Catch: Throwable -> L6
            r5.verifySuccess();     // Catch: Throwable -> L6
            r0.releaseTemporaryStorage();     // Catch: Throwable -> L6
            int r3 = r5.readInt32();     // Catch: Throwable -> L6
            r5.release();
            return r3;
        L6:
            th = move-exception;
            r5.release();
            throw th;
        }

        @Override // vendor.qti.hardware.touchscreen.V1_0.ITouchscreen
        public boolean supportsGestureModeControl() throws RemoteException {
            HwParcel r0 = new HwParcel();
            r0.writeInterfaceToken(ITouchscreen.kInterfaceName);
            HwParcel r1 = new HwParcel();
            this.mRemote.transact(6, r0, r1, 0);     // Catch: Throwable -> L6
            r1.verifySuccess();     // Catch: Throwable -> L6
            r0.releaseTemporaryStorage();     // Catch: Throwable -> L6
            boolean r4 = r1.readBool();     // Catch: Throwable -> L6
            r1.release();
            return r4;
        L6:
            th = move-exception;
            r1.release();
            throw th;
        }

        @Override // vendor.qti.hardware.touchscreen.V1_0.ITouchscreen, android.hidl.base.V1_0.IBase
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

        @Override // vendor.qti.hardware.touchscreen.V1_0.ITouchscreen, android.hidl.base.V1_0.IBase
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

        @Override // vendor.qti.hardware.touchscreen.V1_0.ITouchscreen, android.hidl.base.V1_0.IBase
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

        @Override // vendor.qti.hardware.touchscreen.V1_0.ITouchscreen, android.hidl.base.V1_0.IBase
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

        @Override // vendor.qti.hardware.touchscreen.V1_0.ITouchscreen, android.hidl.base.V1_0.IBase
        public boolean linkToDeath(IHwBinder.DeathRecipient r1, long r2) throws RemoteException {
            return this.mRemote.linkToDeath(r1, r2);
        }

        @Override // vendor.qti.hardware.touchscreen.V1_0.ITouchscreen, android.hidl.base.V1_0.IBase
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

        @Override // vendor.qti.hardware.touchscreen.V1_0.ITouchscreen, android.hidl.base.V1_0.IBase
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

        @Override // vendor.qti.hardware.touchscreen.V1_0.ITouchscreen, android.hidl.base.V1_0.IBase
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

        @Override // vendor.qti.hardware.touchscreen.V1_0.ITouchscreen, android.hidl.base.V1_0.IBase
        public boolean unlinkToDeath(IHwBinder.DeathRecipient r1) throws RemoteException {
            return this.mRemote.unlinkToDeath(r1);
        }
    }

    public static abstract class Stub extends HwBinder implements ITouchscreen {
        @Override // vendor.qti.hardware.touchscreen.V1_0.ITouchscreen, android.hidl.base.V1_0.IBase
        public IHwBinder asBinder() {
            return this;
        }

        @Override // vendor.qti.hardware.touchscreen.V1_0.ITouchscreen, android.hidl.base.V1_0.IBase
        public final String interfaceDescriptor() {
            return ITouchscreen.kInterfaceName;
        }

        @Override // vendor.qti.hardware.touchscreen.V1_0.ITouchscreen, android.hidl.base.V1_0.IBase
        public final boolean linkToDeath(IHwBinder.DeathRecipient r1, long r2) {
            return true;
        }

        @Override // vendor.qti.hardware.touchscreen.V1_0.ITouchscreen, android.hidl.base.V1_0.IBase
        public final void ping() {
        }

        @Override // vendor.qti.hardware.touchscreen.V1_0.ITouchscreen, android.hidl.base.V1_0.IBase
        public final void setHALInstrumentation() {
        }

        @Override // vendor.qti.hardware.touchscreen.V1_0.ITouchscreen, android.hidl.base.V1_0.IBase
        public final boolean unlinkToDeath(IHwBinder.DeathRecipient r1) {
            return true;
        }

        public Stub() {
        }

        @Override // vendor.qti.hardware.touchscreen.V1_0.ITouchscreen, android.hidl.base.V1_0.IBase
        public final ArrayList<String> interfaceChain() {
            return new ArrayList(Arrays.asList(new String[]{ITouchscreen.kInterfaceName, IBase.kInterfaceName}));
        }

        @Override // vendor.qti.hardware.touchscreen.V1_0.ITouchscreen, android.hidl.base.V1_0.IBase
        public final ArrayList<byte[]> getHashChain() {
            return new ArrayList(Arrays.asList(new byte[][]{new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new byte[]{-67, -38, -74, 24, 77, 122, 52, 109, -90, -96, Bidi.MAX_EXPLICIT_LEVEL, -64, -126, -116, -15, -102, 105, 111, 76, -86, 54, 17, -59, Ascii.US, 46, 20, 86, 90, 20, -76, 15, -39}}));
        }

        @Override // vendor.qti.hardware.touchscreen.V1_0.ITouchscreen, android.hidl.base.V1_0.IBase
        public final DebugInfo getDebugInfo() {
            DebugInfo r2 = new DebugInfo();
            r2.pid = HidlSupport.getPidIfSharable();
            r2.ptr = 0;
            r2.arch = 0;
            return r2;
        }

        @Override // vendor.qti.hardware.touchscreen.V1_0.ITouchscreen, android.hidl.base.V1_0.IBase
        public final void notifySyspropsChanged() {
            HwBinder.enableInstrumentation();
        }

        public IHwInterface queryLocalInterface(String r2) {
            if (ITouchscreen.kInterfaceName.equals(r2) == false) goto L5;
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
                case 1: goto L110;
                case 2: goto L103;
                case 3: goto L96;
                case 4: goto L89;
                case 5: goto L82;
                case 6: goto L75;
                default: goto L5;
            };
        L5:
            switch(r5) {
                case 256067662: goto L68;
                case 256131655: goto L61;
                case 256136003: goto L54;
                case 256398152: goto L44;
                case 256462420: goto L38;
                case 256660548: goto L33;
                case 256921159: goto L26;
                case 257049926: goto L19;
                case 257120595: goto L13;
                case 257250372: goto L8;
                default: goto L149;
            };
        L149:
            return;
        L8:
            if ((r8 & 1) == 0) goto L10;
            r2 = 1;
        L10:
            if (r2 == 0) goto L118;
            r7.writeStatus(Integer.MIN_VALUE);
            r7.send();
            return;
        L118:
            return;
        L13:
            if ((r8 & 1) == 0) goto L15;
            r2 = 1;
        L15:
            if (r2 == 1) goto L17;
            r7.writeStatus(Integer.MIN_VALUE);
            r7.send();
            return;
        L17:
            r6.enforceInterface(IBase.kInterfaceName);
            notifySyspropsChanged();
            return;
        L19:
            if ((r8 & 1) != 0) goto L22;
            r3 = false;
        L22:
            if (r3 == false) goto L24;
            r7.writeStatus(Integer.MIN_VALUE);
            r7.send();
            return;
        L24:
            r6.enforceInterface(IBase.kInterfaceName);
            DebugInfo r4 = getDebugInfo();
            r7.writeStatus(0);
            r4.writeToParcel(r7);
            r7.send();
            return;
        L26:
            if ((r8 & 1) != 0) goto L29;
            r3 = false;
        L29:
            if (r3 == false) goto L31;
            r7.writeStatus(Integer.MIN_VALUE);
            r7.send();
            return;
        L31:
            r6.enforceInterface(IBase.kInterfaceName);
            ping();
            r7.writeStatus(0);
            r7.send();
            return;
        L33:
            if ((r8 & 1) == 0) goto L35;
            r2 = 1;
        L35:
            if (r2 == 0) goto L126;
            r7.writeStatus(Integer.MIN_VALUE);
            r7.send();
            return;
        L126:
            return;
        L38:
            if ((r8 & 1) == 0) goto L40;
            r2 = 1;
        L40:
            if (r2 == 1) goto L42;
            r7.writeStatus(Integer.MIN_VALUE);
            r7.send();
            return;
        L42:
            r6.enforceInterface(IBase.kInterfaceName);
            setHALInstrumentation();
            return;
        L44:
            if ((r8 & 1) != 0) goto L47;
            r3 = false;
        L47:
            if (r3 == false) goto L49;
            r7.writeStatus(Integer.MIN_VALUE);
            r7.send();
            return;
        L49:
            r6.enforceInterface(IBase.kInterfaceName);
            ArrayList<byte[]> r9 = getHashChain();
            r7.writeStatus(0);
            HwBlob r10 = new HwBlob(16);
            int r11 = r9.size();
            r10.putInt32(8, r11);
            r10.putBool(12, false);
            HwBlob r12 = new HwBlob(r11 * 32);
        L50:
            if (r2 >= r11) goto L52;
            r12.putInt8Array(r2 * 32, r9.get(r2));
            r2 = r2 + 1;
            goto L50
        L52:
            r10.putBlob(0, r12);
            r7.writeBuffer(r10);
            r7.send();
            return;
        L54:
            if ((r8 & 1) != 0) goto L57;
            r3 = false;
        L57:
            if (r3 == false) goto L59;
            r7.writeStatus(Integer.MIN_VALUE);
            r7.send();
            return;
        L59:
            r6.enforceInterface(IBase.kInterfaceName);
            String r13 = interfaceDescriptor();
            r7.writeStatus(0);
            r7.writeString(r13);
            r7.send();
            return;
        L61:
            if ((r8 & 1) != 0) goto L64;
            r3 = false;
        L64:
            if (r3 == false) goto L66;
            r7.writeStatus(Integer.MIN_VALUE);
            r7.send();
            return;
        L66:
            r6.enforceInterface(IBase.kInterfaceName);
            r7.writeStatus(0);
            r7.send();
            return;
        L68:
            if ((r8 & 1) != 0) goto L71;
            r3 = false;
        L71:
            if (r3 == false) goto L73;
            r7.writeStatus(Integer.MIN_VALUE);
            r7.send();
            return;
        L73:
            r6.enforceInterface(IBase.kInterfaceName);
            ArrayList<String> r14 = interfaceChain();
            r7.writeStatus(0);
            r7.writeStringVector(r14);
            r7.send();
            return;
        L75:
            if ((r8 & 1) != 0) goto L78;
            r3 = false;
        L78:
            if (r3 == false) goto L80;
            r7.writeStatus(Integer.MIN_VALUE);
            r7.send();
            return;
        L80:
            r6.enforceInterface(ITouchscreen.kInterfaceName);
            boolean r15 = supportsGestureModeControl();
            r7.writeStatus(0);
            r7.writeBool(r15);
            r7.send();
            return;
        L82:
            if ((r8 & 1) != 0) goto L85;
            r3 = false;
        L85:
            if (r3 == false) goto L87;
            r7.writeStatus(Integer.MIN_VALUE);
            r7.send();
            return;
        L87:
            r6.enforceInterface(ITouchscreen.kInterfaceName);
            int r16 = setGestureMode(r6.readInt32());
            r7.writeStatus(0);
            r7.writeInt32(r16);
            r7.send();
            return;
        L89:
            if ((r8 & 1) != 0) goto L92;
            r3 = false;
        L92:
            if (r3 == false) goto L94;
            r7.writeStatus(Integer.MIN_VALUE);
            r7.send();
            return;
        L94:
            r6.enforceInterface(ITouchscreen.kInterfaceName);
            boolean r17 = supportsTouchSizeControl();
            r7.writeStatus(0);
            r7.writeBool(r17);
            r7.send();
            return;
        L96:
            if ((r8 & 1) != 0) goto L99;
            r3 = false;
        L99:
            if (r3 == false) goto L101;
            r7.writeStatus(Integer.MIN_VALUE);
            r7.send();
            return;
        L101:
            r6.enforceInterface(ITouchscreen.kInterfaceName);
            int r18 = setTouchSize(r6.readInt32());
            r7.writeStatus(0);
            r7.writeInt32(r18);
            r7.send();
            return;
        L103:
            if ((r8 & 1) != 0) goto L106;
            r3 = false;
        L106:
            if (r3 == false) goto L108;
            r7.writeStatus(Integer.MIN_VALUE);
            r7.send();
            return;
        L108:
            r6.enforceInterface(ITouchscreen.kInterfaceName);
            boolean r19 = supportsGloveModeControl();
            r7.writeStatus(0);
            r7.writeBool(r19);
            r7.send();
            return;
        L110:
            if ((r8 & 1) != 0) goto L113;
            r3 = false;
        L113:
            if (r3 == false) goto L115;
            r7.writeStatus(Integer.MIN_VALUE);
            r7.send();
            return;
        L115:
            r6.enforceInterface(ITouchscreen.kInterfaceName);
            int r20 = setGloveMode(r6.readInt32());
            r7.writeStatus(0);
            r7.writeInt32(r20);
            r7.send();
        }
    }

    @Override // android.hidl.base.V1_0.IBase
    IHwBinder asBinder();

    @Override // android.hidl.base.V1_0.IBase
    DebugInfo getDebugInfo() throws RemoteException;

    @Override // android.hidl.base.V1_0.IBase
    ArrayList<byte[]> getHashChain() throws RemoteException;

    @Override // android.hidl.base.V1_0.IBase
    ArrayList<String> interfaceChain() throws RemoteException;

    @Override // android.hidl.base.V1_0.IBase
    String interfaceDescriptor() throws RemoteException;

    @Override // android.hidl.base.V1_0.IBase
    boolean linkToDeath(IHwBinder.DeathRecipient r1, long r2) throws RemoteException;

    @Override // android.hidl.base.V1_0.IBase
    void notifySyspropsChanged() throws RemoteException;

    @Override // android.hidl.base.V1_0.IBase
    void ping() throws RemoteException;

    int setGestureMode(int r1) throws RemoteException;

    int setGloveMode(int r1) throws RemoteException;

    @Override // android.hidl.base.V1_0.IBase
    void setHALInstrumentation() throws RemoteException;

    int setTouchSize(int r1) throws RemoteException;

    boolean supportsGestureModeControl() throws RemoteException;

    boolean supportsGloveModeControl() throws RemoteException;

    boolean supportsTouchSizeControl() throws RemoteException;

    @Override // android.hidl.base.V1_0.IBase
    boolean unlinkToDeath(IHwBinder.DeathRecipient r1) throws RemoteException;

    static ITouchscreen asInterface(IHwBinder r4) {
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
        if ((r2 instanceof ITouchscreen) == false) goto L11;
        return (ITouchscreen) r2;
    }

    static ITouchscreen castFrom(IHwInterface r0) {
        if (r0 != null) goto L5;
        return null;
    L5:
        return asInterface(r0.asBinder());
    }

    static ITouchscreen getService(String r1, boolean r2) throws RemoteException {
        return asInterface(HwBinder.getService(kInterfaceName, r1, r2));
    }

    static ITouchscreen getService(boolean r1) throws RemoteException {
        return getService("default", r1);
    }

    static ITouchscreen getService(String r1) throws RemoteException {
        return asInterface(HwBinder.getService(kInterfaceName, r1));
    }

    static ITouchscreen getService() throws RemoteException {
        return getService("default");
    }
}
