package com.example.covidbook.ui.home;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.covidbook.R;
import com.example.covidbook.info.image.ImageChooserActivity;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private MutableLiveData<Bitmap> mImage;
    private Bitmap bmp;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mImage = new MutableLiveData<>();

        mText.setValue("Welcome, ");
        mImage.setValue(bmp);
    }

    public LiveData<String> getText() {
        return mText;
    }
    public LiveData<Bitmap> getImage() { return mImage; }
}