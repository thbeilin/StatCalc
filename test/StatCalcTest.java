import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StatCalcTest {
    @Test
    public void AVGCalcTest(){
        int atBats = 9, hits = 3;
        float avg = StatCalc.AVGCalc(hits, atBats);
        assertEquals(avg, (float)1/3);
    }
    @Test
    public void SLGCalcTest(){
        int atBats = 9, totalBases = 10;
        float slg = StatCalc.SLGCalc(totalBases, atBats);
        assertEquals(slg, (float)10/9);
    }
    @Test
    public void OPSCalcTest(){
        int atBats = 9, hits = 3, totalBases = 5;
        float ops = StatCalc.OPSCalc(hits,totalBases, atBats);
        assertEquals(ops, (float)1/3+(float)5/9);
    }
}
