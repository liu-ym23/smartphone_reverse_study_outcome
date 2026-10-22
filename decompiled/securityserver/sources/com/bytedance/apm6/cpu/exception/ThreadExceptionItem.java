package com.bytedance.apm6.cpu.exception;

import a.a;
import com.bytedance.librarian.LibrarianImpl;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
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

    public double getCpuUsage() {
        return this.cpuUsage;
    }

    public StackTraceElement getFirstElement() {
        return this.firstElement;
    }

    public String getKey() {
        return this.threadName + LibrarianImpl.Constants.SEPARATOR + this.threadId;
    }

    public int getPriority() {
        return this.priority;
    }

    public long getProcessCpuTime() {
        return this.processCpuTime;
    }

    public String getStack() {
        return this.stack;
    }

    public long getThreadCpuTime() {
        return this.threadCpuTime;
    }

    public int getThreadId() {
        return this.threadId;
    }

    public String getThreadName() {
        return this.threadName;
    }

    public String getWeight() {
        return this.weight;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(getThreadId()), getThreadName()});
    }

    public void setCpuUsage(double r1) {
        this.cpuUsage = r1;
    }

    public void setFirstElement(StackTraceElement r1) {
        this.firstElement = r1;
    }

    public void setPriority(int r1) {
        this.priority = r1;
    }

    public void setProcessCpuTime(long r1) {
        this.processCpuTime = r1;
    }

    public void setStack(String r1) {
        this.stack = r1;
    }

    public void setThreadCpuTime(long r1) {
        this.threadCpuTime = r1;
    }

    public void setThreadId(int r1) {
        this.threadId = r1;
    }

    public void setThreadName(String r1) {
        this.threadName = r1;
    }

    public void setWeight(String r1) {
        this.weight = r1;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("ThreadExceptionItem{threadId=");
        r0.append(this.threadId);
        r0.append(", threadName='");
        r0.append(this.threadName);
        r0.append("', threadCpuTime=");
        r0.append(this.threadCpuTime);
        r0.append(", processCpuTime=");
        r0.append(this.processCpuTime);
        r0.append(", cpuUsage=");
        r0.append(this.cpuUsage);
        r0.append(", weight=");
        r0.append(this.weight);
        r0.append(", nice=");
        return a.l(r0, this.priority, '}');
    }
}
