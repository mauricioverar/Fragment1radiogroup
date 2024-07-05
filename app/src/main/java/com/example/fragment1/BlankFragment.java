package com.example.fragment1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import com.example.fragment1.databinding.FragmentBlankBinding;

public class BlankFragment extends Fragment {
    public interface OnOptionSelectedListener {
        void onOptionSelected(boolean isYesSelected);
    }

    private FragmentBlankBinding mBinding;

    private OnOptionSelectedListener listener;

    public void setOnOptionSelectedListener(OnOptionSelectedListener listener) {this.listener = listener;
    }


    public BlankFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate xml con binding

        mBinding = FragmentBlankBinding.inflate(inflater,container,false);
        return mBinding.getRoot();

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mBinding.radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                int index = mBinding.radiogroup.indexOfChild(mBinding.radiogroup.findViewById(checkedId));

                switch (index){


                    case 0:
                        mBinding.tvPregunta.setText(R.string.si);
                        if (listener != null) {
                            listener.onOptionSelected(true);
                        }
                        break;

                    case 1:
                        mBinding.tvPregunta.setText(R.string.no);
                        if (listener != null) {
                            listener.onOptionSelected(false);
                        }
                        break;

                    default:
                        break;

                }
            }
        });
    }
}