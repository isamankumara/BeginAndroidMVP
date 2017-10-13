package com.example.saman.mvp_begin.presentation.users;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.example.saman.mvp_begin.R;
import com.example.saman.mvp_begin.domain.User;

import java.util.ArrayList;
import java.util.List;

import static android.support.v4.util.Preconditions.checkNotNull;

/**
 * Created by saman on 10/4/17.
 */
public class UsersFragment extends Fragment implements UsersContract.View  {

    private UsersContract.Presenter mPresenter;
    private UsersAdapter mListAdapter;


    @Override
    public void setPresenter(UsersContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<User> na = new ArrayList<User>();
        na.add(new User("saman"));
        na.add(new User("test name"));

        mListAdapter = new UsersAdapter(na, mUserListener);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.tasks_frag, container, false);

        ListView listView = (ListView) root.findViewById(R.id.tasks_list);
        listView.setAdapter(mListAdapter);

        return root;
    }

    public static UsersFragment newInstance() {
        return new UsersFragment();
    }

    UserItemListener mUserListener = new UserItemListener() {
        @Override
        public void onUserClick(User clickedUser) {

        }
    };


    private static class UsersAdapter extends BaseAdapter {

        private List<User> mUsers;
        private UserItemListener mUserListener;

        public UsersAdapter(List<User> tasks, UserItemListener userListener) {
            setList(tasks);
            mUserListener = userListener;
        }

        public void replaceData(List<User> tasks) {
            setList(tasks);
            notifyDataSetChanged();
        }

        private void setList(List<User> tasks) {
            mUsers = checkNotNull(tasks);
        }

        @Override
        public int getCount() {
            return mUsers.size();
        }

        @Override
        public User getItem(int i) {
            return mUsers.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View rowView = view;
            if (rowView == null) {
                LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
                rowView = inflater.inflate(R.layout.user_item, viewGroup, false);
            }

            final User user = getItem(i);

            TextView titleTV = (TextView) rowView.findViewById(R.id.title);
            titleTV.setText(user.getName());


            rowView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mUserListener.onUserClick(user);
                }
            });

            return rowView;
        }
    }

    public interface UserItemListener {

        void onUserClick(User clickedUser);
    }
}
