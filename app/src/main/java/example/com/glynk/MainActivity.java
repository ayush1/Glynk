package example.com.glynk;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import example.com.glynk.adapter.SectionPagerAdapter;

public class MainActivity extends AppCompatActivity{

    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @BindView(R.id.tabs)
    TabLayout tabLayout;

    SectionPagerAdapter sectionPagerAdapter;

    TabLayout.Tab tab0, tab1, tab2, tab3, tab4;
    private int alpha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        sectionPagerAdapter = new SectionPagerAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(sectionPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);

        tab0 = tabLayout.getTabAt(0);
        tab1 = tabLayout.getTabAt(1);
        tab2 = tabLayout.getTabAt(2);
        tab3 = tabLayout.getTabAt(3);
        tab4 = tabLayout.getTabAt(4);

        tab0.setCustomView(R.layout.fragment_sports);
        tab1.setCustomView(R.layout.fragment_technologies);
        tab2.setCustomView(R.layout.fragment_politics);
        tab3.setCustomView(R.layout.fragment_movies);
        tab4.setCustomView(R.layout.fragment_design);

        viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                int alphaCurrent = (int) (255 - (128*Math.abs(positionOffset)));
                int alphaNext = (int) (128 + (128*Math.abs(positionOffset)));

                if (positionOffset != 0) {
                    switch(position) {
                        case 0:
                            setTheAlpha(tab0, alphaCurrent);
                            setTheAlpha(tab1, alphaNext);
                            break;
                        case 1:
                            setTheAlpha(tab1, alphaCurrent);
                            setTheAlpha(tab2, alphaNext);
                            break;
                        case 2:
                            setTheAlpha(tab2, alphaCurrent);
                            setTheAlpha(tab3, alphaNext);
                            break;
                        case 3:
                            setTheAlpha(tab3, alphaCurrent);
                            setTheAlpha(tab4, alphaNext);
                            break;
                    }
                }

            }
        });
    }

    public void setTheAlpha(TabLayout.Tab tab, int alpha) {
        this.alpha = alpha;
        if (alpha < 128) alpha = 128;
        if (alpha > 255) alpha = 255;
        TextView textView = tab.getCustomView().findViewById(R.id.tv);
        onSetAlpha(textView, alpha);
    }

    public boolean onSetAlpha(TextView textView, int alpha) {
        textView.setTextColor(Color.argb(alpha, 0, 0, 0));
        textView.setHintTextColor(textView.getHintTextColors().withAlpha(alpha));
        return true;
    }

}
