package com.bytedance.apm6.cpu.exception;

import com.bytedance.librarian.LibrarianImpl;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class ThreadExceptionItem {
    private double cpuUsage;
    private StackTraceElement firstElement;
    private int priority;
    private long processCpuTime;
    private String stack;
    private long threadCpuTime;
    private int threadId;
    private String threadName;
    private String weight;

    public ThreadExceptionItem() {
    }

    public StackTraceElement getFirstElement() {
        return this.firstElement;
    }

    public void setFirstElement(StackTraceElement r1) {
        this.firstElement = r1;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int r1) {
        this.priority = r1;
    }

    public String getWeight() {
        return this.weight;
    }

    public void setWeight(String r1) {
        this.weight = r1;
    }

    public long getProcessCpuTime() {
        return this.processCpuTime;
    }

    public void setProcessCpuTime(long r1) {
        this.processCpuTime = r1;
    }

    public String getStack() {
        return this.stack;
    }

    public void setStack(String r1) {
        this.stack = r1;
    }

    public double getCpuUsage() {
        return this.cpuUsage;
    }

    public void setCpuUsage(double r1) {
        this.cpuUsage = r1;
    }

    public int getThreadId() {
        return this.threadId;
    }

    public void setThreadId(int r1) {
        this.threadId = r1;
    }

    public String getThreadName() {
        return this.threadName;
    }

    public void setThreadName(String r1) {
        this.threadName = r1;
    }

    public long getThreadCpuTime() {
        return this.threadCpuTime;
    }

    public void setThreadCpuTime(long r1) {
        this.threadCpuTime = r1;
    }

    public String getKey() {
        return this.threadName + LibrarianImpl.Constants.SEPARATOR + this.threadId;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ThreadExceptionItem) == true) goto L8;
        return false;
    L8:
        ThreadExceptionItem r6 = (ThreadExceptionItem) r5;
        if (getThreadId() != r6.getThreadId()) goto L14;
        if (getThreadName().equals(r6.getThreadName()) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(getThreadId()), getThreadName()});
    }

    public String toString() {
        return "ThreadExceptionItem{threadId=" + this.threadId + ", threadName='" + this.threadName + "', threadCpuTime=" + this.threadCpuTime + ", processCpuTime=" + this.processCpuTime + ", cpuUsage=" + this.cpuUsage + ", weight=" + this.weight + ", nice=" + this.priority + '}';
    }
}
