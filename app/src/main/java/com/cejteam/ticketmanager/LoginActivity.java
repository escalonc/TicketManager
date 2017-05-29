package com.cejteam.ticketmanager;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.cejteam.core.ILoginInteractor;
import com.cejteam.core.LoginInteractor;
import com.cejteam.data.repositories.UserRepository;
import com.cejteam.helpers.injection.TicketManagerApplication;
import com.cejteam.presenters.LoginPresenter;

import java.util.Dictionary;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity {

    LoginPresenter loginPresenter = new LoginPresenter(new LoginInteractor(new UserRepository()));
    //@Inject LoginPresenter loginPresenter;

    private UserLoginTask mAuthTask = null;

    // UI references.
    private EditText mUsernameView;
    private EditText mPasswordView;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //((TicketManagerApplication)getApplicationContext()).getApplicationComponent().inject(this);

        // Set up the login form.
        mUsernameView = (EditText) findViewById(R.id.username);

        mPasswordView = (EditText) findViewById(R.id.password);

//        mPasswordView.setOnEditorActionListener((textView, id, keyEvent) -> {
//            if (id == R.id.login || id == EditorInfo.IME_NULL) {
//                attemptLogin();
//                return true;
//            }
//            return false;
//        });

        Button mSignInButton = (Button) findViewById(R.id.sign_in_button);
        mSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptLogin();
            }
        });

    }

    private void attemptLogin()
    {
        if (mAuthTask != null) {
            return;
        }

        // Reset errors.
        mUsernameView.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String username = mUsernameView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }

        // Check for a valid username address.
        if (TextUtils.isEmpty(username)) {
            mUsernameView.setError(getString(R.string.error_field_required));
            focusView = mUsernameView;
            cancel = true;
        } else if (!isUsernameValid(username)) {
            mUsernameView.setError(getString(R.string.error_invalid_username));
            focusView = mUsernameView;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        }
        else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
//            showProgress(true);
            progressDialog = new ProgressDialog(LoginActivity.this,
                    R.style.AppTheme_Dark_Dialog);
            progressDialog.setIndeterminate(true);
            progressDialog.setMessage("Authenticating...");
            progressDialog.show();

            mAuthTask = new UserLoginTask(username, password);
            mAuthTask.execute((Void) null);

//            if (loginPresenter.login(username, password)){
//                startActivity(new Intent(getApplicationContext(), MainActivity.class));
//            }

        }
    }

    private boolean isUsernameValid(String username) {
        return username.length() > 0;
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 4;
    }

    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {
        private final String mUsername;
        private final String mPassword;

        UserLoginTask(String username, String password) {
            mUsername = username;
            mPassword = password;
        }

        @Override
        protected Boolean doInBackground(Void... params)
        {
            // TODO: improve

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return loginPresenter.login(mUsername, mPassword);
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            mAuthTask = null;
            //showProgress(false);
            progressDialog.dismiss();

            if (success) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            } else {
                mPasswordView.setError(getString(R.string.error_incorrect_password));
                mPasswordView.requestFocus();
            }
        }

        @Override
        protected void onCancelled() {
            mAuthTask = null;
            progressDialog.dismiss();
            //showProgress(false);
        }
    }
}

