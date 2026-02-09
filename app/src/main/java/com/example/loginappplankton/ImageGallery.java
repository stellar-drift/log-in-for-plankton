package com.example.loginappplankton;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;


public class ImageGallery extends AppCompatActivity {

    // create array of resource objects (images) to be used in the gallery
    Integer[] Plankton = {R.drawable.diatom_pexels_turek3024,
            R.drawable.noaa_wagon_wheel_diatom,
            R.drawable.noaa_siphonocladus_tropicus_green_algae,
            R.drawable.dinoflagellates_wikimedia_commons,
            R.drawable.noaa_antarctic_diatoms,
            R.drawable.noaa_phytoplankton_general,
            R.drawable.noaa_stick_star_diatom,
            R.drawable.noaa_pseudo_nitzschia_harmful_aglae,
            R.drawable.saketh_unsplash_algae};

    String[] Captions = {"Microscope image of a diatom",
            "Wagon Wheel diatom",
            "Siphonocladus tropicus",
            "Bioluminescent dinoflagellates",
            "Diatoms sampled from the antarctic",
            "Microscope image of phytoplankton",
            "Stick star diatom",
            "Pseudo nitzschia",
            "Phytoplankton in the wild"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_gallery);


        // get GridView object
        GridView grid = (GridView) findViewById(R.id.imgGrid);

        // configure GridView; use setAdapter() to attach the ImageAdapter class (defined below) to the GridView
        grid.setAdapter(new ImageAdapter(this));

        // add event listener to the GridView object
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            // AdapterView<?>: generic/template; an adapter view of ~*some type*~; the AdapterView where the click happened
            // view: View - the view provided by the adapter
            // position: int - the position/index of the view in the adapter
            // id: long - the row id of the item that was clicked
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // instantiate a new intent object, with source and destination activity classes
                Intent intent = new Intent(ImageGallery.this, ImageFull.class);

                // use putExtra() to attach data to the intent so it's transferred between activities;
                // create a key in the first parameter that identifies the data that's being sent, and
                // attach the actual data in the second parameter, using the position callback from onItemClick()
                intent.putExtra("imageResId", Plankton[position]);
                intent.putExtra("captions", Captions[position]);

                // start the new activity as defined in intent
                startActivity(intent);
            }
        });


        // get button object
        Button btnLogout = findViewById(R.id.btnReturn);

        // add event listener to button object
        btnLogout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // end the current activity and remove it from the activity stack; return to previous activity if available
                finish();
            }
        });
    }


    // this class handles adapting images to the GridView cells; inherits methods from abstract class BaseAdapter
    public class ImageAdapter extends BaseAdapter {

        // initialize a variable to store context
        private Context context;

        // set up constructor to receive the activity context
        public ImageAdapter (Context c) { context=c; }

        @Override
        // return the number of items in the array (Plankton)
        public int getCount() { return Plankton.length; }

        @Override
        // return the image resource id at a particular position
        public Object getItem(int position) {
            return Plankton[position];
        }

        @Override
        // return the position of the item as a unique id
        public long getItemId(int position) {
            return position;
        }

        @Override
        // create and return the view for each grid cell
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView pic = new ImageView(context);
            pic.setImageResource(Plankton[position]);
            pic.setScaleType(ImageView.ScaleType.FIT_XY);
            pic.setLayoutParams(new GridView.LayoutParams(300,300));

            int padding = 20;
            pic.setPadding(padding, padding - 10 , padding, padding - 10);

            return pic;
        }
    }
}
