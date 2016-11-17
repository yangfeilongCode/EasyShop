package feicui.edu.easyshop.mail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import feicui.edu.easyshop.MainActivity;
import feicui.edu.easyshop.R;

/**
 * Created by Administrator on 2016/11/17.
 */

public class MailFragment extends Fragment {
    public MailFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mail,container,false);
    }
}
