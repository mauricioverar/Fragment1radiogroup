package com.example.fragment1;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements BlankFragment.OnOptionSelectedListener {

    private ImageView ivMario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivMario = findViewById(R.id.ivMario);

        BlankFragment fragment = new BlankFragment();
        fragment.setOnOptionSelectedListener(this);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.fragmentContainerView, fragment);
        fragmentTransaction.commit();

    }

    @Override
    public void onOptionSelected(boolean isYesSelected) {
        if (isYesSelected) {
            ivMario.setImageResource(R.drawable.luigi);
        } else {
            ivMario.setImageResource(R.drawable.mariobross);
        }
    }
}