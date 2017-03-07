package csd.starter;


import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;


/**
 * Created by hongja on 2017/3/5.
 */
public class PreminumMemberBookTest {
    @Rule
    public ExpectedException noAPreminumMemberExcepiton = ExpectedException.none();
    Member member = new Member();

    @Test
    public void class_can_be_init(){
        PreminumMemberBook book = new PreminumMemberBook();
    }

    @Test
    public void exceptions_should_throw_exception_when_no_a_preminum(){
        //1、非高级会员，则抛异常
        member.setName("jack");
        member.setId("1111");
        member.setPremium(false);
        Court court = new Court();
        court.courtName = "softwarePark";

        noAPreminumMemberExcepiton.expect(RuntimeException.class);

        PreminumMemberBook.preminumBook(member,court,"2017-3-6 12:00:00");
    }

    @Test
    public void exceptions_should_throw_exception_when_enter_wrong_info(){

        noAPreminumMemberExcepiton.expect(RuntimeException.class);
        PreminumMemberBook.preminumBook(null,new Court(),"2017-3-6 12:00:00");

    }

    @Test
    public void should_store_bookInfo_after_preminummember_book(){

        member.setName("jack");
        member.setId("1111");
        member.setPremium(true);
        Court court = new Court();
        court.courtName = "softwarePark";

        PreminumMemberBook.preminumBook(member,court,"2017-3-6 12:00:00");

        assertNotNull(PreminumMemberBook.getPreminumBookInfo().get(member.getId()));
    }
}