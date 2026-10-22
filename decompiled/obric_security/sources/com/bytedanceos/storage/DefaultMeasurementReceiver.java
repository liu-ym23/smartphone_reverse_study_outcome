package com.bytedanceos.storage;

import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultMeasurementReceiver implements StorageMeasurement.MeasurementReceiver {
    public DefaultMeasurementReceiver() {
    }

    @Override // com.bytedanceos.storage.StorageMeasurement.MeasurementReceiver
    public void updateApproximate(StorageMeasurement meas, long totalSize, long availSize) {
        OLog.d("DefaultMeasurementReceiver", "updateApproximate: totalSize = " + totalSize + ", availSize = " + availSize);
    }

    @Override // com.bytedanceos.storage.StorageMeasurement.MeasurementReceiver
    public void updateDetails(StorageMeasurement meas, StorageMeasurement.MeasurementDetails details) {
        OLog.d("DefaultMeasurementReceiver", "updateDetails: totalSize = " + details.totalSize + ", availSize = " + details.availSize);
    }

    @Override // com.bytedanceos.storage.StorageMeasurement.MeasurementReceiver
    public void updateMediaSize(StorageMeasurement meas, StorageMeasurement.MeasurementDetails details) {
        OLog.d("DefaultMeasurementReceiver", "updateMediaSize: totalSize = " + details.totalSize + ", availSize = " + details.availSize);
    }

    @Override // com.bytedanceos.storage.StorageMeasurement.MeasurementReceiver
    public void updateUserSize(StorageMeasurement meas, StorageMeasurement.MeasurementDetails details) {
        OLog.d("DefaultMeasurementReceiver", "updateUserSize: totalSize = " + details.totalSize + ", availSize = " + details.availSize);
    }

    @Override // com.bytedanceos.storage.StorageMeasurement.MeasurementReceiver
    public void updateAudioSize(StorageMeasurement meas, StorageMeasurement.MeasurementDetails details) {
        OLog.d("DefaultMeasurementReceiver", "updateAudioSize: totalSize = " + details.totalSize + ", availSize = " + details.availSize);
    }

    @Override // com.bytedanceos.storage.StorageMeasurement.MeasurementReceiver
    public void updateAppSize(StorageMeasurement meas, StorageMeasurement.MeasurementDetails details) {
        OLog.d("DefaultMeasurementReceiver", "updateAppSize: totalSize = " + details.totalSize + ", availSize = " + details.availSize);
    }

    @Override // com.bytedanceos.storage.StorageMeasurement.MeasurementReceiver
    public void updateOtherFileSize(StorageMeasurement meas, StorageMeasurement.MeasurementDetails details) {
        OLog.d("DefaultMeasurementReceiver", "updateOtherFileSize: totalSize = " + details.totalSize + ", availSize = " + details.availSize);
    }
}
