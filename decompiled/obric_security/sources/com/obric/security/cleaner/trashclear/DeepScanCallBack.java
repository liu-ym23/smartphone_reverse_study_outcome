package com.obric.security.cleaner.trashclear;

import com.bytedanceos.securitycenter.SecurityCenterApplication;
import com.obric.olog.OLog;
import com.obric.security.cleaner.CustomRubbishEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tmsdk.fg.module.cleanV2.IScanTaskCallBack;
import tmsdk.fg.module.cleanV2.RubbishEntity;
import tmsdk.fg.module.cleanV2.RubbishHolder;

/* JADX INFO: loaded from: classes4.dex */
public class DeepScanCallBack implements IScanTaskCallBack {
    public RubbishHolder currentRubbish;
    private ArrayList<ScanStatusCallBack> scanStatusCallBacks;
    public int sdkStatus;
    public HashMap<String, Long> sizeMap;
    public List<RubbishEntity> softCacheRubbish;
    public HashMap<RubbishEntity, Boolean> uiSelectedItem;
    public List<RubbishEntity> unInstallRubbishes;

    @Override // tmsdk.fg.module.cleanV2.IScanTaskCallBack
    public void onRubbishFound(RubbishEntity rubbishEntity) {
    }

    public DeepScanCallBack() {
        this.sdkStatus = 0;
        this.uiSelectedItem = new HashMap();
        this.sizeMap = new HashMap();
        this.scanStatusCallBacks = new ArrayList();
    }

    public void removeScanStatusCallBack(ScanStatusCallBack scanStatusCallBack) {
        this.scanStatusCallBacks.remove(scanStatusCallBack);
    }

    public void addScanStatusCallBack(ScanStatusCallBack scanStatusCallBack) {
        if (this.scanStatusCallBacks.contains(scanStatusCallBack) == false) goto L5;
        return;
    L5:
        this.scanStatusCallBacks.add(scanStatusCallBack);
    }

    @Override // tmsdk.fg.module.cleanV2.IScanTaskCallBack
    public void onScanStarted() {
        this.sdkStatus = 1;
        Iterator<ScanStatusCallBack> r1 = this.scanStatusCallBacks.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().onScanStarted();
        goto L4
    L6:
        OLog.d("DeepScanCallBack", "onScanStarted:");
    }

    @Override // tmsdk.fg.module.cleanV2.IScanTaskCallBack
    public void onScanCanceled(RubbishHolder rubbishHolder) {
        OLog.d("DeepScanCallBack", "onScanCanceled:");
        this.sdkStatus = 0;
        this.currentRubbish = null;
    }

    @Override // tmsdk.fg.module.cleanV2.IScanTaskCallBack
    public void onScanFinished(RubbishHolder rubbishHolder) {
        CustomRubbishEntity r0 = ObricCleanManager.INSTANCE.scanThumbnailImages(SecurityCenterApplication.getApplication(), null);
        this.uiSelectedItem.clear();
        this.sizeMap.clear();
        rubbishHolder.getSuggetRubbishFileSize();
        OLog.d("DeepScanCallBack", "onScanFinished:");
        if (rubbishHolder.getmApkRubbishes() == null) goto L8;
        if (rubbishHolder.getmApkRubbishes().isEmpty() == true) goto L8;
        OLog.d("DeepScanCallBack", "onScanFinished:apk size:" + rubbishHolder.getmApkRubbishes().size());
        initSelectedItem(rubbishHolder.getmApkRubbishes());
    L8:
        if (rubbishHolder.getmSystemRubbishes() != null) goto L10;
    L12:
        if (r0 == null) goto L15;
        OLog.d("DeepScanCallBack", "onScanFinished:thumbnailImages size:" + r0.getSize());
        rubbishHolder.addRubbish("obric图库缩略图", r0);
    L15:
        if (rubbishHolder.getmInstallRubbishes() == null) goto L20;
        if (rubbishHolder.getmInstallRubbishes().isEmpty() == true) goto L20;
        OLog.d("DeepScanCallBack", "onScanFinished:install size:" + rubbishHolder.getmInstallRubbishes().size());
        initSelectedItem(rubbishHolder.getmInstallRubbishes().values());
    L20:
        if (rubbishHolder.getmUnInstallRubbishes() != null) goto L22;
    L24:
        this.sdkStatus = 2;
        this.currentRubbish = rubbishHolder;
        Iterator<ScanStatusCallBack> r5 = this.scanStatusCallBacks.iterator();
    L26:
        if (r5.hasNext() == false) goto L28;
        r5.next().onScanFinished();
        goto L26
    L28:
        return;
    L22:
        if (rubbishHolder.getmUnInstallRubbishes().isEmpty() == true) goto L24;
        OLog.d("DeepScanCallBack", "onScanFinished:uninstall size:" + rubbishHolder.getmUnInstallRubbishes().size());
        initSelectedItem(rubbishHolder.getmUnInstallRubbishes().values());
        goto L24
    L10:
        if (rubbishHolder.getmSystemRubbishes().isEmpty() == true) goto L12;
        OLog.d("DeepScanCallBack", "onScanFinished:system size:" + rubbishHolder.getmSystemRubbishes().size());
        initSelectedItem(rubbishHolder.getmSystemRubbishes().values());
        goto L12
    }

    @Override // tmsdk.fg.module.cleanV2.IScanTaskCallBack
    public void onScanError(int i, RubbishHolder rubbishHolder) {
        OLog.d("DeepScanCallBack", "onScanError :");
        this.sdkStatus = 0;
        this.currentRubbish = null;
    }

    @Override // tmsdk.fg.module.cleanV2.IScanTaskCallBack
    public void onDirectoryChange(String s, int i) {
        OLog.d("DeepScanCallBack", "onDirectoryChange :" + s + "\t" + i);
    }

    public void initSelectedItem(Collection<RubbishEntity> rubbishList) {
        if (rubbishList != null) goto L4;
        return;
    L4:
        if (rubbishList.isEmpty() == true) goto L12;
        Iterator<RubbishEntity> r4 = rubbishList.iterator();
    L8:
        if (r4.hasNext() == false) goto L13;
        RubbishEntity r0 = r4.next();
        r0.setStatus(0);
        this.sizeMap.putAll(r0.getSinglePathSizeMap());
        this.uiSelectedItem.put(r0, Boolean.valueOf(r0.isSuggest()));
        goto L8
    L13:
        return;
    }
}
