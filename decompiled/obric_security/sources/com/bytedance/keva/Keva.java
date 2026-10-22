package com.bytedance.keva;

import android.content.Context;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class Keva {

    public interface OnChangeListener {
        void onChanged(Keva r1, String r2);
    }

    public abstract Map<String, Object> buildNewMap(Map<String, Object> r1);

    public abstract void clear();

    public abstract boolean contains(String r1);

    public abstract int count();

    public abstract void dump();

    public abstract void erase(String r1);

    public abstract Map<String, ?> getAll();

    public abstract boolean getBoolean(String r1, boolean r2);

    public abstract byte[] getBytes(String r1, byte[] r2);

    public abstract byte[] getBytesJustDisk(String r1, byte[] r2);

    public abstract double getDouble(String r1, double r2);

    public abstract float getFloat(String r1, float r2);

    public abstract int getInt(String r1, int r2);

    public abstract long getLong(String r1, long r2);

    public abstract String getString(String r1, String r2);

    public abstract String[] getStringArray(String r1, String[] r2);

    public abstract String[] getStringArrayJustDisk(String r1, String[] r2);

    public abstract String getStringJustDisk(String r1, String r2);

    public abstract Set<String> getStringSet(String r1, Set<String> r2);

    public abstract Set<String> getStringSetJustDisk(String r1, Set<String> r2);

    public abstract String name();

    public abstract void registerChangeListener(OnChangeListener r1);

    public abstract void storeBoolean(String r1, boolean r2);

    public abstract void storeBytes(String r1, byte[] r2);

    public abstract void storeBytesJustDisk(String r1, byte[] r2);

    public abstract void storeDouble(String r1, double r2);

    public abstract void storeFloat(String r1, float r2);

    public abstract void storeInt(String r1, int r2);

    public abstract void storeLong(String r1, long r2);

    public abstract void storeString(String r1, String r2);

    public abstract void storeStringArray(String r1, String[] r2);

    public abstract void storeStringArrayJustDisk(String r1, String[] r2);

    public abstract void storeStringJustDisk(String r1, String r2);

    public abstract void storeStringSet(String r1, Set<String> r2);

    public abstract void storeStringSetJustDisk(String r1, Set<String> r2);

    public abstract void unRegisterChangeListener(OnChangeListener r1);

    public Keva() {
    }

    public static Keva getRepo(String r1) {
        return KevaImpl.getRepo(r1, 0);
    }

    public static Keva getRepo(String r0, int r1) {
        return KevaImpl.getRepo(r0, r1);
    }

    public static Keva getRepoFromSp(Context r0, String r1, int r2) {
        return KevaImpl.getRepoFromSp(r0, r1, r2);
    }

    public static Keva getRepoSync(String r0, int r1) {
        return KevaImpl.getRepoSync(r0, r1);
    }

    public static Keva getRepoFromSpSync(Context r0, String r1, int r2) {
        return KevaImpl.getRepoFromSpSync(r0, r1, r2);
    }

    public static void forceInit() {
        KevaImpl.forceInitImpl();
    }

    public static boolean isRepoPorted(String r0) {
        return KevaImpl.isRepoPorted(r0);
    }

    @Deprecated
    public int calculateSize() {
        return count();
    }
}
