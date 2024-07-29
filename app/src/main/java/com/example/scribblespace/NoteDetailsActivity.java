package com.example.scribblespace;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;

public class NoteDetailsActivity extends AppCompatActivity {

    EditText titleEditText, contentEditText;
    ImageButton saveNoteButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_details);

        titleEditText = findViewById(R.id.notes_title_text);
        contentEditText = findViewById(R.id.notes_content_text);
        saveNoteButton = findViewById(R.id.save_note_btn);

        saveNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveNote();
            }
        });
    }

    void saveNote(){
        String noteTitle = titleEditText.getText().toString();
        String noteContent = contentEditText.getText().toString();
        if(noteTitle == null || noteTitle.isEmpty()){
            titleEditText.setError("Title is Required");
            return;
        }

        Note note = new Note();
        note.setTitle(noteTitle);
        note.setContent(noteContent);
        note.setTimestamp(Timestamp.now());

        saveNoteToFirebase(note);
    }
    void saveNoteToFirebase(Note note){
        DocumentReference documentReference = Utility.getCollectionReferenceForNotes().document();

        documentReference.set(note).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Utility.showToast( NoteDetailsActivity.this, "Note Added Successfully!");
                    finish();
                }
                else {
                    Utility.showToast(NoteDetailsActivity.this, "Failed while adding note");
                }
            }
        });
    }
}