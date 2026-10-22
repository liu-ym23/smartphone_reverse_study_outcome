package com.monitor.cloudmessage.upload;

import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.logging.Logger;
import com.bytedance.librarian.LibrarianImpl;
import com.monitor.cloudmessage.CloudMessageManager;
import com.monitor.cloudmessage.upload.entity.FileUploadInfo;
import com.monitor.cloudmessage.upload.entity.UploadInfo;
import com.monitor.cloudmessage.upload.net.CloudMessageUploadService;
import com.monitor.cloudmessage.utils.FileUtils;
import com.monitor.cloudmessage.utils.NetworkUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class CloudMessageUploadManager {
    private static ArrayList<FileUploadInfo> fileInfos;

    static {
        fileInfos = new ArrayList();
    }

    public CloudMessageUploadManager() {
    }

    private static boolean checkStateForUpload(FileUploadInfo r6) {
        if (r6.isUploading() == false) goto L6;
        return false;
    L6:
        if (r6.isSkipUploadInternal() == true) goto L11;
        if ((System.currentTimeMillis() - r6.getLastUploadTime()) >= 0) goto L11;
        return false;
    L11:
        if (NetworkUtils.isNetworkAvailable(CloudMessageManager.getInstance().getContext()) == true) goto L13;
        return false;
    L13:
        return true;
    }

    private static String getZipFileName(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L6;
        return "";
    L6:
        int r0 = r4.lastIndexOf(LibrarianImpl.Constants.DOT);
        if (r0 != (-1)) goto L11;
        return r4.concat("-cloudMsg.zip");
    L11:
        return r4.substring(0, r0) + "-cloudMsg.zip";
    }

    public static void upload(FileUploadInfo r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.getCallback() != null) goto L6;
        return;
    L6:
        if (r2.getCallback().getUploadFileList().size() != 0) goto L9;
        return;
    L9:
        if (checkStateForUpload(r2) == true) goto L12;
        return;
    L12:
        if (r2.isCompress() == true) goto L14;
        r2.setUploadFileAbsluteNames(r2.getCallback().getUploadFileList());
    L15:
        boolean r0 = CloudMessageUploadService.uploadFile(r2);
        if (r2.isDelSourceFile() == false) goto L31;
        if (r0 == false) goto L32;
        Iterator<String> r3 = r2.getCallback().getUploadFileList().iterator();
    L20:
        if (r3.hasNext() == false) goto L34;
        File r1 = new File(r3.next());
        if (r1.exists() == false) goto L20;
        r1.delete();
        goto L20
    L34:
        return;
    L32:
        return;
    L31:
        return;
    L14:
        zipUploadFile(r2);
        goto L15
    }

    private static void zipUploadFile(FileUploadInfo r6) {
        if (r6.getCallback().getUploadFileList().size() != 1) goto L5;
    L15:
        File r0 = new File(r6.getCallback().getUploadFileList().get(0));
        File r2 = new File(r0.getParent(), getZipFileName(r0.getName()));
        if (r2.exists() == false) goto L18;
        r2.delete();
    L18:
        String[] r1 = new String[r6.getCallback().getUploadFileList().size()];
        String[] r3 = (String[]) r6.getCallback().getUploadFileList().toArray(r1);
        FileUtils.compress(r2.getAbsolutePath(), r3);
        ArrayList r4 = new ArrayList(1);
        r4.add(r2.getAbsolutePath());
        r6.setUploadFileAbsluteNames(r4);
        return;
    L5:
        if (r6.isMultiFileInOneZip() == true) goto L15;
        ArrayList r5 = new ArrayList();
        Iterator<String> r7 = r6.getCallback().getUploadFileList().iterator();
    L9:
        if (r7.hasNext() == false) goto L14;
        String r8 = r7.next();
        File r9 = new File(r8);
        File r10 = new File(r9.getParent(), getZipFileName(r9.getName()));
        if (r10.exists() == false) goto L13;
        r10.delete();
    L13:
        FileUtils.compress(r10.getAbsolutePath(), new String[]{r8});
        r5.add(r10.getAbsolutePath());
        goto L9
    L14:
        r6.setUploadFileAbsluteNames(r5);
    }

    public static void upload(UploadInfo r2) {
        if (ApmContext.isDebugMode() == false) goto L5;
        Logger.d("cloudmessage", new String[]{"uploadInfo=" + r2});
    L5:
        if (r2 != null) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r2.getCommandId()) == true) goto L12;
        CloudMessageUploadService.uploadData(r2);
        return;
    }
}
