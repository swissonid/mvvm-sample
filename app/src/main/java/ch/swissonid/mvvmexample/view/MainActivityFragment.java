package ch.swissonid.mvvmexample.view;

import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ch.swissonid.mvvmexample.R;
import ch.swissonid.mvvmexample.databinding.FragmentMainBinding;
import ch.swissonid.mvvmexample.modelview.UserViewModel;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        FragmentMainBinding binding = DataBindingUtil.bind(view);
        binding.setUser(new UserViewModel());
        return view;
    }
}
