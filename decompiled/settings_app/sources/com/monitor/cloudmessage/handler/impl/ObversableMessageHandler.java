package com.monitor.cloudmessage.handler.impl;

import com.monitor.cloudmessage.CloudMessageManager;
import com.monitor.cloudmessage.entity.CloudMessage;
import com.monitor.cloudmessage.handler.IMessageHandler;
import com.monitor.cloudmessage.obversable.CloudMessageObservable;
import com.monitor.cloudmessage.obversable.CloudMessageObserver;
import com.monitor.cloudmessage.upload.CloudMessageUploadManager;
import com.monitor.cloudmessage.upload.entity.UploadInfo;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes4.dex */
public class ObversableMessageHandler implements CloudMessageObservable, IMessageHandler {
    public ObversableMessageHandler() {
    }

    @Override // com.monitor.cloudmessage.handler.IMessageHandler
    public boolean handleCloudMessage(CloudMessage r1) {
        return dispatchCloudMessage(r1);
    }

    @Override // com.monitor.cloudmessage.obversable.CloudMessageObservable
    public boolean dispatchCloudMessage(CloudMessage r8) {
        Enumeration r7 = CloudMessageManager.getInstance().getObverserList();
        if (r7 != null) goto L5;
        return false;
    L5:
        if (r7.hasMoreElements() == false) goto L20;
        CloudMessageObserver r0 = (CloudMessageObserver) r7.nextElement();
        if (r0 == null) goto L5;
        if (r0.obverseCloudMessage(r8) == false) goto L5;
        CloudMessageUploadManager.upload(new UploadInfo(0, false, r8.getCommandId(), null));
        return true;
    L20:
        return false;
    }
}
