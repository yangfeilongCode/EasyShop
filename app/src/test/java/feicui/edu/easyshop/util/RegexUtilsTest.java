package feicui.edu.easyshop.util;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/11/24.
 */
public class RegexUtilsTest {


    public static final int VERIFY_SUCCESS = 0;

    public static final int VERIFY_LENGTH_ERROR = 1;

    public static final int VERIFY_TYPE_ERROR = 2;

    private RegexUtils regexUtils;

    @BeforeClass
    public static void beforeSet() throws Exception{

    }
    @Before
    public void setUp() throws Exception {
         regexUtils=new RegexUtils();
    }

    @Test
    public void verifyUsername() throws Exception {
        int username = regexUtils.verifyUsername("123");
        assertEquals(1,username);
    }

    @Test
    public void verifyPassword() throws Exception {

    }

    @Test
    public void verifyNickname() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @AfterClass
    public static void afterTear() throws Exception{

    }

}