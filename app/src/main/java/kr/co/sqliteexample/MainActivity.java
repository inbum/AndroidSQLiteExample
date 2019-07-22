package kr.co.sqliteexample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // Create sample data
        User sampleUser = new User();
        sampleUser.userName = "Steph";
        sampleUser.profilePictureUrl = "https://i.imgur.com/tGbaZCY.jpg";


        // Get singleton instance of database
        SampleDatabaseHelper databaseHelper = SampleDatabaseHelper.getInstance(this);


        Post samplePost = new Post();
        samplePost.user = sampleUser;
        samplePost.text = "Won won!";


        Post samplePost2 = new Post();
        samplePost2.user = sampleUser;
        samplePost2.text = "Won won222!";

        Post samplePost3 = new Post();
        samplePost3.user = sampleUser;
        samplePost3.text = "Won won333!";

        // Add sample post to the database
        databaseHelper.addPost(samplePost);
        databaseHelper.addPost(samplePost2);
        databaseHelper.addPost(samplePost3);

        // Get all posts from database
        List<Post> posts = databaseHelper.getAllPosts();
        for (Post post : posts) {
            // do something
            Log.e("MainActivity", post.toString());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
