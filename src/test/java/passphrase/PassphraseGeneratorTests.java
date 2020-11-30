package passphrase;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PassphraseGeneratorTests {

    private final List<String> lowers;
    private final List<String> uppers;
    private final List<String> numbers;

    PassphraseGeneratorTests() {
        this.lowers = Arrays.asList("a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z".split(","));
        this.uppers = Arrays.asList("A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z".split(","));
        this.numbers = Arrays.asList("1,2,3,4,5,6,7,8,9,0".split(","));
    }

    @Test
    void generatePassphraseNotContainUppers() {

        String[] l_test = new String[10000];
        for (int i = 0; i < 10000; i++) {
            PassphraseGenerator PG = new PassphraseGenerator(true, false, true);
            l_test[i]=PG.generate(1024);
        }
        boolean testcode;
        if(Arrays.asList(l_test).contains(uppers)){
            testcode=false;
        }else{
            testcode=true;
        }
        assertEquals(true,testcode);
    }
    @Test
    void generatePassphraseBySpecifiedLength() {
        PassphraseGenerator PG = new PassphraseGenerator(true, true, true);
        Random random = new Random();
        int le = random.nextInt(10000);
        String leng = PG.generate(le);
        assertEquals(le,leng.length());
    }
    @Test
    void generateEmptyWhenAllConfigIsFalse() {
        PassphraseGenerator PG = new PassphraseGenerator(false, false, false);
        String space = PG.generate(10);
        assertEquals("",space);
    }
}

