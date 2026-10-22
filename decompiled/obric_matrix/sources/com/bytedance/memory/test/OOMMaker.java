package com.bytedance.memory.test;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class OOMMaker {
    private static ArrayList<byte[]> sArrayList;

    static {
        sArrayList = new ArrayList();
    }

    public OOMMaker() {
    }

    public static void createOOM() {
    L2:
        encreaseMem(2097152);
        goto L2
    }

    public static void encreaseMem() {
        encreaseMem(15728640);
    }

    private static void encreaseMem(int r1) {
        ArrayList<byte[]> r0 = sArrayList;
        r0.add(new byte[r1]);
    }
}
