package ch.swissonid.mvvmexample.modelview;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.Editable;
import android.text.TextWatcher;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

import ch.swissonid.mvvmexample.model.User;
import ch.swissonid.mvvmexample.util.TextWatcherAdapter;

public class UserViewModel extends BaseObservable {
    private User mUser;
    private DateFormat mDateFormat;

    public UserViewModel(){
        mDateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.GERMANY);
        mUser = new User("","","",new Date(System.currentTimeMillis()));
    }

    public UserViewModel(final User user) {
        this();
        mUser = user;
    }

    @Bindable
    public String getName(){
        if(mUser == null) return null;
        return mUser.getName();
    }

    public String getLastName(){
        if(mUser == null) return null;
        return mUser.getLastName();
    }

    public String getBirthday(){
        if(mUser == null) return null;
        return mDateFormat.format(mUser.getBirthDay());
    }

    public void setBirthDay(final String birthDay) throws ParseException {
        validateYear(birthDay);
        Date date = mDateFormat.parse(birthDay);
        mUser.setBirthDay(date);
    }

    private void validateYear(final String date) throws ParseException{
        int lastPointIndex = date.lastIndexOf(".")+1;
        String year = date.substring(lastPointIndex, date.length());
        if(year.length() < 4 ){
            throw new ParseException("Year ("+year+") to short, it has to be four characters",lastPointIndex);
        }
    }

    public boolean isValid() {
        if(mUser == null) return false;
        if(mUser.getName().length() < 2) return false;
        if(mUser.getLastName().length() < 2) return false;
        return true;
    }

    public TextWatcher nameWatcher = new TextWatcherAdapter(){
        @Override public void afterTextChanged(Editable s) {
            if (!Objects.equals(mUser.getName(), s.toString())) {
                mUser.setName(s.toString());
                notifyChange();
            }
        }
    };

    public TextWatcher lastNameWatcher = new TextWatcherAdapter(){
        @Override public void afterTextChanged(Editable s) {
            if (!Objects.equals(mUser.getLastName(), s.toString())) {
                mUser.setLastName(s.toString());
                notifyChange();
            }
        }
    };

    public void setName(final String name) {
        mUser.setName(name);
    }
}
