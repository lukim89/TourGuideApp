package com.example.android.tourguideapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class FragmentDetails extends Fragment {

    public FragmentDetails() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.details, container, false);

        Bundle bundle = getActivity().getIntent().getExtras();

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(bundle.getString("NAME"));

        TextView title = rootView.findViewById(R.id.title);
        title.setTextSize(20);
        title.setGravity(Gravity.CENTER_HORIZONTAL);
        title.setText(bundle.getString("NAME"));

        ImageView image = rootView.findViewById(R.id.image);
        image.setImageResource(bundle.getInt("IMAGE_ID"));

        TextView address = rootView.findViewById(R.id.address);
        address.setText(bundle.getString("ADDRESS"));

        TextView phone = rootView.findViewById(R.id.phone);
        if (!(bundle.getString("PHONE") == null)) {
            phone.setText(bundle.getString("PHONE"));
        } else phone.setVisibility(View.GONE);


        TextView web = rootView.findViewById(R.id.web);
        if (!(bundle.getString("URL") == null || bundle.getString("WEB") == null)) {
            String webUrl = ("<a href =\"" + bundle.getString("URL") + "\">" + bundle.getString("WEB") + "</a>");
            web.setText(Html.fromHtml(webUrl));
            web.setMovementMethod(LinkMovementMethod.getInstance());
        } else web.setVisibility(View.GONE);

        TextView description = rootView.findViewById(R.id.description);
        description.setText(bundle.getString("DESCRIPTION"));

        return rootView;
    }
}
