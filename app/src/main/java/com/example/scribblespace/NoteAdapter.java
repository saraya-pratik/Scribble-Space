package com.example.scribblespace;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class NoteAdapter extends FirestoreRecyclerAdapter<Note, NoteAdapter.NoteViewHolder>{

    Context context;

    public NoteAdapter(@NonNull FirestoreRecyclerOptions<Note> options, Context context) {
        super(options);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull NoteAdapter.NoteViewHolder holder, int position, @NonNull Note model) {

    }

    @NonNull
    @Override
    public NoteAdapter.NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    class NoteViewHolder extends RecyclerView.ViewHolder{
        TextView titleTextView, contextTextView, timestampTextView;
        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.notes_title_text);
            contextTextView = itemView.findViewById(R.id.notes_content_text);
            timestampTextView = itemView.findViewById(R.id.node_TimeStamp_text_view);
        }
    }
}
