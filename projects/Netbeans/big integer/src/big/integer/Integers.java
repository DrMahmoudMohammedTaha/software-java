package big.integer;

public class Integers {

    private char[] num = new char[40];

    public Integers() {
        for (int i = 0; i < 40; i++) {
            num[i] = '0';
        }
    }

    Integers(String x) {
        if (x .length() > 40) {
            for (int i = 0; i < x.length(); i++) {
                num[i] = x .charAt(i);

            }
        }
        else
        {
            for (int i = 0; i < x.length(); i++) {
                num[i] = x .charAt(i);

            }
            for (int i = x.length(); i < 40; i++) {
                num[i] = '0';

            }
        
        }

    }

    @Override
    public String toString() {
        String x = "";
        for (int i = 0; i < 40; i++) {
            x += num[i] + "";
        }
        return x;
    }

    public static Integers parseBIg(String x) {
        Integers bigint = new Integers();
        if ((x + "").length() > 40) {
            for (int i = 0; i < 40; i++) {
                bigint.num[i] = (x + "").charAt(i);

            }
        }

        return bigint;

    }

    public static Integers Add(Integers a, Integers b) {
        Integers sum = new Integers();
        int carry = 0;
        for (int i = 0; i < 40; i++) {
            if (Integer.parseInt(a.num[i] + "".trim()) + Integer.parseInt(b.num[i] + "".trim()) + carry > 9) {
                int x = Integer.parseInt(a.num[i] + "") + Integer.parseInt(b.num[i] + "") + carry;
                carry = x /10 ;
               sum.num[i]= (( x%10 )+"").charAt(0);
                
            } else {
                sum.num[i]=((Integer.parseInt(a.num[i] + "") + Integer.parseInt(b.num[i] + "") + carry)+"").charAt(0);
            }
        }

        return sum;
    }

    
    
    
    
    
}
