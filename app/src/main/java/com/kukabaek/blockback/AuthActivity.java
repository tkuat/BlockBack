package com.kukabaek.blockback;



        import android.content.Context;
        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.annotation.Nullable;
        import android.support.v4.app.Fragment;
        import static java.security.AccessController.getContext;


public class AuthActivity extends AppCompatActivity {

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showAuth();
    }

    private void showAuth() {
        AuthFragment fragment = new AuthFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.activity_main, fragment)
                .addToBackStack(null)
                .commit();
    }

    private static void showMain() {
        Intent intent = new Intent(this, MainActivity.class);
        new AppCompatActivity().startActivity(intent); // show Main Activity
    }

    public static class AuthFragment extends Fragment {

        public void onAuthSuccess() {
            new AppCompatActivity().finish(); // Destroy current activity
        }
    }


    public static class MainFragment extends Fragment {

    }
}