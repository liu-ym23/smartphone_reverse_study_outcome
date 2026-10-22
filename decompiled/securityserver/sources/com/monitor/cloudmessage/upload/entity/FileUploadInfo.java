package com.monitor.cloudmessage.upload.entity;

import androidx.annotation.NonNull;
import com.monitor.cloudmessage.upload.callback.IFileUploadCallback;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class FileUploadInfo extends UploadInfo {

    @NonNull
    protected IFileUploadCallback callback;
    protected String fileType;
    protected boolean forceUseState;
    protected boolean isCompress;
    protected boolean isDelSourceFile;
    protected boolean isMultiFileInOneZip;
    protected boolean isSkipUploadInternal;
    private List<String> mUploadFileAbsluteNames;

    public FileUploadInfo(String r7, long r8, boolean r10, String r11, @NonNull IFileUploadCallback r12, HashMap<String, String> r13) {
        super(r8, r10, r11, r13);
        this.isSkipUploadInternal = true;
        this.isCompress = true;
        this.isMultiFileInOneZip = true;
        this.isDelSourceFile = false;
        this.forceUseState = false;
        this.fileType = r7;
        this.callback = r12;
    }

    @NonNull
    public IFileUploadCallback getCallback() {
        return this.callback;
    }

    public String getFileType() {
        return this.fileType;
    }

    public List<String> getUploadFileAbsluteNames() {
        return this.mUploadFileAbsluteNames;
    }

    public boolean isCompress() {
        return this.isCompress;
    }

    public boolean isDelSourceFile() {
        return this.isDelSourceFile;
    }

    public boolean isForceUseState() {
        return this.forceUseState;
    }

    public boolean isMultiFileInOneZip() {
        return this.isMultiFileInOneZip;
    }

    public boolean isSkipUploadInternal() {
        return this.isSkipUploadInternal;
    }

    public void setCallback(@NonNull IFileUploadCallback r1) {
        this.callback = r1;
    }

    public void setCompress(boolean r1) {
        this.isCompress = r1;
    }

    public void setDelSourceFile(boolean r1) {
        this.isDelSourceFile = r1;
    }

    public void setFileType(String r1) {
        this.fileType = r1;
    }

    public void setForceUseState(boolean r1) {
        this.forceUseState = r1;
    }

    public void setMultiFileInOneZip(boolean r1) {
        this.isMultiFileInOneZip = r1;
    }

    public void setSkipUploadInternal(boolean r1) {
        this.isSkipUploadInternal = r1;
    }

    public void setUploadFileAbsluteNames(List<String> r1) {
        this.mUploadFileAbsluteNames = r1;
    }
}
