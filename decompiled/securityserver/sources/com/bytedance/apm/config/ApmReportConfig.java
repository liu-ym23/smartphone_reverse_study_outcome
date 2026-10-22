package com.bytedance.apm.config;

/* JADX INFO: loaded from: classes.dex */
public class ApmReportConfig {
    public static final int REPORT_SMALL_BATCH_ONCE_SIZE_BYTES = 512000;
    private long onceReportMaxSizeBytes;
    private int reportMode;

    /* JADX INFO: renamed from: com.bytedance.apm.config.ApmReportConfig$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private long onceReportMaxSizeBytes;
        private int reportMode;

        public Builder() {
            this.reportMode = 0;
            this.onceReportMaxSizeBytes = 2147483647L;
        }

        public static /* synthetic */ int access$000(Builder r0) {
            return r0.reportMode;
        }

        public static /* synthetic */ long access$100(Builder r2) {
            return r2.onceReportMaxSizeBytes;
        }

        public ApmReportConfig build() {
            return new ApmReportConfig(this, null);
        }

        public Builder setOnceReportMaxSizeBytes(int r3) {
            this.onceReportMaxSizeBytes = r3;
            return this;
        }

        public Builder setReportMode(int r3) {
            this.reportMode = r3;
            if (r3 != 1) goto L5;
            this.onceReportMaxSizeBytes = 512000;
        L5:
            return this;
        }
    }

    public /* synthetic */ ApmReportConfig(Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public long getOnceReportMaxSizeBytes() {
        return this.onceReportMaxSizeBytes;
    }

    public int getReportMode() {
        return this.reportMode;
    }

    private ApmReportConfig(Builder r3) {
        this.reportMode = Builder.access$000(r3);
        this.onceReportMaxSizeBytes = Builder.access$100(r3);
    }
}
