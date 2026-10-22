package com.bytedance.watson.assist.api;

import androidx.core.os.EnvironmentCompat;

/* JADX INFO: loaded from: classes.dex */
public class AssistConfig {
    public static AssistConfig DEFAULT;
    private CpuAbnormalConfig cpuAbnormalConfig;
    private int cpuSampleBatteryLevel;
    private int cpuSampleBatteryTemp;
    public boolean enableProcessCpuUsageStat;
    public boolean enableProcessTimeFreqPercent;
    public boolean enableSystemCpuTimeFreqPercent;
    public boolean enableSystemCpuUsageStat;
    public boolean enableThreadCpuUsageStat;

    public static class CpuAbnormalConfig {
        private float BigCpuCoreTimePercent;
        private String cpuHardWare;
        private float cpuSpeed;
        private float middleCpuCoreTimePercent;
        private String scene;
        private float smallCpuCoreTimePercent;

        public CpuAbnormalConfig() {
            this.cpuHardWare = EnvironmentCompat.MEDIA_UNKNOWN;
            this.scene = "default";
            this.cpuSpeed = 0.0f;
            this.smallCpuCoreTimePercent = 0.0f;
            this.middleCpuCoreTimePercent = 0.0f;
            this.BigCpuCoreTimePercent = 0.0f;
        }

        public float getBigCpuCoreTimePercent() {
            return this.BigCpuCoreTimePercent;
        }

        public String getCpuHardWare() {
            return this.cpuHardWare;
        }

        public float getCpuSpeed() {
            return this.cpuSpeed;
        }

        public float getMiddleCpuCoreTimePercent() {
            return this.middleCpuCoreTimePercent;
        }

        public String getScene() {
            return this.scene;
        }

        public float getSmallCpuCoreTimePercent() {
            return this.smallCpuCoreTimePercent;
        }

        public void setBigCpuCoreTimePercent(float r1) {
            this.BigCpuCoreTimePercent = r1;
        }

        public void setCpuHardWare(String r1) {
            this.cpuHardWare = r1;
        }

        public void setCpuSpeed(float r1) {
            this.cpuSpeed = r1;
        }

        public void setMiddleCpuCoreTimePercent(float r1) {
            this.middleCpuCoreTimePercent = r1;
        }

        public void setScene(String r1) {
            this.scene = r1;
        }

        public void setSmallCpuCoreTimePercent(float r1) {
            this.smallCpuCoreTimePercent = r1;
        }

        public String toString() {
            return "CpuAbnormalConfig{cpuHardWare='" + this.cpuHardWare + "', scene='" + this.scene + "', cpuSpeed=" + this.cpuSpeed + ", smallCpuCoreTimePercent=" + this.smallCpuCoreTimePercent + ", middleCpuCoreTimePercent=" + this.middleCpuCoreTimePercent + ", BigCpuCoreTimePercent=" + this.BigCpuCoreTimePercent + '}';
        }

        public CpuAbnormalConfig(String r2, String r3) {
            this.cpuSpeed = 0.0f;
            this.smallCpuCoreTimePercent = 0.0f;
            this.middleCpuCoreTimePercent = 0.0f;
            this.BigCpuCoreTimePercent = 0.0f;
            this.scene = r2;
            this.cpuHardWare = r3;
        }
    }

    static {
        DEFAULT = new AssistConfig();
    }

    public AssistConfig() {
        this.enableProcessCpuUsageStat = false;
        this.enableThreadCpuUsageStat = false;
        this.enableSystemCpuUsageStat = false;
        this.enableProcessTimeFreqPercent = false;
        this.enableSystemCpuTimeFreqPercent = false;
        this.cpuSampleBatteryTemp = 37;
        this.cpuSampleBatteryLevel = 30;
        this.cpuAbnormalConfig = new CpuAbnormalConfig();
    }

    public CpuAbnormalConfig getCpuAbnormalConfig() {
        return this.cpuAbnormalConfig;
    }

    public int getCpuSampleBatteryLevel() {
        return this.cpuSampleBatteryLevel;
    }

    public int getCpuSampleBatteryTemp() {
        return this.cpuSampleBatteryTemp;
    }

    public boolean isEnableCpuUsageStat() {
        return this.enableProcessCpuUsageStat;
    }

    public boolean isEnableProcessTimeFreqPercent() {
        return this.enableProcessTimeFreqPercent;
    }

    public boolean isEnableSystemCpuTimeFreqPercent() {
        return this.enableSystemCpuTimeFreqPercent;
    }

    public boolean isEnableSystemCpuUsageStat() {
        return this.enableSystemCpuUsageStat;
    }

    public boolean isEnableThreadCpuUsageStat() {
        return this.enableThreadCpuUsageStat;
    }

    public void setCpuAbnormalConfig(CpuAbnormalConfig r1) {
        this.cpuAbnormalConfig = r1;
    }

    public void setCpuSampleBatteryLevel(int r1) {
        this.cpuSampleBatteryLevel = r1;
    }

    public void setCpuSampleBatteryTemp(int r1) {
        this.cpuSampleBatteryTemp = r1;
    }

    public void setEnableCpuUsageStat(boolean r1) {
        this.enableProcessCpuUsageStat = r1;
    }

    public void setEnableProcessTimeFreqPercent(boolean r1) {
        this.enableProcessTimeFreqPercent = r1;
    }

    public void setEnableSystemCpuTimeFreqPercent(boolean r1) {
        this.enableSystemCpuTimeFreqPercent = r1;
    }

    public void setEnableSystemCpuUsageStat(boolean r1) {
        this.enableSystemCpuUsageStat = r1;
    }

    public void setEnableThreadCpuUsageStat(boolean r1) {
        this.enableThreadCpuUsageStat = r1;
    }

    public String toString() {
        return "AssistConfig{enableProcessCpuUsageStat=" + this.enableProcessCpuUsageStat + ", enableThreadCpuUsageStat=" + this.enableThreadCpuUsageStat + ", enableSystemCpuUsageStat=" + this.enableSystemCpuUsageStat + ", enableProcessTimeFreqPercent=" + this.enableProcessTimeFreqPercent + ", enableSystemCpuTimeFreqPercent=" + this.enableSystemCpuTimeFreqPercent + ", cpuSampleBatteryTemp=" + this.cpuSampleBatteryTemp + ", cpuSampleBatteryLevel=" + this.cpuSampleBatteryLevel + ", cpuAbnormalConfig=" + this.cpuAbnormalConfig + '}';
    }

    public AssistConfig(CpuAbnormalConfig r2) {
        this.enableProcessCpuUsageStat = false;
        this.enableThreadCpuUsageStat = false;
        this.enableSystemCpuUsageStat = false;
        this.enableProcessTimeFreqPercent = false;
        this.enableSystemCpuTimeFreqPercent = false;
        this.cpuSampleBatteryTemp = 37;
        this.cpuSampleBatteryLevel = 30;
        new CpuAbnormalConfig();
        this.cpuAbnormalConfig = r2;
    }
}
