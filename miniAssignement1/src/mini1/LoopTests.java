package mini1;
import static mini1.LoopTheLoopyLoopingLoopers.*;
public class LoopTests {
	public static void main (String[] args)
	{
		String test = "aabbccdd";
		String result = eliminateRuns(test);
		System.out.println(result);
		System.out.println(countIterations(10,1));
		System.out.println(countOccurrences("xyzx", "xyxyxyzxyzxyzxy", false));
		System.out.println(findMostFrequentCharacter("cabababcbabacc"));
		System.out.println(findSecondLargest("10 2 900 80"));
		System.out.println(isLucasSequence("1 2 4 5 8 13"));
		System.out.println(mergePreservingRuns("aaabbbccc","xxxyyyyzzzzz"));
		System.out.println(takeApartPreservingRuns("aabbabaabbab"));
		
	}
}
