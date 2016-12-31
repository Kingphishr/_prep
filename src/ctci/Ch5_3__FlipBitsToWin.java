package ctci;

/**
 * Created by LAViATHoR on 12/30/2016.
 *
 * Find largest number of ones that can be made by flipping a single bit
 */
public class Ch5_3__FlipBitsToWin {

    public static void main(String[] args){
        System.out.println(maxxableFilppable(1775));
    }

    private static int maxxableFilppable(int flippable){
        int max = 0;
        int currMax = 0;

        for(int i = 0; i <32; i++){
            if((flippable & (1 << i)) != 0){
                currMax++;
            }
            else{
                for(int j = i+1; j < 32; j++){
                    if((flippable & (1 << j)) != 0)
                        currMax++;
                    else
                        break;
                }

                if(currMax + 1 > max)
                    max = currMax + 1;

                currMax = 0;
            }
        }
        return max;
    }
}
