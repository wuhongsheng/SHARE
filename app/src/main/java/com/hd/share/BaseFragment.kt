package com.hd.share

import android.os.Bundle
import android.support.v4.app.Fragment

/**
 * Created by whs on 2017/5/27
 */

class BaseFragment : Fragment() {
    private val mViewModel: BaseViewModel? = null


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }
    /*private void setupSnackbar() {
        mMainViewModel.snackbarText.addOnPropertyChangedCallback(
                new Observable.OnPropertyChangedCallback() {
                    @Override
                    public void onPropertyChanged(Observable observable, int i) {
                        SnackbarUtils.showSnackbar(getView(), mMainViewModel.getSnackbarText());

                    }
                });
    }*/
}
