package com.jordanschwichtenberg.simpleimagebrowser;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends android.support.v4.app.Fragment {

    LinearLayout imageGallery;

    private String[] filePathStrs;
    private String[] fileNameStrs;
    private String[] mImageFileUris;
    //private File[] files;

    private ArrayList<File> files;
    private ArrayList<ImageView> mImageViewsList;
    private ImageLoader imageLoader;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private void drawImages(ArrayList imageViews, ArrayList files, int filesPointer) {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Initialize ImageLoader from external library
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getActivity()).build();
        ImageLoader.getInstance().init(config);
        imageLoader = ImageLoader.getInstance();

        mImageViewsList = new ArrayList<>();
        files = new ArrayList<>();

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        imageGallery = (LinearLayout) v.findViewById(R.id.imageGallery);
        //imageGallery = (TableLayout) v.findViewById(R.id.imageGallery);

        File file = new File(Environment.getExternalStorageDirectory() + File.separator + "test");
        file.mkdirs();

        files.addAll(Arrays.asList(file.listFiles()));

        int filesPointer = 0;

        ImageView iv1 = (ImageView) v.findViewById(R.id.imageGallery_1);
        ImageView iv2 = (ImageView) v.findViewById(R.id.imageGallery_2);
        ImageView iv3 = (ImageView) v.findViewById(R.id.imageGallery_3);
        ImageView iv4 = (ImageView) v.findViewById(R.id.imageGallery_4);
        ImageView iv5 = (ImageView) v.findViewById(R.id.imageGallery_5);

        mImageViewsList.add(iv1);
        mImageViewsList.add(iv2);
        mImageViewsList.add(iv3);
        mImageViewsList.add(iv4);
        mImageViewsList.add(iv5);

        List temp = files.subList(filesPointer, filesPointer + 5);





        /*imageLoader.displayImage("file://" + files[filesPointer].getAbsolutePath(), iv1);
        filesPointer++;
        imageLoader.displayImage("file://" + files[filesPointer].getAbsolutePath(), iv2);
        filesPointer++;
        imageLoader.displayImage("file://" + files[filesPointer].getAbsolutePath(), iv3);
        filesPointer++;
        imageLoader.displayImage("file://" + files[filesPointer].getAbsolutePath(), iv4);
        filesPointer++;
        imageLoader.displayImage("file://" + files[filesPointer].getAbsolutePath(), iv5);*/



        /*for (File f : files) {
        //for (int i = 0; i < 5; i++) {
            //imageGallery.addView(insertPhoto(f.getAbsolutePath()));
            imageGallery.addView(insertImage("file://" + f.getAbsolutePath()));
            Log.i("myapp", f.getAbsolutePath());

            //String fname = f.getAbsolutePath();



        }*/

        /*for (File f : files) {
            Log.w("myapp", f.getAbsolutePath());
            imageGallery.addView(insertImage(f.getAbsolutePath()));
        }*/

        return v;
    }

    View insertImage(String path) {
        /*Bitmap bmp = BitmapFactory.decodeFile(path);

        LinearLayout layout = new LinearLayout(getActivity().getApplicationContext());
        layout.setLayoutParams(new ViewGroup.LayoutParams(220, 220));
        layout.setGravity(Gravity.CENTER);

        ImageView iv = new ImageView(getActivity().getApplicationContext());
        iv.setLayoutParams(new ViewGroup.LayoutParams(200, 200));
        iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        iv.setImageBitmap(bmp);

        layout.addView(iv);
        return layout;*/

        /*Bitmap bmp = BitmapFactory.decodeFile(path);

        ImageView imgview = new ImageView(getActivity().getApplicationContext());
        imgview.setLayoutParams(new ViewGroup.LayoutParams(200, 200));
        imgview.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imgview.setImageBitmap(bmp);*/

        ImageView iv = new ImageView(getActivity().getApplicationContext());
        iv.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        iv.setLayoutParams(new ViewGroup.LayoutParams(400, ViewGroup.LayoutParams.MATCH_PARENT));
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.displayImage(path, iv);
        iv.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

        return iv;
    }

    View insertPhoto(String path) {
        Bitmap bm = decodeSampledBitmapFromUri(path, 220, 220);

        /*LinearLayout layout = new LinearLayout(getActivity().getApplicationContext());
        layout.setLayoutParams(new ViewGroup.LayoutParams(250, 250));
        layout.setGravity(Gravity.CENTER);*/

        ImageView imageView = new ImageView(getActivity().getApplicationContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(220, 200));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageBitmap(bm);

        //layout.addView(imageView);
        //return layout;
        return imageView;
    }

    public Bitmap decodeSampledBitmapFromUri(String path, int reqWidth, int reqHeight) {
        Bitmap bm = null;

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        bm = BitmapFactory.decodeFile(path, options);

        return bm;
    }

    public int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {
            if (width > height) {
                inSampleSize = Math.round((float)height / (float)reqHeight);
            } else {
                inSampleSize = Math.round((float)width / (float)reqWidth);
            }
        }

        return inSampleSize;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
