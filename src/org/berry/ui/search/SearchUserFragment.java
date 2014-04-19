package org.berry.ui.search;

import android.os.Bundle;
import android.support.v4.content.Loader;
import android.view.Menu;
import android.view.MenuInflater;

import org.berry.bean.UserBean;
import org.berry.bean.UserListBean;
import org.berry.bean.android.AsyncTaskLoaderResult;
import org.berry.support.utils.GlobalContext;
import org.berry.ui.basefragment.AbstractUserListFragment;
import org.berry.ui.loader.SearchUserLoader;

import java.util.List;

/**
 * User: qii
 * Date: 12-11-10
 */
public class SearchUserFragment extends AbstractUserListFragment {

    private int page = 1;


    public SearchUserFragment() {
        super();
    }

    public void search() {
        pullToRefreshListView.setRefreshing();
        loadNewMsg();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(false);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        //don't need refresh menu

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            clearAndReplaceValue((UserListBean) savedInstanceState.getParcelable("bean"));
            getAdapter().notifyDataSetChanged();
        }
        refreshLayout(bean);
    }


    @Override
    protected void oldUserOnPostExecute(UserListBean newValue) {
        if (newValue != null && newValue.getUsers().size() > 0) {
            List<UserBean> list = newValue.getUsers();
            getList().getUsers().addAll(list);
            page++;
        }
    }


    @Override
    protected Loader<AsyncTaskLoaderResult<UserListBean>> onCreateNewMsgLoader(int id, Bundle args) {
        String token = GlobalContext.getInstance().getSpecialToken();
        String word = ((SearchMainParentFragment) getParentFragment()).getSearchWord();
        page = 1;
        return new SearchUserLoader(getActivity(), token, word, String.valueOf(page));
    }

    @Override
    protected Loader<AsyncTaskLoaderResult<UserListBean>> onCreateOldMsgLoader(int id, Bundle args) {
        String token = GlobalContext.getInstance().getSpecialToken();
        String word = ((SearchMainParentFragment) getParentFragment()).getSearchWord();
        return new SearchUserLoader(getActivity(), token, word, String.valueOf(page + 1));
    }

}

