package com.ss.android.agilelogger;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.agilelogger.utils.FileUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ALogConfig {
    private String bufferDirPath;
    private boolean compress;
    private Context context;
    private boolean encrypt;
    private int level;
    private String logDirPath;
    private int logFileExpDays;
    private boolean mainThreadSpeedUp;
    private int maxDirSize;
    private int perSize;
    private String pubKey;

    /* JADX INFO: renamed from: com.ss.android.agilelogger.ALogConfig$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private String bufferDirPath;
        private boolean compress;
        private Context context;
        private boolean encrypt;
        private int level;
        private String logDirPath;
        private int logFileExpDays;
        private boolean mainThreadSpeedUp;
        private int maxDirSize;
        private int perSize;
        private String pubKey;

        public Builder(Context r3) {
            this.logFileExpDays = 14;
            this.maxDirSize = 20971520;
            this.perSize = 2097152;
            this.compress = true;
            this.encrypt = true;
            this.level = 3;
            this.pubKey = "fecbb32b759120b672045f74edc41d159b6a426ffc863b9e0be9ad4be12824546f549959b838993a430344f15197221e87bd362298814c75f5068148b980306f";
            this.mainThreadSpeedUp = true;
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

        public ALogConfig build() {
            ALogConfig r0 = new ALogConfig(null);
            r0.setContext(this.context);
            r0.setLogFileExpDays(this.logFileExpDays);
            r0.setMaxDirSize(this.maxDirSize);
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
            return r0;
        L9:
            r2 = this.logDirPath;
            goto L10
        L5:
            r1 = this.bufferDirPath;
            goto L6
        }

        public Builder setBufferDirPath(String r1) {
            this.bufferDirPath = r1;
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

        public Builder setLogDirPath(String r1) {
            this.logDirPath = r1;
            return this;
        }

        public Builder setLogFileExpDays(int r1) {
            this.logFileExpDays = r1;
            return this;
        }

        public Builder setMainThreadSpeedUp(boolean r1) {
            this.mainThreadSpeedUp = r1;
            return this;
        }

        public Builder setMaxDirSize(int r1) {
            this.maxDirSize = r1;
            return this;
        }

        public Builder setPerSize(int r1) {
            this.perSize = r1;
            return this;
        }

        public Builder setPubKey(String r1) {
            this.pubKey = r1;
            return this;
        }
    }

    public /* synthetic */ ALogConfig(AnonymousClass1 r1) {
        this();
    }

    public String getBufferDirPath() {
        return this.bufferDirPath;
    }

    public Context getContext() {
        return this.context;
    }

    public int getLevel() {
        return this.level;
    }

    public String getLogDirPath() {
        return this.logDirPath;
    }

    public int getLogFileExpDays() {
        return this.logFileExpDays;
    }

    public int getMaxDirSize() {
        return this.maxDirSize;
    }

    public int getPerSize() {
        return this.perSize;
    }

    public String getPubKey() {
        return this.pubKey;
    }

    public boolean isCompress() {
        return this.compress;
    }

    public boolean isEncrypt() {
        return this.encrypt;
    }

    public boolean isMainThreadSpeedUp() {
        return this.mainThreadSpeedUp;
    }

    public void setBufferDirPath(String r1) {
        this.bufferDirPath = r1;
    }

    public void setCompress(boolean r1) {
        this.compress = r1;
    }

    public void setContext(Context r1) {
        this.context = r1;
    }

    public void setEncrypt(boolean r1) {
        this.encrypt = r1;
    }

    public void setLevel(int r1) {
        this.level = r1;
    }

    public void setLogDirPath(String r1) {
        this.logDirPath = r1;
    }

    public void setLogFileExpDays(int r1) {
        this.logFileExpDays = r1;
    }

    public void setMainThreadSpeedUp(boolean r1) {
        this.mainThreadSpeedUp = r1;
    }

    public void setMaxDirSize(int r1) {
        this.maxDirSize = r1;
    }

    public void setPerSize(int r1) {
        this.perSize = r1;
    }

    public void setPubKey(String r1) {
        this.pubKey = r1;
    }

    private ALogConfig() {
    }
}
