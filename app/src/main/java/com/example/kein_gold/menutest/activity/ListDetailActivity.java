package com.example.kein_gold.menutest.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kein_gold.menutest.R;
import com.example.kein_gold.menutest.api.service.ArticleService;
import com.example.kein_gold.menutest.model.ArticleDetail;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;

public class ListDetailActivity extends AppCompatActivity {

    public final static String USER_ID = "id";

    @BindView(R.id.name)
    public TextView name;

    @NonNull
    private CompositeDisposable articleCompositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_detail);
        ButterKnife.bind(this);

        long id = getIntent().getLongExtra(USER_ID, 0);
        setSupport();
        getArticleDetail(id);
    }

    private void setSupport() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (articleCompositeDisposable != null && !articleCompositeDisposable.isDisposed()) {
            articleCompositeDisposable.clear();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (articleCompositeDisposable != null && !articleCompositeDisposable.isDisposed()) {
            articleCompositeDisposable.clear();
        }
    }

    @Override
    public boolean onNavigateUp() {
        finish();
        return true;
    }

    public void getArticleDetail(long id) {
        ArticleService articleService = new ArticleService();
        articleCompositeDisposable.add(articleService.getArticleById(id).subscribe(
                this::detailSuccessResponse,
                this::detailErrorResponse));

    }

    public void detailSuccessResponse(ArticleDetail response) {
        getSupportActionBar().setTitle(response.getShortTitle());
        name.setText(response.getTitle());

    }

    public void detailErrorResponse(Throwable throwable) {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();

    }
}
