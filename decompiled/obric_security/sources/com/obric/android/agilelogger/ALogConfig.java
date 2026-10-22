package com.obric.android.agilelogger;

import android.content.Context;
import android.text.TextUtils;
import com.obric.android.agilelogger.utils.FileUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ALogConfig {
    private String bufferDirPath;
    private int cacheFileSizeInKB;
    private boolean compress;
    private Context context;
    private boolean enableOffloadInAllProcess;
    private boolean enableOffloadInAllThread;
    private boolean encrypt;
    private int level;
    private String logDirPath;
    private int logFileExpDays;
    private boolean mainThreadSpeedUp;
    private int maxDirSize;
    private boolean newThreadPoolImplementation;
    private boolean offloadMainThreadWrite;
    private int perSize;
    private String pubKey;
    private float subProcessMaxDirSizeRatio;

    /* JADX INFO: renamed from: com.obric.android.agilelogger.ALogConfig$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private String bufferDirPath;
        private int cacheFileSizeInKB;
        private boolean compress;
        private Context context;
        private boolean enableOffloadInAllProcess;
        private boolean enableOffloadInAllThread;
        private boolean encrypt;
        private int level;
        private String logDirPath;
        private int logFileExpDays;
        private boolean mainThreadSpeedUp;
        private int maxDirSize;
        private boolean newThreadPoolImplementation;
        private boolean offloadMainThreadWrite;
        private int perSize;
        private String pubKey;
        private float subProcessMaxDirSizeRatio;

        public Builder(Context r3) {
            this.logFileExpDays = 14;
            this.maxDirSize = 20971520;
            this.subProcessMaxDirSizeRatio = 0.1f;
            this.perSize = 2097152;
            this.compress = true;
            this.encrypt = true;
            this.level = 3;
            this.pubKey = "fecbb32b759120b672045f74edc41d159b6a426ffc863b9e0be9ad4be12824546f549959b838993a430344f15197221e87bd362298814c75f5068148b980306f";
            this.mainThreadSpeedUp = true;
            this.offloadMainThreadWrite = false;
            this.enableOffloadInAllProcess = false;
            this.newThreadPoolImplementation = false;
            this.enableOffloadInAllThread = false;
            this.cacheFileSizeInKB = 256;
            if (r3 == null) goto L10;
            Context r0 = r3.getApplicationContext();
            if (r0 == null) goto L7;
            r3 = r0;
        L7:
            this.context = r3;
            return;
        L10:
            throw new RuntimeException("context must not be null");
        }

        public Builder setLogFileExpDays(int r1) {
            this.logFileExpDays = r1;
            return this;
        }

        public Builder setMaxDirSize(int r1) {
            this.maxDirSize = r1;
            return this;
        }

        public Builder setSubProcessMaxDirSizeRatio(float r1) {
            this.subProcessMaxDirSizeRatio = r1;
            return this;
        }

        public Builder setPerSize(int r1) {
            this.perSize = r1;
            return this;
        }

        public Builder setBufferDirPath(String r1) {
            this.bufferDirPath = r1;
            return this;
        }

        public Builder setLogDirPath(String r1) {
            this.logDirPath = r1;
            return this;
        }

        public Builder setCompress(boolean r1) {
            this.compress = r1;
            return this;
        }

        public Builder setEncrypt(boolean r1) {
            this.encrypt = r1;
            return this;
        }

        public Builder setLevel(int r1) {
            this.level = r1;
            return this;
        }

        public Builder setPubKey(String r1) {
            this.pubKey = r1;
            return this;
        }

        public Builder setMainThreadSpeedUp(boolean r1) {
            this.mainThreadSpeedUp = r1;
            return this;
        }

        public Builder setOffloadMainThreadWrite(boolean r1) {
            this.offloadMainThreadWrite = r1;
            return this;
        }

        public Builder setEnableOffloadInAllProcess(boolean r1) {
            this.enableOffloadInAllProcess = r1;
            return this;
        }

        public Builder setEnableOffloadInAllThread(boolean r1) {
            this.enableOffloadInAllThread = r1;
            return this;
        }

        public Builder setNewThreadPoolImplementation(boolean r1) {
            this.newThreadPoolImplementation = r1;
            return this;
        }

        public Builder setCacheFileSizeInKB(int r1) {
            this.cacheFileSizeInKB = r1;
            return this;
        }

        public ALogConfig build() {
            ALogConfig r0 = new ALogConfig(null);
            r0.setContext(this.context);
            r0.setLogFileExpDays(this.logFileExpDays);
            r0.setMaxDirSize(this.maxDirSize);
            r0.setSubProcessMaxDirSizeRatio(this.subProcessMaxDirSizeRatio);
            r0.setPerSize(this.perSize);
            if (TextUtils.isEmpty(this.bufferDirPath) == false) goto L5;
            String r1 = FileUtils.getBufferDirPath(this.context);
        L6:
            r0.setBufferDirPath(r1);
            if (TextUtils.isEmpty(this.logDirPath) == false) goto L9;
            String r2 = FileUtils.getDefaultLogDir(this.context).getAbsolutePath();
        L10:
            r0.setLogDirPath(r2);
            r0.setCompress(this.compress);
            r0.setEncrypt(this.encrypt);
            r0.setLevel(this.level);
            r0.setPubKey(this.pubKey);
            r0.setMainThreadSpeedUp(this.mainThreadSpeedUp);
            r0.setOffloadMainThreadWrite(this.offloadMainThreadWrite);
            r0.setEnableOffloadInAllProcess(this.enableOffloadInAllProcess);
            r0.setEnableOffloadInAllThread(this.enableOffloadInAllThread);
            r0.setNewThreadPoolImplementation(this.newThreadPoolImplementation);
            r0.setCacheFileSizeInKB(this.cacheFileSizeInKB);
            return r0;
        L9:
            r2 = this.logDirPath;
            goto L10
        L5:
            r1 = this.bufferDirPath;
            goto L6
        }
    }

    /* synthetic */ ALogConfig(AnonymousClass1 r1) {
        this();
    }

    private ALogConfig() {
    }

    public Context getContext() {
        return this.context;
    }

    public void setContext(Context r1) {
        this.context = r1;
    }

    public int getLogFileExpDays() {
        return this.logFileExpDays;
    }

    public void setLogFileExpDays(int r1) {
        this.logFileExpDays = r1;
    }

    public int getMaxDirSize() {
        return this.maxDirSize;
    }

    public void setMaxDirSize(int r1) {
        this.maxDirSize = r1;
    }

    public void setSubProcessMaxDirSizeRatio(float r1) {
        this.subProcessMaxDirSizeRatio = r1;
    }

    public float getSubProcessMaxDirSizeRatio() {
        return this.subProcessMaxDirSizeRatio;
    }

    public int getPerSize() {
        return this.perSize;
    }

    public void setPerSize(int r1) {
        this.perSize = r1;
    }

    public String getBufferDirPath() {
        return this.bufferDirPath;
    }

    public void setBufferDirPath(String r1) {
        this.bufferDirPath = r1;
    }

    public String getLogDirPath() {
        return this.logDirPath;
    }

    public void setLogDirPath(String r1) {
        this.logDirPath = r1;
    }

    public boolean isCompress() {
        return this.compress;
    }

    public void setCompress(boolean r1) {
        this.compress = r1;
    }

    public boolean isEncrypt() {
        return this.encrypt;
    }

    public void setEncrypt(boolean r1) {
        this.encrypt = r1;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int r1) {
        this.level = r1;
    }

    public String getPubKey() {
        return this.pubKey;
    }

    public void setPubKey(String r1) {
        this.pubKey = r1;
    }

    public boolean isMainThreadSpeedUp() {
        return this.mainThreadSpeedUp;
    }

    public void setMainThreadSpeedUp(boolean r1) {
        this.mainThreadSpeedUp = r1;
    }

    public void setOffloadMainThreadWrite(boolean r1) {
        this.offloadMainThreadWrite = r1;
    }

    public boolean isOffloadMainThreadWrite() {
        return this.offloadMainThreadWrite;
    }

    public void setEnableOffloadInAllProcess(boolean r1) {
        this.enableOffloadInAllProcess = r1;
    }

    public boolean enableOffloadInAllProcess() {
        return this.enableOffloadInAllProcess;
    }

    public void setEnableOffloadInAllThread(boolean r1) {
        this.enableOffloadInAllThread = r1;
    }

    public boolean enableOffloadInAllThread() {
        return this.enableOffloadInAllThread;
    }

    public void setNewThreadPoolImplementation(boolean r1) {
        this.newThreadPoolImplementation = r1;
    }

    public boolean isNewThreadPoolImplementation() {
        return this.newThreadPoolImplementation;
    }

    public int getCacheFileSizeInKB() {
        return this.cacheFileSizeInKB;
    }

    public void setCacheFileSizeInKB(int r1) {
        this.cacheFileSizeInKB = r1;
    }
}
