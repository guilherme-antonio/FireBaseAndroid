package br.ifsc.edu.br.firebase;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Iterator;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference reference;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = FirebaseDatabase.getInstance();
        reference = database.getReference();
        auth = FirebaseAuth.getInstance();
//
//        Usuario usuario = new Usuario("001", "Rati", 18, "rati@gmail.com");
//
//        reference.child("usuarios").push().setValue(usuario);
//
//        usuario = new Usuario("001", "Teste", 20, "Teste@gmail.com");
//
//        reference.child("usuarios").push().setValue(usuario);
//
//        usuario = new Usuario("001", "asd", 123, "asd@gmail.com");
//
//        reference.child("usuarios").push().setValue(usuario);
//
//        usuario = new Usuario("001", "aaa", 18, "aaa@gmail.com");
//
//        reference.child("usuarios").push().setValue(usuario);

//        reference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                Log.i("FIREBASE:", dataSnapshot.getValue().toString());
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });

        //Recuperando dados apartir de um id específico
        //DatabaseReference referenciaUsuario = reference.child("usuarios");

//        referenciaUsuario.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                Usuario user = dataSnapshot.getValue(Usuario.class);
//                Log.i("FIREBASE:", "nome = " + user.getNome() + " " + user.getEmail());
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });

//        Query usuarioPesquisa = referenciaUsuario.orderByChild("nome").equalTo("Rati");
//
//        usuarioPesquisa.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                Iterator<DataSnapshot> results = dataSnapshot.getChildren().iterator();
//
//                while (results.hasNext())
//                {
//                    Usuario user = results.next().getValue(Usuario.class);
//                    Log.i("FIREBASE:", "nome = " + user.getNome() + " " + user.getEmail());
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });

        //Autenticação
        auth.createUserWithEmailAndPassword("guilherme@gmail.com", "testeasdasd")
        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                    Toast.makeText(getApplicationContext(),
                            "Usuário criado com sucesso", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(),
                            "ERRO - Usuário não foi criado", Toast.LENGTH_LONG).show();
            }
        });

        //Desconectar usuário
        auth.signOut();

        auth.signInWithEmailAndPassword("guilherme@gmail.com", "testeasdasd");

        //Verificar se o usuário está logado
        if (auth.getCurrentUser() != null)
        {
            Toast.makeText(getApplicationContext(),
                    "Usuário logado: " + auth.getCurrentUser().getEmail(), Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),
                    "Não há usuário conectado", Toast.LENGTH_LONG).show();
        }
    }
}
