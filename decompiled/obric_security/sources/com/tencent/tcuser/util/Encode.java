package com.tencent.tcuser.util;

import android.content.Context;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class Encode {
    private static String TAG = "--Encode--";
    private static boolean isLoaded = false;

    public static class ProcessInfo {
        public String name;
        public int pid;
        public int ppid;
        public int uid;

        public ProcessInfo() {
            this.pid = 0;
            this.ppid = 0;
            this.name = null;
            this.uid = 0;
        }

        public String toString() {
            return "PID=" + this.pid + " PPID=" + this.ppid + " NAME=" + this.name + " UID=" + this.uid;
        }

        public ProcessInfo(int r1, int r2, String r3, int r4) {
            this.pid = r1;
            this.ppid = r2;
            this.name = r3;
            this.uid = r4;
        }
    }

    static {
    }

    public Encode() {
    }

    public static final native String cs(String r0);

    private static final native void nativePs(List<String> r0, List<ProcessInfo> r1);

    public static final native int pu(int r0);

    public static native byte[] x(Context r0, byte[] r1);

    public static native byte[] y(Context r0, byte[] r1);
}
