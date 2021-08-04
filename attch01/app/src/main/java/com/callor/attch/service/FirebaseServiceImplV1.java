package com.callor.attch.service;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.callor.attch.adapter.ChattAdapter;
import com.callor.attch.model.chatt;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

public class FirebaseServiceImplV1 implements ChildEventListener {

    private ChattAdapter apdapter;

    public FirebaseServiceImplV1(ChattAdapter apdapter) {
        this.apdapter = apdapter;
    }

    @Override
    public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
        chatt chatt = snapshot.getValue(chatt.class);
        apdapter.addChattList(chatt);
    }

    @Override
    public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

    }

    @Override
    public void onChildRemoved(@NonNull DataSnapshot snapshot) {

    }

    @Override
    public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

    }

    @Override
    public void onCancelled(@NonNull DatabaseError error) {

    }
}
