package com.yelj.hello;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.yelj.hello.bean.Person;

import java.util.List;

/**
 * Author: Alex.ylj
 * 2019-05-07 17:14 Tuesday
 * Description: AIDL练习
 */
public class AIDLTest {

    /**
     * 实现接口
     */
    private MRemotePersonService.Stub mBinder = new MRemotePersonService.Stub(){

        @Override
        public void addPerson(Person p) throws RemoteException {
            //处理数据
        }

        @Override
        public List<Person> getPersonList() throws RemoteException {
            return null;
        }

        @Override
        public void setValue(int value) throws RemoteException {

        }
    };

    /**
     * 绑定服务
     */
    public class MyPersonService extends Service {

        @Override
        public IBinder onBind(Intent intent) {
            return mBinder;
        }
    }

    /**
     * 连接服务并开始使用
     */
    public class ActivityA extends AppCompatActivity {

        MRemotePersonService mRemotePersonService;

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            Intent intent = new Intent(this, MyPersonService.class);
            bindService(intent, new ServiceConnection() {
                @Override
                public void onServiceConnected(ComponentName name, IBinder service) {
                    mRemotePersonService = MRemotePersonService.Stub.asInterface(service);
                }

                @Override
                public void onServiceDisconnected(ComponentName name) {
                    mRemotePersonService = null;
                }
            }, BIND_AUTO_CREATE);

            try {
                //调用定义的接口方法
                mRemotePersonService.addPerson(new Person());
                mRemotePersonService.getPersonList();
                mRemotePersonService.setValue(1);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
