/*..._......_......................._....._._......
....|.|....(_).....................|.|...(_).|.....
..__|.|.___._..__._._.__.___...___.|.|__.._|.|.___.
./._`.|/._.\.|/._`.|.'_.`._.\./._.\|.'_.\|.|.|/._.\
|.(_|.|..__/.|.(_|.|.|.|.|.|.|.(_).|.|_).|.|.|..__/
.\__,_|\___|.|\__,_|_|.|_|.|_|\___/|_.__/|_|_|\___|
.........._/.|.....................................
.........|__/
Copyright (C) 2015 dejamobile.
*/
package com.dejamobile.ardeco.lib;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.dejamobile.ardeco.card.MasterFile;
import com.dejamobile.ardeco.util.DBManager;
import com.snappydb.SnappydbException;

/**
 * Created by Sylvain on 21/04/2015.
 */
public class ServiceEntryPoint extends Service {

    private static final String TAG = ServiceEntryPoint.class.getName();

    protected final DelegateEntryPoint mBinder = new DelegateEntryPoint();

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "Binding Service");

        return mBinder.asBinder();
    }


    protected class DelegateEntryPoint extends IServiceEntryPoint.Stub {

        @Override
        public String getVersion() throws RemoteException {
            return BuildConfig.VERSION_NAME;
        }

        public void init(ArdecoCallBack callback){
            if (callback == null){
                return;
            }

        }

        public void createCommunity(String id, String signature, ArdecoCallBack callback){
            if (callback == null){
                return;
            }
        }

        public void createService(String communityId, String serviceId, String signature, ArdecoCallBack callback){
            if (callback == null){
                return;
            }
        }

        public void readServiceContents(String communityId, String serviceId, ArdecoCallBack callback){
            if (callback == null){
                return;
            }
        }

        public void readServiceTransactions(String communityId, String serviceId, ArdecoCallBack callback){
            if (callback == null){
                return;
            }
        }

        public void updateUserInfo(UserInfo userInfo, ArdecoCallBack callback){
            if (callback == null){
                return;
            }
            Log.d(TAG, "UserInfo name : " + userInfo.getFirstName() + " " + userInfo.getLastName());
            try {
                callback.onSuccess();
            } catch (RemoteException e) {
                Log.w(TAG, "Something went wrong will invoking callBack " + e.getMessage());
            }
        }

        public void readUserInfo(UserInfo userInfo, ArdecoCallBack callback){
            if (callback == null){
                return;
            }
        }






    }
}