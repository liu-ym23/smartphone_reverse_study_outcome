package android.hidl.base.V1_0;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import com.bytedance.networkstackapplib.NetworkStackConstant;
import java.util.ArrayList;
import java.util.Objects;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: loaded from: classes.dex */
public final class DebugInfo {
    public int arch;
    public int pid;
    public long ptr;

    public static final class Architecture {
        public static final int IS_32BIT = 2;
        public static final int IS_64BIT = 1;
        public static final int UNKNOWN = 0;

        public Architecture() {
        }

        public static final String toString(int r2) {
            if (r2 != 0) goto L6;
            return NetworkStackConstant.UNKNOWN_TYPE;
        L6:
            if (r2 != 1) goto L10;
            return "IS_64BIT";
        L10:
            if (r2 != 2) goto L14;
            return "IS_32BIT";
        L14:
            return "0x" + Integer.toHexString(r2);
        }

        public static final String dumpBitfield(int r4) {
            ArrayList r0 = new ArrayList();
            r0.add(NetworkStackConstant.UNKNOWN_TYPE);
            int r2 = 1;
            if ((r4 & 1) != 1) goto L5;
            r0.add("IS_64BIT");
        L7:
            if ((r4 & 2) != 2) goto L9;
            r0.add("IS_32BIT");
            r2 = r2 | 2;
        L9:
            if (r4 == r2) goto L12;
            r0.add("0x" + Integer.toHexString(r4 & (~r2)));
        L12:
            return String.join(" | ", r0);
        L5:
            r2 = 0;
            goto L7
        }
    }

    public DebugInfo() {
    }

    public final boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (r7 != null) goto L9;
        return false;
    L9:
        if (r7.getClass() == DebugInfo.class) goto L11;
        return false;
    L11:
        DebugInfo r8 = (DebugInfo) r7;
        if (this.pid == r8.pid) goto L15;
        return false;
    L15:
        if (this.ptr == r8.ptr) goto L18;
        return false;
    L18:
        if (this.arch == r8.arch) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.pid))), Integer.valueOf(HidlSupport.deepHashCode(Long.valueOf(this.ptr))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.arch)))});
    }

    public final String toString() {
        return "{.pid = " + this.pid + ", .ptr = " + this.ptr + ", .arch = " + Architecture.toString(this.arch) + VectorFormat.DEFAULT_SUFFIX;
    }

    public final void readFromParcel(HwParcel r4) {
        readEmbeddedFromParcel(r4, r4.readBuffer(24), 0);
    }

    public static final ArrayList<DebugInfo> readVectorFromParcel(HwParcel r12) {
        ArrayList<DebugInfo> r0 = new ArrayList();
        HwBlob r1 = r12.readBuffer(16);
        int r2 = r1.getInt32(8);
        HwBlob r3 = r12.readEmbeddedBuffer(r2 * 24, r1.handle(), 0, true);
        r0.clear();
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L5;
        DebugInfo r5 = new DebugInfo();
        r5.readEmbeddedFromParcel(r12, r3, r4 * 24);
        r0.add(r5);
        r4 = r4 + 1;
        goto L3
    L5:
        return r0;
    }

    public final void readEmbeddedFromParcel(HwParcel r3, HwBlob r4, long r5) {
        this.pid = r4.getInt32(0 + r5);
        this.ptr = r4.getInt64(8 + r5);
        this.arch = r4.getInt32(r5 + 16);
    }

    public final void writeToParcel(HwParcel r4) {
        HwBlob r0 = new HwBlob(24);
        writeEmbeddedToBlob(r0, 0);
        r4.writeBuffer(r0);
    }

    public static final void writeVectorToParcel(HwParcel r7, ArrayList<DebugInfo> r8) {
        HwBlob r0 = new HwBlob(16);
        int r1 = r8.size();
        r0.putInt32(8, r1);
        int r4 = 0;
        r0.putBool(12, false);
        HwBlob r2 = new HwBlob(r1 * 24);
    L3:
        if (r4 >= r1) goto L5;
        r8.get(r4).writeEmbeddedToBlob(r2, r4 * 24);
        r4 = r4 + 1;
        goto L3
    L5:
        r0.putBlob(0, r2);
        r7.writeBuffer(r0);
    }

    public final void writeEmbeddedToBlob(HwBlob r5, long r6) {
        r5.putInt32(0 + r6, this.pid);
        r5.putInt64(8 + r6, this.ptr);
        r5.putInt32(r6 + 16, this.arch);
    }
}
