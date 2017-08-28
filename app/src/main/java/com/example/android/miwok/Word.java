package com.example.android.miwok;

/**
 * Created by codeTribe on 2017/06/28.
 */

public class Word
{
    private String mDefaultTranslation;
    private String mMiworkTranslation;
    private int mImageResourceId=NO_IMAGE_PROVIDED;
    private  static final int NO_IMAGE_PROVIDED=-1;
    private int mAudioResourceId;

    public Word(String defaultTranslation, String miworkTranslation,int audioResourceId)
    {
        mDefaultTranslation = defaultTranslation;
        mMiworkTranslation = miworkTranslation;
        mAudioResourceId=audioResourceId;
    }


    public Word(String defaultTranslation, String miworkTranslation, int imageResourceId,int audioResourceId)
    {
        mDefaultTranslation = defaultTranslation;
        mMiworkTranslation = miworkTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId=audioResourceId;
    }


    public String getmDefaultTranslation()
    {

        return mDefaultTranslation;
    }

    public String getmMiworkTranslation()
    {
        return mMiworkTranslation;
    }




    public int getmImageResourceId()
    {
return mImageResourceId;
    }


    public boolean hasimage(){
return mImageResourceId !=NO_IMAGE_PROVIDED;
    }

    public int getmAudioResourceId(){

        return  mAudioResourceId;
    }
}
