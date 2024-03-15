
public class LevelEasy {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        else{
            int xnew = x;
            int result = 0;
            do{
                result = result*10 + (xnew%10);
                xnew = xnew/10;
            } while(xnew > 0);
            if(result == x){
                return true;
            }
            else
                return false;
        }
    }
    public int romanToInt(String s) {
        int i = 1, v = 5, x = 10, l = 50, c = 100, d = 500, M = 1000;
        int result = 0;
        String[] splitString = s.split("");
        for (int j = splitString.length - 1; j >= 0; j--){

        }
    }
}
