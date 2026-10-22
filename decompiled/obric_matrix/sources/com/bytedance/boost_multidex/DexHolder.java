package com.bytedance.boost_multidex;

import android.content.SharedPreferences;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes.dex */
abstract class DexHolder {
    File mFile;

    static class ApkBuffer extends DexHolder {
        private byte[] mBytes;
        private int mIndex;
        private File mOptFile;

        ApkBuffer(int r1, byte[] r2, File r3, File r4) {
            this.mIndex = r1;
            this.mBytes = r2;
            this.mFile = r3;
            this.mOptFile = r4;
        }

        @Override // com.bytedance.boost_multidex.DexHolder
        public StoreInfo getInfo() {
            return null;
        }

        @Override // com.bytedance.boost_multidex.DexHolder
        public Object toDexFile() {
            return BoostNative.loadDirectDex(null, this.mBytes);
        L5:
            e = move-exception;
            Monitor.get().logError("Fail to create DexFile: " + toString(), e);
            Result.get().unFatalThrowable.add(e);
            return null;
        }

        @Override // com.bytedance.boost_multidex.DexHolder
        public Object toDexListElement(DexLoader.ElementConstructor r2) {
            Object r1 = toDexFile();
            if (r1 != null) goto L6;
            return null;
        L6:
            return r2.newInstance(null, r1);
        }

        @Override // com.bytedance.boost_multidex.DexHolder
        public DexHolder toFasterHolder(SharedPreferences r4) {
            if (Utility.storeBytesToFile(this.mBytes, this.mFile) == true) goto L9;
        L8:
            return null;
        L9:
            return DexHolder.obtainValidDexBuffer(r4, this.mIndex, this.mFile, this.mOptFile);
        L6:
            e = move-exception;
            Monitor.get().logError("fail to get dex buffer", e);
            goto L8
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append(super.toString());
            r0.append(", index: ");
            r0.append(this.mIndex);
            r0.append(", [file: ");
            r0.append(this.mFile.getPath());
            r0.append(", size: ");
            r0.append(this.mFile.length());
            r0.append("], [opt file: ");
            r0.append(this.mOptFile);
            r0.append(", size: ");
            r0.append(this.mOptFile.length());
            r0.append("], bytes len: ");
            byte[] r4 = this.mBytes;
            if (r4 != null) goto L5;
            Integer r5 = null;
        L6:
            r0.append(r5);
            return r0.toString();
        L5:
            r5 = Integer.valueOf(r4.length);
            goto L6
        }
    }

    static class DexBuffer extends DexHolder {
        private int mIndex;
        private File mOptFile;

        DexBuffer(int r1, File r2, File r3) {
            this.mIndex = r1;
            this.mFile = r2;
            this.mOptFile = r3;
        }

        @Override // com.bytedance.boost_multidex.DexHolder
        public StoreInfo getInfo() {
            return new StoreInfo(this, 1, this.mIndex, this.mFile);
        }

        @Override // com.bytedance.boost_multidex.DexHolder
        public Object toDexFile() {
            return BoostNative.loadDirectDex(this.mFile.getPath(), null);
        L5:
            e = move-exception;
            Monitor.get().logError("Fail to create DexFile: " + toString(), e);
            Result.get().unFatalThrowable.add(e);
            return null;
        }

        @Override // com.bytedance.boost_multidex.DexHolder
        public DexHolder toFasterHolder(SharedPreferences r4) {
        L9:
            e = move-exception;
            Monitor.get().logError("Fail to opt dex finally", e);
            return null;
        L3:
            if (BoostNative.isSupportFastLoad() == true) goto L5;
        L6:
            Monitor.get().logWarning("Opt dex in origin way");     // Catch: IOException -> L9
            DexFile.loadDex(this.mFile.getPath(), this.mOptFile.getPath(), 0).close();     // Catch: IOException -> L9
        L7:
            return DexHolder.obtainValidDexOpt(r4, this.mIndex, this.mFile, this.mOptFile);
        L5:
            if (BoostNative.makeOptDexFile(this.mFile.getPath(), this.mOptFile.getPath()) == true) goto L7;
            goto L6
        }

        public String toString() {
            return super.toString() + ", index: " + this.mIndex + ", [file: " + this.mFile.getPath() + ", size: " + this.mFile.length() + "], [opt file: " + this.mOptFile + ", size: " + this.mOptFile.length() + "]";
        }
    }

    static class DexOpt extends DexHolder {
        private boolean mForceOpt;
        private int mIndex;
        private File mOptFile;

        DexOpt(int r1, File r2, File r3, boolean r4) {
            this.mIndex = r1;
            this.mFile = r2;
            this.mOptFile = r3;
            this.mForceOpt = r4;
        }

        @Override // com.bytedance.boost_multidex.DexHolder
        public StoreInfo getInfo() {
            return new StoreInfo(this, 2, this.mIndex, this.mOptFile);
        }

        @Override // com.bytedance.boost_multidex.DexHolder
        public Object toDexFile() {
            return DexFile.loadDex(this.mFile.getPath(), this.mOptFile.getPath(), 0);
        L5:
            e = move-exception;
            Monitor.get().logError("Fail to load dex file first time", e);
        L13:
            e = move-exception;
            Monitor.get().logError("Fail to load dex file", e);
            throw new RuntimeException(e);
        L8:
            if (this.mForceOpt == false) goto L12;
            return DexFile.loadDex(this.mFile.getPath(), this.mOptFile.getPath(), 0);
        L12:
            return BoostNative.loadDirectDex(this.mFile.getPath(), null);
        }

        @Override // com.bytedance.boost_multidex.DexHolder
        public DexHolder toFasterHolder(SharedPreferences r1) {
            return null;
        }

        public String toString() {
            return super.toString() + ", index: " + this.mIndex + ", [file: " + this.mFile.getPath() + ", size: " + this.mFile.length() + "], [opt file: " + this.mOptFile + ", size: " + this.mOptFile.length() + "], force: " + this.mForceOpt;
        }
    }

    class StoreInfo {
        File file;
        int index;
        final /* synthetic */ DexHolder this$0;
        int type;

        StoreInfo(DexHolder r1, int r2, int r3, File r4) {
            this.this$0 = r1;
            this.type = r2;
            this.index = r3;
            this.file = r4;
        }
    }

    static class ZipOpt extends DexHolder {
        private int mIndex;
        private File mOptFile;

        ZipOpt(int r1, File r2, File r3) {
            this.mIndex = r1;
            this.mFile = r2;
            this.mOptFile = r3;
        }

        @Override // com.bytedance.boost_multidex.DexHolder
        public StoreInfo getInfo() {
            return null;
        }

        @Override // com.bytedance.boost_multidex.DexHolder
        public Object toDexFile() {
            return DexFile.loadDex(this.mFile.getPath(), this.mOptFile.getPath(), 0);
        L4:
            e = move-exception;
            Monitor.get().logError("Fail to load dex file");
            throw new RuntimeException(e);
        }

        @Override // com.bytedance.boost_multidex.DexHolder
        public DexHolder toFasterHolder(SharedPreferences r1) {
            return null;
        }

        public String toString() {
            return super.toString() + ", index: " + this.mIndex + ", [file: " + this.mFile.getPath() + ", size: " + this.mFile.length() + "], [opt file: " + this.mOptFile + ", size: " + this.mOptFile.length() + "]";
        }
    }

    DexHolder() {
    }

    static DexHolder obtainValidDexBuffer(SharedPreferences r1, int r2, File r3, File r4) {
        SharedPreferences.Editor r5 = r1.edit();
        putTypeInfo(r5, r2, 1);
        putDexFileInfo(r5, r2, r3);
        r5.commit();
        return new DexBuffer(r2, r3, r4);
    }

    static DexHolder obtainValidDexOpt(SharedPreferences r1, int r2, File r3, File r4) {
        SharedPreferences.Editor r5 = r1.edit();
        putTypeInfo(r5, r2, 2);
        putDexOptInfo(r5, r2, r4);
        r5.commit();
        return new DexOpt(r2, r3, r4, false);
    }

    static DexHolder obtainValidForceDexOpt(SharedPreferences r0, int r1, File r2, File r3, ZipFile r4, ZipEntry r5) {
        File r6 = Utility.obtainEntryFileInZip(r4, r5, r2);
        SharedPreferences.Editor r7 = r0.edit();
        putTypeInfo(r7, r1, 2);
        putDexFileInfo(r7, r1, r6);
        r7.commit();
        return new DexOpt(r1, r6, r3, true);
    }

    static ZipOpt obtainValidZipDex(SharedPreferences r0, int r1, File r2, File r3, ZipFile r4, ZipEntry r5) {
        Utility.obtainZipForEntryFileInZip(r4, r5, r2);
        SharedPreferences.Editor r6 = r0.edit();
        putTypeInfo(r6, r1, 3);
        putZipOptInfo(r6, r1, r2);
        r6.commit();
        return new ZipOpt(r1, r2, r3);
    }

    private static void putDexFileInfo(SharedPreferences.Editor r7, int r8, File r9) {
        long r0 = Utility.doFileCheckSum(r9);
        r7.putLong(Constants.KEY_DEX_CHECKSUM + r8, r0);
        long r4 = r9.lastModified();
        r7.putLong(Constants.KEY_DEX_TIME + r8, r4);
        Monitor.get().logInfo("Put f key " + Constants.KEY_DEX_CHECKSUM + Constants.KEY_DEX_TIME + r8 + " checksum=" + r0 + ", time=" + r4);
    }

    private static void putDexOptInfo(SharedPreferences.Editor r7, int r8, File r9) {
        long r0 = r9.length();
        r7.putLong(Constants.KEY_ODEX_CHECKSUM + r8, r0);
        long r4 = r9.lastModified();
        r7.putLong(Constants.KEY_ODEX_TIME + r8, r4);
        Monitor.get().logInfo("Put o key " + Constants.KEY_ODEX_CHECKSUM + Constants.KEY_ODEX_TIME + r8 + " checksum=" + r0 + ", time=" + r4);
    }

    private static void putTypeInfo(SharedPreferences.Editor r2, int r3, int r4) {
        r2.putInt(Constants.KEY_DEX_OBJ_TYPE + r3, r4);
    }

    private static void putZipOptInfo(SharedPreferences.Editor r7, int r8, File r9) {
        long r0 = Utility.doZipCheckSum(r9);
        r7.putLong(Constants.KEY_DEX_CHECKSUM + r8, r0);
        long r4 = r9.lastModified();
        r7.putLong(Constants.KEY_DEX_TIME + r8, r4);
        Monitor.get().logInfo("Put z key " + Constants.KEY_DEX_CHECKSUM + Constants.KEY_DEX_TIME + r8 + " checksum=" + r0 + ", time=" + r4);
    }

    abstract StoreInfo getInfo();

    abstract Object toDexFile();

    protected Object toDexListElement(DexLoader.ElementConstructor r2) {
        Object r0 = toDexFile();
        if (r0 != null) goto L6;
        return null;
    L6:
        return r2.newInstance(this.mFile, r0);
    }

    abstract DexHolder toFasterHolder(SharedPreferences r1);
}
