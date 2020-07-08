
/**
 * Class used to exercise classes LotteryDraw and LotteryTicket
 * 
 * @author Marius.Joldos
 * @version 2009.10.16
 */
public class TestLottery
{
    public static void main()
    {
        LotteryDraw l1, l2, l3, l4;
        LotteryTicket b1, b2, b3, b4, b5;
        
        l1 = new LotteryDraw(4, 40);
        l2 = new LotteryDraw(6, 49);
        b1 = new LotteryTicket(4, 40);
        b1.autofill();
        b2 = new LotteryTicket(4, 40);
        b2.autofill();
        b3 = new LotteryTicket(6, 49);
        b3.readNumbers();
        l1.draw();
        l1.list();
        b1.list();
        l1.checkWins(b1);
        b2.list();
        l1.checkWins(b2);
        b3.list();
        l1.checkWins(b3);
        b3.list();
        l2.checkWins(b3);
        
    }
}
