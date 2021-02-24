package com.example.geoquizz;

import android.util.Log;

import androidx.lifecycle.ViewModel;

public class QuizViewModel extends ViewModel {

    private static final String TAG = "QuizViewModel";

    public void init(){
        Log.d(TAG, "ViewModel instance created");
    }
    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d("TAG", "View model instance about be destroyed");
    }
}
