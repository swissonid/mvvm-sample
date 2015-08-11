package ch.swissonid.mvvmexample.modelview;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import ch.swissonid.mvvmexample.model.User;

import static org.assertj.core.api.Assertions.*;
/**
 * Created by pmueller on 11.8.15.
 */
public class UserModelViewTest {

    private static final String NAME = "TestName";
    private static final String LAST_NAME = "TestLastName";
    private static final String EMAIL = "testName@gmail.com";
    private static final String INIT_BIRTH_DAY = "01.08.1997";
    public static final String BIRTH_DAY = "01.09.1997";

    private UserViewModel mUserViewModel;

    @Rule
    public ExpectedException thrown= ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.GERMANY);

        Date userBirthday = dateFormat.parse(INIT_BIRTH_DAY);
        User user = new User(NAME, LAST_NAME, EMAIL,userBirthday);
        mUserViewModel = new UserViewModel(user);
    }

    @Test
    public void birthdayTest() throws ParseException {
        assertThat(mUserViewModel.getBirthday()).isNotEmpty();
        assertThat(mUserViewModel.getBirthday()).isEqualTo(INIT_BIRTH_DAY);

        mUserViewModel.setBirthDay(BIRTH_DAY);
        assertThat(mUserViewModel.getBirthday()).isEqualTo(BIRTH_DAY);

        mUserViewModel.setBirthDay("3.9.1997");
        assertThat(mUserViewModel.getBirthday()).isEqualTo("03.09.1997");
    }

    @Test
    public void birthdayExceptionTest() throws ParseException {
        thrown.expect(ParseException.class);
        thrown.expectMessage("Year (97) to short, it has to be four characters");
        mUserViewModel.setBirthDay("3.9.97");
    }


    @Test
    public void isValidTest(){
        assertThat(mUserViewModel.isValid()).isTrue();

        mUserViewModel.setName("H");
        assertThat(mUserViewModel.isValid()).isFalse();

        mUserViewModel.setName("Ha");
        assertThat(mUserViewModel.isValid()).isTrue();
    }
}
