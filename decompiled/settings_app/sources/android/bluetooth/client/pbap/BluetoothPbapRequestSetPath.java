package android.bluetooth.client.pbap;

import android.util.Log;
import java.io.IOException;
import javax.obex.ClientSession;
import javax.obex.HeaderSet;

/* JADX INFO: loaded from: classes.dex */
final class BluetoothPbapRequestSetPath extends BluetoothPbapRequest {
    private static final String TAG = "BluetoothPbapRequestSetPath";
    private SetPathDir mDir;

    /* JADX INFO: renamed from: android.bluetooth.client.pbap.BluetoothPbapRequestSetPath$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$bluetooth$client$pbap$BluetoothPbapRequestSetPath$SetPathDir = null;

        static {
            int[] r0 = new int[SetPathDir.values().length];
            $SwitchMap$android$bluetooth$client$pbap$BluetoothPbapRequestSetPath$SetPathDir = r0;
            r0[SetPathDir.ROOT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$android$bluetooth$client$pbap$BluetoothPbapRequestSetPath$SetPathDir[SetPathDir.DOWN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$android$bluetooth$client$pbap$BluetoothPbapRequestSetPath$SetPathDir[SetPathDir.UP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    private static final enum SetPathDir extends Enum<SetPathDir> {
        private static final /* synthetic */ SetPathDir[] $VALUES = null;
        public static final SetPathDir DOWN = null;
        public static final SetPathDir ROOT = null;
        public static final SetPathDir UP = null;

        private static /* synthetic */ SetPathDir[] $values() {
            return new SetPathDir[]{ROOT, UP, DOWN};
        }

        private SetPathDir(String r1, int r2) {
            super(r1, r2);
        }

        public static SetPathDir valueOf(String r1) {
            return (SetPathDir) Enum.valueOf(SetPathDir.class, r1);
        }

        public static SetPathDir[] values() {
            return (SetPathDir[]) $VALUES.clone();
        }

        static {
            ROOT = new SetPathDir("ROOT", 0);
            UP = new SetPathDir("UP", 1);
            DOWN = new SetPathDir("DOWN", 2);
            $VALUES = $values();
        }
    }

    public BluetoothPbapRequestSetPath(String r2) {
        this.mDir = SetPathDir.DOWN;
        this.mHeaderSet.setHeader(1, r2);
    }

    public BluetoothPbapRequestSetPath(boolean r2) {
        this.mHeaderSet.setEmptyNameHeader();
        if (r2 == false) goto L5;
        this.mDir = SetPathDir.UP;
        return;
    L5:
        this.mDir = SetPathDir.ROOT;
    }

    @Override // android.bluetooth.client.pbap.BluetoothPbapRequest
    public void execute(ClientSession r5) {
        Log.v(TAG, "execute");
        int r0 = AnonymousClass1.$SwitchMap$android$bluetooth$client$pbap$BluetoothPbapRequestSetPath$SetPathDir[this.mDir.ordinal()];     // Catch: IOException -> L14
        if (r0 != 1) goto L6;
    L11:
        HeaderSet r6 = r5.setPath(this.mHeaderSet, false, false);     // Catch: IOException -> L14
    L12:
        this.mResponseCode = r6.getResponseCode();     // Catch: IOException -> L14
        return;
    L6:
        if (r0 == 2) goto L11;
        if (r0 == 3) goto L10;
        r6 = null;
        goto L12
    L10:
        r6 = r5.setPath(this.mHeaderSet, true, false);     // Catch: IOException -> L14
    L14:
        this.mResponseCode = 208;
    }
}
