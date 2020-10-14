package com.example.myweichat;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends Activity implements View.OnClickListener {
    private LinearLayout TabMessage;
    private LinearLayout TabContact;
    private LinearLayout TabFriend;
    private LinearLayout TabSetting;

    private ImageButton ImgMessage;
    private ImageButton ImgContact;
    private ImageButton ImgFriend;
    private ImageButton ImgSetting;

    private Fragment Tab01=new messageFragment();
    private Fragment Tab02=new contactFragment();
    private Fragment Tab03=new friendFragment();
    private Fragment Tab04=new settingFragment();

    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initView();
        initFragment();
        initEvent();
        setSelect(0);
    }
    private void initFragment() {
        fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.id_content,Tab01);
        transaction.add(R.id.id_content, Tab02);
        transaction.add(R.id.id_content, Tab03);
        transaction.add(R.id.id_content, Tab04);
        transaction.commit();
    }
    private void initEvent()
    {
        TabMessage.setOnClickListener(this);
        TabContact.setOnClickListener(this);
        TabFriend.setOnClickListener(this);
        TabSetting.setOnClickListener(this);
    }
    private void initView()
    {
        TabMessage=(LinearLayout)findViewById(R.id.id_tab_message);
        TabContact=(LinearLayout)findViewById(R.id.id_tab_contact);
        TabFriend=(LinearLayout)findViewById(R.id.id_tab_friend);
        TabSetting=(LinearLayout)findViewById(R.id.id_tab_setting);

        ImgMessage=(ImageButton)findViewById(R.id.imageButton_message);
        ImgContact=(ImageButton)findViewById(R.id.imageButton_contact);
        ImgFriend=(ImageButton)findViewById(R.id.imageButton_friend);
        ImgSetting=(ImageButton)findViewById(R.id.imageButton_setting);
    }
    private void setSelect(int i){
        FragmentTransaction transaction=fm.beginTransaction();
        hideFragment(transaction);
        //把图片设置为亮的
        switch (i){
            case 0:
                Log.d("setSelect","1");
                transaction.show(Tab01);
                ImgMessage.setImageResource(R.drawable.message_tab);
                break;
            case 1:
                transaction.show(Tab02);
                ImgContact.setImageResource(R.drawable.contact_tab);
                break;
            case 2:
                transaction.show(Tab03);
                ImgFriend.setImageResource(R.drawable.friend_tab);
                break;
            case 3:
                transaction.show(Tab04);
                ImgSetting.setImageResource(R.drawable.setting_tab);
                break;
             default:
                 break;

        }
        transaction.commit();
    }
    private void hideFragment(FragmentTransaction transaction)
    {
      transaction.hide(Tab01) ;
        transaction.hide(Tab02) ;
        transaction.hide(Tab03) ;
        transaction.hide(Tab04) ;
    }
    @Override
    public void onClick(View v)
    {
        Log.d("onClick","1");
        resetImgs();
        switch(v.getId()){
            case R.id.id_tab_message:
                Log.d("onClick","2");
                setSelect(0);
                break;
            case R.id.id_tab_contact:
                setSelect(1);
                break;
            case R.id.id_tab_friend:
                setSelect(2);
                break;
            case R.id.id_tab_setting:
                setSelect(3);
                break;
            default:
                break;
        }
    }
    public void resetImgs()
    {
        ImgMessage.setImageResource(R.drawable.message);
        ImgContact.setImageResource(R.drawable.contact);
        ImgFriend.setImageResource(R.drawable.friend);
        ImgSetting.setImageResource(R.drawable.setting);
    }
}
