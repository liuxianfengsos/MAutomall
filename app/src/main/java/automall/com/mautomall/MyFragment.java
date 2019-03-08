package automall.com.mautomall;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class MyFragment extends Fragment{
    private static final String ARG_SHOW_TEXT = "text";
    private String mContentText;
    //返回通过工厂方法获取BlankFragment
    public static MyFragment newInstance(){
        MyFragment fragment = new MyFragment();
        Bundle args = new Bundle();
       // args.putString(ARG_SHOW_TEXT,param1);
        //fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /* if (getArguments()!=null){
            mContentText = getArguments().getString(ARG_SHOW_TEXT);
        }*/
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //FOR fragment
        View rootView = inflater.inflate(R.layout.fragment_mine,container,false);
        //TextView contentTv = rootView.findViewById(R.id.content_tv);
        //contentTv.setText(mContentText);
        initMine_login(rootView);
        return rootView;
    }
    //点击登录按钮mine_login

    public void initMine_login(View rootView){
        Button mine_login1 = rootView.findViewById(R.id.mine_login1);
        mine_login1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Toast.makeText(homeView.getContext(), "您点击的是" , Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getActivity(),LoginActivity.class);
                startActivity(intent);
            }
        });
    }

}
