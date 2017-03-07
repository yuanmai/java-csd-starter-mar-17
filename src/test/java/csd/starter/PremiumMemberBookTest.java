package csd.starter;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;


/**
 * Created by hongja on 2017/3/5.
 */
public class PremiumMemberBookTest {
    @Rule
    public ExpectedException noAPremiumMemberException = ExpectedException.none();
    Member member = new Member();

    @Test
    public void class_can_be_init(){
        PremiumMemberBook book = new PremiumMemberBook();
    }

    @Test
    public void exceptions_should_throw_exception_when_no_a_preminum(){
        //1、非高级会员，则抛异常
        member.setName("jack");
        member.setId("1111");
        member.setPremium(false);
        Court court = new Court();
        court.courtName = "softwarePark";

        noAPremiumMemberException.expect(RuntimeException.class);

        PremiumMemberBook.premiumBook(member,court,"2017-3-6 12:00:00");
    }

    @Test
    public void exceptions_should_throw_exception_when_enter_wrong_info(){

        noAPremiumMemberException.expect(RuntimeException.class);
        PremiumMemberBook.premiumBook(null,new Court(),"2017-3-6 12:00:00");

    }

    @Test
    public void should_store_bookInfo_after_premiumMember_book(){

        member.setName("jack");
        member.setId("1111");
        member.setPremium(true);
        Court court = new Court();
        court.courtName = "softwarePark";

        PremiumMemberBook.premiumBook(member,court,"2017-3-6 12:00:00");

        assertNotNull(PremiumMemberBook.getPremiumBookInfo().get(member.getId()));
    }
}