package com.mywork.fragmentsindialog.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.mywork.fragmentsindialog.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainDialogFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainDialogFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainDialogFragment extends DialogFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private FragmentActivity fActivity;
    private Fragment fragment;
    private Button nextButton;

    private OnFragmentInteractionListener mListener;

    public MainDialogFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainDialogFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainDialogFragment newInstance(String param1, String param2) {
        MainDialogFragment fragment = new MainDialogFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
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
        fActivity = getActivity();
        fragment = this;
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        nextButton = view.findViewById(R.id.btn_next);

        FirstFragment firstFragment = FirstFragment.newInstance("param1", "param2");
        FragmentManager fm = fragment.getChildFragmentManager();
        FrameLayout fl = view.findViewById(R.id.frag_dialog);
        fl.removeAllViews();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frag_dialog, firstFragment, "FIRST_FRAGMENT");
        fragmentTransaction.commit();
        fm.executePendingTransactions();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment childFrag = fragment.getChildFragmentManager().findFragmentById(R.id.frag_dialog);

                if(childFrag!=null && childFrag instanceof FirstFragment){
                    SecondFragment secondFragment = SecondFragment.newInstance("param1", "param2");
                    FragmentManager fm = fragment.getChildFragmentManager();
                    FrameLayout fl = fragment.getView().findViewById(R.id.frag_dialog);
                    fl.removeAllViews();
                    FragmentTransaction fragmentTransaction = fm.beginTransaction();
                    fragmentTransaction.replace(R.id.frag_dialog, secondFragment, "SECOND_FRAGMENT");
                    fragmentTransaction.commit();
                    fm.executePendingTransactions();
                }
            }
        });
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onDialogFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
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
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onDialogFragmentInteraction(Uri uri);
    }
}
