package com.example.kein_gold.menutest.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import com.example.kein_gold.menutest.adapter.ImageAdapter;
import com.example.kein_gold.menutest.activity.ListDetailActivity;
import com.example.kein_gold.menutest.R;
import com.example.kein_gold.menutest.api.service.ArticleService;
import com.example.kein_gold.menutest.model.ResponseArticlePagination;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.disposables.CompositeDisposable;

import static com.example.kein_gold.menutest.activity.ListDetailActivity.USER_ID;

public class Tab1 extends Fragment {

    @NonNull
    private CompositeDisposable articleCompositeDisposable = new CompositeDisposable();

    @BindView(R.id.grid_list)
    GridView gridview;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getArticleDetail();
    }

    public void getArticleDetail() {
        ArticleService articleService = new ArticleService();
        articleCompositeDisposable.add(articleService.getArticleList().subscribe(
                this::articleListSuccessResponse,
                this::articleListErrorResponse));
    }

    public void articleListSuccessResponse(ResponseArticlePagination responseArticlePagination) {
        gridview.setAdapter(new ImageAdapter(getContext(), responseArticlePagination.getItems()));
        gridview.setOnItemClickListener((parent, v, position, id) -> {
            Intent intent = new Intent(getActivity(), ListDetailActivity.class);
            intent.putExtra(USER_ID, id);
            startActivity(intent);
        });
    }

    public void articleListErrorResponse(Throwable throwable) {
        Toast.makeText(getContext(), throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStop() {
        super.onStop();
        if (!articleCompositeDisposable.isDisposed()) {
            articleCompositeDisposable.clear();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (!articleCompositeDisposable.isDisposed()) {
            articleCompositeDisposable.clear();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (!articleCompositeDisposable.isDisposed()) {
            articleCompositeDisposable.clear();
        }
    }
}
