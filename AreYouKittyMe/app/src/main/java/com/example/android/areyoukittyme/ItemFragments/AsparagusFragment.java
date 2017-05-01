package com.example.android.areyoukittyme.ItemFragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.android.areyoukittyme.Item.Asparagus;
import com.example.android.areyoukittyme.Item.Avocado;
import com.example.android.areyoukittyme.Item.Bacon;
import com.example.android.areyoukittyme.Item.Corndog;
import com.example.android.areyoukittyme.Item.Fish;
import com.example.android.areyoukittyme.Item.Hamburger;
import com.example.android.areyoukittyme.MainActivity;
import com.example.android.areyoukittyme.R;
import com.example.android.areyoukittyme.StoreActivity;
import com.example.android.areyoukittyme.User.User;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;

/**
 * Created by PrGxw on 4/18/2017.
 */

public class AsparagusFragment extends Fragment {
    private static ViewGroup rootView;
    private User mUser;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mUser = ((MainActivity) getActivity()).getmUser();
        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_item_asparagus, container, false);
        TextView text = (TextView)rootView.findViewById(R.id.asparagusAmount);
        rootView.findViewById(R.id.asparagusImage).setOnClickListener(new MyClickListener());



        if (mUser.getInventoryList().containsKey(Asparagus.getIndex())) {
            text.setText(String.format("x%d", mUser.getInventoryAmount(Asparagus.getIndex())));
        }
        else {
            text.setText("nokey");
        }

        return rootView;
    }

    private final class MyClickListener implements View.OnClickListener {
        public void onClick(View v) {
            if (mUser.getInventoryAmount(Asparagus.getIndex()) > 0) {
                RelativeLayout p = (RelativeLayout) rootView.getParent().getParent();
                ViewPager vp = (ViewPager) rootView.getParent();

                TextView text = (TextView) rootView.findViewById(R.id.asparagusAmount);
                text.setText(String.format("x%d", mUser.getInventoryAmount(Asparagus.getIndex()) - 1));

                CircularProgressBar healthProgress = ((MainActivity) getActivity()).getHealthProgress();
                CircularProgressBar moodProgress = ((MainActivity) getActivity()).getMoodProgress();

                int prevAmount = mUser.getInventoryAmount(Asparagus.getIndex());
                mUser.getInventoryList().put(Asparagus.getIndex(), prevAmount - 1);

                mUser.incrementMood(mUser.foodToMoodConversion(vp.getCurrentItem()));
                System.out.println("now is: " + mUser.getHealth());
                mUser.incrementHealth(mUser.foodToHealthConversion(vp.getCurrentItem()));
                healthProgress.setProgressWithAnimation(mUser.getHealth());
                moodProgress.setProgressWithAnimation(mUser.getMood());
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        TextView text = (TextView)rootView.findViewById(R.id.asparagusAmount);
        text.setText(String.format("x%d", mUser.getInventoryAmount(Asparagus.getIndex())));
    }
}
