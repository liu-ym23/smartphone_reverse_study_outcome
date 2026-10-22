package com.bytedance.apm6.cpu.config;

import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class CpuExceptionConfig {
    private static final double DEFAULT_MAX_PROCESS_BACK_CPU_SPEED = 3.0d;
    private static final double DEFAULT_MAX_PROCESS_FORE_CPU_SPEED = 6.0d;
    private static final double DEFAULT_MAX_THREAD_CPU_RATE = 0.05d;
    private Map<String, Double> backSceneMaxSpeedMap;
    private Map<String, Double> foreSceneMaxSpeedMap;
    private boolean isCollectAllProcess;
    private boolean isCollectMainThread;
    private boolean isCollectNativeThread;
    private boolean isCollectThreadStack;
    private boolean isOpen;
    private double maxProcessBackCpuSpeed;
    private double maxProcessForeCpuSpeed;
    private double maxThreadCpuRate;
    private Map<String, Double> maxThreadCpuRateMap;
    private int processDetectInterval;
    private int threadDetectInterval;

    public CpuExceptionConfig() {
        this.isOpen = false;
        this.isCollectMainThread = false;
        this.maxProcessBackCpuSpeed = DEFAULT_MAX_PROCESS_BACK_CPU_SPEED;
        this.maxProcessForeCpuSpeed = DEFAULT_MAX_PROCESS_FORE_CPU_SPEED;
        this.maxThreadCpuRate = DEFAULT_MAX_THREAD_CPU_RATE;
        this.isCollectAllProcess = false;
        this.isCollectThreadStack = true;
        this.isCollectNativeThread = false;
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    public void setOpen(boolean r1) {
        this.isOpen = r1;
    }

    public Map<String, Double> getBackSceneMaxSpeedMap() {
        return this.backSceneMaxSpeedMap;
    }

    public void setBackSceneMaxSpeedMap(Map<String, Double> r1) {
        this.backSceneMaxSpeedMap = r1;
    }

    public Map<String, Double> getForeSceneMaxSpeedMap() {
        return this.foreSceneMaxSpeedMap;
    }

    public void setForeSceneMaxSpeedMap(Map<String, Double> r1) {
        this.foreSceneMaxSpeedMap = r1;
    }

    public boolean isCollectMainThread() {
        return this.isCollectMainThread;
    }

    public void setCollectMainThread(boolean r1) {
        this.isCollectMainThread = r1;
    }

    public double getMaxProcessBackCpuSpeed() {
        return this.maxProcessBackCpuSpeed;
    }

    public void setMaxProcessBackCpuSpeed(double r1) {
        this.maxProcessBackCpuSpeed = r1;
    }

    public double getMaxThreadCpuRate() {
        return this.maxThreadCpuRate;
    }

    public void setMaxThreadCpuRate(double r1) {
        this.maxThreadCpuRate = r1;
    }

    public Map<String, Double> getMaxThreadCpuRateMap() {
        return this.maxThreadCpuRateMap;
    }

    public void setMaxThreadCpuRateMap(Map<String, Double> r1) {
        this.maxThreadCpuRateMap = r1;
    }

    public boolean isCollectAllProcess() {
        return this.isCollectAllProcess;
    }

    public void setCollectAllProcess(boolean r1) {
        this.isCollectAllProcess = r1;
    }

    public double getMaxProcessForeCpuSpeed() {
        return this.maxProcessForeCpuSpeed;
    }

    public void setMaxProcessForeCpuSpeed(double r1) {
        this.maxProcessForeCpuSpeed = r1;
    }

    public String toString() {
        return "CpuExceptionConfig{isOpen=" + this.isOpen + ", isCollectMainThread=" + this.isCollectMainThread + ", maxProcessBackCpuSpeed=" + this.maxProcessBackCpuSpeed + ", maxProcessForeCpuSpeed=" + this.maxProcessForeCpuSpeed + ", maxThreadCpuRate=" + this.maxThreadCpuRate + ", isCollectAllProcess=" + this.isCollectAllProcess + ", backSceneMaxSpeedMap=" + this.backSceneMaxSpeedMap + ", foreSceneMaxSpeedMap=" + this.foreSceneMaxSpeedMap + '}';
    }

    public boolean isCollectThreadStack() {
        return this.isCollectThreadStack;
    }

    public void setCollectThreadStack(boolean r1) {
        this.isCollectThreadStack = r1;
    }

    public int getProcessDetectInterval() {
        return this.processDetectInterval;
    }

    public void setProcessDetectInterval(int r1) {
        this.processDetectInterval = r1;
    }

    public int getThreadDetectInterval() {
        return this.threadDetectInterval;
    }

    public void setThreadDetectInterval(int r1) {
        this.threadDetectInterval = r1;
    }

    public boolean isCollectNativeThread() {
        return this.isCollectNativeThread;
    }

    public void setCollectNativeThread(boolean r1) {
        this.isCollectNativeThread = r1;
    }
}
