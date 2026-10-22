package com.bytedanceos.numberassistant;

import android.accounts.Account;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.bytedanceos.numberassistant.xysdk.IXySdkCallBack;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface IPhoneNumberAssistant extends IInterface {

    public static class Default implements IPhoneNumberAssistant {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.bytedanceos.numberassistant.IPhoneNumberAssistant
        public int filterSMS(String message, String sourceNumber, String messageCenter) throws RemoteException {
            return 0;
        }

        @Override // com.bytedanceos.numberassistant.IPhoneNumberAssistant
        public Bitmap findLogoByLogoNameByXySdk(String logoName, int width, int height, int logoType, IXySdkCallBack xyCallBack) throws RemoteException {
            return null;
        }

        @Override // com.bytedanceos.numberassistant.IPhoneNumberAssistant
        public byte[] findScaleLogoByLogoNameByXySdk(String logoName, int scale, IXySdkCallBack xyCallBack, String backColor, String backColorEnd, int width, int height) throws RemoteException {
            return null;
        }

        @Override // com.bytedanceos.numberassistant.IPhoneNumberAssistant
        public List<Account> getAccountsOfDoppelganger() throws RemoteException {
            return null;
        }

        @Override // com.bytedanceos.numberassistant.IPhoneNumberAssistant
        public long getBuildNumber() throws RemoteException {
            return 0;
        }

        @Override // com.bytedanceos.numberassistant.IPhoneNumberAssistant
        public Intent getLaunchRechargeIntent(int from) throws RemoteException {
            return null;
        }

        @Override // com.bytedanceos.numberassistant.IPhoneNumberAssistant
        public String getPhoneAttriCity(String number) throws RemoteException {
            return null;
        }

        @Override // com.bytedanceos.numberassistant.IPhoneNumberAssistant
        public boolean isTdSmsByXySdk(String msgId, String address, String serviceCenter, String body, long date) throws RemoteException {
            return false;
        }

        @Override // com.bytedanceos.numberassistant.IPhoneNumberAssistant
        public void launchRecharge(String number) throws RemoteException {
        }

        @Override // com.bytedanceos.numberassistant.IPhoneNumberAssistant
        public void launchYellowPage() throws RemoteException {
        }

        @Override // com.bytedanceos.numberassistant.IPhoneNumberAssistant
        public void markCallerClassify(String number, String classify) throws RemoteException {
        }

        @Override // com.bytedanceos.numberassistant.IPhoneNumberAssistant
        public void markCallerName(String number, String name) throws RemoteException {
        }

        @Override // com.bytedanceos.numberassistant.IPhoneNumberAssistant
        public void onNewMsgByXySdk(String phoneNum, String smsCenterNum, int simIndex, String smsContent, long smsReceiveTime, String extend) throws RemoteException {
        }

        @Override // com.bytedanceos.numberassistant.IPhoneNumberAssistant
        public void parseMessageByXySdk(String msgId, String phoneNum, String smsCenterNum, String smsContent, long smsReceiveTime, IXySdkCallBack xyCallBack, boolean scrollFing) throws RemoteException {
        }

        @Override // com.bytedanceos.numberassistant.IPhoneNumberAssistant
        public void parseMsgForCardByXySdk(String msgId, String phoneNumber, String smsCenterNum, String smsContent) throws RemoteException {
        }

        @Override // com.bytedanceos.numberassistant.IPhoneNumberAssistant
        public String parseSalaryIndexByXySdk(String body) throws RemoteException {
            return null;
        }

        @Override // com.bytedanceos.numberassistant.IPhoneNumberAssistant
        public String parseTdSmsInstructByXySdk(String body) throws RemoteException {
            return null;
        }

        @Override // com.bytedanceos.numberassistant.IPhoneNumberAssistant
        public CallerIdDetail queryCallerIdDetail(String number, int strategy) throws RemoteException {
            return null;
        }

        @Override // com.bytedanceos.numberassistant.IPhoneNumberAssistant
        public void queryCallerIdDetailAsync(String number, int strategy, IQueryCallerIdCallback callback) throws RemoteException {
        }

        @Override // com.bytedanceos.numberassistant.IPhoneNumberAssistant
        public String queryPublicInfoByXySdk(String phoneNum, int numType, String simIccid, IXySdkCallBack xyCallBack) throws RemoteException {
            return null;
        }

        @Override // com.bytedanceos.numberassistant.IPhoneNumberAssistant
        public SMSCallerIdDetail querySMSCallerId(String number) throws RemoteException {
            return null;
        }

        @Override // com.bytedanceos.numberassistant.IPhoneNumberAssistant
        public List<YellowPageResult> queryYellowPage(String query, int type) throws RemoteException {
            return null;
        }

        @Override // com.bytedanceos.numberassistant.IPhoneNumberAssistant
        public void unMarkCaller(String number) throws RemoteException {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IPhoneNumberAssistant {
        private static final String DESCRIPTOR = "com.bytedanceos.numberassistant.IPhoneNumberAssistant";
        static final int TRANSACTION_filterSMS = 9;
        static final int TRANSACTION_findLogoByLogoNameByXySdk = 17;
        static final int TRANSACTION_findScaleLogoByLogoNameByXySdk = 18;
        static final int TRANSACTION_getAccountsOfDoppelganger = 23;
        static final int TRANSACTION_getBuildNumber = 13;
        static final int TRANSACTION_getLaunchRechargeIntent = 11;
        static final int TRANSACTION_getPhoneAttriCity = 12;
        static final int TRANSACTION_isTdSmsByXySdk = 19;
        static final int TRANSACTION_launchRecharge = 7;
        static final int TRANSACTION_launchYellowPage = 6;
        static final int TRANSACTION_markCallerClassify = 3;
        static final int TRANSACTION_markCallerName = 4;
        static final int TRANSACTION_onNewMsgByXySdk = 15;
        static final int TRANSACTION_parseMessageByXySdk = 14;
        static final int TRANSACTION_parseMsgForCardByXySdk = 22;
        static final int TRANSACTION_parseSalaryIndexByXySdk = 21;
        static final int TRANSACTION_parseTdSmsInstructByXySdk = 20;
        static final int TRANSACTION_queryCallerIdDetail = 1;
        static final int TRANSACTION_queryCallerIdDetailAsync = 2;
        static final int TRANSACTION_queryPublicInfoByXySdk = 16;
        static final int TRANSACTION_querySMSCallerId = 8;
        static final int TRANSACTION_queryYellowPage = 10;
        static final int TRANSACTION_unMarkCaller = 5;

        private static class Proxy implements IPhoneNumberAssistant {
            public static IPhoneNumberAssistant sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.bytedanceos.numberassistant.IPhoneNumberAssistant
            public CallerIdDetail queryCallerIdDetail(String number, int strategy) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(number);     // Catch: Throwable -> L17
                r0.writeInt(strategy);     // Catch: Throwable -> L17
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                CallerIdDetail r4 = CallerIdDetail.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                CallerIdDetail r5 = Stub.getDefaultImpl().queryCallerIdDetail(number, strategy);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r5;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.numberassistant.IPhoneNumberAssistant
            public void queryCallerIdDetailAsync(String number, int strategy, IQueryCallerIdCallback callback) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(number);     // Catch: Throwable -> L17
                r0.writeInt(strategy);     // Catch: Throwable -> L17
                if (callback == null) goto L6;
                IBinder r2 = callback.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().queryCallerIdDetailAsync(number, strategy, callback);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.numberassistant.IPhoneNumberAssistant
            public void markCallerClassify(String number, String classify) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(number);     // Catch: Throwable -> L13
                r0.writeString(classify);     // Catch: Throwable -> L13
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().markCallerClassify(number, classify);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.numberassistant.IPhoneNumberAssistant
            public void markCallerName(String number, String name) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(number);     // Catch: Throwable -> L13
                r0.writeString(name);     // Catch: Throwable -> L13
                if (this.mRemote.transact(4, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().markCallerName(number, name);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.numberassistant.IPhoneNumberAssistant
            public void unMarkCaller(String number) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(number);     // Catch: Throwable -> L13
                if (this.mRemote.transact(5, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().unMarkCaller(number);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.numberassistant.IPhoneNumberAssistant
            public void launchYellowPage() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(6, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().launchYellowPage();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.numberassistant.IPhoneNumberAssistant
            public void launchRecharge(String number) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(number);     // Catch: Throwable -> L13
                if (this.mRemote.transact(7, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().launchRecharge(number);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.numberassistant.IPhoneNumberAssistant
            public SMSCallerIdDetail querySMSCallerId(String number) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(number);     // Catch: Throwable -> L17
                if (this.mRemote.transact(8, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                SMSCallerIdDetail r4 = SMSCallerIdDetail.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                SMSCallerIdDetail r5 = Stub.getDefaultImpl().querySMSCallerId(number);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r5;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.numberassistant.IPhoneNumberAssistant
            public int filterSMS(String message, String sourceNumber, String messageCenter) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(message);     // Catch: Throwable -> L13
                r0.writeString(sourceNumber);     // Catch: Throwable -> L13
                r0.writeString(messageCenter);     // Catch: Throwable -> L13
                if (this.mRemote.transact(9, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r5 = Stub.getDefaultImpl().filterSMS(message, sourceNumber, messageCenter);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.numberassistant.IPhoneNumberAssistant
            public List<YellowPageResult> queryYellowPage(String query, int type) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(query);     // Catch: Throwable -> L13
                r0.writeInt(type);     // Catch: Throwable -> L13
                if (this.mRemote.transact(10, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                ArrayList r4 = r1.createTypedArrayList(YellowPageResult.CREATOR);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<YellowPageResult> r5 = Stub.getDefaultImpl().queryYellowPage(query, type);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.numberassistant.IPhoneNumberAssistant
            public Intent getLaunchRechargeIntent(int from) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeInt(from);     // Catch: Throwable -> L17
                if (this.mRemote.transact(11, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                Intent r4 = (Intent) Intent.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Intent r5 = Stub.getDefaultImpl().getLaunchRechargeIntent(from);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r5;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.numberassistant.IPhoneNumberAssistant
            public String getPhoneAttriCity(String number) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(number);     // Catch: Throwable -> L13
                if (this.mRemote.transact(12, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r4 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r5 = Stub.getDefaultImpl().getPhoneAttriCity(number);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.numberassistant.IPhoneNumberAssistant
            public long getBuildNumber() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(13, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                long r2 = r1.readLong();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                long r3 = Stub.getDefaultImpl().getBuildNumber();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r3;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.numberassistant.IPhoneNumberAssistant
            public void parseMessageByXySdk(String msgId, String phoneNum, String smsCenterNum, String smsContent, long smsReceiveTime, IXySdkCallBack xyCallBack, boolean scrollFing) throws RemoteException {
                Parcel r1 = Parcel.obtain();
                Parcel r2 = Parcel.obtain();
                r1.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                r1.writeString(msgId);     // Catch: Throwable -> L21
                r1.writeString(phoneNum);     // Catch: Throwable -> L21
                r1.writeString(smsCenterNum);     // Catch: Throwable -> L21
                r1.writeString(smsContent);     // Catch: Throwable -> L21
                r1.writeLong(smsReceiveTime);     // Catch: Throwable -> L21
                if (xyCallBack == null) goto L6;
                IBinder r3 = xyCallBack.asBinder();     // Catch: Throwable -> L21
            L7:
                r1.writeStrongBinder(r3);     // Catch: Throwable -> L21
                if (scrollFing == false) goto L10;
                int r4 = 1;
            L11:
                r1.writeInt(r4);     // Catch: Throwable -> L21
                if (this.mRemote.transact(14, r1, r2, 0) == false) goto L14;
            L18:
                r2.readException();     // Catch: Throwable -> L21
                r2.recycle();
                r1.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().parseMessageByXySdk(msgId, phoneNum, smsCenterNum, smsContent, smsReceiveTime, xyCallBack, scrollFing);     // Catch: Throwable -> L21
                r2.recycle();
                r1.recycle();
                return;
            L10:
                r4 = 0;
                goto L11
            L6:
                r3 = null;
            L21:
                th = move-exception;
                r2.recycle();
                r1.recycle();
                throw th;
            }

            @Override // com.bytedanceos.numberassistant.IPhoneNumberAssistant
            public void onNewMsgByXySdk(String phoneNum, String smsCenterNum, int simIndex, String smsContent, long smsReceiveTime, String extend) throws RemoteException {
                Parcel r1 = Parcel.obtain();
                Parcel r2 = Parcel.obtain();
                r1.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r1.writeString(phoneNum);     // Catch: Throwable -> L13
                r1.writeString(smsCenterNum);     // Catch: Throwable -> L13
                r1.writeInt(simIndex);     // Catch: Throwable -> L13
                r1.writeString(smsContent);     // Catch: Throwable -> L13
                r1.writeLong(smsReceiveTime);     // Catch: Throwable -> L13
                r1.writeString(extend);     // Catch: Throwable -> L13
                if (this.mRemote.transact(15, r1, r2, 0) == false) goto L6;
            L10:
                r2.readException();     // Catch: Throwable -> L13
                r2.recycle();
                r1.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onNewMsgByXySdk(phoneNum, smsCenterNum, simIndex, smsContent, smsReceiveTime, extend);     // Catch: Throwable -> L13
                r2.recycle();
                r1.recycle();
                return;
            L13:
                th = move-exception;
                r2.recycle();
                r1.recycle();
                throw th;
            }

            @Override // com.bytedanceos.numberassistant.IPhoneNumberAssistant
            public String queryPublicInfoByXySdk(String phoneNum, int numType, String simIccid, IXySdkCallBack xyCallBack) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(phoneNum);     // Catch: Throwable -> L17
                r0.writeInt(numType);     // Catch: Throwable -> L17
                r0.writeString(simIccid);     // Catch: Throwable -> L17
                if (xyCallBack == null) goto L6;
                IBinder r2 = xyCallBack.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(16, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                String r4 = r1.readString();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r4;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                String r5 = Stub.getDefaultImpl().queryPublicInfoByXySdk(phoneNum, numType, simIccid, xyCallBack);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r5;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.numberassistant.IPhoneNumberAssistant
            public Bitmap findLogoByLogoNameByXySdk(String logoName, int width, int height, int logoType, IXySdkCallBack xyCallBack) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                r0.writeString(logoName);     // Catch: Throwable -> L19
                r0.writeInt(width);     // Catch: Throwable -> L19
                r0.writeInt(height);     // Catch: Throwable -> L19
                r0.writeInt(logoType);     // Catch: Throwable -> L19
                Bitmap r2 = null;
                if (xyCallBack == null) goto L6;
                IBinder r3 = xyCallBack.asBinder();     // Catch: Throwable -> L19
            L7:
                r0.writeStrongBinder(r3);     // Catch: Throwable -> L19
                if (this.mRemote.transact(17, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L19
                if (r1.readInt() == 0) goto L17;
                r2 = (Bitmap) Bitmap.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L19
            L17:
                r1.recycle();
                r0.recycle();
                return r2;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Bitmap r9 = Stub.getDefaultImpl().findLogoByLogoNameByXySdk(logoName, width, height, logoType, xyCallBack);     // Catch: Throwable -> L19
                r1.recycle();
                r0.recycle();
                return r9;
            L6:
                r3 = null;
            L19:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.numberassistant.IPhoneNumberAssistant
            public byte[] findScaleLogoByLogoNameByXySdk(String logoName, int scale, IXySdkCallBack xyCallBack, String backColor, String backColorEnd, int width, int height) throws RemoteException {
                Parcel r1 = Parcel.obtain();
                Parcel r2 = Parcel.obtain();
                r1.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r1.writeString(logoName);     // Catch: Throwable -> L17
                r1.writeInt(scale);     // Catch: Throwable -> L17
                if (xyCallBack == null) goto L6;
                IBinder r3 = xyCallBack.asBinder();     // Catch: Throwable -> L17
            L7:
                r1.writeStrongBinder(r3);     // Catch: Throwable -> L17
                r1.writeString(backColor);     // Catch: Throwable -> L17
                r1.writeString(backColorEnd);     // Catch: Throwable -> L17
                r1.writeInt(width);     // Catch: Throwable -> L17
                r1.writeInt(height);     // Catch: Throwable -> L17
                if (this.mRemote.transact(18, r1, r2, 0) == false) goto L10;
            L14:
                r2.readException();     // Catch: Throwable -> L17
                byte[] r0 = r2.createByteArray();     // Catch: Throwable -> L17
                r2.recycle();
                r1.recycle();
                return r0;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                byte[] r4 = Stub.getDefaultImpl().findScaleLogoByLogoNameByXySdk(logoName, scale, xyCallBack, backColor, backColorEnd, width, height);     // Catch: Throwable -> L17
                r2.recycle();
                r1.recycle();
                return r4;
            L6:
                r3 = null;
            L17:
                th = move-exception;
                r2.recycle();
                r1.recycle();
                throw th;
            }

            @Override // com.bytedanceos.numberassistant.IPhoneNumberAssistant
            public boolean isTdSmsByXySdk(String msgId, String address, String serviceCenter, String body, long date) throws RemoteException {
                Parcel r1 = Parcel.obtain();
                Parcel r2 = Parcel.obtain();
                r1.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r1.writeString(msgId);     // Catch: Throwable -> L15
                r1.writeString(address);     // Catch: Throwable -> L15
                r1.writeString(serviceCenter);     // Catch: Throwable -> L15
                r1.writeString(body);     // Catch: Throwable -> L15
                r1.writeLong(date);     // Catch: Throwable -> L15
                boolean r10 = false;
                if (this.mRemote.transact(19, r1, r2, 0) == false) goto L6;
            L10:
                r2.readException();     // Catch: Throwable -> L15
                if (r2.readInt() == 0) goto L13;
                r10 = true;
            L13:
                r2.recycle();
                r1.recycle();
                return r10;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r0 = Stub.getDefaultImpl().isTdSmsByXySdk(msgId, address, serviceCenter, body, date);     // Catch: Throwable -> L15
                r2.recycle();
                r1.recycle();
                return r0;
            L15:
                th = move-exception;
                r2.recycle();
                r1.recycle();
                throw th;
            }

            @Override // com.bytedanceos.numberassistant.IPhoneNumberAssistant
            public String parseTdSmsInstructByXySdk(String body) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(body);     // Catch: Throwable -> L13
                if (this.mRemote.transact(20, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r4 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r5 = Stub.getDefaultImpl().parseTdSmsInstructByXySdk(body);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.numberassistant.IPhoneNumberAssistant
            public String parseSalaryIndexByXySdk(String body) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(body);     // Catch: Throwable -> L13
                if (this.mRemote.transact(21, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r4 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r5 = Stub.getDefaultImpl().parseSalaryIndexByXySdk(body);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.numberassistant.IPhoneNumberAssistant
            public void parseMsgForCardByXySdk(String msgId, String phoneNumber, String smsCenterNum, String smsContent) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(msgId);     // Catch: Throwable -> L13
                r0.writeString(phoneNumber);     // Catch: Throwable -> L13
                r0.writeString(smsCenterNum);     // Catch: Throwable -> L13
                r0.writeString(smsContent);     // Catch: Throwable -> L13
                if (this.mRemote.transact(22, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().parseMsgForCardByXySdk(msgId, phoneNumber, smsCenterNum, smsContent);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.numberassistant.IPhoneNumberAssistant
            public List<Account> getAccountsOfDoppelganger() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(23, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                ArrayList r4 = r1.createTypedArrayList(Account.CREATOR);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<Account> r5 = Stub.getDefaultImpl().getAccountsOfDoppelganger();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IPhoneNumberAssistant asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface r0 = obj.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IPhoneNumberAssistant) == false) goto L12;
            return (IPhoneNumberAssistant) r0;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r14, Parcel r15, Parcel r16, int r17) throws RemoteException {
            if (r14 != 1598968902) goto L5;
            r16.writeString(DESCRIPTOR);
            return true;
        L5:
            switch(r14) {
                case 1: goto L65;
                case 2: goto L63;
                case 3: goto L61;
                case 4: goto L59;
                case 5: goto L57;
                case 6: goto L55;
                case 7: goto L53;
                case 8: goto L48;
                case 9: goto L46;
                case 10: goto L44;
                case 11: goto L39;
                case 12: goto L37;
                case 13: goto L35;
                case 14: goto L29;
                case 15: goto L27;
                case 16: goto L25;
                case 17: goto L20;
                case 18: goto L18;
                case 19: goto L16;
                case 20: goto L14;
                case 21: goto L12;
                case 22: goto L10;
                case 23: goto L8;
                default: goto L7;
            };
        L8:
            r15.enforceInterface(DESCRIPTOR);
            List<Account> r0 = getAccountsOfDoppelganger();
            r16.writeNoException();
            r16.writeTypedList(r0);
            return true;
        L10:
            r15.enforceInterface(DESCRIPTOR);
            parseMsgForCardByXySdk(r15.readString(), r15.readString(), r15.readString(), r15.readString());
            r16.writeNoException();
            return true;
        L12:
            r15.enforceInterface(DESCRIPTOR);
            String r1 = parseSalaryIndexByXySdk(r15.readString());
            r16.writeNoException();
            r16.writeString(r1);
            return true;
        L14:
            r15.enforceInterface(DESCRIPTOR);
            String r2 = parseTdSmsInstructByXySdk(r15.readString());
            r16.writeNoException();
            r16.writeString(r2);
            return true;
        L16:
            r15.enforceInterface(DESCRIPTOR);
            boolean r3 = isTdSmsByXySdk(r15.readString(), r15.readString(), r15.readString(), r15.readString(), r15.readLong());
            r16.writeNoException();
            r16.writeInt(r3 ? 1 : 0);
            return true;
        L18:
            r15.enforceInterface(DESCRIPTOR);
            byte[] r4 = findScaleLogoByLogoNameByXySdk(r15.readString(), r15.readInt(), IXySdkCallBack.Stub.asInterface(r15.readStrongBinder()), r15.readString(), r15.readString(), r15.readInt(), r15.readInt());
            r16.writeNoException();
            r16.writeByteArray(r4);
            return true;
        L20:
            r15.enforceInterface(DESCRIPTOR);
            Bitmap r5 = findLogoByLogoNameByXySdk(r15.readString(), r15.readInt(), r15.readInt(), r15.readInt(), IXySdkCallBack.Stub.asInterface(r15.readStrongBinder()));
            r16.writeNoException();
            if (r5 == null) goto L23;
            r16.writeInt(1);
            r5.writeToParcel(r16, 1);
        L24:
            return true;
        L23:
            r16.writeInt(0);
            goto L24
        L25:
            r15.enforceInterface(DESCRIPTOR);
            String r6 = queryPublicInfoByXySdk(r15.readString(), r15.readInt(), r15.readString(), IXySdkCallBack.Stub.asInterface(r15.readStrongBinder()));
            r16.writeNoException();
            r16.writeString(r6);
            return true;
        L27:
            r15.enforceInterface(DESCRIPTOR);
            onNewMsgByXySdk(r15.readString(), r15.readString(), r15.readInt(), r15.readString(), r15.readLong(), r15.readString());
            r16.writeNoException();
            return true;
        L29:
            r15.enforceInterface(DESCRIPTOR);
            String r7 = r15.readString();
            String r8 = r15.readString();
            String r9 = r15.readString();
            String r10 = r15.readString();
            long r11 = r15.readLong();
            IXySdkCallBack r12 = IXySdkCallBack.Stub.asInterface(r15.readStrongBinder());
            if (r15.readInt() == 0) goto L32;
            boolean r13 = true;
        L33:
            parseMessageByXySdk(r7, r8, r9, r10, r11, r12, r13);
            r16.writeNoException();
            return true;
        L32:
            r13 = false;
            goto L33
        L35:
            r15.enforceInterface(DESCRIPTOR);
            long r18 = getBuildNumber();
            r16.writeNoException();
            r16.writeLong(r18);
            return true;
        L37:
            r15.enforceInterface(DESCRIPTOR);
            String r19 = getPhoneAttriCity(r15.readString());
            r16.writeNoException();
            r16.writeString(r19);
            return true;
        L39:
            r15.enforceInterface(DESCRIPTOR);
            Intent r20 = getLaunchRechargeIntent(r15.readInt());
            r16.writeNoException();
            if (r20 == null) goto L42;
            r16.writeInt(1);
            r20.writeToParcel(r16, 1);
        L43:
            return true;
        L42:
            r16.writeInt(0);
            goto L43
        L44:
            r15.enforceInterface(DESCRIPTOR);
            List<YellowPageResult> r21 = queryYellowPage(r15.readString(), r15.readInt());
            r16.writeNoException();
            r16.writeTypedList(r21);
            return true;
        L46:
            r15.enforceInterface(DESCRIPTOR);
            int r22 = filterSMS(r15.readString(), r15.readString(), r15.readString());
            r16.writeNoException();
            r16.writeInt(r22);
            return true;
        L48:
            r15.enforceInterface(DESCRIPTOR);
            SMSCallerIdDetail r23 = querySMSCallerId(r15.readString());
            r16.writeNoException();
            if (r23 == null) goto L51;
            r16.writeInt(1);
            r23.writeToParcel(r16, 1);
        L52:
            return true;
        L51:
            r16.writeInt(0);
            goto L52
        L53:
            r15.enforceInterface(DESCRIPTOR);
            launchRecharge(r15.readString());
            r16.writeNoException();
            return true;
        L55:
            r15.enforceInterface(DESCRIPTOR);
            launchYellowPage();
            r16.writeNoException();
            return true;
        L57:
            r15.enforceInterface(DESCRIPTOR);
            unMarkCaller(r15.readString());
            r16.writeNoException();
            return true;
        L59:
            r15.enforceInterface(DESCRIPTOR);
            markCallerName(r15.readString(), r15.readString());
            r16.writeNoException();
            return true;
        L61:
            r15.enforceInterface(DESCRIPTOR);
            markCallerClassify(r15.readString(), r15.readString());
            r16.writeNoException();
            return true;
        L63:
            r15.enforceInterface(DESCRIPTOR);
            queryCallerIdDetailAsync(r15.readString(), r15.readInt(), IQueryCallerIdCallback.Stub.asInterface(r15.readStrongBinder()));
            r16.writeNoException();
            return true;
        L65:
            r15.enforceInterface(DESCRIPTOR);
            CallerIdDetail r24 = queryCallerIdDetail(r15.readString(), r15.readInt());
            r16.writeNoException();
            if (r24 == null) goto L68;
            r16.writeInt(1);
            r24.writeToParcel(r16, 1);
        L69:
            return true;
        L68:
            r16.writeInt(0);
            goto L69
        L7:
            return super.onTransact(r14, r15, r16, r17);
        }

        public static boolean setDefaultImpl(IPhoneNumberAssistant impl) {
            if (Proxy.sDefaultImpl != null) goto L10;
            if (impl == null) goto L7;
            Proxy.sDefaultImpl = impl;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        public static IPhoneNumberAssistant getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    int filterSMS(String message, String sourceNumber, String messageCenter) throws RemoteException;

    Bitmap findLogoByLogoNameByXySdk(String logoName, int width, int height, int logoType, IXySdkCallBack xyCallBack) throws RemoteException;

    byte[] findScaleLogoByLogoNameByXySdk(String logoName, int scale, IXySdkCallBack xyCallBack, String backColor, String backColorEnd, int width, int height) throws RemoteException;

    List<Account> getAccountsOfDoppelganger() throws RemoteException;

    long getBuildNumber() throws RemoteException;

    Intent getLaunchRechargeIntent(int from) throws RemoteException;

    String getPhoneAttriCity(String number) throws RemoteException;

    boolean isTdSmsByXySdk(String msgId, String address, String serviceCenter, String body, long date) throws RemoteException;

    void launchRecharge(String number) throws RemoteException;

    void launchYellowPage() throws RemoteException;

    void markCallerClassify(String number, String classify) throws RemoteException;

    void markCallerName(String number, String name) throws RemoteException;

    void onNewMsgByXySdk(String phoneNum, String smsCenterNum, int simIndex, String smsContent, long smsReceiveTime, String extend) throws RemoteException;

    void parseMessageByXySdk(String msgId, String phoneNum, String smsCenterNum, String smsContent, long smsReceiveTime, IXySdkCallBack xyCallBack, boolean scrollFing) throws RemoteException;

    void parseMsgForCardByXySdk(String msgId, String phoneNumber, String smsCenterNum, String smsContent) throws RemoteException;

    String parseSalaryIndexByXySdk(String body) throws RemoteException;

    String parseTdSmsInstructByXySdk(String body) throws RemoteException;

    CallerIdDetail queryCallerIdDetail(String number, int strategy) throws RemoteException;

    void queryCallerIdDetailAsync(String number, int strategy, IQueryCallerIdCallback callback) throws RemoteException;

    String queryPublicInfoByXySdk(String phoneNum, int numType, String simIccid, IXySdkCallBack xyCallBack) throws RemoteException;

    SMSCallerIdDetail querySMSCallerId(String number) throws RemoteException;

    List<YellowPageResult> queryYellowPage(String query, int type) throws RemoteException;

    void unMarkCaller(String number) throws RemoteException;
}
